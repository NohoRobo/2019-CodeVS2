package frc.robot.utilities;

import frc.robot.utilities.PID;
import com.revrobotics.CANEncoder;


public class DrivePID{
    PID drivePIDDistance;
    PID drivePIDAngle;

    double kPDistance;
    double kIDistance;
    double kDDistance;
    double acceptableRangeDistance;
    double maxErrorIDistance;

    double kPAngle;
    double kIAngle;
    double kDAngle;
    double acceptableRangeAngle;
    double maxErrorIAngle;

    double motorValueDistance;
    double motorValueAngle;

    double leftMotorValue;
    double rightMotorValue;

    CANEncoder encoderLeftFront;
    CANEncoder encoderLeftMiddle;
    CANEncoder encoderLeftBack;

    CANEncoder encoderRightFront;
    CANEncoder encoderRightMiddle;
    CANEncoder encoderRightBack;

    public DrivePID(CANEncoder encoderLeftFront, CANEncoder encoderLeftMiddle, CANEncoder encoderLeftBack,
    CANEncoder encoderRightFront, CANEncoder encoderRightMiddle, CANEncoder encoderRightBack,
    Double kPDistance, Double kIDistance, Double kDDistance, Double acceptableRangeDistance, Double maxErrorIDistance,
    Double kPAngle, Double kIAngle, Double kDAngle, Double acceptableRangeAngle, Double maxErrorIAngle){
        drivePIDDistance = new PID(kPDistance, kIDistance, kDDistance, acceptableRangeDistance, maxErrorIDistance, false);
        drivePIDAngle = new PID(kPAngle, kIAngle, kDAngle, acceptableRangeAngle, maxErrorIAngle, false);
    }

    private double getGoodEncoderValue(double encoder1, double encoder2, double encoder3){
        double average = (encoder1 + encoder2 + encoder3)/3.0;
        double encoder1Deviation = encoder1-average;
        double encoder2Deviation = encoder2-average;
        double encoder3Deviation = encoder3-average;
        if(encoder1Deviation>encoder2Deviation && encoder1Deviation>encoder3Deviation){
            return (encoder2+encoder3)/2.0;
        }
        if(encoder2Deviation>encoder1Deviation && encoder2Deviation>encoder3Deviation){
            return (encoder1+encoder3)/2.0;
        }
        return (encoder1+encoder2)/2.0;
    }

    public double getDistance(){
        return (getGoodEncoderValue(encoderLeftFront.getPosition(), encoderLeftMiddle.getPosition(), encoderLeftBack.getPosition()) + 
        getGoodEncoderValue(encoderRightFront.getPosition(), encoderRightMiddle.getPosition(), encoderRightBack.getPosition()))/2.0;
    }

    public double getAngle(){//make this into degrees somehow
        return (getGoodEncoderValue(encoderLeftFront.getPosition(), encoderLeftMiddle.getPosition(), encoderLeftBack.getPosition()) - 
        getGoodEncoderValue(encoderRightFront.getPosition(), encoderRightMiddle.getPosition(), encoderRightBack.getPosition()))/2.0;
    }

    public void updateMotorValues(){
        motorValueDistance = drivePIDDistance.calculatePIDValue(getDistance());
        motorValueAngle = drivePIDAngle.calculatePIDValue(getAngle());
        leftMotorValue = motorValueDistance + motorValueAngle;
        rightMotorValue = motorValueDistance - motorValueAngle;
    }

    public double getLeftMotorValue(){
        return leftMotorValue;
    }

    public double getRightMotorValue(){
        return rightMotorValue;
    }
}
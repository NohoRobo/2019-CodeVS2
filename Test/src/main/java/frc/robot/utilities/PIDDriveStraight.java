package frc.robot.utilities;

import com.revrobotics.CANEncoder;
import frc.robot.utilities.PIDDrive;

public class PIDDriveStraight extends PIDDrive{
    CANEncoder leftFrontCANEncoder;
    CANEncoder leftMiddleCANEncoder;
    CANEncoder leftBackCANEncoder;

    CANEncoder rightFrontCANEncoder;
    CANEncoder rightMiddleCANEncoder;
    CANEncoder rightBackCANEncoder;

    public PIDDriveStraight(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity, boolean reverseSensor,
    CANEncoder leftFrontCANEncoder, CANEncoder leftMiddleCANEncoder, CANEncoder leftBackCANEncoder,
    CANEncoder rightFrontCANEncoder, CANEncoder rightMiddleCANEncoder, CANEncoder rightBackCANEncoder){
        super(kP, kI, kD, minErrorI, maxErrorI, maxPowerI, acceptableError, acceptableVelocity, reverseSensor,
        leftFrontCANEncoder, leftMiddleCANEncoder, leftBackCANEncoder, rightFrontCANEncoder, rightMiddleCANEncoder, rightBackCANEncoder);
    }

    public double getSensorPosition(){
        return (super.getGoodCANEncoderValue(leftFrontCANEncoder.getPosition(), leftMiddleCANEncoder.getPosition(), leftBackCANEncoder.getPosition()) +
        super.getGoodCANEncoderValue(rightFrontCANEncoder.getPosition(), rightMiddleCANEncoder.getPosition(), rightBackCANEncoder.getPosition()))/2;
    }
    public double getSensorVelocity(){
        return (super.getGoodCANEncoderValue(leftFrontCANEncoder.getVelocity(), leftMiddleCANEncoder.getVelocity(), leftBackCANEncoder.getVelocity()) +
        super.getGoodCANEncoderValue(rightFrontCANEncoder.getVelocity(), rightMiddleCANEncoder.getVelocity(), rightBackCANEncoder.getVelocity()))/2;
    }
}
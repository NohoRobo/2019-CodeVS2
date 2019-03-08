package frc.robot.utilities;

import com.revrobotics.CANEncoder;

import frc.robot.utilities.PID;

public abstract class PIDDrive extends PID{
    CANEncoder leftFrontCANEncoder;
    CANEncoder leftMiddleCANEncoder;
    CANEncoder leftBackCANEncoder;

    CANEncoder rightFrontCANEncoder;
    CANEncoder rightMiddleCANEncoder;
    CANEncoder rightBackCANEncoder;

    public PIDDrive(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity, boolean reverseSensor,
    CANEncoder leftFrontCANEncoder, CANEncoder leftMiddleCANEncoder, CANEncoder leftBackCANEncoder,
    CANEncoder rightFrontCANEncoder, CANEncoder rightMiddleCANEncoder, CANEncoder rightBackCANEncoder){
        super(kP, kI, kD, minErrorI, maxErrorI, maxPowerI, acceptableError, acceptableVelocity, reverseSensor);
        this.leftFrontCANEncoder = leftFrontCANEncoder;
        this.leftMiddleCANEncoder = leftMiddleCANEncoder;
        this.leftBackCANEncoder = leftBackCANEncoder;

        this.rightFrontCANEncoder = rightFrontCANEncoder;
        this.rightMiddleCANEncoder = rightMiddleCANEncoder;
        this.rightBackCANEncoder = rightBackCANEncoder;
    }
    protected double getGoodCANEncoderValue(double CANEncoder1, double CANEncoder2, double CANEncoder3){
        double average = (CANEncoder1 + CANEncoder2 + CANEncoder3)/3.0;
        double CANEncoder1Deviation = CANEncoder1-average;
        double CANEncoder2Deviation = CANEncoder2-average;
        double CANEncoder3Deviation = CANEncoder3-average;
        if(CANEncoder1Deviation>CANEncoder2Deviation && CANEncoder1Deviation>CANEncoder3Deviation){
            return (CANEncoder2+CANEncoder3)/2.0;
        }
        if(CANEncoder2Deviation>CANEncoder1Deviation && CANEncoder2Deviation>CANEncoder3Deviation){
            return (CANEncoder1+CANEncoder3)/2.0;
        }
        return (CANEncoder1+CANEncoder2)/2.0;
    }
    public abstract double getSensorPosition();
    public abstract double getSensorVelocity();
}

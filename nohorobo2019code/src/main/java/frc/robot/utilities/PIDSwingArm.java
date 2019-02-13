package frc.robot.utilities;

import com.revrobotics.CANEncoder;

import frc.robot.utilities.PIDFeedForward;;

public class PIDSwingArm extends PIDFeedForward{

    public CANEncoder armEncoder;

    public PIDSwingArm(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity,
    boolean reverseSensor, CANEncoder armEncoder){
        super(kP, kI, kD, minErrorI, maxErrorI, maxPowerI, acceptableError, acceptableVelocity, reverseSensor);
        this.armEncoder = armEncoder;
    }
    protected double calculateFeedForwardTerm(){
        return 1/*some code that finds drive acceleration, and combines it with arm angle*/;
    }
    protected double getSensorPosition(){
        return armEncoder.getPosition();
    }
    public double getSensorVelocity(){
        return armEncoder.getVelocity();
    }
}
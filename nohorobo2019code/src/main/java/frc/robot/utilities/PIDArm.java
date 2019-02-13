package frc.robot.utilities;

import edu.wpi.first.wpilibj.Encoder;

import frc.robot.utilities.PIDFeedForward;

public class PIDArm extends PIDFeedForward{

    public Encoder armEncoder;

    public PIDArm(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity,
    boolean reverseSensor, Encoder armEncoder){
        super(kP, kI, kD, minErrorI, maxErrorI, maxPowerI, acceptableError, acceptableVelocity, reverseSensor);
        this.armEncoder = armEncoder;
    }
    protected double calculateFeedForwardTerm(){
        return 1/*some code that finds drive acceleration, and combines it with arm angle*/;
    }
    protected double getSensorPosition(){
        return armEncoder.getDistance();
    }
    protected double getSensorVelocity(){
        return armEncoder.getRate();
    }
}
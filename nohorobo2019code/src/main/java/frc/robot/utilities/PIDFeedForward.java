package frc.robot.utilities;

import frc.robot.utilities.PID;

public abstract class PIDFeedForward extends PID{

    public PIDFeedForward(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity, boolean reverseSensor){
        super(kP, kI, kD, minErrorI, maxErrorI, maxPowerI, acceptableError, acceptableVelocity, reverseSensor);
    }
    protected abstract double calculateFeedForwardTerm();
    protected abstract double getSensorPosition();
    protected abstract double getSensorVelocity();
    public double getMotorPower(){
        return this.calculatePIDValue() + this.calculateFeedForwardTerm();
    }
}
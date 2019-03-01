package frc.robot.utilities;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.utilities.PIDFeedForward;

public class PIDArm extends PIDFeedForward{

    public TalonSRX armEncoder;

    public PIDArm(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity,
    boolean reverseSensor, TalonSRX armEncoder){
        super(kP, kI, kD, minErrorI, maxErrorI, maxPowerI, acceptableError, acceptableVelocity, reverseSensor);
        this.armEncoder = armEncoder;
    }
    protected double calculateFeedForwardTerm(){
        return 0/*some code that finds drive acceleration, and combines it with arm angle*/;
    }
    protected double getSensorPosition(){
        return armEncoder.getSelectedSensorPosition();
    }
    protected double getSensorVelocity(){
        return armEncoder.getSelectedSensorVelocity();
    }
}
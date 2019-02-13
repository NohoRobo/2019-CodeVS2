package frc.robot.utilities;

import com.revrobotics.CANEncoder;

import frc.robot.utilities.PID;

public class PIDLift extends PID{

    public CANEncoder liftEncoder;

    public PIDLift(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity,
    boolean reverseSensor, CANEncoder liftEncoder){
        super(kP, kI, kD, minErrorI, maxErrorI, maxPowerI, acceptableError, acceptableVelocity, reverseSensor);
        this.liftEncoder = liftEncoder;
    }
    protected double getSensorPosition(){
        return liftEncoder.getPosition();
    }
    public double getSensorVelocity(){
        return liftEncoder.getVelocity();
    }
}
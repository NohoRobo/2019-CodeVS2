package frc.robot.utilities;

import edu.wpi.first.wpilibj.Encoder;

import frc.robot.utilities.PID;

public class PIDLift extends PID{

    public Encoder liftEncoder;

    public PIDLift(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity,
    boolean reverseSensor, Encoder liftEncoder){
        super(kP, kI, kD, minErrorI, maxErrorI, maxPowerI, acceptableError, acceptableVelocity, reverseSensor);
        this.liftEncoder = liftEncoder;
    }
    public double getSensorPosition(){
        return liftEncoder.getDistance();
    }
    public double getSensorVelocity(){
        return liftEncoder.getRate();
    }
}
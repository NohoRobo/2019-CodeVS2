package frc.robot.utilities;
import frc.robot.utilities.Utilities;;

public abstract class PID {
	public double kP;
	public double kI;
	public double kD;
	public double minErrorI;
    public double maxErrorI;
    public double maxPowerI;
    public double acceptableError;
    public double acceptableVelocity;
    public boolean reverseSensor;
    
	private double error;
	private double desiredValue;
	private double pVal;
	private double iVal;
	private double dVal;
    private double sensorPosition;
    private double sensorVelocity;
	
    public PID(double kP, double kI, double kD, double minErrorI, 
    double maxErrorI, double maxPowerI, double acceptableError, double acceptableVelocity, boolean reverseSensor){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.minErrorI = minErrorI;
        this.maxErrorI = maxErrorI;
        this.maxPowerI = maxPowerI;
        this.acceptableError = acceptableError;
        this.acceptableVelocity = acceptableVelocity;
        this.reverseSensor = reverseSensor;
        this.error = 0;
        this.desiredValue = 0;
        this.pVal = 0;
        this.iVal = 0;
        this.dVal = 0;
    }

    //returns motorValue for given PID loop struct
    double calculatePIDValue(){
        sensorPosition = getSensorPosition();
        sensorVelocity = getSensorVelocity();
        //calculate error
        this.error = this.desiredValue-(this.reverseSensor?-1:1)*sensorPosition;

        //set P value
        this.pVal = this.error;

        //add newest value to I
        if(Math.abs(error)>=minErrorI && Math.abs(error)<=maxErrorI){
            this.iVal += this.error;
        }
        else if(Math.abs(this.error)<=this.minErrorI){
            this.iVal = 0;
        }

        //calculate derivative
        this.dVal = -(this.reverseSensor?-1:1)*sensorVelocity;

        //return motor Value
        return this.pVal*this.kP + Utilities.limit(this.iVal*this.kI,-maxPowerI , maxPowerI) + this.dVal*this.kD;
    }

    public boolean isFinished(){
        if(Math.abs(error)<acceptableVelocity && Math.abs(getSensorVelocity())<acceptableVelocity){
            return true;
        }
        return false;
    }

    public void incrementDesiredValue(double value){this.desiredValue += value;}
    public void setDesiredValue(double value){this.desiredValue = value;}
    public double getDesiredValue(){return this.desiredValue;}

       
    
    protected abstract double getSensorPosition();
    protected abstract double getSensorVelocity();
    public double getMotorPower(){
        return this.calculatePIDValue();
        
    }
}
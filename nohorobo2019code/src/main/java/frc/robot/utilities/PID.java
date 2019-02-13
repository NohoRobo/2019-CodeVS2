package frc.robot.utilities;

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
    private boolean enabled;
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
        if(this.enabled){
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
            this.dVal = (this.reverseSensor?-1:1)*sensorVelocity;

            //avoid stupid errors when changing setpoint
            if(Math.abs(this.dVal)>1000){
                this.dVal = 0;
            }

            //return motor Value
            return this.pVal*this.kP + limit(this.iVal*this.kI,-maxPowerI , maxPowerI) + this.dVal;
        }
        else{
            this.error = 0;
            this.pVal = 0;
            this.iVal = 0;
            this.dVal = 0;
            return 0;
        }
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

    public void enable(){enabled = true;}
    public void disable(){enabled = false;}

    private double limit(double value, double floor, double ceiling){
        if(value<=floor)return floor;
        if(value>=ceiling)return ceiling;
        return value;
    }    
    
    protected abstract double getSensorPosition();
    protected abstract double getSensorVelocity();
    public double getMotorPower(){
        return this.calculatePIDValue();
    }
}
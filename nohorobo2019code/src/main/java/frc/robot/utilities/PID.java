package frc.robot.utilities;

public class PID {
    private static final int OLD_ERROR_ARR_LENGTH = 100;
    private static final int OLD_DERIVATIVES_LENGTH = 3;
	double kP;
	double kI;
	double kD;
	double minErrorI;
    double maxErrorI;
    double maxPowerI;
	boolean reverseSensor;
	double error;
	double desiredValue;
	double pVal;
	double iVal;
	double dVal;
    double oldSensorValue;
    boolean enabled;
	
    public PID(double kP, double kI, double kD, double minErrorI, 
        double maxErrorI, double maxPowerI, boolean reverseSensor){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.minErrorI = minErrorI;
        this.maxErrorI = maxErrorI;
        this.maxPowerI = maxPowerI;
        this.reverseSensor = reverseSensor;
        this.error = 0;
        this.desiredValue = 0;
        this.pVal = 0;
        this.iVal = 0;
        this.dVal = 0;
    }

    //returns motorValue for given PID loop struct
    double calculatePIDValue(double sensorValue){
        if(this.enabled){
            //calculate delta time since last call
            //calculate error
            this.error = this.desiredValue-(this.reverseSensor?-1:1)*sensorValue;
            //set P value
            this.pVal = this.error;

            //add newest value to I
            this.iVal += this.error;

            //calculate derivative
            this.dVal = this.oldSensorValue-(this.reverseSensor?-1:1)*sensorValue;
            //avoid stupid errors when changing setpoint
            if(Math.abs(this.dVal)>1000){
                this.dVal = 0;
            }

            //set oldSensorValue
            this.oldSensorValue = (this.reverseSensor?-1:1)*sensorValue;

            //set I to 0 if within acceptable range
            if(Math.abs(this.error)<this.minErrorI){
                this.oldErrorArr = new int[OLD_ERROR_ARR_LENGTH];
                this.iVal = 0;
            }

            //return motor Value
            return this.pVal*this.kP + limit(this.iVal*this.kI,-maxPowerI , maxPowerI) + this.dVal;
        }
        else{
            this.oldErrorArr = new int[OLD_ERROR_ARR_LENGTH];
            this.iVal = 0;
            this.oldDerivatives = new int[OLD_DERIVATIVES_LENGTH];
            this.dVal = 0;
            return 0;
        }
    }

    public boolean isFinished(double velocity){
        if(Math.abs(error)<this.minErrorI && checkVelocityThreshold(0.1)){
            return true;
        }
        return false;
    }

    public void setDesiredValue(double value){
        this.desiredValue = value;
    }

    public double getDesiredValue(){
        return this.desiredValue;
    }

    double limit(double value, double floor, double ceiling){
        if(value<=floor)return floor;
        if(value>=ceiling)return ceiling;
        return value;
    }

	
}
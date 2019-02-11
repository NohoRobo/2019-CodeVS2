package frc.robot.utilities;

import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.Timer;

public class PID {
    private static final int OLD_ERROR_ARR_LENGTH = 100;
    private static final int OLD_DERIVATIVES_LENGTH = 3;
	double kP;
	double kI;
	double kD;
	double acceptableRange;
	double maxErrorI;
	CANEncoder encoder;
	boolean reverseSensor;
	double error;
	double desiredValue;
	double pVal;
	double iVal;
	double dVal;
	double dAverage;
	int[] oldErrorArr;
	int[] oldDerivatives;
	int oldTime;
	double oldSensorValue;
	double timeChange;
	int writeCounterI;
	int writeCounterD;
    boolean enabled;
    Timer timer;
	
    PID(double kP, double kI, double kD, double acceptableRange, 
        double maxErrorI, CANEncoder encoder, boolean reverseSensor){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.acceptableRange = acceptableRange;
        this.maxErrorI = maxErrorI;
        this.encoder = encoder;
        this.reverseSensor = reverseSensor;
        this.error = 0;
        this.desiredValue =	encoder.getPosition();
        this.pVal = 0;
        this.iVal = 0;
        this.dVal = 0;
        this.dAverage = 0;
        this.writeCounterI = 0;
        this.oldTime = 0;
        this.oldSensorValue = 0;
        this.timeChange = 0;
        this.writeCounterD = 0;
        oldErrorArr = new int[OLD_ERROR_ARR_LENGTH];
        oldDerivatives = new int[OLD_DERIVATIVES_LENGTH];
        timer = new Timer();
        timer.start(0);
    }

    /*PID(double kP, double kI, double kD, double acceptableRange, double maxErrorI, CANEncoder encoder){
        PID(kP, kI, kD, acceptableRange, maxErrorI, encoder, false);
    }*/

    //returns motorValue for given PID loop struct
    double calculatePIDValue(double manualSensorValue){
        if(this.enabled){
            //calculate delta time since last call
            this.timeChange = nSysTime-this.oldTime;
            this.oldTime = nSysTime;
            if(this.timeChange>100||this.timeChange == 0){
                this.timeChange = 50;
            }
            //calculate error
            this.error = this.desiredValue-(this.reverseSensor?-1:1)*manualSensorValue;
            //set P value
            this.pVal = this.error;

            //subtract oldest value from I
            this.iVal -= this.oldErrorArr[this.writeCounterI];

            //add newest value to I
            if(Math.abs(this.error)<this.maxErrorI){
                this.iVal += this.error*this.timeChange;
                this.oldErrorArr[this.writeCounterI] = (int) (this.error*this.timeChange);
            }

            //calculate derivative
            this.dVal = this.oldSensorValue-(this.reverseSensor?-1:1)*manualSensorValue;
            //avoid stupid errors when changing setpoint
            if(Math.abs(this.dVal)>1000){
                this.dVal = 0;
            }
            this.dAverage+=this.dVal;
            this.dAverage-=this.oldDerivatives[this.writeCounterD];
            this.oldDerivatives[this.writeCounterD] = (int) this.dVal;

            //set oldSensorValue
            this.oldSensorValue = (this.reverseSensor?-1:1)*manualSensorValue;

            //increment writeCounterD in circular array
            this.writeCounterD++;
            this.writeCounterD %= (this.oldDerivatives.length/this.oldDerivatives[0].length);

            //set I to 0 if within acceptable range
            if(Math.abs(this.error)<this.acceptableRange){
                resetArray(this.oldErrorArr);
                this.iVal = 0;
            }

            //set old error in circular array
            this.writeCounterI++;
            this.writeCounterI %= (this.oldErrorArr.length/this.oldErrorArr[0].length);

            //return motor Value
            return this.pVal*this.kP +
            limit(this.iVal*this.kI,-50,50) +
            this.dAverage*this.kD/this.oldDerivatives.length/this.oldDerivatives[0]/(double)this.timeChange;
        }
        else{
            resetArray(this.oldErrorArr);
            this.iVal = 0;
            resetArray(this.oldDerivatives);
            this.dVal = 0;
            return 0;
        }
    }

    double limit(double value, double floor, double ceiling){
        if(value<=floor){
            return floor;
        }
        if(value>=ceiling){
            return ceiling;
        }
        return value;
    }

    double calculatePIDValue(){
        return calculatePIDValue(this.encoder.getPosition());
    }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utilities.PIDSubSystem;
import frc.robot.utilities.PID;
import frc.robot.utilities.PIDLift;

import frc.robot.utilities.Utilities;

import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftPIDSet;
import frc.robot.commands.LiftStop;
import frc.robot.commands.OperatorLift;

public class Lift extends Subsystem implements PIDSubSystem {
  public TalonSRX liftTalon1 = new TalonSRX(RobotMap.liftRight775);
  public TalonSRX liftTalon2 = new TalonSRX(RobotMap.liftLeft775);
  Encoder liftEncoder = new Encoder(RobotMap.liftEncoderA, RobotMap.liftEncoderB, false, Encoder.EncodingType.k4X);
  public double PIDSpeed = 0;
  public PID pid = new PIDLift(0.0005, 0, 0, 0, 0, 0, 0, 0, false, liftEncoder);
  
  public boolean ballHeld = false;

  public final double LIFT_MAX_TURNING = 0;
  public final double LIFT_MIN_TURNING = 0;
  public final double LIFT_GROUND = 0;
  public final double LIFT_PANEL_3 = 0;
  public final double LIFT_PANEL_2 = 0;
  public final double LIFT_PANEL_1 = LIFT_GROUND;
  public final double LIFT_BALL_3 = 0;
  public final double LIFT_BALL_2 = 0;
  public final double LIFT_BALL_1 = 0;
  public final double LIFT_BALL_SHIP = 0;


  @Override
  public void initDefaultCommand() {



    //setDefaultCommand(new TestingSparkMaxControllers(0));
    //setDefaultCommand(new OperatorLift());
    setDefaultCommand(new LiftPIDSet(13000));
    //setDefaultCommand(new TestingSparkMaxControllers(Robot.m_oi.getDriverLeftY()));
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  /**
 * @return the liftTalon1
 */

public void setTalon1Speed(double speed){
    liftTalon1.set(ControlMode.PercentOutput, -speed);
  }
public void setTalon2Speed(double speed){
   liftTalon2.set(ControlMode.PercentOutput, -speed);
}

  public double getTalonSpeed(){
    return liftTalon1.getMotorOutputVoltage();
  }
public double getDesiredValuePID(){
  return pid.getDesiredValue();
}
public void setLiftMotorsPID(){
  this.PIDSpeed = Utilities.limit(this.pid.getMotorPower(),-.3,.3);
  this.setTalon1Speed(this.PIDSpeed);
  this.setTalon1Speed(this.PIDSpeed);
}
public void setDesiredValuePID(double value){
  pid.setDesiredValue(value);
}
public boolean isFinishedPID(){
  return pid.isFinished();
}
public double getLiftTalonEncoder(){
  //liftEncoder.get();
  return liftEncoder.get();
}
public void pidSetMotors(){
  double power = Utilities.limit(pid.getMotorPower(),-.3,.3);
  setTalon1Speed(power);
  setTalon2Speed(power);
}
/*public void setTalonEncoder(double position){

  //double position = degrees*1000;

  while (liftEncoder.get() < position){
    liftTalon1.set(ControlMode.PercentOutput, 1);
    liftTalon2.set(ControlMode.PercentOutput, 1);
  }

}*/



}

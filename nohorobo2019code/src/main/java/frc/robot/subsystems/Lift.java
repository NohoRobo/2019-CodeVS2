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

import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TestingSparkMaxControllers;



/**
 * Add your docs here.
 */
public class Lift extends Subsystem implements PIDSubSystem {
  // Pu1t methods for controlling this subsystem 
  // here. Call these from Commands.
  public TalonSRX liftTalon1 = new TalonSRX(RobotMap.liftRight775);
  public TalonSRX liftTalon2 = new TalonSRX(RobotMap.liftLeft775);
  Encoder liftEncoder = new Encoder(RobotMap.liftEncoderA, RobotMap.liftEncoderB);

  PID pid = new PIDLift(0.1, 0.1, 0.1, 1.0, 1.0, 0.2, 5.0, 0.1, false, liftEncoder);

  public final double LIFT_MAX = 0;
  public final double LIFT_MIN = 0;
  public final double LIFT_PANEL_3 = 0;
  public final double LIFT_PANEL_2 = 0;
  public final double LIFT_PANEL_1 = 0;
  public final double LIFT_BALL_3 = 0;
  public final double LIFT_BALL_2 = 0;
  public final double LIFT_BALL_1 = 0;
  public final double LIFT_GROUND = 0;
  public final double LIFT_SHIP = 0;


  @Override
  public void initDefaultCommand() {


    //setDefaultCommand(new TestingSparkMaxControllers(0));


    //setDefaultCommand(new TestingSparkMaxControllers(Robot.m_oi.getDriverLeftY()));
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  /**
 * @return the liftTalon1
 */

public void setTalon1Speed(double speed){
    liftTalon1.set(ControlMode.PercentOutput, speed);
  }
public void setTalon2Speed(double speed){
   liftTalon2.set(ControlMode.PercentOutput, speed);
}
public void enablePID(){
  pid.enable();
}
public void disablePID(){
  pid.disable();
}
public double getDesiredValuePID(){
  return pid.getDesiredValue();
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

/*public void setTalonEncoder(double position){

  //double position = degrees*1000;

  while (liftEncoder.get() < position){
    liftTalon1.set(ControlMode.PercentOutput, 1);
    liftTalon2.set(ControlMode.PercentOutput, 1);
  }

}*/



}

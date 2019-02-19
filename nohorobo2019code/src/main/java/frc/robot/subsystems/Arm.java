/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utilities.PIDSubSystem;
import frc.robot.utilities.PID;
import frc.robot.utilities.PIDArm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem implements PIDSubSystem {

  TalonSRX Arm = new TalonSRX(RobotMap.swingArm775);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Encoder ArmEncoder = new Encoder(RobotMap.swingArmEncoderA, RobotMap.swingArmEncoderB);

  public PID pid = new PIDArm(0, 0, 0, 0, 0, 0, 0, 0, false, ArmEncoder);

  public final double ARM_LEFT = 0;
  public final double ARM_CENTER = 0;
  public final double ARM_RIGHT = 0;



  @Override
  public void initDefaultCommand() {
    this.setMotorSpeed(0);
  }

  public void setMotorSpeed(double speed){
    Arm.set(ControlMode.PercentOutput,speed);
  }

  public double getArmTalonEncoder(){
    return ArmEncoder.get();
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
}

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

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem implements PIDSubSystem {

  //VictorSP Arm = new VictorSP(RobotMap.swingArm775);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //Talon ArmTalon = new Talon(RobotMap.swingArm775);
  //Encoder ArmEncoder1 = new Encoder(RobotMap.swingArmEncoderA, RobotMap.swingArmEncoderB);

  //PID pid = new PIDArm(0.1, 0.1, 0.1, 1.0, 1.0, 0.2, 5.0, 0.1, false, ArmEncoder1);

  @Override
  public void initDefaultCommand() {
    this.setMotorSpeed(0);
  }

  public void setMotorSpeed(double speed){
    //Arm.set(speed);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import frc.robot.utilities.PIDSubSystem;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem implements PIDSubSystem {

  VictorSP Arm = new VictorSP(RobotMap.swingArm775);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Talon ArmTalon = new Talon(RobotMap.swingArm775);
  Encoder ArmEncoder = new Encoder(RobotMap.swingArmEncoderA, RobotMap.swingArmEncoderB);

  @Override
  public void initDefaultCommand() {

    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }


  public void SetArmMotors(double speed){
    Arm.set(speed);
  }
  


}

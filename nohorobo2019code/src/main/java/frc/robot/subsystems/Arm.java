/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
//import robot.RobotMap;//this doesnt work

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {


  
  private static final int ARM_LEFT = 0;
  private static final int ARM_RIGHT = 0;
  private static final int ARM_FORWARD = 0;

  private int ARM_FRONT_POSITION;
  private int ARM_SIDE_POSITION;
  private int ARM_BACK_POSITION;

  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setArmMotor(double power){
    
  }

  public int getArmPosition(){
    return 0;
  } 
}

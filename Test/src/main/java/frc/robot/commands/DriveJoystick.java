/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveJoystick extends Command {
  double speed;
  public DriveJoystick() {

    
    
    requires(Robot.drive);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  
   

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /*double straightSpeed = Robot.drive.checkStickDeadzone(
      Robot.oi.driverController.getRawAxis(3)-Robot.oi.driverController.getRawAxis(2));
    double turningSpeed = Robot.drive.checkTriggerDeadzone(Robot.oi.driverController.getRawAxis(0));
    
    Robot.drive.setDriveStraight(Math.pow(straightSpeed, 3.0)/2); 
    Robot.drive.setDriveTurning(Math.pow(turningSpeed, 3.0)/3);*/

  
    
//left deadzone
    if ((Robot.oi.driverController.getRawAxis(1)) <= 0.05){

      Robot.drive.setDriveLeft(0);
      
    }
//left drive joystick
    else if ((Robot.oi.driverController.getRawAxis(1)) > 0.05){

      Robot.drive.setDriveLeft(Robot.oi.driverController.getRawAxis(1));

    }
//right deadzone
    if ((Robot.oi.driverController.getRawAxis(5)) <= 0.05){

      Robot.drive.setDriveRight(0);
      
    }
//right drive joystick
    else if ((Robot.oi.driverController.getRawAxis(5)) > 0.05){

      Robot.drive.setDriveRight(Robot.oi.driverController.getRawAxis(5));

    }


  }
  @Override
  protected boolean isFinished() {
    return false;
  }
  @Override
  protected void end() {}
  @Override
  protected void interrupted() {}
}

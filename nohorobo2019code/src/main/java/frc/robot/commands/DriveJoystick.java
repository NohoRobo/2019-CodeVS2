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
  public DriveJoystick(double speed) {

    this.speed = speed;
    
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

    //Robot.drive.setDriveStraight(this.speed);

    if (Robot.m_oi.driverController.getRawAxis(3) > Robot.m_oi.driverController.getRawAxis(2)){

      Robot.drive.setDriveStraight(Robot.m_oi.driverController.getRawAxis(3));
    }
    else if (Robot.m_oi.driverController.getRawAxis(2) > Robot.m_oi.driverController.getRawAxis(3)){

      Robot.drive.setDriveStraight(-1*Robot.m_oi.driverController.getRawAxis(2));
    }
    else{
      Robot.drive.setDriveStraight(0);
    }
    if ((Robot.m_oi.driverController.getRawAxis(3) < Robot.m_oi.STICK_DEADZONE)&&(Robot.m_oi.driverController.getRawAxis(2) < Robot.m_oi.STICK_DEADZONE)&&(Robot.m_oi.getDriverLeftX() == 0)){
      Robot.drive.setDriveStraight(0);
    }
    Robot.drive.setDriveTurning(Robot.m_oi.getDriverLeftX());
    







  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

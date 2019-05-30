/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.security.KeyStore.TrustedCertificateEntry;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.utilities.Utilities;


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
    /*
    if (Math.abs(Robot.oi.driverController.getRawAxis(1)) <= 0.15){
      Robot.drive.setDriveRight(0);
    }
    else if (Math.abs(Robot.oi.driverController.getRawAxis(1)) > 0.15){
      Robot.drive.setDriveRight(-1*(Robot.drive.getDirection())*Robot.oi.driverController.getRawAxis(1)/3);
    }
    if (Math.abs(Robot.oi.driverController.getRawAxis(5)) <= 0.15){
      Robot.drive.setDriveLeft(0);
  }

    else if (Math.abs(Robot.oi.driverController.getRawAxis(5)) > 0.15){
      Robot.drive.setDriveLeft(-1*(Robot.drive.getDirection())*Robot.oi.driverController.getRawAxis(5)/3);
    }
    */

  /*if(Math.abs(Robot.oi.driverController.getRawAxis(1)) > .15 || Math.abs(Robot.oi.driverController.getRawAxis(4)) > .15){
        Robot.drive.setDriveLeft(((Math.pow(Utilities.limit(-1*Robot.oi.driverController.getRawAxis(1)-(Robot.oi.driverController.getRawAxis(4)/3), -1, 1),3)+(Utilities.limit(-1*Robot.oi.driverController.getRawAxis(1)-(Robot.oi.driverController.getRawAxis(4)), -1, 1)))));
        Robot.drive.setDriveRight(((Math.pow(Utilities.limit(-1*Robot.oi.driverController.getRawAxis(1)+(Robot.oi.driverController.getRawAxis(4)/3), -1, 1),3)+(Utilities.limit(-1*Robot.oi.driverController.getRawAxis(1)+(Robot.oi.driverController.getRawAxis(4)), -1, 1)))));
        }
    else{
      Robot.drive.setDriveLeft(0);
      Robot.drive.setDriveRight(0);
    }*/
    if(Math.abs(Robot.oi.driverController.getRawAxis(1)) > .15 || Math.abs(Robot.oi.driverController.getRawAxis(5)) > .15){
      Robot.drive.setDriveLeft(Robot.oi.driverController.getRawAxis(5)*-1);
      Robot.drive.setDriveRight(Robot.oi.driverController.getRawAxis(1)*-1);
    }
    else{
      Robot.drive.setDriveLeft(0);
      Robot.drive.setDriveRight(0);
    }



  }

  

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /*double straightSpeed = Robot.drive.checkStickDeadzone(
      Robot.oi.driverController.getRawAxis(3)-Robot.oi.driverController.getRawAxis(2));
    double turningSpeed = Robot.drive.checkTriggerDeadzone(Robot.oi.driverController.getRawAxis(0));
    
    Robot.drive.setDriveStraight(Math.pow(straightSpeed, 3.0)/2); 
    Robot.drive.setDriveTurning(Math.pow(turningSpeed, 3.0)/3);*/    
//left deadzoneer
  }
  @Override
  protected boolean isFinished() {
    return true;
  }
  @Override
  protected void end() {}
  @Override
  protected void interrupted() {}
}

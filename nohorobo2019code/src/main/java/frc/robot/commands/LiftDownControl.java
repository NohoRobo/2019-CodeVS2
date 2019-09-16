/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI;

public class LiftDownControl extends Command {
  public LiftDownControl() {

    requires(Robot.lift);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    /*if ((Robot.oi.driverButtonLeftBumper.get())){
      Robot.lift.setTalon1Speed(0.7);
      Robot.lift.setTalon2Speed(0.7);
    }
    else if ((Robot.oi.driverController.getRawAxis(5)) > 0.1){
      Robot.lift.setTalon1Speed(-0.5);
      Robot.lift.setTalon2Speed(-0.5);
    }
    else{*/
      Robot.lift.setTalon1Speed(0);
      Robot.lift.setTalon2Speed(0);
    //}

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
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

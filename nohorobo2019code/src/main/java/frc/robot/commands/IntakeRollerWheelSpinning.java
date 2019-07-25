/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;



/*void bith (int speed, int direction){
  movemotor(speed*direction);
}




button1.whenpressed(bith(1, -1));
button2.whenpressed(bith(1, 1));*/






public class IntakeRollerWheelSpinning extends Command {
  //public float rollerSpeed = 0;
  double speed;
  public IntakeRollerWheelSpinning(double speed) {
    super("IntakeRollerWheelSpinning");
    this.speed = speed;
    requires(Robot.intake);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.intake.setRollerMotors(this.speed);
  }
  

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    


    // solenoid in and button pressed
    
    Robot.intake.setRollerMotors(this.speed);
    


    //button1.whenpressed(intakewheelspinning(1);
    //button2.whenpressed(intakewheelspinning(-1);
    //intake.SetRollerMotors();

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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

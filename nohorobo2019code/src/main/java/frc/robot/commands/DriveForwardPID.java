package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveForwardPID extends Command {

    double distance;

    public DriveForwardPID(double distance) {
    // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	Robot.drive.pidDriveStraight.incrementDesiredValue(distance);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.drive.setDriveMotorsPID();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.drive.pidDriveStraight.isFinished();
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

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import java.util.concurrent.TimeUnit;

public class GroupAuton extends CommandGroup {

  //left side auton (probably not going to use)
  public GroupAuton(boolean onLeftSideOfField) {
    addSequential(new SetSideOfFieldIsLeft(onLeftSideOfField));
    //go forward while setting lift/arm position after specified degrees
    addParallel(new DriveForwardPID(10));
    while ((2 > (Robot.drive.getDriveLF())) && ((Robot.drive.getDriveLF()) > 0)) {
      try {
        TimeUnit.MILLISECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    //addSequential(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_1, Robot.arm.ARM_RIGHT));
    if ((Robot.drive.getDriveLF()) >= 10){
      addSequential(new IntakeRollerSolenoidOut());

    }









 




    //addSequential();
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}

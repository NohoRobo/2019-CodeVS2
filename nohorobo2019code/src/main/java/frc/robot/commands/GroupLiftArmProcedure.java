/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class GroupLiftArmProcedure extends CommandGroup {
  /**
   * Add your docs here.
   */

   double liftpos;
   double armpos;
  public GroupLiftArmProcedure(double liftpos, double armpos) {

    requires(Robot.lift);
    requires(Robot.arm);
//start
if (Robot.intake.BallHeld()){
  if(liftpos == Robot.lift.LIFT_PANEL_1){
    liftpos = Robot.lift.LIFT_BALL_1;
  }
  else if(liftpos == Robot.lift.LIFT_PANEL_2){
    liftpos = Robot.lift.LIFT_BALL_2;
  }
  else if(liftpos == Robot.lift.LIFT_PANEL_3){
    liftpos = Robot.lift.LIFT_BALL_3;
  }
}

    if ((Robot.arm.pid.getDesiredValue()) != armpos){
      if (!((Robot.lift.getLiftTalonEncoder() < Robot.lift.LIFT_MAX)&&(Robot.lift.getLiftTalonEncoder() > Robot.lift.LIFT_MIN))){
        if (Math.abs(Robot.lift.getLiftTalonEncoder()-Robot.lift.LIFT_MIN) < Math.abs(Robot.lift.getLiftTalonEncoder()-Robot.lift.LIFT_MAX)){
          addSequential(new LiftSetPosition(Robot.lift.LIFT_MIN));
        }
        else{
          addSequential(new LiftSetPosition(Robot.lift.LIFT_MAX));
        }
      }
      if (!((liftpos < Robot.lift.LIFT_MAX) && (liftpos > Robot.lift.LIFT_MIN))){
        addParallel(new LiftSetPosition(Math.min(Math.abs(liftpos-Robot.lift.LIFT_MIN), Math.abs(liftpos-Robot.lift.LIFT_MAX))));
        addSequential(new ArmSetPosition(armpos));
        addSequential(new LiftSetPosition(liftpos));
      }
      else{
        addParallel(new ArmSetPosition(armpos));
        addSequential(new LiftSetPosition(liftpos));
      }
    }
    else{
      addSequential(new LiftSetPosition(liftpos));
    }

    /*if (Robot.intake.BallHeld()){
      liftp
    }*/

  
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

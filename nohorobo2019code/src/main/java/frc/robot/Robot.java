/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
 
public class Robot extends TimedRobot {
  public static Arm arm =  new Arm(); 
  public static Drive drive = new Drive();
  public static Intake intake = new Intake();
  public static Lift lift = new Lift();
  public static OI oi;

  public static boolean onLeftSideOfField = true;

  Command autonomousCommand;
  SendableChooser<Command> chooser = new SendableChooser<>();

 /**
 * This function is run when the robot is first started up and should be
 * used for any initialization code.
 */
 @Override
  public void robotInit() {
    oi = new OI();
    chooser.setDefaultOption("No Auton Left", new SetSideOfFieldIsLeft(true));
    chooser.setDefaultOption("No Auton Right", new SetSideOfFieldIsLeft(false));
    chooser.addOption("Left Side", new GroupAuton(true));
    chooser.addOption("Right side", new GroupAuton(false));
    SmartDashboard.putData("Field Side", chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    autonomousCommand = chooser.getSelected();
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */
    // schedule the autonomous command (example)
    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (autonomousCommand != null) {
          autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    SmartDashboard.putNumber("RightFrontEncoder", Robot.drive.getDriveRF());
    SmartDashboard.putNumber("RightMiddleEncoder", Robot.drive.getDriveRM());
    SmartDashboard.putNumber("RightBackEncoder", Robot.drive.getDriveRB());
    SmartDashboard.putNumber("LeftFrontEncoder", Robot.drive.getDriveLF());
    SmartDashboard.putNumber("LeftMiddleEncoder", Robot.drive.getDriveLM());
    SmartDashboard.putNumber("LeftBackEncoder", Robot.drive.getDriveLB());

    SmartDashboard.putNumber("LiftEncoder", Robot.lift.getLiftTalonEncoder());

    SmartDashboard.putNumber("ArmEncoder", Robot.arm.getEncoder());




















  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

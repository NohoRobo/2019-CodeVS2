/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DecreaseDriveSpeedJoystick;
import frc.robot.commands.GroupLiftArmProcedure;
import frc.robot.commands.IncreaseDriveSpeedJoystick;
import frc.robot.commands.IntakePanelSolenoidToggle;
import frc.robot.commands.IntakeRollerSolenoidToggle;
import frc.robot.commands.IntakeRollerWheelSpinning;
import frc.robot.commands.SpinRollers;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and and command groups that allow control of the
 * robot.
 */
public class OI {

  public static final int LEFT_HORIZ_AXIS = 0;
	public static final int LEFT_VERT_AXIS = 1;
	public static final int RIGHT_HORIZ_AXIS = 4;
	public static final int RIGHT_VERT_AXIS = 5;
	public static final int LEFT_Z_AXIS = 3;
	public static final int RIGHT_Z_AXIS = 2;

  public static final double STICK_DEADZONE = 0.2;
  public static final double TRIGGER_DEADZONE = 0.1;

  public Joystick driverController = new Joystick(0);
	Button driverButtonA = new JoystickButton(driverController, 1);
	Button driverButtonB = new JoystickButton(driverController, 2);
	Button driverButtonX = new JoystickButton(driverController, 3);
	Button driverButtonY = new JoystickButton(driverController, 4);
	Button driverButtonLeftBumper = new JoystickButton(driverController, 5);
  Button driverButtonRightBumper = new JoystickButton(driverController, 6);
  
  public Joystick operatorController = new Joystick(1);
  Button Left3 = new JoystickButton(operatorController, 1);
  Button Left2 = new JoystickButton(operatorController, 2);
  Button Left1 = new JoystickButton(operatorController, 3);
  Button LeftShip = new JoystickButton(operatorController, 4);
  Button LeftGround = new JoystickButton(operatorController, 5);
  Button Center3 = new JoystickButton(operatorController, 6);
  Button Center2 = new JoystickButton(operatorController, 7);
  Button Center1 = new JoystickButton(operatorController, 8);
  Button CenterShip = new JoystickButton(operatorController, 9);
  Button Right3 = new JoystickButton(operatorController, 10);
  Button Right2 = new JoystickButton(operatorController, 11);
  Button Right1 = new JoystickButton(operatorController, 12);
  Button RightShip = new JoystickButton(operatorController, 13);
  Button RightGround = new JoystickButton(operatorController, 14);

  public  double getDriverRightY() {
    return -driverController.getRawAxis(RIGHT_VERT_AXIS);
  }

  public double getDriverRightX() {
    return driverController.getRawAxis(RIGHT_HORIZ_AXIS);
  }

  public double getDriverLeftY() {
    return -driverController.getRawAxis(LEFT_VERT_AXIS);
  }

  public double getDriverLeftX() {
    return driverController.getRawAxis(LEFT_HORIZ_AXIS);
  }

  public double getDriverLeftTrigger() {
    return driverController.getRawAxis(LEFT_Z_AXIS);
  }

  public double getDriverRightTrigger() {
    return driverController.getRawAxis(RIGHT_Z_AXIS);
  }

  public OI() {
    driverButtonX.whenPressed(new IntakeRollerSolenoidToggle());
    driverButtonY.whenPressed(new IntakePanelSolenoidToggle());
    driverButtonB.whileHeld(new SpinRollers(1));
    driverButtonA.whileHeld(new SpinRollers(-1));
    driverButtonX.whenPressed(new IntakeRollerWheelSpinning(-1));
    driverButtonX.whenReleased(new IntakeRollerWheelSpinning(1));
    
    driverButtonRightBumper.whenPressed(new IncreaseDriveSpeedJoystick());
    driverButtonLeftBumper.whenPressed(new DecreaseDriveSpeedJoystick());

    Left3.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_3,Robot.arm.ARM_LEFT));
    Left2.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_2,Robot.arm.ARM_LEFT));
    Left1.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_1,Robot.arm.ARM_LEFT));
    LeftShip.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_BALL_SHIP,Robot.arm.ARM_LEFT));
    LeftGround.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_GROUND,Robot.arm.ARM_LEFT));
    Center3.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_3,Robot.arm.ARM_CENTER));
    Center2.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_2,Robot.arm.ARM_CENTER));
    Center1.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_1,Robot.arm.ARM_CENTER));
    CenterShip.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_BALL_SHIP,Robot.arm.ARM_CENTER));
    Right3.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_3,Robot.arm.ARM_RIGHT));
    Right2.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_2,Robot.arm.ARM_RIGHT));
    Right1.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_PANEL_1,Robot.arm.ARM_RIGHT));
    RightShip.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_BALL_SHIP,Robot.arm.ARM_RIGHT));
    RightGround.whenPressed(new GroupLiftArmProcedure(Robot.lift.LIFT_GROUND,Robot.arm.ARM_RIGHT));
  }
}
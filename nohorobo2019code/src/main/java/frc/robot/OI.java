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
import frc.robot.commands.DriveJoystick;
import frc.robot.commands.IncreaseDriveSpeedJoystick;
import frc.robot.commands.IntakeRollerWheelSpinning;
import frc.robot.subsystems.Drive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and and command groups that allow control of the
 * robot.
 */
public class OI {

  private static final int LEFT_HORIZ_AXIS = 0;
	private static final int LEFT_VERT_AXIS = 1;
	private static final int RIGHT_HORIZ_AXIS = 4;
	private static final int RIGHT_VERT_AXIS = 5;
	private static final int LEFT_Z_AXIS = 3;
	private static final int RIGHT_Z_AXIS = 2;

	private static final double STICK_DEADZONE = 0.3;
	private static final double STICK_MAX = 0.97;

  Joystick driverController = new Joystick(0);
	Button driverButtonA = new JoystickButton(driverController, 1);
	Button driverButtonB = new JoystickButton(driverController, 2);
	Button driverButtonX = new JoystickButton(driverController, 3);
	Button driverButtonY = new JoystickButton(driverController, 4);
	Button driverButtonLeftBumper = new JoystickButton(driverController, 5);
	Button driverButtonRightBumper = new JoystickButton(driverController, 6);


public double getDriverRightY() {
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

  driverButtonX.whenPressed(new IntakeRollerWheelSpinning(-1));
  driverButtonA.whenPressed(new IntakeRollerWheelSpinning(1));

  driverButtonRightBumper.whenPressed(new IncreaseDriveSpeedJoystick());
  driverButtonLeftBumper.whenPressed(new DecreaseDriveSpeedJoystick());

  /*driverButtonY.whileHeld(new DriveJoystick(0.1));
  driverButtonY.whenReleased(new DriveJoystick(0));*/

  
  //double drivespeed = 1;
//  driverButtonA.whenPressed(driverspeed += 1);

  /*if (driverButtonLeftBumper.
 

  }*/

  driverButtonX.whenPressed(new DriveJoystick(-1));
  driverButtonA.whenPressed(new DriveJoystick(1));

    new DriveJoystick(/*Drive.driveSpeed*/getDriverRightTrigger());
   new DriveJoystick(-1*/*Drive.driveSpeed*/getDriverLeftTrigger());



   
//Robot.subystems.Drive.driveSpeed = 2;
  
  
  
  
  
  }










	
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}

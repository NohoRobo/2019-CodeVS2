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
import frc.robot.commands.ChangeDir;
import frc.robot.commands.ChangeDirBack;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {




  public static final int LEFT_HORIZ_AXIS = 0;
	public static final int LEFT_VERT_AXIS = 1;
	public static final int RIGHT_HORIZ_AXIS = 4;
	public static final int RIGHT_VERT_AXIS = 5;
	public static final int LEFT_Z_AXIS = 3;
	public static final int RIGHT_Z_AXIS = 2;

  public static final double STICK_DEADZONE = 0.1;
  public static final double TRIGGER_DEADZONE = 0.1;
  public static final double ARM_DEADZONE = 0.1;

  public Joystick driverController = new Joystick(0);
  Button driverButtonA = new JoystickButton(driverController, 1);
	Button driverButtonB = new JoystickButton(driverController, 2);
	Button driverButtonX = new JoystickButton(driverController, 3);
	Button driverButtonY = new JoystickButton(driverController, 4);
	Button driverButtonLeftBumper = new JoystickButton(driverController, 5);
  Button driverButtonRightBumper = new JoystickButton(driverController, 6);
  Button driverButtonSelect = new JoystickButton(driverController, 7);
  Button driverButtonStart = new JoystickButton(driverController, 8);

  /*public Joystick opController = new Joystick(2);
	Button driverButtonA2 = new JoystickButton(opController, 1);
	Button driverButtonB2 = new JoystickButton(opController, 2);
	Button driverButtonX2 = new JoystickButton(opController, 3);
	Button driverButtonY2 = new JoystickButton(opController, 4);
	Button driverButtonLeftBumper2 = new JoystickButton(opController, 5);
  Button driverButtonRightBumper2 = new JoystickButton(opController, 6);
  Button driverButtonSelect2 = new JoystickButton(opController, 7);
  Button driverButtonStart2 = new JoystickButton(opController, 8);
  */

  /*public Joystick operatorController = new Joystick(1);
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
  Button RightGround = new JoystickButton(operatorController, 14);*/






  //analog driver
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



  public OI (){

    driverButtonA.whenPressed(new ChangeDir());
    driverButtonB.whenPressed(new ChangeDirBack());
    //driverButtonB.whenPressed(new ChangeDirBack());





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

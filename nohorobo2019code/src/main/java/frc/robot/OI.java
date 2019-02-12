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
import frc.robot.commands.LiftSetPosition;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and and command groups that allow control of the
 * robot.
 */
public class OI {

  Joystick leftJoy = new Joystick(0);
	Button button1 = new JoystickButton(leftJoy, 1),
			button2 = new JoystickButton(leftJoy, 2),
			button3 = new JoystickButton(leftJoy, 3),
			button4 = new JoystickButton(leftJoy, 4),
			button5 = new JoystickButton(leftJoy, 5),
			button6 = new JoystickButton(leftJoy, 6),
			button7 = new JoystickButton(leftJoy, 7),
      button8 = new JoystickButton(leftJoy, 8);


LiftSetPosition testing = new LiftSetPosition();
public OI() {
      button1.whenPressed(new LiftSetPosition());
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

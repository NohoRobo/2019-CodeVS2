/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //Drive
  /*public static int neoLeftFront;
  public static int neoLeftMiddle;
  public static int neoLeftBack;
  public static int neoRightFront;
  public static int neoRightMiddle;
  public static int neoRightBack;*/
  public static int sparkMaxLeftFront = 5; 
  public static int sparkMaxLeftMiddle = 4; 
  public static int sparkMaxLeftBack = 3;
  public static int sparkMaxRightFront = 0;
  public static int sparkMaxRightMiddle = 1;
  public static int sparkMaxRightBack = 2;

  //Lift
  public static int liftEncoderA = 0; //temp
  public static int liftEncoderB = 3; //temp
  public static int liftRight775 = 1;
  public static int liftLeft775 = 2;
  //Arm
  public static int swingArmEncoderA = 2; //temp
  public static int swingArmEncoderB = 3; //temp
  public static int swingArm775 = 8; //temp
  //Intake
  public static int intake775 = 3;
  public static int intakeRollerSolenoid = 0; //temp
  public static int intakeLeftPistonSolenoid = 1; //temp
  public static int intakeRightPistonSolenoid = 2; //temp
  public static int intakeUltrasonicPing = 3; //temp
  public static int intakeUltrasonicEcho = 4; //temp
}

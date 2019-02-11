/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.command.PIDSubsystem;
=======
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
//import robot.RobotMap;//this doesnt work
>>>>>>> db4795a553ac8d386a0a13271adbe125a5ec0542

/**
 * Add your docs here.
 */
<<<<<<< HEAD
public class Arm extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  public Arm() {
    // Intert a subsystem name and PID values here
    super("SubsystemName", 1, 2, 3);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }
=======
public class Arm extends Subsystem {


  
  private static final int ARM_LEFT = 0;
  private static final int ARM_RIGHT = 0;
  private static final int ARM_FORWARD = 0;

  private int ARM_FRONT_POSITION;
  private int ARM_SIDE_POSITION;
  private int ARM_BACK_POSITION;

  
>>>>>>> db4795a553ac8d386a0a13271adbe125a5ec0542

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

<<<<<<< HEAD
  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return 0.0;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
=======
  public void setArmMotor(double power){
    
  }

  public int getArmPosition(){
    return 0;
  } 
>>>>>>> db4795a553ac8d386a0a13271adbe125a5ec0542
}

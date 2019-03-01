/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.SpinRollerWhenOut;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VictorSPX RollerMotor = new VictorSPX(RobotMap.intake775);
  Solenoid RollerSolenoid = new Solenoid(RobotMap.intakeRollerSolenoid);
  Solenoid LeftPanelSolenoid = new Solenoid(RobotMap.intakeLeftPistonSolenoid);
  Solenoid RightPanelSolenoid = new Solenoid(RobotMap.intakeRightPistonSolenoid);
  //Ultrasonic UltrasonicSensor = new Ultrasonic(RobotMap.intakeUltrasonicPing, RobotMap.intakeUltrasonicEcho);

  public final double BALL_RANGE = 2;

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new SpinRollerWhenOut());

    //setDefaultCommand(new IntakeCheckForBall());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  public void setRollerMotors(double speed){
    RollerMotor.set(ControlMode.PercentOutput, speed);
  }
  
  public void extendRollerSolenoid(){
    RollerSolenoid.set(true);
  }
  public void retractRollerSolenoid(){
    RollerSolenoid.set(false);
  }
  public boolean getRollerSolenoidStatus(){
    return RollerSolenoid.get();
  }
  public void extendPanelPistons(){
    LeftPanelSolenoid.set(true);
    RightPanelSolenoid.set(true);
  }
  public void retractPanelPistons(){
    LeftPanelSolenoid.set(false);
    RightPanelSolenoid.set(false);
  }
  public boolean getPanelPistonStatus(){
    return LeftPanelSolenoid.get();
  }

  /*
  public void UltrasonicRange(){
    UltrasonicSensor.getRangeInches();
  }
  public void EnableUltrasonic(){
    UltrasonicSensor.setEnabled(true);
  }
  public void DisableUltrasonic(){
    UltrasonicSensor.setEnabled(false);
  }
  public boolean BallHeld(){
    return UltrasonicSensor.getRangeInches() < BALL_RANGE;
  }
  */
}

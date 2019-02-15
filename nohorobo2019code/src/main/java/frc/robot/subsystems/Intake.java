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
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

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

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  public void SetRollerMotors(double speed){
    RollerMotor.set(ControlMode.PercentOutput, speed);
  }
  
  public void ExtendRollerSolenoid(){
    RollerSolenoid.set(true);
  }
  public void RetractRollerSolenoid(){
    RollerSolenoid.set(false);
  }
  public void RollerSolenoidStatus(){
    RollerSolenoid.get();
  }
  public void ExtendLeftPanelSolenoid(){
    LeftPanelSolenoid.set(true);
  }
  public void RetractLeftPanelSolenoid(){
    LeftPanelSolenoid.set(false);
  }
  public void LeftPanelSolenoidStatus(){
    LeftPanelSolenoid.get();
  }
  public void ExtendRightPanelSolenoid(){
    RightPanelSolenoid.set(true);
  }
  public void RetractRightPanelSolenoid(){
    RightPanelSolenoid.set(false);
  }
  public void RightPanelSolenoidStatus(){
    RightPanelSolenoid.get();
  }
  
  /*public void UltrasonicRange(){
    UltrasonicSensor.getRangeInches();
  }
  public void EnableUltrasonic(){
    UltrasonicSensor.setEnabled(true);
  }
  public void DisableUltrasonic(){
    UltrasonicSensor.setEnabled(false);
  }*/
}

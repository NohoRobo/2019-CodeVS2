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
import frc.robot.commands.AAA;
import frc.robot.commands.AAAIntakeSpam;
import frc.robot.commands.GroupIntakeDefault;
import frc.robot.commands.IntakeRollerWheelSpinning;
import frc.robot.commands.SpinRollerWhenOut;

public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  VictorSPX RollerMotor = new VictorSPX(RobotMap.intake775);
  Solenoid RollerSolenoid = new Solenoid(RobotMap.intakeRollerSolenoid);
  Solenoid PanelSolenoid = new Solenoid(RobotMap.intakePanelSolenoid);
  Solenoid PanelBaseSolenoid = new Solenoid(RobotMap.intakePanelBaseSolenoid);
  
  //Ultrasonic UltrasonicSensor = new Ultrasonic(RobotMap.intakeUltrasonicPing, RobotMap.intakeUltrasonicEcho);

  //public final double BALL_RANGE = 2;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeRollerWheelSpinning(0.4));
  }
  
  public void setRollerMotors(double speed){
    RollerMotor.set(ControlMode.PercentOutput, speed);
  }
  public void extendPanelBaseSolenoid(){
    PanelBaseSolenoid.set(true);
  }
  public void retractPanelBaseSolenoid(){
    PanelBaseSolenoid.set(false);
  }
  public boolean getPanelBaseSolenoidOut(){
    return PanelBaseSolenoid.get();
  }
  public void extendRollerSolenoid(){
    RollerSolenoid.set(true);
  }
  public void retractRollerSolenoid(){
    RollerSolenoid.set(false);
  }
  public boolean getRollerSolenoidOut(){
    return RollerSolenoid.get();
  }
  public void extendPanelSolenoid(){
    PanelSolenoid.set(true);
  }
  public void retractPanelSolenoid(){
    PanelSolenoid.set(false);
  }
  public boolean getPanelSolenoid(){
    return PanelSolenoid.get();
  }

  public void spamPanel(){
    if(getPanelSolenoid()){
      retractPanelSolenoid();
    }
    else if (!getPanelSolenoid()){
      extendPanelSolenoid();
    }
    
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

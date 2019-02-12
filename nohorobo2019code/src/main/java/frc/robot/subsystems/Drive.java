/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.utilities.PID;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.*;



/**
 * Add your docs here.
 * 
 * 
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax leftFront = new CANSparkMax(RobotMap.neoLeftFront, MotorType.kBrushless);
  CANSparkMax leftMiddle = new CANSparkMax(RobotMap.neoLeftMiddle, MotorType.kBrushless);
  CANSparkMax leftBack = new CANSparkMax(RobotMap.neoLeftBack, MotorType.kBrushless);
  CANSparkMax rightFront = new CANSparkMax(RobotMap.neoRightFront, MotorType.kBrushless);
  CANSparkMax rightMiddle = new CANSparkMax(RobotMap.neoRightMiddle, MotorType.kBrushless);
  CANSparkMax rightBack = new CANSparkMax(RobotMap.neoRightBack, MotorType.kBrushless);
  CANEncoder leftFrontEncoder = new CANEncoder(leftFront);
  CANEncoder leftMiddleEncoder = new CANEncoder(leftMiddle);
  CANEncoder leftBackEncoder = new CANEncoder(leftBack);
  CANEncoder rightFrontEncoder = new CANEncoder(rightFront);
  CANEncoder rightMiddleEncoder = new CANEncoder(rightMiddle);
  CANEncoder rightBackEncoder = new CANEncoder(rightBack);
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void SetLeftMotors(int speed){
    leftFront.set(speed);
    leftMiddle.set(speed);
    leftBack.set(speed);
  }

  public void SetRightMotors(int speed){
    rightFront.set(speed);
    rightMiddle.set(speed);
    rightBack.set(speed);
  }
  
  public void ReadLeftFrontEncoder(){
    leftFrontEncoder.getPosition();
  }
  public void ReadLeftMiddleEncoder(){
    leftMiddleEncoder.getPosition();
  }
  public void ReadLeftBackEncoder(){
    leftBackEncoder.getPosition();
  }
  public void ReadRightFrontEncoder(){
    rightFrontEncoder.getPosition();
  }
  public void ReadRightMiddleEncoder(){
    rightMiddleEncoder.getPosition();
  }
  public void ReadRightBackEncoder(){
    rightBackEncoder.getPosition();
  }

}

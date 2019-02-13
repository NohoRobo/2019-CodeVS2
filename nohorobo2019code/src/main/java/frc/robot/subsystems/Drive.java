/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import frc.robot.utilities.PIDSubSystem;
import frc.robot.utilities.PID;
import frc.robot.utilities.PIDDriveTurning;
import frc.robot.utilities.PIDDriveStraight;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.*;

/**
 * Add your docs here.
 * 
 * 
 */
public class Drive extends Subsystem implements PIDSubSystem {
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

  public PID pidDriveStraight = new PIDDriveStraight(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, false,
  leftFrontEncoder, leftMiddleEncoder, leftBackEncoder,
  rightFrontEncoder, rightMiddleEncoder, rightBackEncoder);

  public PID pidDriveTurning = new PIDDriveTurning(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, false,
  leftFrontEncoder, leftMiddleEncoder, leftBackEncoder,
  rightFrontEncoder, rightMiddleEncoder, rightBackEncoder);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setDriveLeft(double speed){
    this.leftFront.set(speed);
    this.leftMiddle.set(speed);
    this.leftBack.set(speed);
  }

  public void setDriveRight(double speed){
    this.rightFront.set(speed);
    this.rightMiddle.set(speed);
    this.rightBack.set(speed);
  }

  public void setDriveStraight(double speed){
    this.setDriveLeft(speed);
    this.setDriveRight(speed);
  }

  public void setDriveTurning(double speed){
    this.setDriveLeft(speed);
    this.setDriveRight(-speed);
  }
  
  public void setDriveMotorsPID(){
    this.setDriveStraight(this.pidDriveStraight.getMotorPower());
    this.setDriveTurning(this.pidDriveTurning.getMotorPower());
  }

  public void enablePID(){
    this.pidDriveStraight.enable();
    this.pidDriveTurning.enable();
  }

  public void disablePID(){
    this.pidDriveStraight.disable();
    this.pidDriveTurning.disable();
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveJoystick;
import frc.robot.utilities.PIDSubSystem;
import frc.robot.utilities.Utilities;
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
  CANSparkMax leftFront = new CANSparkMax(RobotMap.sparkMaxLeftFront, MotorType.kBrushless);
  CANSparkMax leftMiddle = new CANSparkMax(RobotMap.sparkMaxLeftMiddle, MotorType.kBrushless);
  CANSparkMax leftBack = new CANSparkMax(RobotMap.sparkMaxLeftBack, MotorType.kBrushless);
  CANSparkMax rightFront = new CANSparkMax(RobotMap.sparkMaxRightFront, MotorType.kBrushless);
  CANSparkMax rightMiddle = new CANSparkMax(RobotMap.sparkMaxRightMiddle, MotorType.kBrushless);
  CANSparkMax rightBack = new CANSparkMax(RobotMap.sparkMaxRightBack, MotorType.kBrushless);
  CANEncoder leftFrontEncoder = new CANEncoder(leftFront);
  CANEncoder leftMiddleEncoder = new CANEncoder(leftMiddle);
  CANEncoder leftBackEncoder = new CANEncoder(leftBack);
  CANEncoder rightFrontEncoder = new CANEncoder(rightFront);
  CANEncoder rightMiddleEncoder = new CANEncoder(rightMiddle);
  CANEncoder rightBackEncoder = new CANEncoder(rightBack);

public double invert = 1;
  public double driveSpeed = 1;
  private double speedStraight = 0;
  private double speedTurning  = 0;

  public PID pidDriveStraight = new PIDDriveStraight(0, 0, 0, 0, 0, 0, 0, 0, false,
  leftFrontEncoder, leftMiddleEncoder, leftBackEncoder,
  rightFrontEncoder, rightMiddleEncoder, rightBackEncoder);

  public PID pidDriveTurning = new PIDDriveTurning(0, 0, 0, 0, 0, 0, 0, 0, false,
  leftFrontEncoder, leftMiddleEncoder, leftBackEncoder,
  rightFrontEncoder, rightMiddleEncoder, rightBackEncoder);

  @Override
  public void initDefaultCommand() {

    setDefaultCommand(new DriveJoystick());

    //setDefaultCommand(new DriveJoystick(-1*Robot.m_oi.getDriverLeftTrigger()));
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  
  public void invertMotorDirection(){
    if (invert == 1) this.invert=-1;
    else this.invert=1;
  }
  public void stop(){
    setDriveLeft(0);
    setDriveRight(0);
  }
  public void setDriveLeft(double speed){
   //this.leftFront.set(-speed);
    //this.leftMiddle.set(-speed);
    //this.leftBack.set(-speed);
  }

  public void setDriveRight(double speed){
    //this.rightFront.set(speed);
    //this.rightMiddle.set(speed);
    //this.rightBack.set(speed);
  }

  public void setDriveStraight(double speed){
    this.speedStraight = speed;
    setFinalDrive();
  }
  private void setFinalDrive(){
    setDriveMotors(Utilities.limit(this.driveSpeed * Math.pow(this.speedStraight + this.speedTurning,3),-1,1), Utilities.limit(this.driveSpeed*Math.pow(this.speedStraight - this.speedTurning,3),-1,1));
  }
  public void setDriveMotors(double leftSpeed, double rightSpeed){
    this.setDriveLeft(leftSpeed);
    this.setDriveRight(rightSpeed);
  }
  public double  checkStickDeadzone(double speed){
    if(Math.abs(speed)>Robot.m_oi.STICK_DEADZONE) return speed;
    else return 0;
  }
  public double checkTriggerDeadzone(double speed){
    if(Math.abs(speed)>Robot.m_oi.TRIGGER_DEADZONE) return speed;
    else return 0;
  }
  public void setDriveTurning(double speed){
    this.speedTurning = speed;
    setFinalDrive();
  }
  
  public void setDriveMotorsPID(){
    this.setDriveStraight(this.pidDriveStraight.getMotorPower());
    this.setDriveTurning(this.pidDriveTurning.getMotorPower());
  }

  public void increaseMaxSpeed(){
    this.driveSpeed += 0.25;
    if (this.driveSpeed >= 1){
      this.driveSpeed = 1;
    }
    //return driveSpeed;
  }

  public void decreaseMaxSpeed(){
    this.driveSpeed -= 0.25;
    if (this.driveSpeed <= .25){
      this.driveSpeed = .25;
    }
    //return driveSpeed;
  }



  public double getDriveRF(){

    return rightFrontEncoder.getPosition();

  }
  public double getDriveRM(){

    return rightMiddleEncoder.getPosition();

  }

  public double getDriveRB(){

    return rightBackEncoder.getPosition();

  }

  public double getDriveLF(){

    return leftFrontEncoder.getPosition();

  }

  public double getDriveLM(){

    return leftMiddleEncoder.getPosition();

  }

  public double getDriveLB(){

    return leftBackEncoder.getPosition();

  }

  /*public double setMaxSpeed(double toSet){
    driveSpeed = (toSet > 1) ? +.25 : -.25;
    driveSpeed = (driveSpeed >1) ? 1 : driveSpeed));

    return driveSpeed;
  }*/
}

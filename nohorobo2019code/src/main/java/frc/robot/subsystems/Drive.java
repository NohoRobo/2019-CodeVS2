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
  public void setDriveStraight(double speed){
    this.speedStraight = speed;
    setFinalDrive();
  }
  private void setFinalDrive(){
    setDriveMotors(this.speedStraight+this.speedTurning, this.speedStraight-this.speedTurning); 
  }
  public void setDriveMotors(double leftSpeed, double rightSpeed){
    this.setDriveLeft(leftSpeed);
    this.setDriveRight(rightSpeed);
  }
  public void stop(){
    setDriveLeft(0);
    setDriveRight(0);
  }
  public void setDriveLeft(double speed){
    this.leftFront.set(this.invert*(Utilities.limit(speed, -1, 1)));
    this.leftMiddle.set(this.invert*(Utilities.limit(speed, -1, 1)));
    this.leftBack.set(this.invert*(Utilities.limit(speed, -1, 1)));
  }

  public void setDriveRight(double speed){
    this.rightFront.set(this.invert*(Utilities.limit(speed, -1, 1)));
    this.rightMiddle.set(this.invert*(Utilities.limit(speed, -1, 1)));
    this.rightBack.set(this.invert*(Utilities.limit(speed, -1, 1)));
  }
  
  public void setDriveMotorsPID(){
    this.setDriveStraight(Utilities.limit(this.pidDriveStraight.getMotorPower(),-1,1));
    this.setDriveTurning(Utilities.limit(this.pidDriveTurning.getMotorPower(),-1,1));
  }

  public void setDriveTurning(double speed){
    this.speedTurning = speed;
    setFinalDrive();
  }
  public double checkStickDeadzone(double speed){
    if(Math.abs(speed)>Robot.m_oi.STICK_DEADZONE) return speed;
    else return 0;
  }
  public double checkTriggerDeadzone(double speed){
    if(Math.abs(speed)>Robot.m_oi.TRIGGER_DEADZONE) return speed;
    else return 0;
  }

  public void increaseMaxSpeed(){
    driveSpeed += 0.25;
    if (driveSpeed >= 1){
      driveSpeed = 1;
    }
    //return driveSpeed;
  }

  public void decreaseMaxSpeed(){
    driveSpeed -= 0.25;
    if (driveSpeed <= 0){
      driveSpeed = 0;
    }
    //return driveSpeed;
  }
    //return driveSpeed;
  

  /*public double setMaxSpeed(double toSet){
    driveSpeed = (toSet > 1) ? +.25 : -.25;
    driveSpeed = (driveSpeed >1) ? 1 : driveSpeed));

    return driveSpeed;
  }*/
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.OI;
import frc.robot.commands.DriveJoystick;
import frc.robot.utilities.PIDSubSystem;
import frc.robot.utilities.Utilities;
import frc.robot.utilities.PID;
//import frc.robot.utilities.PIDDriveTurning;
//import frc.robot.utilities.PIDDriveStraight;

import frc.robot.Robot;

//import com.revrobotics.CANEncoder;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.*;

public class Drive extends Subsystem implements PIDSubSystem {
  VictorSP left = new VictorSP(RobotMap.sparkMaxLeft);
  VictorSP right = new VictorSP(RobotMap.sparkMaxRight);

  
  /*CANEncoder leftFrontEncoder = new CANEncoder(leftFront);
  CANEncoder leftMiddleEncoder = new CANEncoder(leftMiddle);
  CANEncoder leftBackEncoder = new CANEncoder(leftBack);
  CANEncoder rightFrontEncoder = new CANEncoder(rightFront);
  CANEncoder rightMiddleEncoder = new CANEncoder(rightMiddle);
  CANEncoder rightBackEncoder = new CANEncoder(rightBack);*/

  public double driveSpeed = 1;
  private double speedStraight = 0;
  private double speedTurning  = 0;
  public double direction = 1;



  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveJoystick());
  }

  public void stop(){
    setDriveLeft(0);
    setDriveRight(0);
  }

  public void setDriveLeft(double speed){
    speed *= reverse();
    this.left.set(-speed/2);
    //this.leftMiddle.set(-speed);
    //this.leftBack.set(-speed);
  }

  public void setDriveRight(double speed){
    speed *= reverse();
    this.right.set(speed/2);
    //this.rightMiddle.set(speed);
    //this.rightBack.set(speed);
  }

  public void setDriveStraight(double speed){
    this.speedStraight = speed;
    setFinalDrive();
  }
  private void setFinalDrive(){
    setDriveMotors(Utilities.limit(this.driveSpeed * ((.6*Math.pow(this.speedStraight - this.speedTurning,3)+(.4*(this.speedStraight - this.speedTurning)))),-1,1), Utilities.limit(this.driveSpeed*((.6*Math.pow(this.speedStraight + this.speedTurning,3)+(.4*(this.speedStraight + this.speedTurning)))) ,-1,1));
  }
  public void setDriveMotors(double leftSpeed, double rightSpeed){
    this.setDriveLeft(leftSpeed);
    this.setDriveRight(rightSpeed);
  }
  public double checkStickDeadzone(double speed){
    if(Math.abs(speed)>OI.STICK_DEADZONE) return speed;
    else return 0;
  }
  public double checkTriggerDeadzone(double speed){
    if(Math.abs(speed)>OI.TRIGGER_DEADZONE) return speed;
    else return 0;
  }
  public void setDriveTurning(double speed){
    this.speedTurning = speed;
    setFinalDrive();
  }
  
  /*public void setDriveMotorsPID(){
    this.setDriveStraight(this.pidDriveStraight.getMotorPower());
    this.setDriveTurning(this.pidDriveTurning.getMotorPower());
  }*/

  public void increaseMaxSpeed(){
    this.driveSpeed += 0.25;
    if (this.driveSpeed >= 1){
      this.driveSpeed = 1;
    }
  }

  public void decreaseMaxSpeed(){
    this.driveSpeed -= 0.25;
    if (this.driveSpeed <= .25){
      this.driveSpeed = .25;
    }
  }


  public void ChangeDir1(){
    //if (direction == 1){
      this.direction = -1;
      System.out.print("Direction change works");
    //}

    /*if (direction == -1){
      direction = 1;
    }*/
  }

  public void ChangeDir2(){
    //if (direction == 1){
      this.direction = 1;
    //}

    /*if (direction == -1){
      direction = 1
    }*/
  }


  public void ChangeAll(){
    if (this.direction == 1){
      this.direction = -1;
    }

    else if (this.direction == -1){
      this.direction = 1;
    }
  }
  /*public double getDriveRF(){
    return reverse()*rightFrontEncoder.getPosition();
  }
  public double getDriveRM(){
    return reverse()*rightMiddleEncoder.getPosition();
  }

  public double getDriveRB(){
    return reverse()*rightBackEncoder.getPosition();
  }

  public double getDriveLF(){
    return reverse()*leftFrontEncoder.getPosition();
  }

  public double getDriveLM(){
    return reverse()*leftMiddleEncoder.getPosition();
  }

  public double getDriveLB(){
    return reverse()*leftBackEncoder.getPosition();
  }*/

  private int reverse(){
    return (Robot.onLeftSideOfField?1:-1);
  }

  /*public double setMaxSpeed(double toSet){
    driveSpeed = (toSet > 1) ? +.25 : -.25;
    driveSpeed = (driveSpeed >1) ? 1 : driveSpeed));

    return driveSpeed;
  }*/
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.utilities.PIDSubSystem;
import frc.robot.utilities.PID;
import frc.robot.utilities.PIDLift;

import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TestingSparkMaxControllers;



/**
 * Add your docs here.
 */
public class Lift extends Subsystem implements PIDSubSystem {
  // Pu1t methods for controlling this subsystem 
  // here. Call these from Commands.
  TalonSRX liftTalon1 = new TalonSRX(RobotMap.liftRight775);
  TalonSRX liftTalon2 = new TalonSRX(RobotMap.liftLeft775);
  //Encoder liftEncoder = new Encoder(RobotMap.liftEncoderA, RobotMap.liftEncoderB);

  //PID pidLift = new PIDLift(0.1, 0.1, 0.1, 1.0, 1.0, 0.2, 5.0, 0.1, false, liftEncoder);
  @Override
  public void initDefaultCommand() {


    setDefaultCommand(new TestingSparkMaxControllers(0));


    //setDefaultCommand(new TestingSparkMaxControllers(Robot.m_oi.getDriverLeftY()));
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  /**
 * @return the liftTalon1
 */

public void setTalon1Speed(double speed){
    liftTalon1.set(ControlMode.PercentOutput, speed);
  }
public  void setTalon2Speed(double speed){
  liftTalon2.set(ControlMode.PercentOutput, speed);
} 



}

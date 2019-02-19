/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.utilities;

/**
 * Add your docs here.
 */
public class Utilities {

    public static double limit(double value, double floor, double ceiling){
        if(value<=floor)return floor;
        if(value>=ceiling)return ceiling;
        return value;
    } 

}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class BallGatheringSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double speed = 0.5;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void ballIn() {
    RobotMap.leftIntake.set(-speed);
    RobotMap.rightIntake.set(speed);
  }
  public void ballOut() {
    RobotMap.leftIntake.set(speed);
    RobotMap.rightIntake.set(-speed);
  }
  public void ballStop() {
    // that's funny, all stop.
    RobotMap.leftIntake.set(0);
    RobotMap.rightIntake.set(0);
  }
}

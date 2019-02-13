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

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void ballIn() {
    RobotMap.leftBallMotor.set(-0.5);
    RobotMap.rightBallMotor.set(0.5);
  }
  public void ballOut() {
    RobotMap.leftBallMotor.set(0.5);
    RobotMap.rightBallMotor.set(-0.5);
  }
  public void ballStop() {
    // that's funny, all stop.
    RobotMap.leftBallMotor.set(0);
    RobotMap.rightBallMotor.set(0);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class ArmDriveMotorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void armDown() {
    double motorSpeed = Robot.controlBoxSubsystem.getPotValueScaled(1, 0.0, 1.0);
    Robot.nttable.getEntry("Control Box arm speed").setDouble(motorSpeed);
    RobotMap.armUpDown.set(motorSpeed);
  }
  public void armUp() {
    double motorSpeed = Robot.controlBoxSubsystem.getPotValueScaled(1, 0.0, 1.0);
    RobotMap.armUpDown.set(- motorSpeed);
  }
  public void armStop() {
    RobotMap.armUpDown.set(0);
  }
}

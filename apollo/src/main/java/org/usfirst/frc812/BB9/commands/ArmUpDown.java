/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmUpDown extends Command {
  private int goingUp;
  private boolean finished;
  public ArmUpDown(int upDown) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.armDriveMotorSubsystem);
    goingUp = upDown;
    finished = false;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch (goingUp) {
      case 0:
        Robot.armDriveMotorSubsystem.armStop();
        break;
      case 1:
        Robot.armDriveMotorSubsystem.armDown();
        break;
      case 2:
        Robot.armDriveMotorSubsystem.armUp();
        break;
      default:
        Robot.armDriveMotorSubsystem.armStop();
        break;
    }
    finished = true;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

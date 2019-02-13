/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc812.BB9.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc812.BB9.Robot;

public class BallGatherer extends Command {
  private int todo;
  private boolean finished;
  public BallGatherer(int inOutStop) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.ballGatheringSubsystem);
    todo = inOutStop;
    finished = false;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch(todo) {
      case 0:
        Robot.ballGatheringSubsystem.ballStop();
        break;
      case 1:
        Robot.ballGatheringSubsystem.ballIn();
        break;
      case 2:
        Robot.ballGatheringSubsystem.ballOut();
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

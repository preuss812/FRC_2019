/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.subsystems.PistonLiftSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class PistonLiftCommand extends Command {
  private boolean finished = false;
  private int action;
  private PistonLiftSubsystem pistons = Robot.pistonLiftSubsystem;

  public PistonLiftCommand(int act) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pistonLiftSubsystem);
    action = act;
    finished = false;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch(action) {
      case 0: // front up
        pistons.frontUp();
        break;
      case 1: // front down
        pistons.frontDown();
        break;
      case 2: // back up
        pistons.backUp();
        break;
      case 3: // back down
        pistons.backDown();
        break;
      case 4: // both up
        pistons.allUp();
        break;
      case 5: // both down
        pistons.allDown();
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

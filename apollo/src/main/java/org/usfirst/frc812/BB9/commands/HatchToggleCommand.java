/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc812.BB9.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc812.BB9.Robot;

/**
 * Add your docs here.
 */
public class HatchToggleCommand extends Command {
  /**
   * Add your docs here.
   */

  public HatchToggleCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.hatchSubsystem);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    Robot.hatchSubsystem.toggle();
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
  }

  protected boolean isFinished() {
    return true;
  }
  // Called once after timeout
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}

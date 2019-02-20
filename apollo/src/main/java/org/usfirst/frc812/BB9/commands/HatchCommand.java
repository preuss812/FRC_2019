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
public class HatchCommand extends Command {
  /**
   * Add your docs here.
   */
  private double timeout;

  public HatchCommand(double waitTime) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.hatchSubsystem);
    timeout = waitTime;
    Robot.nttable.getEntry("Hatch Command timeout:").setDouble(timeout);
    setTimeout(timeout);

  }

  // Called just before this Command runs the first time
  protected void initialize() {
    Robot.hatchSubsystem.open();
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
  }

  protected boolean isFinished() {
    return isTimedOut();
  }
  // Called once after timeout
  protected void end() {
    Robot.hatchSubsystem.close();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}

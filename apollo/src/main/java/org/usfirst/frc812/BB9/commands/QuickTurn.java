package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class QuickTurn extends Command {

	boolean done = false;

    public QuickTurn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.quick_turn = false; // default is automatic
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
 
        Robot.quick_turn = true;
        done = true;
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.quick_turn = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}

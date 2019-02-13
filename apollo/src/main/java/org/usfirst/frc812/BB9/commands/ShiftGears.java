package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftGears extends Command {

    boolean done = false;
    private int shiftValue;

    public ShiftGears(int shift) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        shiftValue = shift;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.shift_control = shiftValue;
        done = true;
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}

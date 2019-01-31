package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousOpenArms extends Command {
	public AutonomousOpenArms() {
		System.out.println("AutonomousOpenArms: executing");
	}
    protected void initialize() {
        
    }
    protected void execute() {
		
		end();
    }

	protected boolean isFinished() {
		return true;
	}

// Called once after isFinished returns true
	protected void end() {
	}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}

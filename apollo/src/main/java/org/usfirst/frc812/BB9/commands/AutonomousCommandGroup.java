package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * We have enabled the three position switch on the external control box
 * The autonomous CommandGroup can operate three different autonomous
 * sequences depending on where the switch is set.
 * - Robot.controlBoxSubsystem.isSwitchleft()
 * - Robot.controlBoxSubsystem.isSwitchCenter()
 * - Robot.controlBoxSubsystem.isSwitchRight()
 */
public class AutonomousCommandGroup extends CommandGroup {
	AutonomousCommandGroup() {
		System.out.println("AutonomousCommandGroup called");
		long sleepDuration;
		if( Robot.runOnce ) {
			Robot.controlBoxSubsystem.readBits();
			Robot.controlBoxSubsystem.printBits();
			
			sleepDuration = (long) ((Robot.controlBoxSubsystem.getPotValue(1)+1.0)/2.0*4.0*1000.0); // Pot % * 10 sec * 1000ms/s
			try {
				Thread.sleep(sleepDuration);
			} catch (InterruptedException e) {
			}
			
			if( ! Robot.controlBoxSubsystem.isSet(7) ) {
				if( Robot.controlBoxSubsystem.isSwitchLeft())  {
			//input parameters(xSpeed, ySpeed, time in seconds)
					//
					//      +----X
					//      |
					//      |
					//      |
					//      o
					System.out.println("Autonomous mode = Left");
					addSequential(new DriveByTime( 0.0,  0.4,  0.0,  3.6));//(Y, X, rotation, time) drives 13.5 feet forward
					addSequential(new DriveByTime( 0.0,  0.0, 0.5,  0.80));// rotate right 90 degrees
					addSequential(new DriveByTime( 0.0,  0.3,  0.0,  1.0));//(Y, X, time) drives five feet forward
					
		//			addParallel(new MoveArmByTime(-0.30,3.0));    // keep the arm up, fight gravity
					addSequential(new MoveArmByTime(0.20, 0.75));  // Move Arm Down into drop position
					addSequential(new AutonomousOpenArms());
					addSequential(new MoveArmByTime(-0.3, 0.75));  // keep the arm off the switch
	
				} else if( Robot.controlBoxSubsystem.isSwitchCenter()) {
					//if the switch is center, the arm motors will run twice as fast
					//
					//      ^
					//      |
					//      |
					//      |
					//      o
					System.out.println("Autonomous mode = Center");
					addSequential(new DriveByTime(0.0, 0.3, 0.0, 3.5));// drives ten feet forward
					addSequential(new MoveArmByTime(0.20, 0.75));  // Move Arm Down into drop position
					addSequential(new AutonomousOpenArms());
					addSequential(new MoveArmByTime(-0.3, 0.75));  // keep the arm off the switch

				} else if( Robot.controlBoxSubsystem.isSwitchRight()) {
					//if the switch is center, the arm motors will run twice as fast
					//
					// X----+
					//      |
					//      |
					//      o
					System.out.println("Autonomous mode = Right");
					addSequential(new DriveByTime(0.0,   0.4, 0.0, 3.6));//drives 13.5 feet 
					addSequential(new DriveByTime( 0.0,  0.0, -0.5,  0.80));// rotate left 90 degrees
					addSequential(new DriveByTime( 0.0,  0.3,  0.0,  1.0));//(Y, X, time) drives forward
					
					addSequential(new MoveArmByTime(0.20, 0.75));  // Move Arm Down into drop position
					addSequential(new AutonomousOpenArms());
					addSequential(new MoveArmByTime(-0.3, 0.75));  // keep the arm off the switch

					// Perform a sequence
				}
				
				Robot.runOnce = false;
			} else {
				System.out.println("Autonomous mode = DISABLED");
			}
		} else {
			System.out.println("runOnce is false and so I'm not running this again.");
		}
	}
}

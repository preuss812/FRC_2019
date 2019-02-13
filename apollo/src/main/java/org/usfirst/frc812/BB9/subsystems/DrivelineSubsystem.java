package org.usfirst.frc812.BB9.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivelineSubsystem extends Subsystem {

	public static final double distancePerPulse = .01227;
	public static Encoder leftEncoder;
	public static Encoder rightEncoder;

	
	//constructor method to instantiate counters
	
	public DrivelineSubsystem() {
		leftEncoder = new Encoder(0,1);
		rightEncoder = new Encoder(2, 3);
	}
	
	@Override
	protected void initDefaultCommand() {

	}

	public static Encoder getLeftEncoder() {
		return leftEncoder;
	}

	public static Encoder getRightEncoder() {
		return rightEncoder;
	}

}

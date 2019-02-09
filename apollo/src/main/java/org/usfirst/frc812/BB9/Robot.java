// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc812.BB9;

import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;

import org.usfirst.frc812.BB9.commands.AutonomousCommand;
import org.usfirst.frc812.BB9.subsystems.ControlBoxSubsystem;
import org.usfirst.frc812.BB9.subsystems.DriveTrain;
import org.usfirst.frc812.BB9.RobotMap.shifter;

import org.usfirst.frc812.BB9.RobotMap.leftEncoder;
import org.usfirst.frc812.BB9.RobotMap.rightEncoder;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

	Command autonomousCommand;

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static DriveTrain driveTrain;
	public static ControlBoxSubsystem controlBoxSubsystem;
	public static String gameData;
	public static boolean runOnce;
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;

	public static double centerX = 3.14;
//	private RobotDrive drive;

	private final Object imgLock = new Object();

	private static final double shift_up_speed = 4; //feet pers sec
	private static final double shift_down_speed = 3; //feet per sec

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		NetworkTableInstance ntinst = NetworkTableInstance.getDefault();
		NetworkTable nttable = ntinst.getTable("myTable");
		nttable.getEntry("myTable").setDouble(6.78);
		RobotMap.init();
	
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		driveTrain = new DriveTrain();
		controlBoxSubsystem = new ControlBoxSubsystem();
		
		Timer.delay(0.1);
		
		// The following print statements come from the controlBoxSubsystem.. they're
		// only here for testing initial connection to the wheel  encoders while we have no
		// joysticks hooked up

		 Timer.delay(0.005);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		autonomousCommand = new AutonomousCommand();
		
		runOnce = true;
//		gameData = "RRR";
		System.out.println("auto init");
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
	//	System.out.println("auto running");
		Scheduler.getInstance().run();
		//System.out.println("leftcount is " +LeftCount );
		//System.out.println("rightcount is " + RightCount );
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		private double speed;
		private boolean isInHighGear;
		private int shift_control = 0; // move this to a button
		
		Scheduler.getInstance().run();

		speed=Math.max(leftEncoder.getRate(), rightEncoder.getRate());

		
		boolean shift = false;
		switch(shift_control)
		{
			case 0: 
				if (shifter.get() == Value.kForward )
				{
					shift = speed>shift_down_speed;
				}
				else 
				{
					shift = speed>shift_up_speed;
				}
				break;
			case 1:
				shift = false;
				break;
			case 2:
				shift = true; 
				break;
		}
		setGear(shift);
	}


	public voi
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	//	LiveWindow.run();
	}

	public double getCenterX() {
		return centerX;
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}

    public void setGear(boolean gearValue) {
	shifter.set(gearValue ? Value.kForward : Value.kReverse);
	isInHighGear = gearValue;
    }

    public boolean isHighGear() {
	return isinHighGear;
    }
}

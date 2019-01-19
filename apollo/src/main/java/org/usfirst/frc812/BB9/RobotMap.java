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

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

// import edu.wpi.first.wpilibj.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.*;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

//import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static WPI_TalonSRX LeftRear;
	public static WPI_TalonSRX RightFront;
	public static WPI_TalonSRX RightRear;
	public static WPI_TalonSRX leftFront;
	public static WPI_TalonSRX armMotor;
	public static WPI_TalonSRX winch;
	public static DifferentialDrive dtProtoRobotDrive;
	public static DifferentialDrive dtProductionRobotDrive;
	public static MecanumDrive dtMecanumDrive;
	public static Compressor compressor;
	public static Solenoid leftSolenoid;
	public static Solenoid rightSolenoid;
	// public static DoubleSolenoid shifter;
	public static DoubleSolenoid picker;
	public static Servo cameraHorizontal;
	public static Servo cameraVertical;
	public static AnalogGyro gyro;
	// public static DigitalInput grabberSensor;
	public static DigitalInput climberSensor;

	private static double rampRateSeconds = 2.5;
	private static double deadBandPercentage = 0.03;

	// ultrasonic sensor
	public static AnalogInput ultraSensor;
	public static AnalogInput analogPot;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static void init() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		// Production robot uses CAN bus Talon SRX speed controllers
		leftFront = new WPI_TalonSRX(30);
		RightRear = new WPI_TalonSRX(42);
		RightFront = new WPI_TalonSRX(40);
		LeftRear = new WPI_TalonSRX(32);
		winch = new WPI_TalonSRX(23);

		// Set ramp rate for some level of control
		leftFront.configClosedloopRamp(rampRateSeconds, 0);
		RightRear.configClosedloopRamp(rampRateSeconds, 0);
		RightFront.configClosedloopRamp(rampRateSeconds, 0);
		LeftRear.configClosedloopRamp(rampRateSeconds, 0);

		// Set deadband area
		leftFront.configNeutralDeadband(deadBandPercentage, 0);
		RightRear.configNeutralDeadband(deadBandPercentage, 0);
		RightFront.configNeutralDeadband(deadBandPercentage, 0);
		LeftRear.configNeutralDeadband(deadBandPercentage, 0);
		

		dtMecanumDrive = new MecanumDrive(leftFront, LeftRear, RightFront, RightRear);

		armMotor = new WPI_TalonSRX(50);
		armMotor.configClosedloopRamp(1.0, 0); // take 1 second to ramp from zero to full throttle
		armMotor.configNeutralDeadband(0.05, 0); // set deadband to 5% of range
		armMotor.configForwardSoftLimitEnable(false, 0);
		armMotor.configReverseSoftLimitEnable(false, 0);
		armMotor.configReverseSoftLimitThreshold(0, 0);
		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		compressor = new Compressor(0);
		compressor.start();
		picker = new DoubleSolenoid(0, 0, 1);

	}
}

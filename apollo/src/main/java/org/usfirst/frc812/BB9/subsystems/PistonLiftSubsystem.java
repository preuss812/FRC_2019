/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.RobotMap;
import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class PistonLiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DoubleSolenoid frontPiston = RobotMap.frontLift;
  private DoubleSolenoid backPiston = RobotMap.backLift;

  private static PistonLiftSubsystem mInstance;

	public synchronized static PistonLiftSubsystem getInstance() {
		if (mInstance == null) {
			mInstance = new PistonLiftSubsystem();
			Robot.nttable.getEntry("PistonLift-instance:").setString("created");
		}
		return mInstance;
	}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    allDown(); // default position
  }

  public void frontUp() {
    frontPiston.set(DoubleSolenoid.Value.kReverse);
  }
  public void frontDown() {
    frontPiston.set(DoubleSolenoid.Value.kForward);
  }
  public void backUp() {
    backPiston.set(DoubleSolenoid.Value.kReverse);
  }
  public void backDown() {
    backPiston.set(DoubleSolenoid.Value.kForward);
  }

  public void allUp() {
    frontUp();
    backUp();
  }

  public void allDown() {
    frontDown();
    backDown();
  }

}


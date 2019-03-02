/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc812.BB9.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc812.BB9.Robot;

public class PistonLiftGroupCommand extends CommandGroup {
  /**
   * Add your docs here.
   */
  private double liftDelay;

  public PistonLiftGroupCommand(int action) {
    liftDelay = Robot.controlBoxSubsystem.getPotValueScaled(1, 0.000, 2.000);
    Robot.nttable.getEntry("PistonLiftDelay").setDouble(liftDelay);
    
    switch(action) {
      case 0:
        addSequential(new PistonLiftCommand(0));
        break;
      case 1:
        addSequential(new PistonLiftCommand(1));
        break;
      case 2:
        addSequential(new PistonLiftCommand(2));
        break;
      case 3:
        addSequential(new PistonLiftCommand(3));
        break;
      case 4:
        addSequential(new PistonLiftCommand(4));
        break;
      case 5:
        addSequential(new PistonLiftCommand(5));
        break;
      case 6:
        addSequential(new PistonLiftCommand(0)); // front up
        addSequential(new WaitCommand(liftDelay));
        addSequential(new PistonLiftCommand(2)); // back up
        break;
    }
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}

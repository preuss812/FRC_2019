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

import org.usfirst.frc812.BB9.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick leftJoystick;
    public Joystick rightJoystick;
    public Joystick controlBox;
    public XboxController xboxController;
    public Button frontLiftToggle;
    public Button backLiftToggle;
    public Button ballIntake;
    public Button ballOutput;
    public Button hatchToggle;
    public Button armDown;
    public Button armUp;

    public Button printDiagnostics;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        leftJoystick = new Joystick(0);
        rightJoystick = new Joystick(1);
        controlBox = new Joystick(2);
        xboxController = new XboxController(3);
        
        frontLiftToggle = new JoystickButton(leftJoystick, 1);
        backLiftToggle = new JoystickButton(leftJoystick, 3);
        ballIntake = new JoystickButton(xboxController, 6);
        ballOutput = new JoystickButton(xboxController, 5);
        hatchToggle = new JoystickButton(rightJoystick, 1);
        
        printDiagnostics = new JoystickButton(rightJoystick, 10);
        printDiagnostics.whileHeld(new PrintDiagnostics());
        // SmartDashboard Buttons
        SmartDashboard.putData("test drive: STOP", new DriveWithJoysticks());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }
    
    public XboxController getXboxController() {
    	return xboxController;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

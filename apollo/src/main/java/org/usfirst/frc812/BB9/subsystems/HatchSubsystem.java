package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HatchSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private DoubleSolenoid picker = RobotMap.hatch ;
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        close();
    }
    public void open(){	
        picker.set(DoubleSolenoid.Value.kForward);
    }
    public void close(){
        picker.set(DoubleSolenoid.Value.kReverse);
    }

    public void toggle() {
        DoubleSolenoid.Value state = picker.get();

        switch(state) {
            case kOff:
                break;
            case kForward:
                close();
                break;
            case kReverse:
                open();
                break;
        }
    }
}



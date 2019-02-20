package org.usfirst.frc812.BB9.subsystems;
import org.usfirst.frc812.BB9.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ControlBoxSubsystem2019 extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static final int CB1 = 2;
	private static final int CB2 = 4;
	private static final int CB3 = 8;
	private static final int CB4 = 16;
	private static final int CB5 = 32;
	private static final int CB6 = 64;
	private static final int CB7 = 128;

	private static int flagBits = 0;

	private static Joystick controlBox;

	private static ControlBoxSubsystem2019 mInstance;

	public synchronized static ControlBoxSubsystem2019 getInstance() {
		if (mInstance == null) {
			mInstance = new ControlBoxSubsystem2019();
			Robot.nttable.getEntry("Controlbox-instance:").setString("created");
		}
		return mInstance;
	}
	
	private ControlBoxSubsystem2019() {
		controlBox = new Joystick(3);
		Robot.nttable.getEntry("Controlbox-joystick:").setString("initialized");
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // This function reads each button on the control box and sets 
    // a corresponding single bit in the integer variable flagBits
    // using bit shifts; e.g., << operator
    public void readBits() {
    	flagBits = 0;
    	for (int i = 1; i<=7; i++) {
    		if(controlBox.getRawButton(i)) {
    			flagBits |= 1 << i;
    		}
    	}
    }
    
    // Creates a mask by bit shifting to the flag number
    // to be inspected and then logically ands that against
    // the flagBits and if the mask set is equal to the value
    // returned, then the bit is set.
    public boolean isSet(int flag) {
    	int flagMask = 1 << flag;
    	if( (flagBits & flagMask) == flagMask ) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public void printBits() {
    	readBits();
//		System.out.println("ControlBox bits: " + Integer.toBinaryString(flagBits));
		Robot.nttable.getEntry("Controlbox flagbits").setString(Integer.toBinaryString(flagBits));
    	String prespace = "";
//    	System.out.print("Switches: ");
    	for (int i = 1; i<=7; i++) {
//			System.out.print(prespace + i + "=" + (isSet(i) ? "on":"off"));
			String iString = String.format( prespace + i + "=" + (isSet(i) ? "on":"off") );
			String eString = String.format("ControlBox bit %d", i);
			Robot.nttable.getEntry(eString).setString(iString);
    		prespace = " ";
		}	
		Robot.nttable.getEntry("ControlBox pot 0").setDouble(getPotValue(0));
		Robot.nttable.getEntry("ControlBox pot 1").setDouble(getPotValue(1));
		Robot.nttable.getEntry("ControlBox pot 0 scaled 0-5").setDouble(getPotValueScaled(0,0.0,5.0));
		Robot.nttable.getEntry("ControlBox pot 1 scaled 0-5").setDouble(getPotValueScaled(1, 0.0, 5.0));

		Robot.nttable.getEntry("ControlBox sw left").setString((isSwitchLeft() ? "true":"false"));
		Robot.nttable.getEntry("ControlBox sw center").setString((isSwitchCenter() ? "true":"false"));
		Robot.nttable.getEntry("ControlBox sw right").setString((isSwitchRight() ? "true":"false"));

/*
    	System.out.println("");
    	System.out.println("ControlBox pot 0:  " + getPotValue(0));
    	System.out.println("ControlBox pot 1:  " + getPotValue(1));
    	
    	System.out.println("Three position switch status:");
    	System.out.println("\tleft: " + (isSwitchLeft() ? "true":"false"));
    	System.out.println("\tcenter: " + (isSwitchCenter() ? "true":"false"));
		System.out.println("\tright: " + (isSwitchRight() ? "true":"false"));
		*/
    }
    
    /*
    The three position switch on the external control box requires two bits
    The switches are 1 and 2

     1  |  2  | Position
    --------------------
     0     0    Left (or Out for FRC 2017)
     0     1    Center (or Off for FRC 2017)
     1     0    Don't care
     1     1    Right (or IN for FRC 2017)
     */
       
    public Boolean isSwitchLeft() {
    	return( ! isSet(1) && ! isSet(2) );
    }
       
    public Boolean isSwitchCenter() {
    	return( ! isSet(1) &&  isSet(2)) ;
    }
    
    public Boolean isSwitchRight() {
    	return( isSet(1) && isSet(2));
    }
       
    public double getPotValue(int axis) {
    	return controlBox.getRawAxis(axis);
	}
	
	public double getPotValueScaled(int axis, double to_min, double to_max) {
		double from_min = -1.0;
	 	double from_max = 1.0;
		double x;
		double scaled_x = 0.0;
		if( to_max > to_min  && from_max > from_min )
		{
			x =  controlBox.getRawAxis(axis);
			scaled_x = ((x - from_min) * (to_max - to_min)) / 
						(from_max - from_min) +
						to_min;
		}
		return scaled_x;
	}
}


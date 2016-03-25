package org.usfirst.frc.team1517.robot.subsystems;

import org.usfirst.frc.team1517.robot.commands.ShooterKick;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Kicker extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Servo servo;
	
	public Kicker (){
		 super();
		 servo = new Servo(5); 
		 
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
       // setDefaultCommand(new ShooterKick());
    }
    public void log() {}
    //set Servo to 75 degrees
    public void kick() {
       	servo.set(0.3); 
}
    // move Servo to the original position 
    public void takeBack() {
       	servo.set(0.7);
       	
}
}


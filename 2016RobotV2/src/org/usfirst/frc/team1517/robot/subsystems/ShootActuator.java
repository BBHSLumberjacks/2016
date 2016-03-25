/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team1517.robot.subsystems;

import org.usfirst.frc.team1517.robot.commands.SAUp;
import org.usfirst.frc.team1517.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *  
 */
public class ShootActuator extends Subsystem {
    private SpeedController motor;
   private DigitalInput contact;

    public ShootActuator() {
        super();
        motor = new Victor(4);
        // limit switch 
       contact = new DigitalInput(6);
		// Let's show everything on the LiveWindow
        LiveWindow.addActuator("Claw", "Motor", (Victor) motor);
      
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new SAUp());
    }
    public void log() {}
    
    /**
     * up 
     */
    public void up(double speed) {
		motor.set(speed);
	}
    
    public void up(Joystick scoreStick) {
    //    up(scoreStick.getRawAxis(1));
       double a=0; 
       double x= scoreStick.getRawAxis(5);  
        up(a*(x*x*x) + x*(1-a)); 
    }
    public void Up() {
       motor.set(0.5); 
        }
    /**
     * down
     */
//    public void down() {
//        motor.set(1);
//    }
//    
//    /**
//     * don't move 
//     */

    public void stop() {
        motor.set(0);
    }
    
    /**
     * Return true when the robot is grabbing an object hard enough
     * to trigger the limit switch.
     */
    public boolean isGrabbing() {
    	return !contact.get();
    	
    }
   
}

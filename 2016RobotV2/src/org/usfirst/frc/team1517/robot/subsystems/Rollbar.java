/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team1517.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The claw subsystem is a simple system with a motor for opening and closing.
 * If using stronger motors, you should probably use a sensor so that the
 * motors don't stall. 
 */
public class Rollbar extends Subsystem {
    private SpeedController motor;
  

    public Rollbar() {
        super();
        motor = new Victor(8);
        

		// Let's show everything on the LiveWindow
        LiveWindow.addActuator("Claw", "Motor", (Victor) motor);
       
    }

    public void initDefaultCommand() {}
    public void log() {}
    
    /**
     * shoot
     */
    public void shoot() {
        motor.set(-1);
    }

    /**
     * take in 
     */
    public void takein() {
        motor.set(1);
    }
    
    /**
     * dont move 
     */
    public void stop() {
        motor.set(0);
    }
    
   
}

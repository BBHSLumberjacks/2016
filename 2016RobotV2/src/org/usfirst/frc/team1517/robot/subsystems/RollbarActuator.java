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
public class RollbarActuator extends Subsystem {
    private SpeedController motor;
    

    public RollbarActuator() {
        super();
        motor = new Victor(7);
        

		// Let's show everything on the LiveWindow
        LiveWindow.addActuator("Claw", "Motor", (Victor) motor);
        
    }

    public void initDefaultCommand() {}
    public void log() {}
    
    /**
     * up
     */
    public void up() {
        motor.set(-1);
    }

    /**
     *  down 
     */
    public void down() {
        motor.set(1);
    }
    
    /**
     * don't move 
     */
    public void stop() {
        motor.set(0);
    }
    
   
}

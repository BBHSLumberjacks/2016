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
 * The Hook subsystem uses a single motor which is controlled by  
 *  a Talon and an encoder can be mounted if needed  
 */
public class Hook extends Subsystem {
    private SpeedController motor;
    

    public Hook() {
        super();
        motor = new Victor(3);
       

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
     * down
     */
    public void down() {
        motor.set(1);
    }
    
    /**
     * dont move 
     */
    public void stop() {
        motor.set(0);
    }
    
   
}

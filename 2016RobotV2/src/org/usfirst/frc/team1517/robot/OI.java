
package org.usfirst.frc.team1517.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1517.robot.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Binds the physical buttons and the commands 
 * so it is the class which will let the driver 
 * control the robot 
 */
public class OI {
  // Initialize JoySticks here 
	private Joystick joy = new Joystick(0);
    private Joystick ScoreStick = new Joystick(1);

    public OI() {
    	// Put important info on the smart DashBoard 
        
        SmartDashboard.putData("Auto", new Autonomous());
        
        // Create buttons
        JoystickButton d_up = new JoystickButton(joy, 5);
        JoystickButton d_right= new JoystickButton(joy, 6);
        JoystickButton d_down= new JoystickButton(joy, 7);
        JoystickButton d_left = new JoystickButton(joy, 8);
        JoystickButton l2 = new JoystickButton(joy, 9);
        JoystickButton r2 = new JoystickButton(joy, 10);
        JoystickButton l1 = new JoystickButton(joy, 11);
        JoystickButton r1 = new JoystickButton(joy, 12);
        JoystickButton a = new JoystickButton(ScoreStick, 1);
        JoystickButton b = new JoystickButton(ScoreStick, 2);
        JoystickButton y = new JoystickButton(ScoreStick, 4);
        JoystickButton c = new JoystickButton(ScoreStick, 5);
        JoystickButton d = new JoystickButton(ScoreStick, 6);
        // Connect the buttons to commands
        d_up.whenPressed(new ShooterShoot());
        //d_down.whenPressed(new ShooterTakein());
        d_right.whenPressed(new Hook());
        d_left.whenPressed(new HookUp());
        b.whenPressed(new AutoUp());
        r1.whenPressed(new RAUp());
        r2.whenPressed(new RADown());
        l1.whenPressed(new RollbarShoot());
        l2.whenPressed(new Autonomous());
        a.whenPressed(new KickerGroup());
        c.whenPressed(new HookUp());
        d.whenPressed(new Hook());
        
        
    }
  // Create methods which will let the JoySticks to be used in 
  // other classes
    
    public Joystick getJoystick() {
        return joy;
    }
    public Joystick scoreStick(){
    	return  ScoreStick; 
    }
}


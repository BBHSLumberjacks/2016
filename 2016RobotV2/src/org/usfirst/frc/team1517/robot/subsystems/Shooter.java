/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team1517.robot.subsystems;

import org.usfirst.frc.team1517.robot.Robot;
import org.usfirst.frc.team1517.robot.commands.ShooterShoot;
//import org.usfirst.frc.team1517.robot.commands.ShooterTakein;
import org.usfirst.frc.team1517.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The claw subsystem is a simple system with a motor for opening and closing.
 * If using stronger motors, you should probably use a sensor so that the
 * motors don't stall. 
 */
public class Shooter extends Subsystem {
    private SpeedController motor;
//    private DigitalInput contact;
    private Encoder shoot_encoder;   
     
    public Shooter() {
        super();
        motor = new TalonSRX(1);
        shoot_encoder = new Encoder(8,9); 
        
        
        if (Robot.isReal()) {
			shoot_encoder.setDistancePerPulse(0.042);
			
		} else {
			// Circumference in ft = 4in/12(in/ft)*PI
			shoot_encoder.setDistancePerPulse((4/12.0*Math.PI) / 250.0);
			
		}

		// Let's show everything on the LiveWindow
        LiveWindow.addActuator("Claw", "Motor", (Talon) motor);
        LiveWindow.addSensor("Shooter", "Shoot Encoder", shoot_encoder);
//        LiveWindow.addActuator("Claw", "Limit Switch", contact);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterShoot());
    }
    public void log() {
    	SmartDashboard.putNumber("Shooter Speed", 0 - shoot_encoder.getRate());
    	
    }
    
    
    public void shoot(double speed) {
		motor.set(speed);
	}
//    public void takeIn(double speed) {
//		motor.set(speed);
//	}
    /**
     * shoot
     */
    public void shoot(Joystick ScoreStick) {
           	shoot(-ScoreStick.getRawAxis(1));
    }
//    public void takeIn(Joystick ScoreStick) {
//       	shoot(-ScoreStick.getRawAxis(2));
//}
    /**
     * take in 
     */
//    public void takein(Joystick scoreStick) {
//        motor.set(-scoreStick.getRawAxis(2));
//    }
//    
    public void up() {
       	motor.set(1);
}
    /**
     * dont move 
     */
    public void stop() {
        motor.set(0);
    }
    public void speedController(double targetRate){
		 double ShootorRate = 0-shoot_encoder.getRate(); 
			
			if(ShootorRate < targetRate){
				motor.set(1);
			}
			else{
				motor.set(.3);
			}	  
	  }  
	  public void autoUp(){
		  speedController(63); 
	  }
}

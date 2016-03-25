/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team1517.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1517.robot.Robot;

/**
 * Allows the shooter to shoot 
 */
public class ShooterShoot extends Command {
    
    public ShooterShoot() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 Robot.shooter.shoot(Robot.oi.scoreStick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.shooter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //end();
    	Robot.shooter.stop();
    }
}

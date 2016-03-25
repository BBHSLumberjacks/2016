/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team1517.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1517.robot.Robot;

/**
 * Put shooter in the up position 
 */
public class SAUp extends Command {
    
    public SAUp() {
        requires(Robot.SA);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
  
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.SA.up(Robot.oi.scoreStick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.SA.isGrabbing();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.SA.stop(); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}

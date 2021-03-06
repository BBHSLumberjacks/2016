/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team1517.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1517.robot.Robot;

/**
 * Sets the rollbar in the Down position 
 */
public class RADown extends Command {
    
    public RADown() {
        requires(Robot.RA);
        setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.RA.down();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.RA.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}

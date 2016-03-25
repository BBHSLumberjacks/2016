package org.usfirst.frc.team1517.robot.commands;

import org.usfirst.frc.team1517.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBack extends Command {

	private double driveForwardSpeed;
	private double distance;
	private double error;
	private final double TOLERANCE = .1;
	private final double KP = -1.0 / 5.0;
	
	
	public DriveBack(double dist, double maxSpeed) {
		requires(Robot.drivetrain);
		distance = dist;
		driveForwardSpeed = maxSpeed;
	}

	protected void initialize() {
		Robot.drivetrain.getRightEncoder().reset();
		Robot.drivetrain.getLeftEncoder().reset(); 
		// setTimeout(2);
	}

	protected void execute() {
		error = (distance - -Robot.drivetrain.getDistance());
		if (driveForwardSpeed * KP * error >= driveForwardSpeed) {
			Robot.drivetrain.drive(driveForwardSpeed, driveForwardSpeed);
		} else {
			Robot.drivetrain.drive(driveForwardSpeed * KP * error,
					-driveForwardSpeed * KP * error);
		}
	}

	protected boolean isFinished() {
		return (Math.abs(error) <= TOLERANCE); //|| isTimedOut();
	}

	protected void end() {
		//Robot.drivetrain.stop();
		Robot.drivetrain.drive(0, 0);
	}

	protected void interrupted() {
		end();
	}
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1517.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1517.robot.commands.Autonomous;
import org.usfirst.frc.team1517.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1517.robot.subsystems.Hook;
import org.usfirst.frc.team1517.robot.subsystems.Kicker;
import org.usfirst.frc.team1517.robot.subsystems.Rollbar;
import org.usfirst.frc.team1517.robot.subsystems.RollbarActuator;
import org.usfirst.frc.team1517.robot.subsystems.ShootActuator;
import org.usfirst.frc.team1517.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main class
 * Class which automatically runs at the start of the program 
 */
public class Robot extends IterativeRobot {
    Command autonomousCommand;
    
    public static DriveTrain drivetrain;
    public static Hook hook;
    public static Rollbar rollbar;
    public static RollbarActuator RA;
    public static ShootActuator SA;
    public static Shooter shooter;
    public static Kicker kick; 
    public static OI oi;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize all subsystems
        drivetrain = new DriveTrain();
        rollbar = new Rollbar();
        hook = new Hook();
        RA = new RollbarActuator();
        SA = new ShootActuator();
        shooter = new Shooter(); 
        kick = new Kicker(); 
        oi = new OI();
        CameraServer server = CameraServer.getInstance(); 
        server.setQuality(50); 
        server.startAutomaticCapture("cam0");
        
        // command used for the autonomous period
        autonomousCommand = new Autonomous();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(drivetrain);
        SmartDashboard.putData(rollbar);
        SmartDashboard.putData(hook);
        SmartDashboard.putData(RA);
        SmartDashboard.putData(SA);
        SmartDashboard.putData(shooter);
        SmartDashboard.putData(kick);
    }

    public void autonomousInit() {
        autonomousCommand.start(); // schedule the autonomous command 
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
    	// Start Teleop
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
    private void log() {
        hook.log();
        rollbar.log();
        drivetrain.log();
        RA.log();
        SA.log();
        shooter.log();
        kick.log(); 
    }
}

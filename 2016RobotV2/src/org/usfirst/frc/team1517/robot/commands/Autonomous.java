
package org.usfirst.frc.team1517.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The main autonomous command 
 */
public class Autonomous extends CommandGroup {
    public Autonomous() {
    // Add commands which will run in autonomous 
    	
    	addSequential(new DriveStraight(4));
    }
}

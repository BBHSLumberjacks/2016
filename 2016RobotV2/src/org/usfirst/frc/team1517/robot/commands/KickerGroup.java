package org.usfirst.frc.team1517.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class KickerGroup extends CommandGroup {
    
    public  KickerGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
       addSequential(new ShooterKick()); 
       addSequential(new ShooterTakeBack());
       
    }
}

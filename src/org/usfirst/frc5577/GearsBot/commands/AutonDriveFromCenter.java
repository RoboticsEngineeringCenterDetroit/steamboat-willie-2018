// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5577.GearsBot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonDriveFromCenter extends CommandGroup {
    
	private String gameData;
	
    public  AutonDriveFromCenter() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	gameData = DriverStation.getInstance().getGameSpecificMessage();

    	// Robot is in center of starting zone
    	if(gameData.charAt(0) == 'L') { 
    		addSequential(new DriveForward(5));
    		addSequential(new Turn(-90));
    		addSequential(new DriveForward(6));
    		addSequential(new Turn(90));
    		addSequential(new DriveForward(3));
    		//TODO Drop Cube
        } else {
        	addSequential(new DriveForward(5));
            addSequential(new Turn(90));
           	addSequential(new DriveForward(4));
            addSequential(new Turn(-90));
            addSequential(new DriveForward(3));
            //TODO Drop Cube
    	}
        
//    	addSequential(new BackUp(0.5, 0.5));
    }  
    
}

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
import org.usfirst.frc5577.GearsBot.Robot;
import org.usfirst.frc5577.GearsBot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {
	
	double speed = 0.75;
    double distanceInInches = 24;
    double time = 0.5;
    
    public DriveForward() {
        requires(Robot.driveTrain);		 
    }
    
//    public DriveForward(double speed) {
//    	this();
//    	this.speed = speed;
//    }
    
    public DriveForward(double distanceInFeet) {
    	this();
    	this.distanceInInches = 12 * distanceInFeet;
    }
    
    public DriveForward(double speed, double time) {
    	this();
    	this.speed = speed;
    	this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	setTimeout(time); //Or change back to 5 if something goes wrong
    	RobotMap.leftWheelEncoder.reset();
    	RobotMap.rightWheelEncoder.reset();    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.driveTrain.driveTrainForwardWithDistance(distance);
    	Robot.driveTrain.driveTrainFoward(-speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println("Right wheel encoder count: " + RobotMap.rightWheelEncoder.get());
        System.out.println("Right wheel encoder distance traveled: " + RobotMap.rightWheelEncoder.getDistance() / 12);
    	
    	if(RobotMap.rightWheelEncoder.getDistance() >= this.distanceInInches) {
    		System.out.println("Finished the command!");
    		return true;
    	}
    	return false;
//    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.climbingArm.disable();
    	Robot.driveTrain.stop(); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5577.GearsBot;

import org.usfirst.frc5577.GearsBot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public final double ANGLE_MOTOR_SPEED = 0.5;
	public final double SHOOTER_GATE_POSITION = 0.5;
	
	public final int A_BUTTON = 1;
	public final int B_BUTTON = 2;
	public final int X_BUTTON = 3;
	public final int Y_BUTTON = 4;
	public final int L_BUMPER = 5;
	public final int R_BUMPER = 6;
	public final int BACK_BUTTON = 7;
	public final int START_BUTTON = 8;
	public final int LEFT_STICK_BUTTON = 9;
	public final int RIGHT_STICK_BUTTON = 10;
	
	public final int LEFT_AXIS_X = 0;
	public final int LEFT_AXIS_Y = 1;
	public final int LEFT_TRIGGER_AXIS = 2;
	public final int RIGHT_TRIGGER_AXIS = 3;
	public final int RIGHT_AXIS_X = 4;
	public final int RIGHT_AXIS_Y = 5;
	public final int DPAD_AXIS = 6;
 
    public Joystick driverController = new Joystick(0); //This is for xbox controller one or player one
    public Joystick manipulatorController; //This is for xbox controller two or player two
    
    public static OI instance;
    
    public static OI GetInstance() {
    	if (instance == null) {
    		instance = new OI();
    	}
    	return instance;
    }

    public Joystick getJoystick() {
        return driverController;
    }
    
    // Comment this out for one controller setup
//    public Joystick getManipulatorJoystick() {
//    	return manipulatorCont;
//    }
    
    public OI() {
    	
    	driverController = new Joystick(0);
    	// Comment out the lines below for two controller setup 
//    	Button driveButtonA = new JoystickButton(controller, A_BUTTON);
//    	Button driveButtonB = new JoystickButton(controller, B_BUTTON);
//    	Button xButton = new JoystickButton(controller, X_BUTTON);
//    	Button yButton = new JoystickButton(controller, Y_BUTTON);
    	Button rBumperDriver = new JoystickButton(driverController, R_BUMPER);
//    	Button lBumper = new JoystickButton(controller, L_BUMPER);
//    	Button dPadUp = new JoystickButton(controller, controller.getPOV(0));
//    	Button dPadDown = new JoystickButton(controller, controller.getPOV(180));
//    	Button backButton = new JoystickButton(driveController, BACK_BUTTON);
    	
    	rBumperDriver.whenPressed(new ShiftGear());
    	
    	// Comment out the lines below for one controller setup
    	manipulatorController = new Joystick(1);
    	Button aButton = new JoystickButton(manipulatorController, A_BUTTON);
    	Button bButton = new JoystickButton(manipulatorController, B_BUTTON);
    	Button xButton = new JoystickButton(manipulatorController, X_BUTTON);
    	Button yButton = new JoystickButton(manipulatorController, Y_BUTTON);
    	Button rBumperManipulator = new JoystickButton(manipulatorController, R_BUMPER);	
//    	Button lBumper = new JoystickButton(manipulatorController, L_BUMPER);
//    	Button backButton = new JoystickButton(manipulatorCont, BACK_BUTTON);
//    	Button startButton = new JoystickButton(manipulatorController, START_BUTTON);
//    	Button dPadUp = new JoystickButton(manipulatorCont, manipulatorCont.getPOV(0));
//    	Button dPadDown = new JoystickButton(manipulatorCont, manipulatorCont.getPOV(180));
   
    	xButton.whileHeld(new CollectCube(0.8));
    	xButton.whenReleased(new CollectCube(0));
    	
    	// No reverse refuel! New paddles should allow fuel to go only one direction!
    	bButton.whileHeld(new PlaceCube(0.8));
    	bButton.whenReleased(new PlaceCube(0));
    	
    	aButton.whileHeld(new DownLift(-0.4));
    	aButton.whenReleased(new DownLift(0));
    	
    	yButton.whileHeld(new UpLift(0.4));
    	yButton.whenReleased(new UpLift(0));

//    	lBumper.whileHeld(new Blend(1.0));
//    	lBumper.whenReleased(new Blend(0));
    	
//    	aButton.whileHeld(new Blend(-1.0));
//    	aButton.whenReleased(new Blend(0));
    	
    	rBumperManipulator.whenPressed(new ShiftClaw());
    	
//    	backButton.whenPressed(new BackUp(0.5 , 0.5));
//    	startButton.whenPressed(new FlipShooterGate(0.4)); 
    	
//    	driveButtonA.whileHeld(new ButtonDrive(.8));
//    	driveButtonB.whileHeld(new ButtonDrive(-.8));

//        SmartDashboard.putData("DriveWithJoysticks", new DriveWithJoysticks());

        SmartDashboard.putData("Practice Auton Driving Straight", new AutonDriveStraight());
        SmartDashboard.putData("Practice Auton Turning", new AutonTurn());
        SmartDashboard.putData("Practice Auton Shoot Cube", new AutonShootCube());
        SmartDashboard.putData("Practice Auton Driving from Left", new AutonDriveFromLeft());
        SmartDashboard.putData("Practice Auton Driving from Center", new AutonDriveFromCenter());
        SmartDashboard.putData("Practice Auton Driving from Right", new AutonDriveFromRight());
    }
    
}

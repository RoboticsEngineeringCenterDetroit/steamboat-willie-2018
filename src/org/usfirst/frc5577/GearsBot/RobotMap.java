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

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.usfirst.frc5577.GearsBot.subsystems.WheelEncoder;

import com.ctre.phoenix.motorcontrol.can.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static SpeedController driveTrainRightMotor;
	public static SpeedController driveTrainLeftMotor;
	public static DifferentialDrive driveTrainRobotDrive;

	public static TalonSRX talonSRX5;
	public static TalonSRX talonSRX6;
	public static TalonSRX talonSRX7;
	public static TalonSRX talonSRX8;
	public static VictorSPX victorSPX1;
	public static VictorSPX victorSPX2;
	public static VictorSPX victorSPX3;
	public static VictorSPX victorSPX4;
//	public static TalonSRX talonSRX6;

	public static Servo servo;
	public static Compressor compressor;
	public static DoubleSolenoid gas_system;
	public static Encoder leftWheelEncoder;
	public static Encoder rightWheelEncoder;

	static void init() {

		driveTrainLeftMotor = new Spark(0);
		driveTrainRightMotor = new Spark(1);

		driveTrainRobotDrive = new DifferentialDrive(driveTrainLeftMotor, driveTrainRightMotor);

		driveTrainRobotDrive.setSafetyEnabled(true);
		driveTrainRobotDrive.setExpiration(0.1);
		driveTrainRobotDrive.setMaxOutput(1.0);

		talonSRX5 = new TalonSRX(5);
		talonSRX6 = new TalonSRX(6);
	    talonSRX7 = new TalonSRX(7);
		talonSRX8 = new TalonSRX(8);
		// talonSRX6 = new TalonSRX(6);
		victorSPX1 = new VictorSPX(1);
		victorSPX2 = new VictorSPX(2);
		victorSPX3 = new VictorSPX(3);
		victorSPX4 = new VictorSPX(4);

		servo = new Servo(2);

		compressor = new Compressor();
		compressor.setClosedLoopControl(true);

		gas_system = new DoubleSolenoid(0, 1);
		gas_system.set(DoubleSolenoid.Value.kOff);

		leftWheelEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		// leftWheelEncoder = new Encoder(2, 3);
		leftWheelEncoder.setDistancePerPulse(.147);
		leftWheelEncoder.setSamplesToAverage(10);
		leftWheelEncoder.reset();
		rightWheelEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		// rightWheelEncoder = new Encoder(0, 1);
		rightWheelEncoder.setDistancePerPulse(.147);
		rightWheelEncoder.setSamplesToAverage(10);
		rightWheelEncoder.reset();
	}
}

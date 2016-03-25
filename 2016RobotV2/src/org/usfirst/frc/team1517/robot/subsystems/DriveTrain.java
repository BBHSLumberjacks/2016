package org.usfirst.frc.team1517.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team1517.robot.Robot;
import org.usfirst.frc.team1517.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private SpeedController front_left_motor, back_left_motor,
							front_right_motor, back_right_motor;
	private RobotDrive drive;
	public Encoder left_encoder;
	private Encoder right_encoder;
	private AnalogInput rangefinder;
	private AnalogGyro gyro;

	public DriveTrain() {
		super();
		front_left_motor = new CANTalon(0);
		back_left_motor = new CANTalon(2);
		front_right_motor = new CANTalon(6);
		back_right_motor = new CANTalon(3);
		drive = new RobotDrive(front_left_motor, back_left_motor,
							   front_right_motor, back_right_motor);
		left_encoder = new Encoder(0, 1);
		right_encoder = new Encoder(2, 3);

		
		if (Robot.isReal()) {
			left_encoder.setDistancePerPulse(0.042);
			right_encoder.setDistancePerPulse(0.042);
		} else {
			
			left_encoder.setDistancePerPulse((3.5/12.0*Math.PI) / 250.0);
			right_encoder.setDistancePerPulse((3.5/12.0*Math.PI) / 250.0);
		}

		rangefinder = new AnalogInput(6);
		gyro = new AnalogGyro(1);

		// Let's show everything on the LiveWindow
		LiveWindow.addActuator("Drive Train", "Front_Left Motor", (CANTalon) front_left_motor);
		LiveWindow.addActuator("Drive Train", "Back Left Motor", (CANTalon) back_left_motor);
		LiveWindow.addActuator("Drive Train", "Front Right Motor", (CANTalon) front_right_motor);
		LiveWindow.addActuator("Drive Train", "Back Right Motor", (CANTalon) back_right_motor);
		LiveWindow.addSensor("Drive Train", "Left Encoder", left_encoder);
		LiveWindow.addSensor("Drive Train", "Right Encoder", right_encoder);
		LiveWindow.addSensor("Drive Train", "Rangefinder", rangefinder);
		LiveWindow.addSensor("Drive Train", "Gyro", gyro);
	}

	/**
	 * When no other command is running let the operator drive around
	 * using the PS3 joystick.
	 */
	public void initDefaultCommand() {
		setDefaultCommand(new TankDriveWithJoystick());
		
	}

	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
		SmartDashboard.putNumber("Left Distance", left_encoder.getDistance());
		SmartDashboard.putNumber("Right Distance", right_encoder.getDistance());
		SmartDashboard.putNumber("Left Speed", left_encoder.getRate());
		SmartDashboard.putNumber("Right Speed", right_encoder.getRate());
		SmartDashboard.putNumber("Gyro", gyro.getAngle());
	}

	/**
	 * Tank style driving for the DriveTrain.
	 */
	public void drive(double left, double right) {
		drive.tankDrive(left, right);
		//drive.tankDrive(left, right, true);
	}

	/**
	 * @param The xbox controller to drive.
	 */
	public void drive(Joystick joy) {
	//2,3 
		//4,5 
		double x = joy.getRawAxis(1); 
		double y = joy.getRawAxis(5); 
		double a = .7; // a cannot be greater then one 
		drive(a*(x*x*x) + x*(1-a), a*(y*y*y) + (1-a)*y);
			//2,3 
				//4,5
			
		
	}
	
	public void driveStright(){
		drive(1, 1);
	}
	public void driveBack(){
		drive(-1, -1);
	}
	public void driveRight(){
		drive(1, -1);
	}
	public void driveLeft(){
		drive(-1, 1);
	}
	/**
	 * @return The robots heading in degrees.
	 */
	public double getHeading() {
		return gyro.getAngle();
	}

	/**
	 * Reset the robots sensors to the zero states.
	 */
	public void reset() {
		gyro.reset();
		left_encoder.reset();
		right_encoder.reset();
	}

	/**
	 * @return The distance driven (average of left and right encoders).
	 */
	public double getDistance() {
		return (left_encoder.getDistance() + right_encoder.getDistance())/2;
	}

	/**
	 * @return The distance to the obstacle detected by the rangefinder.
	 */
	public double getDistanceToObstacle() {
		
		return rangefinder.getAverageVoltage();
	}
	/**
	 * @return The encoder getting the distance and speed of left side of the drivetrain.
	 */
	public Encoder getLeftEncoder() {
		return left_encoder;
	}

	/**
	 * @return The encoder getting the distance and speed of right side of the drivetrain.
	 */
	public Encoder getRightEncoder() {
		return right_encoder;
	}
}

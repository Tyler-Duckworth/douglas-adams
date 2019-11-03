/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Spark;

import static frc.robot.Constants.DrivetrainConstants.*;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * Subsystem that holds everything for the drivetrain.
 * 
 * Includes: motors and drivetrain methods.
 * 
 * Robot operates off of a Cartesian coordinate system.
 */
public class Drivetrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static SpeedController m_leftFront, m_leftBack, m_rightFront, m_rightBack;
  public static MecanumDrive m_drive;

  public Drivetrain() {
    if(RobotBase.isReal()) {
      m_leftFront = new WPI_TalonSRX(kmLeftFront);
      m_leftBack = new WPI_TalonSRX(kmLeftBack);
      m_rightFront = new WPI_TalonSRX(kmRightFront);
      m_rightBack = new WPI_TalonSRX(kmRightBack);
    } else {
      m_leftFront = new Spark(2);
      m_leftBack = new Spark(3);
      m_rightFront = new Spark(4);
      m_rightBack = new Spark(5);
    }

    m_drive = new MecanumDrive(m_leftFront, m_leftBack, m_rightFront, m_rightBack);
    m_drive.setExpiration(0.1);
    m_drive.setSafetyEnabled(true);
  }


  public void driveCartesian(double xSpeed, double ySpeed, double zRotation) {

    xSpeed = Math.round(xSpeed * 100.0) / 100.0;
    ySpeed = Math.round(ySpeed * 100.0) / 100.0;
    zRotation = Math.round(zRotation * 100.0) / 100.0;

    m_drive.driveCartesian(ySpeed, xSpeed, zRotation);
  }
}

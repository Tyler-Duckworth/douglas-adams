/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mechanisms;

public class Crossbow extends CommandBase {
  private final Mechanisms crossbow;
  private long startTime, length;
  private double speed;
  public Crossbow(Mechanisms _crossbow, double _speed, long _length) {
    crossbow = _crossbow;
    length = _length;
    speed = _speed;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(crossbow);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    crossbow.setCrossbow(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - startTime) >= length;
  }
  
}

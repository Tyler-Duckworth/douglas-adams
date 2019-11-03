/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Mechanisms;

public class PullIntake extends CommandBase {
  private final Mechanisms intake;
  private boolean defaultValue;
  public PullIntake(Mechanisms _intake) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    intake = _intake;
    defaultValue = false;
    addRequirements(intake);
  }

  @Override
  public void initialize() {
    intake.pullIntake(Value.kOff);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if(defaultValue) {
      intake.pullIntake(Value.kForward);
    } else intake.pullIntake(Value.kReverse);

    defaultValue = !defaultValue;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return true;
  }
}

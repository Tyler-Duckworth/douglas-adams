/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalInput;


/**
 * Subsystem with micellaneous parts of the robot.
 * 
 * Mostly 'getters' and 'setters'.
 * 
 * NOTE:
 *  This is just a straight port of the Python code.
 *  If we go back through this looking to optimize it, we will probably remove some of this.
 */
public class Mechanisms extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final Spark crossbow, intake;
  private final DoubleSolenoid gearShift, intakeSolenoid;
  private final DigitalInput stopper;

  public Mechanisms() {
    crossbow = new Spark(0);
    intake = new Spark(1);

    gearShift = new DoubleSolenoid(0, 1);
    intakeSolenoid = new DoubleSolenoid(2, 3);

    stopper = new DigitalInput(0);
  }

  public void setCrossbow(double speed) {
    crossbow.set(speed);
  }

  public void setIntake(double speed) {
    intake.set(speed);
  }

  public void pullIntake(Value value) {
    intakeSolenoid.set(value);
  }

  public void shiftGears(Value value) {
    gearShift.set(value);
  }

  public double getCrossbow() {
    return crossbow.get();
  }

  public boolean getStopper() {
    boolean prevState = stopper.get();
    return !prevState;
  }

  // @Override
  // public void initDefaultCommand() {
  //   // Set the default command for a subsystem here.
  //   // setDefaultCommand(new MySpecialCommand());
  // }
}

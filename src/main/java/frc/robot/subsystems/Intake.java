// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  CANSparkMax intakeMotor;

  /** Creates a new Intake. */
  public Intake() {
    intakeMotor = new CANSparkMax(4, MotorType.kBrushless);
    intakeMotor.setIdleMode(IdleMode.kCoast);
  }

  public void intake(double power) {
    intakeMotor.set(-power);
  }

  public void eject(double power) {
    intakeMotor.set(power);
  }

  public void stop() {
    intakeMotor.set(0);
  }

  public boolean intakeAutoDone() {
    if (intakeMotor.getEncoder().getPosition() <= -20) {
      return true;
    }
    return false;
  }

  public boolean outakeAutoDone() {
    if (intakeMotor.getEncoder().getPosition() >= 40) {
      return true;
    }
    return false;
  }

  public void resetIntakeEncoder() {
    intakeMotor.getEncoder().setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

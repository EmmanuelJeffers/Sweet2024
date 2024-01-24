package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;

public class Limelight extends SubsystemBase {
  /** Creates a new Limelight. */
  public Limelight() {
    LimelightHelpers.setLEDMode_PipelineControl("limelight");
    LimelightHelpers.setLEDMode_ForceOn("limelight");
    LimelightHelpers.setCropWindow("", -1, 1, -1, 1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("tX", LimelightHelpers.getTX("limelight"));
    SmartDashboard.putNumber("tY", LimelightHelpers.getTY("limelight"));
    SmartDashboard.putNumber("tA", LimelightHelpers.getTA("limelight"));
  }
}
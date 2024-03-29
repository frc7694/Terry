package frc.robot.subsystems;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.systems.Orangutan;
import frc.robot.values.Constants.DriveConstants;

public class OdometrySubsystem extends SubsystemBase {

    private SwerveDrivePoseEstimator m_poseEstimator;

    public void init() {
        m_poseEstimator =
        new SwerveDrivePoseEstimator(
                DriveConstants.kDriveKinematics,
                Orangutan.get2D(),
                RobotContainer.m_robotDrive.getPoses(),
                new Pose2d());
    }

    @Override
    public void periodic() {
        m_poseEstimator.update(
                Orangutan.get2D(),
                RobotContainer.m_robotDrive.getPoses());
    }

    public double getX() {
        return m_poseEstimator.getEstimatedPosition().getX();
    }

    public double getY() {
        return m_poseEstimator.getEstimatedPosition().getY();
    }

    public Pose2d getPose() {
        if (m_poseEstimator == null) return new Pose2d();
        return m_poseEstimator.getEstimatedPosition();
    }

    public void reset() {
        m_poseEstimator.resetPosition(
                Orangutan.get2D(),
                RobotContainer.m_robotDrive.getPoses(),
                new Pose2d());
    }

    public void reset(Pose2d pose) {
        m_poseEstimator.resetPosition(
                Orangutan.get2D(),
                RobotContainer.m_robotDrive.getPoses(),
                pose);
    }

}

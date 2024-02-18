package frc.robot.values;

import edu.wpi.first.math.controller.PIDController;

public class PID {
    public static PIDController autoRotationPID = getAutoRotationPID();
    private static PIDController getAutoRotationPID() {
        PIDController pid = new PIDController(
                Constants.PIDConstants.kDriveRotationP,
                Constants.PIDConstants.kDriveRotationI,
                Constants.PIDConstants.kDriveRotationD);
        pid.setTolerance(Constants.PIDConstants.kDriveRotationT);
        pid.enableContinuousInput(Constants.GyroConstants.kAlsoSS, Constants.GyroConstants.kSS);
        return pid;
    }
    public static PIDController aprilRotationPID = getAutoRotationPID();
    private static PIDController getAprilRotationPID() {
        PIDController pid = new PIDController(
                Constants.PIDConstants.kAprilRotationP,
                Constants.PIDConstants.kAprilRotationI,
                Constants.PIDConstants.kAprilRotationD);
        pid.setTolerance(Constants.PIDConstants.kAprilRotationT);
        pid.enableContinuousInput(Constants.GyroConstants.kAlsoSS, Constants.GyroConstants.kSS);
        return pid;
    }
}

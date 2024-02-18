package frc.robot.semiautodrive.impl.rotation;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI.Controller;
import frc.robot.RobotContainer;
import frc.robot.semiautodrive.RotationController;
import frc.robot.systems.AprilTag;
import frc.robot.values.Constants;
import frc.robot.values.PID;

public class RAprilTag implements RotationController {

    public RAprilTag() {

    }

    @Override
    public void initialize() {
        PID.aprilRotationPID.setSetpoint(0);
    }

    @Override
    public double getR() {
        SmartDashboard.putNumber("err", AprilTag.table.getEntry("tx").getDouble(0));
        return PID.aprilRotationPID.calculate(AprilTag.table.getEntry("tx").getDouble(0));
    }

    @Override
    public boolean isFinished() {
        return Controller.XBox.getYButton();
    }

    @Override
    public void end() {
        RobotContainer.setX();
    }

    @Override
    public String toString() {
        return "APR";
    }

}

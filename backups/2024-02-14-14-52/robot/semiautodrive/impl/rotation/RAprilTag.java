package frc.robot.semiautodrive.impl.rotation;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI.Controller;
import frc.robot.RobotContainer;
import frc.robot.semiautodrive.RotationController;
import frc.robot.systems.AprilTag;
import frc.robot.values.Constants;
import frc.robot.values.Variables;

public class RAprilTag implements RotationController {

    public RAprilTag() {

    }

    @Override
    public void initialize() {
        Variables.rotationPID.setSetpoint(0);
        Variables.rotationPID.setTolerance(.25);
    }

    @Override
    public double getR() {
        SmartDashboard.putNumber("err", AprilTag.table.getEntry("tx").getDouble(0));
        return Variables.rotationPID.calculate(AprilTag.table.getEntry("tx").getDouble(0));
    }

    @Override
    public boolean isFinished() {
        return Variables.rotationPID.atSetpoint() || Controller.XBox.getYButton();
    }

    @Override
    public void end() {
        RobotContainer.setX();
        Variables.rotationPID.setTolerance(Constants.PIDConstants.kDriveRotationT);
    }

}

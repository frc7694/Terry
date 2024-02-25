package frc.robot.semiautodrive.impl.strafe;

import edu.wpi.first.math.MathUtil;
import frc.robot.OI.Controller;
import frc.robot.semiautodrive.StrafeController;
import frc.robot.systems.Orangutan;
import frc.robot.values.Constants.OIConstants;
import frc.robot.values.Variables;

public class XYAprilTag implements StrafeController {
    @Override
    public double getX() {
        Variables.fod = Math.abs(Orangutan.get() - 120) < 1;
        return slow(-MathUtil.applyDeadband(Controller.XBox.getLeftX(), OIConstants.kDriveDeadband));
    }

    @Override
    public double getY() {
        return slow(-MathUtil.applyDeadband(Controller.XBox.getLeftY(), OIConstants.kDriveDeadband));
    }

    public double slow(double in) {
        double slow = (1 - (.5 * Controller.XBox.getLeftTriggerAxis())) * (1 - (.5 * Controller.XBox.getRightTriggerAxis()));
        return slow * in;
    }

}

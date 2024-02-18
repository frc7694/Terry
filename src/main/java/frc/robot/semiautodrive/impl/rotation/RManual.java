package frc.robot.semiautodrive.impl.rotation;

import edu.wpi.first.math.MathUtil;
import frc.robot.OI.Controller;
import frc.robot.semiautodrive.RotationController;
import frc.robot.values.Constants.OIConstants;

public class RManual implements RotationController {
    @Override
    public double getR() {
        return -MathUtil.applyDeadband(Controller.XBox.getRightX(), OIConstants.kDriveDeadband);
    }

    @Override
    public String toString() {
        return "MAN";
    }

}

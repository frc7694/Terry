package frc.robot.semiautodrive.impl.strafe;

import edu.wpi.first.math.MathUtil;
import frc.robot.OI.Controller;
import frc.robot.OI.axis.XBox.JoystickAxis;
import frc.robot.semiautodrive.StrafeController;
import frc.robot.values.Constants.OIConstants;

public class XYManual implements StrafeController {
    @Override
    public double getX() {
        return slow(-MathUtil.applyDeadband(JoystickAxis.LX.getPos(), OIConstants.kDriveDeadband));
    }

    @Override
    public double getY() {
        return slow(-MathUtil.applyDeadband(JoystickAxis.LY.getPos(), OIConstants.kDriveDeadband));
    }

    public double slow(double in) {
        double slow = (1 - (.5 * Controller.XBox.getLeftTriggerAxis())) * (1 - (.5 * Controller.XBox.getRightTriggerAxis()));
        return slow * in;
    }

}

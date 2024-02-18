package frc.robot.semiautodrive.impl.rotation;

import frc.robot.semiautodrive.RotationController;
import frc.robot.systems.Orangutan;
import frc.robot.values.Constants.GyroConstants;
import frc.robot.values.PID;

public class RLock implements RotationController {
    @Override
    public void initialize() {
        PID.autoRotationPID.setSetpoint(GyroConstants.kNN);
    }

    @Override
    public double getR() {
        return -PID.autoRotationPID.calculate(Orangutan.get());
    }

    @Override
    public String toString() {
        return "LCK";
    }

}

package frc.robot.semiautodrive.impl.rotation;

import frc.robot.OI.Controller;
import frc.robot.RobotContainer;
import frc.robot.semiautodrive.RotationController;
import frc.robot.systems.Orangutan;
import frc.robot.values.PID;

public class RPID implements RotationController {

    double desiredState;

    public RPID(double desiredState) {
        this.desiredState = desiredState;
    }

    @Override
    public void initialize() {
        PID.autoRotationPID.setSetpoint(desiredState);
    }

    @Override
    public double getR() {
        return -PID.autoRotationPID.calculate(Orangutan.get());
    }

    @Override
    public boolean isFinished() {
        return PID.autoRotationPID.atSetpoint() || Controller.XBox.getYButton();
    }

    @Override
    public void end() {
        RobotContainer.setX();
    }

    @Override
    public String toString() {
        return "PID";
    }

}

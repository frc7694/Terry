package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.systems.Orangutan;
import frc.robot.RobotContainer;
import frc.robot.values.PID;
import frc.robot.OI.Controller;

public class PIDRotateCommand extends Command {

    double desiredState;

    public PIDRotateCommand(double desiredState) {
        super();
        this.desiredState = desiredState;
    }

    @Override
    public void initialize() {
        PID.autoRotationPID.setSetpoint(desiredState);
        super.initialize();
    }

    @Override
    public void execute() {
        RobotContainer.m_robotDrive.drive(0, 0, -PID.autoRotationPID.calculate(Orangutan.get()), true, true);
    }

    @Override
    public boolean isFinished() {
        return PID.autoRotationPID.atSetpoint() || Controller.XBox.getYButton();
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.setX();
        super.end(interrupted);
    }

}

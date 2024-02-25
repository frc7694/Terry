package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.drive.BrakeCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.semiautodrive.impl.rotation.RLockBack;
import frc.robot.systems.Orangutan;
import frc.robot.values.Variables;

public class RedLeftAutoDrive extends SequentialCommandGroup {
    public RedLeftAutoDrive() {
        addCommands(new InstantCommand(RobotContainer.m_odometry::reset));
        addCommands(new InstantCommand(Orangutan::reset));
        addCommands(new InstantCommand(() -> Variables.fod = true));
        addCommands(new InstantCommand(() -> Orangutan.set(120)));
        addCommands(new InstantCommand(() -> RobotContainer.m_robotSemiAuto.setRotationController(new RLockBack())));
        addCommands(new DriveCommand(.3, 0, RobotContainer.m_robotSemiAuto.getR(), () -> RobotContainer.m_odometry.getX() <= -1.5));
        addCommands(new BrakeCommand(500));
    }
}

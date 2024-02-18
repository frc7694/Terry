package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.drive.BrakeCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.drive.PIDRotateCommand;
import frc.robot.commands.util.InstantNonPhysicalCommand;
import frc.robot.systems.Orangutan;

public class AutoTest extends SequentialCommandGroup {
    public AutoTest() {
        addCommands(new InstantNonPhysicalCommand(Orangutan::reset));
        addCommands(new InstantNonPhysicalCommand(RobotContainer.m_odometry::reset));
        addCommands(new DriveCommand(1, 0, 0, () -> RobotContainer.m_odometry.getX() >= 1));
        addCommands(new BrakeCommand(100));
        addCommands(new PIDRotateCommand(270));
        addCommands(new DriveCommand(-1, 0, 0, () -> RobotContainer.m_odometry.getY() <= -1));
        addCommands(new BrakeCommand(100));
    }
}

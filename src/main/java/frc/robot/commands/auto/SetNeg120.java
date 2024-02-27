package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.systems.Orangutan;

public class SetNeg120 extends SequentialCommandGroup {
    public SetNeg120() {
        addCommands(new InstantCommand(RobotContainer.m_odometry::reset));
        addCommands(new InstantCommand(() -> Orangutan.set(120)));
    }
}

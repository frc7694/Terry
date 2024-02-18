package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.wait.TimeCommand;

public class KickCommand extends SequentialCommandGroup {

    public KickCommand() {
        addCommands(new InstantCommand(RobotContainer.m_pneumatics::kickUp));
        addCommands(new TimeCommand(1000));
        addCommands(new InstantCommand(RobotContainer.m_pneumatics::kickDown));
    }

}

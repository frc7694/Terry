package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.wait.TimeCommand;
import frc.robot.values.Variables;

public class KickCommand extends SequentialCommandGroup {

    public KickCommand() {
        if (Variables.override || (RobotContainer.m_vision.getDistance() < 48 && RobotContainer.m_vision.isSpeaker())) {
            addCommands(new InstantCommand(RobotContainer.m_pneumatics::kickUp));
            addCommands(new TimeCommand(1000));
            addCommands(new InstantCommand(RobotContainer.m_pneumatics::kickDown));
        }
    }

}

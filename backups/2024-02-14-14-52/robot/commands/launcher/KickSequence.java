package frc.robot.commands.launcher;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class KickSequence extends SequentialCommandGroup {

    public KickSequence() {
        addCommands(new KickCommand(true));
        addCommands(new KickCommand(false));
        addCommands(new InstantCommand(RobotContainer.m_launcher::kickStop));
    }

}

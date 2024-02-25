package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.values.Variables;

public class KickCommand extends Command {
    @Override
    public void initialize() {
        if (Variables.override || (RobotContainer.m_vision.getDistance() < 48 && RobotContainer.m_vision.isSpeaker())) {
            (new KickCommandGroup()).schedule();
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

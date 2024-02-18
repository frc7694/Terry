package frc.robot.commands.launcher;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class SpeedCommand extends Command {

    Speed speed;

    public SpeedCommand(Speed speed) {
        super();
        this.speed = speed;
    }

    @Override
    public void initialize() {
        RobotContainer.m_launcher.setSpeed(speed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}

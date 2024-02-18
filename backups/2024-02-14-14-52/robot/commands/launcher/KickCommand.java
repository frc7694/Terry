package frc.robot.commands.launcher;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class KickCommand extends Command {

    long start;
    long length = 10000;
    boolean up = false;

    public KickCommand(boolean up) {
        super();
        this.up = up;
    }

    @Override
    public void initialize() {
        this.start = System.currentTimeMillis();
        super.initialize();
    }

    @Override
    public void execute() {
        if (up) RobotContainer.m_launcher.kickUp();
        else RobotContainer.m_launcher.kickDown();
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - start > length;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }
}

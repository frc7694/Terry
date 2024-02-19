package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.wait.TimeCommand;

public class TimeLimitedCommand extends ParallelDeadlineGroup {
    public TimeLimitedCommand(Command cmd, long limit) {
        super(new TimeCommand(limit), cmd);
    }
}

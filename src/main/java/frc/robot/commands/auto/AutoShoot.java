package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.shooter.KickCommand;
import frc.robot.commands.shooter.KickCommandGroup;
import frc.robot.commands.shooter.Speed;
import frc.robot.commands.shooter.SpeedCommand;
import frc.robot.commands.wait.TimeCommand;

public class AutoShoot extends SequentialCommandGroup {
    public AutoShoot() {
        addCommands(new SpeedCommand(Speed.FULL));
        addCommands(new TimeCommand(500));
        addCommands(new KickCommandGroup());
        addCommands(new SpeedCommand(Speed.OFF));
    }
}

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.wait.FMSTimeCommand;

public class RedLeftAutoShootWaitDrive extends SequentialCommandGroup {
    public RedLeftAutoShootWaitDrive() {
        addCommands(new AutoShoot());
        addCommands(new FMSTimeCommand(4));
        addCommands(new RedLeftAutoDrive());
    }
}

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.wait.FMSTimeCommand;

public class BlueLeftAutoShootWaitDrive extends SequentialCommandGroup {
    public BlueLeftAutoShootWaitDrive() {
        addCommands(new AutoShoot());
        addCommands(new FMSTimeCommand(4));
        addCommands(new BlueLeftAutoDrive());
    }
}

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.wait.FMSTimeCommand;

public class BlueRightAutoShootWaitDrive extends SequentialCommandGroup {
    public BlueRightAutoShootWaitDrive() {
        addCommands(new AutoShoot());
        addCommands(new FMSTimeCommand(4));
        addCommands(new BlueRightAutoDrive());
    }
}

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class BlueRightAutoShootDrive extends SequentialCommandGroup {
    public BlueRightAutoShootDrive() {
        addCommands(new AutoShoot());
        addCommands(new BlueRightAutoDrive());
    }
}

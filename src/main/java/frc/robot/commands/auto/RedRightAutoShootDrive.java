package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class RedRightAutoShootDrive extends SequentialCommandGroup {
    public RedRightAutoShootDrive() {
        addCommands(new AutoShoot());
        addCommands(new RedRightAutoDrive());
    }
}

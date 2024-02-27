package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class BlueLeftAutoShootDrive extends SequentialCommandGroup {
    public BlueLeftAutoShootDrive() {
        addCommands(new AutoShoot());
        addCommands(new BlueLeftAutoDrive());
    }
}

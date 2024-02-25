package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.drive.BrakeCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.semiautodrive.impl.rotation.RLockBack;
import frc.robot.systems.Orangutan;
import frc.robot.values.Variables;

public class RedLeftAutoShootDrive extends SequentialCommandGroup {
    public RedLeftAutoShootDrive() {
        addCommands(new AutoShoot());
        addCommands(new RedLeftAutoDrive());
    }
}

package frc.robot.commands.auto;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.drive.BrakeCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.shooter.KickCommandGroup;
import frc.robot.commands.shooter.Speed;
import frc.robot.commands.shooter.SpeedCommand;
import frc.robot.commands.util.InstantNonPhysicalCommand;
import frc.robot.commands.wait.TimeCommand;
import frc.robot.semiautodrive.impl.rotation.RLockBack;
import frc.robot.systems.Orangutan;
import frc.robot.values.Variables;

public class AutoShootDrive extends SequentialCommandGroup {
    public AutoShootDrive() {
        addCommands(new AutoShoot());
        addCommands(new AutoDrive());
    }
}

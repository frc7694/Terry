package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import java.util.function.BooleanSupplier;

public class SetAngle extends SequentialCommandGroup {

    BooleanSupplier getColor = () -> {
        var alliance = DriverStation.getAlliance();
        if (alliance.isPresent()) {
            return alliance.get() == DriverStation.Alliance.Red;
        }
        return false;
    };

    public SetAngle() {
        addCommands(new InstantCommand(() -> {
            if (getColor.getAsBoolean()) new Set120().schedule();
            else new SetNeg120().schedule();
        }));
    }
}

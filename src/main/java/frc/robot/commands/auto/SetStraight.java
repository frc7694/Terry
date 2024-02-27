package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import java.util.function.BooleanSupplier;

public class SetStraight extends SequentialCommandGroup {

    BooleanSupplier getColor = () -> {
        var alliance = DriverStation.getAlliance();
        if (alliance.isPresent()) {
            return alliance.get() == DriverStation.Alliance.Red;
        }
        return false;
    };

    public SetStraight() {
        addCommands(new InstantCommand(() -> {
            if (getColor.getAsBoolean()) new SetNeg120().schedule();
            else new Set120().schedule();
        }));
    }
}

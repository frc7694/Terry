package frc.robot.commands.wait;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.Command;

public class FMSTimeCommand extends Command {

    double stop;

    public FMSTimeCommand(double stop) {
        super();
        this.stop = stop;
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return DriverStation.getMatchTime() <= stop;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean runsWhenDisabled() {
        return true;
    }
}

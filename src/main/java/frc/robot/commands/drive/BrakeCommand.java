package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.values.Variables;

import java.util.function.BooleanSupplier;

public class BrakeCommand extends Command {

    BooleanSupplier done;
    long start;
    long time;

    public BrakeCommand(BooleanSupplier done) {
        super();
        this.done = done;
    }

    public BrakeCommand(long time) {
        this.time = time;
        this.done = () -> System.currentTimeMillis() - start > time;
    }

    @Override
    public void initialize() {
        Variables.perryIsControllingHimselfAgainOhNo = true;
        this.start = System.currentTimeMillis();
        super.initialize();
    }

    @Override
    public void execute() {
        RobotContainer.m_robotDrive.setX();
    }

    @Override
    public boolean isFinished() {
        return done.getAsBoolean();
    }

    @Override
    public void end(boolean interrupted) {
        Variables.perryIsControllingHimselfAgainOhNo = false;
        super.end(interrupted);
    }

}

package frc.robot.commands.shooter;

import frc.robot.OI.Controller;
import frc.robot.RobotContainer;
import frc.robot.subsystems.VisionSubsystem;
import java.util.function.DoubleSupplier;

public enum Speed {
    OFF(() -> 0),
    INTAKE(() -> -.125),
    AMP(() ->.12),
    SPEAKER(() -> RobotContainer.m_vision.getDistance() < 48 ? (-.025 * RobotContainer.m_vision.getDistance()) + 1.6 : -.125),
    FULL(() -> 1),
    PMANUAL(() -> (Controller.HIDI1.getRawAxis(3) + 1) / 2),
    NMANUAL(() -> -(Controller.HIDI1.getRawAxis(3) + 1) / 2);

    private final DoubleSupplier value;

    public double getValue() {
        return value.getAsDouble();
    }

    Speed(DoubleSupplier value) {
        this.value = value;
    }

}

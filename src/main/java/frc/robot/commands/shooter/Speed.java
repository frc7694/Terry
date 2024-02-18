package frc.robot.commands.shooter;

import frc.robot.systems.AprilTag;

import java.util.function.DoubleSupplier;

public enum Speed {
    OFF(() -> 0),
    INTAKE(() -> -.125),
    AMP(() ->.12),
    SPEAKER(() -> AprilTag.getDistance() < 48 ? (-.025 * AprilTag.getDistance()) + 1.6 : 0),
    FULL(() -> 1);

    private final DoubleSupplier value;

    public double getValue() {
        return value.getAsDouble();
    }

    Speed(DoubleSupplier value) {
        this.value = value;
    }

}

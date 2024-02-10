package frc.robot.commands.shooter;

public enum Speed {
    OFF(0),
    INTAKE(-.125),
    AMP(.12),
    SPEAKER(1);

    public final double value;

    Speed(double value) {
        this.value = value;
    }

}

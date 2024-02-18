package frc.robot.systems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.SPI;

public class Orangutan {

    // Forward: 180
    // Left: 90
    // Right: 270
    // Backward: 360

    private static AHRS gyro;
    private static double offset = 0;

    public static void init() {
        gyro = new AHRS(SPI.Port.kMXP);
    }

    public static void reset() {
        gyro.reset();
        offset = 0;
    }

    public static void set(double offset) {
        Orangutan.offset = offset;
    }

    public static void changeOffsetBy(double delta) {
        offset += delta;
        while (offset < 0) {
            offset += 360;
        }
        offset = offset % 360;
    }

    private static double positive() {
        return gyro.getYaw() + 180;
    }

    public static double get() {
        return positive() - offset;
    }
    public static Rotation2d get2D() {
        return Rotation2d.fromDegrees(get());
    }

    public static boolean is(double desiredPos) {
        return Math.abs(desiredPos % 360 - get() % 360) < .5;
    }

    public static double getRoll() {
        return gyro.getRoll();
    }

    public static double getPitch() {
        return gyro.getPitch();
    }

}

package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.values.Constants.LimeLightConstants;

public class VisionSubsystem extends SubsystemBase {

    public static NetworkTable table;

    public static void init() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    @Override
    public void periodic() {
        table.getEntry("pipeline").setDouble(1);
    }

    public static double getDistance() {
        int tid = (int) table.getEntry("tid").getDouble(-1);
        int ty = (int) table.getEntry("ty").getDouble(0);
        if (tid == -1) return 0;
        double h2 = LimeLightConstants.kAprilTagHeights[tid - 1];
        double angleToGoal = Units.degreesToRadians(LimeLightConstants.kMountPitchDeg + ty);
        double heightToGoal = h2 - LimeLightConstants.kMountHeightIn;
        double distance = heightToGoal / Math.tan(angleToGoal);
        return distance / 2; // idk why but divide it in half
    }

    public static boolean isSpeaker() {
        int tid = (int) table.getEntry("tid").getDouble(-1);
        return tid == 3 || tid == 4 || tid == 7 || tid == 8;
    }

}

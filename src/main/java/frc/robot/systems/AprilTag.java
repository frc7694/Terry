package frc.robot.systems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.values.Constants.LimeLightConstants;

public class AprilTag {

    public static NetworkTable table;

    public static void init() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
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

}

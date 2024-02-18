package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.systems.AprilTag;

public class LightSubsystem extends SubsystemBase {

    Spark blinkin = new Spark(8);

    public void init() {
        if (AprilTag.getDistance() < 48) blinkin.set(.77);
        else if (DriverStation.getAlliance().isEmpty()) blinkin.set(.55);
        else if (DriverStation.getAlliance().equals(DriverStation.Alliance.Red)) blinkin.set(-.73);
        else blinkin.set(-.75);
    }

    @Override
    public void periodic() {
    }


}

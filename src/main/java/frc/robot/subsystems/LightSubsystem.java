package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.systems.AprilTag;
import frc.robot.values.Variables;

public class LightSubsystem extends SubsystemBase {

    Spark blinkin = new Spark(8);

    @Override
    public void periodic() {
        if (Variables.aligned || (AprilTag.getDistance() < 48 && AprilTag.isSpeaker())) blinkin.set(.77);
        else if (DriverStation.getAlliance().isEmpty()) blinkin.set(.55);
        else if (DriverStation.getAlliance().get() == DriverStation.Alliance.Red) blinkin.set(-.39);
        else blinkin.set(-.41);
    }

}

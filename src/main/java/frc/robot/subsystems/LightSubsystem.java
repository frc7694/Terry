package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.shooter.Speed;
import frc.robot.values.Variables;

public class LightSubsystem extends SubsystemBase {

    Spark blinkin = new Spark(8);

    @Override
    public void periodic() {
        if ((Variables.aligned && RobotContainer.m_launcher.getSpeedMode() == Speed.INTAKE) || (VisionSubsystem.getDistance() < 48 && VisionSubsystem.isSpeaker())) blinkin.set(.77);
        else if (DriverStation.getAlliance().isEmpty()) blinkin.set(.55);
        else if (DriverStation.getAlliance().get() == DriverStation.Alliance.Red) blinkin.set(-.39);
        else blinkin.set(-.41);
    }

}

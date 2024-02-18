package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class LightSubsystem extends SubsystemBase {

    public Spark blinkin = new Spark(8);

    @Override
    public void periodic() {
        RobotContainer.m_lights.blinkin.set(.55);
    }
}

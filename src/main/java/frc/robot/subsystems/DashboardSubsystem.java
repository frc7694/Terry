package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.auto.*;
import frc.robot.values.Variables;
import frc.robot.systems.Orangutan;

public class DashboardSubsystem extends SubsystemBase {

    private SendableChooser<Command> m_autoChooser = new SendableChooser<>();

    public DashboardSubsystem() {}

    public void init() {
        m_autoChooser.setDefaultOption("Disabled", new AutoDisabled());
        m_autoChooser.setDefaultOption("Just Shoot", new AutoShoot());
        m_autoChooser.addOption("Center Instant", new AutoShootDrive());
        m_autoChooser.addOption("Center Delay", new AutoShootWaitDrive());
        m_autoChooser.addOption("Blue Right Instant", new BlueRightAutoShootDrive());
        m_autoChooser.addOption("Blue Right Delay", new BlueRightAutoShootWaitDrive());
        m_autoChooser.addOption("Red Right Instant", new RedRightAutoShootDrive());
        m_autoChooser.addOption("Red Right Delay", new RedRightAutoShootWaitDrive());
        m_autoChooser.addOption("Blue Left Instant", new BlueLeftAutoShootDrive());
        m_autoChooser.addOption("Blue Left Delay", new BlueLeftAutoShootWaitDrive());
        m_autoChooser.addOption("Red Left Instant", new RedLeftAutoShootDrive());
        m_autoChooser.addOption("Red Left Delay", new RedLeftAutoShootWaitDrive());
        SmartDashboard.putData(m_autoChooser);
        SmartDashboard.putNumber("Delay", 3);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("nav/yaw", Orangutan.get());
        SmartDashboard.putNumber("nav/pitch", Orangutan.getPitch());
        SmartDashboard.putNumber("nav/roll", Orangutan.getRoll());
        SmartDashboard.putBoolean("fieldOriented", Variables.fod);
        SmartDashboard.putNumber("motorSpeed", RobotContainer.m_launcher.getSpeed());
        SmartDashboard.putNumber("distance", RobotContainer.m_vision.getDistance());
        SmartDashboard.putNumber("posX", RobotContainer.m_odometry.getX());
        SmartDashboard.putNumber("posY", RobotContainer.m_odometry.getY());
        SmartDashboard.putNumber("compressure", RobotContainer.m_pneumatics.getPressure());
        SmartDashboard.putBoolean("limit", RobotContainer.m_climber.getLimit());
        SmartDashboard.putBoolean("override", Variables.override);
        SmartDashboard.putBoolean("aligned", Variables.aligned);
        SmartDashboard.putNumber("fmstime", DriverStation.getMatchTime());
    }

    @Override
    public void simulationPeriodic() {
        SmartDashboard.putNumber("nav/yaw", Orangutan.get());
        SmartDashboard.putNumber("nav/pitch", Orangutan.getPitch());
        SmartDashboard.putNumber("nav/roll", Orangutan.getRoll());
        SmartDashboard.putBoolean("fieldOriented", Variables.fod);
    }

    public Command getAutonomousCommand() {
        return m_autoChooser.getSelected();
    }

    public double getDelay() {
        double value = SmartDashboard.getNumber("Delay", 0);
        return value > 12 ? 5 : value;
    }

}

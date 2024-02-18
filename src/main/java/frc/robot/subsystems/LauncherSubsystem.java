package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI.Controller;
import frc.robot.commands.shooter.Speed;
import frc.robot.values.Constants.LauncherConstants;

public class LauncherSubsystem extends SubsystemBase {

    private Speed speed = Speed.OFF;
    CANSparkMax left = new CANSparkMax(LauncherConstants.kLeftLauncherCanID, CANSparkLowLevel.MotorType.kBrushless);
    CANSparkMax right = new CANSparkMax(LauncherConstants.kRightLauncherCanID, CANSparkLowLevel.MotorType.kBrushless);

    @Override
    public void periodic() {
        double percent = (Controller.HIDI1.getRawAxis(3) + 1) / 2;
        left.set(speed.getValue() * percent);
        right.set(-speed.getValue() * percent);
    }

    public double getSpeed() {
        double percent = (Controller.HIDI1.getRawAxis(3) + 1) / 2;
        return speed.getValue() * percent;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

}

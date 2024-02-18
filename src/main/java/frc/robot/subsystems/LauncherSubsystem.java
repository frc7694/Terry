package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.shooter.Speed;
import frc.robot.values.Constants.LauncherConstants;

public class LauncherSubsystem extends SubsystemBase {

    private Speed speed = Speed.OFF;
    CANSparkMax left = new CANSparkMax(LauncherConstants.kLeftLauncherCanID, CANSparkLowLevel.MotorType.kBrushless);
    CANSparkMax right = new CANSparkMax(LauncherConstants.kRightLauncherCanID, CANSparkLowLevel.MotorType.kBrushless);

    @Override
    public void periodic() {
        left.set(speed.getValue());
        right.set(-speed.getValue());
    }

    public double getSpeed() {
        return speed.getValue();
    }

    public Speed getSpeedMode() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

}

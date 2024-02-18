package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI.Controller;
import frc.robot.commands.launcher.Speed;
import frc.robot.values.Constants.LauncherConstants;

public class LauncherSubsystem extends SubsystemBase {

    private Speed speed = Speed.OFF;
    CANSparkMax left = new CANSparkMax(LauncherConstants.kLeftLauncherCanID, CANSparkLowLevel.MotorType.kBrushless);
    CANSparkMax right = new CANSparkMax(LauncherConstants.kRightLauncherCanID, CANSparkLowLevel.MotorType.kBrushless);
    WPI_VictorSPX kick = new WPI_VictorSPX(LauncherConstants.kLauncherKickCanID);

    public void init() {
        kick.configFactoryDefault();
        kick.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
        double percent = (Controller.HIDI1.getRawAxis(3) + 1) / 2;
        left.set(speed.value * percent);
        right.set(-speed.value * percent);
    }

    public double getSpeed() {
        double percent = (Controller.HIDI1.getRawAxis(3) + 1) / 2;
        return speed.value * percent;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public void kickUp() {
        kick.set(ControlMode.PercentOutput, -1);
    }

    public void kickDown() {
        kick.set(ControlMode.PercentOutput, 1);
    }

    public void kickStop() {
        kick.set(0);
    }

}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI.Controller;
import frc.robot.values.Constants.ClimberConstants;

public class ClimberSusbystem extends SubsystemBase {

    WPI_VictorSPX climber = new WPI_VictorSPX(ClimberConstants.kClimberCanID);

    public void init() {
        climber.configFactoryDefault();
        climber.setNeutralMode(NeutralMode.Brake);
    }

    public void up() {
        climber.set(ControlMode.PercentOutput, .4);
    }

    public void down() {
        climber.set(ControlMode.PercentOutput, -.4);
    }

    public void brake() {
        climber.set(ControlMode.Disabled, 0);
    }

}

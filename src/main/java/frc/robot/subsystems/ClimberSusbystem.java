package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI.Controller;
import frc.robot.values.Constants.ClimberConstants;

public class ClimberSusbystem extends SubsystemBase {

    WPI_VictorSPX climber;
    DigitalInput limit = new DigitalInput(0);
    double speedPercent = 0;

    public void init() {
        climber = new WPI_VictorSPX(ClimberConstants.kClimberCanID);
        climber.configFactoryDefault();
        climber.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
        if (speedPercent < 0 && !getLimit()) stop();
    }

    public void up() {
        climber.set(ControlMode.PercentOutput, 1);
        speedPercent = 1;
    }

    public void down() {
        climber.set(ControlMode.PercentOutput, -1);
        speedPercent = -1;
    }

    public void stop() {
        climber.set(ControlMode.PercentOutput, 0);
        speedPercent = 0;
    }

    public boolean getLimit() {
        return limit.get();
    }

}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI.Controller;
import frc.robot.values.Constants.ClimberConstants;

public class ClimberSusbystem extends SubsystemBase {

    WPI_VictorSPX climber;

    public void init() {
        climber = new WPI_VictorSPX(ClimberConstants.kClimberCanID);
        climber.configFactoryDefault();
        climber.setNeutralMode(NeutralMode.Brake);
    }

    @Override
    public void periodic() {
        climber.set(ControlMode.PercentOutput, Controller.HIDI3.getRawAxis(0));
    }

}

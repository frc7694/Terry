package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticSubsystem extends SubsystemBase {

    public PneumaticSubsystem() {
        compressor.enableAnalog(100, 115);
    }
    Compressor compressor = new Compressor(14, PneumaticsModuleType.REVPH);
    Solenoid kicker = new Solenoid(14, PneumaticsModuleType.REVPH, 0);

    public double getPressure() {
        return compressor.getPressure();
    }

//    public void init() {
////        compressor.enableDigital();
//       try {
//           SmartDashboard.putString("msg", "comp " + compressor.getPressure() + " " + UUID.randomUUID());
//       } catch (Exception e) {
//           SmartDashboard.putString("msg", "comp " + e.getMessage() + " " + UUID.randomUUID());
//       }
//
//
//
//    }

    public void kickUp() {
        kicker.set(true);
    }
    public void kickDown() {
        kicker.set(false);
    }
}

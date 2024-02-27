package frc.robot.OI.button.HID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum BoxButton implements ButtonType {
    ONE(9),
    TWO(10),
    RED(11),
    THREE(12),
    FOUR(13),
    GREEN(14);

    public final int value;

    BoxButton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> controller.getRawButton(input));
    }

}

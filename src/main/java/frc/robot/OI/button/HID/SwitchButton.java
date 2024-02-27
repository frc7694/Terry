package frc.robot.OI.button.HID;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.OI.button.ButtonType;

public enum SwitchButton implements ButtonType {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    public final int value;

    SwitchButton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Trigger getSupplier(XboxController controller, int input) {
        return new Trigger(() -> controller.getRawButton(input));
    }

}

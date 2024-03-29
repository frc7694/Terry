package frc.robot.controls.lists;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.OI.button.ButtonType;
import frc.robot.OI.button.HIDI.PadButton;
import frc.robot.OI.button.HIDI.TransportButton;
import frc.robot.RobotContainer;
import frc.robot.commands.launcher.KickSequence;
import frc.robot.commands.launcher.Speed;
import frc.robot.commands.launcher.SpeedCommand;
import frc.robot.commands.util.InstantNonPhysicalCommand;
import frc.robot.controls.ControlList;
import frc.robot.controls.When;
import frc.robot.OI.Controller;
import frc.robot.OI.button.HID.*;
import frc.robot.semiautodrive.impl.rotation.RAprilTag;

public enum Comp implements ControlList {

    SetX(           Controller.XBox,  ClickableButton.SQUARES, When.WHILE_TRUE, new RunCommand(RobotContainer::setX)),
    XYPanic(        Controller.XBox,  ClickableButton.LSTICK,  When.ON_TRUE,    new InstantNonPhysicalCommand(RobotContainer::panicXY)),
    RPanic(         Controller.XBox,  ClickableButton.RSTICK,  When.ON_TRUE,    new InstantNonPhysicalCommand(RobotContainer::panicR)),
    ToggleFOD(      Controller.XBox,  ClickableButton.B,       When.ON_TRUE,    new InstantNonPhysicalCommand(RobotContainer::toggleFOD)),
    DriverResetFOD( Controller.XBox,  ClickableButton.X,       When.ON_TRUE,    new InstantNonPhysicalCommand(RobotContainer::resetFOD)),
    ResetFOD(       Controller.HIDI1, ClickableButton.LSTICK,  When.ON_TRUE,    new InstantNonPhysicalCommand(RobotContainer::resetFOD)),
    ShooterOff(     Controller.HIDI3, PadButton.P1,            When.ON_TRUE,    new SpeedCommand(Speed.OFF)),
    ShooterIn(      Controller.HIDI3, PadButton.P2,            When.ON_TRUE,    new SpeedCommand(Speed.INTAKE)),
    ShootAmp(       Controller.HIDI3, PadButton.P3,            When.ON_TRUE,    new SpeedCommand(Speed.AMP)),
    ShootSpeaker(   Controller.HIDI3, PadButton.P4,            When.ON_TRUE,    new SpeedCommand(Speed.SPEAKER)),
    AprilLock(      Controller.XBox,  ClickableButton.A,       When.ON_TRUE,    new InstantCommand(() -> RobotContainer.m_robotSemiAuto.setRotationController(new RAprilTag()))),
    ClimbUp(        Controller.HIDI3, TransportButton.FF,      When.ON_TRUE,    new InstantCommand(RobotContainer.m_climber::up)),
    ClimbDown(      Controller.HIDI3, TransportButton.REW,     When.ON_TRUE,    new InstantCommand(RobotContainer.m_climber::down)),
    BrakeUp(        Controller.HIDI3, TransportButton.FF,      When.ON_FALSE,   new InstantCommand(RobotContainer.m_climber::brake)),
    BrakeDown(      Controller.HIDI3, TransportButton.REW,     When.ON_FALSE,   new InstantCommand(RobotContainer.m_climber::brake)),
    Kick(           Controller.HIDI3, TransportButton.REC,     When.ON_TRUE,    new KickSequence());

//    NN(              Controller.XBox, POVButton.NN,            When.ON_TRUE,    new PIDRotateCommand(180)),
//    SS(              Controller.XBox, POVButton.SS,            When.ON_TRUE,    new PIDRotateCommand(360)),
//    EE(              Controller.XBox, POVButton.EE,            When.ON_TRUE,    new PIDRotateCommand(270)),
//    WW(              Controller.XBox, POVButton.WW,            When.ON_TRUE,    new PIDRotateCommand(90));
//    Test(            Controller.BBox, TriggerButton.DOWN,      When.ON_TRUE,    new PIDRotateCommand(90));


    public final XboxController controller;
    public final ButtonType type;
    public final When when;
    public final Command function;

    Comp(XboxController controller, ButtonType type, When when, Command function) {
        this.controller = controller;
        this.type = type;
        this.when = when;
        this.function = function;
    }

    public XboxController getController() {
        return controller;
    }

    public ButtonType getType() {
        return type;
    }

    public When getWhen() {
        return when;
    }

    public Command getFunction() {
        return function;
    }

}

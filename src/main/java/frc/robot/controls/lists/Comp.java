package frc.robot.controls.lists;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.OI.button.ButtonType;
import frc.robot.OI.button.HIDI.KeyButton;
import frc.robot.OI.button.HIDI.PadButton;
import frc.robot.OI.button.HIDI.TransportButton;
import frc.robot.RobotContainer;
import frc.robot.commands.shooter.KickCommand;
import frc.robot.commands.shooter.Speed;
import frc.robot.commands.shooter.SpeedCommand;
import frc.robot.commands.util.InstantNonPhysicalCommand;
import frc.robot.controls.ControlList;
import frc.robot.controls.When;
import frc.robot.OI.Controller;
import frc.robot.OI.button.HID.*;
import frc.robot.semiautodrive.impl.rotation.RAprilTag;
import frc.robot.semiautodrive.impl.rotation.RLock;
import frc.robot.semiautodrive.impl.rotation.RLockBack;
import frc.robot.semiautodrive.impl.rotation.RManual;
import frc.robot.subsystems.SemiAutoSubsystem;
import frc.robot.values.Variables;

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
    ShootFull(      Controller.HIDI3, TransportButton.FF,      When.ON_TRUE,    new SpeedCommand(Speed.FULL)),
    AprilLock(      Controller.XBox,  ClickableButton.A,       When.ON_TRUE,    new InstantCommand(() -> RobotContainer.m_robotSemiAuto.setRotationController(new RAprilTag()))),
    NoAprilLock(    Controller.XBox,  ClickableButton.A,       When.ON_FALSE,   new InstantCommand(() -> RobotContainer.m_robotSemiAuto.setRotationController(new RManual()))),
    LockN(          Controller.XBox,  POVButton.NN,            When.ON_TRUE,    new InstantCommand(() -> RobotContainer.m_robotSemiAuto.setRotationController(new RLock()))),
    LockS(          Controller.XBox,  POVButton.SS,            When.ON_TRUE,    new InstantCommand(() -> RobotContainer.m_robotSemiAuto.setRotationController(new RLockBack()))),
    RManual(        Controller.XBox,  POVButton.WW,            When.ON_TRUE,    new InstantCommand(() -> RobotContainer.m_robotSemiAuto.setRotationController(new RManual()))),
    KickUp(         Controller.HIDI3, TransportButton.SUS,     When.ON_TRUE,    new KickCommand()),
    KickDown(       Controller.HIDI3, TransportButton.REC,     When.ON_TRUE,    new InstantCommand(RobotContainer.m_pneumatics::kickDown)),
    LightUp(        Controller.HIDI1, KeyButton.a_4,           When.ON_TRUE,    new InstantCommand(() -> Variables.aligned = true)),
    LightDown(      Controller.HIDI1, KeyButton.a_4,           When.ON_FALSE,   new InstantCommand(() -> Variables.aligned = false));
//    Compress(      Controller.HIDI1,  KeyButton.c4,            When.ON_TRUE,    new InstantCommand(RobotContainer.m_pneumatics::init));
//    ClimberUp(     );

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

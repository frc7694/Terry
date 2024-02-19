// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.semiautodrive.impl.rotation.RManual;
import frc.robot.semiautodrive.impl.strafe.XYManual;
import frc.robot.subsystems.*;
import frc.robot.controls.ControlList;
import frc.robot.controls.lists.Comp;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.systems.Orangutan;
import frc.robot.values.Variables;

public class RobotContainer {
  public static final DriveSubsystem m_robotDrive = new DriveSubsystem();
  public static final LauncherSubsystem m_launcher = new LauncherSubsystem();
  public static final ClimberSusbystem m_climber = new ClimberSusbystem();
  public static final DashboardSubsystem m_dashboard = new DashboardSubsystem();
  public static final SemiAutoSubsystem m_robotSemiAuto = new SemiAutoSubsystem(new XYManual(), new RManual());
  public static final OdometrySubsystem m_odometry = new OdometrySubsystem();
  public static final PneumaticSubsystem m_pneumatics = new PneumaticSubsystem();
  public static final LightSubsystem m_lights = new LightSubsystem();
  public static final VisionSubsystem m_vision = new VisionSubsystem();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureButtonBindings();

    m_robotDrive.setDefaultCommand(new RunCommand(() -> {
                      if (m_robotSemiAuto.getBrake()) {
                        setX();
                      } else {
                        m_robotDrive.drive(
                                m_robotSemiAuto.getY(),
                                m_robotSemiAuto.getX(),
                                m_robotSemiAuto.getR(),
                                true, true);
                      }
                    }, m_robotDrive));
  }

  private void configureButtonBindings() {
    for (ControlList control : Comp.values()) {
      Trigger button = control.getType().getSupplier(control.getController(), control.getType().getValue());

      switch (control.getWhen()) {
        case ON_TRUE:
          button.onTrue(control.getFunction());
          break;
        case ON_FALSE:
          button.onFalse(control.getFunction());
          break;
        case WHILE_TRUE:
          button.whileTrue(control.getFunction());
          break;
        case WHILE_FALSE:
          button.whileFalse(control.getFunction());
          break;
        case ON_TOGGLE:
          button.onTrue(control.getFunction());
          button.onFalse(control.getFunction());
          break;
      }
    }
  }
  public static void setX() {
    m_robotDrive.setX();
  }

  public static void resetFOD() {
    Orangutan.reset();
  }

  public static void toggleFOD() {
    Variables.fod = !Variables.fod;
  }

  public static void panicXY() {
    m_robotSemiAuto.setStrafeController(new XYManual());
  }

  public static void panicR() {
    m_robotSemiAuto.setRotationController(new RManual());
  }

}

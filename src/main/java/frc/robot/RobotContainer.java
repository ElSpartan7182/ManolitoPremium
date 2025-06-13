// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.Constants.WristConstants;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.ElevatorSubsystem;
import frc.robot.Subsystems.RollerSubsystem;
import frc.robot.Subsystems.WristSubsystem;
import frc.robot.Subsystems.StateMachine2;
import frc.robot.Subsystems.StateMachine2.RobotState;

public class RobotContainer {
private ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
private CommandXboxController controller = new CommandXboxController(0);
private ArmSubsystem armSubsystem = new ArmSubsystem();
private RollerSubsystem rollerSubsystem = new RollerSubsystem();
private WristSubsystem wristSubsystem = new WristSubsystem();
private StateMachine2 states = new StateMachine2(elevatorSubsystem, armSubsystem);


Command ACTIVAR_ELEVADOR_BRAZO = Commands.runOnce(()-> elevatorSubsystem.setPosition(ElevatorConstants.POSITION_1)).alongWith(Commands.runOnce(()->armSubsystem.setPosition(ArmConstants.POSITION_ARRIBA)));
Command DESACTIVAR_ELEVADOR = Commands.runOnce(()-> elevatorSubsystem.setPosition(ElevatorConstants.POSITION_0)).alongWith(Commands.runOnce(()->armSubsystem.setPosition(ArmConstants.POSITION_INICIAL)));
Command ACTIVAR_ROLLERS = Commands.runOnce(()-> rollerSubsystem.setSpeed(0.7));
Command AL_REVES_ROLLERS = Commands.runOnce(()-> rollerSubsystem.setSpeed(-0.7));
Command DESACTIVAR_ROLLERS = Commands.runOnce(()-> rollerSubsystem.setSpeed(0.0));
Command MUNECA_D = Commands.runOnce(()-> wristSubsystem.setPosition(WristConstants.POSITION_1));
Command GIRAR_MUNECA_I = Commands.runOnce(()-> wristSubsystem.setPosition(WristConstants.POSITION_0));

Command SUBIR = Commands.deferredProxy(()->states.tryState(RobotState.SUBIR));
Command BAJAR = Commands.deferredProxy(()->states.tryState(RobotState.BAJAR));
Command ADENTRO = Commands.deferredProxy(()->states.tryState(RobotState.ADENTRO));
Command AFUERA = Commands.deferredProxy(()->states.tryState(RobotState.AFUERA));
Command NONE = Commands.deferredProxy(()->states.tryState(RobotState.NONE));




  public RobotContainer() {
    states.setState(RobotState.NONE);
    
    configureBindings();
  }

  private void configureBindings() {
    controller.povUp().onTrue(SUBIR);
    controller.povDown().onTrue(BAJAR);
    controller.rightTrigger().onTrue(MUNECA_D);
    controller.leftTrigger().onTrue(GIRAR_MUNECA_I);
    controller.x().whileTrue(ACTIVAR_ROLLERS).onFalse(DESACTIVAR_ROLLERS);
    controller.b().whileTrue(AL_REVES_ROLLERS).onFalse(DESACTIVAR_ROLLERS);
    controller.povLeft().onTrue(ADENTRO);
    controller.povRight().onTrue(AFUERA);
    controller.a().onTrue(NONE);

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.*;
import frc.robot.Subsystems.*;
import frc.robot.Subsystems.StateMachine2.RobotState;

public class Arriba extends Command {

    private ElevatorSubsystem elevatorSub;
    private StateMachine2 states   ;
    private ArmSubsystem armsub;
    
    public Arriba(ElevatorSubsystem elevatorSub, StateMachine2 states, ArmSubsystem armsub){
        this.elevatorSub = elevatorSub;
        this.states = states;
        this.armsub = armsub;

        addRequirements(states);

    }

    @Override
    public void initialize(){
        states.setState(RobotState.SUBIR);
        armsub.setPosition(ArmConstants.POSITION_ARRIBA);
        elevatorSub.setPosition(ElevatorConstants.POSITION_1);
    }

    @Override
    public void execute(){
        
    }

    @Override
    public void end(boolean interrupted){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}

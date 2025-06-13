package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.*;
import frc.robot.Subsystems.*;
import frc.robot.Subsystems.StateMachine2.RobotState;

public class Bajar extends Command {

    private ElevatorSubsystem elevatorSub;
    private StateMachine2 states   ;
    private ArmSubsystem armsub;
    
    public Bajar(ElevatorSubsystem elevatorSub, StateMachine2 states, ArmSubsystem armsub){
        this.elevatorSub = elevatorSub;
        this.states = states;
        this.armsub = armsub;

        addRequirements(states);

    }

    @Override
    public void initialize(){
        states.setState(RobotState.BAJAR);
        elevatorSub.setPosition(ElevatorConstants.POSITION_0);
        armsub.setPosition(ArmConstants.POSITION_INICIAL);
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

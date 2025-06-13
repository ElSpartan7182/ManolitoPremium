package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.ElevatorSubsystem;
import frc.robot.Subsystems.StateMachine2;
import frc.robot.Subsystems.StateMachine2.RobotState;

public class None extends Command{
    private ElevatorSubsystem elevatorSub;
    private StateMachine2 states;
    private ArmSubsystem armsub;
    
    public None(ElevatorSubsystem elevatorSub, StateMachine2 states, ArmSubsystem armsub){
        this.elevatorSub = elevatorSub;
        this.states = states;
        this.armsub = armsub;

        addRequirements(states);

    }

    @Override
    public void initialize(){
        states.setState(RobotState.NONE);
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

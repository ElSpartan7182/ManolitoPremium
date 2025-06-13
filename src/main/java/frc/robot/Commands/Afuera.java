package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.ElevatorSubsystem;
import frc.robot.Subsystems.StateMachine2;
import frc.robot.Subsystems.StateMachine2.RobotState;

public class Afuera extends Command{
    private StateMachine2 states;
    private ArmSubsystem armsub;
    
    public Afuera(StateMachine2 states, ArmSubsystem armsub){
        this.states = states;
        this.armsub = armsub;

        addRequirements(states);

    }

    @Override
    public void initialize(){
        states.setState(RobotState.AFUERA);
        armsub.setPosition(ArmConstants.POSITION_ARRIBA);

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

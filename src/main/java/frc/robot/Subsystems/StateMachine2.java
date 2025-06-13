package frc.robot.Subsystems;

import org.opencv.features2d.AffineFeature;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Commands.*;

public class StateMachine2 extends SubsystemBase {

    RobotState actualRobotState;
    
    private ElevatorSubsystem elevatorSub;
    private ArmSubsystem armsub;

    StateMachine2 states;

    public StateMachine2(ElevatorSubsystem elevatorSub, ArmSubsystem armsub){
        this.elevatorSub = elevatorSub;
        this.armsub = armsub;

        states = this;

        setState(RobotState.NONE);
        
    }

    public RobotState getState(){
        return actualRobotState;
    }

    public void setState(RobotState newState){
        actualRobotState = newState;
    }

    public Command tryState(RobotState desiredState){

        switch (desiredState) {
            case NONE:
                switch (actualRobotState){
                    case SUBIR:
                    case BAJAR:
                    case ADENTRO:
                    case AFUERA:
                        return new None(elevatorSub, states, armsub);

                }
                
                break;

            case SUBIR:
                switch (actualRobotState){
                    case NONE:
                    case BAJAR:
                        return new Arriba(elevatorSub, states, armsub);
                }
                break;
            
            case BAJAR:
                switch (actualRobotState){
                    case SUBIR:
                        return new Bajar(elevatorSub, states, armsub);

                }
                break;
            
            case ADENTRO:
                switch (actualRobotState){
                    case AFUERA:
                    case NONE:
                    return new Adentro(elevatorSub, states, armsub);
                }
                break;
            case AFUERA:
                switch (actualRobotState){
                    case NONE:
                    case ADENTRO:
                    case SUBIR:
                    case BAJAR:
                        return new Afuera(states, armsub);
                }


        }



        return Commands.print("El estado estaba malillo :(");
    }

    public enum RobotState {
        NONE,
        SUBIR,
        BAJAR,
        ADENTRO,
        AFUERA
    }


}

package frc.robot.Subsystems;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;

public class ElevatorSubsystem extends SubsystemBase {
    
    private TalonFX m_motor;


    public ElevatorSubsystem(){
        m_motor = new TalonFX(16);
        m_motor.getConfigurator().apply(ElevatorConstants.elevator_config);
     
    }

    public void setPosition(Angle  position){
        m_motor.setControl(new PositionVoltage(position));
    }

}

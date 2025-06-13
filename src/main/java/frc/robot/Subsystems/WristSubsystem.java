package frc.robot.Subsystems;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WristSubsystem extends SubsystemBase {
    
    private TalonFX m_motor;

public WristSubsystem(){
    m_motor = new TalonFX(21);
}
public void setPosition(Angle position){
m_motor.setControl(new PositionVoltage(position));
}
}

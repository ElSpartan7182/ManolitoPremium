package frc.robot.Subsystems;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase{

    private TalonFX m_motor;

    public ArmSubsystem (){
        m_motor = new TalonFX(ArmConstants.ARM_ID);
        m_motor.getConfigurator().apply(ArmConstants.arm_config);
    }

    public void setPosition (Angle position){
    m_motor.setControl(new PositionVoltage(position));
    }
}

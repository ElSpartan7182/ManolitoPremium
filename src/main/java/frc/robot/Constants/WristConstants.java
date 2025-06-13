package frc.robot.Constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public class WristConstants {
    public static final int WRIST_ID = 21; 

    public static TalonFXConfiguration wrist_config = new TalonFXConfiguration();
    
    static {
        wrist_config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        wrist_config.Slot0.kP = 3.5;
        wrist_config.Slot0.kG = 0.3;
        wrist_config.Feedback.SensorToMechanismRatio = 64; 
    }

    public static final Angle POSITION_1 = Units.Rotations.of(0.49);
    public static final Angle POSITION_0 = Units.Rotations.of(0.00);

}

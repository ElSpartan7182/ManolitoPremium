package frc.robot.Constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public class ElevatorConstants {
    public static final int ELEVATOR_ID = 16; 

    public static TalonFXConfiguration elevator_config = new TalonFXConfiguration();
    
    static {
    elevator_config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    elevator_config.Slot0.GravityType = GravityTypeValue.Elevator_Static;
    elevator_config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    elevator_config.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    elevator_config.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Rotations.of(5.0).in(Units.Rotations);
    elevator_config.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    elevator_config.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Rotations.of(0.3).in(Units.Rotations);

    elevator_config.Slot0.kP = 3.0;
    elevator_config.Slot0.kG = 0.3;
    elevator_config.Feedback.SensorToMechanismRatio = 16; 
    }

    public static final Angle POSITION_1 = Units.Rotations.of(4.5);
   public static final Angle POSITION_0 = Units.Rotations.of(0.15);
}

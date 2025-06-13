package frc.robot.Constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;

public class ArmConstants {
   public static final int ARM_ID = 19;
   
   public static TalonFXConfiguration arm_config = new TalonFXConfiguration();

   static {

    arm_config.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    arm_config.Slot0.GravityType = GravityTypeValue.Arm_Cosine;
    arm_config.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    arm_config.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    arm_config.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Rotations.of(0.78).in(Units.Rotations);
    arm_config.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    arm_config.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Rotations.of(0.0).in(Units.Rotations);

    arm_config.Slot0.kP = 25;
    arm_config.Slot0.kG = 0.3;
    arm_config.Feedback.SensorToMechanismRatio = 125;
   }
   public static final Angle POSITION_ARRIBA = Units.Rotations.of(0.65);
   public static final Angle POSITION_INICIAL = Units.Rotations.of(0.20);
   public static final Angle POSITION_ADENTRO = Units.Rotations.of(0.10);
   

}

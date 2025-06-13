package frc.robot.Subsystems;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {
    
    private SparkMax motor;

    public RollerSubsystem(){
        motor = new SparkMax(22, MotorType.kBrushless);
    }

    public void setSpeed (double speed){
    motor.set(speed);
    }
}

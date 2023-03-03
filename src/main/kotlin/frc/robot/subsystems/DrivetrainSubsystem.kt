package frc.robot.subsystems

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode
import com.kauailabs.navx.frc.AHRS
import com.ctre.phoenix.motorcontrol.can.VictorSPX
import edu.wpi.first.math.controller.PIDController
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.robot.constants.DrivetrainConstants
import kotlin.math.*

class DrivetrainSubsystem:  SubsystemBase(){
    val leftMotor = VictorSPX(DrivetrainConstants.leftMotorID)
    val rightMotor = VictorSPX(DrivetrainConstants.rightMotorID)

    fun tankDrivePercent(leftPercentDesired: Double, rightPercentDesired: Double) {
        leftMotor.inverted = true
        rightMotor.inverted = false

        val drivePID = PIDController(
            DrivetrainConstants.drivetrainP,
            DrivetrainConstants.drivetrainI,
            DrivetrainConstants.drivetrainD
        )

        val leftCalculated = drivePID.calculate(leftPercentDesired)
        val rightCalculated = drivePID.calculate(rightPercentDesired)

        leftMotor.set(VictorSPXControlMode.PercentOutput, leftCalculated)
        rightMotor.set(VictorSPXControlMode.PercentOutput, rightCalculated)

    }
}
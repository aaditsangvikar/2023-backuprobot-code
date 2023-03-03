package frc.robot.constants

import com.revrobotics.CANSparkMax
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.math.kinematics.SwerveDriveKinematics
import edu.wpi.first.math.util.Units
import edu.wpi.first.networktables.NetworkTableInstance


object DrivetrainConstants {

    val leftMotorID = 4
    val rightMotorID = 3

    val drivetrainP = 1.0
    val drivetrainI = 0.0
    val drivetrainD = 0.0

}
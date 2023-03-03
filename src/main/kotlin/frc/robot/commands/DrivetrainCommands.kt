package frc.robot.commands

import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystems.DrivetrainSubsystem
import kotlin.math.abs
import kotlin.math.max

class ArcadeDrive(val driveSubsystem: DrivetrainSubsystem, val controller: XboxController) : CommandBase() {
    init {
        addRequirements(driveSubsystem)
    }

    override fun execute() {

        val speed = controller.leftY
        val rotation = if(speed >= 0) -controller.leftX else controller.leftX

        println(speed)
        println(rotation)

        val maximum = max(abs(speed), abs(rotation))
        val total = speed + rotation
        val difference = speed - rotation

        if (speed >= 0) {
            if (rotation >= 0) {
                driveSubsystem.tankDrivePercent(maximum, difference)
            } else {
                driveSubsystem.tankDrivePercent(total, maximum)
            }
        } else {
            if (rotation >= 0) {
                driveSubsystem.tankDrivePercent(total, -1 * maximum)
            } else {
                driveSubsystem.tankDrivePercent(-1 * maximum, difference)
            }
        }

    }

    override fun end(interrupted: Boolean) {
        driveSubsystem.tankDrivePercent(0.0,0.0)
    }

}
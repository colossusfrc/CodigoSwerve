// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.HashMap;

import com.pathplanner.lib.util.PIDConstants;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{

  public static final double ROBOT_MASS = (148 - 20.3) * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
  public static final double MAX_SPEED  = Units.feetToMeters(14.5);
      // Maximum speed of the robot in meters per second, used to limit acceleration.

  public static final class AutonConstants
  {
    public static final PIDConstants TRANSLATION_PID = new PIDConstants(0.7, 0.0, 0.0);
    public static final PIDConstants ANGLE_PID       = new PIDConstants(.4, 0.0, 0.0);

    private static final String[] labels = {
      "bleu 1",
      "bleu 2",
      "bleu 3",
      "rouge 1",
      "rouge 2",
      "rouge 3"
    };
    private static final Pose2d[] initialPositions = {
      new Pose2d(7.6, 2, new Rotation2d(180)),
      new Pose2d(7.6, 4, new Rotation2d(180)),
      new Pose2d(7.6, 6, new Rotation2d(180)),
      new Pose2d(10, 2, new Rotation2d(0)),
      new Pose2d(10, 4, new Rotation2d(0)),
      new Pose2d(10, 6, new Rotation2d(0))
    };

    public static final HashMap<String, Pose2d> initialPositionsByLabels = new HashMap<>();
    static{
      for(int i = 0; i<6; i++)initialPositionsByLabels.put(labels[i], initialPositions[i]); 
    }
  }

  public static final class CameraConstants
  {
    public static final String nome = "limelight-one";

    public static final double kpAim = 0.035;

    public static final double kpRange = 0.01;
  }

  public static final class DrivebaseConstants
  {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static class OperatorConstants
  {
    public static final double integralLimit = 0.3;

    public static double limit = 0.3;
    // Joystick Deadband
    public static final double LEFT_X_DEADBAND  = 0.1;
    public static final double LEFT_Y_DEADBAND  = 0.1;
    public static final double RIGHT_X_DEADBAND = 0.1;
    public static final double TURN_CONSTANT    = 6;
  }
}

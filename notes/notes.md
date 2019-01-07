# Misc notes

2019 is changing from Eclipse to Visual Studio Code (VS Code) and so
we'll have to understand the build and deployment pipeline.

RoboRIO no longer requires silverlight which is a good thing, however,
the documents say that it no longer supports CAN device
status/configuration. The documents online aren't updated with the new
RoboRIO software as of 2019-01-06

* CI/CD workflow in VS Code?
* How to updated CAN devices if RoboRIO doesn't support it?
  * Install the RoboRIO image, then
  * Install the [CTRE Phoenix Lifeboat](https://github.com/CrossTheRoadElec/Phoenix-Documentation#before-you-write-any-software)
* WPILib changes
  * SendableBase was removed - the documentation appears to be wrong. I think it was SensorBase that was removed.
  * SendableBase+ErrorBase is the class in 2019.
  * SensorBase methods are now in SensorUtil
  * WatchDog class added
  * IterativeRobot deprecated, move to TimedRobot
  * CameraServer class moved to a new package - What's the name of the package???
  * JNI classes have been moved to a new package ??
  * WPILib tools are installed in C:\Users\Public\frc2019\tools
  * Shuffleboard is the new display panel, need to read up on this
  * PathWeaver / Pathfinder requires encoders and a gyro to make sense
  * Raspberry Pi OS Image for cameras is available



package frc.robot.values;

import frc.robot.values.Constants.OIConstants;

// like Constants.java but for things that aren't constant
public class Variables {
    public static long autoTime  = 0;
    public static boolean fod = OIConstants.kDefualtFODState;
    // TODO: phase out perryIsControllingHimselfAgainOhNo in favor of the SemiAutoSubsystem
    public static boolean perryIsControllingHimselfAgainOhNo = false;
    public static boolean aligned = false;

}

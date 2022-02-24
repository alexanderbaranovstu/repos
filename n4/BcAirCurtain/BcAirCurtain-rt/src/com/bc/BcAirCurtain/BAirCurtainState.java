package com.bc.BcAirCurtain; 


import javax.baja.sys.*;

/**
 * BOrientation defines a widget's orientation as
 * either horizontal or vertical.
 *
 * @author    Baranov Alex
 * @creation  1 March 21
 * @version   $Revision: 2$ $Date: 3/23/05 11:29:07 AM EST$
 * @since     Baja 1.0
 */
public final class BAirCurtainState
  extends BFrozenEnum
{
  /*-
  
  enum BAirCurtainState
  {
    range
    {
      Alarm,
      ManOff,
      Speed1HeatOff,
      Speed1Heat1,
      Speed2Heat2,
      Speed3Heat3,
      Speed1HeatAuto,
      Speed2HeatAuto,
      Speed3HeatAuto,
      SpeedHeatAuto
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.BcAirCurtain.BAirCurtainState(2460371899)1.0$ @*/
/* Generated Wed Oct 13 14:35:03 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for Alarm. */
  public static final int ALARM = 0;
  /** Ordinal value for ManOff. */
  public static final int MAN_OFF = 1;
  /** Ordinal value for Speed1HeatOff. */
  public static final int SPEED_1HEAT_OFF = 2;
  /** Ordinal value for Speed1Heat1. */
  public static final int SPEED_1HEAT_1 = 3;
  /** Ordinal value for Speed2Heat2. */
  public static final int SPEED_2HEAT_2 = 4;
  /** Ordinal value for Speed3Heat3. */
  public static final int SPEED_3HEAT_3 = 5;
  /** Ordinal value for Speed1HeatAuto. */
  public static final int SPEED_1HEAT_AUTO = 6;
  /** Ordinal value for Speed2HeatAuto. */
  public static final int SPEED_2HEAT_AUTO = 7;
  /** Ordinal value for Speed3HeatAuto. */
  public static final int SPEED_3HEAT_AUTO = 8;
  /** Ordinal value for SpeedHeatAuto. */
  public static final int SPEED_HEAT_AUTO = 9;
  
  /** BAirCurtainState constant for Alarm. */
  public static final BAirCurtainState Alarm = new BAirCurtainState(ALARM);
  /** BAirCurtainState constant for ManOff. */
  public static final BAirCurtainState ManOff = new BAirCurtainState(MAN_OFF);
  /** BAirCurtainState constant for Speed1HeatOff. */
  public static final BAirCurtainState Speed1HeatOff = new BAirCurtainState(SPEED_1HEAT_OFF);
  /** BAirCurtainState constant for Speed1Heat1. */
  public static final BAirCurtainState Speed1Heat1 = new BAirCurtainState(SPEED_1HEAT_1);
  /** BAirCurtainState constant for Speed2Heat2. */
  public static final BAirCurtainState Speed2Heat2 = new BAirCurtainState(SPEED_2HEAT_2);
  /** BAirCurtainState constant for Speed3Heat3. */
  public static final BAirCurtainState Speed3Heat3 = new BAirCurtainState(SPEED_3HEAT_3);
  /** BAirCurtainState constant for Speed1HeatAuto. */
  public static final BAirCurtainState Speed1HeatAuto = new BAirCurtainState(SPEED_1HEAT_AUTO);
  /** BAirCurtainState constant for Speed2HeatAuto. */
  public static final BAirCurtainState Speed2HeatAuto = new BAirCurtainState(SPEED_2HEAT_AUTO);
  /** BAirCurtainState constant for Speed3HeatAuto. */
  public static final BAirCurtainState Speed3HeatAuto = new BAirCurtainState(SPEED_3HEAT_AUTO);
  /** BAirCurtainState constant for SpeedHeatAuto. */
  public static final BAirCurtainState SpeedHeatAuto = new BAirCurtainState(SPEED_HEAT_AUTO);
  
  /** Factory method with ordinal. */
  public static BAirCurtainState make(int ordinal)
  {
    return (BAirCurtainState)Alarm.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BAirCurtainState make(String tag)
  {
    return (BAirCurtainState)Alarm.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BAirCurtainState(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BAirCurtainState DEFAULT = Alarm;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAirCurtainState.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



  
}

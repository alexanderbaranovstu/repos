package com.bc.ahu; 


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
public final class BAhuState
  extends BFrozenEnum
{
  /*-
  
  enum BAhuState
  {
    range
    {
      AlarmRw,
      Alarm,
      Standby,
      On
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.BcAirCurtain.BAhuState(251094702)1.0$ @*/
/* Generated Wed Oct 20 06:11:27 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for AlarmRw. */
  public static final int ALARM_RW = 0;
  /** Ordinal value for Alarm. */
  public static final int ALARM = 1;
  /** Ordinal value for Standby. */
  public static final int STANDBY = 2;
  /** Ordinal value for On. */
  public static final int ON = 3;
  
  /** BAhuState constant for AlarmRw. */
  public static final BAhuState AlarmRw = new BAhuState(ALARM_RW);
  /** BAhuState constant for Alarm. */
  public static final BAhuState Alarm = new BAhuState(ALARM);
  /** BAhuState constant for Standby. */
  public static final BAhuState Standby = new BAhuState(STANDBY);
  /** BAhuState constant for On. */
  public static final BAhuState On = new BAhuState(ON);
  
  /** Factory method with ordinal. */
  public static BAhuState make(int ordinal)
  {
    return (BAhuState)AlarmRw.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BAhuState make(String tag)
  {
    return (BAhuState)AlarmRw.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BAhuState(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BAhuState DEFAULT = AlarmRw;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAhuState.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



  
}

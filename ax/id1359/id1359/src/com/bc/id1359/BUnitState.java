package com.bc.id1359; 


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
public final class BUnitState
  extends BFrozenEnum
{
  /*-
  
  enum BUnitState
  {
    range
    {
      AlarmStandby,
      Off,
      On
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.id1359.BUnitState(1536354886)1.0$ @*/
/* Generated Mon Oct 04 10:57:44 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */
  
  /** Ordinal value for AlarmStandby. */
  public static final int ALARM_STANDBY = 0;
  /** Ordinal value for Off. */
  public static final int OFF = 1;
  /** Ordinal value for On. */
  public static final int ON = 2;
  
  /** BUnitState constant for AlarmStandby. */
  public static final BUnitState AlarmStandby = new BUnitState(ALARM_STANDBY);
  /** BUnitState constant for Off. */
  public static final BUnitState Off = new BUnitState(OFF);
  /** BUnitState constant for On. */
  public static final BUnitState On = new BUnitState(ON);

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUnitState.class);
  
  /** Factory method with ordinal. */
  public static BUnitState make(int ordinal)
  {
    return (BUnitState)AlarmStandby.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BUnitState make(String tag)
  {
    return (BUnitState)AlarmStandby.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BUnitState(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BUnitState DEFAULT = BUnitState.AlarmStandby;

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  
}

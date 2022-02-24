package com.bc.id1348; 


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
public final class BContactorState
  extends BFrozenEnum
{
  /*-
  
  enum BContactorState
  {
    range
    {
      off,
      toOff,
      on,
      toOn,
      alarmFb
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.id1359.BContactorState(4105480748)1.0$ @*/
/* Generated Thu Dec 16 10:47:34 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */
  
  /** Ordinal value for off. */
  public static final int OFF = 0;
  /** Ordinal value for toOff. */
  public static final int TO_OFF = 1;
  /** Ordinal value for on. */
  public static final int ON = 2;
  /** Ordinal value for toOn. */
  public static final int TO_ON = 3;
  /** Ordinal value for alarmFb. */
  public static final int ALARM_FB = 4;
  
  /** BContactorState constant for off. */
  public static final BContactorState off = new BContactorState(OFF);
  /** BContactorState constant for toOff. */
  public static final BContactorState toOff = new BContactorState(TO_OFF);
  /** BContactorState constant for on. */
  public static final BContactorState on = new BContactorState(ON);
  /** BContactorState constant for toOn. */
  public static final BContactorState toOn = new BContactorState(TO_ON);
  /** BContactorState constant for alarmFb. */
  public static final BContactorState alarmFb = new BContactorState(ALARM_FB);

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BContactorState.class);
  
  /** Factory method with ordinal. */
  public static BContactorState make(int ordinal)
  {
    return (BContactorState)off.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BContactorState make(String tag)
  {
    return (BContactorState)off.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BContactorState(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BContactorState DEFAULT = BContactorState.off;

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  
}

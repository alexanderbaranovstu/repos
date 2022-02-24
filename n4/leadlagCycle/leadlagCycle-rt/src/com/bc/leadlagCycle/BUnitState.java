package com.bc.leadlagCycle;  


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
      off,
      toOff,
      on,
      toOn,
      alarm,
      serviceOff
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.leadlag.BUnitState(1120487857)1.0$ @*/
/* Generated Thu Dec 30 12:41:29 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */
  
  /** Ordinal value for off. */
  public static final int OFF = 0;
  /** Ordinal value for toOff. */
  public static final int TO_OFF = 1;
  /** Ordinal value for on. */
  public static final int ON = 2;
  /** Ordinal value for toOn. */
  public static final int TO_ON = 3;
  /** Ordinal value for alarm. */
  public static final int ALARM = 4;
  /** Ordinal value for serviceOff. */
  public static final int SERVICE_OFF = 5;
  
  /** BUnitState constant for off. */
  public static final BUnitState off = new BUnitState(OFF);
  /** BUnitState constant for toOff. */
  public static final BUnitState toOff = new BUnitState(TO_OFF);
  /** BUnitState constant for on. */
  public static final BUnitState on = new BUnitState(ON);
  /** BUnitState constant for toOn. */
  public static final BUnitState toOn = new BUnitState(TO_ON);
  /** BUnitState constant for alarm. */
  public static final BUnitState alarm = new BUnitState(ALARM);
  /** BUnitState constant for serviceOff. */
  public static final BUnitState serviceOff = new BUnitState(SERVICE_OFF);

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUnitState.class);
  
  /** Factory method with ordinal. */
  public static BUnitState make(int ordinal)
  {
    return (BUnitState)off.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BUnitState make(String tag)
  {
    return (BUnitState)off.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BUnitState(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BUnitState DEFAULT = BUnitState.off;

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  
}

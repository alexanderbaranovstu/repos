package com.bc.componentsToAction;  


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
public final class BUState
  extends BFrozenEnum
{
  /*-
  
  enum BUState
  {
    range
    {
      off,
      standby,
      on,
      warning,
      alarm,
      service
    }
  }
  
  -*/

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.componentsToAction.BUState(3455602927)1.0$ @*/
/* Generated Wed Feb 02 17:43:57 MSK 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for off. */
  public static final int OFF = 0;
  /** Ordinal value for standby. */
  public static final int STANDBY = 1;
  /** Ordinal value for on. */
  public static final int ON = 2;
  /** Ordinal value for warning. */
  public static final int WARNING = 3;
  /** Ordinal value for alarm. */
  public static final int ALARM = 4;
  /** Ordinal value for service. */
  public static final int SERVICE = 5;
  
  /** BUState constant for off. */
  public static final BUState off = new BUState(OFF);
  /** BUState constant for standby. */
  public static final BUState standby = new BUState(STANDBY);
  /** BUState constant for on. */
  public static final BUState on = new BUState(ON);
  /** BUState constant for warning. */
  public static final BUState warning = new BUState(WARNING);
  /** BUState constant for alarm. */
  public static final BUState alarm = new BUState(ALARM);
  /** BUState constant for service. */
  public static final BUState service = new BUState(SERVICE);
  
  /** Factory method with ordinal. */
  public static BUState make(int ordinal)
  {
    return (BUState)off.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BUState make(String tag)
  {
    return (BUState)off.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BUState(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BUState DEFAULT = off;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUState.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  
}

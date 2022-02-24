package com.bc.CommonLogic.fcuModule;  


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
public final class BSpeedRange
  extends BFrozenEnum
{
  /*-
  
  enum BFcuState
  {
    range
    {
      coolSpeed3,
      coolSpeed2,
      coolSpeed1,
      stop,
      heatSpeed1,   
      heatSpeed2,
      heatSpeed3
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BSpeedRange(2730705790)1.0$ @*/
/* Generated Mon Mar 01 14:55:47 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for coolSpeed3. */
  public static final int COOL_SPEED_3 = -3;
  /** Ordinal value for coolSpeed2. */
  public static final int COOL_SPEED_2 = -2;
  /** Ordinal value for coolSpeed1. */
  public static final int COOL_SPEED_1 = -1;
  /** Ordinal value for stop. */
  public static final int STOP = 0;
  /** Ordinal value for heatSpeed1. */
  public static final int HEAT_SPEED_1 = 1;
  /** Ordinal value for heatSpeed2. */
  public static final int HEAT_SPEED_2 = 2;
  /** Ordinal value for heatSpeed3. */
  public static final int HEAT_SPEED_3 = 3;
  
  /** BSpeedRange constant for coolSpeed3. */
  public static final BSpeedRange coolSpeed3 = new BSpeedRange(COOL_SPEED_3);
  /** BSpeedRange constant for coolSpeed2. */
  public static final BSpeedRange coolSpeed2 = new BSpeedRange(COOL_SPEED_2);
  /** BSpeedRange constant for coolSpeed1. */
  public static final BSpeedRange coolSpeed1 = new BSpeedRange(COOL_SPEED_1);
  /** BSpeedRange constant for stop. */
  public static final BSpeedRange stop = new BSpeedRange(STOP);
  /** BSpeedRange constant for heatSpeed1. */
  public static final BSpeedRange heatSpeed1 = new BSpeedRange(HEAT_SPEED_1);
  /** BSpeedRange constant for heatSpeed2. */
  public static final BSpeedRange heatSpeed2 = new BSpeedRange(HEAT_SPEED_2);
  /** BSpeedRange constant for heatSpeed3. */
  public static final BSpeedRange heatSpeed3 = new BSpeedRange(HEAT_SPEED_3);
  
  /** Factory method with ordinal. */
  public static BSpeedRange make(int ordinal)
  {
    return (BSpeedRange)coolSpeed3.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BSpeedRange make(String tag)
  {
    return (BSpeedRange)coolSpeed3.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BSpeedRange(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BSpeedRange DEFAULT = coolSpeed3;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpeedRange.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  
}

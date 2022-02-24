package com.bc.fcuModule;  


import javax.baja.sys.*;

/**
 * BOrientation defines a widget's orientation as
 * either horizontal or vertical.
 *
 * @author    Brian Frank
 * @creation  21 Nov 00
 * @version   $Revision: 2$ $Date: 3/23/05 11:29:07 AM EST$
 * @since     Baja 1.0
 */
public final class BFcuState
  extends BFrozenEnum
{
  /*-
  
  enum BFcuState
  {
    range
    {
      Off,
      ManualSpeed1,
      ManualSpeed2,
      ManualSpeed3,
      Auto
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BFcuState(491698212)1.0$ @*/
/* Generated Fri Feb 26 15:41:52 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for Off. */
  public static final int OFF = 0;
  /** Ordinal value for ManualSpeed1. */
  public static final int MANUAL_SPEED_1 = 1;
  /** Ordinal value for ManualSpeed2. */
  public static final int MANUAL_SPEED_2 = 2;
  /** Ordinal value for ManualSpeed3. */
  public static final int MANUAL_SPEED_3 = 3;
  /** Ordinal value for Auto. */
  public static final int AUTO = 4;
  
  /** BFcuState constant for Off. */
  public static final BFcuState Off = new BFcuState(OFF);
  /** BFcuState constant for ManualSpeed1. */
  public static final BFcuState ManualSpeed1 = new BFcuState(MANUAL_SPEED_1);
  /** BFcuState constant for ManualSpeed2. */
  public static final BFcuState ManualSpeed2 = new BFcuState(MANUAL_SPEED_2);
  /** BFcuState constant for ManualSpeed3. */
  public static final BFcuState ManualSpeed3 = new BFcuState(MANUAL_SPEED_3);
  /** BFcuState constant for Auto. */
  public static final BFcuState Auto = new BFcuState(AUTO);
  
  /** Factory method with ordinal. */
  public static BFcuState make(int ordinal)
  {
    return (BFcuState)Off.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BFcuState make(String tag)
  {
    return (BFcuState)Off.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BFcuState(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BFcuState DEFAULT = Off;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFcuState.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
}

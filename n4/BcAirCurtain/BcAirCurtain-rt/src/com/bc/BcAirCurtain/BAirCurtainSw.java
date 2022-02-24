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
public final class BAirCurtainSw
  extends BFrozenEnum
{
  /*-
  
  enum BAirCurtainSw
  {
    range
    {
      SwitchManualOff,
      SwitchManualS1,
      SwitchManualS2,
      SwitchManualS3,
      SwitchAuto
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.BcAirCurtain.BAirCurtainSw(2618744008)1.0$ @*/
/* Generated Thu Oct 14 06:14:42 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for SwitchManualOff. */
  public static final int SWITCH_MANUAL_OFF = 0;
  /** Ordinal value for SwitchManualS1. */
  public static final int SWITCH_MANUAL_S1 = 1;
  /** Ordinal value for SwitchManualS2. */
  public static final int SWITCH_MANUAL_S2 = 2;
  /** Ordinal value for SwitchManualS3. */
  public static final int SWITCH_MANUAL_S3 = 3;
  /** Ordinal value for SwitchAuto. */
  public static final int SWITCH_AUTO = 4;
  
  /** BAirCurtainSw constant for SwitchManualOff. */
  public static final BAirCurtainSw SwitchManualOff = new BAirCurtainSw(SWITCH_MANUAL_OFF);
  /** BAirCurtainSw constant for SwitchManualS1. */
  public static final BAirCurtainSw SwitchManualS1 = new BAirCurtainSw(SWITCH_MANUAL_S1);
  /** BAirCurtainSw constant for SwitchManualS2. */
  public static final BAirCurtainSw SwitchManualS2 = new BAirCurtainSw(SWITCH_MANUAL_S2);
  /** BAirCurtainSw constant for SwitchManualS3. */
  public static final BAirCurtainSw SwitchManualS3 = new BAirCurtainSw(SWITCH_MANUAL_S3);
  /** BAirCurtainSw constant for SwitchAuto. */
  public static final BAirCurtainSw SwitchAuto = new BAirCurtainSw(SWITCH_AUTO);
  
  /** Factory method with ordinal. */
  public static BAirCurtainSw make(int ordinal)
  {
    return (BAirCurtainSw)SwitchManualOff.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BAirCurtainSw make(String tag)
  {
    return (BAirCurtainSw)SwitchManualOff.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BAirCurtainSw(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BAirCurtainSw DEFAULT = SwitchManualOff;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAirCurtainSw.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



  
}

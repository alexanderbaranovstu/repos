package com.bc.fcuModule;  


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
public final class BControlError
  extends BFrozenEnum
{
  /*-
  
  enum BControlError
  {
    range
    {
      Normal,
      Hi,
      Lo
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BControlError(87814406)1.0$ @*/
/* Generated Thu Mar 18 15:08:06 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for Normal. */
  public static final int NORMAL = 0;
  /** Ordinal value for Hi. */
  public static final int HI = 1;
  /** Ordinal value for Lo. */
  public static final int LO = 2;
  
  /** BControlError constant for Normal. */
  public static final BControlError Normal = new BControlError(NORMAL);
  /** BControlError constant for Hi. */
  public static final BControlError Hi = new BControlError(HI);
  /** BControlError constant for Lo. */
  public static final BControlError Lo = new BControlError(LO);
  
  /** Factory method with ordinal. */
  public static BControlError make(int ordinal)
  {
    return (BControlError)Normal.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BControlError make(String tag)
  {
    return (BControlError)Normal.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BControlError(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BControlError DEFAULT = Normal;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BControlError.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

}

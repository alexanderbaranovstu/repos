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
public final class BHc
  extends BFrozenEnum
{
  /*-
  
  enum BHc
  {
    range
    {
      Cool,
      Stop,
      Heat
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BHc(1875563544)1.0$ @*/
/* Generated Mon Mar 15 15:00:56 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for Cool. */
  public static final int COOL = -1;
  /** Ordinal value for Stop. */
  public static final int STOP = 0;
  /** Ordinal value for Heat. */
  public static final int HEAT = 1;
  
  /** BHc constant for Cool. */
  public static final BHc Cool = new BHc(COOL);
  /** BHc constant for Stop. */
  public static final BHc Stop = new BHc(STOP);
  /** BHc constant for Heat. */
  public static final BHc Heat = new BHc(HEAT);
  
  /** Factory method with ordinal. */
  public static BHc make(int ordinal)
  {
    return (BHc)Cool.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BHc make(String tag)
  {
    return (BHc)Cool.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BHc(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BHc DEFAULT = Cool;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BHc.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  
}

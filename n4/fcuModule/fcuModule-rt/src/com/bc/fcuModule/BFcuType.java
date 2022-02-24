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
public final class BFcuType
  extends BFrozenEnum
{
  /*-
  
  enum BFcuType
  {
    range
    {
      TwoPipe,
      FourPipe
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BFcuType(4021930334)1.0$ @*/
/* Generated Tue Apr 06 07:20:19 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for TwoPipe. */
  public static final int TWO_PIPE = 0;
  /** Ordinal value for FourPipe. */
  public static final int FOUR_PIPE = 1;
  
  /** BFcuType constant for TwoPipe. */
  public static final BFcuType TwoPipe = new BFcuType(TWO_PIPE);
  /** BFcuType constant for FourPipe. */
  public static final BFcuType FourPipe = new BFcuType(FOUR_PIPE);
  
  /** Factory method with ordinal. */
  public static BFcuType make(int ordinal)
  {
    return (BFcuType)TwoPipe.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BFcuType make(String tag)
  {
    return (BFcuType)TwoPipe.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BFcuType(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BFcuType DEFAULT = TwoPipe;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFcuType.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

}

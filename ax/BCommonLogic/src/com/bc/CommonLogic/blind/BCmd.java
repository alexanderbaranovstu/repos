package com.bc.CommonLogic.blind;  


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
public final class BCmd
  extends BFrozenEnum
{
  /*-
  
  enum BCmd
  {
    range
    {
      Open,
      Stop,
      Close
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.blind.BCmd(123902162)1.0$ @*/
/* Generated Thu May 13 18:27:17 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */
  
  /** Ordinal value for Open. */
  public static final int OPEN = 1;
  /** Ordinal value for Stop. */
  public static final int STOP = 0;
  /** Ordinal value for Close. */
  public static final int CLOSE = -1;
  
  /** BCmd constant for Open. */
  public static final BCmd Open = new BCmd(OPEN);
  /** BCmd constant for Stop. */
  public static final BCmd Stop = new BCmd(STOP);
  /** BCmd constant for Close. */
  public static final BCmd Close = new BCmd(CLOSE);

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCmd.class);
  
  /** Factory method with ordinal. */
  public static BCmd make(int ordinal)
  {
    return (BCmd)Open.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BCmd make(String tag)
  {
    return (BCmd)Open.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BCmd(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BCmd DEFAULT = BCmd.Stop;

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  
}

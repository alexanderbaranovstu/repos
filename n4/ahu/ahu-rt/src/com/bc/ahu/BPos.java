package com.bc.ahu; 


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
public final class BPos
  extends BFrozenEnum
{
  /*-
  
  enum BPos
  {
    range
    {
      nullPosition,
      zeroPosition,
      minPosition,
      maxPosition,
      holdPosition,      
      regulator
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.ahu.BPos(1373506885)1.0$ @*/
/* Generated Thu Oct 28 20:00:45 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  /** Ordinal value for nullPosition. */
  public static final int NULL_POSITION = 0;
  /** Ordinal value for zeroPosition. */
  public static final int ZERO_POSITION = 1;
  /** Ordinal value for minPosition. */
  public static final int MIN_POSITION = 2;
  /** Ordinal value for maxPosition. */
  public static final int MAX_POSITION = 3;
  /** Ordinal value for holdPosition. */
  public static final int HOLD_POSITION = 4;
  /** Ordinal value for regulator. */
  public static final int REGULATOR = 5;
  
  /** BPos constant for nullPosition. */
  public static final BPos nullPosition = new BPos(NULL_POSITION);
  /** BPos constant for zeroPosition. */
  public static final BPos zeroPosition = new BPos(ZERO_POSITION);
  /** BPos constant for minPosition. */
  public static final BPos minPosition = new BPos(MIN_POSITION);
  /** BPos constant for maxPosition. */
  public static final BPos maxPosition = new BPos(MAX_POSITION);
  /** BPos constant for holdPosition. */
  public static final BPos holdPosition = new BPos(HOLD_POSITION);
  /** BPos constant for regulator. */
  public static final BPos regulator = new BPos(REGULATOR);
  
  /** Factory method with ordinal. */
  public static BPos make(int ordinal)
  {
    return (BPos)nullPosition.getRange().get(ordinal, false);
  }
  
  /** Factory method with tag. */
  public static BPos make(String tag)
  {
    return (BPos)nullPosition.getRange().get(tag);
  }
  
  /** Private constructor. */
  private BPos(int ordinal)
  {
    super(ordinal);
  }
  
  public static final BPos DEFAULT = nullPosition;

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPos.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



  
}

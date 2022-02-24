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
public final class BFloat2Knx  extends BComponent
{
  /*-
  class BFloat2Knx  
  {   
    properties  
    {  
      out                :     BDouble         flags { SUMMARY }     default {[  BDouble.DEFAULT ]}       
      in               :     BInteger          flags { SUMMARY }     default {[  BInteger.DEFAULT ]}       

    }   
    actions
    {
    
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.fcuModule.BFloat2Knx(2254502787)1.0$ @*/
/* Generated Thu Jun 24 07:12:10 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "out"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BFloat2Knx#getOut
   * @see com.bc.CommonLogic.fcuModule.BFloat2Knx#setOut
   */
  public static final Property out = newProperty(Flags.SUMMARY, ((BDouble)(BDouble.DEFAULT)).getDouble(),null);
  
  /**
   * Get the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BFloat2Knx#out
   */
  public double getOut() { return getDouble(out); }
  
  /**
   * Set the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BFloat2Knx#out
   */
  public void setOut(double v) { setDouble(out,v,null); }

////////////////////////////////////////////////////////////////
// Property "in"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BFloat2Knx#getIn
   * @see com.bc.CommonLogic.fcuModule.BFloat2Knx#setIn
   */
  public static final Property in = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.DEFAULT)).getInt(),null);
  
  /**
   * Get the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BFloat2Knx#in
   */
  public int getIn() { return getInt(in); }
  
  /**
   * Set the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BFloat2Knx#in
   */
  public void setIn(int v) { setInt(in,v,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFloat2Knx.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  setOut(ConvetUint162Temp(getIn()));
}
float ConvetUint162Temp(int value)
{
 float temp;
 int e,m;
 e = ( value & 0x7800 ) >> 11;
 if( 0 == ( value & 0x8000) )
 {
  m = value & 0x07ff;
  temp = (float)( 0.01 * m * (1<<e) );
 }
 else
 {
  m = value & 0x07ff;
  m = m | 0xf800;
  temp = (float)( 0.01 * m * (1<<e) );  
 }
 return temp;
}

}

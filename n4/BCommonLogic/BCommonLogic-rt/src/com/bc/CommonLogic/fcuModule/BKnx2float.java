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
public final class BKnx2float  extends BComponent
{
  /*-
  class BKnx2float  
  {   
    properties  
    {  
      in                :     BDouble         flags { SUMMARY }     default {[  BDouble.DEFAULT ]}       
      out               :     BInteger          flags { SUMMARY }     default {[  BInteger.DEFAULT ]}       

    }   
    actions
    {
    
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.fcuModule.BKnx2float(2398459775)1.0$ @*/
/* Generated Thu Jun 24 07:01:00 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "in"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnx2float#getIn
   * @see com.bc.CommonLogic.fcuModule.BKnx2float#setIn
   */
  public static final Property in = newProperty(Flags.SUMMARY, ((BDouble)(BDouble.DEFAULT)).getDouble(),null);
  
  /**
   * Get the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnx2float#in
   */
  public double getIn() { return getDouble(in); }
  
  /**
   * Set the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnx2float#in
   */
  public void setIn(double v) { setDouble(in,v,null); }

////////////////////////////////////////////////////////////////
// Property "out"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnx2float#getOut
   * @see com.bc.CommonLogic.fcuModule.BKnx2float#setOut
   */
  public static final Property out = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.DEFAULT)).getInt(),null);
  
  /**
   * Get the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnx2float#out
   */
  public int getOut() { return getInt(out); }
  
  /**
   * Set the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnx2float#out
   */
  public void setOut(int v) { setInt(out,v,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BKnx2float.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  setOut(ConvetTemp2Uint16((float)getIn()));
}
int ConvetTemp2Uint16(float temp)
{
  int e, m; /// ** <For the definition of these two parameters, please refer to 3.10 Datapoint Types "2-Octet Float Value" in 03_07_02 Datapoint Types * /

 for( e = 0;  e<=15;  e++ )
 {
  m = (int) ( temp/( 1<<e )/0.01 );
  if( m>-2048 && m<=2047 )
  {
   if( m>=0 )
   {
    return ( m | ( e<<11 ) );
   }
   else
   {
    m = ( m & 0x87ff ) | ( e<<11 );
    return m;
   }
  }
 }
 return 0xffff;
}  
}

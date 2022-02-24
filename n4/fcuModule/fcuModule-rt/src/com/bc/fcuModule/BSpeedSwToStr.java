/*

*/     
package com.bc.fcuModule;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;


import javax.baja.agent.*;

import javax.baja.control.*;
import javax.baja.status.*;

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BSpeedSwToStr extends BComponent
{ 
  
  /*-  
  class BSpeedSwToStr  
  {  
    properties  
    {  
       out        :     BString        flags { READONLY }     default {[ BString.make("fan=speed0,hv=close,cv=close") ]}  
       speed               :     BInteger        flags { SUMMARY }     default {[ BInteger.make(0) ]}  
       hv        :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ) ]} 
       cv        :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ) ]} 
       

    }   
    actions
    {

    }
  }  
  -*/


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BSpeedSwToStr(960951190)1.0$ @*/
/* Generated Mon Dec 20 10:48:10 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "out"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.READONLY, BString.make("fan=speed0,hv=close,cv=close"), null);
  
  /**
   * Get the {@code out} property.
   * @see #out
   */
  public String getOut() { return getString(out); }
  
  /**
   * Set the {@code out} property.
   * @see #out
   */
  public void setOut(String v) { setString(out, v, null); }

////////////////////////////////////////////////////////////////
// Property "speed"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code speed} property.
   * @see #getSpeed
   * @see #setSpeed
   */
  public static final Property speed = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(0))).getInt(), null);
  
  /**
   * Get the {@code speed} property.
   * @see #speed
   */
  public int getSpeed() { return getInt(speed); }
  
  /**
   * Set the {@code speed} property.
   * @see #speed
   */
  public void setSpeed(int v) { setInt(speed, v, null); }

////////////////////////////////////////////////////////////////
// Property "hv"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hv} property.
   * @see #getHv
   * @see #setHv
   */
  public static final Property hv = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ));
  
  /**
   * Get the {@code hv} property.
   * @see #hv
   */
  public boolean getHv() { return getBoolean(hv); }
  
  /**
   * Set the {@code hv} property.
   * @see #hv
   */
  public void setHv(boolean v) { setBoolean(hv, v, null); }

////////////////////////////////////////////////////////////////
// Property "cv"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code cv} property.
   * @see #getCv
   * @see #setCv
   */
  public static final Property cv = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ));
  
  /**
   * Get the {@code cv} property.
   * @see #cv
   */
  public boolean getCv() { return getBoolean(cv); }
  
  /**
   * Set the {@code cv} property.
   * @see #cv
   */
  public void setCv(boolean v) { setBoolean(cv, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpeedSwToStr.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  
}  
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; 
  super.changed(p, cx);

  
  if( p == speed ||  p == hv ||  p == cv ){ 
  String StrS = new String("");  
  String StrH = new String(""); 
  String StrC = new String("");  
  
  if      (getSpeed()==1){StrS = "fan=speed1";}
  else if (getSpeed()==2){StrS = "fan=speed2";}
  else if (getSpeed()==3){StrS = "fan=speed3";}  
  else{StrS = "fan=speed0";}
  
  if(getHv()){StrH = "hv=open";}
  else{StrH = "hv=close";}

  if(getCv()){StrC = "cv=open";}
  else{StrC = "cv=close";}

  setOut(StrS + "," + StrH + "," + StrC );
  }

 
} 
   
   
}

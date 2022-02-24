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
public class BSpeedSwStrParser extends BComponent
{ 
  
  /*-  
  class BSpeedSwStrParser  
  {  
    properties  
    {  
       in        :     BString        flags { SUMMARY }     default {[ BString.make("fan=speed0,hv=close,cv=close") ]}  
       speed               :     BInteger        flags { READONLY }     default {[ BInteger.make(0) ]}  
       hv        :     BBoolean        flags { READONLY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ) ]} 
       cv        :     BBoolean        flags { READONLY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ) ]} 
       

    }   
    actions
    {

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BSpeedSwStrParser(3674079705)1.0$ @*/
/* Generated Mon Dec 20 10:51:02 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "in"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in} property.
   * @see #getIn
   * @see #setIn
   */
  public static final Property in = newProperty(Flags.SUMMARY, BString.make("fan=speed0,hv=close,cv=close"), null);
  
  /**
   * Get the {@code in} property.
   * @see #in
   */
  public String getIn() { return getString(in); }
  
  /**
   * Set the {@code in} property.
   * @see #in
   */
  public void setIn(String v) { setString(in, v, null); }

////////////////////////////////////////////////////////////////
// Property "speed"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code speed} property.
   * @see #getSpeed
   * @see #setSpeed
   */
  public static final Property speed = newProperty(Flags.READONLY, ((BInteger)(BInteger.make(0))).getInt(), null);
  
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
  public static final Property hv = newProperty(Flags.READONLY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ));
  
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
  public static final Property cv = newProperty(Flags.READONLY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ));
  
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
  public static final Type TYPE = Sys.loadType(BSpeedSwStrParser.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  
}  
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; 
  super.changed(p, cx);
  

  if( p == in  ){ 
  String prs = new String(getIn());
  if(prs.lastIndexOf("fan=speed0")!= -1)setSpeed(0);
  if(prs.lastIndexOf("fan=speed1")!= -1)setSpeed(1);  
  if(prs.lastIndexOf("fan=speed2")!= -1)setSpeed(2);  
  if(prs.lastIndexOf("fan=speed3")!= -1)setSpeed(3);  
  if(prs.lastIndexOf("hv=close")!= -1)setHv(false);
  if(prs.lastIndexOf("hv=open")!= -1)setHv(true);     
  if(prs.lastIndexOf("cv=close")!= -1)setCv(false);
  if(prs.lastIndexOf("cv=open")!= -1)setCv(true);  
  }

 
} 
   
   
}

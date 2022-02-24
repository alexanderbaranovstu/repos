package com.bc.CommonLogic.lighting;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.control.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;
import javax.baja.util.BFormat;
import javax.baja.units.*;
  
public class BIsmaDaliLamp extends BStringWritable   
{  

  /*-  
  class BIsmaDaliLamp  
  {  
    properties  
    {  
      sourceName: BFormat
        -- Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
        default {[ BFormat.make("%displayName%") ]}
              
                
      swIn            : BBoolean            flags { SUMMARY }         default {[ BBoolean.FALSE ]}     
       
      inDim           : BInteger            flags { SUMMARY }         default {[ BInteger.make(0) ]}                            slotfacets {[ BFacets.makeInt(   BUnit.make("Numbers of Steps", BDimension.NULL), 0, 254)  ]}
        
      daliOn          : BBoolean            flags { SUMMARY }         default {[ BBoolean.FALSE ]}                              slotfacets {[ BFacets.makeBoolean(  BString.make("SwitchOn"), BString.make("SwitchOff") ) ]}
      daliOff         : BBoolean            flags { SUMMARY }         default {[ BBoolean.FALSE ]}                              slotfacets {[ BFacets.makeBoolean(  BString.make("SwitchOn"), BString.make("SwitchOff") ) ]}
      outDim          : BInteger            flags { SUMMARY }         default {[ BInteger.make(0) ]}                            slotfacets {[ BFacets.makeInt(   BUnit.make("Numbers of Steps", BDimension.NULL), 0, 254)  ]}

    }   
    actions
    {

      onCmd()
        flags { SUMMARY }
      offCmd()
        flags { SUMMARY }
      dimCmd  (arg: BDouble)
        default {[ BDouble.DEFAULT ]}
        flags { SUMMARY }          
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.lighting.BIsmaDaliLamp(1295450704)1.0$ @*/
/* Generated Wed Nov 17 09:58:05 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "sourceName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#getSourceName
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#setSourceName
   */
  public static final Property sourceName = newProperty(0, BFormat.make("%displayName%"),null);
  
  /**
   * Get the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#sourceName
   */
  public BFormat getSourceName() { return (BFormat)get(sourceName); }
  
  /**
   * Set the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#sourceName
   */
  public void setSourceName(BFormat v) { set(sourceName,v,null); }

////////////////////////////////////////////////////////////////
// Property "swIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>swIn</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#getSwIn
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#setSwIn
   */
  public static final Property swIn = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),null);
  
  /**
   * Get the <code>swIn</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#swIn
   */
  public boolean getSwIn() { return getBoolean(swIn); }
  
  /**
   * Set the <code>swIn</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#swIn
   */
  public void setSwIn(boolean v) { setBoolean(swIn,v,null); }

////////////////////////////////////////////////////////////////
// Property "inDim"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>inDim</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#getInDim
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#setInDim
   */
  public static final Property inDim = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(0))).getInt(),BFacets.makeInt(   BUnit.make("Numbers of Steps", BDimension.NULL), 0, 254));
  
  /**
   * Get the <code>inDim</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#inDim
   */
  public int getInDim() { return getInt(inDim); }
  
  /**
   * Set the <code>inDim</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#inDim
   */
  public void setInDim(int v) { setInt(inDim,v,null); }

////////////////////////////////////////////////////////////////
// Property "daliOn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>daliOn</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#getDaliOn
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#setDaliOn
   */
  public static final Property daliOn = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),BFacets.makeBoolean(  BString.make("SwitchOn"), BString.make("SwitchOff") ));
  
  /**
   * Get the <code>daliOn</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#daliOn
   */
  public boolean getDaliOn() { return getBoolean(daliOn); }
  
  /**
   * Set the <code>daliOn</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#daliOn
   */
  public void setDaliOn(boolean v) { setBoolean(daliOn,v,null); }

////////////////////////////////////////////////////////////////
// Property "daliOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>daliOff</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#getDaliOff
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#setDaliOff
   */
  public static final Property daliOff = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),BFacets.makeBoolean(  BString.make("SwitchOn"), BString.make("SwitchOff") ));
  
  /**
   * Get the <code>daliOff</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#daliOff
   */
  public boolean getDaliOff() { return getBoolean(daliOff); }
  
  /**
   * Set the <code>daliOff</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#daliOff
   */
  public void setDaliOff(boolean v) { setBoolean(daliOff,v,null); }

////////////////////////////////////////////////////////////////
// Property "outDim"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outDim</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#getOutDim
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#setOutDim
   */
  public static final Property outDim = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(0))).getInt(),BFacets.makeInt(   BUnit.make("Numbers of Steps", BDimension.NULL), 0, 254));
  
  /**
   * Get the <code>outDim</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#outDim
   */
  public int getOutDim() { return getInt(outDim); }
  
  /**
   * Set the <code>outDim</code> property.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#outDim
   */
  public void setOutDim(int v) { setInt(outDim,v,null); }

////////////////////////////////////////////////////////////////
// Action "onCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>onCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#onCmd()
   */
  public static final Action onCmd = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>onCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#onCmd
   */
  public void onCmd() { invoke(onCmd,null,null); }

////////////////////////////////////////////////////////////////
// Action "offCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>offCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#offCmd()
   */
  public static final Action offCmd = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>offCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#offCmd
   */
  public void offCmd() { invoke(offCmd,null,null); }

////////////////////////////////////////////////////////////////
// Action "dimCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>dimCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#dimCmd()
   */
  public static final Action dimCmd = newAction(Flags.SUMMARY,BDouble.DEFAULT,null);
  
  /**
   * Invoke the <code>dimCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BIsmaDaliLamp#dimCmd
   */
  public void dimCmd(BDouble arg) { invoke(dimCmd,arg,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BIsmaDaliLamp.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void changed(Property p, Context cx) {
    

    if(p == swIn){
      if(getSwIn())doOnCmd();
      else doOffCmd();
    }
    if(p == inDim){
      setOutDim(getInDim() );
      doDimCmd(BDouble.make(getInDim()) );
    }    
  }
  public void doOnCmd() { 

        setDaliOn(false );
        this.set( BString.make(getSourceName().format(this) + "doOnCmd") );        // BString.make(getSourceName().format(this) + "doOnCmd") 
        setDaliOn(true );  
  }
  public void doOffCmd()  {  
        setDaliOff(false );
        this.set( BString.make(getSourceName().format(this) + "doOffCmd")); 
        setDaliOff(true );  
  }


  public void doDimCmd(BDouble v)  {  
    setOutDim(v.getInt());
    this.set( BString.make(getSourceName().format(this) + "doDimCmd"));  


  }  
} 

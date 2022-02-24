/*
объект шаг представляет собой 
req
fb
state=toOn,On,toOff,Off,fbAlarm
delay
cntr
waitingFlag
работа по переключению ступеней вообще 
Таким образом прежде чем включить какой либо пускатель мы должны убедиться
что waitingFlag не установлен ни на одном из пускателей
далее  

*/     
package com.bc.fcuModule;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;


import javax.baja.agent.*;

import javax.baja.control.*;
import javax.baja.status.*;

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BContactor extends BComponent
{ 
  
  /*-  
  class BSpeedSw  
  {  
    properties  
    {  

       req                :     BBoolean        flags { READONLY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]} 
       fb                 :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]} 
       contactorState     :     BStatusEnum     flags { READONLY }      default {[ new BStatusEnum(BContactorState.off, BStatus.ok) ]}      slotfacets {[ BFacets.makeEnum( BEnumRange.make(BContactorState.TYPE) ) ]}
       delay              :     BInteger        flags { SUMMARY }     default {[ BInteger.make(10) ]}  --slotfacets {[ BFacets.makeString(  BString.make("Second") ) ]} 
       cntr               :     BInteger        flags { HIDDEN }     default {[ BInteger.make(0) ]}  --slotfacets {[ BFacets.makeString(  BString.make("Second") ) ]} 
       waitingFlag        :     BBoolean        flags { HIDDEN }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("Set"), BString.make("Reset") ) ]} 
       

    }   
    actions
    {
      clear()
      calc(arg: BBoolean)                   flags { HIDDEN }      default {[ BBoolean.make(false) ]}

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.id1359.BContactor(2688613277)1.0$ @*/
/* Generated Thu Dec 16 12:02:32 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "req"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>req</code> property.
   * @see com.bc.id1359.BContactor#getReq
   * @see com.bc.id1359.BContactor#setReq
   */
  public static final Property req = newProperty(Flags.READONLY, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the <code>req</code> property.
   * @see com.bc.id1359.BContactor#req
   */
  public boolean getReq() { return getBoolean(req); }
  
  /**
   * Set the <code>req</code> property.
   * @see com.bc.id1359.BContactor#req
   */
  public void setReq(boolean v) { setBoolean(req,v,null); }

////////////////////////////////////////////////////////////////
// Property "fb"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>fb</code> property.
   * @see com.bc.id1359.BContactor#getFb
   * @see com.bc.id1359.BContactor#setFb
   */
  public static final Property fb = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the <code>fb</code> property.
   * @see com.bc.id1359.BContactor#fb
   */
  public boolean getFb() { return getBoolean(fb); }
  
  /**
   * Set the <code>fb</code> property.
   * @see com.bc.id1359.BContactor#fb
   */
  public void setFb(boolean v) { setBoolean(fb,v,null); }

////////////////////////////////////////////////////////////////
// Property "contactorState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>contactorState</code> property.
   * @see com.bc.id1359.BContactor#getContactorState
   * @see com.bc.id1359.BContactor#setContactorState
   */
  public static final Property contactorState = newProperty(Flags.READONLY, new BStatusEnum(BContactorState.off, BStatus.ok),BFacets.makeEnum( BEnumRange.make(BContactorState.TYPE) ));
  
  /**
   * Get the <code>contactorState</code> property.
   * @see com.bc.id1359.BContactor#contactorState
   */
  public BStatusEnum getContactorState() { return (BStatusEnum)get(contactorState); }
  
  /**
   * Set the <code>contactorState</code> property.
   * @see com.bc.id1359.BContactor#contactorState
   */
  public void setContactorState(BStatusEnum v) { set(contactorState,v,null); }

////////////////////////////////////////////////////////////////
// Property "delay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>delay</code> property.
   * @see com.bc.id1359.BContactor#getDelay
   * @see com.bc.id1359.BContactor#setDelay
   */
  public static final Property delay = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(10))).getInt(),null);
  
  /**
   * Get the <code>delay</code> property.
   * @see com.bc.id1359.BContactor#delay
   */
  public int getDelay() { return getInt(delay); }
  
  /**
   * Set the <code>delay</code> property.
   * @see com.bc.id1359.BContactor#delay
   */
  public void setDelay(int v) { setInt(delay,v,null); }

////////////////////////////////////////////////////////////////
// Property "cntr"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cntr</code> property.
   * @see com.bc.id1359.BContactor#getCntr
   * @see com.bc.id1359.BContactor#setCntr
   */
  public static final Property cntr = newProperty(Flags.HIDDEN, ((BInteger)(BInteger.make(0))).getInt(),null);
  
  /**
   * Get the <code>cntr</code> property.
   * @see com.bc.id1359.BContactor#cntr
   */
  public int getCntr() { return getInt(cntr); }
  
  /**
   * Set the <code>cntr</code> property.
   * @see com.bc.id1359.BContactor#cntr
   */
  public void setCntr(int v) { setInt(cntr,v,null); }

////////////////////////////////////////////////////////////////
// Property "waitingFlag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>waitingFlag</code> property.
   * @see com.bc.id1359.BContactor#getWaitingFlag
   * @see com.bc.id1359.BContactor#setWaitingFlag
   */
  public static final Property waitingFlag = newProperty(Flags.HIDDEN, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("Set"), BString.make("Reset") ));
  
  /**
   * Get the <code>waitingFlag</code> property.
   * @see com.bc.id1359.BContactor#waitingFlag
   */
  public boolean getWaitingFlag() { return getBoolean(waitingFlag); }
  
  /**
   * Set the <code>waitingFlag</code> property.
   * @see com.bc.id1359.BContactor#waitingFlag
   */
  public void setWaitingFlag(boolean v) { setBoolean(waitingFlag,v,null); }

////////////////////////////////////////////////////////////////
// Action "clear"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>clear</code> action.
   * @see com.bc.id1359.BContactor#clear()
   */
  public static final Action clear = newAction(0,null);
  
  /**
   * Invoke the <code>clear</code> action.
   * @see com.bc.id1359.BContactor#clear
   */
  public void clear() { invoke(clear,null,null); }

////////////////////////////////////////////////////////////////
// Action "calc"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>calc</code> action.
   * @see com.bc.id1359.BContactor#calc()
   */
  public static final Action calc = newAction(Flags.HIDDEN,BBoolean.make(false),null);
  
  /**
   * Invoke the <code>calc</code> action.
   * @see com.bc.id1359.BContactor#calc
   */
  public void calc(BBoolean arg) { invoke(calc,arg,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BContactor.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/







                

// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();


      
}  
public void doClear()  throws Exception
{
 setReq(false);
 setContactorState(new BStatusEnum(BContactorState.off, BStatus.ok) );
 setCntr(0);
 setWaitingFlag(false);
}
public void doCalc(BBoolean b)  throws Exception
{
//System.out.println("something to show " + getParent ()  );
if(getContactorState().getEnum().getOrdinal()  == BContactorState.ALARM_FB){setReq(false);return;}
 
 if(b.getBoolean() != getFb() ){
  if(getCntr() < getDelay()){setCntr(getCntr() + 1);}
  else{setContactorState(new BStatusEnum(BContactorState.alarmFb, BStatus.ok));}
  if(!getWaitingFlag()){setReq(b.getBoolean());}
  setWaitingFlag(true);
  }
 else{
  setCntr(0);
  //((BSpeedSw)this.getParent () ).getSpeedRequest().setValue( ((BSpeedSw)this.getParent () ).getSpeedInt().getValue() );
  setWaitingFlag(false);
 }
 if(getContactorState().getEnum().getOrdinal()  == BContactorState.ALARM_FB){return;}
 if     (getReq() && !getWaitingFlag()){setContactorState(new BStatusEnum(BContactorState.on, BStatus.ok));}
 else if(!getReq() && !getWaitingFlag()){setContactorState(new BStatusEnum(BContactorState.off, BStatus.ok));}
 else if(getReq() && getWaitingFlag()){setContactorState(new BStatusEnum(BContactorState.toOn, BStatus.ok));} 
 else if(!getReq() && getWaitingFlag()){setContactorState(new BStatusEnum(BContactorState.toOff, BStatus.ok));}  
}
   
   
}

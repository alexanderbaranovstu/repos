/*

*/     
package com.bc.id1359;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;


import javax.baja.agent.*;

import javax.baja.control.*;
import javax.baja.status.*;

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BStateMachine extends BComponent
{ 
  
  /*-  
  class BStateMachine  
  {  
    properties  
    {  
     unitState                :     BEnumWritable         flags { SUMMARY }     default {[ new BEnumWritable() ]}                                 --slotfacets {[ BFacets.makeEnum( BEnumRange.make(BUnitState.TYPE) ) ]}
     winter                   :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}               slotfacets {[ BFacets.makeBoolean(  BString.make("Winter"), BString.make("Summer") ) ]}   
     onOffReq                 :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}
     alarmCritical            :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}
     cpFb                     :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}               slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}   

    }   
    actions
    {
 
     resetAlarms()                                   

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.id1359.BStateMachine(1227707058)1.0$ @*/
/* Generated Mon Oct 04 15:09:14 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "unitState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>unitState</code> property.
   * @see com.bc.id1359.BStateMachine#getUnitState
   * @see com.bc.id1359.BStateMachine#setUnitState
   */
  public static final Property unitState = newProperty(Flags.SUMMARY, new BEnumWritable(),null);
  
  /**
   * Get the <code>unitState</code> property.
   * @see com.bc.id1359.BStateMachine#unitState
   */
  public BEnumWritable getUnitState() { return (BEnumWritable)get(unitState); }
  
  /**
   * Set the <code>unitState</code> property.
   * @see com.bc.id1359.BStateMachine#unitState
   */
  public void setUnitState(BEnumWritable v) { set(unitState,v,null); }

////////////////////////////////////////////////////////////////
// Property "winter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>winter</code> property.
   * @see com.bc.id1359.BStateMachine#getWinter
   * @see com.bc.id1359.BStateMachine#setWinter
   */
  public static final Property winter = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok),BFacets.makeBoolean(  BString.make("Winter"), BString.make("Summer") ));
  
  /**
   * Get the <code>winter</code> property.
   * @see com.bc.id1359.BStateMachine#winter
   */
  public BStatusBoolean getWinter() { return (BStatusBoolean)get(winter); }
  
  /**
   * Set the <code>winter</code> property.
   * @see com.bc.id1359.BStateMachine#winter
   */
  public void setWinter(BStatusBoolean v) { set(winter,v,null); }

////////////////////////////////////////////////////////////////
// Property "onOffReq"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>onOffReq</code> property.
   * @see com.bc.id1359.BStateMachine#getOnOffReq
   * @see com.bc.id1359.BStateMachine#setOnOffReq
   */
  public static final Property onOffReq = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok),null);
  
  /**
   * Get the <code>onOffReq</code> property.
   * @see com.bc.id1359.BStateMachine#onOffReq
   */
  public BStatusBoolean getOnOffReq() { return (BStatusBoolean)get(onOffReq); }
  
  /**
   * Set the <code>onOffReq</code> property.
   * @see com.bc.id1359.BStateMachine#onOffReq
   */
  public void setOnOffReq(BStatusBoolean v) { set(onOffReq,v,null); }

////////////////////////////////////////////////////////////////
// Property "alarmCritical"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alarmCritical</code> property.
   * @see com.bc.id1359.BStateMachine#getAlarmCritical
   * @see com.bc.id1359.BStateMachine#setAlarmCritical
   */
  public static final Property alarmCritical = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok),null);
  
  /**
   * Get the <code>alarmCritical</code> property.
   * @see com.bc.id1359.BStateMachine#alarmCritical
   */
  public BStatusBoolean getAlarmCritical() { return (BStatusBoolean)get(alarmCritical); }
  
  /**
   * Set the <code>alarmCritical</code> property.
   * @see com.bc.id1359.BStateMachine#alarmCritical
   */
  public void setAlarmCritical(BStatusBoolean v) { set(alarmCritical,v,null); }

////////////////////////////////////////////////////////////////
// Property "cpFb"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cpFb</code> property.
   * @see com.bc.id1359.BStateMachine#getCpFb
   * @see com.bc.id1359.BStateMachine#setCpFb
   */
  public static final Property cpFb = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok),BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the <code>cpFb</code> property.
   * @see com.bc.id1359.BStateMachine#cpFb
   */
  public BStatusBoolean getCpFb() { return (BStatusBoolean)get(cpFb); }
  
  /**
   * Set the <code>cpFb</code> property.
   * @see com.bc.id1359.BStateMachine#cpFb
   */
  public void setCpFb(BStatusBoolean v) { set(cpFb,v,null); }

////////////////////////////////////////////////////////////////
// Action "resetAlarms"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>resetAlarms</code> action.
   * @see com.bc.id1359.BStateMachine#resetAlarms()
   */
  public static final Action resetAlarms = newAction(0,null);
  
  /**
   * Invoke the <code>resetAlarms</code> action.
   * @see com.bc.id1359.BStateMachine#resetAlarms
   */
  public void resetAlarms() { invoke(resetAlarms,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BStateMachine.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/





  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    return icon; 
  }
  private static final BIcon icon = BIcon.std("site.png");




                

// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();


  // Установки енумераций BFcuState = Off, ManualSpeed1, ManualSpeed2, ManualSpeed3, Auto
  getUnitState().setFacets(BFacets.makeEnum(BEnumRange.make(BUnitState.TYPE)) );
  //getSpeedInt().BFacets.makeNumeric(null,0,BNumber.make(0), BNumber.make(3));
  doResetAlarms();
      
}  

 
// Начало пользовательских методов
public void doResetAlarms()    throws Exception
{                 
 
    if(!getAlarmCritical().getValue() && (( getWinter().getValue()&& getCpFb().getValue()) || !getWinter().getValue()) ){getUnitState().set( BDynamicEnum.make(1)) ;}
    

} 
// 
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; 
  super.changed(p, cx);
  

  if( p == onOffReq && !getOnOffReq().getValue() ){ 
      try{doResetAlarms();}
      catch(Exception ie) {System.out.println("Changed " + ie);} 
  }
  
  if( getUnitState().getOut().getValue().getOrdinal() == 0)return;

  if ( getOnOffReq().getValue() ) {getUnitState().set( BDynamicEnum.make(2)) ;}
  else {getUnitState().set( BDynamicEnum.make(1)) ;}
  
  if(getAlarmCritical().getValue()||( getWinter().getValue()&& !getCpFb().getValue()) ){getUnitState().set( BDynamicEnum.make(0)) ;} 
 
} 
    
     
}

/*

*/     
package com.bc.leadlagCycle;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;


import javax.baja.agent.*;

import javax.baja.control.*;
import javax.baja.status.*;

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BSingleUnit extends BComponent
{ 
  
  /*-  
  class BSpeedSw  
  {  
    properties  
    {  

       unitState          :     BStatusEnum     flags { READONLY }      default {[ new BStatusEnum(BUnitState.off, BStatus.ok) ]}      slotfacets {[ BFacets.makeEnum( BEnumRange.make(BUnitState.TYPE) ) ]}
       req                :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]} 
       fb                 :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]} 
       fbDelay            :     BRelTime        flags {  }     default {[ BRelTime.make(15000) ]}
       alm                :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ) ]} 
       out                :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]} 
       number             :     BInteger        flags { READONLY }     default {[ BInteger.make(0) ]}        
    }   
    actions
    {
      setOn()           flags { SUMMARY }
      setOff()          flags { SUMMARY }
      setAlarm()        flags { SUMMARY }
      resetAlarm()      flags { SUMMARY }
      timerExpired()    flags { hidden }                             

      setServiceOff()           flags { SUMMARY }
      resetServiceOff()          flags { SUMMARY }
     
    }
  }  
  -*/



/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.leadlagCycle.BSingleUnit(2949874991)1.0$ @*/
/* Generated Fri Jan 21 05:56:15 MSK 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "unitState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code unitState} property.
   * @see #getUnitState
   * @see #setUnitState
   */
  public static final Property unitState = newProperty(Flags.READONLY, new BStatusEnum(BUnitState.off, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BUnitState.TYPE) ));
  
  /**
   * Get the {@code unitState} property.
   * @see #unitState
   */
  public BStatusEnum getUnitState() { return (BStatusEnum)get(unitState); }
  
  /**
   * Set the {@code unitState} property.
   * @see #unitState
   */
  public void setUnitState(BStatusEnum v) { set(unitState, v, null); }

////////////////////////////////////////////////////////////////
// Property "req"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code req} property.
   * @see #getReq
   * @see #setReq
   */
  public static final Property req = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code req} property.
   * @see #req
   */
  public boolean getReq() { return getBoolean(req); }
  
  /**
   * Set the {@code req} property.
   * @see #req
   */
  public void setReq(boolean v) { setBoolean(req, v, null); }

////////////////////////////////////////////////////////////////
// Property "fb"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fb} property.
   * @see #getFb
   * @see #setFb
   */
  public static final Property fb = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code fb} property.
   * @see #fb
   */
  public boolean getFb() { return getBoolean(fb); }
  
  /**
   * Set the {@code fb} property.
   * @see #fb
   */
  public void setFb(boolean v) { setBoolean(fb, v, null); }

////////////////////////////////////////////////////////////////
// Property "fbDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fbDelay} property.
   * @see #getFbDelay
   * @see #setFbDelay
   */
  public static final Property fbDelay = newProperty(0, BRelTime.make(15000), null);
  
  /**
   * Get the {@code fbDelay} property.
   * @see #fbDelay
   */
  public BRelTime getFbDelay() { return (BRelTime)get(fbDelay); }
  
  /**
   * Set the {@code fbDelay} property.
   * @see #fbDelay
   */
  public void setFbDelay(BRelTime v) { set(fbDelay, v, null); }

////////////////////////////////////////////////////////////////
// Property "alm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alm} property.
   * @see #getAlm
   * @see #setAlm
   */
  public static final Property alm = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ));
  
  /**
   * Get the {@code alm} property.
   * @see #alm
   */
  public boolean getAlm() { return getBoolean(alm); }
  
  /**
   * Set the {@code alm} property.
   * @see #alm
   */
  public void setAlm(boolean v) { setBoolean(alm, v, null); }

////////////////////////////////////////////////////////////////
// Property "out"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code out} property.
   * @see #getOut
   * @see #setOut
   */
  public static final Property out = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code out} property.
   * @see #out
   */
  public boolean getOut() { return getBoolean(out); }
  
  /**
   * Set the {@code out} property.
   * @see #out
   */
  public void setOut(boolean v) { setBoolean(out, v, null); }

////////////////////////////////////////////////////////////////
// Property "number"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code number} property.
   * @see #getNumber
   * @see #setNumber
   */
  public static final Property number = newProperty(Flags.READONLY, ((BInteger)(BInteger.make(0))).getInt(), null);
  
  /**
   * Get the {@code number} property.
   * @see #number
   */
  public int getNumber() { return getInt(number); }
  
  /**
   * Set the {@code number} property.
   * @see #number
   */
  public void setNumber(int v) { setInt(number, v, null); }

////////////////////////////////////////////////////////////////
// Action "setOn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setOn} action.
   * @see #setOn()
   */
  public static final Action setOn = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setOn} action.
   * @see #setOn
   */
  public void setOn() { invoke(setOn, null, null); }

////////////////////////////////////////////////////////////////
// Action "setOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setOff} action.
   * @see #setOff()
   */
  public static final Action setOff = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setOff} action.
   * @see #setOff
   */
  public void setOff() { invoke(setOff, null, null); }

////////////////////////////////////////////////////////////////
// Action "setAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setAlarm} action.
   * @see #setAlarm()
   */
  public static final Action setAlarm = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setAlarm} action.
   * @see #setAlarm
   */
  public void setAlarm() { invoke(setAlarm, null, null); }

////////////////////////////////////////////////////////////////
// Action "resetAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code resetAlarm} action.
   * @see #resetAlarm()
   */
  public static final Action resetAlarm = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code resetAlarm} action.
   * @see #resetAlarm
   */
  public void resetAlarm() { invoke(resetAlarm, null, null); }

////////////////////////////////////////////////////////////////
// Action "timerExpired"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code timerExpired} action.
   * @see #timerExpired()
   */
  public static final Action timerExpired = newAction(Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code timerExpired} action.
   * @see #timerExpired
   */
  public void timerExpired() { invoke(timerExpired, null, null); }

////////////////////////////////////////////////////////////////
// Action "setServiceOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setServiceOff} action.
   * @see #setServiceOff()
   */
  public static final Action setServiceOff = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setServiceOff} action.
   * @see #setServiceOff
   */
  public void setServiceOff() { invoke(setServiceOff, null, null); }

////////////////////////////////////////////////////////////////
// Action "resetServiceOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code resetServiceOff} action.
   * @see #resetServiceOff()
   */
  public static final Action resetServiceOff = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code resetServiceOff} action.
   * @see #resetServiceOff
   */
  public void resetServiceOff() { invoke(resetServiceOff, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSingleUnit.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  initTimer();   
  doResetAlarm();
}  

private void initTimer()  
{
  if (ticket != null) ticket.cancel();
  ticket = Clock.schedulePeriodically(this, BRelTime.make(1000), timerExpired, null);
}
private void stopFbTimer()  
{
 if (fbTicket != null) fbTicket.cancel();
  //System.out.println("stopFbTimer" );
}
// If fb timer not interrpted, alarm occured
private void startFbTimer()  
{
 if (fbTicket != null) fbTicket.cancel();
   fbTicket = Clock.schedule(this, getFbDelay(), setAlarm, null);
   //System.out.println("startFbTimer" );
}
private void startFbTimerIfNotStarted()  
{
 //System.out.println("startFbTimerIfNotStarted  " + fbTicket);
 if(fbTicket == null){
      fbTicket = Clock.schedule(this, getFbDelay(), setAlarm, null);
 }
 else if (fbTicket.isExpired()){
      fbTicket.cancel();
      fbTicket = Clock.schedule(this, getFbDelay(), setAlarm, null); 
 }
  
}
public void doSetOn()  throws Exception
{
  if(getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF)return;
  setReq(true);
}
public void doSetOff()  throws Exception
{
  setReq(false);
}
public void doSetAlarm() throws Exception
{
  if(getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF)return;
  setUnitState(new BStatusEnum(BUnitState.alarm, BStatus.ok));
}
public void doResetAlarm()  throws Exception
{
  if(getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF)return;
  ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("initSys"),null,null);     
  ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("calc"),null,null);   
  setUnitState(new BStatusEnum(BUnitState.off, BStatus.ok));
}
public void doResetServiceOff()  throws Exception
{
  setUnitState(new BStatusEnum(BUnitState.off, BStatus.ok));
  ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("initSys"),null,null);     
  ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("calc"),null,null);   
}    
public void doSetServiceOff()  throws Exception
{
  setUnitState(new BStatusEnum(BUnitState.serviceOff, BStatus.ok));
}
// Check alarm input and fb every 1 second and set UnitState
public void doTimerExpired()  throws Exception
{
  if(getUnitState().getEnum().getOrdinal() == BUnitState.ALARM || getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF ){}
  else if(getAlm())               {doSetAlarm();}
  else if(getReq() && !getFb())   {setUnitState(new BStatusEnum(BUnitState.toOn, BStatus.ok));  startFbTimerIfNotStarted();}
  else if(getReq() && getFb())    {setUnitState(new BStatusEnum(BUnitState.on, BStatus.ok));    stopFbTimer();}
  else if(!getReq() && getFb())   {setUnitState(new BStatusEnum(BUnitState.toOff, BStatus.ok)); startFbTimerIfNotStarted();}
  else if(!getReq() && !getFb())  {setUnitState(new BStatusEnum(BUnitState.off, BStatus.ok));   stopFbTimer();}
  
  switch(getUnitState().getEnum().getOrdinal()){
    case BUnitState.OFF       : setOut(false);  break;
    case BUnitState.TO_OFF    : setOut(false);  break;
    case BUnitState.ON        : setOut(true);   break;
    case BUnitState.TO_ON     : setOut(true);   break;
    case BUnitState.ALARM     : setOut(false);  break;
    case BUnitState.SERVICE_OFF     : setOut(false);  break;
    default                   : setOut(false);  break;
  }
  
}

public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  if( p == unitState && (getUnitState().getEnum().getOrdinal() == BUnitState.ALARM || getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF)){  
    ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("initSys"),null,null);     
    ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("calc"),null,null); 
  
  }
}



// Глобальные переменные
public Clock.Ticket ticket;   
public Clock.Ticket fbTicket;  
}

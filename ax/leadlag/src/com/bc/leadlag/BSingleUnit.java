/*

*/     
package com.bc.leadlag;  

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
       runtime            :     BRelTime        flags { summary }     default {[ BRelTime.make(0) ]}
    }   
    actions
    {
      setOn()           flags { SUMMARY }
      setOff()          flags { SUMMARY }
      setAlarm()        flags { SUMMARY }
      resetAlarm()      flags { SUMMARY }
      timerExpired()    flags { hidden }                             
      resetRuntime()    flags { SUMMARY }
      setServiceOff()           flags { SUMMARY }
      resetServiceOff()          flags { SUMMARY }
     
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.leadlag.BSingleUnit(8425231)1.0$ @*/
/* Generated Thu Dec 30 13:02:03 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "unitState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>unitState</code> property.
   * @see com.bc.leadlag.BSingleUnit#getUnitState
   * @see com.bc.leadlag.BSingleUnit#setUnitState
   */
  public static final Property unitState = newProperty(Flags.READONLY, new BStatusEnum(BUnitState.off, BStatus.ok),BFacets.makeEnum( BEnumRange.make(BUnitState.TYPE) ));
  
  /**
   * Get the <code>unitState</code> property.
   * @see com.bc.leadlag.BSingleUnit#unitState
   */
  public BStatusEnum getUnitState() { return (BStatusEnum)get(unitState); }
  
  /**
   * Set the <code>unitState</code> property.
   * @see com.bc.leadlag.BSingleUnit#unitState
   */
  public void setUnitState(BStatusEnum v) { set(unitState,v,null); }

////////////////////////////////////////////////////////////////
// Property "req"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>req</code> property.
   * @see com.bc.leadlag.BSingleUnit#getReq
   * @see com.bc.leadlag.BSingleUnit#setReq
   */
  public static final Property req = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the <code>req</code> property.
   * @see com.bc.leadlag.BSingleUnit#req
   */
  public boolean getReq() { return getBoolean(req); }
  
  /**
   * Set the <code>req</code> property.
   * @see com.bc.leadlag.BSingleUnit#req
   */
  public void setReq(boolean v) { setBoolean(req,v,null); }

////////////////////////////////////////////////////////////////
// Property "fb"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>fb</code> property.
   * @see com.bc.leadlag.BSingleUnit#getFb
   * @see com.bc.leadlag.BSingleUnit#setFb
   */
  public static final Property fb = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the <code>fb</code> property.
   * @see com.bc.leadlag.BSingleUnit#fb
   */
  public boolean getFb() { return getBoolean(fb); }
  
  /**
   * Set the <code>fb</code> property.
   * @see com.bc.leadlag.BSingleUnit#fb
   */
  public void setFb(boolean v) { setBoolean(fb,v,null); }

////////////////////////////////////////////////////////////////
// Property "fbDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>fbDelay</code> property.
   * @see com.bc.leadlag.BSingleUnit#getFbDelay
   * @see com.bc.leadlag.BSingleUnit#setFbDelay
   */
  public static final Property fbDelay = newProperty(0, BRelTime.make(15000),null);
  
  /**
   * Get the <code>fbDelay</code> property.
   * @see com.bc.leadlag.BSingleUnit#fbDelay
   */
  public BRelTime getFbDelay() { return (BRelTime)get(fbDelay); }
  
  /**
   * Set the <code>fbDelay</code> property.
   * @see com.bc.leadlag.BSingleUnit#fbDelay
   */
  public void setFbDelay(BRelTime v) { set(fbDelay,v,null); }

////////////////////////////////////////////////////////////////
// Property "alm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alm</code> property.
   * @see com.bc.leadlag.BSingleUnit#getAlm
   * @see com.bc.leadlag.BSingleUnit#setAlm
   */
  public static final Property alm = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ));
  
  /**
   * Get the <code>alm</code> property.
   * @see com.bc.leadlag.BSingleUnit#alm
   */
  public boolean getAlm() { return getBoolean(alm); }
  
  /**
   * Set the <code>alm</code> property.
   * @see com.bc.leadlag.BSingleUnit#alm
   */
  public void setAlm(boolean v) { setBoolean(alm,v,null); }

////////////////////////////////////////////////////////////////
// Property "out"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>out</code> property.
   * @see com.bc.leadlag.BSingleUnit#getOut
   * @see com.bc.leadlag.BSingleUnit#setOut
   */
  public static final Property out = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the <code>out</code> property.
   * @see com.bc.leadlag.BSingleUnit#out
   */
  public boolean getOut() { return getBoolean(out); }
  
  /**
   * Set the <code>out</code> property.
   * @see com.bc.leadlag.BSingleUnit#out
   */
  public void setOut(boolean v) { setBoolean(out,v,null); }

////////////////////////////////////////////////////////////////
// Property "number"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>number</code> property.
   * @see com.bc.leadlag.BSingleUnit#getNumber
   * @see com.bc.leadlag.BSingleUnit#setNumber
   */
  public static final Property number = newProperty(Flags.READONLY, ((BInteger)(BInteger.make(0))).getInt(),null);
  
  /**
   * Get the <code>number</code> property.
   * @see com.bc.leadlag.BSingleUnit#number
   */
  public int getNumber() { return getInt(number); }
  
  /**
   * Set the <code>number</code> property.
   * @see com.bc.leadlag.BSingleUnit#number
   */
  public void setNumber(int v) { setInt(number,v,null); }

////////////////////////////////////////////////////////////////
// Property "runtime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>runtime</code> property.
   * @see com.bc.leadlag.BSingleUnit#getRuntime
   * @see com.bc.leadlag.BSingleUnit#setRuntime
   */
  public static final Property runtime = newProperty(Flags.SUMMARY, BRelTime.make(0),null);
  
  /**
   * Get the <code>runtime</code> property.
   * @see com.bc.leadlag.BSingleUnit#runtime
   */
  public BRelTime getRuntime() { return (BRelTime)get(runtime); }
  
  /**
   * Set the <code>runtime</code> property.
   * @see com.bc.leadlag.BSingleUnit#runtime
   */
  public void setRuntime(BRelTime v) { set(runtime,v,null); }

////////////////////////////////////////////////////////////////
// Action "setOn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>setOn</code> action.
   * @see com.bc.leadlag.BSingleUnit#setOn()
   */
  public static final Action setOn = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>setOn</code> action.
   * @see com.bc.leadlag.BSingleUnit#setOn
   */
  public void setOn() { invoke(setOn,null,null); }

////////////////////////////////////////////////////////////////
// Action "setOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>setOff</code> action.
   * @see com.bc.leadlag.BSingleUnit#setOff()
   */
  public static final Action setOff = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>setOff</code> action.
   * @see com.bc.leadlag.BSingleUnit#setOff
   */
  public void setOff() { invoke(setOff,null,null); }

////////////////////////////////////////////////////////////////
// Action "setAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>setAlarm</code> action.
   * @see com.bc.leadlag.BSingleUnit#setAlarm()
   */
  public static final Action setAlarm = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>setAlarm</code> action.
   * @see com.bc.leadlag.BSingleUnit#setAlarm
   */
  public void setAlarm() { invoke(setAlarm,null,null); }

////////////////////////////////////////////////////////////////
// Action "resetAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>resetAlarm</code> action.
   * @see com.bc.leadlag.BSingleUnit#resetAlarm()
   */
  public static final Action resetAlarm = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>resetAlarm</code> action.
   * @see com.bc.leadlag.BSingleUnit#resetAlarm
   */
  public void resetAlarm() { invoke(resetAlarm,null,null); }

////////////////////////////////////////////////////////////////
// Action "timerExpired"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>timerExpired</code> action.
   * @see com.bc.leadlag.BSingleUnit#timerExpired()
   */
  public static final Action timerExpired = newAction(Flags.HIDDEN,null);
  
  /**
   * Invoke the <code>timerExpired</code> action.
   * @see com.bc.leadlag.BSingleUnit#timerExpired
   */
  public void timerExpired() { invoke(timerExpired,null,null); }

////////////////////////////////////////////////////////////////
// Action "resetRuntime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>resetRuntime</code> action.
   * @see com.bc.leadlag.BSingleUnit#resetRuntime()
   */
  public static final Action resetRuntime = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>resetRuntime</code> action.
   * @see com.bc.leadlag.BSingleUnit#resetRuntime
   */
  public void resetRuntime() { invoke(resetRuntime,null,null); }

////////////////////////////////////////////////////////////////
// Action "setServiceOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>setServiceOff</code> action.
   * @see com.bc.leadlag.BSingleUnit#setServiceOff()
   */
  public static final Action setServiceOff = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>setServiceOff</code> action.
   * @see com.bc.leadlag.BSingleUnit#setServiceOff
   */
  public void setServiceOff() { invoke(setServiceOff,null,null); }

////////////////////////////////////////////////////////////////
// Action "resetServiceOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>resetServiceOff</code> action.
   * @see com.bc.leadlag.BSingleUnit#resetServiceOff()
   */
  public static final Action resetServiceOff = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>resetServiceOff</code> action.
   * @see com.bc.leadlag.BSingleUnit#resetServiceOff
   */
  public void resetServiceOff() { invoke(resetServiceOff,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSingleUnit.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  initTimer();   
  lastOnExecuteTicks = Clock.ticks();
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
  setUnitState(new BStatusEnum(BUnitState.off, BStatus.ok));
}
public void doResetServiceOff()  throws Exception
{
  setUnitState(new BStatusEnum(BUnitState.off, BStatus.ok));
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
  updateRuntime();  
}
public void doResetRuntime()  throws Exception
{
  setRuntime(BRelTime.make(0));
}
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  if( p == unitState && (getUnitState().getEnum().getOrdinal() == BUnitState.ALARM || getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF)){  ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("calc"),null,null); }
}

private void updateRuntime(){
  long currentTicks = Clock.ticks();
  if(getUnitState().getEnum().getOrdinal() == BUnitState.ON){setRuntime(BRelTime.make(getRuntime().getMillis () + (currentTicks - lastOnExecuteTicks)));}
  lastOnExecuteTicks = currentTicks;
}

// Глобальные переменные
public Clock.Ticket ticket;   
public Clock.Ticket fbTicket;  
private long lastOnExecuteTicks;  // Tick count at last onExecute 
  
}

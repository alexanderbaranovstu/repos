/*
BEquipmentFMode смотрит на уровень вверх на машину состояний, и в зависимости от состояния 
принимается решение о том в какое положение перевести Out

*/
package com.bc.ahu;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*; 

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

//import javax.baja.schedule.*;
import javax.baja.agent.*;

import javax.baja.control.*;
import javax.baja.control.util.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;
import javax.baja.util.*;
import javax.baja.util.BFormat;
import javax.baja.naming.*;
import javax.baja.registry.*;
// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 

public class BEquipmentFMode extends BBooleanWritable   
{ 
  
  /*-  
  class BEquipmentFMode  
  {  
    properties  
    {  
 
    
      parentMode            :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BAhuState.make(2), BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BAhuState.TYPE) ) ]}
      executeTime           :     BRelTime              flags { HIDDEN }     default {[ BRelTime.make(1000) ]}                                 slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
      alarmRwPosition       :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      alarmPosition         :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      standbyPosition       :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      onPosition            :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      sendAlarmRw           :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("SendToParent"), BString.make("DoNothig") ) ]}
      sendAlarm             :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("SendToParent"), BString.make("DoNothig") ) ]}

    }   
    actions
    {

      timerExpired()                                    flags { hidden }
    }
  }  
  -*/














/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.ahu.BEquipmentFMode(1835267409)1.0$ @*/
/* Generated Fri Oct 22 15:44:30 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "parentMode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code parentMode} property.
   * @see #getParentMode
   * @see #setParentMode
   */
  public static final Property parentMode = newProperty(Flags.SUMMARY, new BStatusEnum(BAhuState.make(2), BStatus.ok), BFacets.makeEnum( BEnumRange.make(BAhuState.TYPE) ));
  
  /**
   * Get the {@code parentMode} property.
   * @see #parentMode
   */
  public BStatusEnum getParentMode() { return (BStatusEnum)get(parentMode); }
  
  /**
   * Set the {@code parentMode} property.
   * @see #parentMode
   */
  public void setParentMode(BStatusEnum v) { set(parentMode, v, null); }

////////////////////////////////////////////////////////////////
// Property "executeTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code executeTime} property.
   * @see #getExecuteTime
   * @see #setExecuteTime
   */
  public static final Property executeTime = newProperty(Flags.HIDDEN, BRelTime.make(1000), BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE));
  
  /**
   * Get the {@code executeTime} property.
   * @see #executeTime
   */
  public BRelTime getExecuteTime() { return (BRelTime)get(executeTime); }
  
  /**
   * Set the {@code executeTime} property.
   * @see #executeTime
   */
  public void setExecuteTime(BRelTime v) { set(executeTime, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmRwPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmRwPosition} property.
   * @see #getAlarmRwPosition
   * @see #setAlarmRwPosition
   */
  public static final Property alarmRwPosition = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code alarmRwPosition} property.
   * @see #alarmRwPosition
   */
  public BStatusBoolean getAlarmRwPosition() { return (BStatusBoolean)get(alarmRwPosition); }
  
  /**
   * Set the {@code alarmRwPosition} property.
   * @see #alarmRwPosition
   */
  public void setAlarmRwPosition(BStatusBoolean v) { set(alarmRwPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmPosition} property.
   * @see #getAlarmPosition
   * @see #setAlarmPosition
   */
  public static final Property alarmPosition = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code alarmPosition} property.
   * @see #alarmPosition
   */
  public BStatusBoolean getAlarmPosition() { return (BStatusBoolean)get(alarmPosition); }
  
  /**
   * Set the {@code alarmPosition} property.
   * @see #alarmPosition
   */
  public void setAlarmPosition(BStatusBoolean v) { set(alarmPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "standbyPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code standbyPosition} property.
   * @see #getStandbyPosition
   * @see #setStandbyPosition
   */
  public static final Property standbyPosition = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code standbyPosition} property.
   * @see #standbyPosition
   */
  public BStatusBoolean getStandbyPosition() { return (BStatusBoolean)get(standbyPosition); }
  
  /**
   * Set the {@code standbyPosition} property.
   * @see #standbyPosition
   */
  public void setStandbyPosition(BStatusBoolean v) { set(standbyPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "onPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code onPosition} property.
   * @see #getOnPosition
   * @see #setOnPosition
   */
  public static final Property onPosition = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code onPosition} property.
   * @see #onPosition
   */
  public BStatusBoolean getOnPosition() { return (BStatusBoolean)get(onPosition); }
  
  /**
   * Set the {@code onPosition} property.
   * @see #onPosition
   */
  public void setOnPosition(BStatusBoolean v) { set(onPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "sendAlarmRw"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code sendAlarmRw} property.
   * @see #getSendAlarmRw
   * @see #setSendAlarmRw
   */
  public static final Property sendAlarmRw = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("SendToParent"), BString.make("DoNothig") ));
  
  /**
   * Get the {@code sendAlarmRw} property.
   * @see #sendAlarmRw
   */
  public BStatusBoolean getSendAlarmRw() { return (BStatusBoolean)get(sendAlarmRw); }
  
  /**
   * Set the {@code sendAlarmRw} property.
   * @see #sendAlarmRw
   */
  public void setSendAlarmRw(BStatusBoolean v) { set(sendAlarmRw, v, null); }

////////////////////////////////////////////////////////////////
// Property "sendAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code sendAlarm} property.
   * @see #getSendAlarm
   * @see #setSendAlarm
   */
  public static final Property sendAlarm = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("SendToParent"), BString.make("DoNothig") ));
  
  /**
   * Get the {@code sendAlarm} property.
   * @see #sendAlarm
   */
  public BStatusBoolean getSendAlarm() { return (BStatusBoolean)get(sendAlarm); }
  
  /**
   * Set the {@code sendAlarm} property.
   * @see #sendAlarm
   */
  public void setSendAlarm(BStatusBoolean v) { set(sendAlarm, v, null); }

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
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEquipmentFMode.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  try { setFlags(getSlot("in1"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in2"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in3"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in3"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in4"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in5"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in6"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in7"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in8"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in9"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in10"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in11"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in12"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in13"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in14"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in15"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("in16"),  Flags.HIDDEN, null);} catch(Exception e) {};
  try { setFlags(getSlot("fallback"),  Flags.HIDDEN, null);} catch(Exception e) {};    
  try { setFlags(getSlot("minActiveTime"),  Flags.HIDDEN, null);} catch(Exception e) {};    
  try { setFlags(getSlot("minInactiveTime"),  Flags.HIDDEN, null);} catch(Exception e) {};    
  try { setFlags(getSlot("overrideExpiration"),  Flags.HIDDEN, null);} catch(Exception e) {};    
  try { setFlags(getSlot("setMinInactiveTimeOnStart"),  Flags.HIDDEN, null);} catch(Exception e) {};    
  
            
  initTimer();
}       
private void initTimer()  
{
  if (ticketEqMode != null) ticketEqMode.cancel();
  ticketEqMode = Clock.schedulePeriodically(this, getExecuteTime(), timerExpired, null);
}

public void doTimerExpired()  throws Exception
{
  if (ticketEqMode != null) ticketEqMode.cancel();
  initTimer();
  try {update();}
  catch(Exception ie) {System.out.println("doTimerExpired update() " + ie);}
  
  
}
// Производим проверку каждый раз по таймеру
public void update() throws Exception  {
  int c = 0;
  //setParentMode((BStatusEnum)this.getParent().get("mode")) ; //BAhuState.make(2), BStatus.ok)
  c = (((BStatusEnum)this.getParent().get("mode")).getValue()).getOrdinal();
  
  //System.out.println(c + " update " + this.getParent().get("mode") );
  switch(c){
    case 0  : set(BBoolean.make(getAlarmRwPosition().getValue())) ;   this.getParentMode().setValue(BAhuState.AlarmRw) ;   break;
    case 1  : set(BBoolean.make(getAlarmPosition().getValue())) ;     this.getParentMode().setValue(BAhuState.Alarm) ;   break;
    case 2  : set(BBoolean.make(getStandbyPosition().getValue())) ;   this.getParentMode().setValue(BAhuState.Standby) ;   break;
    case 3  : set(BBoolean.make(getOnPosition().getValue())) ;        this.getParentMode().setValue(BAhuState.On) ;   break;    
    default : set(BBoolean.make(getStandbyPosition().getValue())) ;   this.getParentMode().setValue(BAhuState.Standby) ;   break;
  }
  if(getSendAlarmRw().getValue() && !getOut().getStatus().isOk()){   ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("setAlarmRw"),null,null); }
  if(getSendAlarm().getValue() && !getOut().getStatus().isOk()){     ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("setAlarm"),null,null); }
}
// update запускается по таймеру.  Но для того что бы не ждать обновления долго при изменении режима работы или уставки - происходит мгновенное обновление
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  
}

// Глобальные переменные
public Clock.Ticket ticketEqMode; 
}
/*
BEquipmentFWinter смотрит на уровень вверх на машину состояний, и в зависимости от переменной Winter 
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

public class BEquipmentFWinter extends BBooleanWritable   
{ 
  
  /*-  
  class BEquipmentFWinter  
  {  
    properties  
    {  
 
    
      parentWinter          :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("Winter"), BString.make("Summer") ) ]}
      executeTime           :     BRelTime              flags { HIDDEN }      default {[ BRelTime.make(1000) ]}                                 slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
      winterPosition        :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      summerPosition        :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
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
/*@ $com.bc.ahu.BEquipmentFWinter(1877835171)1.0$ @*/
/* Generated Fri Oct 22 18:04:44 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "parentWinter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code parentWinter} property.
   * @see #getParentWinter
   * @see #setParentWinter
   */
  public static final Property parentWinter = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("Winter"), BString.make("Summer") ));
  
  /**
   * Get the {@code parentWinter} property.
   * @see #parentWinter
   */
  public BStatusBoolean getParentWinter() { return (BStatusBoolean)get(parentWinter); }
  
  /**
   * Set the {@code parentWinter} property.
   * @see #parentWinter
   */
  public void setParentWinter(BStatusBoolean v) { set(parentWinter, v, null); }

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
// Property "winterPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code winterPosition} property.
   * @see #getWinterPosition
   * @see #setWinterPosition
   */
  public static final Property winterPosition = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code winterPosition} property.
   * @see #winterPosition
   */
  public BStatusBoolean getWinterPosition() { return (BStatusBoolean)get(winterPosition); }
  
  /**
   * Set the {@code winterPosition} property.
   * @see #winterPosition
   */
  public void setWinterPosition(BStatusBoolean v) { set(winterPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "summerPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code summerPosition} property.
   * @see #getSummerPosition
   * @see #setSummerPosition
   */
  public static final Property summerPosition = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code summerPosition} property.
   * @see #summerPosition
   */
  public BStatusBoolean getSummerPosition() { return (BStatusBoolean)get(summerPosition); }
  
  /**
   * Set the {@code summerPosition} property.
   * @see #summerPosition
   */
  public void setSummerPosition(BStatusBoolean v) { set(summerPosition, v, null); }

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
  public static final Type TYPE = Sys.loadType(BEquipmentFWinter.class);

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
  if (ticketEqWinter != null) ticketEqWinter.cancel();
  ticketEqWinter = Clock.schedulePeriodically(this, getExecuteTime(), timerExpired, null);
}

public void doTimerExpired()  throws Exception
{
  if (ticketEqWinter != null) ticketEqWinter.cancel();
  initTimer();
  try {update();}
  catch(Exception ie) {System.out.println("doTimerExpired update() " + ie);}
  
  
}
// Производим проверку каждый раз по таймеру
public void update() throws Exception  {
  int c = 0;
  //c = (((BStatusBoolean)this.getParent().get("winter")).getValue());
  getParentWinter().setValue((((BStatusBoolean)this.getParent().get("winter")).getValue()));
  if(getParentWinter().getValue()){set(BBoolean.make(getWinterPosition().getValue())) ;}
  else{set(BBoolean.make(getSummerPosition().getValue())) ;}
  if(getSendAlarmRw().getValue() && !getOut().getStatus().isOk()){   ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("setAlarmRw"),null,null); }
  if(getSendAlarm().getValue() && !getOut().getStatus().isOk()){     ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("setAlarm"),null,null); }
}
// update запускается по таймеру.  Но для того что бы не ждать обновления долго при изменении режима работы или уставки - происходит мгновенное обновление
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  
}

// Глобальные переменные
public Clock.Ticket ticketEqWinter; 
}
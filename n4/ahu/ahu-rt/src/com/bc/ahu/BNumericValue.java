/*
BNumericValue класс для контроля за аналоговыми значениями посредством стандартного механизва аварий
с возможностью вызовов методов etAlarm(),  setAlarmRw(), посредством установки флагов
                    sendAlarmRw, sendAlarm в положение SendToParent. 
                    

*/
package com.bc.ahu;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*; 

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.units.*;
import javax.baja.agent.*;

import javax.baja.control.*;
import javax.baja.control.util.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;
import javax.baja.util.*;
import javax.baja.util.BFormat;
import javax.baja.naming.*;
import javax.baja.registry.*;
import com.tridium.kitControl.enums.BLoopAction;

public class BNumericValue extends BNumericWritable   
{ 
  
  /*-  
  class BNumericValue  
  {  
    properties  
    {  
      sendAlarmRw           :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("SendToParent"), BString.make("DoNothig") ) ]}
      sendAlarm             :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("SendToParent"), BString.make("DoNothig") ) ]}
    }   
    actions
    {

    }
  }  
  -*/


















/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.ahu.BNumericValue(3561586547)1.0$ @*/
/* Generated Tue Nov 02 08:10:26 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNumericValue.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
}       



// update запускается по таймеру.  Но для того что бы не ждать обновления долго при изменении режима работы или уставки - происходит мгновенное обновление
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  
  if(getSendAlarmRw().getValue() && !getOut().getStatus().isOk()){   ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("setAlarmRw"),null,null); }
  if(getSendAlarm().getValue() && !getOut().getStatus().isOk()){     ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("setAlarm"),null,null); }  
}





}
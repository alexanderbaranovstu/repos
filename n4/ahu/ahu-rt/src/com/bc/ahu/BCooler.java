/*
BCooler класс управления охладителем. Если температура выше уставки - охлаждаем
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

public class BCooler extends BNumericWritable   
{ 
  
  /*-  
  class BCooler  
  {  
    properties  
    {  
     parentMode             :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BAhuState.Standby, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BAhuState.TYPE) ) ]}
     spt                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(15) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     pv                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(25) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     alarmRwPosition        :     BStatusEnum           flags { SUMMARY  }   default {[ new BStatusEnum(BPos.nullPosition, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ) ]}
     alarmPosition          :     BStatusEnum           flags { SUMMARY  }   default {[ new BStatusEnum(BPos.nullPosition, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ) ]}
     standbyPosition        :     BStatusEnum           flags { SUMMARY }    default {[ new BStatusEnum(BPos.nullPosition, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ) ]}
     onPosition             :     BStatusEnum           flags { SUMMARY  }   default {[ new BStatusEnum(BPos.nullPosition, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ) ]}
     minY                  :     BStatusNumeric        flags {  }            default {[ new BStatusNumeric(0) ]}                                     slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0) ]}
     maxY                  :     BStatusNumeric        flags {  }            default {[ new BStatusNumeric(100) ]}                                   slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0) ]}
     PID                    :     BPid                  flags { SUMMARY }     default {[ new BPid() ]} 

     executeTime            :     BRelTime              flags { hidden }      default {[ BRelTime.make(1000) ]}                                       slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
    }   
    actions
    {
      timerExpired()                                    flags { hidden }
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.ahu.BCooler(4041324687)1.0$ @*/
/* Generated Mon Nov 01 08:57:57 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "parentMode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code parentMode} property.
   * @see #getParentMode
   * @see #setParentMode
   */
  public static final Property parentMode = newProperty(Flags.SUMMARY, new BStatusEnum(BAhuState.Standby, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BAhuState.TYPE) ));
  
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
// Property "spt"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code spt} property.
   * @see #getSpt
   * @see #setSpt
   */
  public static final Property spt = newProperty(Flags.SUMMARY, new BStatusNumeric(15), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code spt} property.
   * @see #spt
   */
  public BStatusNumeric getSpt() { return (BStatusNumeric)get(spt); }
  
  /**
   * Set the {@code spt} property.
   * @see #spt
   */
  public void setSpt(BStatusNumeric v) { set(spt, v, null); }

////////////////////////////////////////////////////////////////
// Property "pv"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pv} property.
   * @see #getPv
   * @see #setPv
   */
  public static final Property pv = newProperty(Flags.SUMMARY, new BStatusNumeric(25), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code pv} property.
   * @see #pv
   */
  public BStatusNumeric getPv() { return (BStatusNumeric)get(pv); }
  
  /**
   * Set the {@code pv} property.
   * @see #pv
   */
  public void setPv(BStatusNumeric v) { set(pv, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmRwPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmRwPosition} property.
   * @see #getAlarmRwPosition
   * @see #setAlarmRwPosition
   */
  public static final Property alarmRwPosition = newProperty(Flags.SUMMARY, new BStatusEnum(BPos.nullPosition, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ));
  
  /**
   * Get the {@code alarmRwPosition} property.
   * @see #alarmRwPosition
   */
  public BStatusEnum getAlarmRwPosition() { return (BStatusEnum)get(alarmRwPosition); }
  
  /**
   * Set the {@code alarmRwPosition} property.
   * @see #alarmRwPosition
   */
  public void setAlarmRwPosition(BStatusEnum v) { set(alarmRwPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmPosition} property.
   * @see #getAlarmPosition
   * @see #setAlarmPosition
   */
  public static final Property alarmPosition = newProperty(Flags.SUMMARY, new BStatusEnum(BPos.nullPosition, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ));
  
  /**
   * Get the {@code alarmPosition} property.
   * @see #alarmPosition
   */
  public BStatusEnum getAlarmPosition() { return (BStatusEnum)get(alarmPosition); }
  
  /**
   * Set the {@code alarmPosition} property.
   * @see #alarmPosition
   */
  public void setAlarmPosition(BStatusEnum v) { set(alarmPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "standbyPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code standbyPosition} property.
   * @see #getStandbyPosition
   * @see #setStandbyPosition
   */
  public static final Property standbyPosition = newProperty(Flags.SUMMARY, new BStatusEnum(BPos.nullPosition, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ));
  
  /**
   * Get the {@code standbyPosition} property.
   * @see #standbyPosition
   */
  public BStatusEnum getStandbyPosition() { return (BStatusEnum)get(standbyPosition); }
  
  /**
   * Set the {@code standbyPosition} property.
   * @see #standbyPosition
   */
  public void setStandbyPosition(BStatusEnum v) { set(standbyPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "onPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code onPosition} property.
   * @see #getOnPosition
   * @see #setOnPosition
   */
  public static final Property onPosition = newProperty(Flags.SUMMARY, new BStatusEnum(BPos.nullPosition, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ));
  
  /**
   * Get the {@code onPosition} property.
   * @see #onPosition
   */
  public BStatusEnum getOnPosition() { return (BStatusEnum)get(onPosition); }
  
  /**
   * Set the {@code onPosition} property.
   * @see #onPosition
   */
  public void setOnPosition(BStatusEnum v) { set(onPosition, v, null); }

////////////////////////////////////////////////////////////////
// Property "minY"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code minY} property.
   * @see #getMinY
   * @see #setMinY
   */
  public static final Property minY = newProperty(0, new BStatusNumeric(0), BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0));
  
  /**
   * Get the {@code minY} property.
   * @see #minY
   */
  public BStatusNumeric getMinY() { return (BStatusNumeric)get(minY); }
  
  /**
   * Set the {@code minY} property.
   * @see #minY
   */
  public void setMinY(BStatusNumeric v) { set(minY, v, null); }

////////////////////////////////////////////////////////////////
// Property "maxY"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code maxY} property.
   * @see #getMaxY
   * @see #setMaxY
   */
  public static final Property maxY = newProperty(0, new BStatusNumeric(100), BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0));
  
  /**
   * Get the {@code maxY} property.
   * @see #maxY
   */
  public BStatusNumeric getMaxY() { return (BStatusNumeric)get(maxY); }
  
  /**
   * Set the {@code maxY} property.
   * @see #maxY
   */
  public void setMaxY(BStatusNumeric v) { set(maxY, v, null); }

////////////////////////////////////////////////////////////////
// Property "PID"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code PID} property.
   * @see #getPID
   * @see #setPID
   */
  public static final Property PID = newProperty(Flags.SUMMARY, new BPid(), null);
  
  /**
   * Get the {@code PID} property.
   * @see #PID
   */
  public BPid getPID() { return (BPid)get(PID); }
  
  /**
   * Set the {@code PID} property.
   * @see #PID
   */
  public void setPID(BPid v) { set(PID, v, null); }

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
  public static final Type TYPE = Sys.loadType(BCooler.class);

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
  
  setFacets(BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0));
            
  initTimer();
}       
private void initTimer()  
{
  if (ticketCooler != null) ticketCooler.cancel();
  ticketCooler = Clock.schedulePeriodically(this, getExecuteTime(), timerExpired, null);
}

public void doTimerExpired()  throws Exception
{
  if (ticketCooler != null) ticketCooler.cancel();
  initTimer();
  try {update();}
  catch(Exception ie) {System.out.println("doTimerExpired update() " + ie);}
  
  
}
// Производим проверку каждый раз по таймеру

public void update() throws Exception  {
  getParentMode().setValue( ((BStatusEnum)this.getParent().get("mode")).getValue() );
  int c = getParentMode().getValue().getOrdinal() ;
  // Send data to regulator and get back control value
  
  
  switch(c){
    case 0 : getPositionValue(getAlarmRwPosition().getValue().getOrdinal());    break; //BAhuState.AlarmRw  
    case 1 : getPositionValue(getAlarmPosition().getValue().getOrdinal());  break; //BAhuState.Alarm    
    case 2 : getPositionValue(getStandbyPosition().getValue().getOrdinal());  break; //BAhuState.Standby    
    case 3 : getPositionValue(getOnPosition().getValue().getOrdinal());  break; //BAhuState.On   
  }

}
void getPositionValue(int i){
  
  switch(i){
    case 0 : set(BDouble.NaN);                              getOut().setStatusNull(true);         getPID().getLoopEnable().setValue(false);      break; //BPos.nullPosition
    case 1 : set(BDouble.make(0));                          getOut().setStatusNull(false);        getPID().getLoopEnable().setValue(false);      break; //BPos.zeroPosition
    case 2 : set(BDouble.make(getMinY().getValue()));      getOut().setStatusNull(false);        getPID().getLoopEnable().setValue(false);      break; //BPos.minPosition
    case 3 : set(BDouble.make(getMaxY().getValue()));      getOut().setStatusNull(false);        getPID().getLoopEnable().setValue(false);      break; //BPos.maxPosition
    case 4 :                                                getOut().setStatusNull(false);        getPID().getLoopEnable().setValue(false);      break; //BPos.holdPosition
    case 5 : 
      
        if( ((BStatusBoolean)getParent().get("winter")).getValue() ){
          getPID().getLoopEnable().setValue(false); 
        }
        else{
          getPID().getLoopEnable().setValue(true); 
        }
       
      //this.getOut().setStatusNull(false); 
      //System.out.println(" da1 " + da1 + " da2 " + da2 + " da1sum " + da1sum + " da2sum " + da2sum + " result " + result);
      getPID().getControlledVariable().setValue( getPv().getValue() );
      getPID().getSetpoint().setValue( getSpt().getValue() );

      getPID().setMinimumOutput(getMinY().getValue());
      getPID().setMaximumOutput(getMaxY().getValue());
      set(BDouble.make( getPID().getOut().getValue() ) );     
                
    break; //BPos.regulator    
  }
//     minDa                  :     BStatusNumeric        flags {  }            default {[ new BStatusNumeric(0) ]}                                     slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0) ]}


}
// update запускается по таймеру.  Но для того что бы не ждать обновления долго при изменении режима работы или уставки - происходит мгновенное обновление
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  
}

// Глобальные переменные
public Clock.Ticket ticketCooler; 
public BIcon getIcon() { return icon; }
private static final BIcon icon = BIcon.std("navOnly/modules.png");

}
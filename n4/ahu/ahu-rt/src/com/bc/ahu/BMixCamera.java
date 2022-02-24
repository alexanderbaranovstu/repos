/*
BMixCamera класс управления камерой смешения. В общем случае мы располааем температурой tempRet вытяжного воздуха, темпратурой на улице tempOut, понимаем расход в прямом с удице каналом flowSup и расход
по линии камеры смешения flowRet. ожидаемая температура в камере смешения tempEst получается посредством интегрирования. предположим что расход через заслонку притока меняется линейно от 0 до flowSup
в диапазоне от 0-100% открытия DA1, и от 0 до flowRet в диапазоне от 100-0% открытия DA1. 
тогда 
getPID().getControlledVariable().setValue( tempOut*DA1/100*flowSup + tempRet*( (100 -DA1) / 100)*flowSup);
getPID().getSetpoint().setValue( tempEst );
set(getPID().getOut());
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

public class BMixCamera extends BNumericWritable   
{ 
  
  /*-  
  class BMixCamera  
  {  
    properties  
    {  
     parentMode             :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BAhuState.Standby, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BAhuState.TYPE) ) ]}
     flowSup                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(3000) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("cubic meters per hour"), 0) ]}
     flowRet                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(3000) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("cubic meters per hour"), 0) ]}
     tempOut                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(15) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     tempRet                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(25) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     tempEst                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(20) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     tempEstSp              :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(20) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     alarmRwPosition        :     BStatusEnum           flags { SUMMARY  }   default {[ new BStatusEnum(BPos.nullPosition, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ) ]}
     alarmPosition          :     BStatusEnum           flags { SUMMARY  }   default {[ new BStatusEnum(BPos.nullPosition, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ) ]}
     standbyPosition        :     BStatusEnum           flags { SUMMARY }    default {[ new BStatusEnum(BPos.nullPosition, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ) ]}
     onPosition             :     BStatusEnum           flags { SUMMARY  }   default {[ new BStatusEnum(BPos.nullPosition, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BPos.TYPE) ) ]}
     minDa                  :     BStatusNumeric        flags {  }            default {[ new BStatusNumeric(0) ]}                                     slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0) ]}
     maxDa                  :     BStatusNumeric        flags {  }            default {[ new BStatusNumeric(100) ]}                                   slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0) ]}
     PID                    :     BPid                  flags { hidden }     default {[ new BPid() ]} 

     executeTime            :     BRelTime              flags { hidden }      default {[ BRelTime.make(1000) ]}                                       slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
    }   
    actions
    {
      timerExpired()                                    flags { hidden }
    }
  }  
  -*/

















/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.ahu.BMixCamera(1352388536)1.0$ @*/
/* Generated Mon Nov 01 07:32:33 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "flowSup"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code flowSup} property.
   * @see #getFlowSup
   * @see #setFlowSup
   */
  public static final Property flowSup = newProperty(Flags.SUMMARY, new BStatusNumeric(3000), BFacets.makeNumeric(UnitDatabase.getUnit("cubic meters per hour"), 0));
  
  /**
   * Get the {@code flowSup} property.
   * @see #flowSup
   */
  public BStatusNumeric getFlowSup() { return (BStatusNumeric)get(flowSup); }
  
  /**
   * Set the {@code flowSup} property.
   * @see #flowSup
   */
  public void setFlowSup(BStatusNumeric v) { set(flowSup, v, null); }

////////////////////////////////////////////////////////////////
// Property "flowRet"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code flowRet} property.
   * @see #getFlowRet
   * @see #setFlowRet
   */
  public static final Property flowRet = newProperty(Flags.SUMMARY, new BStatusNumeric(3000), BFacets.makeNumeric(UnitDatabase.getUnit("cubic meters per hour"), 0));
  
  /**
   * Get the {@code flowRet} property.
   * @see #flowRet
   */
  public BStatusNumeric getFlowRet() { return (BStatusNumeric)get(flowRet); }
  
  /**
   * Set the {@code flowRet} property.
   * @see #flowRet
   */
  public void setFlowRet(BStatusNumeric v) { set(flowRet, v, null); }

////////////////////////////////////////////////////////////////
// Property "tempOut"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code tempOut} property.
   * @see #getTempOut
   * @see #setTempOut
   */
  public static final Property tempOut = newProperty(Flags.SUMMARY, new BStatusNumeric(15), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code tempOut} property.
   * @see #tempOut
   */
  public BStatusNumeric getTempOut() { return (BStatusNumeric)get(tempOut); }
  
  /**
   * Set the {@code tempOut} property.
   * @see #tempOut
   */
  public void setTempOut(BStatusNumeric v) { set(tempOut, v, null); }

////////////////////////////////////////////////////////////////
// Property "tempRet"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code tempRet} property.
   * @see #getTempRet
   * @see #setTempRet
   */
  public static final Property tempRet = newProperty(Flags.SUMMARY, new BStatusNumeric(25), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code tempRet} property.
   * @see #tempRet
   */
  public BStatusNumeric getTempRet() { return (BStatusNumeric)get(tempRet); }
  
  /**
   * Set the {@code tempRet} property.
   * @see #tempRet
   */
  public void setTempRet(BStatusNumeric v) { set(tempRet, v, null); }

////////////////////////////////////////////////////////////////
// Property "tempEst"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code tempEst} property.
   * @see #getTempEst
   * @see #setTempEst
   */
  public static final Property tempEst = newProperty(Flags.SUMMARY, new BStatusNumeric(20), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code tempEst} property.
   * @see #tempEst
   */
  public BStatusNumeric getTempEst() { return (BStatusNumeric)get(tempEst); }
  
  /**
   * Set the {@code tempEst} property.
   * @see #tempEst
   */
  public void setTempEst(BStatusNumeric v) { set(tempEst, v, null); }

////////////////////////////////////////////////////////////////
// Property "tempEstSp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code tempEstSp} property.
   * @see #getTempEstSp
   * @see #setTempEstSp
   */
  public static final Property tempEstSp = newProperty(Flags.SUMMARY, new BStatusNumeric(20), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code tempEstSp} property.
   * @see #tempEstSp
   */
  public BStatusNumeric getTempEstSp() { return (BStatusNumeric)get(tempEstSp); }
  
  /**
   * Set the {@code tempEstSp} property.
   * @see #tempEstSp
   */
  public void setTempEstSp(BStatusNumeric v) { set(tempEstSp, v, null); }

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
// Property "minDa"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code minDa} property.
   * @see #getMinDa
   * @see #setMinDa
   */
  public static final Property minDa = newProperty(0, new BStatusNumeric(0), BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0));
  
  /**
   * Get the {@code minDa} property.
   * @see #minDa
   */
  public BStatusNumeric getMinDa() { return (BStatusNumeric)get(minDa); }
  
  /**
   * Set the {@code minDa} property.
   * @see #minDa
   */
  public void setMinDa(BStatusNumeric v) { set(minDa, v, null); }

////////////////////////////////////////////////////////////////
// Property "maxDa"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code maxDa} property.
   * @see #getMaxDa
   * @see #setMaxDa
   */
  public static final Property maxDa = newProperty(0, new BStatusNumeric(100), BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0));
  
  /**
   * Get the {@code maxDa} property.
   * @see #maxDa
   */
  public BStatusNumeric getMaxDa() { return (BStatusNumeric)get(maxDa); }
  
  /**
   * Set the {@code maxDa} property.
   * @see #maxDa
   */
  public void setMaxDa(BStatusNumeric v) { set(maxDa, v, null); }

////////////////////////////////////////////////////////////////
// Property "PID"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code PID} property.
   * @see #getPID
   * @see #setPID
   */
  public static final Property PID = newProperty(Flags.HIDDEN, new BPid(), null);
  
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
  public static final Type TYPE = Sys.loadType(BMixCamera.class);

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
  if (ticketMixCamera != null) ticketMixCamera.cancel();
  ticketMixCamera = Clock.schedulePeriodically(this, getExecuteTime(), timerExpired, null);
}

public void doTimerExpired()  throws Exception
{
  if (ticketMixCamera != null) ticketMixCamera.cancel();
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
    case 2 : set(BDouble.make(getMinDa().getValue()));      getOut().setStatusNull(false);        getPID().getLoopEnable().setValue(false);      break; //BPos.minPosition
    case 3 : set(BDouble.make(getMaxDa().getValue()));      getOut().setStatusNull(false);        getPID().getLoopEnable().setValue(false);      break; //BPos.maxPosition
    case 4 :                                                getOut().setStatusNull(false);        getPID().getLoopEnable().setValue(false);      break; //BPos.holdPosition
    case 5 : 
      getPID().getLoopEnable().setValue(true); 
      getOut().setStatusNull(false); 
      double da1 = reset(getOut().getValue(),0,100,0,getFlowSup().getValue());
      double da2 = reset(getOut().getValue(),0,100,getFlowRet().getValue(),0);
      double sum = (getFlowSup().getValue()+getFlowRet().getValue())/2;
      double da1sum = da1/sum;
      double da2sum = da2/sum;
      double result = da1sum*getTempOut().getValue() + da2sum*getTempRet().getValue();
      //System.out.println(" da1 " + da1 + " da2 " + da2 + " da1sum " + da1sum + " da2sum " + da2sum + " result " + result);
      getTempEst().setValue(result);
      getPID().getControlledVariable().setValue( getTempEst().getValue() );
       // Если уличная температура выше комнатной на 1 градус то следует поддерживать в камере смешения уставку на уровне TempRet
      if(getTempOut().getValue() > (getTempRet().getValue() + 1)){
        getPID().getSetpoint().setValue( getTempRet().getValue() );
        getPID().setLoopAction(BLoopAction.reverse );
      }
      else if (getTempOut().getValue() < getTempRet().getValue()) {
        getPID().getSetpoint().setValue( getTempEstSp().getValue() );
        getPID().setLoopAction(BLoopAction.direct );
      }
      
      getPID().setMinimumOutput(getMinDa().getValue());
      getPID().setMaximumOutput(getMaxDa().getValue());
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
  private static double reset(double x, 
                              double inputLowLimit, 
                              double inputHighLimit, 
                              double outputLowLimit, 
                              double outputHighLimit)
  {
    if (x < inputLowLimit)
      return outputLowLimit;
    else if (x > inputHighLimit)
      return outputHighLimit;
    else
    {
      return (((outputHighLimit-outputLowLimit)/(inputHighLimit-inputLowLimit)
              *  (x-inputLowLimit) + outputLowLimit));     
    }
  }
// Глобальные переменные
public Clock.Ticket ticketMixCamera; 

  public BIcon getIcon() { return icon; }
  private static final BIcon icon = BIcon.std("navOnly/stationCopier.png");


}
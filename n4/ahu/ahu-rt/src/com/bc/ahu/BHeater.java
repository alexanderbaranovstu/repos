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

public class BHeater extends BNumericWritable   
{ 
  
  /*-  
  class BHeater  
  {  
    properties  
    {  
     parentMode             :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BAhuState.Standby, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BAhuState.TYPE) ) ]}
     spt                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(15) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     t2                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(25) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     t3                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(25) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     t4                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(25) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     calcSp                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(25) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     rwSp                :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(12) ]}                                      slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]}
     minY                  :     BStatusNumeric        flags {  }            default {[ new BStatusNumeric(0) ]}                                     slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0) ]}
     maxY                  :     BStatusNumeric        flags {  }            default {[ new BStatusNumeric(100) ]}                                   slotfacets {[ BFacets.makeNumeric(UnitDatabase.getUnit("percent"), 0) ]}
     PID                    :     BPid                  flags { SUMMARY }     default {[ new BPid() ]} 
     CSCD                    :     BPid                  flags { SUMMARY }     default {[ new BPid() ]} 
     RW                    :     BPid                  flags { SUMMARY }     default {[ new BPid() ]} 

     executeTime            :     BRelTime              flags { hidden }      default {[ BRelTime.make(1000) ]}                                       slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
    }   
    actions
    {
      timerExpired()                                    flags { hidden }
    }
  }  
  -*/




/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.ahu.BHeater(2980783252)1.0$ @*/
/* Generated Tue Nov 02 06:29:31 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "t2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code t2} property.
   * @see #getT2
   * @see #setT2
   */
  public static final Property t2 = newProperty(Flags.SUMMARY, new BStatusNumeric(25), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code t2} property.
   * @see #t2
   */
  public BStatusNumeric getT2() { return (BStatusNumeric)get(t2); }
  
  /**
   * Set the {@code t2} property.
   * @see #t2
   */
  public void setT2(BStatusNumeric v) { set(t2, v, null); }

////////////////////////////////////////////////////////////////
// Property "t3"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code t3} property.
   * @see #getT3
   * @see #setT3
   */
  public static final Property t3 = newProperty(Flags.SUMMARY, new BStatusNumeric(25), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code t3} property.
   * @see #t3
   */
  public BStatusNumeric getT3() { return (BStatusNumeric)get(t3); }
  
  /**
   * Set the {@code t3} property.
   * @see #t3
   */
  public void setT3(BStatusNumeric v) { set(t3, v, null); }

////////////////////////////////////////////////////////////////
// Property "t4"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code t4} property.
   * @see #getT4
   * @see #setT4
   */
  public static final Property t4 = newProperty(Flags.SUMMARY, new BStatusNumeric(25), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code t4} property.
   * @see #t4
   */
  public BStatusNumeric getT4() { return (BStatusNumeric)get(t4); }
  
  /**
   * Set the {@code t4} property.
   * @see #t4
   */
  public void setT4(BStatusNumeric v) { set(t4, v, null); }

////////////////////////////////////////////////////////////////
// Property "calcSp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code calcSp} property.
   * @see #getCalcSp
   * @see #setCalcSp
   */
  public static final Property calcSp = newProperty(Flags.SUMMARY, new BStatusNumeric(25), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code calcSp} property.
   * @see #calcSp
   */
  public BStatusNumeric getCalcSp() { return (BStatusNumeric)get(calcSp); }
  
  /**
   * Set the {@code calcSp} property.
   * @see #calcSp
   */
  public void setCalcSp(BStatusNumeric v) { set(calcSp, v, null); }

////////////////////////////////////////////////////////////////
// Property "rwSp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code rwSp} property.
   * @see #getRwSp
   * @see #setRwSp
   */
  public static final Property rwSp = newProperty(Flags.SUMMARY, new BStatusNumeric(12), BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1));
  
  /**
   * Get the {@code rwSp} property.
   * @see #rwSp
   */
  public BStatusNumeric getRwSp() { return (BStatusNumeric)get(rwSp); }
  
  /**
   * Set the {@code rwSp} property.
   * @see #rwSp
   */
  public void setRwSp(BStatusNumeric v) { set(rwSp, v, null); }

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
// Property "CSCD"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code CSCD} property.
   * @see #getCSCD
   * @see #setCSCD
   */
  public static final Property CSCD = newProperty(Flags.SUMMARY, new BPid(), null);
  
  /**
   * Get the {@code CSCD} property.
   * @see #CSCD
   */
  public BPid getCSCD() { return (BPid)get(CSCD); }
  
  /**
   * Set the {@code CSCD} property.
   * @see #CSCD
   */
  public void setCSCD(BPid v) { set(CSCD, v, null); }

////////////////////////////////////////////////////////////////
// Property "RW"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code RW} property.
   * @see #getRW
   * @see #setRW
   */
  public static final Property RW = newProperty(Flags.SUMMARY, new BPid(), null);
  
  /**
   * Get the {@code RW} property.
   * @see #RW
   */
  public BPid getRW() { return (BPid)get(RW); }
  
  /**
   * Set the {@code RW} property.
   * @see #RW
   */
  public void setRW(BPid v) { set(RW, v, null); }

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
  public static final Type TYPE = Sys.loadType(BHeater.class);

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
  if (ticketHeater != null) ticketHeater.cancel();
  ticketHeater = Clock.schedulePeriodically(this, getExecuteTime(), timerExpired, null);
}

public void doTimerExpired()  throws Exception
{
  if (ticketHeater != null) ticketHeater.cancel();
  initTimer();
  try {update();}
  catch(Exception ie) {System.out.println("doTimerExpired update() " + ie);}
  
  
}
// Производим проверку каждый раз по таймеру

public void update() throws Exception  {
  getParentMode().setValue( ((BStatusEnum)this.getParent().get("mode")).getValue() );
  int c = getParentMode().getValue().getOrdinal() ;
  // Send data to regulator and get back control value
  
  if(c==3){
      if( !((BStatusBoolean)getParent().get("winter")).getValue() ){
          getPID().getLoopEnable().setValue(false); 
      }
      else{
          getPID().getLoopEnable().setValue(true); 
      }
    getRW().getSetpoint().setValue( getRwSp().getValue() );
  }
  else{
     getPID().getLoopEnable().setValue(false);    
     getRW().getSetpoint().setValue( 25 );
  }
  //*******************************************
     getOut().setStatusNull(false); 
      
      getCSCD().getControlledVariable().setValue( getT4().getValue() );
      getCSCD().getSetpoint().setValue( getSpt().getValue() );
      
      getCalcSp().setValue(    getSpt().getValue() + getCSCD().getOut().getValue() );

      getPID().getControlledVariable().setValue( getT3().getValue() );
      getPID().getSetpoint().setValue( getCalcSp().getValue() );
      getPID().setMinimumOutput(getMinY().getValue());
      getPID().setMaximumOutput(getMaxY().getValue());
      
      getRW().getControlledVariable().setValue( getT2().getValue() );
      

      if(getRW().getOut().getValue() > getPID().getOut().getValue()){
                set(BDouble.make( getRW().getOut().getValue() ) ); 
      }
      else{     set(BDouble.make( getPID().getOut().getValue() ) );   
      } 
 

}


// update запускается по таймеру.  Но для того что бы не ждать обновления долго при изменении режима работы или уставки - происходит мгновенное обновление
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do. 
  super.changed(p, cx);
  
}

// Глобальные переменные
public Clock.Ticket ticketHeater; 
  public BIcon getIcon() { return icon; }
  private static final BIcon icon = BIcon.std("navOnly/boxService.png");

}
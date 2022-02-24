package com.bc.CommonLogic.rotator;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.control.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;

 
public class BPumpRotator extends BComponent  
{  

  /*-  
  class BPumpRotator  
  {  
    properties  
    {  
      rotatePeriod: BRelTime
        slotfacets {[ BFacets.make(BFacets.MIN, BRelTime.makeSeconds(0)) ]}
        default {[ BRelTime.make(10000l) ]}
      alarmDelay: BRelTime
        slotfacets {[ BFacets.make(BFacets.MIN, BRelTime.makeSeconds(0)) ]}
        default {[ BRelTime.make(1000l) ]}
      numberOutputs: int
        default {[ 1 ]}
        slotfacets {[ BFacets.makeInt(null, 1, 2) ]}         
      Pump1: BPumpUnit 
         default {[ new BPumpUnit() ]}

      Pump2: BPumpUnit 
         default {[ new BPumpUnit() ]}

      Pump3: BPumpUnit 
         default {[ new BPumpUnit() ]}         
    }   
    actions
    {
      onTimerExpired()
        flags { SUMMARY }

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.rotator.BPumpRotator(2328180075)1.0$ @*/
/* Generated Tue Jan 19 15:41:39 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "rotatePeriod"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>rotatePeriod</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#getRotatePeriod
   * @see com.bc.CommonLogic.rotator.BPumpRotator#setRotatePeriod
   */
  public static final Property rotatePeriod = newProperty(0, BRelTime.make(10000l),BFacets.make(BFacets.MIN, BRelTime.makeSeconds(0)));
  
  /**
   * Get the <code>rotatePeriod</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#rotatePeriod
   */
  public BRelTime getRotatePeriod() { return (BRelTime)get(rotatePeriod); }
  
  /**
   * Set the <code>rotatePeriod</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#rotatePeriod
   */
  public void setRotatePeriod(BRelTime v) { set(rotatePeriod,v,null); }

////////////////////////////////////////////////////////////////
// Property "alarmDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alarmDelay</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#getAlarmDelay
   * @see com.bc.CommonLogic.rotator.BPumpRotator#setAlarmDelay
   */
  public static final Property alarmDelay = newProperty(0, BRelTime.make(1000l),BFacets.make(BFacets.MIN, BRelTime.makeSeconds(0)));
  
  /**
   * Get the <code>alarmDelay</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#alarmDelay
   */
  public BRelTime getAlarmDelay() { return (BRelTime)get(alarmDelay); }
  
  /**
   * Set the <code>alarmDelay</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#alarmDelay
   */
  public void setAlarmDelay(BRelTime v) { set(alarmDelay,v,null); }

////////////////////////////////////////////////////////////////
// Property "numberOutputs"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>numberOutputs</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#getNumberOutputs
   * @see com.bc.CommonLogic.rotator.BPumpRotator#setNumberOutputs
   */
  public static final Property numberOutputs = newProperty(0, 1,BFacets.makeInt(null, 1, 2));
  
  /**
   * Get the <code>numberOutputs</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#numberOutputs
   */
  public int getNumberOutputs() { return getInt(numberOutputs); }
  
  /**
   * Set the <code>numberOutputs</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#numberOutputs
   */
  public void setNumberOutputs(int v) { setInt(numberOutputs,v,null); }

////////////////////////////////////////////////////////////////
// Property "Pump1"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>Pump1</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#getPump1
   * @see com.bc.CommonLogic.rotator.BPumpRotator#setPump1
   */
  public static final Property Pump1 = newProperty(0, new BPumpUnit(),null);
  
  /**
   * Get the <code>Pump1</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#Pump1
   */
  public BPumpUnit getPump1() { return (BPumpUnit)get(Pump1); }
  
  /**
   * Set the <code>Pump1</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#Pump1
   */
  public void setPump1(BPumpUnit v) { set(Pump1,v,null); }

////////////////////////////////////////////////////////////////
// Property "Pump2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>Pump2</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#getPump2
   * @see com.bc.CommonLogic.rotator.BPumpRotator#setPump2
   */
  public static final Property Pump2 = newProperty(0, new BPumpUnit(),null);
  
  /**
   * Get the <code>Pump2</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#Pump2
   */
  public BPumpUnit getPump2() { return (BPumpUnit)get(Pump2); }
  
  /**
   * Set the <code>Pump2</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#Pump2
   */
  public void setPump2(BPumpUnit v) { set(Pump2,v,null); }

////////////////////////////////////////////////////////////////
// Property "Pump3"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>Pump3</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#getPump3
   * @see com.bc.CommonLogic.rotator.BPumpRotator#setPump3
   */
  public static final Property Pump3 = newProperty(0, new BPumpUnit(),null);
  
  /**
   * Get the <code>Pump3</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#Pump3
   */
  public BPumpUnit getPump3() { return (BPumpUnit)get(Pump3); }
  
  /**
   * Set the <code>Pump3</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#Pump3
   */
  public void setPump3(BPumpUnit v) { set(Pump3,v,null); }

////////////////////////////////////////////////////////////////
// Action "onTimerExpired"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>onTimerExpired</code> action.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#onTimerExpired()
   */
  public static final Action onTimerExpired = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>onTimerExpired</code> action.
   * @see com.bc.CommonLogic.rotator.BPumpRotator#onTimerExpired
   */
  public void onTimerExpired() { invoke(onTimerExpired,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPumpRotator.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void started()
  {
    //doOnTimerExpired();
  }
  
 
 
  public void doOnTimerExpired()
  {
    if (onTicket != null) onTicket.cancel();
    onTicket = Clock.schedule(this, getRotatePeriod(), onTimerExpired, null);
    System.out.println(" Ping..... " + PUMP.length  );
    calculate();
    
  }
  
  private void calculate(){
    PUMP[0] = getPump1();
    PUMP[1] = getPump2();
    PUMP[2] = getPump3();    
    // задача такова - из массива из трех элементов выбрать рабочий разрешенный насос насос с минимальной наработкой
    // авария это когда есть сигнал на запуск но за заданное время не приходит сигнал обратной связи или появляется сигнал аварии
    
    
  }
  private Clock.Ticket onTicket;      // Used to manage the current timer  
  
  private static BPumpUnit[] PUMP = {null,null,null};
  
  
} 

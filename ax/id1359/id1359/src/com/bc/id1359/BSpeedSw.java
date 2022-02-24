/*
объект шаг представляет собой 
req
fb
state=toOn,On,toOff,Off,fbAlarm
delay
cntr
waitingFlag
работа по переключению ступеней вообще 
Таким образом прежде чем включить какой либо пускатель мы должны убедиться
что waitingFlag не установлен ни на одном из пускателей
далее  

*/     
package com.bc.id1359;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;


import javax.baja.agent.*;

import javax.baja.control.*;
import javax.baja.status.*;

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BSpeedSw extends BComponent
{ 
  
  /*-  
  class BSpeedSw  
  {  
    properties  
    {  
      speedRequest          :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}
      speedInt              :     BStatusNumeric        flags { READONLY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}        slotfacets{[ BFacets.makeNumeric(null,0) ]}
      s1                    :     BContactor        flags { SUMMARY }     default {[ new BContactor() ]}
      s2                    :     BContactor        flags { SUMMARY }     default {[ new BContactor() ]}
      s3                    :     BContactor        flags { SUMMARY }     default {[ new BContactor() ]}

    }   
    actions
    {
 
      timerExpired()                                    flags { hidden }                             
      resetAlarm()                                                                

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.id1359.BSpeedSw(3259500415)1.0$ @*/
/* Generated Thu Dec 16 11:53:19 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "speedRequest"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>speedRequest</code> property.
   * @see com.bc.id1359.BSpeedSw#getSpeedRequest
   * @see com.bc.id1359.BSpeedSw#setSpeedRequest
   */
  public static final Property speedRequest = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.ok),null);
  
  /**
   * Get the <code>speedRequest</code> property.
   * @see com.bc.id1359.BSpeedSw#speedRequest
   */
  public BStatusNumeric getSpeedRequest() { return (BStatusNumeric)get(speedRequest); }
  
  /**
   * Set the <code>speedRequest</code> property.
   * @see com.bc.id1359.BSpeedSw#speedRequest
   */
  public void setSpeedRequest(BStatusNumeric v) { set(speedRequest,v,null); }

////////////////////////////////////////////////////////////////
// Property "speedInt"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>speedInt</code> property.
   * @see com.bc.id1359.BSpeedSw#getSpeedInt
   * @see com.bc.id1359.BSpeedSw#setSpeedInt
   */
  public static final Property speedInt = newProperty(Flags.READONLY, new BStatusNumeric(0, BStatus.ok),BFacets.makeNumeric(null,0));
  
  /**
   * Get the <code>speedInt</code> property.
   * @see com.bc.id1359.BSpeedSw#speedInt
   */
  public BStatusNumeric getSpeedInt() { return (BStatusNumeric)get(speedInt); }
  
  /**
   * Set the <code>speedInt</code> property.
   * @see com.bc.id1359.BSpeedSw#speedInt
   */
  public void setSpeedInt(BStatusNumeric v) { set(speedInt,v,null); }

////////////////////////////////////////////////////////////////
// Property "s1"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>s1</code> property.
   * @see com.bc.id1359.BSpeedSw#getS1
   * @see com.bc.id1359.BSpeedSw#setS1
   */
  public static final Property s1 = newProperty(Flags.SUMMARY, new BContactor(),null);
  
  /**
   * Get the <code>s1</code> property.
   * @see com.bc.id1359.BSpeedSw#s1
   */
  public BContactor getS1() { return (BContactor)get(s1); }
  
  /**
   * Set the <code>s1</code> property.
   * @see com.bc.id1359.BSpeedSw#s1
   */
  public void setS1(BContactor v) { set(s1,v,null); }

////////////////////////////////////////////////////////////////
// Property "s2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>s2</code> property.
   * @see com.bc.id1359.BSpeedSw#getS2
   * @see com.bc.id1359.BSpeedSw#setS2
   */
  public static final Property s2 = newProperty(Flags.SUMMARY, new BContactor(),null);
  
  /**
   * Get the <code>s2</code> property.
   * @see com.bc.id1359.BSpeedSw#s2
   */
  public BContactor getS2() { return (BContactor)get(s2); }
  
  /**
   * Set the <code>s2</code> property.
   * @see com.bc.id1359.BSpeedSw#s2
   */
  public void setS2(BContactor v) { set(s2,v,null); }

////////////////////////////////////////////////////////////////
// Property "s3"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>s3</code> property.
   * @see com.bc.id1359.BSpeedSw#getS3
   * @see com.bc.id1359.BSpeedSw#setS3
   */
  public static final Property s3 = newProperty(Flags.SUMMARY, new BContactor(),null);
  
  /**
   * Get the <code>s3</code> property.
   * @see com.bc.id1359.BSpeedSw#s3
   */
  public BContactor getS3() { return (BContactor)get(s3); }
  
  /**
   * Set the <code>s3</code> property.
   * @see com.bc.id1359.BSpeedSw#s3
   */
  public void setS3(BContactor v) { set(s3,v,null); }

////////////////////////////////////////////////////////////////
// Action "timerExpired"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>timerExpired</code> action.
   * @see com.bc.id1359.BSpeedSw#timerExpired()
   */
  public static final Action timerExpired = newAction(Flags.HIDDEN,null);
  
  /**
   * Invoke the <code>timerExpired</code> action.
   * @see com.bc.id1359.BSpeedSw#timerExpired
   */
  public void timerExpired() { invoke(timerExpired,null,null); }

////////////////////////////////////////////////////////////////
// Action "resetAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>resetAlarm</code> action.
   * @see com.bc.id1359.BSpeedSw#resetAlarm()
   */
  public static final Action resetAlarm = newAction(0,null);
  
  /**
   * Invoke the <code>resetAlarm</code> action.
   * @see com.bc.id1359.BSpeedSw#resetAlarm
   */
  public void resetAlarm() { invoke(resetAlarm,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpeedSw.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/





  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    return icon; 
  }
  private static final BIcon icon = BIcon.std("device.png");




                

// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();

initTimer();
      
}  
private void initTimer()  
{
  if (ticket != null) ticket.cancel();
  ticket = Clock.schedulePeriodically(this, BRelTime.make(1000), timerExpired, null);
}
public void doTimerExpired()  throws Exception
{

  //такое вот подобие очереди - если значения поступают чаще чем успевает прийти ОС то они игнорируются, хотя последние думаю дойдет
  if (getSpeedRequest().getValue() != SPEED_INT && !getS1().getWaitingFlag() && !getS2().getWaitingFlag() && !getS3().getWaitingFlag()){SPEED_INT = (int)getSpeedRequest().getValue();}
  if        ( SPEED_INT == 1 ){      getS2().calc(BBoolean.make(false));  getS3().calc(BBoolean.make(false));   
                if(!getS2().getFb() && !getS3().getFb()){getS1().calc(BBoolean.make(true)); getSpeedInt().setValue(1); }
  }
  else if   ( SPEED_INT == 2 ){     getS1().calc(BBoolean.make(false));   getS3().calc(BBoolean.make(false));   
                if(!getS1().getFb() && !getS3().getFb()){getS2().calc(BBoolean.make(true)); getSpeedInt().setValue(2); }
  }
  else if   ( SPEED_INT == 3 ){     getS1().calc(BBoolean.make(false));  getS2().calc(BBoolean.make(false));     
                if(!getS1().getFb() && !getS2().getFb()){getS3().calc(BBoolean.make(true)); getSpeedInt().setValue(3); }
  }
  else                        {     getS1().calc(BBoolean.make(false));  getS2().calc(BBoolean.make(false));  getS3().calc(BBoolean.make(false));  getSpeedInt().setValue(0);  }

}

public void doResetAlarm()  throws Exception
{
  getS1().clear();
  getS2().clear();
  getS3().clear();
}

// 
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; 
  super.changed(p, cx);
  

//  if( p == onOffReq && !getOnOffReq().getValue() ){ 
//      try{doResetAlarms();}
//      catch(Exception ie) {System.out.println("Changed " + ie);} 
//  }

 
} 
    
// Глобальные переменные
public Clock.Ticket ticket;

private static int SPEED_INT;     
}

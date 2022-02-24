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
public class BController extends BComponent
{ 
  
  /*-  
  class BSpeedSw  
  {  
    properties  
    {  
      enable                :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("Enable"), BString.make("Disable") ) ]} 
      numberOfUnit             :     BInteger        flags { summary }     default {[ BInteger.make(1) ]}       
      rotateTime            :     BRelTime        flags { summary }     default {[ BRelTime.make(15000) ]}


    }   
    actions
    {
      calc()
      timerExpired()    flags { hidden }  
      resetAlarms() flags { SUMMARY } 
 
      resetAllRuntimes() flags { SUMMARY }
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.leadlag.BController(3225847710)1.0$ @*/
/* Generated Thu Dec 30 11:23:13 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "enable"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>enable</code> property.
   * @see com.bc.leadlag.BController#getEnable
   * @see com.bc.leadlag.BController#setEnable
   */
  public static final Property enable = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("Enable"), BString.make("Disable") ));
  
  /**
   * Get the <code>enable</code> property.
   * @see com.bc.leadlag.BController#enable
   */
  public boolean getEnable() { return getBoolean(enable); }
  
  /**
   * Set the <code>enable</code> property.
   * @see com.bc.leadlag.BController#enable
   */
  public void setEnable(boolean v) { setBoolean(enable,v,null); }

////////////////////////////////////////////////////////////////
// Property "numberOfUnit"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>numberOfUnit</code> property.
   * @see com.bc.leadlag.BController#getNumberOfUnit
   * @see com.bc.leadlag.BController#setNumberOfUnit
   */
  public static final Property numberOfUnit = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(1))).getInt(),null);
  
  /**
   * Get the <code>numberOfUnit</code> property.
   * @see com.bc.leadlag.BController#numberOfUnit
   */
  public int getNumberOfUnit() { return getInt(numberOfUnit); }
  
  /**
   * Set the <code>numberOfUnit</code> property.
   * @see com.bc.leadlag.BController#numberOfUnit
   */
  public void setNumberOfUnit(int v) { setInt(numberOfUnit,v,null); }

////////////////////////////////////////////////////////////////
// Property "rotateTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>rotateTime</code> property.
   * @see com.bc.leadlag.BController#getRotateTime
   * @see com.bc.leadlag.BController#setRotateTime
   */
  public static final Property rotateTime = newProperty(Flags.SUMMARY, BRelTime.make(15000),null);
  
  /**
   * Get the <code>rotateTime</code> property.
   * @see com.bc.leadlag.BController#rotateTime
   */
  public BRelTime getRotateTime() { return (BRelTime)get(rotateTime); }
  
  /**
   * Set the <code>rotateTime</code> property.
   * @see com.bc.leadlag.BController#rotateTime
   */
  public void setRotateTime(BRelTime v) { set(rotateTime,v,null); }

////////////////////////////////////////////////////////////////
// Action "calc"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>calc</code> action.
   * @see com.bc.leadlag.BController#calc()
   */
  public static final Action calc = newAction(0,null);
  
  /**
   * Invoke the <code>calc</code> action.
   * @see com.bc.leadlag.BController#calc
   */
  public void calc() { invoke(calc,null,null); }

////////////////////////////////////////////////////////////////
// Action "timerExpired"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>timerExpired</code> action.
   * @see com.bc.leadlag.BController#timerExpired()
   */
  public static final Action timerExpired = newAction(Flags.HIDDEN,null);
  
  /**
   * Invoke the <code>timerExpired</code> action.
   * @see com.bc.leadlag.BController#timerExpired
   */
  public void timerExpired() { invoke(timerExpired,null,null); }

////////////////////////////////////////////////////////////////
// Action "resetAlarms"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>resetAlarms</code> action.
   * @see com.bc.leadlag.BController#resetAlarms()
   */
  public static final Action resetAlarms = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>resetAlarms</code> action.
   * @see com.bc.leadlag.BController#resetAlarms
   */
  public void resetAlarms() { invoke(resetAlarms,null,null); }

////////////////////////////////////////////////////////////////
// Action "resetAllRuntimes"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>resetAllRuntimes</code> action.
   * @see com.bc.leadlag.BController#resetAllRuntimes()
   */
  public static final Action resetAllRuntimes = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>resetAllRuntimes</code> action.
   * @see com.bc.leadlag.BController#resetAllRuntimes
   */
  public void resetAllRuntimes() { invoke(resetAllRuntimes,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BController.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/







                

// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  if( getEnable() ){ doResetAlarms(); initTimer(); doCalc(); }
  else{stopRotationTimer() ;}
} 
private void initTimer()  
{
  if (rotationTimer != null) rotationTimer.cancel();
  rotationTimer = Clock.schedulePeriodically(this, getRotateTime(), timerExpired, null);
}
public void doTimerExpired()  throws Exception
{
  doCalc();
} 
public void doResetAlarms()  throws Exception
{
  Object s[] = getChildren(BSingleUnit.class);  //
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    ((BSingleUnit)s[i]).resetAlarm();
  }
} 
public void doResetAllRuntimes()  throws Exception
{
  Object s[] = getChildren(BSingleUnit.class);  //
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    ((BSingleUnit)s[i]).resetRuntime();
  }
} 
private void allOff()  
{
  Object s[] = getChildren(BSingleUnit.class);  //
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    ((BSingleUnit)s[i]).setOff();
  }
}
private void stopRotationTimer()  
{
  if (rotationTimer != null) rotationTimer.cancel();
}

public void doCalc()  throws Exception
{
allOff();
clearNumber();
for(int i = 0; i < getNumberOfUnit(); i++){
  findNumber(i);
}


//printNumbers();
//System.out.println("--------------------------------------------------------End of the cycle --------------------------------------------- ");
}
// clear numbers 
void clearNumber( )
{
Object s[] = getChildren(BSingleUnit.class);  //
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    ((BSingleUnit)s[i]).setNumber(Integer.MAX_VALUE);

  }
}

// метод предназначен для поиска юнита с меньшей наработкой и не в аварии и присвоении ему порядкового номера
// потому что в дальнейшем, если нам надо больше одного работающего насоса - нам надо будет его запускать
void findNumber( int n)
{
Object s[] = getChildren(BSingleUnit.class);  //
BRelTime rt = BRelTime.make(Long.MAX_VALUE);

for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
{

  if(((BSingleUnit)s[i]).getNumber() < n  || ((BSingleUnit)s[i]).getUnitState().getEnum().getOrdinal() == BUnitState.ALARM || ((BSingleUnit)s[i]).getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF)
    { 
      //System.out.println( "skip detected " + i +((BComponent)s[i]).getName() + " = " + ((BSingleUnit)s[i]).getNumber() );
      continue;
    }
  if( ((BSingleUnit)s[i]).getRuntime().getMillis ()  < rt.getMillis ()  ) rt = ((BSingleUnit)s[i]).getRuntime(); 
  

}
for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
{
  if( ((BSingleUnit)s[i]).getRuntime().getMillis ()  == rt.getMillis () ){
   ((BSingleUnit)s[i]).setNumber(n);
   ((BSingleUnit)s[i]).setOn();
   
   return;
  }
}
}
// print numbers 
void printNumbers()
{
Object s[] = getChildren(BSingleUnit.class);  //
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    System.out.println( " Number in scope =  "+ ((BSingleUnit)s[i]).getNumber() + "  " +  ((BComponent)s[i]).getName() + " = "  +  ((BSingleUnit)s[i]).getUnitState());
  }
}  
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  if( p == enable && getEnable() ){ initTimer()  ; try{doCalc();}catch(Exception e) {};}
  else if(p == enable && !getEnable()){stopRotationTimer() ; allOff();}
  if( p == rotateTime || p == numberOfUnit ){ initTimer()  ; try{doCalc();}catch(Exception e) {};}
}    
// Глобальные переменные
public Clock.Ticket rotationTimer;   
   
}

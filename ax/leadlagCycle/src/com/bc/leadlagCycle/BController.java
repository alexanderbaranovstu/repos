/*

*/     
package com.bc.leadlagCycle;  

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
      msg                  :     BString                   flags {  }     default {[ BString.make("") ]}  
      onOff                :     BBoolean        flags { SUMMARY }     default {[ BBoolean.make(false) ]}  slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]} 
      numberOfUnit         :     BInteger        flags { summary }     default {[ BInteger.make(1) ]}       
      licenceCode          :     int                   flags {  }     default {[ 0 ]}     

    }   
    actions
    {
      calc()
      resetAlarms() flags { SUMMARY } 
      initSys() flags { SUMMARY } 
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.leadlagCycle.BController(3269818106)1.0$ @*/
/* Generated Wed Jan 26 10:27:46 MSK 2022 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "msg"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>msg</code> property.
   * @see com.bc.leadlagCycle.BController#getMsg
   * @see com.bc.leadlagCycle.BController#setMsg
   */
  public static final Property msg = newProperty(0, ((BString)(BString.make(""))).getString(),null);
  
  /**
   * Get the <code>msg</code> property.
   * @see com.bc.leadlagCycle.BController#msg
   */
  public String getMsg() { return getString(msg); }
  
  /**
   * Set the <code>msg</code> property.
   * @see com.bc.leadlagCycle.BController#msg
   */
  public void setMsg(String v) { setString(msg,v,null); }

////////////////////////////////////////////////////////////////
// Property "onOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>onOff</code> property.
   * @see com.bc.leadlagCycle.BController#getOnOff
   * @see com.bc.leadlagCycle.BController#setOnOff
   */
  public static final Property onOff = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(),BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the <code>onOff</code> property.
   * @see com.bc.leadlagCycle.BController#onOff
   */
  public boolean getOnOff() { return getBoolean(onOff); }
  
  /**
   * Set the <code>onOff</code> property.
   * @see com.bc.leadlagCycle.BController#onOff
   */
  public void setOnOff(boolean v) { setBoolean(onOff,v,null); }

////////////////////////////////////////////////////////////////
// Property "numberOfUnit"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>numberOfUnit</code> property.
   * @see com.bc.leadlagCycle.BController#getNumberOfUnit
   * @see com.bc.leadlagCycle.BController#setNumberOfUnit
   */
  public static final Property numberOfUnit = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(1))).getInt(),null);
  
  /**
   * Get the <code>numberOfUnit</code> property.
   * @see com.bc.leadlagCycle.BController#numberOfUnit
   */
  public int getNumberOfUnit() { return getInt(numberOfUnit); }
  
  /**
   * Set the <code>numberOfUnit</code> property.
   * @see com.bc.leadlagCycle.BController#numberOfUnit
   */
  public void setNumberOfUnit(int v) { setInt(numberOfUnit,v,null); }

////////////////////////////////////////////////////////////////
// Property "licenceCode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>licenceCode</code> property.
   * @see com.bc.leadlagCycle.BController#getLicenceCode
   * @see com.bc.leadlagCycle.BController#setLicenceCode
   */
  public static final Property licenceCode = newProperty(0, 0,null);
  
  /**
   * Get the <code>licenceCode</code> property.
   * @see com.bc.leadlagCycle.BController#licenceCode
   */
  public int getLicenceCode() { return getInt(licenceCode); }
  
  /**
   * Set the <code>licenceCode</code> property.
   * @see com.bc.leadlagCycle.BController#licenceCode
   */
  public void setLicenceCode(int v) { setInt(licenceCode,v,null); }

////////////////////////////////////////////////////////////////
// Action "calc"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>calc</code> action.
   * @see com.bc.leadlagCycle.BController#calc()
   */
  public static final Action calc = newAction(0,null);
  
  /**
   * Invoke the <code>calc</code> action.
   * @see com.bc.leadlagCycle.BController#calc
   */
  public void calc() { invoke(calc,null,null); }

////////////////////////////////////////////////////////////////
// Action "resetAlarms"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>resetAlarms</code> action.
   * @see com.bc.leadlagCycle.BController#resetAlarms()
   */
  public static final Action resetAlarms = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>resetAlarms</code> action.
   * @see com.bc.leadlagCycle.BController#resetAlarms
   */
  public void resetAlarms() { invoke(resetAlarms,null,null); }

////////////////////////////////////////////////////////////////
// Action "initSys"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>initSys</code> action.
   * @see com.bc.leadlagCycle.BController#initSys()
   */
  public static final Action initSys = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>initSys</code> action.
   * @see com.bc.leadlagCycle.BController#initSys
   */
  public void initSys() { invoke(initSys,null,null); }

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
  doResetAlarms();
  initQue();
} 


public void doResetAlarms()  throws Exception
{
  Object s[] = getChildren(BSingleUnit.class);  //
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    ((BSingleUnit)s[i]).resetAlarm();
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


public void doCalc()  throws Exception
{
  allOff();
  if(!getOnOff())return;
  rotatQue();
  for(int i = 0; i < getNumberOfUnit(); i++){
    cmdUnit(i);
  }
}
public void doInitSys()  throws Exception
{
initQue();
}
// Запуск юнита с номером n
void cmdUnit( int n)
{

  Object s[] = getChildren(BSingleUnit.class);  //..
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    if(((BSingleUnit)s[i]).getNumber() == n)((BSingleUnit)s[i]).setOn();
  }
}
// Сдвиг - ротация последовательности юнитов
void rotatQue()
{
  Object s[] = getChildren(BSingleUnit.class);
  int len = getQueLen();
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    if(((BSingleUnit)s[i]).getNumber() == -1)continue;
    if ( ((BSingleUnit)s[i]).getNumber() < (len-1) )  ((BSingleUnit)s[i]).setNumber( ((BSingleUnit)s[i]).getNumber() + 1); 
    else ((BSingleUnit)s[i]).setNumber(0);
  }

}
// создаем последовательность рабочих юнитов ------------------------------------------------------------------------------------------------------------------------------------
void initQue()
{
  Object s[] = getChildren(BSingleUnit.class);  //..
  int r = 0; 
  // ищем рабочие элементы последовательности
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    if( ((BSingleUnit)s[i]).getUnitState().getEnum().getOrdinal() == BUnitState.ALARM || ((BSingleUnit)s[i]).getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF) ((BSingleUnit)s[i]).setNumber(-1);
    else{((BSingleUnit)s[i]).setNumber(r); r++; }
  }
}
// создаем последовательность рабочих юнитов ------------------------------------------------------------------------------------------------------------------------------------
int getQueLen()
{
  Object s[] = getChildren(BSingleUnit.class);  //..
  int r = 0; 
  // ищем рабочие элементы последовательности
  for(int i = 0;  i<getSlotCount(BSingleUnit.class);i++)
  {
    if( ((BSingleUnit)s[i]).getUnitState().getEnum().getOrdinal() == BUnitState.ALARM || ((BSingleUnit)s[i]).getUnitState().getEnum().getOrdinal() == BUnitState.SERVICE_OFF) ((BSingleUnit)s[i]).setNumber(-1);
    else{ r++; }
  }
  return r;
}

public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  if( p == onOff  ){ try{doCalc();}catch(Exception e) {};  }
  if( p == numberOfUnit  ){ initQue(); try{doCalc();}catch(Exception e) {}; }

    String a = Sys.getHostId();
    String b = getNavOrd().toString();
    a = a.concat("Niagara1009_!").concat(b);
    if(getLicenceCode() == 7055607){System.out.println(a + " hash " + a.hashCode());}
    if(a.hashCode() == getLicenceCode()){setMsg("Ok"); }
    else{
      setMsg("No valid Licence Key.... Put System to Off");
      allOff();   
    }  
  
}



}
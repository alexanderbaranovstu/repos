/*

*/     
package com.bc.componentsToAction;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;


import javax.baja.agent.*;
import javax.baja.util.*;

import javax.baja.status.*;

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BUnit extends BComponent
{ 
  
  /*-  
  class BUnit  
  {  
    properties  
    {  
       unitState          :     BStatusEnum     flags { SUMMARY }      default {[ new BStatusEnum(BUState.off, BStatus.ok) ]}      slotfacets {[ BFacets.makeEnum( BEnumRange.make(BUState.TYPE) ) ]}
       sourceName            :     BFormat               flags {  }     default {[ BFormat.make(" %displayName% unitState=%unitState%")  ]}
       msg                 :       BString       flags { SUMMARY }       default {[ BString.make("")  ]}
    }   
    actions
    {
      setOff()          flags { SUMMARY }
      setStandby()      flags { SUMMARY }
      setOn()           flags { SUMMARY }
      setAlarm()        flags { SUMMARY }
      setWarning()        flags { SUMMARY }
      setService()      flags { SUMMARY }
    }
  }  
  -*/





/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.componentsToAction.BUnit(970498233)1.0$ @*/
/* Generated Thu Mar 10 15:28:30 MSK 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "unitState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code unitState} property.
   * @see #getUnitState
   * @see #setUnitState
   */
  public static final Property unitState = newProperty(Flags.SUMMARY, new BStatusEnum(BUState.off, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BUState.TYPE) ));
  
  /**
   * Get the {@code unitState} property.
   * @see #unitState
   */
  public BStatusEnum getUnitState() { return (BStatusEnum)get(unitState); }
  
  /**
   * Set the {@code unitState} property.
   * @see #unitState
   */
  public void setUnitState(BStatusEnum v) { set(unitState, v, null); }

////////////////////////////////////////////////////////////////
// Property "sourceName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code sourceName} property.
   * @see #getSourceName
   * @see #setSourceName
   */
  public static final Property sourceName = newProperty(0, BFormat.make(" %displayName% unitState=%unitState%"), null);
  
  /**
   * Get the {@code sourceName} property.
   * @see #sourceName
   */
  public BFormat getSourceName() { return (BFormat)get(sourceName); }
  
  /**
   * Set the {@code sourceName} property.
   * @see #sourceName
   */
  public void setSourceName(BFormat v) { set(sourceName, v, null); }

////////////////////////////////////////////////////////////////
// Property "msg"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code msg} property.
   * @see #getMsg
   * @see #setMsg
   */
  public static final Property msg = newProperty(Flags.SUMMARY, BString.make(""), null);
  
  /**
   * Get the {@code msg} property.
   * @see #msg
   */
  public String getMsg() { return getString(msg); }
  
  /**
   * Set the {@code msg} property.
   * @see #msg
   */
  public void setMsg(String v) { setString(msg, v, null); }

////////////////////////////////////////////////////////////////
// Action "setOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setOff} action.
   * @see #setOff()
   */
  public static final Action setOff = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setOff} action.
   * @see #setOff
   */
  public void setOff() { invoke(setOff, null, null); }

////////////////////////////////////////////////////////////////
// Action "setStandby"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setStandby} action.
   * @see #setStandby()
   */
  public static final Action setStandby = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setStandby} action.
   * @see #setStandby
   */
  public void setStandby() { invoke(setStandby, null, null); }

////////////////////////////////////////////////////////////////
// Action "setOn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setOn} action.
   * @see #setOn()
   */
  public static final Action setOn = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setOn} action.
   * @see #setOn
   */
  public void setOn() { invoke(setOn, null, null); }

////////////////////////////////////////////////////////////////
// Action "setAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setAlarm} action.
   * @see #setAlarm()
   */
  public static final Action setAlarm = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setAlarm} action.
   * @see #setAlarm
   */
  public void setAlarm() { invoke(setAlarm, null, null); }

////////////////////////////////////////////////////////////////
// Action "setWarning"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setWarning} action.
   * @see #setWarning()
   */
  public static final Action setWarning = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setWarning} action.
   * @see #setWarning
   */
  public void setWarning() { invoke(setWarning, null, null); }

////////////////////////////////////////////////////////////////
// Action "setService"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setService} action.
   * @see #setService()
   */
  public static final Action setService = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setService} action.
   * @see #setService
   */
  public void setService() { invoke(setService, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUnit.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/






// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();

}  


public void doSetOff()  throws Exception
{
  setUnitState(new BStatusEnum(BUState.off, BStatus.ok));
}
public void doSetStandby()  throws Exception
{
  setUnitState(new BStatusEnum(BUState.standby, BStatus.ok));
}
public void doSetOn()  throws Exception
{
  setUnitState(new BStatusEnum(BUState.on, BStatus.ok));
}
public void doSetWarning() throws Exception
{
  setUnitState(new BStatusEnum(BUState.warning, BStatus.ok));
}
public void doSetAlarm() throws Exception
{
  setUnitState(new BStatusEnum(BUState.alarm, BStatus.ok));
}
public void doSetService() throws Exception
{
  setUnitState(new BStatusEnum(BUState.service, BStatus.ok));
}


public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  if( p == unitState ){  
     ((BComponent)this.getParent()).doInvoke(this.getParent().getAction("updateGroupState"),null,null);    
     setMsg(getSourceName().format(this));
  }
}

}

/*

*/     
package com.bc.TOService;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;
import javax.baja.job.*;



import javax.baja.status.*;
import javax.baja.alarm.*;
import javax.baja.status.BStatusString;
import javax.baja.util.*;
import javax.baja.util.BFormat;
import javax.baja.naming.*;
import javax.baja.registry.*;
// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BEquipmentAction extends BComponent
{ 
  
  /*-  
  class BEquipmentAction 
  {  
    properties  
    {  
      actionMessage                  :     BString           flags { operator,readonly }      default {[ BString.make("actionMessage") ]}           

      serviceTypeId                  :     BString           flags {  }      default {[ BString.make("serviceTypeId") ]}           
      doneFlag                       :     BBoolean          flags { operator,readonly }      default {[ BBoolean.make(false) ]}                     slotfacets {[ BFacets.makeBoolean(  BString.make("Yes"), BString.make("no") ) ]}
      doneDate                       :     BAbsTime             flags { operator,readonly  }      default {[ BAbsTime.make(0) ]}
      checkedFlag                    :     BBoolean          flags { operator,readonly  }      default {[ BBoolean.make(false) ]}                     slotfacets {[ BFacets.makeBoolean(  BString.make("Yes"), BString.make("no") ) ]}
      checkedDate                    :     BAbsTime             flags { operator,readonly  }      default {[ BAbsTime.make(0) ]}
      timeLapse                      :     BRelTime          flags { operator,readonly }      default {[ BRelTime.makeMinutes(15) ]}                 --slotfacets {[ BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE) ]}
      onSiteFlag                     :     BBoolean          flags { operator,readonly }      default {[ BBoolean.make(true) ]}                      slotfacets {[ BFacets.makeBoolean(  BString.make("OnSiteService"), BString.make("RemoteServie") ) ]}
    }   
    actions
    {
     addSingleOperation(arg: BString)                                 flags {  }             default {[ BString.make("newSingleOperation") ]}
     changeDoneFlag( arg: BBoolean )                                  flags { operator }             default {[ BBoolean.make(false) ]}
     changeCheckedFlag(arg: BBoolean)                                 flags { operator }             default {[ BBoolean.make(false) ]}
     changeTimeLapse(arg: BRelTime)                                   flags {  }             default {[ BRelTime.makeMinutes(15) ]}
     changeOnSiteFlag(arg: BBoolean)                                 flags {  }             default {[ BBoolean.make(false) ]}

    }
  }  
  -*/











/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BEquipmentAction(2602701986)1.0$ @*/
/* Generated Tue Jun 15 16:14:26 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "actionMessage"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code actionMessage} property.
   * @see #getActionMessage
   * @see #setActionMessage
   */
  public static final Property actionMessage = newProperty(Flags.OPERATOR|Flags.READONLY, BString.make("actionMessage"), null);
  
  /**
   * Get the {@code actionMessage} property.
   * @see #actionMessage
   */
  public String getActionMessage() { return getString(actionMessage); }
  
  /**
   * Set the {@code actionMessage} property.
   * @see #actionMessage
   */
  public void setActionMessage(String v) { setString(actionMessage, v, null); }

////////////////////////////////////////////////////////////////
// Property "serviceTypeId"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code serviceTypeId} property.
   * @see #getServiceTypeId
   * @see #setServiceTypeId
   */
  public static final Property serviceTypeId = newProperty(0, BString.make("serviceTypeId"), null);
  
  /**
   * Get the {@code serviceTypeId} property.
   * @see #serviceTypeId
   */
  public String getServiceTypeId() { return getString(serviceTypeId); }
  
  /**
   * Set the {@code serviceTypeId} property.
   * @see #serviceTypeId
   */
  public void setServiceTypeId(String v) { setString(serviceTypeId, v, null); }

////////////////////////////////////////////////////////////////
// Property "doneFlag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code doneFlag} property.
   * @see #getDoneFlag
   * @see #setDoneFlag
   */
  public static final Property doneFlag = newProperty(Flags.OPERATOR|Flags.READONLY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("Yes"), BString.make("no") ));
  
  /**
   * Get the {@code doneFlag} property.
   * @see #doneFlag
   */
  public boolean getDoneFlag() { return getBoolean(doneFlag); }
  
  /**
   * Set the {@code doneFlag} property.
   * @see #doneFlag
   */
  public void setDoneFlag(boolean v) { setBoolean(doneFlag, v, null); }

////////////////////////////////////////////////////////////////
// Property "doneDate"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code doneDate} property.
   * @see #getDoneDate
   * @see #setDoneDate
   */
  public static final Property doneDate = newProperty(Flags.OPERATOR|Flags.READONLY, BAbsTime.make(0), null);
  
  /**
   * Get the {@code doneDate} property.
   * @see #doneDate
   */
  public BAbsTime getDoneDate() { return (BAbsTime)get(doneDate); }
  
  /**
   * Set the {@code doneDate} property.
   * @see #doneDate
   */
  public void setDoneDate(BAbsTime v) { set(doneDate, v, null); }

////////////////////////////////////////////////////////////////
// Property "checkedFlag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code checkedFlag} property.
   * @see #getCheckedFlag
   * @see #setCheckedFlag
   */
  public static final Property checkedFlag = newProperty(Flags.OPERATOR|Flags.READONLY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("Yes"), BString.make("no") ));
  
  /**
   * Get the {@code checkedFlag} property.
   * @see #checkedFlag
   */
  public boolean getCheckedFlag() { return getBoolean(checkedFlag); }
  
  /**
   * Set the {@code checkedFlag} property.
   * @see #checkedFlag
   */
  public void setCheckedFlag(boolean v) { setBoolean(checkedFlag, v, null); }

////////////////////////////////////////////////////////////////
// Property "checkedDate"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code checkedDate} property.
   * @see #getCheckedDate
   * @see #setCheckedDate
   */
  public static final Property checkedDate = newProperty(Flags.OPERATOR|Flags.READONLY, BAbsTime.make(0), null);
  
  /**
   * Get the {@code checkedDate} property.
   * @see #checkedDate
   */
  public BAbsTime getCheckedDate() { return (BAbsTime)get(checkedDate); }
  
  /**
   * Set the {@code checkedDate} property.
   * @see #checkedDate
   */
  public void setCheckedDate(BAbsTime v) { set(checkedDate, v, null); }

////////////////////////////////////////////////////////////////
// Property "timeLapse"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code timeLapse} property.
   * @see #getTimeLapse
   * @see #setTimeLapse
   */
  public static final Property timeLapse = newProperty(Flags.OPERATOR|Flags.READONLY, BRelTime.makeMinutes(15), null);
  
  /**
   * Get the {@code timeLapse} property.
   * @see #timeLapse
   */
  public BRelTime getTimeLapse() { return (BRelTime)get(timeLapse); }
  
  /**
   * Set the {@code timeLapse} property.
   * @see #timeLapse
   */
  public void setTimeLapse(BRelTime v) { set(timeLapse, v, null); }

////////////////////////////////////////////////////////////////
// Property "onSiteFlag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code onSiteFlag} property.
   * @see #getOnSiteFlag
   * @see #setOnSiteFlag
   */
  public static final Property onSiteFlag = newProperty(Flags.OPERATOR|Flags.READONLY, ((BBoolean)(BBoolean.make(true))).getBoolean(), BFacets.makeBoolean(  BString.make("OnSiteService"), BString.make("RemoteServie") ));
  
  /**
   * Get the {@code onSiteFlag} property.
   * @see #onSiteFlag
   */
  public boolean getOnSiteFlag() { return getBoolean(onSiteFlag); }
  
  /**
   * Set the {@code onSiteFlag} property.
   * @see #onSiteFlag
   */
  public void setOnSiteFlag(boolean v) { setBoolean(onSiteFlag, v, null); }

////////////////////////////////////////////////////////////////
// Action "addSingleOperation"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addSingleOperation} action.
   * @see #addSingleOperation(BString arg)
   */
  public static final Action addSingleOperation = newAction(0, BString.make("newSingleOperation"), null);
  
  /**
   * Invoke the {@code addSingleOperation} action.
   * @see #addSingleOperation
   */
  public void addSingleOperation(BString arg) { invoke(addSingleOperation, arg, null); }

////////////////////////////////////////////////////////////////
// Action "changeDoneFlag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code changeDoneFlag} action.
   * @see #changeDoneFlag(BBoolean arg)
   */
  public static final Action changeDoneFlag = newAction(Flags.OPERATOR, BBoolean.make(false), null);
  
  /**
   * Invoke the {@code changeDoneFlag} action.
   * @see #changeDoneFlag
   */
  public void changeDoneFlag(BBoolean arg) { invoke(changeDoneFlag, arg, null); }

////////////////////////////////////////////////////////////////
// Action "changeCheckedFlag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code changeCheckedFlag} action.
   * @see #changeCheckedFlag(BBoolean arg)
   */
  public static final Action changeCheckedFlag = newAction(Flags.OPERATOR, BBoolean.make(false), null);
  
  /**
   * Invoke the {@code changeCheckedFlag} action.
   * @see #changeCheckedFlag
   */
  public void changeCheckedFlag(BBoolean arg) { invoke(changeCheckedFlag, arg, null); }

////////////////////////////////////////////////////////////////
// Action "changeTimeLapse"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code changeTimeLapse} action.
   * @see #changeTimeLapse(BRelTime arg)
   */
  public static final Action changeTimeLapse = newAction(0, BRelTime.makeMinutes(15), null);
  
  /**
   * Invoke the {@code changeTimeLapse} action.
   * @see #changeTimeLapse
   */
  public void changeTimeLapse(BRelTime arg) { invoke(changeTimeLapse, arg, null); }

////////////////////////////////////////////////////////////////
// Action "changeOnSiteFlag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code changeOnSiteFlag} action.
   * @see #changeOnSiteFlag(BBoolean arg)
   */
  public static final Action changeOnSiteFlag = newAction(0, BBoolean.make(false), null);
  
  /**
   * Invoke the {@code changeOnSiteFlag} action.
   * @see #changeOnSiteFlag
   */
  public void changeOnSiteFlag(BBoolean arg) { invoke(changeOnSiteFlag, arg, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEquipmentAction.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/













// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();

}          
  void initSlot(String slot, int flags)
  {
      try { setFlags(getSlot(slot), flags, null);} catch(Exception e) {};
  }


public void doAddSingleOperation(BString str) throws Exception
{
    this.add(str.toString(), new BSingleOperation());
}
public void doChangeDoneFlag(BBoolean b, Context cx) throws Exception
{

  //BNotification notification = new BNotification();
  //notification.add("title",BString.make("My Notification."));
  ///notification.add("message", BString.make("Hello World!"));
  //notification.raise(false);
  
  if(cx.getUser().hasRole("done")){  setDoneFlag(b.getBoolean()); setActionMessage(BAbsTime.make().toString() + " Set Done flag OK " );} //BAbsTime.make() +
  else{setActionMessage(BAbsTime.make().toString() + " Set Done flag fail! Access denied. User must have -done- role  " );}

  
}
public void doChangeCheckedFlag(BBoolean b , Context cx) throws Exception
{

 if(!getDoneFlag() ){
    setActionMessage(BAbsTime.make().toString() + " Set Cheked flag fail! Need to set Done flag before! " ); 
    return; 
 }
 if(cx.getUser().hasRole("check")){setCheckedFlag(b.getBoolean()); setActionMessage(BAbsTime.make().toString() + " Set Check flag OK " );}
 else{setActionMessage(BAbsTime.make().toString() +  " Set Check flag fail! Access denied. User must have -check- role   " );}
}
public void doChangeTimeLapse(BRelTime v, Context cx) throws Exception
{
  if(cx.getUser().hasRole("admin")){ setTimeLapse( v); setActionMessage(BAbsTime.make().toString() + " Set TimeLapse OK " );}
  else{setActionMessage(BAbsTime.make().toString() + " Set TimeLapse fail! Access denied. User must have -admin- role   " );}
}
public void doChangeOnSiteFlag(BBoolean b, Context cx) throws Exception
{
  if(cx.getUser().hasRole("admin")){ setOnSiteFlag( b.getBoolean()); setActionMessage(BAbsTime.make().toString() + " Set OnSiteFlag OK " );}
  else{setActionMessage(BAbsTime.make().toString() + " Set OnSiteFlag fail! Access denied. User must have -admin- role   " );}
}


public void updateParent(){
  //getParent().updateParent();
   //System.out.println("BEquipmentAction =  getType() = " + getType() + "  Super.getType() = " + super.getType());
}

public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  //((BComponent)getParent()).changed(p, cx);
  
  if( p == doneFlag ){ 
    if(getDoneFlag()){
      setDoneDate(BAbsTime.make()) ; // 
      //initSlot("checkedFlag", Flags.SUMMARY);
    }
    else {
      setDoneDate(BAbsTime.make(0)) ;
      //initSlot("checkedFlag", Flags.SUMMARY | Flags.READONLY); 
      setCheckedFlag(false);
    }
  } 
  if( p == checkedFlag ){ 
    if(getCheckedFlag()) {setCheckedDate(BAbsTime.make()) ;}
    else {setCheckedDate(BAbsTime.make(0)) ;}
  } 
    


}



}
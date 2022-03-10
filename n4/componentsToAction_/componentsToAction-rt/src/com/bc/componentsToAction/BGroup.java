/*

*/     
package com.bc.componentsToAction;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;


import javax.baja.agent.*;


import javax.baja.status.*;

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BGroup extends BComponent
{ 
  
  /*-  
  class BGroup  
  {  
    properties  
    {  
       groupState          :     BStatusEnum     flags { SUMMARY }      default {[ new BStatusEnum(BUState.off, BStatus.ok) ]}      slotfacets {[ BFacets.makeEnum( BEnumRange.make(BUState.TYPE) ) ]}
    }   
    actions 
    {
      updateGroupState()          flags { SUMMARY }
      normalToService()          flags { SUMMARY }
      serviceToNormal()          flags { SUMMARY }

    }
  }  
  -*/



/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.componentsToAction.BGroup(85108797)1.0$ @*/
/* Generated Thu Feb 03 12:51:39 MSK 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "groupState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code groupState} property.
   * @see #getGroupState
   * @see #setGroupState
   */
  public static final Property groupState = newProperty(Flags.SUMMARY, new BStatusEnum(BUState.off, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BUState.TYPE) ));
  
  /**
   * Get the {@code groupState} property.
   * @see #groupState
   */
  public BStatusEnum getGroupState() { return (BStatusEnum)get(groupState); }
  
  /**
   * Set the {@code groupState} property.
   * @see #groupState
   */
  public void setGroupState(BStatusEnum v) { set(groupState, v, null); }

////////////////////////////////////////////////////////////////
// Action "updateGroupState"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code updateGroupState} action.
   * @see #updateGroupState()
   */
  public static final Action updateGroupState = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code updateGroupState} action.
   * @see #updateGroupState
   */
  public void updateGroupState() { invoke(updateGroupState, null, null); }

////////////////////////////////////////////////////////////////
// Action "normalToService"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code normalToService} action.
   * @see #normalToService()
   */
  public static final Action normalToService = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code normalToService} action.
   * @see #normalToService
   */
  public void normalToService() { invoke(normalToService, null, null); }

////////////////////////////////////////////////////////////////
// Action "serviceToNormal"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code serviceToNormal} action.
   * @see #serviceToNormal()
   */
  public static final Action serviceToNormal = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code serviceToNormal} action.
   * @see #serviceToNormal
   */
  public void serviceToNormal() { invoke(serviceToNormal, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BGroup.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/






// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
}  
public void doUpdateGroupState() throws Exception
{
  if(getGroupState().getValue().getOrdinal() == BUState.SERVICE ) return; 
  Object s[] = getChildren(BUnit.class);  //..
  int r = 0; 
  int c = 0;
  setGroupState(new BStatusEnum(BUState.off, BStatus.ok)); 
  for(int i = 0;  i<getSlotCount(BUnit.class);i++)
  {
    c =    ((BUnit)s[i]).getUnitState().getValue().getOrdinal();
    switch(c){
      case BUState.SERVICE           :   continue;          
      case BUState.ALARM             :   
        setGroupState(new BStatusEnum(BUState.alarm, BStatus.ok)); 
      continue; 
      case BUState.WARNING           :   
        if(getGroupState().getValue().getOrdinal() == BUState.ALARM ) continue; 
        else setGroupState(new BStatusEnum(BUState.warning, BStatus.ok));  
      continue; 
      case BUState.ON           :   
        if(getGroupState().getValue().getOrdinal() == BUState.ALARM || getGroupState().getValue().getOrdinal() == BUState.WARNING) continue; 
        else setGroupState(new BStatusEnum(BUState.on, BStatus.ok));  
      continue; 
      case BUState.STANDBY           :   
        if(getGroupState().getValue().getOrdinal() == BUState.ALARM || getGroupState().getValue().getOrdinal() == BUState.WARNING || getGroupState().getValue().getOrdinal() == BUState.ON) continue; 
        else setGroupState(new BStatusEnum(BUState.standby, BStatus.ok));  
      continue; 
      case BUState.OFF           :   
        if(getGroupState().getValue().getOrdinal() == BUState.ALARM || getGroupState().getValue().getOrdinal() == BUState.WARNING || getGroupState().getValue().getOrdinal() == BUState.ON || getGroupState().getValue().getOrdinal() == BUState.STANDBY) continue; 
        else setGroupState(new BStatusEnum(BUState.off, BStatus.ok));  
      continue; 
    }
  }
}

public void doNormalToService() throws Exception
{
  setGroupState(new BStatusEnum(BUState.service, BStatus.ok)); 
}  
public void doServiceToNormal() throws Exception
{
  setGroupState(new BStatusEnum(BUState.off, BStatus.ok));
  updateGroupState();
}  


}

/*

*/     
package com.bc.TOService;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;


//import javxa.baja.agent.*;


import javax.baja.status.*;
import javax.baja.alarm.*;
import javax.baja.status.BStatusString;
import javax.baja.util.*;
import javax.baja.util.BFormat;
import javax.baja.naming.*;
import javax.baja.registry.*;
// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BEquipment extends BComponent
{ 
  
  /*-  
  class BEquipment  
  {  
    properties  
    {  
 
    }   
    actions
    {
    
     addReglamentAction(arg: BString)                                      flags { operator, summary } default {[ BString.make("newReglamentAction") ]}
     addAlarmAction(arg: BString)                                      flags { operator, summary } default {[ BString.make("newAlarmAction") ]}
     addUpgradeAction(arg: BString)                                      flags { operator, summary } default {[ BString.make("newUpgradeAction") ]}
     addWarantyAction(arg: BString)                                      flags { operator, summary } default {[ BString.make("newWarantyAction") ]}

    }
  }  
  -*/







/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BEquipment(2119176941)1.0$ @*/
/* Generated Tue Jun 08 05:35:14 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Action "addReglamentAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addReglamentAction} action.
   * @see #addReglamentAction(BString arg)
   */
  public static final Action addReglamentAction = newAction(Flags.OPERATOR|Flags.SUMMARY, BString.make("newReglamentAction"), null);
  
  /**
   * Invoke the {@code addReglamentAction} action.
   * @see #addReglamentAction
   */
  public void addReglamentAction(BString arg) { invoke(addReglamentAction, arg, null); }

////////////////////////////////////////////////////////////////
// Action "addAlarmAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addAlarmAction} action.
   * @see #addAlarmAction(BString arg)
   */
  public static final Action addAlarmAction = newAction(Flags.OPERATOR|Flags.SUMMARY, BString.make("newAlarmAction"), null);
  
  /**
   * Invoke the {@code addAlarmAction} action.
   * @see #addAlarmAction
   */
  public void addAlarmAction(BString arg) { invoke(addAlarmAction, arg, null); }

////////////////////////////////////////////////////////////////
// Action "addUpgradeAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addUpgradeAction} action.
   * @see #addUpgradeAction(BString arg)
   */
  public static final Action addUpgradeAction = newAction(Flags.OPERATOR|Flags.SUMMARY, BString.make("newUpgradeAction"), null);
  
  /**
   * Invoke the {@code addUpgradeAction} action.
   * @see #addUpgradeAction
   */
  public void addUpgradeAction(BString arg) { invoke(addUpgradeAction, arg, null); }

////////////////////////////////////////////////////////////////
// Action "addWarantyAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addWarantyAction} action.
   * @see #addWarantyAction(BString arg)
   */
  public static final Action addWarantyAction = newAction(Flags.OPERATOR|Flags.SUMMARY, BString.make("newWarantyAction"), null);
  
  /**
   * Invoke the {@code addWarantyAction} action.
   * @see #addWarantyAction
   */
  public void addWarantyAction(BString arg) { invoke(addWarantyAction, arg, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEquipment.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/






  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    BValue dynamic = get("icon");
    if (dynamic instanceof BIcon)
      return (BIcon)dynamic;
    return icon; 
  }
  private static final BIcon icon = BIcon.std("device.png");
// private static final BIcon icon = BIcon.std("shapes/circleGreen.png");






// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();

}          


public void doAddReglamentAction(BString str) throws Exception
{
    this.add(str.toString(), new BReglamentAction() );
}
public void doAddAlarmAction(BString str) throws Exception
{
    this.add(str.toString(), new BAlarmAction() );
}
public void doAddUpgradeAction(BString str) throws Exception
{
    this.add(str.toString(), new BUpgradeAction() );
}
public void doAddWarantyAction(BString str) throws Exception
{
    this.add(str.toString(), new BWarantyAction() );
}


public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);

   ((BComponent)getParent()).changed(p, cx);
   System.out.println("BEquipment =  getType() = " + getType() + "  Super.getType() = " + super.getType());
}

}
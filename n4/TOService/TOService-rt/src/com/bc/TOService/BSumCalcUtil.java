/*

*/     
package com.bc.TOService;  



import javax.baja.sys.*;



public class BSumCalcUtil extends BComponent
{ 
  
  /*-  
  class BSumCalcUtil  
  {  
    properties  
    {  
    countOfEquipment                  :     BAuditCountOfEquipment      flags { readonly, summary }                    default {[new BAuditCountOfEquipment()  ]}

    reglamentAction                  :     BAuditCountOfActions      flags { readonly, summary }                    default {[new BAuditCountOfActions()  ]}
    reglamentLabor                   :     BAuditLaborOfActions      flags { readonly, summary }                    default {[new BAuditLaborOfActions()  ]}

    alarmAction                  :     BAuditCountOfActions      flags { readonly, summary }                    default {[new BAuditCountOfActions()  ]}
    alarmLabor                   :     BAuditLaborOfActions      flags { readonly, summary }                    default {[new BAuditLaborOfActions()  ]}

    upgradeAction                  :     BAuditCountOfActions      flags { readonly, summary }                    default {[new BAuditCountOfActions()  ]}
    upgradeLabor                   :     BAuditLaborOfActions      flags { readonly, summary }                    default {[new BAuditLaborOfActions()  ]}

    warantyAction                  :     BAuditCountOfActions      flags { readonly, summary }                    default {[new BAuditCountOfActions()  ]}
    warantyLabor                   :     BAuditLaborOfActions      flags { readonly, summary }                    default {[new BAuditLaborOfActions()  ]}
 
    }   
    actions
    {
     updateCountersFields()                                   flags { summary }        -- default {[ BString.make("no Need to Add") ]}
    
    }
  }  
  -*/


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BSumCalcUtil(2303353902)1.0$ @*/
/* Generated Wed Jun 09 05:52:31 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "countOfEquipment"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code countOfEquipment} property.
   * @see #getCountOfEquipment
   * @see #setCountOfEquipment
   */
  public static final Property countOfEquipment = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditCountOfEquipment(), null);
  
  /**
   * Get the {@code countOfEquipment} property.
   * @see #countOfEquipment
   */
  public BAuditCountOfEquipment getCountOfEquipment() { return (BAuditCountOfEquipment)get(countOfEquipment); }
  
  /**
   * Set the {@code countOfEquipment} property.
   * @see #countOfEquipment
   */
  public void setCountOfEquipment(BAuditCountOfEquipment v) { set(countOfEquipment, v, null); }

////////////////////////////////////////////////////////////////
// Property "reglamentAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code reglamentAction} property.
   * @see #getReglamentAction
   * @see #setReglamentAction
   */
  public static final Property reglamentAction = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditCountOfActions(), null);
  
  /**
   * Get the {@code reglamentAction} property.
   * @see #reglamentAction
   */
  public BAuditCountOfActions getReglamentAction() { return (BAuditCountOfActions)get(reglamentAction); }
  
  /**
   * Set the {@code reglamentAction} property.
   * @see #reglamentAction
   */
  public void setReglamentAction(BAuditCountOfActions v) { set(reglamentAction, v, null); }

////////////////////////////////////////////////////////////////
// Property "reglamentLabor"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code reglamentLabor} property.
   * @see #getReglamentLabor
   * @see #setReglamentLabor
   */
  public static final Property reglamentLabor = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditLaborOfActions(), null);
  
  /**
   * Get the {@code reglamentLabor} property.
   * @see #reglamentLabor
   */
  public BAuditLaborOfActions getReglamentLabor() { return (BAuditLaborOfActions)get(reglamentLabor); }
  
  /**
   * Set the {@code reglamentLabor} property.
   * @see #reglamentLabor
   */
  public void setReglamentLabor(BAuditLaborOfActions v) { set(reglamentLabor, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmAction} property.
   * @see #getAlarmAction
   * @see #setAlarmAction
   */
  public static final Property alarmAction = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditCountOfActions(), null);
  
  /**
   * Get the {@code alarmAction} property.
   * @see #alarmAction
   */
  public BAuditCountOfActions getAlarmAction() { return (BAuditCountOfActions)get(alarmAction); }
  
  /**
   * Set the {@code alarmAction} property.
   * @see #alarmAction
   */
  public void setAlarmAction(BAuditCountOfActions v) { set(alarmAction, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmLabor"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmLabor} property.
   * @see #getAlarmLabor
   * @see #setAlarmLabor
   */
  public static final Property alarmLabor = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditLaborOfActions(), null);
  
  /**
   * Get the {@code alarmLabor} property.
   * @see #alarmLabor
   */
  public BAuditLaborOfActions getAlarmLabor() { return (BAuditLaborOfActions)get(alarmLabor); }
  
  /**
   * Set the {@code alarmLabor} property.
   * @see #alarmLabor
   */
  public void setAlarmLabor(BAuditLaborOfActions v) { set(alarmLabor, v, null); }

////////////////////////////////////////////////////////////////
// Property "upgradeAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code upgradeAction} property.
   * @see #getUpgradeAction
   * @see #setUpgradeAction
   */
  public static final Property upgradeAction = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditCountOfActions(), null);
  
  /**
   * Get the {@code upgradeAction} property.
   * @see #upgradeAction
   */
  public BAuditCountOfActions getUpgradeAction() { return (BAuditCountOfActions)get(upgradeAction); }
  
  /**
   * Set the {@code upgradeAction} property.
   * @see #upgradeAction
   */
  public void setUpgradeAction(BAuditCountOfActions v) { set(upgradeAction, v, null); }

////////////////////////////////////////////////////////////////
// Property "upgradeLabor"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code upgradeLabor} property.
   * @see #getUpgradeLabor
   * @see #setUpgradeLabor
   */
  public static final Property upgradeLabor = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditLaborOfActions(), null);
  
  /**
   * Get the {@code upgradeLabor} property.
   * @see #upgradeLabor
   */
  public BAuditLaborOfActions getUpgradeLabor() { return (BAuditLaborOfActions)get(upgradeLabor); }
  
  /**
   * Set the {@code upgradeLabor} property.
   * @see #upgradeLabor
   */
  public void setUpgradeLabor(BAuditLaborOfActions v) { set(upgradeLabor, v, null); }

////////////////////////////////////////////////////////////////
// Property "warantyAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code warantyAction} property.
   * @see #getWarantyAction
   * @see #setWarantyAction
   */
  public static final Property warantyAction = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditCountOfActions(), null);
  
  /**
   * Get the {@code warantyAction} property.
   * @see #warantyAction
   */
  public BAuditCountOfActions getWarantyAction() { return (BAuditCountOfActions)get(warantyAction); }
  
  /**
   * Set the {@code warantyAction} property.
   * @see #warantyAction
   */
  public void setWarantyAction(BAuditCountOfActions v) { set(warantyAction, v, null); }

////////////////////////////////////////////////////////////////
// Property "warantyLabor"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code warantyLabor} property.
   * @see #getWarantyLabor
   * @see #setWarantyLabor
   */
  public static final Property warantyLabor = newProperty(Flags.READONLY|Flags.SUMMARY, new BAuditLaborOfActions(), null);
  
  /**
   * Get the {@code warantyLabor} property.
   * @see #warantyLabor
   */
  public BAuditLaborOfActions getWarantyLabor() { return (BAuditLaborOfActions)get(warantyLabor); }
  
  /**
   * Set the {@code warantyLabor} property.
   * @see #warantyLabor
   */
  public void setWarantyLabor(BAuditLaborOfActions v) { set(warantyLabor, v, null); }

////////////////////////////////////////////////////////////////
// Action "updateCountersFields"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code updateCountersFields} action.
   * @see #updateCountersFields()
   */
  public static final Action updateCountersFields = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code updateCountersFields} action.
   * @see #updateCountersFields
   */
  public void updateCountersFields() { invoke(updateCountersFields, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSumCalcUtil.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/




  
// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();

}      
// Override method
public void calcStatistic() throws Exception
{

     getCountOfEquipment().clearSlotsValues();    
     calcEquipment((BComponent) this.getParent(),"TOService:Equipment", getCountOfEquipment());
     getReglamentAction().clearSlotsValues();          
     getReglamentLabor().clearSlotsValues();
     calcAction((BComponent) this.getParent(),"TOService:ReglamentAction",getReglamentAction(),getReglamentLabor());
     getAlarmAction().clearSlotsValues();          
     getAlarmLabor().clearSlotsValues();
     calcAction((BComponent) this.getParent(),"TOService:AlarmAction",getAlarmAction(),getAlarmLabor());
     getUpgradeAction().clearSlotsValues();          
     getUpgradeLabor().clearSlotsValues();
     calcAction((BComponent) this.getParent(),"TOService:UpgradeAction",getUpgradeAction(),getUpgradeLabor());
     getWarantyAction().clearSlotsValues();          
     getWarantyLabor().clearSlotsValues();
     calcAction((BComponent) this.getParent(),"TOService:WarantyAction",getWarantyAction(),getWarantyLabor());
   


}
public void doUpdateCountersFields() throws Exception
{
  try{
    calcStatistic();
  }
  catch(Exception e) {
      // Do nothing
  }    
}
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  //System.out.println("BSite =  getType() = " + getType() + "  Super.getType() = " + super.getType());
  try{
    //calcStatistic();
  }
  catch(Exception e) {
      // Do nothing
    }
}

//========== Calculation block

public void calcEquipment(BComponent c, String classType, BAuditCountOfEquipment Equipment )  throws Exception
{

    String classtype = c.getType().toString();
      if(classtype.equalsIgnoreCase(classType )){
        //-------------Total------------------
        Equipment.setTotal( Equipment.getTotal() + 1); //Total Equipment calculation

      }
    BComponent[] kids = c.getChildComponents();
    for(int i=0; i<kids.length; ++i)
      calcEquipment(kids[i],classType, Equipment );
    
}
public void calcAction(BComponent c, String classType, BAuditCountOfActions Action, BAuditLaborOfActions Labor )  throws Exception
{

    String classtype = c.getType().toString();
      if(classtype.equalsIgnoreCase(classType)){
        //-------------Total------------------
        Action.setTotal( Action.getTotal() + 1); //Total Action calculation
        Labor.setTotal(BRelTime.make  (  ((BEquipmentAction)c).getTimeLapse().getMillis() + Labor.getTotal().getMillis() ));  //Total Labor calculation 
        //-------------Done and Undone ------------------
        if( ((BEquipmentAction)c).getDoneFlag() ){
          Action.setDone( Action.getDone() + 1); 
          Labor.setDone(BRelTime.make  (  ((BEquipmentAction)c).getTimeLapse().getMillis() + Labor.getDone().getMillis() ));  //Done Labor calculation 
        }
        else {
          Action.setUndone( Action.getUndone() + 1);
          Labor.setUndone(BRelTime.make  (  ((BEquipmentAction)c).getTimeLapse().getMillis() + Labor.getUndone().getMillis() ));  //Undone Labor calculation 
        }
        //-------------Checked and Unchecked ------------------
        if( ((BEquipmentAction)c).getCheckedFlag() ){
          Action.setChecked( Action.getChecked() + 1);
          Labor.setChecked(BRelTime.make  (  ((BEquipmentAction)c).getTimeLapse().getMillis() + Labor.getChecked().getMillis() ));  //Checked Labor calculation 
        }
        else if ( ((BEquipmentAction)c).getDoneFlag() && !((BEquipmentAction)c).getCheckedFlag()) {
          Action.setUnchecked( Action.getUnchecked() + 1); 
          Labor.setUnchecked(BRelTime.make  (  ((BEquipmentAction)c).getTimeLapse().getMillis() + Labor.getUnchecked().getMillis() ));  //Unchecked Labor calculation 

        } 
        
        //System.out.println(c.toPathString() + " [" + c.getType() + "]");
 
      }
    // 
    BComponent[] kids = c.getChildComponents();
    for(int i=0; i<kids.length; ++i)
      calcAction(kids[i],classType, Action, Labor );
    
}



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
  private static final BIcon icon = BIcon.std("add.png");

}
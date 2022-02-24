/*

*/     
package com.bc.TOService;  



import javax.baja.sys.*;



public class BArea extends BComponent
{ 
  
  /*-  
  class BArea  
  {  
    properties  
    {  
    }   
    actions
    {
     addEquipment(arg: BString)                                   flags { operator, summary } default {[ BString.make("newEquipment") ]}
    
    }
  }  
  -*/

/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BArea(3608594719)1.0$ @*/
/* Generated Thu Jun 03 13:08:21 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Action "addEquipment"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addEquipment} action.
   * @see #addEquipment(BString arg)
   */
  public static final Action addEquipment = newAction(Flags.OPERATOR|Flags.SUMMARY, BString.make("newEquipment"), null);
  
  /**
   * Invoke the {@code addEquipment} action.
   * @see #addEquipment
   */
  public void addEquipment(BString arg) { invoke(addEquipment, arg, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BArea.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  
// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();

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
  private static final BIcon icon = BIcon.std("editPolygon.png");




public void doAddEquipment(BString str) throws Exception
{
    this.add(str.toString(), new BEquipment() );
}


}
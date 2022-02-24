/*

*/     
package com.bc.TOService;  


import javax.baja.sys.*;

public class BFloor extends BComponent
{ 
  
  /*-  
  class BFloor  
  {  
    properties  
    {  
    }   
    actions
    {
     addArea(arg: BString)                                   flags { operator, summary } default {[ BString.make("newArea") ]}
    }
  }  
  -*/


/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BFloor(3239049998)1.0$ @*/
/* Generated Thu Jun 03 13:03:03 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Action "addArea"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addArea} action.
   * @see #addArea(BString arg)
   */
  public static final Action addArea = newAction(Flags.OPERATOR|Flags.SUMMARY, BString.make("newArea"), null);
  
  /**
   * Invoke the {@code addArea} action.
   * @see #addArea
   */
  public void addArea(BString arg) { invoke(addArea, arg, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFloor.class);

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
    return icon; 
  }
  private static final BIcon icon = BIcon.std("allDescendants.png"); //module://icons/x16/

public void doAddArea(BString str) throws Exception
{
    this.add(str.toString(), new BArea() );
}



}
/*

*/     
package com.bc.componentsToAction;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;


import javax.baja.agent.*;


import javax.baja.status.*;

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BComponentsToAction extends BComponent
{ 
  
  /*-  
  class BComponentsToAction  
  {  
    properties  
    {  
       in           :     BString     flags { summary }      default {[ "" ]}     
       mask         :     BString     flags { summary }      default {[ "" ]}     
       parentAction :     BString     flags { summary }      default {[ "" ]}     
      
    }   
    actions 
    {

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.componentsToAction.BComponentsToAction(1129118370)1.0$ @*/
/* Generated Thu Feb 03 08:06:10 MSK 2022 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "in"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in} property.
   * @see #getIn
   * @see #setIn
   */
  public static final Property in = newProperty(Flags.SUMMARY, "", null);
  
  /**
   * Get the {@code in} property.
   * @see #in
   */
  public String getIn() { return getString(in); }
  
  /**
   * Set the {@code in} property.
   * @see #in
   */
  public void setIn(String v) { setString(in, v, null); }

////////////////////////////////////////////////////////////////
// Property "mask"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code mask} property.
   * @see #getMask
   * @see #setMask
   */
  public static final Property mask = newProperty(Flags.SUMMARY, "", null);
  
  /**
   * Get the {@code mask} property.
   * @see #mask
   */
  public String getMask() { return getString(mask); }
  
  /**
   * Set the {@code mask} property.
   * @see #mask
   */
  public void setMask(String v) { setString(mask, v, null); }

////////////////////////////////////////////////////////////////
// Property "parentAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code parentAction} property.
   * @see #getParentAction
   * @see #setParentAction
   */
  public static final Property parentAction = newProperty(Flags.SUMMARY, "", null);
  
  /**
   * Get the {@code parentAction} property.
   * @see #parentAction
   */
  public String getParentAction() { return getString(parentAction); }
  
  /**
   * Set the {@code parentAction} property.
   * @see #parentAction
   */
  public void setParentAction(String v) { setString(parentAction, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BComponentsToAction.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/








// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
}  
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  if( (p == in || p == mask ) && (getIn().equalsIgnoreCase(getMask())) ){  
    if( this.getParent().getAction(getParentAction() ) != null){
     ((BComponent)this.getParent()).doInvoke(this.getParent().getAction(getParentAction() ),null,null);   
    }
    else{
      System.out.println(" Action " + getParentAction() + " not exist!" );
    }
     
  }
}

}

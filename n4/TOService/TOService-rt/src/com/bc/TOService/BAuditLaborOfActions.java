/*

*/     
package com.bc.TOService;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;


import javax.baja.status.*;
import javax.baja.alarm.*;
import javax.baja.status.BStatusString;
import javax.baja.util.*;
import javax.baja.util.BFormat;
import javax.baja.naming.*;
import javax.baja.registry.*;
// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BAuditLaborOfActions extends BComponent
{ 
  
  /*-  
  class BAuditLaborOfActions 
  {  
    properties  
    {  
      total           :     BRelTime      flags { summary,readonly}                     default {[ BRelTime.makeHours(1) ]}                slotfacets {[ BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE) ]}
      undone          :     BRelTime      flags { summary,readonly}                     default {[ BRelTime.makeHours(1) ]}                slotfacets {[ BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE) ]}
      done            :     BRelTime      flags { summary,readonly}                     default {[ BRelTime.makeHours(1) ]}                slotfacets {[ BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE) ]}
      unchecked       :     BRelTime      flags { summary,readonly}                     default {[ BRelTime.makeHours(1) ]}                slotfacets {[ BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE) ]}
      checked         :     BRelTime      flags { summary,readonly}                     default {[ BRelTime.makeHours(1) ]}                slotfacets {[ BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE) ]}
    }   
    actions
    {
 
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BAuditLaborOfActions(3236495389)1.0$ @*/
/* Generated Sat Jun 05 16:15:06 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "total"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code total} property.
   * @see #getTotal
   * @see #setTotal
   */
  public static final Property total = newProperty(Flags.SUMMARY|Flags.READONLY, BRelTime.makeHours(1), BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE));
  
  /**
   * Get the {@code total} property.
   * @see #total
   */
  public BRelTime getTotal() { return (BRelTime)get(total); }
  
  /**
   * Set the {@code total} property.
   * @see #total
   */
  public void setTotal(BRelTime v) { set(total, v, null); }

////////////////////////////////////////////////////////////////
// Property "undone"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code undone} property.
   * @see #getUndone
   * @see #setUndone
   */
  public static final Property undone = newProperty(Flags.SUMMARY|Flags.READONLY, BRelTime.makeHours(1), BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE));
  
  /**
   * Get the {@code undone} property.
   * @see #undone
   */
  public BRelTime getUndone() { return (BRelTime)get(undone); }
  
  /**
   * Set the {@code undone} property.
   * @see #undone
   */
  public void setUndone(BRelTime v) { set(undone, v, null); }

////////////////////////////////////////////////////////////////
// Property "done"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code done} property.
   * @see #getDone
   * @see #setDone
   */
  public static final Property done = newProperty(Flags.SUMMARY|Flags.READONLY, BRelTime.makeHours(1), BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE));
  
  /**
   * Get the {@code done} property.
   * @see #done
   */
  public BRelTime getDone() { return (BRelTime)get(done); }
  
  /**
   * Set the {@code done} property.
   * @see #done
   */
  public void setDone(BRelTime v) { set(done, v, null); }

////////////////////////////////////////////////////////////////
// Property "unchecked"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code unchecked} property.
   * @see #getUnchecked
   * @see #setUnchecked
   */
  public static final Property unchecked = newProperty(Flags.SUMMARY|Flags.READONLY, BRelTime.makeHours(1), BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE));
  
  /**
   * Get the {@code unchecked} property.
   * @see #unchecked
   */
  public BRelTime getUnchecked() { return (BRelTime)get(unchecked); }
  
  /**
   * Set the {@code unchecked} property.
   * @see #unchecked
   */
  public void setUnchecked(BRelTime v) { set(unchecked, v, null); }

////////////////////////////////////////////////////////////////
// Property "checked"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code checked} property.
   * @see #getChecked
   * @see #setChecked
   */
  public static final Property checked = newProperty(Flags.SUMMARY|Flags.READONLY, BRelTime.makeHours(1), BFacets.make(BFacets.SHOW_TIME, BBoolean.TRUE));
  
  /**
   * Get the {@code checked} property.
   * @see #checked
   */
  public BRelTime getChecked() { return (BRelTime)get(checked); }
  
  /**
   * Set the {@code checked} property.
   * @see #checked
   */
  public void setChecked(BRelTime v) { set(checked, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAuditLaborOfActions.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

public void clearSlotsValues(){
  setTotal(BRelTime.make(0));
  setDone(BRelTime.make(0));  
  setUndone(BRelTime.make(0));
  setChecked(BRelTime.make(0));  
  setUnchecked(BRelTime.make(0));  
}
  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    return icon; 
  }
  private static final BIcon icon = BIcon.std("clock.png");

}
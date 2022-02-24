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
public class BAuditCountOfActions extends BComponent
{ 
  
  /*-  
  class BAuditCountOfActions 
  {  
    properties  
    {  
      total         :     long          flags { readonly, summary }          default {[BInteger.DEFAULT  ]}
      undone        :     long          flags { readonly, summary }          default {[BInteger.DEFAULT  ]}
      done          :     long          flags { readonly, summary }          default {[BInteger.DEFAULT  ]}
      unchecked     :     long          flags { readonly, summary }          default {[BInteger.DEFAULT  ]}
      checked       :     long          flags { readonly, summary }          default {[BInteger.DEFAULT  ]}
    }   
    actions
    {
 
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BAuditCountOfActions(3341363470)1.0$ @*/
/* Generated Sat Jun 05 16:15:06 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "total"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code total} property.
   * @see #getTotal
   * @see #setTotal
   */
  public static final Property total = newProperty(Flags.READONLY|Flags.SUMMARY, BInteger.DEFAULT, null);
  
  /**
   * Get the {@code total} property.
   * @see #total
   */
  public long getTotal() { return getLong(total); }
  
  /**
   * Set the {@code total} property.
   * @see #total
   */
  public void setTotal(long v) { setLong(total, v, null); }

////////////////////////////////////////////////////////////////
// Property "undone"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code undone} property.
   * @see #getUndone
   * @see #setUndone
   */
  public static final Property undone = newProperty(Flags.READONLY|Flags.SUMMARY, BInteger.DEFAULT, null);
  
  /**
   * Get the {@code undone} property.
   * @see #undone
   */
  public long getUndone() { return getLong(undone); }
  
  /**
   * Set the {@code undone} property.
   * @see #undone
   */
  public void setUndone(long v) { setLong(undone, v, null); }

////////////////////////////////////////////////////////////////
// Property "done"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code done} property.
   * @see #getDone
   * @see #setDone
   */
  public static final Property done = newProperty(Flags.READONLY|Flags.SUMMARY, BInteger.DEFAULT, null);
  
  /**
   * Get the {@code done} property.
   * @see #done
   */
  public long getDone() { return getLong(done); }
  
  /**
   * Set the {@code done} property.
   * @see #done
   */
  public void setDone(long v) { setLong(done, v, null); }

////////////////////////////////////////////////////////////////
// Property "unchecked"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code unchecked} property.
   * @see #getUnchecked
   * @see #setUnchecked
   */
  public static final Property unchecked = newProperty(Flags.READONLY|Flags.SUMMARY, BInteger.DEFAULT, null);
  
  /**
   * Get the {@code unchecked} property.
   * @see #unchecked
   */
  public long getUnchecked() { return getLong(unchecked); }
  
  /**
   * Set the {@code unchecked} property.
   * @see #unchecked
   */
  public void setUnchecked(long v) { setLong(unchecked, v, null); }

////////////////////////////////////////////////////////////////
// Property "checked"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code checked} property.
   * @see #getChecked
   * @see #setChecked
   */
  public static final Property checked = newProperty(Flags.READONLY|Flags.SUMMARY, BInteger.DEFAULT, null);
  
  /**
   * Get the {@code checked} property.
   * @see #checked
   */
  public long getChecked() { return getLong(checked); }
  
  /**
   * Set the {@code checked} property.
   * @see #checked
   */
  public void setChecked(long v) { setLong(checked, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAuditCountOfActions.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
public void clearSlotsValues(){
  setTotal(0);
  setDone(0);  
  setUndone(0);
  setChecked(0);  
  setUnchecked(0);  
}
  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    return icon; 
  }
  private static final BIcon icon = BIcon.std("buildSave.png");

}
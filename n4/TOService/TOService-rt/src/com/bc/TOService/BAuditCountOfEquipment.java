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
public class BAuditCountOfEquipment extends BComponent
{ 
  
  /*-  
  class BAuditCountOfEquipment 
  {  
    properties  
    {  
      total         :     long          flags { readonly, summary }          default {[BInteger.DEFAULT  ]}
    }   
    actions
    {
 
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BAuditCountOfEquipment(1541746325)1.0$ @*/
/* Generated Tue Jun 08 08:06:58 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAuditCountOfEquipment.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  
public void clearSlotsValues(){
  setTotal(0);
 
}
  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    return icon; 
  }
  private static final BIcon icon = BIcon.std("control/math/add.png");

}
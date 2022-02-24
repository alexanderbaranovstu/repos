package com.bc.CommonLogic.mau;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.control.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;
import javax.baja.util.BFormat;
 
public class BEquipment extends BComponent   
{  

  /*-  
  class BEquipment  
  {  
    properties  
    {  
      sourceName: BFormat
        -- Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
        default {[ BFormat.make("%displayName%") ]}
        
      alarmFire: BStatusBoolean
        flags { HIDDEN }
        default {[ new BStatusBoolean(false, BStatus.nullStatus) ]}          
      alarmAFP: BStatusBoolean
        flags { SUMMARY }
        default {[ new BStatusBoolean(false, BStatus.nullStatus) ]}                 
      alarmSF: BStatusBoolean
        flags { SUMMARY }
        default {[ new BStatusBoolean(false, BStatus.nullStatus) ]}  
        
    }   
    actions
    {

         
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.mau.BEquipment(1710945811)1.0$ @*/
/* Generated Mon Feb 15 04:45:03 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "sourceName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.mau.BEquipment#getSourceName
   * @see com.bc.CommonLogic.mau.BEquipment#setSourceName
   */
  public static final Property sourceName = newProperty(0, BFormat.make("%displayName%"),null);
  
  /**
   * Get the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.mau.BEquipment#sourceName
   */
  public BFormat getSourceName() { return (BFormat)get(sourceName); }
  
  /**
   * Set the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.mau.BEquipment#sourceName
   */
  public void setSourceName(BFormat v) { set(sourceName,v,null); }

////////////////////////////////////////////////////////////////
// Property "alarmFire"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alarmFire</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#getAlarmFire
   * @see com.bc.CommonLogic.mau.BEquipment#setAlarmFire
   */
  public static final Property alarmFire = newProperty(Flags.HIDDEN, new BStatusBoolean(false, BStatus.nullStatus),null);
  
  /**
   * Get the <code>alarmFire</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#alarmFire
   */
  public BStatusBoolean getAlarmFire() { return (BStatusBoolean)get(alarmFire); }
  
  /**
   * Set the <code>alarmFire</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#alarmFire
   */
  public void setAlarmFire(BStatusBoolean v) { set(alarmFire,v,null); }

////////////////////////////////////////////////////////////////
// Property "alarmAFP"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alarmAFP</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#getAlarmAFP
   * @see com.bc.CommonLogic.mau.BEquipment#setAlarmAFP
   */
  public static final Property alarmAFP = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.nullStatus),null);
  
  /**
   * Get the <code>alarmAFP</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#alarmAFP
   */
  public BStatusBoolean getAlarmAFP() { return (BStatusBoolean)get(alarmAFP); }
  
  /**
   * Set the <code>alarmAFP</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#alarmAFP
   */
  public void setAlarmAFP(BStatusBoolean v) { set(alarmAFP,v,null); }

////////////////////////////////////////////////////////////////
// Property "alarmSF"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alarmSF</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#getAlarmSF
   * @see com.bc.CommonLogic.mau.BEquipment#setAlarmSF
   */
  public static final Property alarmSF = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.nullStatus),null);
  
  /**
   * Get the <code>alarmSF</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#alarmSF
   */
  public BStatusBoolean getAlarmSF() { return (BStatusBoolean)get(alarmSF); }
  
  /**
   * Set the <code>alarmSF</code> property.
   * @see com.bc.CommonLogic.mau.BEquipment#alarmSF
   */
  public void setAlarmSF(BStatusBoolean v) { set(alarmSF,v,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BEquipment.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

} 

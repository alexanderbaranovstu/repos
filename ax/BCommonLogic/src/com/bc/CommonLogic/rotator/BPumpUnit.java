package com.bc.CommonLogic.rotator;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.control.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;

 
public class BPumpUnit extends BComponent  
{  

  /*-  
  class BPumpUnit  
  {  
    properties  
    {  

      en: BStatusBoolean
        flags { summary }
        default {[ new BStatusBoolean() ]}
      feedBack: BStatusBoolean
        flags { transient, summary }
        default {[ new BStatusBoolean() ]}
      alarmIn: BStatusBoolean
        flags { transient, summary }
        default {[ new BStatusBoolean() ]}      
      out: BStatusBoolean
        flags { transient, summary }
        default {[ new BStatusBoolean() ]}
      runtime: BStatusNumeric
        flags { summary }
        default {[ new BStatusNumeric() ]}
    }   
    actions
    {

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.rotator.BPumpUnit(1877699032)1.0$ @*/
/* Generated Tue Jan 19 15:37:39 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "en"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>en</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#getEn
   * @see com.bc.CommonLogic.rotator.BPumpUnit#setEn
   */
  public static final Property en = newProperty(Flags.SUMMARY, new BStatusBoolean(),null);
  
  /**
   * Get the <code>en</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#en
   */
  public BStatusBoolean getEn() { return (BStatusBoolean)get(en); }
  
  /**
   * Set the <code>en</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#en
   */
  public void setEn(BStatusBoolean v) { set(en,v,null); }

////////////////////////////////////////////////////////////////
// Property "feedBack"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>feedBack</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#getFeedBack
   * @see com.bc.CommonLogic.rotator.BPumpUnit#setFeedBack
   */
  public static final Property feedBack = newProperty(Flags.TRANSIENT|Flags.SUMMARY, new BStatusBoolean(),null);
  
  /**
   * Get the <code>feedBack</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#feedBack
   */
  public BStatusBoolean getFeedBack() { return (BStatusBoolean)get(feedBack); }
  
  /**
   * Set the <code>feedBack</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#feedBack
   */
  public void setFeedBack(BStatusBoolean v) { set(feedBack,v,null); }

////////////////////////////////////////////////////////////////
// Property "alarmIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>alarmIn</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#getAlarmIn
   * @see com.bc.CommonLogic.rotator.BPumpUnit#setAlarmIn
   */
  public static final Property alarmIn = newProperty(Flags.TRANSIENT|Flags.SUMMARY, new BStatusBoolean(),null);
  
  /**
   * Get the <code>alarmIn</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#alarmIn
   */
  public BStatusBoolean getAlarmIn() { return (BStatusBoolean)get(alarmIn); }
  
  /**
   * Set the <code>alarmIn</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#alarmIn
   */
  public void setAlarmIn(BStatusBoolean v) { set(alarmIn,v,null); }

////////////////////////////////////////////////////////////////
// Property "out"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>out</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#getOut
   * @see com.bc.CommonLogic.rotator.BPumpUnit#setOut
   */
  public static final Property out = newProperty(Flags.TRANSIENT|Flags.SUMMARY, new BStatusBoolean(),null);
  
  /**
   * Get the <code>out</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#out
   */
  public BStatusBoolean getOut() { return (BStatusBoolean)get(out); }
  
  /**
   * Set the <code>out</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#out
   */
  public void setOut(BStatusBoolean v) { set(out,v,null); }

////////////////////////////////////////////////////////////////
// Property "runtime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>runtime</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#getRuntime
   * @see com.bc.CommonLogic.rotator.BPumpUnit#setRuntime
   */
  public static final Property runtime = newProperty(Flags.SUMMARY, new BStatusNumeric(),null);
  
  /**
   * Get the <code>runtime</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#runtime
   */
  public BStatusNumeric getRuntime() { return (BStatusNumeric)get(runtime); }
  
  /**
   * Set the <code>runtime</code> property.
   * @see com.bc.CommonLogic.rotator.BPumpUnit#runtime
   */
  public void setRuntime(BStatusNumeric v) { set(runtime,v,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPumpUnit.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public void changed(Property p, Context cx)
  {
    if(p == en) System.out.println(" Change en " );
    if(p == out) System.out.println(" Change out " );
  }
  
} 

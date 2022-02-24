package com.bc.CommonLogic.test;  

import java.util.*;  

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.control.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;

 
public class BParkingFans extends BAhu 
{  

  /*-  
  class BParkingFans  
  {  
    properties  
    {  
 
    }   
    actions
    {
      ControlAction2()
        -- Set the fallback property value.
        flags { operator }
 
    }
 
 
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.test.BParkingFans(4265032944)1.0$ @*/
/* Generated Sun Feb 14 06:46:11 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Action "ControlAction2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>ControlAction2</code> action.
   * Set the fallback property value.
   * @see com.bc.CommonLogic.test.BParkingFans#ControlAction2()
   */
  public static final Action ControlAction2 = newAction(Flags.OPERATOR,null);
  
  /**
   * Invoke the <code>ControlAction2</code> action.
   * Set the fallback property value.
   * @see com.bc.CommonLogic.test.BParkingFans#ControlAction2
   */
  public void ControlAction2() { invoke(ControlAction2,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BParkingFans.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  public  void doControlAction2 (){
    setFallback( new BStatusString("test string" + this.getName()) );
  }

} 

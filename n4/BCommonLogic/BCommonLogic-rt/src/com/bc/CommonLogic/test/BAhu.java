package com.bc.CommonLogic.test;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.control.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;

 
public class BAhu extends BStringWritable 
{  

  /*-  
  class BAhu  
  {  
    properties  
    {  
 
    }   
    actions
    {
      ControlAction()
        -- Set the fallback property value.
        flags { operator }
 
    }
 
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.test.BAhu(2533520902)1.0$ @*/
/* Generated Sun Feb 14 06:46:11 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Action "ControlAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>ControlAction</code> action.
   * Set the fallback property value.
   * @see com.bc.CommonLogic.test.BAhu#ControlAction()
   */
  public static final Action ControlAction = newAction(Flags.OPERATOR,null);
  
  /**
   * Invoke the <code>ControlAction</code> action.
   * Set the fallback property value.
   * @see com.bc.CommonLogic.test.BAhu#ControlAction
   */
  public void ControlAction() { invoke(ControlAction,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAhu.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  public  void doControlAction (){
    setFallback( new BStatusString("test string" + this.getName()) );
  }
} 

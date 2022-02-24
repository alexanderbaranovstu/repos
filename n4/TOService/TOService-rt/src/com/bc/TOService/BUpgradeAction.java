/*

*/     
package com.bc.TOService;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;


//import javxa.baja.agent.*;


import javax.baja.status.*;
import javax.baja.alarm.*;
import javax.baja.status.BStatusString;
import javax.baja.util.*;
import javax.baja.util.BFormat;
import javax.baja.naming.*;
import javax.baja.registry.*;
// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BUpgradeAction extends BEquipmentAction
{ 
  
  /*-  
  class BUpgradeAction 
  {  
    properties  
    {  
    }   
    actions
    {
 
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BUpgradeAction(4035859865)1.0$ @*/
/* Generated Thu Jun 03 18:03:45 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BUpgradeAction.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/




  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    return icon; 
  }
  private static final BIcon icon = BIcon.std("build.png");

}
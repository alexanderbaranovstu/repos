/*

*/     
package com.bc.TOService;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;


import javax.baja.agent.*;
//import javax.baja.ui.*;

import javax.baja.status.*;
import javax.baja.alarm.*;
import javax.baja.status.BStatusString;
import javax.baja.util.*;
import javax.baja.util.BFormat;
import javax.baja.naming.*;
import javax.baja.registry.*;
import com.tridium.report.grid.*; /* report-rt By Property*/

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BSite extends BComponent
{ 
  
  /*-  
  class BSite  
  {  
    properties  
    {  

    }   
    actions
    {
 
     addFloor(arg: BString)                                   flags { operator, summary } default {[ BString.make("newFloor") ]}

    }
  }  
  -*/



/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BSite(1180038939)1.0$ @*/
/* Generated Wed Jun 09 05:40:57 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Action "addFloor"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code addFloor} action.
   * @see #addFloor(BString arg)
   */
  public static final Action addFloor = newAction(Flags.OPERATOR|Flags.SUMMARY, BString.make("newFloor"), null);
  
  /**
   * Invoke the {@code addFloor} action.
   * @see #addFloor
   */
  public void addFloor(BString arg) { invoke(addFloor, arg, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSite.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/









  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    return icon; 
  }
  private static final BIcon icon = BIcon.std("site.png");




// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();

}          


public void doAddFloor(BString str) throws Exception
{
    this.add(str.toString(), new BFloor() );
}



}
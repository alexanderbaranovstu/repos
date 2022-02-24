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

import javax.baja.control.trigger.*; 

// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BSingleOperation extends BComponent
{ 
  
  /*-  
  class BSingleOperation 
  {  
    properties  
    {  
       doneFlag                           :     BBoolean             flags { operator,summary }      default {[ BBoolean.make(false) ]}        slotfacets {[ BFacets.makeBoolean(  BString.make("Yes"), BString.make("no") ) ]}

      operationId                  :     BString         flags { hidden }      default {[ BString.make("operationId") ]}           
      detail                  :     BString         flags { summary }      default {[ BString.make("detail") ]}                          slotfacets {[ BFacets.make(BFacets.MULTI_LINE, BBoolean.TRUE) ]}        
      result                  :     BString         flags { operator,summary }      default {[ BString.make("result") ]}                          slotfacets {[ BFacets.make(BFacets.MULTI_LINE, BBoolean.TRUE) ]} 


    }   
    actions
    {
    

    }
  }  
  -*/












/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.TOService.BSingleOperation(1289209484)1.0$ @*/
/* Generated Wed Jun 16 05:49:07 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "doneFlag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code doneFlag} property.
   * @see #getDoneFlag
   * @see #setDoneFlag
   */
  public static final Property doneFlag = newProperty(Flags.OPERATOR|Flags.SUMMARY, ((BBoolean)(BBoolean.make(false))).getBoolean(), BFacets.makeBoolean(  BString.make("Yes"), BString.make("no") ));
  
  /**
   * Get the {@code doneFlag} property.
   * @see #doneFlag
   */
  public boolean getDoneFlag() { return getBoolean(doneFlag); }
  
  /**
   * Set the {@code doneFlag} property.
   * @see #doneFlag
   */
  public void setDoneFlag(boolean v) { setBoolean(doneFlag, v, null); }

////////////////////////////////////////////////////////////////
// Property "operationId"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code operationId} property.
   * @see #getOperationId
   * @see #setOperationId
   */
  public static final Property operationId = newProperty(Flags.HIDDEN, BString.make("operationId"), null);
  
  /**
   * Get the {@code operationId} property.
   * @see #operationId
   */
  public String getOperationId() { return getString(operationId); }
  
  /**
   * Set the {@code operationId} property.
   * @see #operationId
   */
  public void setOperationId(String v) { setString(operationId, v, null); }

////////////////////////////////////////////////////////////////
// Property "detail"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code detail} property.
   * @see #getDetail
   * @see #setDetail
   */
  public static final Property detail = newProperty(Flags.SUMMARY, BString.make("detail"), BFacets.make(BFacets.MULTI_LINE, BBoolean.TRUE));
  
  /**
   * Get the {@code detail} property.
   * @see #detail
   */
  public String getDetail() { return getString(detail); }
  
  /**
   * Set the {@code detail} property.
   * @see #detail
   */
  public void setDetail(String v) { setString(detail, v, null); }

////////////////////////////////////////////////////////////////
// Property "result"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code result} property.
   * @see #getResult
   * @see #setResult
   */
  public static final Property result = newProperty(Flags.OPERATOR|Flags.SUMMARY, BString.make("result"), BFacets.make(BFacets.MULTI_LINE, BBoolean.TRUE));
  
  /**
   * Get the {@code result} property.
   * @see #result
   */
  public String getResult() { return getString(result); }
  
  /**
   * Set the {@code result} property.
   * @see #result
   */
  public void setResult(String v) { setString(result, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSingleOperation.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/










// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();

}          


  /**
   * Get the icon.
   */
  public BIcon getIcon() 
  { 
    return icon; 
  }
  private static final BIcon icon = BIcon.std("buildModule.png");

}
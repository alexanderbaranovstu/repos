/*

У панели управления Gira 5142 00 специфический интерфейс управления скоростями вентилятора. Панель работает в режиме запрос-ответ с модулем упрвления 
фанкойлом. 
На экранчике должна отображаться текущая скорость вентилятора - 0 - 1 - 2 - 3 и режим работы Man - Auto
кнопки пререключения скоростей работают только если у нас ручной режим работы. В автоматическом режиме работает только обратная связь показывающая на какой скорости работает фанкоил

нам вообще походу ничего не надо - надо задавать температуру и три скорости 

*/     
package com.bc.CommonLogic.fcuModule;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.schedule.*;
import javax.baja.agent.*;

import javax.baja.control.*;
import javax.baja.control.util.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;
import javax.baja.util.*;
import javax.baja.util.BFormat;
import javax.baja.naming.*;
import javax.baja.registry.*;
// BStringWritable BStringPoint BControlPoint BComponent BComplex BValue BObject 
public class BKnxGira5142Converter extends BComponent  
{ 
  
  /*-  
  class BKnxGira5142Converter  
  {  
    properties  
    {  
      speedIncr                            :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}
      speedDecr                            :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}

      enumOperation                         :     BStatusEnum           flags { SUMMARY }      default {[ new BStatusEnum(BFcuState.Off, BStatus.ok) ]}      slotfacets {[ BFacets.makeEnum( BEnumRange.make(BFcuState.TYPE) ) ]}
      activeFanLevelIn                        :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}

      activeFanLevelOut                        :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}
      modeIn                        :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}
      modeOut                        :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}

    }   
    actions
    {
    

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.fcuModule.BKnxGira5142Converter(1484950642)1.0$ @*/
/* Generated Wed Jun 23 13:54:16 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "speedIncr"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>speedIncr</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#getSpeedIncr
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#setSpeedIncr
   */
  public static final Property speedIncr = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok),null);
  
  /**
   * Get the <code>speedIncr</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#speedIncr
   */
  public BStatusBoolean getSpeedIncr() { return (BStatusBoolean)get(speedIncr); }
  
  /**
   * Set the <code>speedIncr</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#speedIncr
   */
  public void setSpeedIncr(BStatusBoolean v) { set(speedIncr,v,null); }

////////////////////////////////////////////////////////////////
// Property "speedDecr"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>speedDecr</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#getSpeedDecr
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#setSpeedDecr
   */
  public static final Property speedDecr = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok),null);
  
  /**
   * Get the <code>speedDecr</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#speedDecr
   */
  public BStatusBoolean getSpeedDecr() { return (BStatusBoolean)get(speedDecr); }
  
  /**
   * Set the <code>speedDecr</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#speedDecr
   */
  public void setSpeedDecr(BStatusBoolean v) { set(speedDecr,v,null); }

////////////////////////////////////////////////////////////////
// Property "enumOperation"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>enumOperation</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#getEnumOperation
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#setEnumOperation
   */
  public static final Property enumOperation = newProperty(Flags.SUMMARY, new BStatusEnum(BFcuState.Off, BStatus.ok),BFacets.makeEnum( BEnumRange.make(BFcuState.TYPE) ));
  
  /**
   * Get the <code>enumOperation</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#enumOperation
   */
  public BStatusEnum getEnumOperation() { return (BStatusEnum)get(enumOperation); }
  
  /**
   * Set the <code>enumOperation</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#enumOperation
   */
  public void setEnumOperation(BStatusEnum v) { set(enumOperation,v,null); }

////////////////////////////////////////////////////////////////
// Property "activeFanLevelIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>activeFanLevelIn</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#getActiveFanLevelIn
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#setActiveFanLevelIn
   */
  public static final Property activeFanLevelIn = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.ok),null);
  
  /**
   * Get the <code>activeFanLevelIn</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#activeFanLevelIn
   */
  public BStatusNumeric getActiveFanLevelIn() { return (BStatusNumeric)get(activeFanLevelIn); }
  
  /**
   * Set the <code>activeFanLevelIn</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#activeFanLevelIn
   */
  public void setActiveFanLevelIn(BStatusNumeric v) { set(activeFanLevelIn,v,null); }

////////////////////////////////////////////////////////////////
// Property "activeFanLevelOut"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>activeFanLevelOut</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#getActiveFanLevelOut
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#setActiveFanLevelOut
   */
  public static final Property activeFanLevelOut = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.ok),null);
  
  /**
   * Get the <code>activeFanLevelOut</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#activeFanLevelOut
   */
  public BStatusNumeric getActiveFanLevelOut() { return (BStatusNumeric)get(activeFanLevelOut); }
  
  /**
   * Set the <code>activeFanLevelOut</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#activeFanLevelOut
   */
  public void setActiveFanLevelOut(BStatusNumeric v) { set(activeFanLevelOut,v,null); }

////////////////////////////////////////////////////////////////
// Property "modeIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>modeIn</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#getModeIn
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#setModeIn
   */
  public static final Property modeIn = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok),null);
  
  /**
   * Get the <code>modeIn</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#modeIn
   */
  public BStatusBoolean getModeIn() { return (BStatusBoolean)get(modeIn); }
  
  /**
   * Set the <code>modeIn</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#modeIn
   */
  public void setModeIn(BStatusBoolean v) { set(modeIn,v,null); }

////////////////////////////////////////////////////////////////
// Property "modeOut"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>modeOut</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#getModeOut
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#setModeOut
   */
  public static final Property modeOut = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok),null);
  
  /**
   * Get the <code>modeOut</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#modeOut
   */
  public BStatusBoolean getModeOut() { return (BStatusBoolean)get(modeOut); }
  
  /**
   * Set the <code>modeOut</code> property.
   * @see com.bc.CommonLogic.fcuModule.BKnxGira5142Converter#modeOut
   */
  public void setModeOut(BStatusBoolean v) { set(modeOut,v,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BKnxGira5142Converter.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

/*
  //Здесь мы ловим изменения в слотах на открытие и закрытие ЕСли НА
*/

public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do. modeSwitchIncr
  super.changed(p, cx);
  
  if(p == enumOperation  ){
    
    CNTR = getEnumOperation().getValue().getOrdinal(); 
    
  }
  
 

  if( p == speedIncr && getSpeedIncr().getValue()){ 
    
    if( CNTR < 4 ){CNTR ++;}
    else{CNTR = 0;}
    
   }
  if( p == speedDecr && getSpeedDecr().getValue()){ 
    
    if( CNTR > 0 ){CNTR--;}
    else{CNTR = 4;}
    
   }   
   

   
    switch(CNTR){
      case 0 : getEnumOperation().setValue(BFcuState.Off);             getActiveFanLevelOut().setValue(0);      getModeOut().setValue(true);                     break;
      case 1 : getEnumOperation().setValue(BFcuState.ManualSpeed1);    getActiveFanLevelOut().setValue(1);      getModeOut().setValue(true);                     break;
      case 2 : getEnumOperation().setValue(BFcuState.ManualSpeed2);    getActiveFanLevelOut().setValue(2);      getModeOut().setValue(true);                     break;
      case 3 : getEnumOperation().setValue(BFcuState.ManualSpeed3);    getActiveFanLevelOut().setValue(3);      getModeOut().setValue(true);                     break;
      case 4 : getEnumOperation().setValue(BFcuState.Auto);            getActiveFanLevelOut().setValue(7);      getModeOut().setValue(false);                      break;
 
      
      //System.out.println(" Open PB DePressed ");
  }
  
}

private static int CNTR; //      Off,      ManualSpeed1,      ManualSpeed2,      ManualSpeed3,      Auto



}
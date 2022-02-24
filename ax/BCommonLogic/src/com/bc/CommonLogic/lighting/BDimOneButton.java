/*
Класс позволяет управлять включением/выключением/диммированием при помощи одной кнопки
Пользователь выбирает количество шагов (от 1 до 5) в регулировании и уровень яркости каждого шага

*/

package com.bc.CommonLogic.lighting;  

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
import javax.baja.units.*;
 
public class BDimOneButton extends BStringWritable   
{  

  /*-  
  class BDimOneButton  
  {  
    properties  
    {  
      sourceName: BFormat
        -- Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
        default {[ BFormat.make("%displayName%") ]}
              
                    
      swIn: BBoolean        flags { SUMMARY }     default {[ BBoolean.FALSE ]}   
      numbersOfSteps                        :     BInteger                   flags { SUMMARY }     default {[ BInteger.make(3) ]}                            slotfacets {[ BFacets.makeInt(   BUnit.make("Numbers of Steps", BDimension.NULL), 1, 5)  ]}                       
      step                        :     BInteger                   flags { READONLY }     default {[ BInteger.make(0) ]}                                                 
      outDim                      :     BInteger                   flags { READONLY }     default {[ BInteger.make(0) ]}                                                 
      outStep0                    :     BInteger                   flags { SUMMARY }     default {[ BInteger.make(0) ]}                                      slotfacets {[ BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254)  ]}            
      outStep1                    :     BInteger                   flags { SUMMARY }     default {[ BInteger.make(50) ]}                                     slotfacets {[ BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254)  ]}             
      outStep2                    :     BInteger                   flags { SUMMARY }     default {[ BInteger.make(100) ]}                                    slotfacets {[ BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254)  ]}              
      outStep3                    :     BInteger                   flags { SUMMARY }     default {[ BInteger.make(150) ]}                                    slotfacets {[ BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254)  ]}              
      outStep4                    :     BInteger                   flags { SUMMARY }     default {[ BInteger.make(200) ]}                                    slotfacets {[ BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254)  ]}              
      outStep5                    :     BInteger                   flags { SUMMARY }     default {[ BInteger.make(250) ]}                                    slotfacets {[ BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254)  ]}              
      daliOn                      :     BBoolean                   flags { SUMMARY }     default {[ BBoolean.FALSE ]}
      daliOff                     :     BBoolean                   flags { SUMMARY }     default {[ BBoolean.FALSE ]}
      longPressDelay              :     BInteger                   flags { SUMMARY }     default {[ BInteger.make(100) ]}                                    slotfacets {[ BFacets.makeInt(   BUnit.make("time in milliseconds", BDimension.NULL), 100, 30000)  ]}
      statusLed                   :     BBoolean                   flags { SUMMARY }     default {[ BBoolean.FALSE ]}                                        slotfacets {[ BFacets.makeBoolean(  BString.make("LedOn"), BString.make("LedOff") ) ]}


    }   
    actions
    {

      onCmd()        flags { SUMMARY }
      offCmd()       flags { SUMMARY }
      stepUp()     flags { SUMMARY }          
      stepDown()   flags { SUMMARY }   
      updateOutDim ()  flags { HIDDEN }        

    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.lighting.BDimOneButton(3171232069)1.0$ @*/
/* Generated Mon Nov 22 08:00:27 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "sourceName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getSourceName
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setSourceName
   */
  public static final Property sourceName = newProperty(0, BFormat.make("%displayName%"),null);
  
  /**
   * Get the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#sourceName
   */
  public BFormat getSourceName() { return (BFormat)get(sourceName); }
  
  /**
   * Set the <code>sourceName</code> property.
   * Text descriptor for the source name of the alarm. Uses BFormat, but currently only supports lexicons.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#sourceName
   */
  public void setSourceName(BFormat v) { set(sourceName,v,null); }

////////////////////////////////////////////////////////////////
// Property "swIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>swIn</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getSwIn
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setSwIn
   */
  public static final Property swIn = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),null);
  
  /**
   * Get the <code>swIn</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#swIn
   */
  public boolean getSwIn() { return getBoolean(swIn); }
  
  /**
   * Set the <code>swIn</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#swIn
   */
  public void setSwIn(boolean v) { setBoolean(swIn,v,null); }

////////////////////////////////////////////////////////////////
// Property "numbersOfSteps"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>numbersOfSteps</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getNumbersOfSteps
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setNumbersOfSteps
   */
  public static final Property numbersOfSteps = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(3))).getInt(),BFacets.makeInt(   BUnit.make("Numbers of Steps", BDimension.NULL), 1, 5));
  
  /**
   * Get the <code>numbersOfSteps</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#numbersOfSteps
   */
  public int getNumbersOfSteps() { return getInt(numbersOfSteps); }
  
  /**
   * Set the <code>numbersOfSteps</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#numbersOfSteps
   */
  public void setNumbersOfSteps(int v) { setInt(numbersOfSteps,v,null); }

////////////////////////////////////////////////////////////////
// Property "step"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>step</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getStep
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setStep
   */
  public static final Property step = newProperty(Flags.READONLY, ((BInteger)(BInteger.make(0))).getInt(),null);
  
  /**
   * Get the <code>step</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#step
   */
  public int getStep() { return getInt(step); }
  
  /**
   * Set the <code>step</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#step
   */
  public void setStep(int v) { setInt(step,v,null); }

////////////////////////////////////////////////////////////////
// Property "outDim"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outDim</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getOutDim
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setOutDim
   */
  public static final Property outDim = newProperty(Flags.READONLY, ((BInteger)(BInteger.make(0))).getInt(),null);
  
  /**
   * Get the <code>outDim</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outDim
   */
  public int getOutDim() { return getInt(outDim); }
  
  /**
   * Set the <code>outDim</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outDim
   */
  public void setOutDim(int v) { setInt(outDim,v,null); }

////////////////////////////////////////////////////////////////
// Property "outStep0"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outStep0</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getOutStep0
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setOutStep0
   */
  public static final Property outStep0 = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(0))).getInt(),BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254));
  
  /**
   * Get the <code>outStep0</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep0
   */
  public int getOutStep0() { return getInt(outStep0); }
  
  /**
   * Set the <code>outStep0</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep0
   */
  public void setOutStep0(int v) { setInt(outStep0,v,null); }

////////////////////////////////////////////////////////////////
// Property "outStep1"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outStep1</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getOutStep1
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setOutStep1
   */
  public static final Property outStep1 = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(50))).getInt(),BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254));
  
  /**
   * Get the <code>outStep1</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep1
   */
  public int getOutStep1() { return getInt(outStep1); }
  
  /**
   * Set the <code>outStep1</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep1
   */
  public void setOutStep1(int v) { setInt(outStep1,v,null); }

////////////////////////////////////////////////////////////////
// Property "outStep2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outStep2</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getOutStep2
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setOutStep2
   */
  public static final Property outStep2 = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(100))).getInt(),BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254));
  
  /**
   * Get the <code>outStep2</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep2
   */
  public int getOutStep2() { return getInt(outStep2); }
  
  /**
   * Set the <code>outStep2</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep2
   */
  public void setOutStep2(int v) { setInt(outStep2,v,null); }

////////////////////////////////////////////////////////////////
// Property "outStep3"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outStep3</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getOutStep3
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setOutStep3
   */
  public static final Property outStep3 = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(150))).getInt(),BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254));
  
  /**
   * Get the <code>outStep3</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep3
   */
  public int getOutStep3() { return getInt(outStep3); }
  
  /**
   * Set the <code>outStep3</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep3
   */
  public void setOutStep3(int v) { setInt(outStep3,v,null); }

////////////////////////////////////////////////////////////////
// Property "outStep4"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outStep4</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getOutStep4
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setOutStep4
   */
  public static final Property outStep4 = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(200))).getInt(),BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254));
  
  /**
   * Get the <code>outStep4</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep4
   */
  public int getOutStep4() { return getInt(outStep4); }
  
  /**
   * Set the <code>outStep4</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep4
   */
  public void setOutStep4(int v) { setInt(outStep4,v,null); }

////////////////////////////////////////////////////////////////
// Property "outStep5"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>outStep5</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getOutStep5
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setOutStep5
   */
  public static final Property outStep5 = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(250))).getInt(),BFacets.makeInt(   BUnit.make("Value of Steps", BDimension.NULL), 0, 254));
  
  /**
   * Get the <code>outStep5</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep5
   */
  public int getOutStep5() { return getInt(outStep5); }
  
  /**
   * Set the <code>outStep5</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#outStep5
   */
  public void setOutStep5(int v) { setInt(outStep5,v,null); }

////////////////////////////////////////////////////////////////
// Property "daliOn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>daliOn</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getDaliOn
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setDaliOn
   */
  public static final Property daliOn = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),null);
  
  /**
   * Get the <code>daliOn</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#daliOn
   */
  public boolean getDaliOn() { return getBoolean(daliOn); }
  
  /**
   * Set the <code>daliOn</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#daliOn
   */
  public void setDaliOn(boolean v) { setBoolean(daliOn,v,null); }

////////////////////////////////////////////////////////////////
// Property "daliOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>daliOff</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getDaliOff
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setDaliOff
   */
  public static final Property daliOff = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),null);
  
  /**
   * Get the <code>daliOff</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#daliOff
   */
  public boolean getDaliOff() { return getBoolean(daliOff); }
  
  /**
   * Set the <code>daliOff</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#daliOff
   */
  public void setDaliOff(boolean v) { setBoolean(daliOff,v,null); }

////////////////////////////////////////////////////////////////
// Property "longPressDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>longPressDelay</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getLongPressDelay
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setLongPressDelay
   */
  public static final Property longPressDelay = newProperty(Flags.SUMMARY, ((BInteger)(BInteger.make(100))).getInt(),BFacets.makeInt(   BUnit.make("time in milliseconds", BDimension.NULL), 100, 30000));
  
  /**
   * Get the <code>longPressDelay</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#longPressDelay
   */
  public int getLongPressDelay() { return getInt(longPressDelay); }
  
  /**
   * Set the <code>longPressDelay</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#longPressDelay
   */
  public void setLongPressDelay(int v) { setInt(longPressDelay,v,null); }

////////////////////////////////////////////////////////////////
// Property "statusLed"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>statusLed</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#getStatusLed
   * @see com.bc.CommonLogic.lighting.BDimOneButton#setStatusLed
   */
  public static final Property statusLed = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),BFacets.makeBoolean(  BString.make("LedOn"), BString.make("LedOff") ));
  
  /**
   * Get the <code>statusLed</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#statusLed
   */
  public boolean getStatusLed() { return getBoolean(statusLed); }
  
  /**
   * Set the <code>statusLed</code> property.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#statusLed
   */
  public void setStatusLed(boolean v) { setBoolean(statusLed,v,null); }

////////////////////////////////////////////////////////////////
// Action "onCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>onCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#onCmd()
   */
  public static final Action onCmd = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>onCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#onCmd
   */
  public void onCmd() { invoke(onCmd,null,null); }

////////////////////////////////////////////////////////////////
// Action "offCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>offCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#offCmd()
   */
  public static final Action offCmd = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>offCmd</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#offCmd
   */
  public void offCmd() { invoke(offCmd,null,null); }

////////////////////////////////////////////////////////////////
// Action "stepUp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>stepUp</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#stepUp()
   */
  public static final Action stepUp = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>stepUp</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#stepUp
   */
  public void stepUp() { invoke(stepUp,null,null); }

////////////////////////////////////////////////////////////////
// Action "stepDown"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>stepDown</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#stepDown()
   */
  public static final Action stepDown = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>stepDown</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#stepDown
   */
  public void stepDown() { invoke(stepDown,null,null); }

////////////////////////////////////////////////////////////////
// Action "updateOutDim"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>updateOutDim</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#updateOutDim()
   */
  public static final Action updateOutDim = newAction(Flags.HIDDEN,null);
  
  /**
   * Invoke the <code>updateOutDim</code> action.
   * @see com.bc.CommonLogic.lighting.BDimOneButton#updateOutDim
   */
  public void updateOutDim() { invoke(updateOutDim,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDimOneButton.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

public void started()
{
   initNumberOutputs();
} 



public void changed(Property p, Context cx) {
  if(p == swIn && getSwIn()){
      doUpdateOutDim();
  }
  //if(p == swIn && !getSwIn()){stopLongPressTimer();}
  
  if(p == numbersOfSteps){initNumberOutputs();}
  

}

  
    
  public void doOnCmd() { 

        setDaliOn(false );
        set( BString.make(getSourceName().format(this) + " doOnCmd") );        // BString.make(getSourceName().format(this) + "doOnCmd") 
        setDaliOn(true ); 
        setStep(1);
        putValues();
        
        
  }
  public void doOffCmd() { 

        setDaliOff(false );
        set( BString.make(getSourceName().format(this) + " doOffCmd") );        // BString.make(getSourceName().format(this) + "doOnCmd") 
        setDaliOff(true );
        setStep(0);
        putValues();       
  }
  public void doStepUp() { 

        if(getStep() < getNumbersOfSteps()){setStep(getStep()+1);}
        set( BString.make(getSourceName().format(this) + " StepUp") );        // BString.make(getSourceName().format(this) + "doOnCmd") 
        putValues(); 
  } 
  public void doStepDown() { 

        if(getStep() > 0){setStep(getStep()-1);}
        set( BString.make(getSourceName().format(this) + " StepDown") );        // BString.make(getSourceName().format(this) + "doOnCmd") 
        putValues(); 
  } 
  
   
  public void doUpdateOutDim() {
  
    if(getStep() < getNumbersOfSteps()){setStep(getStep()+1);}
    else {setStep(0);}
    
     putValues(); 
     set( BString.make(getSourceName().format(this) + " UpdateOutDim") );   
      //System.out.println(" doUpdateOutDim Event " + getOutDim() );   
  } 
   void putValues(){
    //if(getSwIn()){startLongPressTimer();}  
      int a = getStep();
      if(a>0){setStatusLed(true);}
      else{setStatusLed(false);}
      
      switch (a){
        case 0 : setOutDim(getOutStep0()); setDaliOff(false ); setDaliOff(true );  break;
        case 1 : setOutDim(getOutStep1()); setDaliOn(false );  setDaliOn(true );  break;
        case 2 : setOutDim(getOutStep2()); setDaliOn(false );  setDaliOn(true );   break;
        case 3 : setOutDim(getOutStep3()); setDaliOn(false );  setDaliOn(true );   break;
        case 4 : setOutDim(getOutStep4()); setDaliOn(false );  setDaliOn(true );   break;
        case 5 : setOutDim(getOutStep5()); setDaliOn(false );  setDaliOn(true );   break;
        
        default : setOutDim(getOutStep0()); setDaliOff(false ); setDaliOff(true );           break;
       }
       
  }
   void initNumberOutputs()
  {
    numOutputs = getNumbersOfSteps();
    int setFlags;
    for(int i = 0; i < 6; i++)
    {
      if(i > numOutputs)
        setFlags = Flags.HIDDEN ;
      else
        setFlags = Flags.SUMMARY ;
      switch(i)
      {
      case 0: initSlot("outStep0", setFlags ); break;
      case 1: initSlot("outStep1", setFlags ); break;
      case 2: initSlot("outStep2", setFlags ); break;
      case 3: initSlot("outStep3", setFlags ); break;
      case 4: initSlot("outStep4", setFlags ); break;
      case 5: initSlot("outStep5", setFlags ); break;

      }
    }
  }
  void initSlot(String slot, int flags)
  {
      try { setFlags(getSlot(slot), flags, null);} catch(Exception e) {};
  }
   
// Globals
int numOutputs;  
public Clock.Ticket dimOneButtonTicket;  
} 

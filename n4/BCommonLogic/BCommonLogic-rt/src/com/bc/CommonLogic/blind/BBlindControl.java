/*
Тут надо отработать нажатие и остановку шторы. короткое нажатие запускает штору вверх/вниз, по изменению выставляется флаг
Если нажатие долгое то при переходе в 0 отсылается команда STOP и штора остается в промежуточном состоянии


*/

package com.bc.CommonLogic.blind;  


import java.util.*;  

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.control.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;
import javax.baja.util.BFormat;
import javax.baja.util.*;
import javax.baja.units.*;

import javax.baja.naming.*;
import javax.baja.registry.*; 
 
public class BBlindControl extends BComponent  //implements Connection 
{  

  /*-  
  class BBlindControl  
  {  
    properties  
    {  
      openIn                            :     BBoolean        flags { SUMMARY }     default {[ BBoolean.FALSE ]}
      openInLongPressDetected           :     BBoolean        flags { HIDDEN }     default {[ BBoolean.FALSE ]}
      
      closeIn                           :     BBoolean        flags { SUMMARY }     default {[ BBoolean.FALSE ]}
      closeInLongPressDetected          :     BBoolean        flags { HIDDEN }     default {[ BBoolean.FALSE ]}
      
      LongPressDelay                    :     int                   flags { SUMMARY }     default {[ 1000 ]}                                                 slotfacets {[ BFacets.makeInt(   BUnit.make("time in milliseconds", BDimension.NULL), 0, 30000)  ]}
      TravelPeriod                      :     int                   flags { SUMMARY }     default {[ 10000 ]}                                                slotfacets {[ BFacets.makeInt(   BUnit.make("time in milliseconds", BDimension.NULL), 0, 600000)  ]}
      
      openCommand                       :     BBoolean        flags { SUMMARY }     default {[ BBoolean.FALSE ]}                slotfacets {[ BFacets.makeBoolean(  BString.make("OpenCmd"), BString.make("NoCmd") ) ]}
      closeCommand                      :     BBoolean        flags { SUMMARY }     default {[ BBoolean.FALSE ]}                slotfacets {[ BFacets.makeBoolean(  BString.make("CloseCmd"), BString.make("NoCmd") ) ]}
      stopCommand                       :     BBoolean        flags { SUMMARY }     default {[ BBoolean.FALSE ]}                slotfacets {[ BFacets.makeBoolean(  BString.make("StopCmd"), BString.make("NoCmd") ) ]}
      enumCmd                           :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BCmd.DEFAULT, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BCmd.TYPE) ) ]}
      

    }   
    actions
    {

      setLongOpenInPbDetect()        flags { HIDDEN }
      setLongCloseInPbDetect()        flags { HIDDEN }   
      interruptTravel()        flags { HIDDEN } 
      openCmd()        flags { SUMMARY }   
      closeCmd()        flags { SUMMARY }  
      stopCmd()        flags { SUMMARY }       
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.blind.BBlindControl(2946931700)1.0$ @*/
/* Generated Wed Nov 17 09:58:05 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "openIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>openIn</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getOpenIn
   * @see com.bc.CommonLogic.blind.BBlindControl#setOpenIn
   */
  public static final Property openIn = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),null);
  
  /**
   * Get the <code>openIn</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#openIn
   */
  public boolean getOpenIn() { return getBoolean(openIn); }
  
  /**
   * Set the <code>openIn</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#openIn
   */
  public void setOpenIn(boolean v) { setBoolean(openIn,v,null); }

////////////////////////////////////////////////////////////////
// Property "openInLongPressDetected"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>openInLongPressDetected</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getOpenInLongPressDetected
   * @see com.bc.CommonLogic.blind.BBlindControl#setOpenInLongPressDetected
   */
  public static final Property openInLongPressDetected = newProperty(Flags.HIDDEN, ((BBoolean)(BBoolean.FALSE)).getBoolean(),null);
  
  /**
   * Get the <code>openInLongPressDetected</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#openInLongPressDetected
   */
  public boolean getOpenInLongPressDetected() { return getBoolean(openInLongPressDetected); }
  
  /**
   * Set the <code>openInLongPressDetected</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#openInLongPressDetected
   */
  public void setOpenInLongPressDetected(boolean v) { setBoolean(openInLongPressDetected,v,null); }

////////////////////////////////////////////////////////////////
// Property "closeIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>closeIn</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getCloseIn
   * @see com.bc.CommonLogic.blind.BBlindControl#setCloseIn
   */
  public static final Property closeIn = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),null);
  
  /**
   * Get the <code>closeIn</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#closeIn
   */
  public boolean getCloseIn() { return getBoolean(closeIn); }
  
  /**
   * Set the <code>closeIn</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#closeIn
   */
  public void setCloseIn(boolean v) { setBoolean(closeIn,v,null); }

////////////////////////////////////////////////////////////////
// Property "closeInLongPressDetected"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>closeInLongPressDetected</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getCloseInLongPressDetected
   * @see com.bc.CommonLogic.blind.BBlindControl#setCloseInLongPressDetected
   */
  public static final Property closeInLongPressDetected = newProperty(Flags.HIDDEN, ((BBoolean)(BBoolean.FALSE)).getBoolean(),null);
  
  /**
   * Get the <code>closeInLongPressDetected</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#closeInLongPressDetected
   */
  public boolean getCloseInLongPressDetected() { return getBoolean(closeInLongPressDetected); }
  
  /**
   * Set the <code>closeInLongPressDetected</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#closeInLongPressDetected
   */
  public void setCloseInLongPressDetected(boolean v) { setBoolean(closeInLongPressDetected,v,null); }

////////////////////////////////////////////////////////////////
// Property "LongPressDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>LongPressDelay</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getLongPressDelay
   * @see com.bc.CommonLogic.blind.BBlindControl#setLongPressDelay
   */
  public static final Property LongPressDelay = newProperty(Flags.SUMMARY, 1000,BFacets.makeInt(   BUnit.make("time in milliseconds", BDimension.NULL), 0, 30000));
  
  /**
   * Get the <code>LongPressDelay</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#LongPressDelay
   */
  public int getLongPressDelay() { return getInt(LongPressDelay); }
  
  /**
   * Set the <code>LongPressDelay</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#LongPressDelay
   */
  public void setLongPressDelay(int v) { setInt(LongPressDelay,v,null); }

////////////////////////////////////////////////////////////////
// Property "TravelPeriod"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>TravelPeriod</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getTravelPeriod
   * @see com.bc.CommonLogic.blind.BBlindControl#setTravelPeriod
   */
  public static final Property TravelPeriod = newProperty(Flags.SUMMARY, 10000,BFacets.makeInt(   BUnit.make("time in milliseconds", BDimension.NULL), 0, 600000));
  
  /**
   * Get the <code>TravelPeriod</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#TravelPeriod
   */
  public int getTravelPeriod() { return getInt(TravelPeriod); }
  
  /**
   * Set the <code>TravelPeriod</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#TravelPeriod
   */
  public void setTravelPeriod(int v) { setInt(TravelPeriod,v,null); }

////////////////////////////////////////////////////////////////
// Property "openCommand"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>openCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getOpenCommand
   * @see com.bc.CommonLogic.blind.BBlindControl#setOpenCommand
   */
  public static final Property openCommand = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),BFacets.makeBoolean(  BString.make("OpenCmd"), BString.make("NoCmd") ));
  
  /**
   * Get the <code>openCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#openCommand
   */
  public boolean getOpenCommand() { return getBoolean(openCommand); }
  
  /**
   * Set the <code>openCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#openCommand
   */
  public void setOpenCommand(boolean v) { setBoolean(openCommand,v,null); }

////////////////////////////////////////////////////////////////
// Property "closeCommand"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>closeCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getCloseCommand
   * @see com.bc.CommonLogic.blind.BBlindControl#setCloseCommand
   */
  public static final Property closeCommand = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),BFacets.makeBoolean(  BString.make("CloseCmd"), BString.make("NoCmd") ));
  
  /**
   * Get the <code>closeCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#closeCommand
   */
  public boolean getCloseCommand() { return getBoolean(closeCommand); }
  
  /**
   * Set the <code>closeCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#closeCommand
   */
  public void setCloseCommand(boolean v) { setBoolean(closeCommand,v,null); }

////////////////////////////////////////////////////////////////
// Property "stopCommand"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>stopCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getStopCommand
   * @see com.bc.CommonLogic.blind.BBlindControl#setStopCommand
   */
  public static final Property stopCommand = newProperty(Flags.SUMMARY, ((BBoolean)(BBoolean.FALSE)).getBoolean(),BFacets.makeBoolean(  BString.make("StopCmd"), BString.make("NoCmd") ));
  
  /**
   * Get the <code>stopCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#stopCommand
   */
  public boolean getStopCommand() { return getBoolean(stopCommand); }
  
  /**
   * Set the <code>stopCommand</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#stopCommand
   */
  public void setStopCommand(boolean v) { setBoolean(stopCommand,v,null); }

////////////////////////////////////////////////////////////////
// Property "enumCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>enumCmd</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#getEnumCmd
   * @see com.bc.CommonLogic.blind.BBlindControl#setEnumCmd
   */
  public static final Property enumCmd = newProperty(Flags.SUMMARY, new BStatusEnum(BCmd.DEFAULT, BStatus.ok),BFacets.makeEnum( BEnumRange.make(BCmd.TYPE) ));
  
  /**
   * Get the <code>enumCmd</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#enumCmd
   */
  public BStatusEnum getEnumCmd() { return (BStatusEnum)get(enumCmd); }
  
  /**
   * Set the <code>enumCmd</code> property.
   * @see com.bc.CommonLogic.blind.BBlindControl#enumCmd
   */
  public void setEnumCmd(BStatusEnum v) { set(enumCmd,v,null); }

////////////////////////////////////////////////////////////////
// Action "setLongOpenInPbDetect"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>setLongOpenInPbDetect</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#setLongOpenInPbDetect()
   */
  public static final Action setLongOpenInPbDetect = newAction(Flags.HIDDEN,null);
  
  /**
   * Invoke the <code>setLongOpenInPbDetect</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#setLongOpenInPbDetect
   */
  public void setLongOpenInPbDetect() { invoke(setLongOpenInPbDetect,null,null); }

////////////////////////////////////////////////////////////////
// Action "setLongCloseInPbDetect"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>setLongCloseInPbDetect</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#setLongCloseInPbDetect()
   */
  public static final Action setLongCloseInPbDetect = newAction(Flags.HIDDEN,null);
  
  /**
   * Invoke the <code>setLongCloseInPbDetect</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#setLongCloseInPbDetect
   */
  public void setLongCloseInPbDetect() { invoke(setLongCloseInPbDetect,null,null); }

////////////////////////////////////////////////////////////////
// Action "interruptTravel"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>interruptTravel</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#interruptTravel()
   */
  public static final Action interruptTravel = newAction(Flags.HIDDEN,null);
  
  /**
   * Invoke the <code>interruptTravel</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#interruptTravel
   */
  public void interruptTravel() { invoke(interruptTravel,null,null); }

////////////////////////////////////////////////////////////////
// Action "openCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>openCmd</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#openCmd()
   */
  public static final Action openCmd = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>openCmd</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#openCmd
   */
  public void openCmd() { invoke(openCmd,null,null); }

////////////////////////////////////////////////////////////////
// Action "closeCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>closeCmd</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#closeCmd()
   */
  public static final Action closeCmd = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>closeCmd</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#closeCmd
   */
  public void closeCmd() { invoke(closeCmd,null,null); }

////////////////////////////////////////////////////////////////
// Action "stopCmd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>stopCmd</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#stopCmd()
   */
  public static final Action stopCmd = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>stopCmd</code> action.
   * @see com.bc.CommonLogic.blind.BBlindControl#stopCmd
   */
  public void stopCmd() { invoke(stopCmd,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BBlindControl.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

public void doSetLongOpenInPbDetect() 
{
//  if(getOpenIn()){
//    setOpenInLongPressDetected(true);
    //System.out.println(" Detect Long press Open " );
//  }
}
public void doSetLongCloseInPbDetect() 
{
//  if(getCloseIn()){
//    setCloseInLongPressDetected(true);
    //System.out.println(" Detect Long press Close " );
//  }
}
public void doInterruptTravel() 
{

    //System.out.println(" Send Stop CMD to Interrupt " );
    doStopCmd();
    if (longPbTicket != null) longPbTicket.cancel();
}

public void doOpenCmd() {    
  //System.out.println(" Call OpenCmd " );
  startInterruptTravel();
  setOpenCommand(true);
  setCloseCommand(false); 
  //getStopCommand().setValue(false); 
  getEnumCmd().setValue(  BCmd.Open ); 

}
public void doCloseCmd() {   
 //System.out.println(" Call CloseCmd " );
  startInterruptTravel();
  setOpenCommand(false);
  setCloseCommand(true); 
  getEnumCmd().setValue(  BCmd.Close ); 
}
public void doStopCmd() { 
  // System.out.println(" Call StopCmd " );
  setOpenCommand(false);
  setCloseCommand(false); 
  setStopCommand(true); 
  setStopCommand(false);  
  getEnumCmd().setValue(  BCmd.Stop );    
}


private void startDetectOpenInLongPress()  
{
  if (longPbTicket != null) longPbTicket.cancel();
  longPbTicket = Clock.schedule(this, BRelTime.make(getLongPressDelay()), setLongOpenInPbDetect, null);
  //System.out.println("startAlarmTimer" );
}

private void startDetectCloseInLongPress()  
{
  if (longPbTicket != null) longPbTicket.cancel();
  longPbTicket = Clock.schedule(this, BRelTime.make(getLongPressDelay()), setLongCloseInPbDetect, null);
  //System.out.println("startAlarmTimer" );
}

private void startInterruptTravel()  
{
  if (interruptTicket != null) interruptTicket.cancel();
  interruptTicket = Clock.schedule(this, BRelTime.make(getTravelPeriod()), interruptTravel, null);
  //System.out.println("startAlarmTimer" );
}


/*
  //Здесь мы ловим изменения в слотах на открытие и закрытие ЕСли НА
*/

public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  

  if( p == openIn && getOpenIn() && getEnumCmd().getEnum().getOrdinal()== BCmd.STOP){ doOpenCmd(); return;  }
  if( p == openIn && getOpenIn() && getEnumCmd().getEnum().getOrdinal()== BCmd.OPEN){ doStopCmd(); return;  }
  if( p == openIn && getOpenIn() && getEnumCmd().getEnum().getOrdinal()== BCmd.CLOSE){ doStopCmd(); return;   }
  
  

  if( p == closeIn && getCloseIn() && getEnumCmd().getEnum().getOrdinal()== BCmd.STOP){ doCloseCmd(); return;  }
  if( p == closeIn && getCloseIn() && getEnumCmd().getEnum().getOrdinal()== BCmd.OPEN){  doStopCmd(); return;  }
  if( p == closeIn && getCloseIn() && getEnumCmd().getEnum().getOrdinal()== BCmd.CLOSE){  doStopCmd(); return; }
  


  
}


// Глобальные переменные
public Clock.Ticket longPbTicket;
public Clock.Ticket interruptTicket;

  
}



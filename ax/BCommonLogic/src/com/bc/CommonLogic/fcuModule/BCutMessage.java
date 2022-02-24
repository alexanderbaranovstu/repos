/* Класс предназначен для снижения нагрузки на сеть KNX у нас всякий раз как поступает новое значение
происходит его отсылка в сеть. мне необходимо либо выставить скажем градус, либо задать периодичность 
повторений.
*/

package com.bc.CommonLogic.fcuModule;  


import javax.baja.sys.*;

/**
 * BOrientation defines a widget's orientation as
 * either horizontal or vertical.
 *
 * @author    Baranov Alex
 * @creation  1 March 21
 * @version   $Revision: 2$ $Date: 3/23/05 11:29:07 AM EST$
 * @since     Baja 1.0
 */
public final class BCutMessage  extends BComponent
{
  /*-
  class BCutMessage  
  {   
    properties  
    {  
      out                 :     BDouble           flags { SUMMARY }     default {[  BDouble.DEFAULT ]}       
      in                  :     BDouble           flags { SUMMARY }     default {[  BDouble.DEFAULT ]}
      band                :     BDouble           flags { SUMMARY }     default {[  BDouble.DEFAULT ]}
      repeatDelay         :     BRelTime          flags { SUMMARY }     default {[  BRelTime.make(1000) ]}                                    

    }   
    actions
    {
      update()
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.fcuModule.BCutMessage(2349303819)1.0$ @*/
/* Generated Wed Nov 17 11:42:43 MSK 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "out"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#getOut
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#setOut
   */
  public static final Property out = newProperty(Flags.SUMMARY, ((BDouble)(BDouble.DEFAULT)).getDouble(),null);
  
  /**
   * Get the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#out
   */
  public double getOut() { return getDouble(out); }
  
  /**
   * Set the <code>out</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#out
   */
  public void setOut(double v) { setDouble(out,v,null); }

////////////////////////////////////////////////////////////////
// Property "in"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#getIn
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#setIn
   */
  public static final Property in = newProperty(Flags.SUMMARY, ((BDouble)(BDouble.DEFAULT)).getDouble(),null);
  
  /**
   * Get the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#in
   */
  public double getIn() { return getDouble(in); }
  
  /**
   * Set the <code>in</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#in
   */
  public void setIn(double v) { setDouble(in,v,null); }

////////////////////////////////////////////////////////////////
// Property "band"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>band</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#getBand
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#setBand
   */
  public static final Property band = newProperty(Flags.SUMMARY, ((BDouble)(BDouble.DEFAULT)).getDouble(),null);
  
  /**
   * Get the <code>band</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#band
   */
  public double getBand() { return getDouble(band); }
  
  /**
   * Set the <code>band</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#band
   */
  public void setBand(double v) { setDouble(band,v,null); }

////////////////////////////////////////////////////////////////
// Property "repeatDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>repeatDelay</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#getRepeatDelay
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#setRepeatDelay
   */
  public static final Property repeatDelay = newProperty(Flags.SUMMARY, BRelTime.make(1000),null);
  
  /**
   * Get the <code>repeatDelay</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#repeatDelay
   */
  public BRelTime getRepeatDelay() { return (BRelTime)get(repeatDelay); }
  
  /**
   * Set the <code>repeatDelay</code> property.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#repeatDelay
   */
  public void setRepeatDelay(BRelTime v) { set(repeatDelay,v,null); }

////////////////////////////////////////////////////////////////
// Action "update"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>update</code> action.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#update()
   */
  public static final Action update = newAction(0,null);
  
  /**
   * Invoke the <code>update</code> action.
   * @see com.bc.CommonLogic.fcuModule.BCutMessage#update
   */
  public void update() { invoke(update,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BCutMessage.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  initTimer();
}
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  if(p == in){
    if((getIn() > getOut()+getBand()) || (getIn() < getOut() - getBand()))setOut(getIn());
  }
  if(p == repeatDelay){initTimer();}
}
private void initTimer()  
{
  if (cutMessageTicket != null) cutMessageTicket.cancel();
  cutMessageTicket = Clock.schedulePeriodically(this, getRepeatDelay(), update, null); 
}
public void doUpdate()  
{
  setOut(getIn());
}
public Clock.Ticket cutMessageTicket;  

}

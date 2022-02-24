package com.bc.fcuModule;  
/*
 * Copyright 2000 Tridium, Inc. All Rights Reserved.
 */


import javax.baja.control.BNumericPoint;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusValue;
import javax.baja.sys.Action;
import javax.baja.sys.BBoolean;
import javax.baja.sys.BFacets;
import javax.baja.sys.BRelTime;
import javax.baja.sys.BValue;
import javax.baja.sys.Clock;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Slot;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.units.*;
import com.tridium.kitControl.enums.BDisableAction;
import com.tridium.kitControl.enums.BLoopAction;

/**
 * The BLoopPoint class implements a simple PID control loop.
 *
 * @author    Dan Giorgis
 * @creation  25 May 01
 * @version   $Revision: 23$ $Date: 5/11/2004 11:30:46 AM$
 * @since     Baja 1.0
 */
public class BPid
  extends BNumericPoint
{ 

  /*-
  
  class BPid
  {
    properties
    {
      loopEnable: BStatusBoolean  
        -- Loop Enable
        default {[ new BStatusBoolean(true) ]}
        
        
      inputFacets: BFacets
        -- These facets are applied against the controlledVariable and setpoint properties.
        default {[  BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1) ]} --{[  BFacets.makeNumeric(UnitDatabase.getUnit("°C"), 1) ]}
        
  
      controlledVariable: BStatusNumeric
        -- Controlled Variable
        default {[ new BStatusNumeric() ]} 
        slotfacets {[ BFacets.makeNumeric() ]}

      setpoint: BStatusNumeric
        -- The target for the process variable, 
        -- meaning the value at the setpoint input.
        default {[ new BStatusNumeric() ]} 
        slotfacets {[ BFacets.makeNumeric() ]}

      executeTime: BRelTime
        -- execution time
        default {[ BRelTime.make(1000) ]}
        slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
        
      actualTime: int
        -- actual time
        flags { operator, readonly, transient }
        default {[ 0 ]}
        
      loopAction: BLoopAction
        -- Selection of loop action as either direct or reverse acting.
        default {[ BLoopAction.reverse ]}
        
      disableAction: BDisableAction
        -- Selection of disable action selects output action when loop is disabled.
        default {[ BDisableAction.zero ]}
        
      tuningFacets: BFacets
        -- These facets are applied against the proportional, integral, and derivative constant properties.
        default {[ BFacets.makeNumeric(3) ]}
  
      proportionalConstant: double
        -- Defines the value of the proportional gain parameter used by the loop algorithm. 
        -- Used to set the overall gain for the loop. 
        -- A starting point for this value is found by: output range / throttling range. 
        default {[ 0.2 ]}

      integralConstant: double
        -- Defines the integral gain parameter, in repeats per minute, 
        -- used by the loop algorithm. Also called reset rate. 
        -- Acts on the magnitude of the setpoint error. 
        -- resets per minute 
        -- FIXX set units
        default {[ 0.1 ]}

      derivativeConstant: double
        -- Defines the derivative gain parameter, in seconds, used by the loop algorithm. 
        -- Acts on the rate of change of the setpoint error. 
        -- FIXX set units
        default {[ 0 ]}
     
      bias: double
        -- Defines the amount of output bias added to the output to correct offset error. 
        -- In other words, the output at setpoint. 
        -- Expressed in the same units of the outputUnits.  
        default {[ 0 ]}

      maximumOutput: double
        -- Defines the maximum output value that the loop algorithm can produce.       
        default {[ 3 ]}
      minimumOutput: double
        -- Defines the minimum output value that the loop algorithm can produce.        
        default {[ -3 ]}

      rampTime: BRelTime
        -- ramp time is the max time that the output will be allowed to go from 
        -- minimumOutput to maximumOutput when the loop is enabled.
        default {[ BRelTime.make(0) ]}
        
    }

    actions
    { 
      resetIntegral()
        -- Any received trigger pulse clears the current integral component of the loop's output calculation. 
        -- If needed, this input can be linked to another object to provide a quick purge of the integral effect. 
        -- Examples include the changeOfStateTrigger output of a related BinaryOutput object (say for a supply fan), 
        -- or a perhaps a Command object. Typically, the later would provide more of a "debug" utility, 
        -- and should not be necessary if the Loop object's configuration properties are correctly defined. 
        -- Also, note that whenever the Loop's input "statusInhibit" is linked, 
        -- an integral reset occurs automatically each time a false-to-true transition is received.  
        
      timerExpired()
        -- Internal action that will fire when the execute timer expires.        
        flags { hidden }
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BPid(356691321)1.0$ @*/
/* Generated Sun Mar 21 08:41:08 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "loopEnable"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code loopEnable} property.
   * Loop Enable
   * @see #getLoopEnable
   * @see #setLoopEnable
   */
  public static final Property loopEnable = newProperty(0, new BStatusBoolean(true), null);
  
  /**
   * Get the {@code loopEnable} property.
   * Loop Enable
   * @see #loopEnable
   */
  public BStatusBoolean getLoopEnable() { return (BStatusBoolean)get(loopEnable); }
  
  /**
   * Set the {@code loopEnable} property.
   * Loop Enable
   * @see #loopEnable
   */
  public void setLoopEnable(BStatusBoolean v) { set(loopEnable, v, null); }

////////////////////////////////////////////////////////////////
// Property "inputFacets"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code inputFacets} property.
   * These facets are applied against the controlledVariable and setpoint properties.
   * @see #getInputFacets
   * @see #setInputFacets
   */
  public static final Property inputFacets = newProperty(0, BFacets.makeNumeric(UnitDatabase.getUnit("celsius"), 1), null);
  
  /**
   * Get the {@code inputFacets} property.
   * These facets are applied against the controlledVariable and setpoint properties.
   * @see #inputFacets
   */
  public BFacets getInputFacets() { return (BFacets)get(inputFacets); }
  
  /**
   * Set the {@code inputFacets} property.
   * These facets are applied against the controlledVariable and setpoint properties.
   * @see #inputFacets
   */
  public void setInputFacets(BFacets v) { set(inputFacets, v, null); }

////////////////////////////////////////////////////////////////
// Property "controlledVariable"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code controlledVariable} property.
   * Controlled Variable
   * @see #getControlledVariable
   * @see #setControlledVariable
   */
  public static final Property controlledVariable = newProperty(0, new BStatusNumeric(), BFacets.makeNumeric());
  
  /**
   * Get the {@code controlledVariable} property.
   * Controlled Variable
   * @see #controlledVariable
   */
  public BStatusNumeric getControlledVariable() { return (BStatusNumeric)get(controlledVariable); }
  
  /**
   * Set the {@code controlledVariable} property.
   * Controlled Variable
   * @see #controlledVariable
   */
  public void setControlledVariable(BStatusNumeric v) { set(controlledVariable, v, null); }

////////////////////////////////////////////////////////////////
// Property "setpoint"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setpoint} property.
   * The target for the process variable,
   * meaning the value at the setpoint input.
   * @see #getSetpoint
   * @see #setSetpoint
   */
  public static final Property setpoint = newProperty(0, new BStatusNumeric(), BFacets.makeNumeric());
  
  /**
   * Get the {@code setpoint} property.
   * The target for the process variable,
   * meaning the value at the setpoint input.
   * @see #setpoint
   */
  public BStatusNumeric getSetpoint() { return (BStatusNumeric)get(setpoint); }
  
  /**
   * Set the {@code setpoint} property.
   * The target for the process variable,
   * meaning the value at the setpoint input.
   * @see #setpoint
   */
  public void setSetpoint(BStatusNumeric v) { set(setpoint, v, null); }

////////////////////////////////////////////////////////////////
// Property "executeTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code executeTime} property.
   * execution time
   * @see #getExecuteTime
   * @see #setExecuteTime
   */
  public static final Property executeTime = newProperty(0, BRelTime.make(1000), BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE));
  
  /**
   * Get the {@code executeTime} property.
   * execution time
   * @see #executeTime
   */
  public BRelTime getExecuteTime() { return (BRelTime)get(executeTime); }
  
  /**
   * Set the {@code executeTime} property.
   * execution time
   * @see #executeTime
   */
  public void setExecuteTime(BRelTime v) { set(executeTime, v, null); }

////////////////////////////////////////////////////////////////
// Property "actualTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code actualTime} property.
   * actual time
   * @see #getActualTime
   * @see #setActualTime
   */
  public static final Property actualTime = newProperty(Flags.OPERATOR|Flags.READONLY|Flags.TRANSIENT, 0, null);
  
  /**
   * Get the {@code actualTime} property.
   * actual time
   * @see #actualTime
   */
  public int getActualTime() { return getInt(actualTime); }
  
  /**
   * Set the {@code actualTime} property.
   * actual time
   * @see #actualTime
   */
  public void setActualTime(int v) { setInt(actualTime, v, null); }

////////////////////////////////////////////////////////////////
// Property "loopAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code loopAction} property.
   * Selection of loop action as either direct or reverse acting.
   * @see #getLoopAction
   * @see #setLoopAction
   */
  public static final Property loopAction = newProperty(0, BLoopAction.reverse, null);
  
  /**
   * Get the {@code loopAction} property.
   * Selection of loop action as either direct or reverse acting.
   * @see #loopAction
   */
  public BLoopAction getLoopAction() { return (BLoopAction)get(loopAction); }
  
  /**
   * Set the {@code loopAction} property.
   * Selection of loop action as either direct or reverse acting.
   * @see #loopAction
   */
  public void setLoopAction(BLoopAction v) { set(loopAction, v, null); }

////////////////////////////////////////////////////////////////
// Property "disableAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code disableAction} property.
   * Selection of disable action selects output action when loop is disabled.
   * @see #getDisableAction
   * @see #setDisableAction
   */
  public static final Property disableAction = newProperty(0, BDisableAction.zero, null);
  
  /**
   * Get the {@code disableAction} property.
   * Selection of disable action selects output action when loop is disabled.
   * @see #disableAction
   */
  public BDisableAction getDisableAction() { return (BDisableAction)get(disableAction); }
  
  /**
   * Set the {@code disableAction} property.
   * Selection of disable action selects output action when loop is disabled.
   * @see #disableAction
   */
  public void setDisableAction(BDisableAction v) { set(disableAction, v, null); }

////////////////////////////////////////////////////////////////
// Property "tuningFacets"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code tuningFacets} property.
   * These facets are applied against the proportional, integral, and derivative constant properties.
   * @see #getTuningFacets
   * @see #setTuningFacets
   */
  public static final Property tuningFacets = newProperty(0, BFacets.makeNumeric(3), null);
  
  /**
   * Get the {@code tuningFacets} property.
   * These facets are applied against the proportional, integral, and derivative constant properties.
   * @see #tuningFacets
   */
  public BFacets getTuningFacets() { return (BFacets)get(tuningFacets); }
  
  /**
   * Set the {@code tuningFacets} property.
   * These facets are applied against the proportional, integral, and derivative constant properties.
   * @see #tuningFacets
   */
  public void setTuningFacets(BFacets v) { set(tuningFacets, v, null); }

////////////////////////////////////////////////////////////////
// Property "proportionalConstant"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code proportionalConstant} property.
   * Defines the value of the proportional gain parameter used by the loop algorithm.
   * Used to set the overall gain for the loop.
   * A starting point for this value is found by: output range / throttling range.
   * @see #getProportionalConstant
   * @see #setProportionalConstant
   */
  public static final Property proportionalConstant = newProperty(0, 0.2, null);
  
  /**
   * Get the {@code proportionalConstant} property.
   * Defines the value of the proportional gain parameter used by the loop algorithm.
   * Used to set the overall gain for the loop.
   * A starting point for this value is found by: output range / throttling range.
   * @see #proportionalConstant
   */
  public double getProportionalConstant() { return getDouble(proportionalConstant); }
  
  /**
   * Set the {@code proportionalConstant} property.
   * Defines the value of the proportional gain parameter used by the loop algorithm.
   * Used to set the overall gain for the loop.
   * A starting point for this value is found by: output range / throttling range.
   * @see #proportionalConstant
   */
  public void setProportionalConstant(double v) { setDouble(proportionalConstant, v, null); }

////////////////////////////////////////////////////////////////
// Property "integralConstant"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code integralConstant} property.
   * Defines the integral gain parameter, in repeats per minute,
   * used by the loop algorithm. Also called reset rate.
   * Acts on the magnitude of the setpoint error.
   * resets per minute
   * FIXX set units
   * @see #getIntegralConstant
   * @see #setIntegralConstant
   */
  public static final Property integralConstant = newProperty(0, 0.1, null);
  
  /**
   * Get the {@code integralConstant} property.
   * Defines the integral gain parameter, in repeats per minute,
   * used by the loop algorithm. Also called reset rate.
   * Acts on the magnitude of the setpoint error.
   * resets per minute
   * FIXX set units
   * @see #integralConstant
   */
  public double getIntegralConstant() { return getDouble(integralConstant); }
  
  /**
   * Set the {@code integralConstant} property.
   * Defines the integral gain parameter, in repeats per minute,
   * used by the loop algorithm. Also called reset rate.
   * Acts on the magnitude of the setpoint error.
   * resets per minute
   * FIXX set units
   * @see #integralConstant
   */
  public void setIntegralConstant(double v) { setDouble(integralConstant, v, null); }

////////////////////////////////////////////////////////////////
// Property "derivativeConstant"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code derivativeConstant} property.
   * Defines the derivative gain parameter, in seconds, used by the loop algorithm.
   * Acts on the rate of change of the setpoint error.
   * FIXX set units
   * @see #getDerivativeConstant
   * @see #setDerivativeConstant
   */
  public static final Property derivativeConstant = newProperty(0, 0, null);
  
  /**
   * Get the {@code derivativeConstant} property.
   * Defines the derivative gain parameter, in seconds, used by the loop algorithm.
   * Acts on the rate of change of the setpoint error.
   * FIXX set units
   * @see #derivativeConstant
   */
  public double getDerivativeConstant() { return getDouble(derivativeConstant); }
  
  /**
   * Set the {@code derivativeConstant} property.
   * Defines the derivative gain parameter, in seconds, used by the loop algorithm.
   * Acts on the rate of change of the setpoint error.
   * FIXX set units
   * @see #derivativeConstant
   */
  public void setDerivativeConstant(double v) { setDouble(derivativeConstant, v, null); }

////////////////////////////////////////////////////////////////
// Property "bias"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code bias} property.
   * Defines the amount of output bias added to the output to correct offset error.
   * In other words, the output at setpoint.
   * Expressed in the same units of the outputUnits.
   * @see #getBias
   * @see #setBias
   */
  public static final Property bias = newProperty(0, 0, null);
  
  /**
   * Get the {@code bias} property.
   * Defines the amount of output bias added to the output to correct offset error.
   * In other words, the output at setpoint.
   * Expressed in the same units of the outputUnits.
   * @see #bias
   */
  public double getBias() { return getDouble(bias); }
  
  /**
   * Set the {@code bias} property.
   * Defines the amount of output bias added to the output to correct offset error.
   * In other words, the output at setpoint.
   * Expressed in the same units of the outputUnits.
   * @see #bias
   */
  public void setBias(double v) { setDouble(bias, v, null); }

////////////////////////////////////////////////////////////////
// Property "maximumOutput"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code maximumOutput} property.
   * Defines the maximum output value that the loop algorithm can produce.
   * @see #getMaximumOutput
   * @see #setMaximumOutput
   */
  public static final Property maximumOutput = newProperty(0, 3, null);
  
  /**
   * Get the {@code maximumOutput} property.
   * Defines the maximum output value that the loop algorithm can produce.
   * @see #maximumOutput
   */
  public double getMaximumOutput() { return getDouble(maximumOutput); }
  
  /**
   * Set the {@code maximumOutput} property.
   * Defines the maximum output value that the loop algorithm can produce.
   * @see #maximumOutput
   */
  public void setMaximumOutput(double v) { setDouble(maximumOutput, v, null); }

////////////////////////////////////////////////////////////////
// Property "minimumOutput"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code minimumOutput} property.
   * Defines the minimum output value that the loop algorithm can produce.
   * @see #getMinimumOutput
   * @see #setMinimumOutput
   */
  public static final Property minimumOutput = newProperty(0, -3, null);
  
  /**
   * Get the {@code minimumOutput} property.
   * Defines the minimum output value that the loop algorithm can produce.
   * @see #minimumOutput
   */
  public double getMinimumOutput() { return getDouble(minimumOutput); }
  
  /**
   * Set the {@code minimumOutput} property.
   * Defines the minimum output value that the loop algorithm can produce.
   * @see #minimumOutput
   */
  public void setMinimumOutput(double v) { setDouble(minimumOutput, v, null); }

////////////////////////////////////////////////////////////////
// Property "rampTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code rampTime} property.
   * ramp time is the max time that the output will be allowed to go from
   * minimumOutput to maximumOutput when the loop is enabled.
   * @see #getRampTime
   * @see #setRampTime
   */
  public static final Property rampTime = newProperty(0, BRelTime.make(0), null);
  
  /**
   * Get the {@code rampTime} property.
   * ramp time is the max time that the output will be allowed to go from
   * minimumOutput to maximumOutput when the loop is enabled.
   * @see #rampTime
   */
  public BRelTime getRampTime() { return (BRelTime)get(rampTime); }
  
  /**
   * Set the {@code rampTime} property.
   * ramp time is the max time that the output will be allowed to go from
   * minimumOutput to maximumOutput when the loop is enabled.
   * @see #rampTime
   */
  public void setRampTime(BRelTime v) { set(rampTime, v, null); }

////////////////////////////////////////////////////////////////
// Action "resetIntegral"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code resetIntegral} action.
   * Any received trigger pulse clears the current integral component of the loop's output calculation.
   * If needed, this input can be linked to another object to provide a quick purge of the integral effect.
   * Examples include the changeOfStateTrigger output of a related BinaryOutput object (say for a supply fan),
   * or a perhaps a Command object. Typically, the later would provide more of a "debug" utility,
   * and should not be necessary if the Loop object's configuration properties are correctly defined.
   * Also, note that whenever the Loop's input "statusInhibit" is linked,
   * an integral reset occurs automatically each time a false-to-true transition is received.
   * @see #resetIntegral()
   */
  public static final Action resetIntegral = newAction(0, null);
  
  /**
   * Invoke the {@code resetIntegral} action.
   * Any received trigger pulse clears the current integral component of the loop's output calculation.
   * If needed, this input can be linked to another object to provide a quick purge of the integral effect.
   * Examples include the changeOfStateTrigger output of a related BinaryOutput object (say for a supply fan),
   * or a perhaps a Command object. Typically, the later would provide more of a "debug" utility,
   * and should not be necessary if the Loop object's configuration properties are correctly defined.
   * Also, note that whenever the Loop's input "statusInhibit" is linked,
   * an integral reset occurs automatically each time a false-to-true transition is received.
   * @see #resetIntegral
   */
  public void resetIntegral() { invoke(resetIntegral, null, null); }

////////////////////////////////////////////////////////////////
// Action "timerExpired"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code timerExpired} action.
   * Internal action that will fire when the execute timer expires.
   * @see #timerExpired()
   */
  public static final Action timerExpired = newAction(Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code timerExpired} action.
   * Internal action that will fire when the execute timer expires.
   * @see #timerExpired
   */
  public void timerExpired() { invoke(timerExpired, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BPid.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////
    
  /**
   * Is the Integral Term set
   */
  public boolean isIntegral()
  {
    double kI = getIntegralConstant();
    return !( Double.isNaN(kI) || kI == 0.0 );
  }


  public BFacets getSlotFacets(Slot slot)
  {
    if (slot.equals(controlledVariable  )  ||
        slot.equals(setpoint            )    ) return getInputFacets();

    if (slot.equals(proportionalConstant) ||
        slot.equals(integralConstant    ) ||
        slot.equals(derivativeConstant  )    ) return getTuningFacets();

    return super.getSlotFacets(slot);
  }
  
//////////////////////////////////////////////////////////////////
//  Action
//////////////////////////////////////////////////////////////////

  /**********************************************
  * Handle triggers.
  **********************************************/
  public void doResetIntegral()
  {
    clearIntegralTerms();
  }

  /**
   * Callback for timer expired.
   */
  public void doTimerExpired()
  {

    if(!getLoopEnable().getBoolean())
    {
      if (ticket != null) ticket.cancel();
      lastExecuteTime = 0;
    }
    //  execute point when timer expires
    calculatePoint();
  }

////////////////////////////////////////////////////////////////
//  Control Point overrides
////////////////////////////////////////////////////////////////

  public void started()           
    throws Exception
  {                 
    super.started();
    
    //  Start the timer      
    initTimer();
    kPortionalCurrent = getProportionalConstant();
    kIntegralCurrent  = getIntegralConstant();
    kPkIconst = kPortionalCurrent * kIntegralCurrent / 60;
    rampConst =  Math.abs( this.getMaximumOutput() - this.getMinimumOutput() );
    rampStartTicks = Clock.ticks();
    rampEndTicks = rampStartTicks + getRampTime().getMillis();

  }          
  
  private void initTimer()
  {
    if (ticket != null) ticket.cancel();
    ticket = Clock.schedulePeriodically(this, getExecuteTime(), timerExpired, null);
  }
  
  // no longer calculates loop on input changes.  Changed to a time based calculation.      
  public void onExecute(BStatusValue out, Context cx)
  {
    
    if(!isRunning())
      return; // should never get here, but return if we do.
//    System.out.println("loop.onExecute: " + pidOutput);
    ((BStatusNumeric)out).setStatus(pidOutput.getStatus());
    ((BStatusNumeric)out).setValue(pidOutput.getValue());
  }
  
  // called from doTimerExpired()
  public void calculatePoint()
  {
    debug = false;

    //NCCB-25919 BLoopPoint creates excessive amount of java.lang.NullPointerExceptions
    BValue debugValue = get("debug");
    if (debugValue instanceof BBoolean)
    {
      debug = ((BBoolean)debugValue).getBoolean();
    }

    //
    //  Read the status inhibit input value.  If it is not linked,
    //  (readInput returns false) then alarms are never inhibited.
    //  Keep track of current status inhibit even if we are NOT 
    //  linked to handle case where link is removed.
    boolean currentStatusInhibit;
    loopEnabled = currentStatusInhibit = getLoopEnable().getBoolean();

    /* NCCB-8951: LoopPoint becomes disabled
    * this eliminates a race codition between the changed() method and the clock ticket that
    * is invoking caclulatePoint().
    * should never set the out property's disable status flag anyway.*/
//    pidOutput.setStatusDisabled(!loopEnabled);

    //System.out.println("loopEnable is linked and loop enable = " + loopEnabled);
    //if (currentStatusInhibit && !lastStatusInhibit)
    //  clearIntegralTerms();
            
    lastStatusInhibit = currentStatusInhibit;

    double kProportional = getProportionalConstant();     
    double kIntegral     = getIntegralConstant();
    double kDerivative   = getDerivativeConstant();
    double maxOutput     = getMaximumOutput();
    double minOutput     = getMinimumOutput();
    long  now            = Clock.ticks();
    double setPt         = getSetpoint().getValue();
    double controlVar    = getControlledVariable().getValue();
    boolean fault        = false;
    BDisableAction disableAction = getDisableAction();
    rampConst =  Math.abs( this.getMaximumOutput() - this.getMinimumOutput() );
    
    if( Double.isNaN(setPt) || Double.isNaN(controlVar) )
    {
      pidOutput.setStatusFault(true);
      fault = true;
    }
    else
      pidOutput.setStatusFault(false);
    

    if (lastExecuteTime == 0)
      lastExecuteTime = now;
    
    long  delta         = now - lastExecuteTime;
    setActualTime( (int)delta );

    double deltaSecs = (double)delta / 1000.0;

    //  If the loop is not enabled or in fault, don't do anything
    if(!loopEnabled )
    {
      double outValue = Double.NaN;
      if( disableAction == BDisableAction.zero)
        outValue = 0;
      else if( disableAction == BDisableAction.maxValue)
        outValue = this.getMaximumOutput();
      else if( disableAction == BDisableAction.minValue)
        outValue = this.getMinimumOutput();
      if(!Double.isNaN(outValue))
      {
        pidOutput.setValue(outValue);
        if (getLoopAction() == BLoopAction.direct)
          errorSum = -(outValue/kPkIconst);
        else
          errorSum = (outValue/kPkIconst);
      }
      lastExecuteTime = 0;
      return;
    }
    else if(fault)
      return;
    
    //  Calculate the current error
    double error = getSetpoint().getValue() - getControlledVariable().getValue();

    //  Accumulate the error for integral control
    if (kIntegral != 0)
    {
      double iError = deltaSecs * error;
      errorSum += iError;

      //Constrain the error sum to prevent integral windup
      kPkIconst = kProportional * kIntegral / 60;
      if (getLoopAction() == BLoopAction.direct)
      {
         if (-errorSum > maxOutput/kPkIconst)
          errorSum = -(maxOutput/kPkIconst);
        else if (-errorSum < minOutput/kPkIconst)
          errorSum = -(minOutput/kPkIconst);
      }
      else
      {
        if (errorSum > maxOutput/kPkIconst)
          errorSum = (maxOutput/kPkIconst);
        else if (errorSum < minOutput/kPkIconst)
          errorSum = (minOutput/kPkIconst);
      }
    }
    if(Double.isNaN(errorSum) || Double.isInfinite(errorSum))
      errorSum = 0.0;


    //  Calculate the proportional gain
    double proportionalGain = error * kProportional; 

    //  Calculate the integral gain
    double integralGain= 0;

    //  All gain values are calculated in seconds.  Convert integral
    //  term (resets per minute) to resets per second
    integralGain = kProportional * kIntegral * errorSum / 60;
    
            
    //  Calculate the derivative gain
    //double derivativeGain = kProportional * kDerivative * (error - lastError) * (deltaSecs);
    double derivativeGain = kProportional * kDerivative * (error - lastError) / (deltaSecs);

    //  Store the last error for derivative gain    
    lastError = error;
    
    //  Calculate the overall gain
    double pv = proportionalGain + integralGain + derivativeGain;
    
    // if pv NaN don't do anything else
    if(Double.isNaN(pv))
      return;

    //  Apply action
    if (getLoopAction() == BLoopAction.direct)
      pv = - pv;

    //  Add bias if not PI
    if(!isIntegral())
      pv += getBias();

    // Constrain the overall gain
    // NCCB-15881: (E333968) Moved this code lower so that it will strickly enforce the min & max output values.
//    if (pv > maxOutput)
//      pv = maxOutput;
//    else if (pv < minOutput)
//      pv = minOutput;


    if (debug)
      System.out.println("pGain: " + proportionalGain + " iGain: " + integralGain + " dGain: " + derivativeGain + 
                         "\nerrorSum: " + errorSum + " error: " + error + " pv: " + pv + " deltaSecs: " + deltaSecs + " out: " + getOut().getValue());   

    // process ramp startup process
    if( now < rampEndTicks )
    {
      double maxChange = rampConst * (double)(delta) / (double)(getRampTime().getMillis()) ;
      if( getOut().getValue() > pv ) // ramping down
      {
        double minRampOut = getOut().getValue() - maxChange;
        if( pv < minRampOut )
        {
          errorSum = errorSum * minRampOut / pv;
          pv = minRampOut;
        }
      }
      else
      {
        double maxRampOut = getOut().getValue() + maxChange;
        if( pv > maxRampOut )
        {
          errorSum = errorSum * maxRampOut / pv;
          pv = maxRampOut;
        }
      }
    }
    // Constrain the overall gain
    //
    // NCCB-15881: (E333968) enforce the min & max output values.
    if (pv > maxOutput)
      pv = maxOutput;
    else if (pv < minOutput)
      pv = minOutput;

    pidOutput.setValue(pv);
    lastExecuteTime = now;
    //cause extensions to run and output to be updated.
    doExecute();
  }

//////////////////////////////////////////////////////////////////
//  Utility
//////////////////////////////////////////////////////////////////
  
  private void clearIntegralTerms()
  {
    lastExecuteTime = 0;
    if (getLoopAction() == BLoopAction.direct)
    {
      errorSum = -(getMaximumOutput()/kPkIconst);
    }
    else
    {
      errorSum = (getMinimumOutput()/kPkIconst);
    }
    if(Double.isNaN(errorSum))
      errorSum = 0.0d;
    if (debug)
      System.out.println("Clearing integral term...");      
  }

  /**
   * Property changed.
   */
  
  public void changed(Property p, Context cx)
  {
    if(!isRunning())
      return;
    super.changed(p,cx);
    
    if( p.equals(executeTime))
    {
      // clamp execution time max and min values.
      if(getExecuteTime().getMillis() < LOOP_MIN_EXECUTE_TIME)
        setExecuteTime(BRelTime.make(LOOP_MIN_EXECUTE_TIME));
      else if(getExecuteTime().getMillis() > LOOP_MAX_EXECUTE_TIME)
        setExecuteTime(BRelTime.make(LOOP_MAX_EXECUTE_TIME));
      initTimer();
    }
    else if( p.equals(proportionalConstant) )
    {
      double kPnew = this.getProportionalConstant();
      if(kPnew !=0)
        errorSum = errorSum*kPortionalCurrent/kPnew;
      kPortionalCurrent = kPnew;
    }
    else if( p.equals(integralConstant) )
    {
      double kInew = this.getIntegralConstant();
      if(kInew !=0)
        errorSum = errorSum*kIntegralCurrent/kInew;
      kIntegralCurrent = kInew;
    }
    else if(p.equals(rampTime))
    {
      rampConst =  Math.abs( this.getMaximumOutput() - this.getMinimumOutput() );
      rampStartTicks = Clock.ticks();
      rampEndTicks = rampStartTicks + getRampTime().getMillis();
    }
    else if( p.equals(loopEnable) )
    {
      if(getLoopEnable().getBoolean())
      {
        rampConst =  Math.abs( this.getMaximumOutput() - this.getMinimumOutput() );
        rampStartTicks = Clock.ticks();
        rampEndTicks = rampStartTicks + getRampTime().getMillis();
        calculatePoint();
        if(isRunning())
        {
          initTimer();
          //ticket.cancel();
          //ticket = Clock.schedule(this, getExecuteTime(), timerExpired, null);
        }
      }
      else
      {
        if (ticket != null) ticket.cancel();

        BDisableAction disableAction = getDisableAction();
        double outValue = Double.NaN;
        if( disableAction == BDisableAction.zero)
          outValue = 0;
        else if( disableAction == BDisableAction.maxValue)
          outValue = this.getMaximumOutput();
        else if( disableAction == BDisableAction.minValue)
          outValue = this.getMinimumOutput();
        if(!Double.isNaN(outValue))
        {
          pidOutput.setValue(outValue);
          if (getLoopAction() == BLoopAction.direct)
            errorSum = -(outValue/kPkIconst);
          else
            errorSum = (outValue/kPkIconst);
        }
        lastExecuteTime = 0;
        if (debug)
        {
          System.out.println("loop disabled:  errorSum " + errorSum );   
          System.out.println("loop disabled:  outValue " + outValue );   
          System.out.println("loop disabled:  kPkIconst " + kPkIconst );
        }
      }

    }
  }
  

//////////////////////////////////////////////////////////////////
//  Attributes
//////////////////////////////////////////////////////////////////

  private Clock.Ticket ticket;
  private double lastUpdateValue = Double.NaN;
  private boolean loopEnabled;
  private boolean lastStatusInhibit = false;
  private double kPkIconst;
  private double errorSum = 0;
  private double lastError = 0;
  private boolean debug = false;
  private long  lastExecuteTime;  
  private double kPortionalCurrent;  
  private double kIntegralCurrent;  
  private long  rampStartTicks;
  private long  rampEndTicks;
  private double rampConst;
  private BStatusNumeric pidOutput = new BStatusNumeric();
  
//////////////////////////////////////////////////////////////////
//  Constants
//////////////////////////////////////////////////////////////////  
  public static long LOOP_MAX_EXECUTE_TIME     = 60000;
  public static long LOOP_MIN_EXECUTE_TIME     = 100;
  public static long LOOP_DEFAULT_EXECUTE_TIME = 500;
} 

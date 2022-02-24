/*
Модуль BcAirCurtain строится вокруг машины состояний update() - метода который меняет слот mode
вызов метода update() производится периодически и по факту изменения основных управляющих переменных
Переключатель режимов работы имеет 4 положения 0-1-2-3-авто. Схемотехнически реализовано так что
все они через резистивные цепочки заведены на один аналоговый вход.
Учитывая что резисторы имеют разбаланс, настройка порогов настраивается в модуле

*/
package com.bc.BcAirCurtain;  

import java.util.*;  

import java.io.*;
import javax.baja.data.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

//import javax.baja.schedule.*;
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
public class BAirCurtain extends BStringWritable   
{ 
  
  /*-  
  class BAirCurtain  
  {  
    properties  
    {  
      airCurtain                   :     BPxView                                     default {[ new BPxView(BOrd.make("module://BcAirCurtain/com/bc/graphics/AirCurtainView.px") ) ]}
      --Owerride BStringWritable and make it hidden
      in1                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in2                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in3                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in4                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in5                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in6                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in7                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in8                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in9                   :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in10                  :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in11                  :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in12                  :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in13                  :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in14                  :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      in15                  :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}      
      in16                  :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      fallback              :     BStatusString         flags { hidden }      default {[ new BStatusString("", BStatus.nullStatus) ]}
      overrideExpiration    :     BAbsTime              flags { hidden, operator, readonly }        default {[ BAbsTime.NULL ]}
      --Curtain properties  

      sourceName            :     BFormat               flags {  }     default {[ BFormat.make("%time()% %parent.parent.displayName% Mode=%mode.value%") ]}
      homeOrd               :     BOrd                  flags {  }     default {[ BOrd.make("station:|slot:/Drivers") ]}
      mode                  :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BAirCurtainState.make(0), BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BAirCurtainState.TYPE) ) ]}
      switchPos             :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BAirCurtainSw.make(0), BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BAirCurtainSw.TYPE) ) ]}
      switchRaw             :     int                   flags { SUMMARY }     default {[ 0 ]}
      step0Value            :     int                   flags {  }     default {[ 0 ]}
      step1Value            :     int                   flags {  }     default {[ 848 ]}
      step2Value            :     int                   flags {  }     default {[ 200 ]}
      step3Value            :     int                   flags {  }     default {[ 300 ]}
      stepAutoValue         :     int                   flags {  }     default {[ 400 ]}
      stepBand              :     int                   flags { hidden }     default {[ 10 ]}

      sp                    :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}
      --deadBand              :     BStatusNumeric        flags {  }     default {[ new BStatusNumeric(0.5, BStatus.ok) ]}
      speedRequest          :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}
      speedInt              :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}        slotfacets{[ BFacets.makeNumeric(null,0) ]}
      Speed1FB              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      Speed2FB              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}  
      Speed3FB              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      Speed1                :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      Speed2                :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}  
      Speed3                :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      Heat1FB               :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      Heat2FB               :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      Heat1                 :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      Heat2                 :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ) ]}
      fanAlarm              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ) ]}
      unitEnable              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("Enaible"), BString.make("Disable") ) ]}


      executeTime           :     BRelTime              flags {  }     default {[ BRelTime.make(15000) ]}                                 slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
      PID                   :     BPid                  flags {  }     default {[ new BPid() ]} 
      alarmDelay            :     BRelTime              flags {  }     default {[ BRelTime.make(30000) ]}                                 slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
      communicationError    :     BStatusBoolean        flags {  }     default {[ new BStatusBoolean(false, BStatus.ok) ]}            slotfacets {[ BFacets.makeBoolean(  BString.make("CommunicationAlarm"), BString.make("CommunicationNormal") ) ]}

    }   
    actions
    {
    
      emergencyOverride(arg: BString)                   flags { hidden }      default {[ BString.make("") ]}
      emergencyAuto()                                   flags { hidden }      
      override(arg: BStringOverride)                    flags { operator, hidden }  default {[ new BStringOverride() ]}
      auto()                                            flags { operator, hidden }
      set(arg: BString)                                 flags { operator, hidden }  default {[ BString.DEFAULT ]}
      timerExpired()                                    flags { hidden }
      setAlarm()                                        flags { SUMMARY }
      resetAlarm()                                      flags { SUMMARY }
      setCommunicationAlarm()                                        flags { SUMMARY }
      resetCommunicationAlarm()                                      flags { SUMMARY }
    }
  }  
  -*/
















/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.BcAirCurtain.BAirCurtain(1219082008)1.0$ @*/
/* Generated Wed Oct 20 07:09:59 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "airCurtain"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code airCurtain} property.
   * @see #getAirCurtain
   * @see #setAirCurtain
   */
  public static final Property airCurtain = newProperty(0, new BPxView(BOrd.make("module://BcAirCurtain/com/bc/graphics/AirCurtainView.px") ), null);
  
  /**
   * Get the {@code airCurtain} property.
   * @see #airCurtain
   */
  public BPxView getAirCurtain() { return (BPxView)get(airCurtain); }
  
  /**
   * Set the {@code airCurtain} property.
   * @see #airCurtain
   */
  public void setAirCurtain(BPxView v) { set(airCurtain, v, null); }

////////////////////////////////////////////////////////////////
// Property "in1"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in1} property.
   * @see #getIn1
   * @see #setIn1
   */
  public static final Property in1 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in1} property.
   * @see #in1
   */
  public BStatusString getIn1() { return (BStatusString)get(in1); }
  
  /**
   * Set the {@code in1} property.
   * @see #in1
   */
  public void setIn1(BStatusString v) { set(in1, v, null); }

////////////////////////////////////////////////////////////////
// Property "in2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in2} property.
   * @see #getIn2
   * @see #setIn2
   */
  public static final Property in2 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in2} property.
   * @see #in2
   */
  public BStatusString getIn2() { return (BStatusString)get(in2); }
  
  /**
   * Set the {@code in2} property.
   * @see #in2
   */
  public void setIn2(BStatusString v) { set(in2, v, null); }

////////////////////////////////////////////////////////////////
// Property "in3"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in3} property.
   * @see #getIn3
   * @see #setIn3
   */
  public static final Property in3 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in3} property.
   * @see #in3
   */
  public BStatusString getIn3() { return (BStatusString)get(in3); }
  
  /**
   * Set the {@code in3} property.
   * @see #in3
   */
  public void setIn3(BStatusString v) { set(in3, v, null); }

////////////////////////////////////////////////////////////////
// Property "in4"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in4} property.
   * @see #getIn4
   * @see #setIn4
   */
  public static final Property in4 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in4} property.
   * @see #in4
   */
  public BStatusString getIn4() { return (BStatusString)get(in4); }
  
  /**
   * Set the {@code in4} property.
   * @see #in4
   */
  public void setIn4(BStatusString v) { set(in4, v, null); }

////////////////////////////////////////////////////////////////
// Property "in5"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in5} property.
   * @see #getIn5
   * @see #setIn5
   */
  public static final Property in5 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in5} property.
   * @see #in5
   */
  public BStatusString getIn5() { return (BStatusString)get(in5); }
  
  /**
   * Set the {@code in5} property.
   * @see #in5
   */
  public void setIn5(BStatusString v) { set(in5, v, null); }

////////////////////////////////////////////////////////////////
// Property "in6"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in6} property.
   * @see #getIn6
   * @see #setIn6
   */
  public static final Property in6 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in6} property.
   * @see #in6
   */
  public BStatusString getIn6() { return (BStatusString)get(in6); }
  
  /**
   * Set the {@code in6} property.
   * @see #in6
   */
  public void setIn6(BStatusString v) { set(in6, v, null); }

////////////////////////////////////////////////////////////////
// Property "in7"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in7} property.
   * @see #getIn7
   * @see #setIn7
   */
  public static final Property in7 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in7} property.
   * @see #in7
   */
  public BStatusString getIn7() { return (BStatusString)get(in7); }
  
  /**
   * Set the {@code in7} property.
   * @see #in7
   */
  public void setIn7(BStatusString v) { set(in7, v, null); }

////////////////////////////////////////////////////////////////
// Property "in8"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in8} property.
   * @see #getIn8
   * @see #setIn8
   */
  public static final Property in8 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in8} property.
   * @see #in8
   */
  public BStatusString getIn8() { return (BStatusString)get(in8); }
  
  /**
   * Set the {@code in8} property.
   * @see #in8
   */
  public void setIn8(BStatusString v) { set(in8, v, null); }

////////////////////////////////////////////////////////////////
// Property "in9"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in9} property.
   * @see #getIn9
   * @see #setIn9
   */
  public static final Property in9 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in9} property.
   * @see #in9
   */
  public BStatusString getIn9() { return (BStatusString)get(in9); }
  
  /**
   * Set the {@code in9} property.
   * @see #in9
   */
  public void setIn9(BStatusString v) { set(in9, v, null); }

////////////////////////////////////////////////////////////////
// Property "in10"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in10} property.
   * @see #getIn10
   * @see #setIn10
   */
  public static final Property in10 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in10} property.
   * @see #in10
   */
  public BStatusString getIn10() { return (BStatusString)get(in10); }
  
  /**
   * Set the {@code in10} property.
   * @see #in10
   */
  public void setIn10(BStatusString v) { set(in10, v, null); }

////////////////////////////////////////////////////////////////
// Property "in11"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in11} property.
   * @see #getIn11
   * @see #setIn11
   */
  public static final Property in11 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in11} property.
   * @see #in11
   */
  public BStatusString getIn11() { return (BStatusString)get(in11); }
  
  /**
   * Set the {@code in11} property.
   * @see #in11
   */
  public void setIn11(BStatusString v) { set(in11, v, null); }

////////////////////////////////////////////////////////////////
// Property "in12"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in12} property.
   * @see #getIn12
   * @see #setIn12
   */
  public static final Property in12 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in12} property.
   * @see #in12
   */
  public BStatusString getIn12() { return (BStatusString)get(in12); }
  
  /**
   * Set the {@code in12} property.
   * @see #in12
   */
  public void setIn12(BStatusString v) { set(in12, v, null); }

////////////////////////////////////////////////////////////////
// Property "in13"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in13} property.
   * @see #getIn13
   * @see #setIn13
   */
  public static final Property in13 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in13} property.
   * @see #in13
   */
  public BStatusString getIn13() { return (BStatusString)get(in13); }
  
  /**
   * Set the {@code in13} property.
   * @see #in13
   */
  public void setIn13(BStatusString v) { set(in13, v, null); }

////////////////////////////////////////////////////////////////
// Property "in14"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in14} property.
   * @see #getIn14
   * @see #setIn14
   */
  public static final Property in14 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in14} property.
   * @see #in14
   */
  public BStatusString getIn14() { return (BStatusString)get(in14); }
  
  /**
   * Set the {@code in14} property.
   * @see #in14
   */
  public void setIn14(BStatusString v) { set(in14, v, null); }

////////////////////////////////////////////////////////////////
// Property "in15"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in15} property.
   * @see #getIn15
   * @see #setIn15
   */
  public static final Property in15 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in15} property.
   * @see #in15
   */
  public BStatusString getIn15() { return (BStatusString)get(in15); }
  
  /**
   * Set the {@code in15} property.
   * @see #in15
   */
  public void setIn15(BStatusString v) { set(in15, v, null); }

////////////////////////////////////////////////////////////////
// Property "in16"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code in16} property.
   * @see #getIn16
   * @see #setIn16
   */
  public static final Property in16 = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code in16} property.
   * @see #in16
   */
  public BStatusString getIn16() { return (BStatusString)get(in16); }
  
  /**
   * Set the {@code in16} property.
   * @see #in16
   */
  public void setIn16(BStatusString v) { set(in16, v, null); }

////////////////////////////////////////////////////////////////
// Property "fallback"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fallback} property.
   * @see #getFallback
   * @see #setFallback
   */
  public static final Property fallback = newProperty(Flags.HIDDEN, new BStatusString("", BStatus.nullStatus), null);
  
  /**
   * Get the {@code fallback} property.
   * @see #fallback
   */
  public BStatusString getFallback() { return (BStatusString)get(fallback); }
  
  /**
   * Set the {@code fallback} property.
   * @see #fallback
   */
  public void setFallback(BStatusString v) { set(fallback, v, null); }

////////////////////////////////////////////////////////////////
// Property "overrideExpiration"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code overrideExpiration} property.
   * @see #getOverrideExpiration
   * @see #setOverrideExpiration
   */
  public static final Property overrideExpiration = newProperty(Flags.HIDDEN|Flags.OPERATOR|Flags.READONLY, BAbsTime.NULL, null);
  
  /**
   * Get the {@code overrideExpiration} property.
   * @see #overrideExpiration
   */
  public BAbsTime getOverrideExpiration() { return (BAbsTime)get(overrideExpiration); }
  
  /**
   * Set the {@code overrideExpiration} property.
   * @see #overrideExpiration
   */
  public void setOverrideExpiration(BAbsTime v) { set(overrideExpiration, v, null); }

////////////////////////////////////////////////////////////////
// Property "sourceName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code sourceName} property.
   * @see #getSourceName
   * @see #setSourceName
   */
  public static final Property sourceName = newProperty(0, BFormat.make("%time()% %parent.parent.displayName% Mode=%mode.value%"), null);
  
  /**
   * Get the {@code sourceName} property.
   * @see #sourceName
   */
  public BFormat getSourceName() { return (BFormat)get(sourceName); }
  
  /**
   * Set the {@code sourceName} property.
   * @see #sourceName
   */
  public void setSourceName(BFormat v) { set(sourceName, v, null); }

////////////////////////////////////////////////////////////////
// Property "homeOrd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code homeOrd} property.
   * @see #getHomeOrd
   * @see #setHomeOrd
   */
  public static final Property homeOrd = newProperty(0, BOrd.make("station:|slot:/Drivers"), null);
  
  /**
   * Get the {@code homeOrd} property.
   * @see #homeOrd
   */
  public BOrd getHomeOrd() { return (BOrd)get(homeOrd); }
  
  /**
   * Set the {@code homeOrd} property.
   * @see #homeOrd
   */
  public void setHomeOrd(BOrd v) { set(homeOrd, v, null); }

////////////////////////////////////////////////////////////////
// Property "mode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code mode} property.
   * @see #getMode
   * @see #setMode
   */
  public static final Property mode = newProperty(Flags.SUMMARY, new BStatusEnum(BAirCurtainState.make(0), BStatus.ok), BFacets.makeEnum( BEnumRange.make(BAirCurtainState.TYPE) ));
  
  /**
   * Get the {@code mode} property.
   * @see #mode
   */
  public BStatusEnum getMode() { return (BStatusEnum)get(mode); }
  
  /**
   * Set the {@code mode} property.
   * @see #mode
   */
  public void setMode(BStatusEnum v) { set(mode, v, null); }

////////////////////////////////////////////////////////////////
// Property "switchPos"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code switchPos} property.
   * @see #getSwitchPos
   * @see #setSwitchPos
   */
  public static final Property switchPos = newProperty(Flags.SUMMARY, new BStatusEnum(BAirCurtainSw.make(0), BStatus.ok), BFacets.makeEnum( BEnumRange.make(BAirCurtainSw.TYPE) ));
  
  /**
   * Get the {@code switchPos} property.
   * @see #switchPos
   */
  public BStatusEnum getSwitchPos() { return (BStatusEnum)get(switchPos); }
  
  /**
   * Set the {@code switchPos} property.
   * @see #switchPos
   */
  public void setSwitchPos(BStatusEnum v) { set(switchPos, v, null); }

////////////////////////////////////////////////////////////////
// Property "switchRaw"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code switchRaw} property.
   * @see #getSwitchRaw
   * @see #setSwitchRaw
   */
  public static final Property switchRaw = newProperty(Flags.SUMMARY, 0, null);
  
  /**
   * Get the {@code switchRaw} property.
   * @see #switchRaw
   */
  public int getSwitchRaw() { return getInt(switchRaw); }
  
  /**
   * Set the {@code switchRaw} property.
   * @see #switchRaw
   */
  public void setSwitchRaw(int v) { setInt(switchRaw, v, null); }

////////////////////////////////////////////////////////////////
// Property "step0Value"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code step0Value} property.
   * @see #getStep0Value
   * @see #setStep0Value
   */
  public static final Property step0Value = newProperty(0, 0, null);
  
  /**
   * Get the {@code step0Value} property.
   * @see #step0Value
   */
  public int getStep0Value() { return getInt(step0Value); }
  
  /**
   * Set the {@code step0Value} property.
   * @see #step0Value
   */
  public void setStep0Value(int v) { setInt(step0Value, v, null); }

////////////////////////////////////////////////////////////////
// Property "step1Value"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code step1Value} property.
   * @see #getStep1Value
   * @see #setStep1Value
   */
  public static final Property step1Value = newProperty(0, 848, null);
  
  /**
   * Get the {@code step1Value} property.
   * @see #step1Value
   */
  public int getStep1Value() { return getInt(step1Value); }
  
  /**
   * Set the {@code step1Value} property.
   * @see #step1Value
   */
  public void setStep1Value(int v) { setInt(step1Value, v, null); }

////////////////////////////////////////////////////////////////
// Property "step2Value"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code step2Value} property.
   * @see #getStep2Value
   * @see #setStep2Value
   */
  public static final Property step2Value = newProperty(0, 200, null);
  
  /**
   * Get the {@code step2Value} property.
   * @see #step2Value
   */
  public int getStep2Value() { return getInt(step2Value); }
  
  /**
   * Set the {@code step2Value} property.
   * @see #step2Value
   */
  public void setStep2Value(int v) { setInt(step2Value, v, null); }

////////////////////////////////////////////////////////////////
// Property "step3Value"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code step3Value} property.
   * @see #getStep3Value
   * @see #setStep3Value
   */
  public static final Property step3Value = newProperty(0, 300, null);
  
  /**
   * Get the {@code step3Value} property.
   * @see #step3Value
   */
  public int getStep3Value() { return getInt(step3Value); }
  
  /**
   * Set the {@code step3Value} property.
   * @see #step3Value
   */
  public void setStep3Value(int v) { setInt(step3Value, v, null); }

////////////////////////////////////////////////////////////////
// Property "stepAutoValue"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code stepAutoValue} property.
   * @see #getStepAutoValue
   * @see #setStepAutoValue
   */
  public static final Property stepAutoValue = newProperty(0, 400, null);
  
  /**
   * Get the {@code stepAutoValue} property.
   * @see #stepAutoValue
   */
  public int getStepAutoValue() { return getInt(stepAutoValue); }
  
  /**
   * Set the {@code stepAutoValue} property.
   * @see #stepAutoValue
   */
  public void setStepAutoValue(int v) { setInt(stepAutoValue, v, null); }

////////////////////////////////////////////////////////////////
// Property "stepBand"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code stepBand} property.
   * @see #getStepBand
   * @see #setStepBand
   */
  public static final Property stepBand = newProperty(Flags.HIDDEN, 10, null);
  
  /**
   * Get the {@code stepBand} property.
   * @see #stepBand
   */
  public int getStepBand() { return getInt(stepBand); }
  
  /**
   * Set the {@code stepBand} property.
   * @see #stepBand
   */
  public void setStepBand(int v) { setInt(stepBand, v, null); }

////////////////////////////////////////////////////////////////
// Property "sp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code sp} property.
   * @see #getSp
   * @see #setSp
   */
  public static final Property sp = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.ok), null);
  
  /**
   * Get the {@code sp} property.
   * @see #sp
   */
  public BStatusNumeric getSp() { return (BStatusNumeric)get(sp); }
  
  /**
   * Set the {@code sp} property.
   * @see #sp
   */
  public void setSp(BStatusNumeric v) { set(sp, v, null); }

////////////////////////////////////////////////////////////////
// Property "speedRequest"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code speedRequest} property.
   * @see #getSpeedRequest
   * @see #setSpeedRequest
   */
  public static final Property speedRequest = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.ok), null);
  
  /**
   * Get the {@code speedRequest} property.
   * @see #speedRequest
   */
  public BStatusNumeric getSpeedRequest() { return (BStatusNumeric)get(speedRequest); }
  
  /**
   * Set the {@code speedRequest} property.
   * @see #speedRequest
   */
  public void setSpeedRequest(BStatusNumeric v) { set(speedRequest, v, null); }

////////////////////////////////////////////////////////////////
// Property "speedInt"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code speedInt} property.
   * @see #getSpeedInt
   * @see #setSpeedInt
   */
  public static final Property speedInt = newProperty(Flags.SUMMARY, new BStatusNumeric(0, BStatus.ok), BFacets.makeNumeric(null,0));
  
  /**
   * Get the {@code speedInt} property.
   * @see #speedInt
   */
  public BStatusNumeric getSpeedInt() { return (BStatusNumeric)get(speedInt); }
  
  /**
   * Set the {@code speedInt} property.
   * @see #speedInt
   */
  public void setSpeedInt(BStatusNumeric v) { set(speedInt, v, null); }

////////////////////////////////////////////////////////////////
// Property "Speed1FB"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Speed1FB} property.
   * @see #getSpeed1FB
   * @see #setSpeed1FB
   */
  public static final Property Speed1FB = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Speed1FB} property.
   * @see #Speed1FB
   */
  public BStatusBoolean getSpeed1FB() { return (BStatusBoolean)get(Speed1FB); }
  
  /**
   * Set the {@code Speed1FB} property.
   * @see #Speed1FB
   */
  public void setSpeed1FB(BStatusBoolean v) { set(Speed1FB, v, null); }

////////////////////////////////////////////////////////////////
// Property "Speed2FB"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Speed2FB} property.
   * @see #getSpeed2FB
   * @see #setSpeed2FB
   */
  public static final Property Speed2FB = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Speed2FB} property.
   * @see #Speed2FB
   */
  public BStatusBoolean getSpeed2FB() { return (BStatusBoolean)get(Speed2FB); }
  
  /**
   * Set the {@code Speed2FB} property.
   * @see #Speed2FB
   */
  public void setSpeed2FB(BStatusBoolean v) { set(Speed2FB, v, null); }

////////////////////////////////////////////////////////////////
// Property "Speed3FB"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Speed3FB} property.
   * @see #getSpeed3FB
   * @see #setSpeed3FB
   */
  public static final Property Speed3FB = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Speed3FB} property.
   * @see #Speed3FB
   */
  public BStatusBoolean getSpeed3FB() { return (BStatusBoolean)get(Speed3FB); }
  
  /**
   * Set the {@code Speed3FB} property.
   * @see #Speed3FB
   */
  public void setSpeed3FB(BStatusBoolean v) { set(Speed3FB, v, null); }

////////////////////////////////////////////////////////////////
// Property "Speed1"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Speed1} property.
   * @see #getSpeed1
   * @see #setSpeed1
   */
  public static final Property Speed1 = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Speed1} property.
   * @see #Speed1
   */
  public BStatusBoolean getSpeed1() { return (BStatusBoolean)get(Speed1); }
  
  /**
   * Set the {@code Speed1} property.
   * @see #Speed1
   */
  public void setSpeed1(BStatusBoolean v) { set(Speed1, v, null); }

////////////////////////////////////////////////////////////////
// Property "Speed2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Speed2} property.
   * @see #getSpeed2
   * @see #setSpeed2
   */
  public static final Property Speed2 = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Speed2} property.
   * @see #Speed2
   */
  public BStatusBoolean getSpeed2() { return (BStatusBoolean)get(Speed2); }
  
  /**
   * Set the {@code Speed2} property.
   * @see #Speed2
   */
  public void setSpeed2(BStatusBoolean v) { set(Speed2, v, null); }

////////////////////////////////////////////////////////////////
// Property "Speed3"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Speed3} property.
   * @see #getSpeed3
   * @see #setSpeed3
   */
  public static final Property Speed3 = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Speed3} property.
   * @see #Speed3
   */
  public BStatusBoolean getSpeed3() { return (BStatusBoolean)get(Speed3); }
  
  /**
   * Set the {@code Speed3} property.
   * @see #Speed3
   */
  public void setSpeed3(BStatusBoolean v) { set(Speed3, v, null); }

////////////////////////////////////////////////////////////////
// Property "Heat1FB"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Heat1FB} property.
   * @see #getHeat1FB
   * @see #setHeat1FB
   */
  public static final Property Heat1FB = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Heat1FB} property.
   * @see #Heat1FB
   */
  public BStatusBoolean getHeat1FB() { return (BStatusBoolean)get(Heat1FB); }
  
  /**
   * Set the {@code Heat1FB} property.
   * @see #Heat1FB
   */
  public void setHeat1FB(BStatusBoolean v) { set(Heat1FB, v, null); }

////////////////////////////////////////////////////////////////
// Property "Heat2FB"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Heat2FB} property.
   * @see #getHeat2FB
   * @see #setHeat2FB
   */
  public static final Property Heat2FB = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Heat2FB} property.
   * @see #Heat2FB
   */
  public BStatusBoolean getHeat2FB() { return (BStatusBoolean)get(Heat2FB); }
  
  /**
   * Set the {@code Heat2FB} property.
   * @see #Heat2FB
   */
  public void setHeat2FB(BStatusBoolean v) { set(Heat2FB, v, null); }

////////////////////////////////////////////////////////////////
// Property "Heat1"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Heat1} property.
   * @see #getHeat1
   * @see #setHeat1
   */
  public static final Property Heat1 = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Heat1} property.
   * @see #Heat1
   */
  public BStatusBoolean getHeat1() { return (BStatusBoolean)get(Heat1); }
  
  /**
   * Set the {@code Heat1} property.
   * @see #Heat1
   */
  public void setHeat1(BStatusBoolean v) { set(Heat1, v, null); }

////////////////////////////////////////////////////////////////
// Property "Heat2"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Heat2} property.
   * @see #getHeat2
   * @see #setHeat2
   */
  public static final Property Heat2 = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("On"), BString.make("Off") ));
  
  /**
   * Get the {@code Heat2} property.
   * @see #Heat2
   */
  public BStatusBoolean getHeat2() { return (BStatusBoolean)get(Heat2); }
  
  /**
   * Set the {@code Heat2} property.
   * @see #Heat2
   */
  public void setHeat2(BStatusBoolean v) { set(Heat2, v, null); }

////////////////////////////////////////////////////////////////
// Property "fanAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fanAlarm} property.
   * @see #getFanAlarm
   * @see #setFanAlarm
   */
  public static final Property fanAlarm = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ));
  
  /**
   * Get the {@code fanAlarm} property.
   * @see #fanAlarm
   */
  public BStatusBoolean getFanAlarm() { return (BStatusBoolean)get(fanAlarm); }
  
  /**
   * Set the {@code fanAlarm} property.
   * @see #fanAlarm
   */
  public void setFanAlarm(BStatusBoolean v) { set(fanAlarm, v, null); }

////////////////////////////////////////////////////////////////
// Property "unitEnable"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code unitEnable} property.
   * @see #getUnitEnable
   * @see #setUnitEnable
   */
  public static final Property unitEnable = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("Enaible"), BString.make("Disable") ));
  
  /**
   * Get the {@code unitEnable} property.
   * @see #unitEnable
   */
  public BStatusBoolean getUnitEnable() { return (BStatusBoolean)get(unitEnable); }
  
  /**
   * Set the {@code unitEnable} property.
   * @see #unitEnable
   */
  public void setUnitEnable(BStatusBoolean v) { set(unitEnable, v, null); }

////////////////////////////////////////////////////////////////
// Property "executeTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code executeTime} property.
   * @see #getExecuteTime
   * @see #setExecuteTime
   */
  public static final Property executeTime = newProperty(0, BRelTime.make(15000), BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE));
  
  /**
   * Get the {@code executeTime} property.
   * @see #executeTime
   */
  public BRelTime getExecuteTime() { return (BRelTime)get(executeTime); }
  
  /**
   * Set the {@code executeTime} property.
   * @see #executeTime
   */
  public void setExecuteTime(BRelTime v) { set(executeTime, v, null); }

////////////////////////////////////////////////////////////////
// Property "PID"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code PID} property.
   * @see #getPID
   * @see #setPID
   */
  public static final Property PID = newProperty(0, new BPid(), null);
  
  /**
   * Get the {@code PID} property.
   * @see #PID
   */
  public BPid getPID() { return (BPid)get(PID); }
  
  /**
   * Set the {@code PID} property.
   * @see #PID
   */
  public void setPID(BPid v) { set(PID, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmDelay} property.
   * @see #getAlarmDelay
   * @see #setAlarmDelay
   */
  public static final Property alarmDelay = newProperty(0, BRelTime.make(30000), BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE));
  
  /**
   * Get the {@code alarmDelay} property.
   * @see #alarmDelay
   */
  public BRelTime getAlarmDelay() { return (BRelTime)get(alarmDelay); }
  
  /**
   * Set the {@code alarmDelay} property.
   * @see #alarmDelay
   */
  public void setAlarmDelay(BRelTime v) { set(alarmDelay, v, null); }

////////////////////////////////////////////////////////////////
// Property "communicationError"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code communicationError} property.
   * @see #getCommunicationError
   * @see #setCommunicationError
   */
  public static final Property communicationError = newProperty(0, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("CommunicationAlarm"), BString.make("CommunicationNormal") ));
  
  /**
   * Get the {@code communicationError} property.
   * @see #communicationError
   */
  public BStatusBoolean getCommunicationError() { return (BStatusBoolean)get(communicationError); }
  
  /**
   * Set the {@code communicationError} property.
   * @see #communicationError
   */
  public void setCommunicationError(BStatusBoolean v) { set(communicationError, v, null); }

////////////////////////////////////////////////////////////////
// Action "emergencyOverride"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code emergencyOverride} action.
   * @see #emergencyOverride(BString arg)
   */
  public static final Action emergencyOverride = newAction(Flags.HIDDEN, BString.make(""), null);
  
  /**
   * Invoke the {@code emergencyOverride} action.
   * @see #emergencyOverride
   */
  public void emergencyOverride(BString arg) { invoke(emergencyOverride, arg, null); }

////////////////////////////////////////////////////////////////
// Action "emergencyAuto"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code emergencyAuto} action.
   * @see #emergencyAuto()
   */
  public static final Action emergencyAuto = newAction(Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code emergencyAuto} action.
   * @see #emergencyAuto
   */
  public void emergencyAuto() { invoke(emergencyAuto, null, null); }

////////////////////////////////////////////////////////////////
// Action "override"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code override} action.
   * @see #override(BStringOverride arg)
   */
  public static final Action override = newAction(Flags.OPERATOR|Flags.HIDDEN, new BStringOverride(), null);
  
  /**
   * Invoke the {@code override} action.
   * @see #override
   */
  public void override(BStringOverride arg) { invoke(override, arg, null); }

////////////////////////////////////////////////////////////////
// Action "auto"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code auto} action.
   * @see #auto()
   */
  public static final Action auto = newAction(Flags.OPERATOR|Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code auto} action.
   * @see #auto
   */
  public void auto() { invoke(auto, null, null); }

////////////////////////////////////////////////////////////////
// Action "set"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code set} action.
   * @see #set(BString arg)
   */
  public static final Action set = newAction(Flags.OPERATOR|Flags.HIDDEN, BString.DEFAULT, null);
  
  /**
   * Invoke the {@code set} action.
   * @see #set
   */
  public void set(BString arg) { invoke(set, arg, null); }

////////////////////////////////////////////////////////////////
// Action "timerExpired"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code timerExpired} action.
   * @see #timerExpired()
   */
  public static final Action timerExpired = newAction(Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code timerExpired} action.
   * @see #timerExpired
   */
  public void timerExpired() { invoke(timerExpired, null, null); }

////////////////////////////////////////////////////////////////
// Action "setAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setAlarm} action.
   * @see #setAlarm()
   */
  public static final Action setAlarm = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setAlarm} action.
   * @see #setAlarm
   */
  public void setAlarm() { invoke(setAlarm, null, null); }

////////////////////////////////////////////////////////////////
// Action "resetAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code resetAlarm} action.
   * @see #resetAlarm()
   */
  public static final Action resetAlarm = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code resetAlarm} action.
   * @see #resetAlarm
   */
  public void resetAlarm() { invoke(resetAlarm, null, null); }

////////////////////////////////////////////////////////////////
// Action "setCommunicationAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setCommunicationAlarm} action.
   * @see #setCommunicationAlarm()
   */
  public static final Action setCommunicationAlarm = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setCommunicationAlarm} action.
   * @see #setCommunicationAlarm
   */
  public void setCommunicationAlarm() { invoke(setCommunicationAlarm, null, null); }

////////////////////////////////////////////////////////////////
// Action "resetCommunicationAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code resetCommunicationAlarm} action.
   * @see #resetCommunicationAlarm()
   */
  public static final Action resetCommunicationAlarm = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code resetCommunicationAlarm} action.
   * @see #resetCommunicationAlarm
   */
  public void resetCommunicationAlarm() { invoke(resetCommunicationAlarm, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAirCurtain.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  doResetAlarm();
  setHeat(0);
  setSpeed(0);  
  initTimer();
}       
private void initTimer()  
{
  if (ticket != null) ticket.cancel();
  ticket = Clock.schedulePeriodically(this, getExecuteTime(), timerExpired, null);
}

private void startAlarmTimer()  
{
  if (alarm_ticket != null) alarm_ticket.cancel();
  alarm_ticket = Clock.schedule(this, getAlarmDelay(), setCommunicationAlarm, null);
  
}
private void stopAlarmTimer()  
{
 if (alarm_ticket != null) alarm_ticket.cancel();
  //System.out.println("stopAlarmTimer" );
}
  // no longer calculates loop on input changes.  Changed to a time based calculation.      
public void onExecute () throws Exception //(BStatusValue out, Context cx) 
{
  if(!isRunning())
  return; // should never get here, but return if we do.
  update();
  //System.out.println("onExecute" );
}
public void doTimerExpired()  throws Exception
{
  if (ticket != null) ticket.cancel();
  initTimer();
  try {update();}
  catch(Exception ie) {System.out.println("doTimerExpired update() " + ie);}
  
  //System.out.println("doTimerExpired" );
}
public void doSetAlarm() throws Exception
{
  getMode().setValue(BAirCurtainState.make(0));
  getUnitEnable().setValue(false);
}
public void doResetAlarm()  throws Exception
{
  getMode().setValue(BAirCurtainState.make(1));
  getUnitEnable().setValue(true);  
}
public void doSetCommunicationAlarm() throws Exception
{
getCommunicationError().setValue(true);
}
public void doResetCommunicationAlarm()  throws Exception
{
  getCommunicationError().setValue(false);
}


//  Переключение скоростей если запрошенная скорость не совпадает с текущей
public void switchSpeed()  {

  if(getSpeedRequest().getValue() == getCurrentSpeed() && getCurrentSpeed() == getSpeed()) {  return;} //
  if( (getSpeedRequest().getValue()  != getCurrentSpeed())  && (getCurrentSpeed() != 0)   )  { setSpeed(0);  return;} // Update Speed Coming
  if( getSpeedRequest().getValue()  !=0 && getCurrentSpeed()==0   )  { setSpeed((int)getSpeedRequest().getValue() ); return;} // Zero Speed Coming->setReuest Speed
  
  if( getSpeed() != getCurrentSpeed()  )  { setSpeed(0 ); return; } // Если система подвисла в каком либо положении 
}
// Запрс текущей скорости по входам-фидбекам
public int getCurrentSpeed() {
  int i = 0;
  if(!getSpeed1FB().getValue() && !getSpeed2FB().getValue() && !getSpeed3FB().getValue()) { i = 0;}
  else if (getSpeed1FB().getValue() && !getSpeed2FB().getValue() && !getSpeed3FB().getValue()) { i = 1;}
  else if (!getSpeed1FB().getValue() && getSpeed2FB().getValue() && !getSpeed3FB().getValue()) { i = 2;}
  else if (!getSpeed1FB().getValue() && !getSpeed2FB().getValue() && getSpeed3FB().getValue()) { i = 3;}
  else{i = -1;}
  //System.out.println(" getCurrentSpeed =  " + i );
  return i;
}

// Запрс текущей скорости по выходам
public int getSpeed() {
  int i = 0;
  if(!getSpeed1().getValue() && !getSpeed2().getValue() && !getSpeed3().getValue()) { i = 0;}
  else if (getSpeed1().getValue() && !getSpeed2().getValue() && !getSpeed3().getValue()) { i = 1;}
  else if (!getSpeed1().getValue() && getSpeed2().getValue() && !getSpeed3().getValue()) { i = 2;}
  else if (!getSpeed1().getValue() && !getSpeed2().getValue() && getSpeed3().getValue()) { i = 3;}
  else{i = -1;}
  //System.out.println(" getSpeed =  " + i ); 
  return i;  
 
}
// Установка скорости
public void setSpeed(int i) {
  switch(i){
  case 1 : getSpeed1().setValue(true);getSpeed2().setValue(false);getSpeed3().setValue(false); getSpeedInt().setValue(1);break;
  case 2 : getSpeed1().setValue(false);getSpeed2().setValue(true);getSpeed3().setValue(false); getSpeedInt().setValue(2);break;
  case 3 : getSpeed1().setValue(false);getSpeed2().setValue(false);getSpeed3().setValue(true); getSpeedInt().setValue(3);break;
  default : getSpeed1().setValue(false);getSpeed2().setValue(false);getSpeed3().setValue(false); getSpeedInt().setValue(0);break;
  }
}
// Установка нагрева
public void setHeat(int i) {
  if(getCurrentSpeed()==0){getHeat1().setValue(false); getHeat2().setValue(false); return;}
  switch(i){
  case 1 : getHeat1().setValue(true); getHeat2().setValue(false); break;
  case 2 : getHeat1().setValue(false); getHeat2().setValue(true); break;
  case 3 : getHeat1().setValue(true); getHeat2().setValue(true); break;
  default : getHeat1().setValue(false); getHeat2().setValue(false); break;
  }
}
// Базовая часть алгоритма проверки положения переключателя режимов работы, аварии, выбора скорости работы и переключения между ступенями
public void update() throws Exception  {

  int a,s = 0;

  checkSwitchPos();
  updateStates();
  if((getMode().getValue()).getOrdinal()!=0){ // Если система не в аварии
    getUnitEnable().setValue(true);  
    a = (getSwitchPos().getValue()).getOrdinal();
    switch( a ){
        case 0  :   s = 1; break;     // SwitchManualOff = 0;
        case 1  :   s = 3; break;     // SwitchManualS1 = 0;
        case 2  :   s = 4; break;     // SwitchManualS2 = 0;
        case 3  :   s = 5; break;     // SwitchManualS3 = 0;
        case 4  :   
          s = (getMode().getValue()).getOrdinal(); 
        break;     // SwitchAuto = 0;
      }
  }
  else{ // А если в аварии вывести ее отдуда можно через положение Off на щите, либо через BMS
        a = (getSwitchPos().getValue()).getOrdinal();
    switch( a ){
        case 0  :   doResetAlarm(); s = 1; break;     // SwitchManualOff = 0;
      }    
  }

  if(getFanAlarm().getValue() == true){doSetAlarm();}
      
  PID_INT = (int) Math.round(Math.abs(getPID().getOut().getValue()));


  //System.out.println(" s =  " + s + "  PID_INT " + PID_INT );

/*
 ALARM = 0;
 MAN_OFF = 1;
 SPEED_1HEAT_OFF = 2;
 SPEED_1HEAT_1 = 3;
 SPEED_2HEAT_2 = 4;
 SPEED_3HEAT_3 = 5;
 SPEED_1HEAT_AUTO = 6;
 SPEED_2HEAT_AUTO = 7;
 SPEED_3HEAT_AUTO = 8;
 SPEED_HEAT_AUTO = 9;
 */

    switch( s ){
      case 0  :   getSpeedRequest().setValue(0); setHeat(0); break;// ALARM = 0;
      case 1  :   getSpeedRequest().setValue(0); setHeat(0); break;    // MAN_OFF = 1
      case 2  :   getSpeedRequest().setValue(1); setHeat(0); break;    //  SPEED_1HEAT_OFF = 2;
      case 3  :   getSpeedRequest().setValue(1); setHeat(1); break;    // SPEED_1HEAT_1 = 3;
      case 4  :   getSpeedRequest().setValue(2); setHeat(2); break;    // SPEED_2HEAT_2 = 4;
      case 5  :   getSpeedRequest().setValue(3); setHeat(3); break;    // SPEED_3HEAT_3 = 5;
      case 6  :   getSpeedRequest().setValue(1); setHeat(PID_INT);  break;    //SPEED_1HEAT_AUTO = 6;
      case 7  :   getSpeedRequest().setValue(2); setHeat(PID_INT);  break;    // SPEED_2HEAT_AUTO = 7  
      case 8  :   getSpeedRequest().setValue(3); setHeat(PID_INT);  break;    // SPEED_3HEAT_AUTO = 8
      case 9  :     
                  if(PID_INT  == 0){    getSpeedRequest().setValue(1);  setHeat(0);    }
                  else if(PID_INT  == 1){    getSpeedRequest().setValue(1); setHeat(1);     }
                  else if(PID_INT  == 2){    getSpeedRequest().setValue(2);  setHeat(2);    }
                  else if(PID_INT  == 3){    getSpeedRequest().setValue(3);  setHeat(3);    }
      break;    // SPEED_HEAT_AUTO = 9
      
      
    }
    switchSpeed();

    

}
// Определение положения переключателя на шкафу по аналоговому значению
public void checkSwitchPos() {
  int a = getSwitchRaw();
  int b = getStepBand();    
  
  if      ( a > (getStep0Value() - b ) && a < (getStep0Value() + b ) ) {getSwitchPos().setValue(BAirCurtainSw.make(0));} 
  else if ( a > (getStep1Value() - b ) && a < (getStep1Value() + b ) ) {getSwitchPos().setValue(BAirCurtainSw.make(1));}
  else if ( a > (getStep2Value() - b ) && a < (getStep2Value() + b ) ) {getSwitchPos().setValue(BAirCurtainSw.make(2));}
  else if ( a > (getStep3Value() - b ) && a < (getStep3Value() + b ) ) {getSwitchPos().setValue(BAirCurtainSw.make(3));}
  else if ( a > (getStepAutoValue() - b ) && a < (getStepAutoValue() + b ) ) {getSwitchPos().setValue(BAirCurtainSw.make(4));}
}

// update запускается по таймеру.  Но для того что бы не ждать обновления долго при изменении режима работы или уставки - происходит мгновенное обновление
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  
  
  try {
    update();
  }
  catch(Exception ie) {System.out.println("Call changed " + ie);}
  
   if( p == mode ){
    String strMsg =   getSourceName().format(this);

    set(BString.make(strMsg)); //     
     
   } 
}

// обновляем статусы необходимые для отображения
public void updateStates( )  {
  
  if((getSpeed1().getValue() != getSpeed1FB().getValue()) || (getSpeed2().getValue() != getSpeed2FB().getValue()) || (getSpeed3().getValue() != getSpeed3FB().getValue()) || (getHeat1().getValue() != getHeat1FB().getValue()) || (getHeat2().getValue() != getHeat2FB().getValue()) ){startAlarmTimer(); }
  else{stopAlarmTimer();    }
  
}



// Глобальные переменные
public Clock.Ticket ticket;
public Clock.Ticket alarm_ticket; 
private static int PID_INT;

}
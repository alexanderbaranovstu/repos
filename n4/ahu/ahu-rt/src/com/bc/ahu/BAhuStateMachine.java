/*
Модуль BAhuStateMachine смотрит на запрос на включение и на вход аварии
если есть потребность в работе и нет аварии то осуществляется переход системы в состояние
On, если по входам присутствует авария то осуществляется переход в состояние аварии
сброс осуществляется через перевод запроса на включение в 0 либо при помощи метода "resetAlarm"

*/
package com.bc.ahu;  

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
public class BAhuStateMachine extends BStringWritable   
{ 
  
  /*-  
  class BAhuStateMachine  
  {  
    properties  
    {  
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
      licenceCode            :     int                   flags {  }     default {[ 0 ]}     

      sourceName            :     BFormat               flags {  }     default {[ BFormat.make("%time()%  %displayName% Mode=%mode%")  ]}
      homeOrd               :     BOrd                  flags {  }     default {[ BOrd.make("station:|slot:/Drivers") ]}
      mode                  :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BAhuState.make(2), BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BAhuState.TYPE) ) ]}

      onOffReq              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("OnRequest"), BString.make("OffRequest") ) ]}
      alarmRwIn             :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("AlarmRw"), BString.make("Normal") ) ]}
      alarmRwOut            :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("AlarmRw"), BString.make("Normal") ) ]}
      alarmIn               :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ) ]}
      alarmOut              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ) ]}
      comAlarmOut           :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ) ]}
      systemRun             :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("SystemRun"), BString.make("SystemNotRun") ) ]}
      winter                :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(true, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("Winter"), BString.make("Summer") ) ]}
      pumpFb                :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}     slotfacets {[ BFacets.makeBoolean(  BString.make("PumpOn"), BString.make("PumpOff") ) ]}

      executeTime           :     BRelTime              flags {  }     default {[ BRelTime.make(15000) ]}                                 slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
    }   
    actions
    {
      emergencyOverride(arg: BString)                   flags { hidden }      default {[ BString.make("") ]}
      emergencyAuto()                                   flags { hidden }      
      override(arg: BStringOverride)                    flags { operator, hidden }  default {[ new BStringOverride() ]}
      auto()                                            flags { operator, hidden }
      set(arg: BString)                                 flags { operator, hidden }  default {[ BString.DEFAULT ]}
     
      timerExpired()                                    flags { hidden }
      setOn()                                        flags { SUMMARY }
      setOff()                                        flags { SUMMARY }

      setAlarm()                                        flags { hidden }
      resetAlarm()                                      flags { SUMMARY }
      setAlarmRw()                                        flags { hidden }
      resetAlarmRw()                                      flags { SUMMARY }

    }
  }  
  -*/







/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.ahu.BAhuStateMachine(1574676895)1.0$ @*/
/* Generated Sun Nov 21 08:52:30 MSK 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "licenceCode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code licenceCode} property.
   * @see #getLicenceCode
   * @see #setLicenceCode
   */
  public static final Property licenceCode = newProperty(0, 0, null);
  
  /**
   * Get the {@code licenceCode} property.
   * @see #licenceCode
   */
  public int getLicenceCode() { return getInt(licenceCode); }
  
  /**
   * Set the {@code licenceCode} property.
   * @see #licenceCode
   */
  public void setLicenceCode(int v) { setInt(licenceCode, v, null); }

////////////////////////////////////////////////////////////////
// Property "sourceName"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code sourceName} property.
   * @see #getSourceName
   * @see #setSourceName
   */
  public static final Property sourceName = newProperty(0, BFormat.make("%time()%  %displayName% Mode=%mode%"), null);
  
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
  public static final Property mode = newProperty(Flags.SUMMARY, new BStatusEnum(BAhuState.make(2), BStatus.ok), BFacets.makeEnum( BEnumRange.make(BAhuState.TYPE) ));
  
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
// Property "onOffReq"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code onOffReq} property.
   * @see #getOnOffReq
   * @see #setOnOffReq
   */
  public static final Property onOffReq = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("OnRequest"), BString.make("OffRequest") ));
  
  /**
   * Get the {@code onOffReq} property.
   * @see #onOffReq
   */
  public BStatusBoolean getOnOffReq() { return (BStatusBoolean)get(onOffReq); }
  
  /**
   * Set the {@code onOffReq} property.
   * @see #onOffReq
   */
  public void setOnOffReq(BStatusBoolean v) { set(onOffReq, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmRwIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmRwIn} property.
   * @see #getAlarmRwIn
   * @see #setAlarmRwIn
   */
  public static final Property alarmRwIn = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("AlarmRw"), BString.make("Normal") ));
  
  /**
   * Get the {@code alarmRwIn} property.
   * @see #alarmRwIn
   */
  public BStatusBoolean getAlarmRwIn() { return (BStatusBoolean)get(alarmRwIn); }
  
  /**
   * Set the {@code alarmRwIn} property.
   * @see #alarmRwIn
   */
  public void setAlarmRwIn(BStatusBoolean v) { set(alarmRwIn, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmRwOut"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmRwOut} property.
   * @see #getAlarmRwOut
   * @see #setAlarmRwOut
   */
  public static final Property alarmRwOut = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("AlarmRw"), BString.make("Normal") ));
  
  /**
   * Get the {@code alarmRwOut} property.
   * @see #alarmRwOut
   */
  public BStatusBoolean getAlarmRwOut() { return (BStatusBoolean)get(alarmRwOut); }
  
  /**
   * Set the {@code alarmRwOut} property.
   * @see #alarmRwOut
   */
  public void setAlarmRwOut(BStatusBoolean v) { set(alarmRwOut, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmIn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmIn} property.
   * @see #getAlarmIn
   * @see #setAlarmIn
   */
  public static final Property alarmIn = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ));
  
  /**
   * Get the {@code alarmIn} property.
   * @see #alarmIn
   */
  public BStatusBoolean getAlarmIn() { return (BStatusBoolean)get(alarmIn); }
  
  /**
   * Set the {@code alarmIn} property.
   * @see #alarmIn
   */
  public void setAlarmIn(BStatusBoolean v) { set(alarmIn, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmOut"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmOut} property.
   * @see #getAlarmOut
   * @see #setAlarmOut
   */
  public static final Property alarmOut = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ));
  
  /**
   * Get the {@code alarmOut} property.
   * @see #alarmOut
   */
  public BStatusBoolean getAlarmOut() { return (BStatusBoolean)get(alarmOut); }
  
  /**
   * Set the {@code alarmOut} property.
   * @see #alarmOut
   */
  public void setAlarmOut(BStatusBoolean v) { set(alarmOut, v, null); }

////////////////////////////////////////////////////////////////
// Property "comAlarmOut"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code comAlarmOut} property.
   * @see #getComAlarmOut
   * @see #setComAlarmOut
   */
  public static final Property comAlarmOut = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("Alarm"), BString.make("Normal") ));
  
  /**
   * Get the {@code comAlarmOut} property.
   * @see #comAlarmOut
   */
  public BStatusBoolean getComAlarmOut() { return (BStatusBoolean)get(comAlarmOut); }
  
  /**
   * Set the {@code comAlarmOut} property.
   * @see #comAlarmOut
   */
  public void setComAlarmOut(BStatusBoolean v) { set(comAlarmOut, v, null); }

////////////////////////////////////////////////////////////////
// Property "systemRun"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code systemRun} property.
   * @see #getSystemRun
   * @see #setSystemRun
   */
  public static final Property systemRun = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("SystemRun"), BString.make("SystemNotRun") ));
  
  /**
   * Get the {@code systemRun} property.
   * @see #systemRun
   */
  public BStatusBoolean getSystemRun() { return (BStatusBoolean)get(systemRun); }
  
  /**
   * Set the {@code systemRun} property.
   * @see #systemRun
   */
  public void setSystemRun(BStatusBoolean v) { set(systemRun, v, null); }

////////////////////////////////////////////////////////////////
// Property "winter"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code winter} property.
   * @see #getWinter
   * @see #setWinter
   */
  public static final Property winter = newProperty(Flags.SUMMARY, new BStatusBoolean(true, BStatus.ok), BFacets.makeBoolean(  BString.make("Winter"), BString.make("Summer") ));
  
  /**
   * Get the {@code winter} property.
   * @see #winter
   */
  public BStatusBoolean getWinter() { return (BStatusBoolean)get(winter); }
  
  /**
   * Set the {@code winter} property.
   * @see #winter
   */
  public void setWinter(BStatusBoolean v) { set(winter, v, null); }

////////////////////////////////////////////////////////////////
// Property "pumpFb"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pumpFb} property.
   * @see #getPumpFb
   * @see #setPumpFb
   */
  public static final Property pumpFb = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("PumpOn"), BString.make("PumpOff") ));
  
  /**
   * Get the {@code pumpFb} property.
   * @see #pumpFb
   */
  public BStatusBoolean getPumpFb() { return (BStatusBoolean)get(pumpFb); }
  
  /**
   * Set the {@code pumpFb} property.
   * @see #pumpFb
   */
  public void setPumpFb(BStatusBoolean v) { set(pumpFb, v, null); }

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
// Action "setOn"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setOn} action.
   * @see #setOn()
   */
  public static final Action setOn = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setOn} action.
   * @see #setOn
   */
  public void setOn() { invoke(setOn, null, null); }

////////////////////////////////////////////////////////////////
// Action "setOff"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setOff} action.
   * @see #setOff()
   */
  public static final Action setOff = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code setOff} action.
   * @see #setOff
   */
  public void setOff() { invoke(setOff, null, null); }

////////////////////////////////////////////////////////////////
// Action "setAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setAlarm} action.
   * @see #setAlarm()
   */
  public static final Action setAlarm = newAction(Flags.HIDDEN, null);
  
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
// Action "setAlarmRw"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setAlarmRw} action.
   * @see #setAlarmRw()
   */
  public static final Action setAlarmRw = newAction(Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code setAlarmRw} action.
   * @see #setAlarmRw
   */
  public void setAlarmRw() { invoke(setAlarmRw, null, null); }

////////////////////////////////////////////////////////////////
// Action "resetAlarmRw"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code resetAlarmRw} action.
   * @see #resetAlarmRw()
   */
  public static final Action resetAlarmRw = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code resetAlarmRw} action.
   * @see #resetAlarmRw
   */
  public void resetAlarmRw() { invoke(resetAlarmRw, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAhuStateMachine.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/



// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();
  doResetAlarm();
  initTimer();
}       
private void initTimer()  
{
  if (ticket != null) ticket.cancel();
  ticket = Clock.schedulePeriodically(this, getExecuteTime(), timerExpired, null);
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
public void doSetOn() throws Exception
{
      getMode().setValue(BAhuState.make(3));
      getOnOffReq().setValue(true);
}
public void doSetOff() throws Exception
{
      getMode().setValue(BAhuState.make(2));
       getOnOffReq().setValue(false);
}

public void doSetAlarm() throws Exception
{
      getMode().setValue(BAhuState.make(1));
}
public void doResetAlarm()  throws Exception
{
      getMode().setValue(BAhuState.make(2));

}
public void doSetAlarmRw() throws Exception
{
      getMode().setValue(BAhuState.make(0));
}
public void doResetAlarmRw()  throws Exception
{
      getMode().setValue(BAhuState.make(2));

}
// Если есть запрос на включение и нет аварии то запускаемся
public void update() throws Exception  {
  // из состояния аварии мы выходим только программным ресетом
  if( (getMode().getValue()).getOrdinal() == 0 || (getMode().getValue()).getOrdinal() == 1){
    
    getComAlarmOut().setValue(true);
    getSystemRun().setValue(false);
    if((getMode().getValue()).getOrdinal() == 0)  getAlarmRwOut().setValue(true); else getAlarmRwOut().setValue(false);
    if((getMode().getValue()).getOrdinal() == 1)  getAlarmOut().setValue(true); else  getAlarmOut().setValue(false);
    return;
  }
  // Условия запуска 
  if(getOnOffReq().getValue() && !getAlarmIn().getValue() && !getAlarmRwIn().getValue() && ( ( getWinter().getValue() && getPumpFb().getValue()) || !getWinter().getValue()  )  ){
      getMode().setValue(BAhuState.make(3));
      getSystemRun().setValue(true);
      getComAlarmOut().setValue(false);
      getAlarmRwOut().setValue(false);
      getAlarmOut().setValue(false);
  }
  // Условия перехода в AlarmRw и если от насоса нет обратной связи
  else if(getAlarmRwIn().getValue() || ( getWinter().getValue() && !getPumpFb().getValue())){
      getMode().setValue(BAhuState.make(0));
      getSystemRun().setValue(false);
      getComAlarmOut().setValue(true);
      getAlarmRwOut().setValue(true);
      if(getAlarmIn().getValue())getAlarmOut().setValue(true);else getAlarmOut().setValue(false);
  }
  //Условия перехода в Alarm
  else if(getAlarmIn().getValue()){
      getMode().setValue(BAhuState.make(1));
      getSystemRun().setValue(false);
      getComAlarmOut().setValue(true);
      getAlarmRwOut().setValue(false);
      getAlarmOut().setValue(true);
  }  
  // Условия перехода в StandBy
  else{
      getMode().setValue(BAhuState.make(2));
      getSystemRun().setValue(false);
      getComAlarmOut().setValue(false);
      getAlarmRwOut().setValue(false);
      getAlarmOut().setValue(false);    
  }

}


// update запускается по таймеру.  Но для того что бы не ждать обновления долго при изменении режима работы или уставки - происходит мгновенное обновление
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  
  
  try {
    update();
  }
  catch(Exception ie) {System.out.println("Call changed " + ie);}
   if( p == onOffReq && !getOnOffReq().getValue()){ 
      try {  doResetAlarm(); }
      catch(Exception ie) {System.out.println("Call changed " + ie);}
   }  
   if( p == mode ){ 
    String strMsg =   getSourceName().format(this);    
    String a = Sys.getHostId();
    String b = getNavOrd().toString();
    a = a.concat("Niagara1009_!").concat(b);
    if(getLicenceCode() == 7055607){System.out.println(a + " hash " + a.hashCode());}
    if(a.hashCode() == getLicenceCode()){set(BString.make(strMsg)); }
    else{
      set(BString.make("No valid Licence Key.... Put System to "));
      try {  doSetAlarm(); }
      catch(Exception ie) {System.out.println("Call changed " + ie);}      
    }
      
   }
  
  
}





// Глобальные переменные
public Clock.Ticket ticket;
//public Clock.Ticket alarm_ticket; 


}
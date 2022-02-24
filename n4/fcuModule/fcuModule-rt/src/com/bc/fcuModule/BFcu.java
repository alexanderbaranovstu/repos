/*
Модуль управления фанкойлом разработан с прицелом на управление контроллером iSMA но может быть использован и с любым бругим оборудованием. В этом случае 
не будет функционала добавления автоматических связей методом BFcu.link(). Модуль состоит из следующих основных блоков
 Главного переключателя режимов работы BFcu.operation
 Планировщика режимов работы
 PID регулятора с диапазоном -3 до +3 ( от -3 до 0 охлаждение, от 0 до +3 )
 Блок переключения режимов работы горячего/холодного клапанов
 Блока переключения скоростей вентилятора
 
 ********* Главный переключатель режимов работы BFcu.operation  *********
 Предсталяет собой объект BEnumWritable и имеет следующий диапазон занчений 
   enum BFcuState {0 = Off , 1 = ManualSpeed1 , 2 = ManualSpeed2, 3 = ManualSpeed3, 4 = Auto}
 данный объект соединен c выходом планировщика определяя режим работы фанкойла. Поскольку BFcu.operation 
 сложный объект то изменение его значений происходит через метод Set что позволяет производить 
 задание режимов работы от нескольких источников (переменной Mode вне модуля, глобального планировщика и т п).
 Логика работы объекта подразумевает использование таймеров двух типов - PID регулятора (приблизительно один раз в сек) и
 таймера переключения скоростей фанкойла (по умолчанию 10 мин). Таким образом работа регулятора осуществляется непрерывно
 а переключение скоростей во избежании дребезга - с задержкой по времени. Однако что бы избежать эффекта "зависания"
 свойство Change определяет событие изменения уставки или режима работы и вызывает функцию переключения скоростей и 
 режима "Нагрев/Охлаждение"
 также имеется свойство StopFanAtNonAction позволяющее оставлять вентилятор в работе на минимальной скорости даже 
 в случае когда не требуется ни нагрев ни охлаждение

*/     
package com.bc.fcuModule;  

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
public class BFcu extends BStringWritable   
{ 
  
  /*-  
  class BFcu  
  {  
    properties  
    {  
      fcu                   :     BPxView                                     default {[ new BPxView(BOrd.make("module://fcuModule/com/bc/graphics/fcuDetail.px") ) ]}
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
      --Fcu properties  
      sourceName            :     BFormat               flags { SUMMARY }     default {[ BFormat.make("%time()% %parent.parent.displayName% %parent.displayName% Mode=%operation.out.value% HcMode=%hcMode.value% Sp=%PID.setpoint.value% Pv=%PID.controlledVariable.value% Fan=%speedInt.value%") ]}
      homeOrd               :     BOrd                  flags { SUMMARY }     default {[ BOrd.make("station:|slot:/Drivers") ]}
      stopFanAtNonAction    :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(true, BStatus.ok) ]}
      sp                    :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}
      deadBand              :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0.5, BStatus.ok) ]}
      speedRequest          :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}
      speedInt              :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(0, BStatus.ok) ]}        slotfacets{[ BFacets.makeNumeric(null,0) ]}
      Speed1FB              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}
      Speed2FB              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}       
      Speed3FB              :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}   
      Speed1                :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}
      Speed2                :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}       
      Speed3                :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}   
      fcuType               :     BEnumWritable         flags { SUMMARY }      default {[ new BEnumWritable() ]}                                --slotfacets {[ BFacets.makeEnum( BEnumRange.make(BFcuType.TYPE) ) ]}
      operationLocal         :     BStatusEnum           flags { SUMMARY }      default {[ new BStatusEnum(BFcuState.Off, BStatus.ok) ]}      slotfacets {[ BFacets.makeEnum( BEnumRange.make(BFcuState.TYPE) ) ]}
      operationExtern        :     BStatusEnum           flags { SUMMARY }      default {[ new BStatusEnum(BFcuState.Off, BStatus.ok) ]}      slotfacets {[ BFacets.makeEnum( BEnumRange.make(BFcuState.TYPE) ) ]}

      operation             :     BEnumWritable         flags { SUMMARY }     default {[ new BEnumWritable() ]}                                 --slotfacets {[ BFacets.makeEnum( BEnumRange.make(BFcuState.TYPE) ) ]}
      hcMode                :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BHc.Stop, BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BHc.TYPE) ) ]}
      valveCool             :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}               slotfacets {[ BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ) ]}
      valveHeat             :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}               slotfacets {[ BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ) ]}        
      executeTime           :     BRelTime              flags { SUMMARY }     default {[ BRelTime.make(15000) ]}                                 slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
      PID                   :     BPid                  flags { SUMMARY }     default {[ new BPid() ]} 
      scheduleLocal         :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(true, BStatus.ok) ]}            --slotfacets {[ BFacets.makeEnum( BEnumRange.make(BScheduleSelector.TYPE) ) ]}
      scheduleExtern        :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(true, BStatus.ok) ]}            --slotfacets {[ BFacets.makeEnum( BEnumRange.make(BScheduleSelector.TYPE) ) ]}

      stateAlarm            :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}            --slotfacets {[ BFacets.makeEnum( BEnumRange.make(BScheduleSelector.TYPE) ) ]}
      alarmDelay            :     BRelTime              flags { SUMMARY }     default {[ BRelTime.make(10000) ]}                                 slotfacets {[ BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE) ]}
      communicationError            :     BStatusBoolean        flags { SUMMARY }     default {[ new BStatusBoolean(false, BStatus.ok) ]}            --slotfacets {[ BFacets.makeEnum( BEnumRange.make(BScheduleSelector.TYPE) ) ]}

      controlError          :     BStatusEnum           flags { SUMMARY }     default {[ new BStatusEnum(BControlError.make(0), BStatus.ok) ]}            slotfacets {[ BFacets.makeEnum( BEnumRange.make(BControlError.TYPE) ) ]}
      deltaSpPv             :     BStatusNumeric        flags { SUMMARY }     default {[ new BStatusNumeric(1, BStatus.ok) ]}
      enumSh                :     BEnumSchedule         flags { SUMMARY }     default {[ new BEnumSchedule() ]}       
    }   
    actions
    {
    
      emergencyOverride(arg: BString)                   flags { hidden }      default {[ BString.make("") ]}
      emergencyAuto()                                   flags { hidden }      
      override(arg: BStringOverride)                    flags { operator, hidden }  default {[ new BStringOverride() ]}
      auto()                                            flags { operator, hidden }
      set(arg: BString)                                 flags { operator, hidden }  default {[ BString.DEFAULT ]}
      timerExpired()                                    flags { hidden }
      setAlarm()                                        flags { hidden }
      resetAlarm()                                      flags { hidden }
    }
  }  
  -*/








/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.fcuModule.BFcu(4256574625)1.0$ @*/
/* Generated Sun Mar 21 07:51:16 GMT+03:00 2021 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "fcu"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fcu} property.
   * @see #getFcu
   * @see #setFcu
   */
  public static final Property fcu = newProperty(0, new BPxView(BOrd.make("module://fcuModule/com/bc/graphics/fcuDetail.px") ), null);
  
  /**
   * Get the {@code fcu} property.
   * @see #fcu
   */
  public BPxView getFcu() { return (BPxView)get(fcu); }
  
  /**
   * Set the {@code fcu} property.
   * @see #fcu
   */
  public void setFcu(BPxView v) { set(fcu, v, null); }

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
  public static final Property sourceName = newProperty(Flags.SUMMARY, BFormat.make("%time()% %parent.parent.displayName% %parent.displayName% Mode=%operation.out.value% HcMode=%hcMode.value% Sp=%PID.setpoint.value% Pv=%PID.controlledVariable.value% Fan=%speedInt.value%"), null);
  
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
  public static final Property homeOrd = newProperty(Flags.SUMMARY, BOrd.make("station:|slot:/Drivers"), null);
  
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
// Property "stopFanAtNonAction"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code stopFanAtNonAction} property.
   * @see #getStopFanAtNonAction
   * @see #setStopFanAtNonAction
   */
  public static final Property stopFanAtNonAction = newProperty(Flags.SUMMARY, new BStatusBoolean(true, BStatus.ok), null);
  
  /**
   * Get the {@code stopFanAtNonAction} property.
   * @see #stopFanAtNonAction
   */
  public BStatusBoolean getStopFanAtNonAction() { return (BStatusBoolean)get(stopFanAtNonAction); }
  
  /**
   * Set the {@code stopFanAtNonAction} property.
   * @see #stopFanAtNonAction
   */
  public void setStopFanAtNonAction(BStatusBoolean v) { set(stopFanAtNonAction, v, null); }

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
// Property "deadBand"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code deadBand} property.
   * @see #getDeadBand
   * @see #setDeadBand
   */
  public static final Property deadBand = newProperty(Flags.SUMMARY, new BStatusNumeric(0.5, BStatus.ok), null);
  
  /**
   * Get the {@code deadBand} property.
   * @see #deadBand
   */
  public BStatusNumeric getDeadBand() { return (BStatusNumeric)get(deadBand); }
  
  /**
   * Set the {@code deadBand} property.
   * @see #deadBand
   */
  public void setDeadBand(BStatusNumeric v) { set(deadBand, v, null); }

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
  public static final Property Speed1FB = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), null);
  
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
  public static final Property Speed2FB = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), null);
  
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
  public static final Property Speed3FB = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), null);
  
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
  public static final Property Speed1 = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), null);
  
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
  public static final Property Speed2 = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), null);
  
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
  public static final Property Speed3 = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), null);
  
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
// Property "fcuType"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code fcuType} property.
   * @see #getFcuType
   * @see #setFcuType
   */
  public static final Property fcuType = newProperty(Flags.SUMMARY, new BEnumWritable(), null);
  
  /**
   * Get the {@code fcuType} property.
   * @see #fcuType
   */
  public BEnumWritable getFcuType() { return (BEnumWritable)get(fcuType); }
  
  /**
   * Set the {@code fcuType} property.
   * @see #fcuType
   */
  public void setFcuType(BEnumWritable v) { set(fcuType, v, null); }

////////////////////////////////////////////////////////////////
// Property "operationLocal"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code operationLocal} property.
   * @see #getOperationLocal
   * @see #setOperationLocal
   */
  public static final Property operationLocal = newProperty(Flags.SUMMARY, new BStatusEnum(BFcuState.Off, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BFcuState.TYPE) ));
  
  /**
   * Get the {@code operationLocal} property.
   * @see #operationLocal
   */
  public BStatusEnum getOperationLocal() { return (BStatusEnum)get(operationLocal); }
  
  /**
   * Set the {@code operationLocal} property.
   * @see #operationLocal
   */
  public void setOperationLocal(BStatusEnum v) { set(operationLocal, v, null); }

////////////////////////////////////////////////////////////////
// Property "operationExtern"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code operationExtern} property.
   * @see #getOperationExtern
   * @see #setOperationExtern
   */
  public static final Property operationExtern = newProperty(Flags.SUMMARY, new BStatusEnum(BFcuState.Off, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BFcuState.TYPE) ));
  
  /**
   * Get the {@code operationExtern} property.
   * @see #operationExtern
   */
  public BStatusEnum getOperationExtern() { return (BStatusEnum)get(operationExtern); }
  
  /**
   * Set the {@code operationExtern} property.
   * @see #operationExtern
   */
  public void setOperationExtern(BStatusEnum v) { set(operationExtern, v, null); }

////////////////////////////////////////////////////////////////
// Property "operation"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code operation} property.
   * @see #getOperation
   * @see #setOperation
   */
  public static final Property operation = newProperty(Flags.SUMMARY, new BEnumWritable(), null);
  
  /**
   * Get the {@code operation} property.
   * @see #operation
   */
  public BEnumWritable getOperation() { return (BEnumWritable)get(operation); }
  
  /**
   * Set the {@code operation} property.
   * @see #operation
   */
  public void setOperation(BEnumWritable v) { set(operation, v, null); }

////////////////////////////////////////////////////////////////
// Property "hcMode"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code hcMode} property.
   * @see #getHcMode
   * @see #setHcMode
   */
  public static final Property hcMode = newProperty(Flags.SUMMARY, new BStatusEnum(BHc.Stop, BStatus.ok), BFacets.makeEnum( BEnumRange.make(BHc.TYPE) ));
  
  /**
   * Get the {@code hcMode} property.
   * @see #hcMode
   */
  public BStatusEnum getHcMode() { return (BStatusEnum)get(hcMode); }
  
  /**
   * Set the {@code hcMode} property.
   * @see #hcMode
   */
  public void setHcMode(BStatusEnum v) { set(hcMode, v, null); }

////////////////////////////////////////////////////////////////
// Property "valveCool"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code valveCool} property.
   * @see #getValveCool
   * @see #setValveCool
   */
  public static final Property valveCool = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ));
  
  /**
   * Get the {@code valveCool} property.
   * @see #valveCool
   */
  public BStatusBoolean getValveCool() { return (BStatusBoolean)get(valveCool); }
  
  /**
   * Set the {@code valveCool} property.
   * @see #valveCool
   */
  public void setValveCool(BStatusBoolean v) { set(valveCool, v, null); }

////////////////////////////////////////////////////////////////
// Property "valveHeat"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code valveHeat} property.
   * @see #getValveHeat
   * @see #setValveHeat
   */
  public static final Property valveHeat = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), BFacets.makeBoolean(  BString.make("Open"), BString.make("Close") ));
  
  /**
   * Get the {@code valveHeat} property.
   * @see #valveHeat
   */
  public BStatusBoolean getValveHeat() { return (BStatusBoolean)get(valveHeat); }
  
  /**
   * Set the {@code valveHeat} property.
   * @see #valveHeat
   */
  public void setValveHeat(BStatusBoolean v) { set(valveHeat, v, null); }

////////////////////////////////////////////////////////////////
// Property "executeTime"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code executeTime} property.
   * @see #getExecuteTime
   * @see #setExecuteTime
   */
  public static final Property executeTime = newProperty(Flags.SUMMARY, BRelTime.make(15000), BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE));
  
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
  public static final Property PID = newProperty(Flags.SUMMARY, new BPid(), null);
  
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
// Property "scheduleLocal"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code scheduleLocal} property.
   * @see #getScheduleLocal
   * @see #setScheduleLocal
   */
  public static final Property scheduleLocal = newProperty(Flags.SUMMARY, new BStatusBoolean(true, BStatus.ok), null);
  
  /**
   * Get the {@code scheduleLocal} property.
   * @see #scheduleLocal
   */
  public BStatusBoolean getScheduleLocal() { return (BStatusBoolean)get(scheduleLocal); }
  
  /**
   * Set the {@code scheduleLocal} property.
   * @see #scheduleLocal
   */
  public void setScheduleLocal(BStatusBoolean v) { set(scheduleLocal, v, null); }

////////////////////////////////////////////////////////////////
// Property "scheduleExtern"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code scheduleExtern} property.
   * @see #getScheduleExtern
   * @see #setScheduleExtern
   */
  public static final Property scheduleExtern = newProperty(Flags.SUMMARY, new BStatusBoolean(true, BStatus.ok), null);
  
  /**
   * Get the {@code scheduleExtern} property.
   * @see #scheduleExtern
   */
  public BStatusBoolean getScheduleExtern() { return (BStatusBoolean)get(scheduleExtern); }
  
  /**
   * Set the {@code scheduleExtern} property.
   * @see #scheduleExtern
   */
  public void setScheduleExtern(BStatusBoolean v) { set(scheduleExtern, v, null); }

////////////////////////////////////////////////////////////////
// Property "stateAlarm"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code stateAlarm} property.
   * @see #getStateAlarm
   * @see #setStateAlarm
   */
  public static final Property stateAlarm = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), null);
  
  /**
   * Get the {@code stateAlarm} property.
   * @see #stateAlarm
   */
  public BStatusBoolean getStateAlarm() { return (BStatusBoolean)get(stateAlarm); }
  
  /**
   * Set the {@code stateAlarm} property.
   * @see #stateAlarm
   */
  public void setStateAlarm(BStatusBoolean v) { set(stateAlarm, v, null); }

////////////////////////////////////////////////////////////////
// Property "alarmDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code alarmDelay} property.
   * @see #getAlarmDelay
   * @see #setAlarmDelay
   */
  public static final Property alarmDelay = newProperty(Flags.SUMMARY, BRelTime.make(10000), BFacets.make(BFacets.SHOW_MILLISECONDS, BBoolean.TRUE));
  
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
  public static final Property communicationError = newProperty(Flags.SUMMARY, new BStatusBoolean(false, BStatus.ok), null);
  
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
// Property "controlError"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code controlError} property.
   * @see #getControlError
   * @see #setControlError
   */
  public static final Property controlError = newProperty(Flags.SUMMARY, new BStatusEnum(BControlError.make(0), BStatus.ok), BFacets.makeEnum( BEnumRange.make(BControlError.TYPE) ));
  
  /**
   * Get the {@code controlError} property.
   * @see #controlError
   */
  public BStatusEnum getControlError() { return (BStatusEnum)get(controlError); }
  
  /**
   * Set the {@code controlError} property.
   * @see #controlError
   */
  public void setControlError(BStatusEnum v) { set(controlError, v, null); }

////////////////////////////////////////////////////////////////
// Property "deltaSpPv"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code deltaSpPv} property.
   * @see #getDeltaSpPv
   * @see #setDeltaSpPv
   */
  public static final Property deltaSpPv = newProperty(Flags.SUMMARY, new BStatusNumeric(1, BStatus.ok), null);
  
  /**
   * Get the {@code deltaSpPv} property.
   * @see #deltaSpPv
   */
  public BStatusNumeric getDeltaSpPv() { return (BStatusNumeric)get(deltaSpPv); }
  
  /**
   * Set the {@code deltaSpPv} property.
   * @see #deltaSpPv
   */
  public void setDeltaSpPv(BStatusNumeric v) { set(deltaSpPv, v, null); }

////////////////////////////////////////////////////////////////
// Property "enumSh"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code enumSh} property.
   * @see #getEnumSh
   * @see #setEnumSh
   */
  public static final Property enumSh = newProperty(Flags.SUMMARY, new BEnumSchedule(), null);
  
  /**
   * Get the {@code enumSh} property.
   * @see #enumSh
   */
  public BEnumSchedule getEnumSh() { return (BEnumSchedule)get(enumSh); }
  
  /**
   * Set the {@code enumSh} property.
   * @see #enumSh
   */
  public void setEnumSh(BEnumSchedule v) { set(enumSh, v, null); }

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
  public static final Action resetAlarm = newAction(Flags.HIDDEN, null);
  
  /**
   * Invoke the {@code resetAlarm} action.
   * @see #resetAlarm
   */
  public void resetAlarm() { invoke(resetAlarm, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFcu.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/






















// Начало пользовательских методов
public void started()    throws Exception
{                 
  super.started();


  // Установки енумераций BFcuState = Off, ManualSpeed1, ManualSpeed2, ManualSpeed3, Auto
  getEnumSh().setFacets(BFacets.makeEnum(BEnumRange.make(BFcuState.TYPE)) );
  getOperation().setFacets(BFacets.makeEnum(BEnumRange.make(BFcuState.TYPE)) );
  getFcuType().setFacets(BFacets.makeEnum(BEnumRange.make(BFcuType.TYPE)) );
  getPID().setFacets( BFacets.makeNumeric(3));
  //getSpeedInt().BFacets.makeNumeric(null,0,BNumber.make(0), BNumber.make(3));
  getOperation().getOut().setValue(BFcuState.make(0));
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
  alarm_ticket = Clock.schedule(this, getAlarmDelay(), setAlarm, null);
  //System.out.println("startAlarmTimer" );
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
  getStateAlarm().setValue(true);
}
public void doResetAlarm()  throws Exception
{
  getStateAlarm().setValue(false);
}
// Базовая часть алгоритма выбора скорости работы и переключения между нагревом/охлаждением
public void update() throws Exception  {

  int c = 0;
  updateStates();
  SPEED_INT = (int) Math.round(Math.abs(getPID().getOut().getValue()));
  
  c = (getOperation().getOut().getValue()).getOrdinal();
  
  //if(getScheduleLocalSelector().getValue()){ c = (getOperation().getOut().getValue()).getOrdinal();}// Internal scheduled
  //else{c = getOperationExt().getValue().getOrdinal(); getOperation().getOut().setValue(getOperationExt().getValue()); }// External scheduled
  
  //System.out.println(" c =  " + c + "fanSpeed" + fanSpeed );
    switch( c ){
      case 4 : // Operation Mode = Auto
        switchHcMode(true);
        // Устанавливаем скорость вентилятора равной значению ABS выхода регулятора если свойство getStopFanAtNonAction (останавливать вентилятор если выход регулятора близок к 0)
        if(getStopFanAtNonAction().getValue()){ getSpeedRequest().setValue(SPEED_INT); }
        else{
          if(SPEED_INT == 0){getSpeedRequest().setValue(1);} // Тут если требуется вентилятор продолжает работу когда регулятор говорит что он болтается возле 0
          else{getSpeedRequest().setValue(SPEED_INT);}
        }
      break;
      case 1  :   getSpeedRequest().setValue(1); switchHcMode(true);    break;
      case 2  :   getSpeedRequest().setValue(2); switchHcMode(true);    break;
      case 3  :   getSpeedRequest().setValue(3); switchHcMode(true);    break;
      case 0  :   getSpeedRequest().setValue(0); switchHcMode(false);   break;
    }
    switchSpeed();
    
    // Закрываем краны если вентилятор не работает
    /*if(getSpeedRequest() == 0){ fanSpeed
      getHcMode().setValue( BDynamicEnum.make(0) ); 
      getValveHeat().setValue(false);
      getValveCool().setValue(false); 
    }*/
//    String strMsg =    BAbsTime.make() + " " + getParent().getParent().getName() +":"+ getParent().getName()   + " Fancoil Unit " + "Mode = " + getOperation().getOut().getValue().toString() + " Sp = " + getPID().getSetpoint().getValue()+ " Pv = " + getPID().getControlledVariable().getValue() + " Fan Speed =  " + SPEED_INT  + " HC Mode = " + BHc.make(getHcMode().getValue().getOrdinal()) ;
    String strMsg =   getSourceName().format(this);

    set(BString.make(strMsg)); //
}
//  Переключение режимов работы
public void switchHcMode( boolean pid)   {
     getPID().getLoopEnable().setValue(pid);
    // Выход регулятора больше мертвого значения. Требуется нагрев
    if(getPID().getOut().getValue() > getDeadBand().getValue() ){
      getHcMode().setValue(BDynamicEnum.make(1)); 
      getValveHeat().setValue(true);
      getValveCool().setValue(false); 
    }
    // Выход регулятора меньше мертвого значения. Требуется охлаждение
    else if(getPID().getOut().getValue() < -getDeadBand().getValue() ){
      getHcMode().setValue(BDynamicEnum.make(-1)); 
      getValveHeat().setValue(false);
      getValveCool().setValue(true); 
    }
    // Выход регулятора внутри мертвого диапазона. Закрываем холодный и горячий кран вентилятор будет крутится на минимальной скорости или 
    //остановится в зависимости от значения параметра 
    else{
      getHcMode().setValue(BDynamicEnum.make(0)); 
      getValveHeat().setValue(false);
      getValveCool().setValue(false); 
    }
}
//  Переключение скоростей  
public void switchSpeed()  {

  if(getSpeedRequest().getValue() == getCurrentSpeed() && getCurrentSpeed() == getSpeed()) {  return;} //
  if( (getSpeedRequest().getValue()  != getCurrentSpeed())  && (getCurrentSpeed() != 0)   )  { setSpeed(0);  return;} // Update Speed Coming
  if( getSpeedRequest().getValue()  !=0 && getCurrentSpeed()==0   )  { setSpeed((int)getSpeedRequest().getValue() ); return;} // Zero Speed Coming->setReuest Speed
  
  if( getSpeed() != getCurrentSpeed()  )  { setSpeed(0 ); return; } // Если система подвисла в каком либо положении 
}
// Запрс текущей скорости по фидбекам
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
// Запрс текущей скорости
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
// update запускается по таймеру.  Но для того что бы не ждать обновления долго при изменении режима работы или уставки - происходит мгновенное обновление
public void changed(Property p, Context cx)   {
  if(!isRunning())  return; // should never get here, but return if we do.
  super.changed(p, cx);
  
  
  try {update();
  

  if( p == operationExtern || p == scheduleExtern){ if ( getScheduleExtern().getValue() ) getOperation().set(getOperationExtern().getValue());} // getOperation().getOut().setValue(getOperationExtern().getValue());
  if( p == operationLocal || p == scheduleLocal){ if ( getScheduleLocal().getValue() )getOperation().set(getOperationLocal().getValue());} // getOperation().getOut().setValue(getOperationLocal().getValue());
  if( p == fcuType){System.out.println(" Change fcu Type!!!! =  " + getFcuType().getOut().getValue() ); }
  
  }
  catch(Exception ie) {System.out.println("Call changed " + ie);}
}
// обновляем статусы необходимые для отображения
public void updateStates( )  {
  
  if((getSpeed1().getValue() != getSpeed1FB().getValue()) || (getSpeed2().getValue() != getSpeed2FB().getValue()) || (getSpeed3().getValue() != getSpeed3FB().getValue()) ){startAlarmTimer();}
  else{stopAlarmTimer();
      try{doResetAlarm();}
      catch (Exception ie) {
        System.out.println("doResetAlarm Exeption" );
      }
    }
  
  // раскрашиваем поля для отображения выхода за пределы регулирования
  if(
      ((getPID().getControlledVariable().getValue() - getPID().getSetpoint().getValue()) >  getDeltaSpPv().getValue()) &&
      ( (getOperation().getOut().getValue()).getOrdinal() != 0 )
    )  // Температура регулирования больше уставки на значение deltaSpPv и система в работе
      {      getControlError().setValue(BDynamicEnum.make(1));     }
  else if ( ((getPID().getSetpoint().getValue() - getPID().getControlledVariable().getValue() )  >   getDeltaSpPv().getValue() ) &&
      ((getOperation().getOut().getValue()).getOrdinal() != 0 ))
      // Температура регулирования меньше уставки на значение deltaSpPv и система в работе
    {  getControlError().setValue(BDynamicEnum.make(2)); }
  else{ // Температура регулирования в дипазоне или система отключена
       getControlError().setValue(BDynamicEnum.make(0));
  }
  if( getPID().getControlledVariable().getStatus().isDown() || getPID().getControlledVariable().getStatus().isStale() || getPID().getControlledVariable().getStatus().isOverridden() || getPID().getControlledVariable().getStatus().isFault()){ getCommunicationError().setValue(true);}
  else{getCommunicationError().setValue(false);}
  //getPID().getSetpoint().getStatus().isDown());
}

// Глобальные переменные
public Clock.Ticket ticket;
public Clock.Ticket alarm_ticket;
private static int SPEED_INT;

}
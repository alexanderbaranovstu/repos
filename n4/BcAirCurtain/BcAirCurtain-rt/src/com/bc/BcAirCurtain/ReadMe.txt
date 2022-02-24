
Модуль BcAirCurtain управления воздушными электрическими завесами представляет собой программу управления со следующими слотами
-Выходы
1.3 Ступени скорости вентилятора
2.2 Ступени нагрева
3. Выход "Работа разрешена" - когда контроллер подает в схему управления напряжение питания. Необходимо для отключения по аварии 
работающей в ручном или автоматическом режиме установки

-Входы
1. Температура до завесы
2. Температура после завесы
3. Термоконтакт вентилятора
4. Термоконтакт тенов
5. Положение 5ти ступенчатого переключателя 

Машина состояний агрегата определена следующими состояниями
ManOff
ManS1
ManS2
ManS3
AutoOff
Speed1HeatAuto
Speed2HeatAuto
Speed3HeatAuto
SpeedHeatAuto
Alarm
Схемотехнически для ручного режима работы реализовано 3 скорости вентилятора + 2 ступени нагрева
1я Скорость вентилятора + 1я ступень нагрева
2я Скорость вентилятора + 2я ступень нагрева
3я Скорость вентилятора + 1я ступень нагрева + 2я ступень нагрева
В автоматическом режиме все определяется уставкой и выбранным автоматическим режимом работы.
Одной из особенностей работы программного модуля является наличие обратной связи от выходов вентиляторов.
Что бы предотвратить одновременное включение нескольких скоростей, включение скорости производится только при отсутствии обратной связи 
о работе другой. В случае появления аварийного сигнала система останавливается, отключается вентиляторы и нагрев, снимается управляющее 
напряжение. Сброс аврии осуществляется либо Action "ResetAlarm" либо переходом через 0 ручного переключателя по месту

Избежание частых переключений нагрева/скоростей
Для этого в модуле предусмотрено 2 таймера. Один - раз в 10 мин для переключений, другой - раз в 1 сек для обработки пид регулятора







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




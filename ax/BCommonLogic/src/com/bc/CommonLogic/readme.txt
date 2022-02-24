2.1 - 17.11.2021  -       Добавлен класс BCutMessage.java для ограничения отсылок в сеть KNX для того что бы 
                          задать величину и периодичность при которой изменение будет отправлено в сеть KNX
                          В модуль добавлен класс BDimOneButton. В нем реализовано диммирование одной кнопкой.
                          В классах BBlindControl и BSlideControl и BIsmaDaliLamp свойство openIn и closeIn openCommand closeCommand daliOn daliOff
                          типа BStatusBoolean заменено типом BBoolean, для того что 
                          бы убрать реагирование модуля на изменение статуса в методе public void changed(Property p, Context cx) 
                          Это приводило ранее к тому что потеря связи с источником команды вследствии Stale|Fail|Down вызывала закрытие
                          штор, моргание света
  
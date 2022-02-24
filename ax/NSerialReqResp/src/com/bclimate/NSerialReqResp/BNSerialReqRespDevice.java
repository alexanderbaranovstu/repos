/**
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp;

import javax.baja.driver.util.BPollFrequency;
import javax.baja.status.BStatus;
import javax.baja.sys.*;

import com.tridium.ndriver.BNDevice;
import com.tridium.ndriver.poll.BINPollable;
import com.tridium.ndriver.util.SfUtil;

import com.bclimate.NSerialReqResp.comm.*;
import com.bclimate.NSerialReqResp.point.*;
import  com.bclimate.NSerialReqResp.message.*;

import com.tridium.ndriver.comm.*;

/**
 *  BNSerialReqRespDevice models a single device
 *
 *  @author   MS
 *  @creation 13 апр 2021 
 */
public class BNSerialReqRespDevice
  extends BNDevice
  implements BINPollable
{
  
  // Add facet to include following in auto manager view
  public static final Property status = newProperty(Flags.TRANSIENT|Flags.READONLY|Flags.SUMMARY|Flags.DEFAULT_ON_CLONE, BStatus.ok, SfUtil.incl(SfUtil.MGR_EDIT_READONLY));

  /*-
  class BNSerialReqRespDevice
  {
    properties
    {
      address: int flags { SUMMARY } default {[ 0 ]}
      unitStatus: BString flags { SUMMARY,READONLY }  default{[ BString.make("N/A") ]}
      position: int flags { SUMMARY,READONLY } default {[ 0 ]}
      pollFrequency : BPollFrequency
        --How frequently the device is polled for data
        default {[ BPollFrequency.normal ]}
      --nMessage : NSerialReqRespMessage default {[ new NSerialReqRespMessage() ]}   
      --points : BNSerialReqRespPointDeviceExt        default {[ new BNSerialReqRespPointDeviceExt() ]}
      
    }
    actions
    {
      cmdUp()     
      cmdDown()
      cmdStop()
      cmdSetPersent(arg:  BDouble  )                      default {[ BDouble.make(0.0) ]}
      cmdPosition()
                                      
    }
    topics
    {
      
    }
  }
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bclimate.NSerialReqResp.BNSerialReqRespDevice(3337242980)1.0$ @*/
/* Generated Tue Jun 22 10:55:32 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "address"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>address</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#getAddress
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#setAddress
   */
  public static final Property address = newProperty(Flags.SUMMARY, 0,null);
  
  /**
   * Get the <code>address</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#address
   */
  public int getAddress() { return getInt(address); }
  
  /**
   * Set the <code>address</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#address
   */
  public void setAddress(int v) { setInt(address,v,null); }

////////////////////////////////////////////////////////////////
// Property "unitStatus"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>unitStatus</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#getUnitStatus
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#setUnitStatus
   */
  public static final Property unitStatus = newProperty(Flags.SUMMARY|Flags.READONLY, ((BString)(BString.make("N/A"))).getString(),null);
  
  /**
   * Get the <code>unitStatus</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#unitStatus
   */
  public String getUnitStatus() { return getString(unitStatus); }
  
  /**
   * Set the <code>unitStatus</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#unitStatus
   */
  public void setUnitStatus(String v) { setString(unitStatus,v,null); }

////////////////////////////////////////////////////////////////
// Property "position"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>position</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#getPosition
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#setPosition
   */
  public static final Property position = newProperty(Flags.SUMMARY|Flags.READONLY, 0,null);
  
  /**
   * Get the <code>position</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#position
   */
  public int getPosition() { return getInt(position); }
  
  /**
   * Set the <code>position</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#position
   */
  public void setPosition(int v) { setInt(position,v,null); }

////////////////////////////////////////////////////////////////
// Property "pollFrequency"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#getPollFrequency
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#setPollFrequency
   */
  public static final Property pollFrequency = newProperty(0, BPollFrequency.normal,null);
  
  /**
   * Get the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#pollFrequency
   */
  public BPollFrequency getPollFrequency() { return (BPollFrequency)get(pollFrequency); }
  
  /**
   * Set the <code>pollFrequency</code> property.
   * How frequently the device is polled for data
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#pollFrequency
   */
  public void setPollFrequency(BPollFrequency v) { set(pollFrequency,v,null); }

////////////////////////////////////////////////////////////////
// Action "cmdUp"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cmdUp</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdUp()
   */
  public static final Action cmdUp = newAction(0,null);
  
  /**
   * Invoke the <code>cmdUp</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdUp
   */
  public void cmdUp() { invoke(cmdUp,null,null); }

////////////////////////////////////////////////////////////////
// Action "cmdDown"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cmdDown</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdDown()
   */
  public static final Action cmdDown = newAction(0,null);
  
  /**
   * Invoke the <code>cmdDown</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdDown
   */
  public void cmdDown() { invoke(cmdDown,null,null); }

////////////////////////////////////////////////////////////////
// Action "cmdStop"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cmdStop</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdStop()
   */
  public static final Action cmdStop = newAction(0,null);
  
  /**
   * Invoke the <code>cmdStop</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdStop
   */
  public void cmdStop() { invoke(cmdStop,null,null); }

////////////////////////////////////////////////////////////////
// Action "cmdSetPersent"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cmdSetPersent</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdSetPersent()
   */
  public static final Action cmdSetPersent = newAction(0,BDouble.make(0.0),null);
  
  /**
   * Invoke the <code>cmdSetPersent</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdSetPersent
   */
  public void cmdSetPersent(BDouble arg) { invoke(cmdSetPersent,arg,null); }

////////////////////////////////////////////////////////////////
// Action "cmdPosition"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>cmdPosition</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdPosition()
   */
  public static final Action cmdPosition = newAction(0,null);
  
  /**
   * Invoke the <code>cmdPosition</code> action.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespDevice#cmdPosition
   */
  public void cmdPosition() { invoke(cmdPosition,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNSerialReqRespDevice.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  
////////////////////////////////////////////////////////////////
// Overrides
////////////////////////////////////////////////////////////////
  
  /**
   * Returns the network type that the device runs on.
   * @return Type object representing the network
   */
  public Type getNetworkType() { return BNSerialReqRespNetwork.TYPE; }  
  
  
  /**
   * Override started 
   */
  public void started()
    throws Exception
  {
    super.started();
    
    // register device with poll scheduler 
    getNSerialReqRespNetwork().getPollScheduler().subscribe(this);
  }
  
  /**
   * Override stopped 
   */
  public void stopped()
    throws Exception
  {
    // unregister device with poll scheduler 
    getNSerialReqRespNetwork().getPollScheduler().unsubscribe(this);
    super.stopped();
  }
  
  
////////////////////////////////////////////////////////////////
// Implementation
////////////////////////////////////////////////////////////////
  /**
   * 
   */
  public void doPing() 
  
  { 
    // TODO - add ping implementation
    doCmdPosition();
    pingOk();
    // if(getPosition() != -1)
    //  pingOk();
    // else
    //  pingFail("not receiving response from device ");
  }
  

////////////////////////////////////////////////////////////////
// Polling support
////////////////////////////////////////////////////////////////

  /**
   * The poll() callback method called from BPollScheduler
   * when it is time to poll this object.
   */
  public void doPoll()
  {

           
  }
// Команды 2 - открытие, 3 стоп, 4 закрытие, 6 - запрос положения  
// Команда открытия
public void doCmdUp()
{
    sendComd((byte)getAddress(),(byte)2);
}
// Команда закрытия
public void doCmdDown(){
    sendComd((byte)getAddress(),(byte)4);
}

// Команда стоп
public void doCmdStop()
{
    sendComd((byte)getAddress(),(byte)3); 
}   

// Команда задать положение
public void doCmdSetPersent(BDouble a)
{
    int b = a.getInt () ;
    sendComd((byte)getAddress(),(byte)(128+(byte)b)); 
}   
// Команда запросить положение
public void doCmdPosition()
{
  
    sendComd((byte)getAddress(),(byte)6); 
}  
   
    
      
////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////
  /**
   * Get the network cast to a BNSerialReqRespNetwork.
   * @return network as a BNSerialReqRespNetwork.
   */
  public final BNSerialReqRespNetwork getNSerialReqRespNetwork()
  {
    return (BNSerialReqRespNetwork)getNetwork();
  }

public void sendComd(byte addr, byte cmd){
//NSerialReqRespMessage nMsg = new NSerialReqRespMessage();  
 try{
       nMsg.BOS[0] = (byte)0x81;
       nMsg.BOS[1] = 0;
       nMsg.BOS[2] = 0;
       nMsg.BOS[3] = 1;    
       nMsg.BOS[4] = (byte)getAddress();       
       nMsg.BOS[5] = cmd;     //слово управления 
       nMsg.BOS[6] = (byte)(nMsg.BOS[0] + (byte)nMsg.BOS[1 ]* 2 + nMsg.BOS[2] * 3 + nMsg.BOS[3] * 4 + nMsg.BOS[4] * 5 + nMsg.BOS[5] * 6);     //контрольная сумма           
       nMsg.resetBIS();
       getNSerialReqRespNetwork().scomm().sendMessage(nMsg);
       // проверяем ответ надо сюда вывести тупо system out print ln
       //System.out.println("Before nMsg.BIS[0] " + (byte)nMsg.BIS[0] + " nMsg.BIS[1] " + (byte)nMsg.BIS[1 ] + " nMsg.BIS[2] " + nMsg.BIS[2] +" nMsg.BIS[3] " + nMsg.BIS[3]  + " nMsg.BIS[4] " + nMsg.BIS[4] + " nMsg.BIS[5] " + nMsg.BIS[5] );
       try  {      Thread.sleep(getNSerialReqRespNetwork(). getBufferDelay());    } catch (InterruptedException ie) { }
       //System.out.println("After nMsg.BIS[0] " + (byte)nMsg.BIS[0] + " nMsg.BIS[1] " + (byte)nMsg.BIS[1 ] + " nMsg.BIS[2] " + nMsg.BIS[2] +" nMsg.BIS[3] " + nMsg.BIS[3]  + " nMsg.BIS[4] " + nMsg.BIS[4] + " nMsg.BIS[5] " + nMsg.BIS[5] );

       if(  nMsg.BIS[6] != 0 && nMsg.BIS[6] == (byte)(nMsg.BIS[0] + (byte)nMsg.BIS[1 ]* 2 + nMsg.BIS[2] * 3 + nMsg.BIS[3] * 4 + nMsg.BIS[4] * 5 + nMsg.BIS[5] * 6)){
              
                System.out.println("CheckSumOK  nMsg.BIS[0] " + (byte)nMsg.BIS[0] + " nMsg.BIS[1] " + (byte)nMsg.BIS[1 ] + " nMsg.BIS[2] " + nMsg.BIS[2] +" nMsg.BIS[3] " + nMsg.BIS[3]  + " nMsg.BIS[4] " + nMsg.BIS[4] + " nMsg.BIS[5] " + nMsg.BIS[5] + " nMsg.BIS[6] " + nMsg.BIS[6] );

            if(cmd == 6){//была запрошена позиция
              if(nMsg.BIS[5] >= 0 || nMsg.BIS[5] <=100  ){ setPosition(nMsg.BIS[5]); setUnitStatus("Normal Operation"); }
              else if (nMsg.BIS[5] == 0xAA) {setPosition(-1); setUnitStatus("Bad travel");} //штора плохо движется
              else if (nMsg.BIS[5] == 0xBB) {setPosition(-1); setUnitStatus("Motor Locked");} //штора заклинена
              else{setPosition(-1); setUnitStatus("N/A State");} // Не понятное состояние
            }
            // тут еще поработать надо над положением потому что пока штора едет то сое текущее положение меняет... и что она там обратно вернет не сосем понятно....
       }
       else{ // 
          setPosition(-1); setUnitStatus("N/A State");
       }
       //System.out.println( getNSerialReqRespNetwork().getSerialConfig().getLinkMessageFactory().getByteArray() );
    }
    catch(Exception x ){
      System.out.println( "doCmdUp Exception " +  x );
    }        
}
//private void procesResponse(byte[] req, byte[] resp){
  
//}

public static  NSerialReqRespMessage nMsg = new NSerialReqRespMessage();

}

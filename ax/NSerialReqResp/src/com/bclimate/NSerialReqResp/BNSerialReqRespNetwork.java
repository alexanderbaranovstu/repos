/**
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp;

//import javax.baja.license.Feature;
import javax.baja.naming.BOrd;
import javax.baja.sys.*;
import javax.baja.util.Lexicon;

import com.tridium.ndriver.BNNetwork;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.discover.*;
import com.tridium.ndriver.poll.*;
import com.bclimate.NSerialReqResp.comm.BNSerialReqRespSerialCommConfig;



/**
 *  BNSerialReqRespNetwork models a network of devices
 *
 *  @author   MS
 *  @creation 13 апр 2021 
 */
public class BNSerialReqRespNetwork 
  extends BNNetwork
{
  
  /*-
    class BNSerialReqRespNetwork
    {
      properties
      {
        pollScheduler :  BNPollScheduler
          default {[ new BNPollScheduler() ]}
        serialConfig : BNSerialReqRespSerialCommConfig
          default {[ new BNSerialReqRespSerialCommConfig() ]}
        bufferDelay : BInteger   default {[ BInteger.make(500) ]}
      }
    }
   -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bclimate.NSerialReqResp.BNSerialReqRespNetwork(2059127421)1.0$ @*/
/* Generated Thu Jun 24 07:30:14 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Property "pollScheduler"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>pollScheduler</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#getPollScheduler
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#setPollScheduler
   */
  public static final Property pollScheduler = newProperty(0, new BNPollScheduler(),null);
  
  /**
   * Get the <code>pollScheduler</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#pollScheduler
   */
  public BNPollScheduler getPollScheduler() { return (BNPollScheduler)get(pollScheduler); }
  
  /**
   * Set the <code>pollScheduler</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#pollScheduler
   */
  public void setPollScheduler(BNPollScheduler v) { set(pollScheduler,v,null); }

////////////////////////////////////////////////////////////////
// Property "serialConfig"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>serialConfig</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#getSerialConfig
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#setSerialConfig
   */
  public static final Property serialConfig = newProperty(0, new BNSerialReqRespSerialCommConfig(),null);
  
  /**
   * Get the <code>serialConfig</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#serialConfig
   */
  public BNSerialReqRespSerialCommConfig getSerialConfig() { return (BNSerialReqRespSerialCommConfig)get(serialConfig); }
  
  /**
   * Set the <code>serialConfig</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#serialConfig
   */
  public void setSerialConfig(BNSerialReqRespSerialCommConfig v) { set(serialConfig,v,null); }

////////////////////////////////////////////////////////////////
// Property "bufferDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>bufferDelay</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#getBufferDelay
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#setBufferDelay
   */
  public static final Property bufferDelay = newProperty(0, ((BInteger)(BInteger.make(500))).getInt(),null);
  
  /**
   * Get the <code>bufferDelay</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#bufferDelay
   */
  public int getBufferDelay() { return getInt(bufferDelay); }
  
  /**
   * Set the <code>bufferDelay</code> property.
   * @see com.bclimate.NSerialReqResp.BNSerialReqRespNetwork#bufferDelay
   */
  public void setBufferDelay(int v) { setInt(bufferDelay,v,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNSerialReqRespNetwork.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  
  
  
   

  /** Specify name for network resources. */
  public String getNetworkName() { return "NSerialReqRespNetwork"; }

  /** return device folder type  */
  public Type getDeviceFolderType()
  {
    return BNSerialReqRespDeviceFolder.TYPE;
  }

  /** return device type */
  public Type getDeviceType()
  {
    return BNSerialReqRespDevice.TYPE;
  }
  
  /** TODO - Add license check if needed
  public final Feature getLicenseFeature()
  {
    return Sys.getLicenseManager().getFeature("?? vendor", "?? feature");
  }
  */
  
////////////////////////////////////////////////////////////////
//Utilities
////////////////////////////////////////////////////////////////
  
  
  
   
   /**Access the serial comm stack */
  public NComm scomm()
  {
    return (NComm)getSerialConfig().comm();
  }
  
  
  public static Lexicon LEX = Lexicon.make(BNSerialReqRespNetwork.class);

}

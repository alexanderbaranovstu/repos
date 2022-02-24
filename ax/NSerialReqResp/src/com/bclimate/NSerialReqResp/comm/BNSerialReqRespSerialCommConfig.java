/**
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp.comm;

import javax.baja.sys.Sys;
import javax.baja.sys.Type;

import com.tridium.ndriver.comm.IMessageFactory;
import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.comm.NLinkMessageFactory;
import com.tridium.ndriver.datatypes.BSerialCommConfig;

import com.bclimate.NSerialReqResp.message.NSerialReqRespMessageFactory;

/**
 * BNSerialReqRespSerialCommConfig Handles the serial communication for the driver. 
 *
 * @author   MS
 * @creation 13 апр 2021 
 *
 */
public class BNSerialReqRespSerialCommConfig
  extends BSerialCommConfig
{
  /*-
  class BNSerialReqRespSerialCommConfig
  {
    properties
    {
    }
  }
 -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bclimate.NSerialReqResp.comm.BNSerialReqRespSerialCommConfig(1697765737)1.0$ @*/
/* Generated Tue Apr 13 11:34:18 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNSerialReqRespSerialCommConfig.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /** Empty constructor  */
  public BNSerialReqRespSerialCommConfig() {  }
  
//  /** Override to configure the maximum number of request messages that can
//   *  be outstanding at the same time.  Default implementation returns 32. */
  public int getMaxOutstandingTransactions() { return 1; }

  /** Provide custom LinkMessage factory.   */
  protected NLinkMessageFactory makeLinkMessageFactory()  
  {    
    // link message factory must create
    return new NLinkMessageFactory(1024)
      {
        protected LinkMessage createLinkMessage()
        {
          return new NSerialReqRespLinkMessage(1024); 
        }
      };
  }
  
  /** Provide custom Message factory.   */
  protected IMessageFactory makeMessageFactory()
  {
    return new NSerialReqRespMessageFactory();
  }
  
}

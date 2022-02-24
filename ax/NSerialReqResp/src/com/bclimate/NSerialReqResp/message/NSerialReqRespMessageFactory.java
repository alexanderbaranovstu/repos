/**
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp.message;

import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.io.*; 

/**
 * NSerialReqRespMessageFactory implementation of IMessageFactory.
 *
 * @author   MS
 * @creation 13 апр 2021 
 */
public class NSerialReqRespMessageFactory
  implements IMessageFactory
{
  
  public NSerialReqRespMessageFactory() {}
  
  public NMessage makeMessage(LinkMessage lm) 
      throws Exception
  {
      TypedInputStream tin = new TypedInputStream(lm.getByteArray());
      NSerialReqRespMessage msg = new NSerialReqRespMessage();
      msg.fromInputStream(tin);
      
      
      //System.out.println("LinkMessage lm LEN = " + lm.getLength () );
      return (NMessage)msg;
     //return null;
  }




}

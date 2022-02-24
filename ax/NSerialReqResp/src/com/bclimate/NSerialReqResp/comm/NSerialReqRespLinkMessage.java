/**
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp.comm;

import java.io.*;
import com.bclimate.NSerialReqResp.message.*;

import com.tridium.ndriver.comm.LinkMessage;
import com.tridium.ndriver.io.TypedInputStream;

/**
 * NSerialReqRespLinkMessage streams data to and from a byte array representation.
 *
 * @author   MS
 * @creation 13 апр 2021 
 */
public class NSerialReqRespLinkMessage
    extends LinkMessage
{
  public NSerialReqRespLinkMessage(int maxLen)  { super(maxLen); }
  
  /** 
   * Get byte data from inputStream.
   *  return true if complete message received 
   */
  public boolean receive(InputStream in)
    throws Exception
{
    OutputStream os = getOutputStream();
    int b = in.read();
    if(b == -1 )return false;

    int i=0;
    // TODO add code to detect beginning and end of message in serial stream.
    while (b != -1) {
      os.write(b);
      //System.out.println( "NSlave incoming message " +  b );
      b = in.read();
      i++;
    }
    // 
    // after start byte detected write following bytes to buffer[] until
    //  end of message
    return true;
 
}
  
////////////////////////////////////////////////////////////////
//Handle outgoing messages
////////////////////////////////////////////////////////////////

// TODO customize handling of outgoing messages if needed
//  /** Translate data from app message to link message representation */
//  public boolean setMessage(NMessage msg)
//    throws Exception
//  {
//
//  }




}
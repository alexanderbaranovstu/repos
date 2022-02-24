/*
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp;

import javax.baja.sys.*;

import com.tridium.ndriver.BNDeviceFolder;

/**
 * BNSerialReqRespDeviceFolder is a folder for BNSerialReqRespDevice.
 *
 *  @author   MS
 *  @creation 13 апр 2021 
 */
public class BNSerialReqRespDeviceFolder
  extends BNDeviceFolder
{                       
/*-
  class BNSerialReqRespDeviceFolder
  {
    properties
    {
    }
  }
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bclimate.NSerialReqResp.BNSerialReqRespDeviceFolder(4294261386)1.0$ @*/
/* Generated Tue Apr 13 11:34:18 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNSerialReqRespDeviceFolder.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BNSerialReqRespNetwork.
   * @return network as a BNSerialReqRespNetwork.
   */
  public final BNSerialReqRespNetwork getNSerialReqRespNetwork()
  {
    return (BNSerialReqRespNetwork)getNetwork();
  }
  
  /**
   * @return true if parent is BNSerialReqRespNetwork or BNSerialReqRespDeviceFolder.
   */
  public boolean isParentLegal(BComponent parent)
  {
    return parent instanceof BNSerialReqRespNetwork ||
           parent instanceof BNSerialReqRespDeviceFolder;
  }


}

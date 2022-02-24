/**
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp.point;

import javax.baja.sys.*;
import javax.baja.driver.point.*;

import com.bclimate.NSerialReqResp.*;

/**
 * BNSerialReqRespPointFolder
 *
 * @author   MS
 * @creation 13 апр 2021  
 */
public class BNSerialReqRespPointFolder
  extends BPointFolder
{            
  /*-
  class BNSerialReqRespPointFolder
  {
    properties
    {
    }
  }
 -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bclimate.NSerialReqResp.point.BNSerialReqRespPointFolder(2311944889)1.0$ @*/
/* Generated Tue Apr 13 11:34:18 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNSerialReqRespPointFolder.class);

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
   * Get the device cast to a BNSerialReqRespDevice.
   * @return device as a BNSerialReqRespDevice.
   */
  public final BNSerialReqRespDevice getNSerialReqRespDevice()
  {
    return (BNSerialReqRespDevice)getDevice();
  }

}

/**
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp.point;

import javax.baja.sys.*;
import javax.baja.agent.AgentList;
import javax.baja.driver.point.BPointDeviceExt;
import com.tridium.ndriver.util.AgentInfoUtil;

import com.bclimate.NSerialReqResp.*;

/**
 * BNSerialReqRespPointDeviceExt is a container for NSerialReqResp proxy points.
 *
 * @author   MS
 * @creation 13 апр 2021 
 */
public class BNSerialReqRespPointDeviceExt
  extends BPointDeviceExt 
{            

  /*-
    class BNSerialReqRespPointDeviceExt
    {
      properties
      {
      }
    }
   -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bclimate.NSerialReqResp.point.BNSerialReqRespPointDeviceExt(3061647962)1.0$ @*/
/* Generated Tue Apr 13 11:34:18 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNSerialReqRespPointDeviceExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /**
   * Adds BNPointManager and renames.
   *
   * @see NAgentInfo.getAgentsHelp
   */
  public AgentList getAgents(Context cx)
  {
    AgentList agents = super.getAgents(cx);
    agents.add("ndriver:NPointManager");

    return AgentInfoUtil.getAgentsHelp(
        agents,
        getType().getTypeInfo().getModuleName(),
        "driver:PointManager",
        "PointManager",
        "Point Manager");
  }

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

////////////////////////////////////////////////////////////////
// PointDeviceExt
////////////////////////////////////////////////////////////////
  
  /**
   * @return the Device type.
   */
  public Type getDeviceType()
  {
    return BNSerialReqRespDevice.TYPE;
  }

  /**
   * @return the PointFolder type.
   */
  public Type getPointFolderType()
  {
    return BNSerialReqRespPointFolder.TYPE;
  }
  
  /**
   * @return the ProxyExt type.
   */
  public Type getProxyExtType()
  {
    return BNSerialReqRespProxyExt.TYPE;
  }
  
}

/**
 * Copyright 2021 bclimate, Inc. All Rights Reserved.
 */
package com.bclimate.NSerialReqResp.point;

import javax.baja.sys.*;
import java.io.*;

import javax.baja.status.*;
import javax.baja.control.util.*;
import javax.baja.driver.point.*; 
import com.tridium.ndriver.io.*;

import com.bclimate.NSerialReqResp.*;
import com.bclimate.NSerialReqResp.message.*;
import com.bclimate.NSerialReqResp.comm.*;

import com.tridium.driver.util.DrUtil;
import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.io.*;

import com.bclimate.NSerialReqResp.message.*;

/**
 * BNSerialReqRespProxyExt
 *
 *  @author   MS
 * @creation 13 апр 2021 
 */
public class BNSerialReqRespProxyExt
  extends BProxyExt
{   
  
  // Override ProxyExt default status to clear stale state.
  // public static final Property status = newProperty(Flags.READONLY|Flags.TRANSIENT, BStatus.ok, null);
  

  /*-             
  
  class BNSerialReqRespProxyExt
  {
    properties
    {    
        
    }
  }
  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bclimate.NSerialReqResp.point.BNSerialReqRespProxyExt(1367293779)1.0$ @*/
/* Generated Tue Apr 13 11:34:18 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BNSerialReqRespProxyExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  
////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////
  
  /**
   * Get the network cast to a BNSerialReqRespNetwork.
   */
  public final BNSerialReqRespNetwork getNSerialReqRespNetwork()
  {
    return (BNSerialReqRespNetwork)getNetwork();
  }

  /**
   * Get the device cast to a BNSerialReqRespDevice.
   */
  public final BNSerialReqRespDevice getBNSerialReqRespDevice()
  {
    return (BNSerialReqRespDevice)DrUtil.getParent(this, BNSerialReqRespDevice.TYPE);
  }

  /**
   * Get the point device ext cast to a BNSerialReqRespPointDeviceExt.
   */
  public final BNSerialReqRespPointDeviceExt getNSerialReqRespPointDeviceExt()
  {
    return (BNSerialReqRespPointDeviceExt)getDeviceExt();
  }
  
////////////////////////////////////////////////////////////////
// ProxyExt
////////////////////////////////////////////////////////////////
  public void readSubscribed(Context cx)
    throws Exception
  {
    // TODO
    System.out.println( "readSubscribed" +  cx );
    //NSerialReqRespMessage nm = new NSerialReqRespMessage();

    //BStatusString bs = new BStatusString("readUnsubscribed", BStatus.ok);
    //setReadValue(bs);
    //getParent().asComponent().invoke ( getParent().getAction("override"), new BStringOverride("ddddddddddddd") ); //getAction  
  }
  
  public void readUnsubscribed(Context cx)
    throws Exception
  {
     // TODO
     System.out.println( "readUnsubscribed" +  cx );
    //     BStatusString bs = new BStatusString("readUnsubscribed", BStatus.ok);
    ///setReadValue(bs);
  }
  
  public boolean write(Context cx)
    throws Exception
  {

    
    
    NSerialReqRespMessage nMsg = new NSerialReqRespMessage();
    //NSerialReqRespMessage nMsgResp = new NSerialReqRespMessage();
    //NSerialReqRespListener Listener = new NSerialReqRespListener(getNSerialReqRespNetwork().getSerialConfig()); 
    //NSerialReqRespFilter nf= new NSerialReqRespFilter(nMsgResp);
    try{
 
       //getNSerialReqRespNetwork().scomm().registerCommListener(Listener ,nf,true);
       //nMsgResp = (NSerialReqRespMessage)
       getNSerialReqRespNetwork().scomm().sendMessage(nMsg);
       //System.out.println( getNSerialReqRespNetwork().getSerialConfig().getLinkMessageFactory().getByteArray() );
 
       readOk(getWriteValue());
    }
    catch(Exception x ){
      System.out.println( "doSendCmd" +  x );
    }    
    return false; // лучше если это будет false потому что если true по вроде как пакет сегментированный
  }
  
  /**
   * Return the device type. 
   */
  public Type getDeviceExtType()
  {
    return BNSerialReqRespPointDeviceExt.TYPE;
  }                     
  
  /**
   * Return the read/write mode of this proxy.
   */
  public BReadWriteMode getMode()
  {
    // TODO
    //return BReadWriteMode.readonly; readWrite 
    return BReadWriteMode.readWrite; 
  }                        
  
  public boolean isBoolean()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusBoolean;
  }
  
  public boolean isNumeric()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusNumeric;
  }
  
  public boolean isString()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusString;
  }
  
  public boolean isEnum()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusEnum;
  }
  
}

/**
 * Copyright 2013 - All Rights Reserved.
 */
package  com.bclimate.NSerialReqResp.message;

import java.io.*;

import com.tridium.ndriver.comm.*;
import com.tridium.ndriver.io.*;
import com.tridium.ndriver.datatypes.*;
import com.tridium.ndriver.io.TypedInputStream;
import com.bclimate.NSerialReqResp.BNSerialReqRespDevice.*;

/**
 *  NSerialReqRespMessage is super class for all NSerialReqResp messages
 *
 *  @author   MS
 *  @creation 13 апр 2021 
 01 03 00 01 00 01 D5 CA - запрос первого регистра первого адреса
01 03 02 00 16 39 8A - ответ от modbus slave device
 */
public class NSerialReqRespMessage
  extends NMessage
{

  

  public boolean toOutputStream(OutputStream out) 
    throws Exception{
    TypedOutputStream to = new TypedOutputStream();
    
    to.write(BOS[0]);
    to.write(BOS[1]);
    to.write(BOS[2]);
    to.write(BOS[3]);
    to.write(BOS[4]);
    to.write(BOS[5]);
    to.write(BOS[6]);


    
    to.toOutputStream(out); 
    return false;    

}
    
  //   Override for incoming messages
public void fromInputStream(InputStream in)    
    throws Exception{
//    // Use typed stream for more readable code.
//    // Note: messageFactory must have created TypedInputStream
    TypedInputStream tin = (TypedInputStream)in;
    //BIS[0] = (byte)tin.read();
    //if(BIS[0] == 0) return;
    for(int i = 0; i<7 ; i++){
      BIS[i] = (byte)tin.read(); 
      //if(BIS[i]==0)continue;
      //System.out.println( " BIS "  +" - " + BIS[i] );
    } 


}
    
  //   Typical overrides  
  public Object getTag() { return TAG; }
  public boolean isResponse() { return false; }
  public boolean isFragmentable() { return false; }
  public int getResponseTimeOut() { return 10000; }
  
  public void resetBIS() {   for (int i = 0; i<7; i++)BIS[i] = 0;   }  
    
  
  public String toTraceString()
  {
    return " BIS[0] = " + String.valueOf((byte)BIS[0]) + " BIS[1] = " + String.valueOf((byte)BIS[1]) + " BIS[2] = " + String.valueOf((byte)BIS[2]) + " BIS[3] = " + String.valueOf((byte)BIS[3]) +
    " BIS[4] = " + String.valueOf((byte)BIS[4]) + " BIS[5] = " + String.valueOf((byte)BIS[5]) + " BIS[6] = " + String.valueOf((byte)BIS[6]) ; 
  }


public  byte BOS[] = {0,0,0,0,0,0,0}; 
public  static byte BIS[] = {0,0,0,0,0,0,0}; 
public String TAG = "1";
}

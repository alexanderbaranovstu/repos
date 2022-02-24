/*
Для начала нам необходимо создать подключение к базе данных 
BRdbmsHistoryImport
BMySQLDatabase
https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html но оно почемуто не очень то работает....
import java.sql.SQLException;
import java.sql.Connection;
*/

package com.bc.CommonLogic.db;  


import java.util.*;  
import java.io.*;
import java.sql.*;

import javax.baja.sys.*;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

import javax.baja.control.*;
import javax.baja.status.*;
import javax.baja.status.BStatusString;
import javax.baja.util.BFormat;
 
public class BAddDbMsg extends BStringWritable  //implements Connection 
{  

  /*-  
  class BAddDbMsg  
  {  
    properties  
    {  

   

    }   
    actions
    {

      writeToDb()
        flags { SUMMARY }
        
    }
  }  
  -*/
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.bc.CommonLogic.db.BAddDbMsg(2581974404)1.0$ @*/
/* Generated Tue Feb 16 08:32:30 GMT+03:00 2021 by Slot-o-Matic 2000 (c) Tridium, Inc. 2000 */

////////////////////////////////////////////////////////////////
// Action "writeToDb"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the <code>writeToDb</code> action.
   * @see com.bc.CommonLogic.db.BAddDbMsg#writeToDb()
   */
  public static final Action writeToDb = newAction(Flags.SUMMARY,null);
  
  /**
   * Invoke the <code>writeToDb</code> action.
   * @see com.bc.CommonLogic.db.BAddDbMsg#writeToDb
   */
  public void writeToDb() { invoke(writeToDb,null,null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAddDbMsg.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

public void doWriteToDb() throws ClassNotFoundException, SQLException
{
        Connection connection = null;
        Statement statement = null;
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        //connection = DataSource.getConnection();
        statement = connection.createStatement();
        String sql;
        sql = "SELECT * FROM app";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nDevelopers:");
        while (resultSet.next()) {
            int id = resultSet.getInt("idapp");
            //String name = resultSet.getString("name");
            //String specialty = resultSet.getString("specialty");
            //int salary = resultSet.getInt("salary");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            //System.out.println("Name: " + name);
            //System.out.println("Specialty: " + specialty);
            //System.out.println("Salary: $" + salary);
        }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();

}
    /**
     * JDBC Driver and database url
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/n4";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "Niagara1009_";


  
} 
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.githubandsourcetreeminiexample.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBConnection {
    
    private static final String URL="jdbc:mysql://localhost:3306/batch5";
    private static final String USER="root";
    private static final String PASSWORD="root123";
    //DriverManager.getConnection(...)
    //use not to write at every form
    
public Connection getDBConnection(){
    Connection conn = null;
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");//load jdbc driver
        conn=DriverManager.getConnection (URL,USER,PASSWORD);//connect db
        
    }
    catch(SQLException | ClassNotFoundException ex){
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE,null,ex);
        //means.....>> Logger logger = Logger.getLogger(DBConnection.class.getName());
        //...........>>logger.log(Level.SEVERE, null, ex);
    }
    return conn;
}


public static void main (String[]args){
    Connection con = new DBConnection().getDBConnection();
    if(con != null){
        System.out.println("Database connected Successfully");
    }
    else{
        System.out.println("Connection Failed");
    }
}


}

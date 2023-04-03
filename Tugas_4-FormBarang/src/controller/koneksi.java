/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author Lenovo
 */
public class koneksi {
     static Connection kon;
    
    public static Connection connection() {
       if (kon == null) {
           MysqlDataSource data = new  MysqlDataSource();
           data.setDatabaseName("toko");
           data.setUser("root");
           data.setPassword("");
           try {
               kon = data.getConnection();
               System.out.println("sudah konek");
               
           } catch (Exception e) {
               System.out.println("tidak konek");
           }
       }
       return kon;
    }
}

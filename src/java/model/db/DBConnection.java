/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author St-201906349
 */

public class DBConnection {
    
    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "system"; 
        String password = "system"; 
        try {
            try 
            {
                Class.forName("oracle.jdbc.driver.OracleDriver"); 
            } 
            catch (ClassNotFoundException e){

            }
                con = DriverManager.getConnection(url, username, password); 
                System.out.println("Printing connection object "+con);
            } 
            catch (Exception e) 
            {
            }
                return con; 
            }
}



 
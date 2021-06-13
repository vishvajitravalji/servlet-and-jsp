/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.RegisterBean;
import model.db.DBConnection;

/**
 *
 * @author St-201906349
 */
public class RegisterDao {
    public String registerUser(RegisterBean registerBean) throws ClassNotFoundException
 {
        String fullName = registerBean.getFullName();
        String email = registerBean.getEmail();
        String userName = registerBean.getUserName();
        String password = registerBean.getPassword();
 
        Connection con;
        con = null;
        PreparedStatement preparedStatement = null;
 
    try
        {
            con = DBConnection.createConnection();
            String query = "insert into users(SlNo,fullName,Email,userName,password) values (NULL,?,?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, password);

            int i= preparedStatement.executeUpdate();

            if (i!=0)  
                return "SUCCESS"; 
          }
            catch(SQLException e)
                {
                }
                  return "please above enter details";  
                }   
}

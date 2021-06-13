/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoginBean.LoginBean;
import model.dao.LoginDao;


/**
 *
 * @author St-201906349
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})

public class LoginServlet extends HttpServlet {

  
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String username=request.getParameter("txtUserName");
        String password=request.getParameter("txtPassword");
      
        LoginBean loginbean=new LoginBean();
        loginbean.setUsername(username);
        loginbean.setPassword(password);
        LoginDao logindao=new LoginDao();
        
            String uservalidate =" ";
            String errMessage="Invalid Username of Password";
        try {
            uservalidate = logindao.authenticateUser(loginbean);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

                if(uservalidate.equals("success"))
                {
                    request.setAttribute("username", username);
                    request.getRequestDispatcher("DepartmentServlet").forward(request, response);
                }
                else
                {
                    request.setAttribute("errMessage", errMessage);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }    
}

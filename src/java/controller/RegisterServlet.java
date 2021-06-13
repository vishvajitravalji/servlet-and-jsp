package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.RegisterBean;
import model.dao.RegisterDao;
 
public class RegisterServlet extends HttpServlet {
 
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     try {
         String fullName = request.getParameter("fullname");
         String email = request.getParameter("email");
         String userName = request.getParameter("username");
         String password = request.getParameter("password");
         
         RegisterBean registerBean = new RegisterBean();
         
         registerBean.setFullName(fullName);
         registerBean.setEmail(email);
         registerBean.setUserName(userName);
         registerBean.setPassword(password);
         
         RegisterDao registerDao = new RegisterDao();
         
         String userRegistered = registerDao.registerUser(registerBean);
         
         if(userRegistered.equals("SUCCESS"))
         {
             request.getRequestDispatcher("/Home.jsp").forward(request, response);
         }
         else
         {
             request.setAttribute("errMessage", userRegistered);
             request.getRequestDispatcher("/register.jsp").forward(request, response);
         }
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
     }
        }
}
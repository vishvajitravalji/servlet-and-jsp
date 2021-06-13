
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.LoginBean.LoginBean;
import model.db.DBConnection;

/**
 *
 * @author St-201906349
 */
public class LoginDao {
    
    
    public String authenticateUser(LoginBean loginbean) throws ClassNotFoundException, SQLException{
        String username=loginbean.getUsername();
        String password=loginbean.getPassword();
        String usernameDB="";
        String passwordDB="";
        
        Connection con = DBConnection.createConnection();
        Statement st = con.createStatement();
        
        ResultSet result = st.executeQuery("select username,password from login");
        
        while(result.next()){
            usernameDB=result.getString("username");
            passwordDB=result.getString("password");
            
            if(username.equals(usernameDB) && password.equals(passwordDB))
            {
                return "success";
            }
            else
            {
                return "invalid details";
            }
        }
        con.close();
        return "invalid details";
    }
}

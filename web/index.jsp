<%-- 
    Document   : Login
    Created on : Jan 7, 2020, 9:20:36 AM
    Author     : St-201906349
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div>
            <div>
                <h1>Sign in</h1>
                <span>Enter Username and password</span>
                        <form name="form" action="LoginServlet" method="post" onsubmit="return validate()">
                            <input type="text"  name="txtUserName" id="txtUserName"><br>
                             <input type="password" name="txtPassword" id="txtPassword">
                             <button type="submit" value="login">login</button>
                             <% String errMessage=""+request.getAttribute("errMessage"); %>
                             <span style="color:red"> 
                                 <%=(request.getAttribute("errMessage")==null)?"" : request.getAttribute("errMessage")%>
                             </span>
                        </form>
            </div>
            </div>
    </body>
</html>



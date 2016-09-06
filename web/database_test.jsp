<%-- 
    Document   : database_test
    Created on : Jun 13, 2014, 4:15:52 PM
    Author     : sys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%

        InitialContext initialContext = new InitialContext();
Context context = (Context) initialContext.lookup("java:comp/env");
//The JDBC Data source that we just created
DataSource ds = (DataSource) context.lookup("lms");
Connection connection = ds.getConnection();
if (connection == null)
{
throw new SQLException("Error establishing connection!");
}
String query = "SELECT * from empdetails";
PreparedStatement statement = connection.prepareStatement(query);
ResultSet rs = statement.executeQuery();
while (rs.next())
{
out.print(rs.getString("emp_id") + "<br>");
}
%>
    </body>
</html>

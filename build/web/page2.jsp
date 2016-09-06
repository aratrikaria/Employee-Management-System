<%-- 
    Document   : page2
    Created on : Jun 18, 2014, 3:46:38 PM
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
String query = "SELECT emp_id,password from empdetails";
PreparedStatement statement = connection.prepareStatement(query);
ResultSet rs = statement.executeQuery();


String empid = request.getParameter("empid");
String pword = request.getParameter("pword");
int p=1;
while (rs.next())
{
    if((empid.equals(rs.getString("emp_id"))) && (pword.equals(rs.getString("password"))))
    {
        p = 0;
        out.println("EMPLOYEE ID : "+empid+"<br>PASSWORD:    "+ pword+"<br>");
        break;
     }
   
 }
if (p == 0)
    {
    session.setAttribute("emp_id",empid);
    out.print(session.getAttribute("emp_id").toString());
    %>
    <script>
        window.location.href='homepage_2.jsp'
    </script>
    <%
    }
    else
    {
    out.println("INVALID USERNAME OR PASSWORD");
    }

        

            

        %>
    </body>
</html>

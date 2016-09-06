<%-- 
    Document   : homepage_2
    Created on : Jun 27, 2014, 2:09:35 PM
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
<%@ page import="java.io.*,javax.crypto.*,javax.crypto.spec.*,java.util.*;"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <form name="input" action="page3.jsp" method="post">
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
        String sender = "";
        String fileid = "";
        String seen = "";
        String filename = "";
        String fileid1 = "";
        String filename1 = "";

        String query = "SELECT * from check_view where emp_id='"+session.getAttribute("emp_id").toString()+"'";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while(rs.next())
       {
         sender = rs.getString("sender_emp_id");
         fileid = rs.getString("file_id");
         seen = rs.getString("seen_unseen");

        String query1 = "SELECT * from files where file_id='"+fileid+"'";
        PreparedStatement statement1 = connection.prepareStatement(query1);
        ResultSet rs1 = statement1.executeQuery();
        while(rs1.next())
           {
            filename = rs1.getString("file_name");
           }
        if(seen.equals("unseen")){
            out.println("<b>"+filename+"</b>");
            out.println("<b>"+sender+"</b><br>");
        }
        else{
            out.println(filename);
            out.println("  "+sender+"<br>");
        }
        }

%>
<table>
                <tr> <td><p>SHARED FILES<p></td></tr>
                <tr><td><%
                String query2 = "SELECT * from shared_details where emp_id='"+session.getAttribute("emp_id").toString()+"'";
                PreparedStatement statement2 = connection.prepareStatement(query2);
                ResultSet rs2 = statement2.executeQuery();

        while(rs2.next())
       {
          fileid1 = rs2.getString("file_id");
          String query3 = "SELECT * from files where file_id='"+fileid1+"'";
        PreparedStatement statement3 = connection.prepareStatement(query3);
        ResultSet rs3 = statement3.executeQuery();
        while(rs3.next())
           {
            filename1 = rs3.getString("file_name");
            out.println("  "+filename1+"<br>");
           }
        }


%>
                    </td></tr>
                         </table>

  

<input type="SUBMIT" value="NEXT PAGE">

    </body>
</form>
</html>

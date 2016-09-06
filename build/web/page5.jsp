<%-- 
    Document   : page5
    Created on : Jun 20, 2014, 4:43:19 PM
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
    <form name="input" action="page6.jsp" method="post">
    <body>

ENTER FILE NAME: <input type="text" name="filename">
 <input type="SUBMIT" value="SUBMIT FILE">


 </form>

</body>

</html>

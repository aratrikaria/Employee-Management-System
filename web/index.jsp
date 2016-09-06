<%-- 
    Document   : index
    Created on : Jun 13, 2014, 2:08:06 PM
    Author     : sys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="input" action="page2.jsp" method="post">
            <h1> WELCOME TO ONLINE FILE TRANSFER</h1> <br> <br>
            
        <table>
            <tr> <td> EMPLOYEE ID: <input type="text" name="empid"></td>
                 <td> PASSWORD: <input type="password" name="pword"></td>
                 <td><input type="submit" value="LOGIN"></td>
                 </tr>
        </table> <br><br><br>
            <table>
                <th1>CREATE A NEW ACCOUNT</th1> <br> <br>
                <tr> <td>FIRST NAME: <input type="text" name="firstname"></td>
                     <td>LAST NAME: <input type="text" name="lname"></td>
                </tr> <br> <br>
                <tr>
                    <td>EMAIL ADDRESS: <input type="text" name="eadd1"></td>
                    <td>RE ENTER EMAIL ADDRESS: <input type="text" name="eadd2"></td>
                </tr> <br> <br>
                <tr>
                    <td>NEW PASSWORD: <input type="password" name="p1"></td>
                    <td>RE ENTER PASSWORD: <input type="text" name="p2"></td>
                    <td> <input type="SUBMIT" value="SIGN UP">
                </tr>

            </table>
           
</form>
    </body>
</html>

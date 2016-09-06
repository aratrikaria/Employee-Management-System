<%-- 
    Document   : fileupload
    Created on : Jun 19, 2014, 3:11:05 PM
    Author     : sys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WELCOME USER</title>
    </head>
    <body>

        <form name="fileinput" action="page4.jsp" method="post">
        <p> UPLOAD YOUR FILES HERE</p>

        <br>
<table>
    <tr>
        <td>FILE NAME: <input type="text" name="filename"></td> 
    </tr>

    <tr> <td>CONTENTS</td>

        <td>
        <textarea name="myTextarea" rows="4" cols="50">  </textarea> <br>
        </td>
    </tr>
    
    <tr> <td> <input type="checkbox" name="sharefile" value="file"> SHARE FILE<br> </td> </tr> <br> <br>

<br>

</table>

<input type="radio" name="mode" value="safe">SAFE MODE<br>
<input type="radio" name="mode" value="normal">NORMAL MODE<br>
<input type="radio" name="mode" value="public">PUBLIC MODE<br><br> <br>

<input type="submit" value="SAVE FILE"> <br> <br>


        </form>
    </body>
</html>

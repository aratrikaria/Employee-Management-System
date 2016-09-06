<%--
    Document   : index
    Created on : Jun 12, 2014, 3:52:51 PM
    Author     : arnab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,javax.crypto.*,javax.crypto.spec.*,java.util.*;"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="action.jsp">
            First Name <input type="text" name="fname">
            Last Name <input tyep="text" name="lname">
            <input type="submit" value="OK">
        </form>

        <%
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        SecretKey myDesKey = keygenerator.generateKey();
        byte[] encoded = myDesKey.getEncoded();
        out.println(new String(encoded));
        Cipher desCipher;
        out.println(myDesKey);
        desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] text = "No body can see me".getBytes();
        out.println("Text [Byte Format] : " + text);
        out.println("Text : " + new String(text));
        byte[] textEncrypted = desCipher.doFinal(text);
        out.println("Text Encryted : " + textEncrypted);
        myDesKey = new SecretKeySpec(encoded, "AES");
        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] textDecrypted = desCipher.doFinal(textEncrypted);
        out.println("Text Decryted : " + new String(textDecrypted));
        out.print(session.getAttribute("emp_id").toString());
        %>
    </body>
</html>





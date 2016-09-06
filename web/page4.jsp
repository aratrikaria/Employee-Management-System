<%-- 
    Document   : afterfileupload
    Created on : Jun 20, 2014, 2:40:33 PM
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
    <form name="input" action="page5.jsp" method="post">
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


        String filename = request.getParameter("filename");
        String text = request.getParameter("myTextarea");
        String mode = request.getParameter("mode");
        String path = "C:\\Users\\sys\\Desktop\\files\\";
        String [] sharefile = request.getParameterValues("sharefile");
        String p = "";
        String worksfor = "";
        String unseen = "unseen";

        if (mode.equals("safe")){

            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey myDesKey = keygenerator.generateKey();
        byte[] encoded1 = myDesKey.getEncoded();
        Cipher desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] textEncrypted = desCipher.doFinal(text.getBytes());

        keygenerator = KeyGenerator.getInstance("AES");
        myDesKey = keygenerator.generateKey();
        byte[] encoded2 = myDesKey.getEncoded();
        desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] textEncrypted1 = desCipher.doFinal(textEncrypted);

        FileWriter fw=new FileWriter(path+filename);
        BufferedWriter bw=new BufferedWriter(fw);

        bw.write(new String(textEncrypted1));
        bw.close();

        int n=0;
        String query = "SELECT * from files";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            n += 1;
            }
        String file_id = "f_"+Integer.toString(n+1);
        p = file_id;
        query = "insert into files values('"+file_id+"','"+filename+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();

        query = "insert into filedetails values('"+session.getAttribute("emp_id").toString()+"','"+file_id+"','"+mode+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();

        query = "insert into safe_keys values('"+file_id+"','"+new String(encoded1)+"','"+new String(encoded2)+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();
        }
        




        else if (mode.equals("normal")){
            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey myDesKey = keygenerator.generateKey();
        byte[] encoded = myDesKey.getEncoded();
        Cipher desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] textEncrypted = desCipher.doFinal(text.getBytes());


        FileWriter fw=new FileWriter(path+filename);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(new String(textEncrypted));
        bw.close();
        int n=0;
        String query = "SELECT * from files";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            n += 1;
            }
        String file_id = "f_"+Integer.toString(n+1);
        p = file_id;
        query = "insert into files values('"+file_id+"','"+filename+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();

        query = "insert into filedetails values('"+session.getAttribute("emp_id").toString()+"','"+file_id+"','"+mode+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();
        

        query = "insert into normal_keys values('"+file_id+"','"+new String(encoded)+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();
        }

else
    {

 FileWriter fw=new FileWriter(path+filename);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(new String(text.getBytes()));
        bw.close();
        int n=0;
        String query = "SELECT * from files";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            n += 1;
            }
        String file_id = "f_"+Integer.toString(n+1);
        p = file_id;

        query = "insert into files values('"+file_id+"','"+filename+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();

        query = "insert into filedetails values('"+session.getAttribute("emp_id").toString()+"','"+file_id+"','"+mode+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();

       }



//If user shares file

        if (sharefile!= null)
    {
        int n =0;
        int n1 = 0;
        String query = "SELECT * from shared_details";
        PreparedStatement statement1 = connection.prepareStatement(query);
        ResultSet rs1 = statement1.executeQuery();
        while(rs1.next()){
            n += 1;
            }
        String query1 = "insert into shared_details values('"+session.getAttribute("emp_id").toString()+"','"+p+"')";
        statement1 = connection.prepareStatement(query1);
        statement1.executeUpdate();
        
        
        //Finding out who he works for,so that the file will be sent to him

        String query2 = "SELECT * from work_structure where emp_id='"+session.getAttribute("emp_id").toString()+"'";;
        PreparedStatement statement2 = connection.prepareStatement(query2);
        ResultSet rs2 = statement2.executeQuery();
         while(rs2.next())
       {
        worksfor = rs2.getString("works_for");
        
        }

        //Putting the file in the inbox of his boss or the receiver of the file
        String query3 = "SELECT * from check_view";
        PreparedStatement statement3 = connection.prepareStatement(query3);
        ResultSet rs3 = statement3.executeQuery();
        while(rs3.next()){
            n1 += 1;
            }
        String query4 = "insert into check_view values('"+worksfor+"','"+p+"','"+unseen+"','"+session.getAttribute("emp_id").toString()+"')";
        statement3 = connection.prepareStatement(query4);
        statement3.executeUpdate();
        
  out.println("YOUR FILE IS SHARED SUCCESSFULLY");



     }

 %>

 <input type="SUBMIT" value="OK">
   

    </body>
    </form>
</html>

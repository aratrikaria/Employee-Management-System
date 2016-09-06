<%-- 
    Document   : page6
    Created on : Jun 20, 2014, 5:37:00 PM
    Author     : sys
--%>

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

        String fileid="";
        String empid1="";
        String mode1="";
        String key11="";
        String key22="";
        String key33="";
        String line = "";
        String content="";
        String path = "C:\\Users\\sys\\Desktop\\files\\";
        String filename = request.getParameter("filename");

        out.println(filename);

        String query = "SELECT file_id from files where file_name='"+filename+"'";

      
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
       while(rs.next())
       {
         fileid = rs.getString("file_id");
       }

        String query1 = "SELECT emp_id,filemode from filedetails where file_id='"+fileid+"'";
        PreparedStatement statement1 = connection.prepareStatement(query1);
        ResultSet rs1 = statement1.executeQuery();
        
        
       while(rs1.next())
       {
         empid1 = rs1.getString("emp_id");
         mode1 = rs1.getString("filemode");
       }
      
       String empid = session.getAttribute("emp_id").toString();
       if(empid.equals(empid1))
       {


            FileReader fr = new FileReader( path + filename);
            BufferedReader br=new BufferedReader(fr);
            while((line = br.readLine())!=null)
            {
                content = content + line;
            }
            
       
           
            if(mode1.equals("safe")){
                String query3 = "SELECT key1,key2 from safe_keys where file_id='"+fileid+"'";
                PreparedStatement statement3 = connection.prepareStatement(query3);
                ResultSet rs3 = statement3.executeQuery();
                
                          while(rs3.next())
                           {
                            key11 = rs3.getString("key1");
                            key22 = rs3.getString("key2");
                           }
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        SecretKey myDesKey = keygenerator.generateKey();
        Cipher desCipher;
        desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        myDesKey = new SecretKeySpec(key22.getBytes(), "AES");
        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] textDecrypted = desCipher.doFinal(content.getBytes());

        myDesKey = new SecretKeySpec(key11.getBytes(), "AES");
        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] textDecrypted1 = desCipher.doFinal(textDecrypted);
        out.println("Text Decrypted : " + new String(textDecrypted1));
        


        out.print(session.getAttribute("emp_id").toString());

            }
                           


           else if (mode1.equals("normal")){
                String query5 = "SELECT keyy from normal_keys where file_id='"+fileid+"'";
                PreparedStatement statement5 = connection.prepareStatement(query5);
                ResultSet rs5 = statement5.executeQuery();


                          while(rs5.next())
                           {
                            key33 = rs5.getString("keyy");

                           }
        KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
        SecretKey myDesKey = keygenerator.generateKey();
        Cipher desCipher;
        desCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        myDesKey = new SecretKeySpec(key33.getBytes(), "AES");
        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] textDecrypted = desCipher.doFinal(content.getBytes());
         out.println("Text Decrypted : " + new String(textDecrypted));



           }
           else{
                out.println(content);
                }

        br.close();

        }
%>
    </body>
</html>

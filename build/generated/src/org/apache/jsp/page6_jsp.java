package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.naming.Context;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;;

public final class page6_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
       out.println("<br>mode: "+mode1);
        String empid = session.getAttribute("emp_id").toString();
       if(empid.equals(empid1))
       {


            FileReader fr = new FileReader( path + filename);
            BufferedReader br=new BufferedReader(fr);
            while((line = br.readLine())!=null)
            {
                content = content + line;
            }
            out.println("<br>content: "+content);
       
           
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

      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

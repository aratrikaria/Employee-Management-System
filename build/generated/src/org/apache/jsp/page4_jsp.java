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

public final class page4_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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


        String filename = request.getParameter("filename");
        String text = request.getParameter("myTextarea");
        String mode = request.getParameter("mode");
        String path = "C:\\Users\\sys\\Desktop\\files\\";
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
        query = "insert into files values('"+file_id+"','"+filename+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();

        query = "insert into filedetails values('"+session.getAttribute("emp_id").toString()+"','"+file_id+"','"+mode+"')";
        statement = connection.prepareStatement(query);
        statement.executeUpdate();

       }


        
      out.write("\n");
      out.write("<script>\n");
      out.write("        window.location.href='page5.jsp'\n");
      out.write("    </script>\n");
      out.write("\n");
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

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

public final class homepage_005f2_jsp extends org.apache.jasper.runtime.HttpJspBase
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


      out.write("\n");
      out.write("<table>\n");
      out.write("                <tr> <td><p>SHARED FILES<p></td></tr>\n");
      out.write("                <tr><td>");

                String query2 = "SELECT * from shared_details where emp_id='"+session.getAttribute("emp_id").toString()+"'";
                PreparedStatement statement2 = connection.prepareStatement(query2);
                ResultSet rs2 = statement2.executeQuery();

        while(rs2.next())
       {
          fileid1 = rs.getString("file_id");
          String query3 = "SELECT * from files where file_id='"+fileid1+"'";
        PreparedStatement statement3 = connection.prepareStatement(query3);
        ResultSet rs3 = statement3.executeQuery();
        while(rs3.next())
           {
            filename1 = rs3.getString("file_name");
            out.println("  "+filename1+"<br>");
           }
        }


      out.write("\n");
      out.write("                    </td></tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("         </table>\n");
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

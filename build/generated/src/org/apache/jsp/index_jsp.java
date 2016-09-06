package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"input\" action=\"page2.jsp\" method=\"post\">\n");
      out.write("            <h1> WELCOME TO ONLINE FILE TRANSFER</h1> <br> <br>\n");
      out.write("            \n");
      out.write("        <table>\n");
      out.write("            <tr> <td> EMPLOYEE ID: <input type=\"text\" name=\"empid\"></td>\n");
      out.write("                 <td> PASSWORD: <input type=\"password\" name=\"pword\"></td>\n");
      out.write("                 <td><input type=\"submit\" value=\"LOGIN\"></td>\n");
      out.write("                 </tr>\n");
      out.write("        </table> <br><br><br>\n");
      out.write("            <table>\n");
      out.write("                <th1>CREATE A NEW ACCOUNT</th1> <br> <br>\n");
      out.write("                <tr> <td>FIRST NAME: <input type=\"text\" name=\"firstname\"></td>\n");
      out.write("                     <td>LAST NAME: <input type=\"text\" name=\"lname\"></td>\n");
      out.write("                </tr> <br> <br>\n");
      out.write("                <tr>\n");
      out.write("                    <td>EMAIL ADDRESS: <input type=\"text\" name=\"eadd1\"></td>\n");
      out.write("                    <td>RE ENTER EMAIL ADDRESS: <input type=\"text\" name=\"eadd2\"></td>\n");
      out.write("                </tr> <br> <br>\n");
      out.write("                <tr>\n");
      out.write("                    <td>NEW PASSWORD: <input type=\"password\" name=\"p1\"></td>\n");
      out.write("                    <td>RE ENTER PASSWORD: <input type=\"text\" name=\"p2\"></td>\n");
      out.write("                    <td> <input type=\"SUBMIT\" value=\"SIGN UP\">\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("           \n");
      out.write("</form>\n");
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

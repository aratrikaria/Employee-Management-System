package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;;

public final class encrypt_005ftest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <form method=\"post\" action=\"action.jsp\">\n");
      out.write("            First Name <input type=\"text\" name=\"fname\">\n");
      out.write("            Last Name <input tyep=\"text\" name=\"lname\">\n");
      out.write("            <input type=\"submit\" value=\"OK\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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

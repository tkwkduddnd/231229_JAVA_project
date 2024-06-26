/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.82
 * Generated at: 2023-11-25 10:19:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>여행사 홈페이지</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"Home.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <header>\r\n");
      out.write("        <h1>NH 여행</h1>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <nav>\r\n");
      out.write("        <!-- Common menu items for both admin and user can be included here -->\r\n");
      out.write("        <div class=\"left-nav\">\r\n");
      out.write("            <a href=\"Home.jsp\">홈</a>\r\n");
      out.write("            <a href=\"trippackage.jsp\">여행 패키지</a>\r\n");
      out.write("            <a href=\"Europe.jsp\">유 럽</a>\r\n");
      out.write("            <a href=\"SoutheastAsia.jsp\">동남아</a>\r\n");
      out.write("            <a href=\"Japan.jsp\">일 본</a>\r\n");
      out.write("            <a href=\"China.jsp\">중 국</a>\r\n");
      out.write("            <a href=\"USA.jsp\">미 국</a>\r\n");
      out.write("            <a href=\"Honeymoon.jsp\">허니문</a>\r\n");
      out.write("            <a href=\"CompanyIntroduction.jsp\">회사 소개</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"right-nav\">\r\n");
      out.write("            ");
 
                String username = (String) session.getAttribute("username");
                String role = (String) session.getAttribute("role");

                if (username == null) { 
            
      out.write("\r\n");
      out.write("                <a href=\"Login.jsp\">로그인</a>\r\n");
      out.write("                <a href=\"Register.jsp\">회원가입</a>\r\n");
      out.write("            ");
 } else { 
      out.write("\r\n");
      out.write("                <a href=\"");
      out.print( "admin".equals(role) ? "Admin.jsp" : "Home.jsp" );
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print( username );
      out.write("님의 마이페이지</a>\r\n");
      out.write("                <a href=\"LogoutServlet\">로그아웃</a>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("            <a href=\"Inquire.jsp\">게시판</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <section>\r\n");
      out.write("        <!-- Common content for both admin and user can be included here -->\r\n");
      out.write("        <div class=\"home-content\">\r\n");
      out.write("            <h2>환영합니다!</h2>\r\n");
      out.write("            <p>여행을 더욱 특별하게 만드는 여행사와 함께하세요.</p>\r\n");
      out.write("            <img src=\"images/main/mainimage.jpg\" alt=\"메인페이지\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"feature-box\">\r\n");
      out.write("            <div class=\"feature\">\r\n");
      out.write("                <h3>다양한 여행지</h3>\r\n");
      out.write("                <p>세계 각지의 아름다운 여행지를 경험하세요.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"feature\">\r\n");
      out.write("                <h3>편리한 예약</h3>\r\n");
      out.write("                <p>간편한 예약 시스템을 통해 여행을 계획하세요.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"feature\">\r\n");
      out.write("                <h3>고객 지원</h3>\r\n");
      out.write("                <p>24/7 고객 서비스로 여행 도중 발생하는 문제를 해결하세요.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
 
            if ("admin".equals(role)) { 
        
      out.write("\r\n");
      out.write("            <!-- Admin-specific content or functionality can be included here -->\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("            <!-- Regular user content or functionality goes here -->\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    <footer>\r\n");
      out.write("        © 2023 여행사. All Rights Reserved.\r\n");
      out.write("    </footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.79
 * Generated at: 2022-07-19 07:30:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.center;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.kh.center.model.vo.*;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;

public final class centerInfoListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/center/../common/header.jsp", Long.valueOf(1657251426536L));
    _jspx_dependants.put("/views/center/../common/footer.jsp", Long.valueOf(1655558372000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.kh.center.model.vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.common.model.vo.PageInfo");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("com.kh.member.model.vo.Member");
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
      return;
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
      out.write("\r\n");

	ArrayList<CenterInfo> list = (ArrayList<CenterInfo>)request.getAttribute("list");

	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// ???????????? ????????? ????????? ?????? ?????? ??????
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>????????? ?????????</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.outer{\r\n");
      out.write("		background-color: white;\r\n");
      out.write("		color: black;\r\n");
      out.write("		width: 1000px;\r\n");
      out.write("		margin: auto;\r\n");
      out.write("		margin-top: 30px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("    .table{\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        border: 2px solid white;\r\n");
      out.write("        font-weight: 300;\r\n");
      out.write("    }\r\n");
      out.write("    .table>tbody>.list-info:hover{\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("	.btn-div a{\r\n");
      out.write("		margin: 0 95px;\r\n");
      out.write("\r\n");
      out.write("	}\r\n");
      out.write("	#del{\r\n");
      out.write("	text-align:right;\r\n");
      out.write("	}\r\n");
      out.write("	.info-faq-btn{\r\n");
      out.write("		display: flex;\r\n");
      out.write("		justify-content: space-between;\r\n");
      out.write("		margin-bottom: 10px;\r\n");
      out.write("	}\r\n");
      out.write("	.info-content{\r\n");
      out.write("	\r\n");
      out.write("		white-space: pre-wrap;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".accordion {\r\n");
      out.write("  background-color: white;\r\n");
      out.write("  color: #444;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  padding: 1px;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  border: none;\r\n");
      out.write("  text-align: left;\r\n");
      out.write("  outline: none;\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  transition: 0.4s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".active, .accordion:hover {\r\n");
      out.write("  background-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".accordion:after {\r\n");
      out.write("  content: '\\002B';\r\n");
      out.write("  color: #777;\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("  float: right;\r\n");
      out.write("  margin-left: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".active:after {\r\n");
      out.write("  content: \"\\2212\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".panel {\r\n");
      out.write("  padding: 0 18px;\r\n");
      out.write("  background-color: #F8F8F8;\r\n");
      out.write("  text-align: left;\r\n");
      out.write("  max-height: 0;\r\n");
      out.write("  overflow: hidden;\r\n");
      out.write("  transition: max-height 0.2s ease-out;\r\n");
      out.write("}\r\n");
      out.write("   	\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<!-- header start -->\r\n");
      out.write("	");
      out.write("	\n");
      out.write("    \n");

	Member loginMember = (Member)session.getAttribute("loginMember");
	String alertMsg = (String)session.getAttribute("alertMsg");
	String contextPath = (String)request.getContextPath();

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("	<meta charset=\"UTF-8\">\n");
      out.write("	<title>Header</title>\n");
      out.write("    <!-- bootstrap -->\n");
      out.write("	<!-- Latest compiled and minified CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("    <!-- jQuery library -->\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js\"></script>\n");
      out.write("    <!-- Popper JS -->\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("    <!-- Latest compiled JavaScript -->\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <!-- fontAwesome -->\n");
      out.write("    <script src=\"https://kit.fontawesome.com/567fbbaed5.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("	<script>\n");
      out.write("	 function loginformPage(){\n");
      out.write("\n");
      out.write("	      	// ??? ????????????????????? ???????????? ????????? url??? ???????????? => ????????? ??????\n");
      out.write("	      	// ????????? ????????? ????????? ??????????????? ???????????? ????????? Servlet??? ????????? ????????? ????????????\n");
      out.write("	      	// => url??? ????????? ???????????? ??????????????? ?????????.\n");
      out.write("	      	// localhost:8001/jsp/??????\n");
      out.write("\n");
      out.write("	      	location.href = \"");
      out.print( contextPath );
      out.write("/loginform.me\";\n");
      out.write("	      	\n");
      out.write("	  }\n");
      out.write("	</script>\n");
      out.write("   <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/header.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<div class=\"header-wrapper\">\n");
      out.write("        <header id=\"header\" role=\"banner\">\n");
      out.write("            <div class=\"web-header\">\n");
      out.write("                <div class=\"special_bg\">\n");
      out.write("                    <div class=\"group_flex\">\n");
      out.write("\n");
      out.write("                        <div class=\"logo_area\">\n");
      out.write("                            <div class=\"logo_default\">\n");
      out.write("                                <a href=\"");
      out.print( contextPath );
      out.write("\" class=\"logo__img\">\n");
      out.write("                                    <img src=\"");
      out.print( contextPath );
      out.write("/resources/img/icon.png\" alt=\"??????_??????\">\n");
      out.write("                                </a>\n");
      out.write("                                <div>\n");
      out.write("                                    <img class=\"logo__title--sm\" src=\"");
      out.print( contextPath );
      out.write("/resources/img/title.png\" alt=\"?????????_?????????\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"main_title\">\n");
      out.write("                            <img src=\"");
      out.print( contextPath );
      out.write("/resources/img/title.png\" alt=\"?????????_?????????\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div id=\"search\" class=\"search_area\">\n");
      out.write("                            <div class=\"input-group mb-3\">\n");
      out.write("                                <input type=\"text\" autofocus class=\"form-control\" placeholder=\"???????????? ???????????????\" name=\"sch\">\n");
      out.write("                                <div class=\"input-group-append\">\n");
      out.write("                                    <button onclick=\"searchProduct();\" class=\"btn btn-outline-secondary\" type=\"button\">\n");
      out.write("                                        <i class=\"fa-solid fa-lg fa-magnifying-glass\"></i>\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- ?????? ?????? -->\n");
      out.write("                        <script>\n");
      out.write("                            function searchProduct(){\n");
      out.write("                                const keyword = $('.form-control').val();\n");
      out.write("                                \n");
      out.write("                                location.href = \"");
      out.print( contextPath );
      out.write("/search.pr?keyword=\" + keyword;\n");
      out.write("                            }\n");
      out.write("                        </script>\n");
      out.write("\n");
      out.write("                        <div class=\"service_area\">\n");
      out.write("                            ");
 if(loginMember == null) { 
      out.write("\n");
      out.write("                                <a href=\"javascript:loginformPage();\" >?????????</a>\n");
      out.write("                                <span>|</span>\n");
      out.write("                                <a href=\"");
      out.print( contextPath );
      out.write("/loginenroll.me\">????????????</a>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                                <a href=\"#\">????????????</a>\n");
      out.write("                                <span>|</span>\n");
      out.write("                                <a href=\"");
      out.print( contextPath );
      out.write("/logout.me\">????????????</a>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                                <span>|</span>\n");
      out.write("                                <a href=\"");
      out.print( contextPath);
      out.write("/center.ce?cpage=1\">????????????</a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    ");
 if(loginMember != null){ 
      out.write("\n");
      out.write("                        <div class=\"user_greeting\">\n");
      out.write("                            <div class=\"user_greeting--user_name\">\n");
      out.write("                                <h3>");
      out.print( loginMember.getMemberName() );
      out.write("???</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"user_greeting--greeting\">\n");
      out.write("                                    <p>????????? ?????? ?????????!</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- nav ?????? -->\n");
      out.write("    <nav class=\"navbar navbar-expand-sm sticky\"> <!-- bg-light ?????? -->\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" class=\"dropdown-toggle\">????????????</div>\n");
      out.write("            <div class=\"dropdown-content\"> \n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/allproduct.pr\">????????????</a>\n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/newproduct.pr\">?????????</a>\n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/rankingproduct.pr\">????????????</a>\n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/saleproduct.pr\">????????????</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" onclick=\"location.href='");
      out.print( contextPath );
      out.write("/list.ev' \">?????????</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" onclick=\"location.href='");
      out.print( contextPath );
      out.write("/list.bo?cpage=1' \">???????????????</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" onclick=\"location.href='");
      out.print(contextPath );
      out.write("/list.no?cpage=1' \">????????????</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" class=\"dropdown-toggle\">???????????????</div>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a class=\"forMember\" href=\"");
      out.print( contextPath );
      out.write("/cart.my\">????????????</a>\n");
      out.write("                <a class=\"forMember\" href=\"");
      out.print( contextPath );
      out.write("/orderHistory.my\">????????????</a>\n");
      out.write("                <a class=\"forMember\" href=\"");
      out.print( contextPath );
      out.write("/address.my\">???????????????</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write(" 	<script>\n");
      out.write(" 		const msg = \"");
      out.print( alertMsg );
      out.write("\";\n");
      out.write(" 		\n");
      out.write(" 		if(msg != \"null\"){\n");
      out.write(" 			alert(msg);\n");
      out.write(" 			\n");
      out.write(" 			");
 session.removeAttribute("alertMsg"); 
      out.write("\n");
      out.write(" 		}\n");
      out.write(" 		\n");
      out.write(" 		\n");
      out.write(" 	</script>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<div class=\"outer\">\r\n");
      out.write("			<br><br><br><br>\r\n");
      out.write("			<div class=\"btn-div\">\r\n");
      out.write("				<a href=\"");
      out.print(contextPath);
      out.write("/center.ce?cpage=1\" class=\"btn btn-lg btn-outline-secondary\">???????????? FAQ</a>\r\n");
      out.write("				<a href=\"");
      out.print(contextPath);
      out.write("/list.ce?cpage=1\" class=\"forMember btn btn-lg btn-outline-secondary\">1:1 ??????</a>\r\n");
      out.write("				<a href=\"");
      out.print(contextPath);
      out.write("/infoList.ce?cpage=1\" class=\"btn btn-lg btn-secondary\"\">????????????</a>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        	<br><br><br><br>\r\n");
      out.write("        	<h4 align=\"left\" style=\"color:black\">???????????? </h4>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- ???????????? ????????? ????????? ???????????? -->\r\n");
      out.write("        ");
 if(loginMember != null && loginMember.getMemberId().equals("admin")) { 
      out.write("\r\n");
      out.write("        <!-- ???????????? ????????????, ????????? ???????????? ??????  -->\r\n");
      out.write("	        <div style=\"width:850px\">\r\n");
      out.write("	            <!--\r\n");
      out.write("	            <button onclick=\"location.href=\"??????????????????\";\">?????????</button>\r\n");
      out.write("				????????? href????????? ?????? ????????? ????????? ????????? ???????????? ?????????????????? onclick=\"location.href='??????url'\"\r\n");
      out.write("	            -->\r\n");
      out.write("	            <!-- a????????? ????????? ?????? ????????? ????????? ?????????? : ??????????????? ?????? -->\r\n");
      out.write("				<div class=\"info-faq-btn\">\r\n");
      out.write("					<a href=\"");
      out.print(contextPath );
      out.write("/infoEnrollForm.ce\" class=\"btn btn-warning\">?????????</a>\r\n");
      out.write("					<a data-toggle=\"modal\" data-target=\"#deleteInfo\" class=\"btn btn-warning\">?????????</a>\r\n");
      out.write("				</div>\r\n");
      out.write("				\r\n");
      out.write("				<table class=\"list-area, table\">\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                </tr>                \r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody>\r\n");
      out.write("            	<!-- ???????????? ??????????????? ?????? -->\r\n");
      out.write("            	");
 if(list.isEmpty()) { 
      out.write("\r\n");
      out.write("            		<!-- ?????? ?????? ?????? -->\r\n");
      out.write("	                 <tr>\r\n");
      out.write("	                     <th align=\"center\">\r\n");
      out.write("                         	??????????????? ???????????? ????????????!\r\n");
      out.write("	                     </th>\r\n");
      out.write("	                 </tr>\r\n");
      out.write("	             ");
 } else { 
      out.write("\r\n");
      out.write("	                 <!-- ??????????????? ????????? ?????? -->\r\n");
      out.write("	                 ");
 for(CenterInfo i : list)  { 
      out.write("\r\n");
      out.write("		                 <tr class=\"list-info\">\r\n");
      out.write("		                     <th width=\"100\" Style=\"color:#FFD000\">\r\n");
      out.write("		                         NO.");
      out.print( i.getInfoNo() );
      out.write("\r\n");
      out.write("		                     </th>\r\n");
      out.write("		                     <td width=\"1000px\">\r\n");
      out.write("		                     	<button class=\"accordion\">");
      out.print( i.getInfoTitle() );
      out.write("</button>\r\n");
      out.write("								<div class=\"panel\">\r\n");
      out.write("								  <br>\r\n");
      out.write("								  <pre class=\"info-content\">");
      out.print(i.getInfoContent() );
      out.write("</pre>\r\n");
      out.write("								</div>\r\n");
      out.write("		                     </td>\r\n");
      out.write("		                 </tr>\r\n");
      out.write("		              ");
 } 
      out.write("\r\n");
      out.write("	             ");
 } 
      out.write("\r\n");
      out.write("            		\r\n");
      out.write("            		\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("				\r\n");
      out.write("				\r\n");
      out.write("		");
 } else {
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	         <table class=\"list-area, table\">\r\n");
      out.write("	            <thead>\r\n");
      out.write("	                <tr>\r\n");
      out.write("	                </tr>                \r\n");
      out.write("	            </thead>\r\n");
      out.write("	            <tbody>\r\n");
      out.write("	            	<!-- ???????????? ??????????????? ?????? -->\r\n");
      out.write("	            	");
 if(list.isEmpty()) { 
      out.write("\r\n");
      out.write("	            		<!-- ?????? ?????? ?????? -->\r\n");
      out.write("		                 <tr>\r\n");
      out.write("		                     <th align=\"center\">\r\n");
      out.write("	                          	??????????????? ???????????? ????????????!\r\n");
      out.write("		                     </th>\r\n");
      out.write("		                 </tr>\r\n");
      out.write("		             ");
 } else { 
      out.write("\r\n");
      out.write("		                 <!-- ??????????????? ????????? ?????? -->\r\n");
      out.write("		                 ");
 for(CenterInfo i : list)  { 
      out.write("\r\n");
      out.write("		                 <tr class=\"list-info\">\r\n");
      out.write("		                     <td>\r\n");
      out.write("		                     	<button class=\"accordion\">");
      out.print( i.getInfoTitle() );
      out.write("</button>\r\n");
      out.write("								<div class=\"panel\">\r\n");
      out.write("								  <br>\r\n");
      out.write("								  <pre class=\"info-content\">");
      out.print(i.getInfoContent() );
      out.write("</pre>\r\n");
      out.write("								</div>\r\n");
      out.write("		                     </td>\r\n");
      out.write("		                 </tr>\r\n");
      out.write("			              ");
 } 
      out.write("\r\n");
      out.write("		             ");
 } 
      out.write("\r\n");
      out.write("	            		\r\n");
      out.write("	            		\r\n");
      out.write("	            </tbody>\r\n");
      out.write("	        </table>\r\n");
      out.write("	        ");
 } 
      out.write("\r\n");
      out.write("        <br><br><br>\r\n");
      out.write(" \r\n");
      out.write("	\r\n");
      out.write("	    <!-- ?????? ?????? -->\r\n");
      out.write("    <form action=\"");
      out.print( contextPath );
      out.write("/infoDelete.ce\" method=\"post\" id=\"delete-Info\">\r\n");
      out.write("        <div class=\"modal fade\" id=\"deleteInfo\">\r\n");
      out.write("            <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("    \r\n");
      out.write("                    <!-- Modal Header -->\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <h5 class=\"modal-title\">???????????? ?????? No.????????? ??????????????????!</h5>\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    <!-- Modal body -->\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <table>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <th>No.(??????)=></th>\r\n");
      out.write("                                <td>\r\n");
      out.write("                                    <input type=\"text\" name=\"deleteNo\">\r\n");
      out.write("                                </td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </div>\r\n");
      out.write("        \r\n");
      out.write("                <!-- Modal footer -->\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-secondary\">????????????</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">????????????</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("        \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("		let isLogIn = false;\r\n");
      out.write("	    \r\n");
      out.write("	    // ???????????? ???????????? true else false\r\n");
      out.write("	    if(\"");
      out.print( loginMember );
      out.write("\" != \"null\"){\r\n");
      out.write("	        isLogIn = true;\r\n");
      out.write("	    }\r\n");
      out.write("	\r\n");
      out.write("	    // ???????????? ??????????????? ????????????????????? forMember??? ????????? ????????? ?????? X\r\n");
      out.write("	    if(!isLogIn){\r\n");
      out.write("	        $('.forMember').click(function(e){\r\n");
      out.write("	            alert(\"????????? ??? ????????? ???????????????. ????????? ???????????????????\");\r\n");
      out.write("	            e.preventDefault();\r\n");
      out.write("	            location.href=\"");
      out.print( contextPath );
      out.write("/loginForm.me\";\r\n");
      out.write("	        })\r\n");
      out.write("	    }\r\n");
      out.write("    \r\n");
      out.write("	    \r\n");
      out.write("	    \r\n");
      out.write("	    var acc = document.getElementsByClassName(\"accordion\");\r\n");
      out.write("	    var i;\r\n");
      out.write("\r\n");
      out.write("	    for (i = 0; i < acc.length; i++) {\r\n");
      out.write("	      acc[i].addEventListener(\"click\", function() {\r\n");
      out.write("	        this.classList.toggle(\"active\");\r\n");
      out.write("	        var panel = this.nextElementSibling;\r\n");
      out.write("	        if (panel.style.maxHeight) {\r\n");
      out.write("	          panel.style.maxHeight = null;\r\n");
      out.write("	        } else {\r\n");
      out.write("	          panel.style.maxHeight = panel.scrollHeight + \"px\";\r\n");
      out.write("	        } \r\n");
      out.write("	      });\r\n");
      out.write("	    }\r\n");
      out.write("	    \r\n");
      out.write("	    \r\n");
      out.write("    </script>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("		<div align=\"center\" class=\"paging-area\">\r\n");
      out.write("			");
 if(currentPage != 1 ) { 
      out.write("\r\n");
      out.write("				<button onclick=\"location.href='");
      out.print( contextPath);
      out.write("/infoList.ce?cpage=");
      out.print( currentPage -1 );
      out.write("'\" class=\"btn btn-sm\">&lt;</button>\r\n");
      out.write("			");
 } 
      out.write("\r\n");
      out.write("			");
 for(int i = startPage; i <= endPage; i++) { 
      out.write("\r\n");
      out.write("				");
 if(i != currentPage) { 
      out.write("\r\n");
      out.write("					<button onclick=\"location.href='");
      out.print( contextPath);
      out.write("/infoList.ce?cpage=");
      out.print( i );
      out.write("'\" class=\"btn btn-sm\" >");
      out.print( i );
      out.write("</button>\r\n");
      out.write("				");
 } else { 
      out.write("\r\n");
      out.write("					<button class=\"btn btn-sm btn-red\" style=\"font-weight: 1000; text-decoration: underline; color:red;\" disabled>");
      out.print( i );
      out.write("</button>\r\n");
      out.write("				");
 } 
      out.write("		\r\n");
      out.write("			\r\n");
      out.write("			");
 } 
      out.write("\r\n");
      out.write("			");
 if(currentPage != maxPage) { 
      out.write(" \r\n");
      out.write("				<button onclick=\"location.href='");
      out.print( contextPath);
      out.write("/infoList.ce?cpage=");
      out.print( currentPage +1 );
      out.write("'\" class=\"btn btn-sm\">&gt;</button>\r\n");
      out.write("			");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<br><br><br><br><br><br><br><br><br>\r\n");
      out.write("	<!-- footer start -->\r\n");
      out.write("	");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<style>\n");
      out.write("    .footer *{\n");
      out.write("        margin: auto;\n");
      out.write("    }\n");
      out.write("    .footer-wrapper{\n");
      out.write("        width: 1130px;\n");
      out.write("        height: 100%;\n");
      out.write("        display: flex;\n");
      out.write("    }\n");
      out.write("    .footer{\n");
      out.write("        border-top: 1px solid #FFD000;\n");
      out.write("        display: flex;\n");
      out.write("        flex-direction: row;\n");
      out.write("        resize: none;\n");
      out.write("    }\n");
      out.write("    .footer__row{\n");
      out.write("        background-color: #FAFBFC;\n");
      out.write("        height: 100px;\n");
      out.write("        width: 100%;\n");
      out.write("        padding: 20px;\n");
      out.write("    }\n");
      out.write("    .footer__row--head{\n");
      out.write("        margin-bottom: 10px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<title>??????</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <div class=\"footer-wrapper\">\n");
      out.write("            <div class=\"footer__row\">\n");
      out.write("                <div>\n");
      out.write("                    <h2 class=\"footer__row--head\">????????? ?????????</h2>\n");
      out.write("                    <p>\n");
      out.write("                        ???????????? ?????????????????? ?????? ?????? ????????? ???????????? <br>?????? ???????????? ??????\n");
      out.write("                        ???????????? ?????? ?????? ????????????<br> ??? ?????? ????????? ?????? ??????????????? ????????????.\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer__row\">\n");
      out.write("                <div>\n");
      out.write("                    <h4 class=\"footer__row--head\">(???) ?????????????????????</h4>\n");
      out.write("                    <span>?????? : ?????????</span><br>\n");
      out.write("                    <span>?????? : ?????? ?????????</span><br>\n");
      out.write("                    <span>????????????????????? : 1234-56-1234</span><br>\n");
      out.write("                    <span>Copyright???????????????????? All rights reserved.</span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer__row\">\n");
      out.write("                <div>\n");
      out.write("                    <h3 class=\"footer__row--head\">????????????</h3>\n");
      out.write("                    <h4>???????????? : 02-123-4567</h4>\n");
      out.write("                    <p>???-??? 10:00 ~ 17:00 (?????? 12:30 ~ 13:30)<br>??????/????????? ??????</p>\n");
      out.write("                    <p>Fax : 02-0000-0000</p>\n");
      out.write("                    <p>Email : chicken@asdasd.com</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

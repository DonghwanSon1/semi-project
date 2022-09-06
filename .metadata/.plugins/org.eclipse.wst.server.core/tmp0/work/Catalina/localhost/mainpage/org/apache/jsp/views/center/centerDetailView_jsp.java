/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.79
 * Generated at: 2022-07-27 05:26:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.center;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.center.model.vo.*;
import com.kh.member.model.vo.Member;

public final class centerDetailView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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

	Center c = (Center)request.getAttribute("c");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>닭치고 이거닭</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("    	.outer{\r\n");
      out.write("		background-color: white;\r\n");
      out.write("		color: black;\r\n");
      out.write("		width: 1000px;\r\n");
      out.write("		margin: auto;\r\n");
      out.write("		margin-top: 30px;\r\n");
      out.write("	}\r\n");
      out.write("    #detail-area{\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        border: 2px solid black;\r\n");
      out.write("    }\r\n");
      out.write("    .content{\r\n");
      out.write("        text-align: left;\r\n");
      out.write("        height: 350px;\r\n");
      out.write("    }\r\n");
      out.write("    .center-modify-btn{\r\n");
      out.write("    	display: flex;\r\n");
      out.write("    	flex-direction: row;\r\n");
      out.write("    	justify-content: center;\r\n");
      out.write("    }\r\n");
      out.write("    .center-modify-btn * {\r\n");
      out.write("    	margin: 0 5px;\r\n");
      out.write("    }\r\n");
      out.write("	#replyContent{\r\n");
      out.write("		width: 700px;\r\n");
      out.write("		height: 100px;\r\n");
      out.write("	}\r\n");
      out.write("	#reply-area tbody{\r\n");
      out.write("		width: 700px;\r\n");
      out.write("		height: 50px;\r\n");
      out.write("	}\r\n");
      out.write("    \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("			<!-- header start -->\r\n");
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
      out.write("	      	// 웹 어플리케이션의 디렉토리 구조가 url에 노출된다 => 보안에 취약\n");
      out.write("	      	// 단순한 정적인 페이지 요청이라고 하더라도 반드시 Servlet을 거쳐서 화면을 띄워주자\n");
      out.write("	      	// => url에 서블릿 맴핑값만 노출되게씀 하겠다.\n");
      out.write("	      	// localhost:8001/jsp/매핑\n");
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
      out.write("/resources/img/icon.png\" alt=\"메인_로고\">\n");
      out.write("                                </a>\n");
      out.write("                                <div>\n");
      out.write("                                    <img class=\"logo__title--sm\" src=\"");
      out.print( contextPath );
      out.write("/resources/img/title.png\" alt=\"닭치고_이거닭\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"main_title\">\n");
      out.write("                            <img src=\"");
      out.print( contextPath );
      out.write("/resources/img/title.png\" alt=\"닭치고_이거닭\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div id=\"search\" class=\"search_area\">\n");
      out.write("                            <div class=\"input-group mb-3\">\n");
      out.write("                                <input type=\"text\" autofocus class=\"form-control\" placeholder=\"검색어를 입력하세요\" name=\"sch\">\n");
      out.write("                                <div class=\"input-group-append\">\n");
      out.write("                                    <button onclick=\"searchProduct();\" class=\"btn btn-outline-secondary\" type=\"button\">\n");
      out.write("                                        <i class=\"fa-solid fa-lg fa-magnifying-glass\"></i>\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- 검색 기능 -->\n");
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
      out.write("                                <a href=\"javascript:loginformPage();\" >로그인</a>\n");
      out.write("                                <span>|</span>\n");
      out.write("                                <a href=\"");
      out.print( contextPath );
      out.write("/loginenroll.me\">회원가입</a>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                                <a href=\"#\">장바구니</a>\n");
      out.write("                                <span>|</span>\n");
      out.write("                                <a href=\"");
      out.print( contextPath );
      out.write("/logout.me\">로그아웃</a>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                                <span>|</span>\n");
      out.write("                                <a href=\"");
      out.print( contextPath);
      out.write("/center.ce?cpage=1\">고객센터</a>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    ");
 if(loginMember != null){ 
      out.write("\n");
      out.write("                        <div class=\"user_greeting\">\n");
      out.write("                            <div class=\"user_greeting--user_name\">\n");
      out.write("                                <h3>");
      out.print( loginMember.getMemberName() );
      out.write("님</h3>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"user_greeting--greeting\">\n");
      out.write("                                    <p>즐거운 쇼핑 되세요!</p>\n");
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
      out.write("    <!-- nav 시작 -->\n");
      out.write("    <nav class=\"navbar navbar-expand-sm sticky\"> <!-- bg-light 지움 -->\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" class=\"dropdown-toggle\">상품구매</div>\n");
      out.write("            <div class=\"dropdown-content\"> \n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/allproduct.pr\">전체상품</a>\n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/newproduct.pr\">신상품</a>\n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/rankingproduct.pr\">랭킹상품</a>\n");
      out.write("                <a href=\"");
      out.print( contextPath );
      out.write("/saleproduct.pr\">할인상품</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" onclick=\"location.href='");
      out.print( contextPath );
      out.write("/list.ev' \">이벤트</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" onclick=\"location.href='");
      out.print( contextPath );
      out.write("/list.bo?cpage=1' \">자유게시판</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" onclick=\"location.href='");
      out.print(contextPath );
      out.write("/list.no?cpage=1' \">공지사항</div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"dropdown\">\n");
      out.write("            <div type=\"button\" class=\"dropdown-toggle\">마이페이지</div>\n");
      out.write("            <div class=\"dropdown-content\">\n");
      out.write("                <a class=\"forMember\" href=\"");
      out.print( contextPath );
      out.write("/cart.my\">장바구니</a>\n");
      out.write("                <a class=\"forMember\" href=\"");
      out.print( contextPath );
      out.write("/orderHistory.my\">주문내역</a>\n");
      out.write("                <a class=\"forMember\" href=\"");
      out.print( contextPath );
      out.write("/address.my\">배송지관리</a>\n");
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
      out.write('\r');
      out.write('\n');
      out.write('	');

		String MemberId = loginMember.getMemberId();
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"outer\">\r\n");
      out.write("	\r\n");
      out.write("		<br>\r\n");
      out.write("		<h3 align=\"center\">1:1 문의</h3>\r\n");
      out.write("		<br>\r\n");
      out.write("        <table class=\"table\" id=\"detail-area\" align=\"center\" border=\"1\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th width=\"80\">제목</th>\r\n");
      out.write("                <td width=\"380\" colspan=\"3\">");
      out.print( c.getCenterTitle() );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>작성자</th>\r\n");
      out.write("                <td>");
      out.print( c.getCenterWriter() );
      out.write("</td>\r\n");
      out.write("                <th>작성일</th>\r\n");
      out.write("                <td>");
      out.print( c.getCreateDate() );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th>내용</th>\r\n");
      out.write("                <td colspan=\"3\">\r\n");
      out.write("                    <p class=\"content\"> ");
      out.print( c.getCenterContent());
      out.write("\r\n");
      out.write("                    </p>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("        <br><br>\r\n");
      out.write("\r\n");
      out.write("        <div align=\"center\">\r\n");
      out.write("        	<div class=\"center-modify-btn\">\r\n");
      out.write("        		<a href=\"");
      out.print(contextPath);
      out.write("/list.ce?cpage=1\" class=\"btn btn-warning\">목록</a>\r\n");
      out.write("           		 <!-- 작성자만 보이게끔 -->\r\n");
      out.write("          		 <!-- 로그인이 되어있고, 그리고 현재 로그인된 사용자가 작성자와 동일할 경우 -->\r\n");
      out.write("           		");
 if(loginMember != null && loginMember.getMemberId().equals(MemberId)) { 
      out.write("\r\n");
      out.write("           			");
 if(!(MemberId.equals("admin"))) { 
      out.write("\r\n");
      out.write("                		<a href=\"");
      out.print(contextPath);
      out.write("/updateForm.ce?ceno=");
      out.print( c.getCenterNo() );
      out.write("\" class=\"btn btn-warning\">수정하기</a> <!-- /updateForm.no -->\r\n");
      out.write("        			");
 } 
      out.write("\r\n");
      out.write("                	<button data-toggle=\"modal\" data-target=\"#myModal\" class=\"btn btn-warning\">삭제하기</button>\r\n");
      out.write("       			");
 } 
      out.write("\r\n");
      out.write("        	</div>\r\n");
      out.write("          \r\n");
      out.write("            \r\n");
      out.write("			\r\n");
      out.write("			<br><br>\r\n");
      out.write("		        <!-- 댓글창 !! 일단 화면만 -->\r\n");
      out.write("        <div id=\"reply-area\">\r\n");
      out.write("            <table border=\"1\" align=\"center\">\r\n");
      out.write("                <thead>\r\n");
      out.write("					");
 if(loginMember != null && loginMember.getMemberId().equals(MemberId)) { 
      out.write("\r\n");
      out.write("                        <!-- 로그인 O -->\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th style=\"width: 100px\">댓글작성</th>\r\n");
      out.write("                            <td style=\"width: 90px\">\r\n");
      out.write("                                <textarea id=\"replyContent\" cols=\"100\" rows=\"5\" style=\"resize:none\"></textarea>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td colspan=\"2\"  style=\"width: 100px\" align=\"center\"><button onclick=\"insertReply();\">댓글등록</button></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                     ");
 } 
      out.write("\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody id=\"reply-content\">\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("            <br>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      <script>\r\n");
      out.write("\r\n");
      out.write("        function selectReplyList(){\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("\r\n");
      out.write("                url : \"rlist.ce\",\r\n");
      out.write("                data : {ceno : ");
      out.print( c.getCenterNo() );
      out.write("},\r\n");
      out.write("                success : function(list){\r\n");
      out.write("\r\n");
      out.write("                	// 댓글갯수만큼 반복 => 누적(문자열)\r\n");
      out.write("                	var result = \"\";\r\n");
      out.write("                	for(var i in list){\r\n");
      out.write("						\r\n");
      out.write("                		result += \"<tr>\"\r\n");
      out.write("                		  		+ \"<td align='center'>\" + \"<input type='hidden' class='reno' name='reno' value='\" +list[i].replyNo +\"'>\"\r\n");
      out.write("								+          list[i].replyWriter + \"</td>\"\r\n");
      out.write("                		  		+ \"<td>\" + list[i].replyContent + \"</td>\"\r\n");
      out.write("                		  		+ \"<td>\" + list[i].createDate + \"</td>\"\r\n");
      out.write("                		  		+ \"<td>\" + \"<a class='reply-dlt-btn' align='center' style='width: 50px'>삭제</a>\" + \"</td>\"\r\n");
      out.write("                		  		+ \"</tr>\";\r\n");
      out.write("                	}\r\n");
      out.write("                	\r\n");
      out.write("                	$(\"#reply-area tbody\").html(result);\r\n");
      out.write("                },\r\n");
      out.write("                error : function(){\r\n");
      out.write("                    console.log(\"댓글 읽어오기 실패 했습니다. 다시 시도해주세요!\");\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // 댓글은 화면이 로딩되었을 때 곧바로 뿌려줘야된다. => window.onload => $(function(){})\r\n");
      out.write("        $(function(){\r\n");
      out.write("        	 selectReplyList();\r\n");
      out.write("        	\r\n");
      out.write("        	 setInterval(selectReplyList, 1000);\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        function insertReply(){\r\n");
      out.write("        	\r\n");
      out.write("        	$.ajax({\r\n");
      out.write("        		url : \"rinsert.ce\",\r\n");
      out.write("        		data : {\r\n");
      out.write("        			ceno : ");
      out.print( c.getCenterNo() );
      out.write(",\r\n");
      out.write("        			content : $(\"#replyContent\").val()		\r\n");
      out.write("        		},\r\n");
      out.write("        		type : \"post\",\r\n");
      out.write("        		success : function(result){\r\n");
      out.write("        			\r\n");
      out.write("        			// result값에 따라서 성공했으면 성공메시지 띄우기\r\n");
      out.write("        			if(result > 0 ){\r\n");
      out.write("        				alert(\"댓글 작성했습니다.\");\r\n");
      out.write("        				\r\n");
      out.write("        				selectReplyList();\r\n");
      out.write("        				\r\n");
      out.write("        				$(\"#replyContent\").val(\"\");\r\n");
      out.write("        			}\r\n");
      out.write("        			\r\n");
      out.write("        		},\r\n");
      out.write("        		error : function(){\r\n");
      out.write("        			console.log(\"댓글 작성 실패했습니다!\");\r\n");
      out.write("        		}\r\n");
      out.write("        	});\r\n");
      out.write("        	\r\n");
      out.write("        }\r\n");
      out.write("        //================ 댓글 삭제 기능 =======================================\r\n");
      out.write("        $(document).on(\"click\",\".reply-dlt-btn\", function deleteReply(){\r\n");
      out.write("        	\r\n");
      out.write("        	$.ajax({\r\n");
      out.write("        		url : \"rdelete.ce\",\r\n");
      out.write("        		data : {\r\n");
      out.write("        			reno : $(this).parents(\"tr\").children(\"td\").children(\".reno\").val()\r\n");
      out.write("        		},\r\n");
      out.write("        		type : \"post\",\r\n");
      out.write("        		success : function(result){\r\n");
      out.write("        			\r\n");
      out.write("        			// result값에 따라서 성공했으면 성공메시지 띄우기\r\n");
      out.write("        			if(result > 0 ){\r\n");
      out.write("        				alert(\"댓글 삭제했습니다.\");\r\n");
      out.write("        				\r\n");
      out.write("        				selectReplyList();\r\n");
      out.write("        				\r\n");
      out.write("        				$(\"#replyContent\").val(\"\");\r\n");
      out.write("        			}\r\n");
      out.write("        			\r\n");
      out.write("        		},\r\n");
      out.write("        		error : function(){\r\n");
      out.write("        			console.log(\"댓글 삭제 실패했습니다!\");\r\n");
      out.write("        		}\r\n");
      out.write("        	});\r\n");
      out.write("        	\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("    </script>\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("		<br><br><br>\r\n");
      out.write("    <!-- The Modal -->\r\n");
      out.write("    <div class=\"modal\" id=\"myModal\">\r\n");
      out.write("        <div class=\"modal-dialog\">\r\n");
      out.write("            <div class=\"modal-content\">\r\n");
      out.write("    \r\n");
      out.write("		        <!-- Modal Header -->\r\n");
      out.write("		        <div class=\"modal-header\">\r\n");
      out.write("		          <h4 class=\"modal-title\">삭제하시겠습니까??</h4>\r\n");
      out.write("		          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("		        </div>\r\n");
      out.write("		    \r\n");
      out.write("		        <!-- Modal footer -->\r\n");
      out.write("		        <div class=\"modal-footer\">\r\n");
      out.write("		            <a href=\"");
      out.print( contextPath );
      out.write("/delete.ce?ceno=");
      out.print( c.getCenterNo() );
      out.write("\" class=\"btn btn-warning\">삭제하기</a>\r\n");
      out.write("		            <button type=\"button\" class=\"btn btn-warning\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("		        </div>\r\n");
      out.write("        \r\n");
      out.write("    		</div>\r\n");
      out.write("    	</div>\r\n");
      out.write("    </div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<br><br><br><br><br><br><br><br><br>\r\n");
      out.write("</body>\r\n");
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
      out.write("<title>푸터</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <div class=\"footer-wrapper\">\n");
      out.write("            <div class=\"footer__row\">\n");
      out.write("                <div>\n");
      out.write("                    <h2 class=\"footer__row--head\">닭치고 이거닭</h2>\n");
      out.write("                    <p>\n");
      out.write("                        바쁜일상 충분한단백질 또는 영양 섭취에 어려움을 <br>겪는 사람들을 위해\n");
      out.write("                        간편하고 빠른 건강 식품추천<br> 및 제공 업체를 소개 해주기위한 곳입니다.\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer__row\">\n");
      out.write("                <div>\n");
      out.write("                    <h4 class=\"footer__row--head\">(주) 버터구이오징어</h4>\n");
      out.write("                    <span>대표 : 김정길</span><br>\n");
      out.write("                    <span>주소 : 중구 신당동</span><br>\n");
      out.write("                    <span>사업자등록번호 : 1234-56-1234</span><br>\n");
      out.write("                    <span>Copyright©닭치고이거닭 All rights reserved.</span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer__row\">\n");
      out.write("                <div>\n");
      out.write("                    <h3 class=\"footer__row--head\">고객센터</h3>\n");
      out.write("                    <h4>대표번호 : 02-123-4567</h4>\n");
      out.write("                    <p>월-금 10:00 ~ 17:00 (점심 12:30 ~ 13:30)<br>주말/공휴일 제외</p>\n");
      out.write("                    <p>Fax : 02-0000-0000</p>\n");
      out.write("                    <p>Email : chicken@asdasd.com</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\r\n");
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
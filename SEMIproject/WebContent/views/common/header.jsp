	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.kh.member.model.vo.Member" %>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
	String alertMsg = (String)session.getAttribute("alertMsg");
	String contextPath = (String)request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Header</title>
    <!-- bootstrap -->
	<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- fontAwesome -->
    <script src="https://kit.fontawesome.com/567fbbaed5.js" crossorigin="anonymous"></script>
	<script>
	 function loginformPage(){

	      	// 웹 어플리케이션의 디렉토리 구조가 url에 노출된다 => 보안에 취약
	      	// 단순한 정적인 페이지 요청이라고 하더라도 반드시 Servlet을 거쳐서 화면을 띄워주자
	      	// => url에 서블릿 맴핑값만 노출되게씀 하겠다.
	      	// localhost:8001/jsp/매핑

	      	location.href = "<%= contextPath %>/loginform.me";
	      	
	  }
	</script>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
</head>
<body>
	<div class="header-wrapper">
        <header id="header" role="banner">
            <div class="web-header">
                <div class="special_bg">
                    <div class="group_flex">

                        <div class="logo_area">
                            <div class="logo_default">
                                <a href="<%= contextPath %>" class="logo__img">
                                    <img src="<%= contextPath %>/resources/img/icon.png" alt="메인_로고">
                                </a>
                                <div>
                                    <img class="logo__title--sm" src="<%= contextPath %>/resources/img/title.png" alt="닭치고_이거닭">
                                </div>
                            </div>
                        </div>

                        <div class="main_title">
                            <img src="<%= contextPath %>/resources/img/title.png" alt="닭치고_이거닭">
                        </div>

                        <div id="search" class="search_area">
                            <div class="input-group mb-3">
                                <input type="text" autofocus class="form-control" placeholder="검색어를 입력하세요" name="sch">
                                <div class="input-group-append">
                                    <button onclick="searchProduct();" class="btn btn-outline-secondary" type="button">
                                        <i class="fa-solid fa-lg fa-magnifying-glass"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <!-- 검색 기능 -->
                        <script>
                            function searchProduct(){
                                const keyword = $('.form-control').val();
                                
                                location.href = "<%= contextPath %>/search.pr?keyword=" + keyword;
                            }
                        </script>

                        <div class="service_area">
                            <% if(loginMember == null) { %>
                                <a href="javascript:loginformPage();" >로그인</a>
                                <span>|</span>
                                <a href="<%= contextPath %>/loginenroll.me">회원가입</a>
                            <% } else { %>
                                <a href="#">장바구니</a>
                                <span>|</span>
                                <a href="<%= contextPath %>/logout.me">로그아웃</a>
                            <% } %>
                                <span>|</span>
                                <a href="<%= contextPath%>/center.ce?cpage=1">고객센터</a>
                        </div>

                    <% if(loginMember != null){ %>
                        <div class="user_greeting">
                            <div class="user_greeting--user_name">
                                <h3><%= loginMember.getMemberName() %>님</h3>
                            </div>
                            <div class="user_greeting--greeting">
                                    <p>즐거운 쇼핑 되세요!</p>
                            </div>
                        </div>
                    <% } %>

                    </div>
                </div>
            </div>
        </header>
    </div>

    <!-- nav 시작 -->
    <nav class="navbar navbar-expand-sm sticky"> <!-- bg-light 지움 -->

        <div class="dropdown">
            <div type="button" class="dropdown-toggle">상품구매</div>
            <div class="dropdown-content"> 
                <a href="<%= contextPath %>/allproduct.pr">전체상품</a>
                <a href="<%= contextPath %>/newproduct.pr">신상품</a>
                <a href="<%= contextPath %>/rankingproduct.pr">랭킹상품</a>
                <a href="<%= contextPath %>/saleproduct.pr">할인상품</a>
            </div>
        </div>

        <div class="dropdown">
            <div type="button" onclick="location.href='<%= contextPath %>/list.ev' ">이벤트</div>
        </div>

        <div class="dropdown">
            <div type="button" onclick="location.href='<%= contextPath %>/list.bo?cpage=1' ">자유게시판</div>
        </div>

        <div class="dropdown">
            <div type="button" onclick="location.href='<%=contextPath %>/list.no?cpage=1' ">공지사항</div>
        </div>

        <div class="dropdown">
            <div type="button" class="dropdown-toggle">마이페이지</div>
            <div class="dropdown-content">
                <a class="forMember" href="<%= contextPath %>/cart.my">장바구니</a>
                <a class="forMember" href="<%= contextPath %>/orderHistory.my">주문내역</a>
                <a class="forMember" href="<%= contextPath %>/address.my">배송지관리</a>
            </div>
        </div>

    </nav>

 	<script>
 		const msg = "<%= alertMsg %>";
 		
 		if(msg != "null"){
 			alert(msg);
 			
 			<% session.removeAttribute("alertMsg"); %>
 		}
 		
 		
 	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%
	String contextPath = (String)request.getContextPath();
%>



 
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">

	<style>
		.sns-login-list img{
			width: 25px;
			height: 25px;
		}
	</style>
    <title>로그인</title>
    
    <script>
    	
    	 function loginEnrollformPage(){

    	   		location.href = "<%= contextPath %>/loginenroll.me";
    	      	
    	  }
    	 
    	 function IdPwdFindformPage(){

 	      	

 	      	location.href = "<%= contextPath %>/idpwdfindform.me";
 	      	
 	  }
    	 
    </script>
    
    
  </head>
  <body>
  <form action="<%= contextPath %>/login.me" method="post" id="login-form">
    <section class = "login">
        <div class="login-greeting">
            <strong class="txt">안녕하세요 :) </strong>
            <p class="message"><i class="ico-logo-login"></i><span class="blind">닭치고 이거닭</span>입니다.</p>
        </div>
        <ul>
          <li><input type="text" placeholder = "아이디" name = "memberId" class = "ssss"/></li>
          <li><input type="password" placeholder = "비밀번호" name = "memberPwd" class = "ss"/></li>
          
          <li><button type="submit"><span>로그인</span></button></li>
          </ul>
          <div>

            <div class="sns-login">
                <ul class="sns-login-list">
                    <li>
                        <a href=""><img class="kakao" src="${pageContext.request.contextPath}/resources/img/kakaotalk.png"></a>
                        </li>
                    <li>
                        <a href=""><img class="google" src="${pageContext.request.contextPath}/resources/img/google.png"></a>
                        </li>
                    <li>
                            <a href=""><img class="google" src="${pageContext.request.contextPath}/resources/img/naver.png"></span></a>
                        </li>
                   
                </ul>
            </div>
            <ul>
              <li><a href="javascript:loginEnrollformPage();">회원가입</a></li>
              <li><a href="javascript:IdPwdFindformPage();">아이디찾기</a></li>
              <li><a href="javascript:IdPwdFindformPage();">비밀번호찾기</a></li>
            </ul>
          </div>
          <a href = "">비회원 주문조회</a>
        </section>
     </form>
  </body>
</html>



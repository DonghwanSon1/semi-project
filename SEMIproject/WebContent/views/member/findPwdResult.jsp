<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.kh.member.model.vo.Member" %>
  <%
  Member m = (Member)session.getAttribute("loginMember"); 
	String alertMsg = (String)session.getAttribute("alertMsg");
	String contextPath = (String)request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭치고 이거닭</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/idpwdFind.css" />
	
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
    	var msg = "<%= alertMsg %>";
    	
    	if(msg != "null"){
          	alert(msg);

          	// session에 들어있는 alertMsg키값에 대한 밸류를 지워줘야한다.
          	// 왜?? menubar.jsp가 로딩될때마다 매번 alert이 뜨기때문에
          	// => XXX.removeAttribute("키");
          	<% session.removeAttribute("alertMsg2"); %>
          }
    	
		
  
    </script>


</head>
<body>
	<div id="wrap">

		<div id="contents" >
			<div class="nBox mt80 mb80">
				<p class="title">아이디 / 비밀번호 찾기</p>
			</div>
			<div class="memberArea find">
				<div class="inBox">
					<dl class="memTit">
						<dt>당신의 ID는</dt>
						<dd><h3><%= m.getMemberId() %>입니다</h3></dd>
					</dl>
					<form Name="idForm" action="/_proc/findID_OK.asp" Method="Post" target="iframes" onsubmit="idFind(this); return false;">
					<div class="fildBox mt15" style="display: none;">
						<input type="text" name="membername" id="username" maxlength="50" value="" placeholder="이름 입력" />
						<input type="text" name="email" id="email" maxlength="50" value="" placeholder="이메일 입력" />

						<div class="btnArea one">
							<input type="submit" value="찾기" class="btns ok" />
						</div>
					</div>
					</form>
				</div>
				<div class="inBox">
					<dl class="memTit">
						<dt>당신의 password는</dt>
						<dd><h3><%= m.getMemberPwd() %>입니다</h3></dd>
					</dl>
					<form Name="pwdForm" action="/_proc/findPwd_OK.asp" Method="Post" target="iframes" onsubmit="pwdFind(this); return false;">
					<div class="fildBox mt15" style="display: none;">
						<input type="text" maxlength="15" name="memberId" id="userid" value="" placeholder="아이디 입력" />
						<select id="question" class="sel" name="question" >
				              <option value="0">질문 선택</option>
				              <option value="1">자신의 보물 1호는?</option>
				              <option value="2">가장 기억에 남는 선생님 성함은?</option>
				              <option value="3">다시 태어나면 되고 싶은것은?</option>
				              <option value="4">존경하는 인물은?</option>
				              <option value="5">자신의 인생 좌우명은?</option>
          				</select>             
						<input type="text" maxlength="50" name="answer" id="answer" value="" placeholder="답변 입력" />

						<div class="btnArea one">
							<input type="submit" value="찾기" class="btns ok" />
						</div>
					</div>
					</form>
				</div>

				<iframe name='iframes' frameborder='0' width='100%' height='0'></iframe>
			</div>
		</div>
	</div>
	<iframe name="actFrm" frameborder="0" width="100%" height="0" style="display:none;"></iframe>
</div>
</body>
</html>
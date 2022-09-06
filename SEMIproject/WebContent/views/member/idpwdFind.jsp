<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String contextPath = (String)request.getContextPath();
    String alertMsg = (String)session.getAttribute("alertMsg");
	%>
 


<!DOCTYPE html>
<html lang="ko" class="sub">
<head>
	

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/idpwdFind.css" />
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
		

	<script>
	
	var msg = "<%= alertMsg %>";
	
	if(msg != "null"){
      	alert(msg);

      	<% session.removeAttribute("alertMsg"); %>
      }
	
	
	</script>

	<script type="text/javascript">
	
	
	
	
	
	
	
	function idFind(frm){
		if (frm.username.value == ""){
			alert("성명을 입력하세요.");
			frm.username.focus();
			return;
		}
		if (frm.email.value == ""){
			alert("이메일을 입력하세요.");
			frm.email.focus();
			return;
		}
		frm.submit();
	}

	function pwdFind(frm){
		if (frm.userid.value == ""){
			alert("아이디를 입력하세요.");
			frm.userid.focus();
			return;
		}
		if (frm.question.value == "0"){
			alert("질문을선택하세요.");
			frm.username.focus();
			return;
		}
		if (frm.answer.value == ""){
			alert("답변을 입력하세요.");
			frm.answer.focus();
			return;
		}
		frm.submit();
	}
	//-->
	</script>
</head>

<body >

<div id="wrap">

		<div id="contents" >
			<div class="nBox mt80 mb80">
				<p class="title">아이디 / 비밀번호 찾기</p>
			</div>
			<div class="memberArea find">
				<div class="inBox">
					<dl class="memTit">
						<dt>아이디 찾기</dt>
						<dd>가입시 입력하신 이름을 입력해주세요.</dd>
					</dl>
					<form action="<%= contextPath %>/idFind.me" method="Post"  onsubmit="idFind(this); return false;">
					
					<div class="fildBox mt15">
						<input type="text" name="memberName" id="username" maxlength="50" value="" placeholder="이름 입력" />
						<input type="text" name="email" id="email" maxlength="50" value="" placeholder="이메일 입력" />

						<div class="btnArea one">
							<button type="submit" class="btns ok" >찾기</button>
						</div>
					</div>
					</form>
				</div>
				<div class="inBox">
					<dl class="memTit">
						<dt>비밀번호 찾기</dt>
						<dd>가입시 입력하신 아이디, 질문, 답변을 입력해주세요.</dd>
					</dl>
					<form action="<%= contextPath %>/pwdFind.me" method="Post"  onsubmit="pwdFind(this); return false;">
					<div class="fildBox mt15">
						<input type="text" maxlength="15" name="memberId" id="userid" value="" placeholder="아이디 입력" />
						<select id="question" class="sel" name="question">
				              <option value="0">질문 선택</option>
				              <option value="1">자신의 보물 1호는?</option>
				              <option value="2">가장 기억에 남는 선생님 성함은?</option>
				              <option value="3">다시 태어나면 되고 싶은것은?</option>
				              <option value="4">존경하는 인물은?</option>
				              <option value="5">자신의 인생 좌우명은?</option>
          				</select>             
						<input type="text" maxlength="50" name="answer" id="answer" value="" placeholder="답변 입력" />

						<div class="btnArea one">
							<button type="submit" class="btns ok" >찾기</button>
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
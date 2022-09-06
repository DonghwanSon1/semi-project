<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList, com.kh.event.model.vo.Event, com.kh.common.model.vo.EventPageInfo" %>

<%
	ArrayList<Event> list = (ArrayList<Event>)request.getAttribute("list");
	EventPageInfo ei = (EventPageInfo)request.getAttribute("ei");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 페이지</title>
<style>
	img{
	width : 190px;
	height : 150px;
	}
	.outer{
	background-color : rgb(255, 255, 255);
	color: black;
	width: 1000px;
	height : 880px;
	margin:auto;
	margin-top : 50px;
	
	}
	.list-area{
		border : 1px solid black;
		width : 760px;
		margin:auto;
		background-image: linear-gradient(
        rgba(255, 255, 255, 0.459),
        rgba(253, 253, 253, 0.404)
      ), url("https://mblogthumb-phinf.pstatic.net/MjAxNzAyMTZfNzcg/MDAxNDg3MjU2NDM0OTk5.__tfgRmDGUJrekyvEGeUkgHV3_eVZZLR8v0vjyad4gwg.Q_MoAaUi4heEZGl6cYiMoGSjeYek2fFx0wstziFAjl8g.PNG.ultrainsup/%EB%8B%AD_%EC%BA%90%EB%A6%AD%ED%84%B03.png?type=w800");
		
	  background-repeat: no-repeat;
		background-size : 100%;
		
	}
	.thumbnail {
		border: 3x solid red;
		width: 190px;
		display: inline-block;
		margin: 27px;
		background-color : rgb(220, 243, 16);
		
	}
	.thumbnail:hover{
	cursor:pointer;
	opacity:0.6;
	}
	#enrollform-btn{
		position: relative;
		left: 1240px;

	}

</style>
</head>
<body>



<%@ include file="../common/header.jsp" %>



<div class="outer">
	
	
  
<h2 align="center">이벤트게시판</h2>
<hr>



<div class="list-area">
	<% if(list != null) { %>
		<% for(Event e : list) { %>
			<div class="thumbnail" align="center">
				<input type="hidden" value="<%= e.getEventNo()%>">
					<img src="<%= e.getEventtitleImg() %>">
	<p>
		<!--<%= e.getEventNo() %> /  이벤트넘버를 불러오는건데 필요없을 것 같아서 안넣었습니다.  --><%= e.getEventTitle() %> <br>
		조회수 : <%= e.getCount() %>
	</p>
	
		</div>
		<% } %>
		<% }else { %>
		등록된 게시글이 없습니다.
		<% } %>
	
	</div>

	<script>
		$(function(){

			$(".thumbnail").click(function(){
				var eno = $(this).children().eq(0).val();



				location.href = "<%= contextPath %>/detail.ev?eno=" + eno;


			});
		});



	</script>

</div>
<% if(loginMember != null && loginMember.getMemberId().equals("admin")) { %>
	<div id="enrollform-btn" align="right" style="width:850px">
		<a href="<%= contextPath %>/enrollForm.ev" class="btn btn-sm btn-info">글 작성하기</a>
		<br>
	</div>
<% } %>
<br>


<%@ include file="../common/footer.jsp" %>
</body>
</html>
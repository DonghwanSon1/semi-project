<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.notice.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// 페이징바 만들때 필요한 변수 미리 셋팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭치고 이거닭</title>
<style>
	.outer{
		background-color: white;
		color: black;
		width: 1000px;
		margin: auto;
		margin-top: 30px;
	}

    .table{
        text-align: center;
        border: 2px solid white;
        font-weight: 300;
    }
    .table>tbody>#notice-list:hover{
        cursor: pointer;

    }

	.btn-div a{
		margin: 0 95px;
	}
</style>
</head>
<body>

<!-- header start -->
	<%@ include file="../common/header.jsp" %>
	
	<div class="outer">
		<br><br><br><br>
       	<h4 align="left" style="color:black">공지사항 </h4>
	
	
		<div>
			<!-- 로그인한 회원만 보여지는 문의 : loginMember가 null인지 아닌지 판단 -->
			<% if(loginMember != null && loginMember.getMemberId().equals("admin")) { %>
				<a style="float: right;" id="write" href="<%=contextPath %>/enrollForm.no" class="btn btn-warning btn-sm">등록하기</a>
				<% } %>
		</div>
			
		<table align="center" border="1" class="table">
			<thead>
				<tr>
					<th width="300">제목</th>
					<th width="10">조회수</th>
					<th width="70">작성일</th>
				</tr>
			</thead>
			<tbody>
				<% if(list.isEmpty()) { %> <!-- 조회글 없음 -->
					<tr>
						<td colspan="3">조회된 문의가 없습니다.</td>
					</tr>
				<% } else { %>
					<!-- 반복문 사용 : list에 있는 값을 순차적으로 접근해서 뽑아오기 -->
					<% for(Notice n : list) { %>	
						<tr id="notice-list">
							<input type="hidden" value="<%=n.getNoticeNo() %>" name="nno">
							<td><%=n.getNoticeTitle() %></td>
							<td><%=n.getCount() %></td>
							<td><%=n.getCreateDate() %></td>
						</tr>
					<% } %>
				<% } %>					
			</tbody>
		</table>
	</div>

		<script>
			$(function(){
	
				$(".table>tbody>#notice-list").click(function(){
	
					//console.log("클릭~");
	
					// 클릭했을때 해당 공지사항의 번호를 넘겨야함
					// 해당 tr태그의 자손 중에서도 첫번째 td태그의 값만 필요함
	
					var nno = $(this).children().eq(0).val();
	
	
					// 글번호를 이용한 요청
					// => 대놓고 요청 => url에 키와 벨류를 대놓고 작성해서 요청을 보내버리겠다.
					// => GET방식 : 요청할 url?키=벨류&키=벨류&키=벨류...
					// "쿼리 스트링" : ? 뒤의 내용들, 직접 쿼리스트링을 만들어서 요청
					// localhost:8001/jsp/detail.no?nno=글번호
					
					location.href="<%=contextPath%>/detail.no?nno=" + nno;
				})
	
			})
		</script>


		<div align="center" class="paging-area">
			<% if(currentPage != 1 ) { %>
				<button onclick="location.href='<%= contextPath%>/list.no?cpage=<%= currentPage -1 %>'" class="btn btn-sm">&lt;</button>
			<% } %>
			<% for(int i = startPage; i <= endPage; i++) { %>
				<% if(i != currentPage) { %>
					<button onclick="location.href='<%= contextPath%>/list.no?cpage=<%= i %>'" class="btn btn-sm" ><%= i %></button>
				<% } else { %>
					<button class="btn btn-sm btn-red" style="font-weight: 1000; text-decoration: underline; color:red;" disabled><%= i %></button>
				<% } %>		
			
			<% } %>
			<% if(currentPage != maxPage) { %> 
				<button onclick="location.href='<%= contextPath%>/list.no?cpage=<%= currentPage +1 %>'" class="btn btn-sm">&gt;</button>
			<% } %>

		</div>
















		<br><br><br><br><br><br><br><br><br>

</body>
	<!-- footer start -->
	<%@ include file="../common/footer.jsp" %>
</html>
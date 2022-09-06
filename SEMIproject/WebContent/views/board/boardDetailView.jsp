<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.board.model.vo.*" %>


<%
     Board b = (Board)request.getAttribute("b");
	// 게시글 번호, 카테고리명, 제목, 내용, 작성자 아이디, 작성일
     
     Attachment at = (Attachment)request.getAttribute("at");
    // 파일번호, 원본명, 수정명, 저장경로
    
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
    .outer{
        background-color: white;
        color : black;
        width: 1000px;
        height : 800px;
        margin : auto;
        margin-top : 50px;

    }
    #detail-area{
        border : 3px solid yellow;
        
    }
    #backlist-btn{
        position: relative;
		left: 450px;

    }





</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>


	<div class="outer">
	
	<br>
	<h2 align="center">자유게시판</h2>
	<br>
	
	<table id="detail-area" align="center" border="1">
	
	<tr>
        <th width ="70" , bgcolor="#FFFF00";>카테고리</th>
        <td width="70"><%= b.getCategory() %></td>
        <th width="70", bgcolor="#00FF00">제목</th>
        <td width="370"><%= b.getBoardTitle() %></td>
    </tr>
    <tr>
        <th bgcolor="#E6E6FA">작성자</th>
        <td><%= b.getBoardWriter() %></td>
        <th bgcolor="#E6E6FA">작성일</th>
        <td><%= b.getCreateDate() %></td>
    </tr>
    <tr>
        <th bgcolor="#FFFF00">내용</th>
        <td colspan="3">
            <p style="height: 200px;"><%= b.getBoardContent() %></p>
            </td>
    </tr>
    <tr>
        <th bgcolor="#00FF00";>첨부파일</th>
        <td colspan="3">
            <!-- 첨부파일이 없을수도 있다. -->
            <% if(at == null) { %>
            	
			<% }else {%>


            <!-- 첨부파일이 있을수도 있다.-->
            <a download"<%= at.getOriginName() %> a href="<%= contextPath %>/<%= at.getFilePath()%>/<%=at.getChangeName() %>"><%= at.getOriginName() %></a>
            <% } %>
        </td>
    </tr>
	</table>
	
	<br>
	
	<div id="backlist-btn" align="right">
	<a href="<%= contextPath %>/list.bo?cpage=1" class="btn btn-sm btn-info">목록가기</a>
	
	<!-- 로그인한 사용자고 이 게시글의 작성자만 수정하고 삭제하기 -->
	<% if(loginMember !=null && b.getBoardWriter().equals(loginMember.getMemberId())) { %> 
		<a href="<%= contextPath %>/updateForm.bo?bno=<%= b.getBoardNo() %>" class="update btn-sm btn-warning" >수정하기</a>
		<a href="<%= contextPath %>/delete.bo?bno=<%=b.getBoardNo() %>" class="delete btn-sm btn-danger">삭제하기</a>
	
	<% } %>

	</div>

	</div>

<%@ include file="../common/footer.jsp" %>
</body>
</html>
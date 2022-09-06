<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.notice.model.vo.*" %>
<%
	Notice n = (Notice)request.getAttribute("n");
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
    #detail-area{
        text-align: center;
        border: 2px solid black;
    }
    .content{
        text-align: left;
        height: 350px;
    }
    .center-modify-btn{
    	display: flex;
    	flex-direction: row;
    	justify-content: center;
    }
    .center-modify-btn * {
    	margin: 0 5px;
    }
    
</style>
</head>
<body>

			<!-- header start -->
	<%@ include file="../common/header.jsp" %>
	
	<div class="outer">
	
		<br>
		<h4 align="left" style="color:black">공지사항 </h4>
		<br>
        <table class="table" id="detail-area" align="center" border="1">
            <tr>
                <th width="80">제목</th>
                <td width="380" colspan="3"><%= n.getNoticeTitle() %></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><%= n.getNoticeWriter() %></td>
                <th>작성일</th>
                <td><%= n.getCreateDate() %></td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    <p class="content"> <%= n.getNoticeContent() %>
                    </p>
                </td>
            </tr>
        </table>

        <br><br>

        <div align="center">
        	<div class="center-modify-btn">
        		<a href="<%=contextPath%>/list.no?cpage=1" class="btn btn-warning">목록</a>
           		 <!-- 작성자만 보이게끔 -->
          		 <!-- 로그인이 되어있고, 그리고 현재 로그인된 사용자가 작성자와 동일할 경우 -->
           		<% if(loginMember != null && loginMember.getMemberId().equals("admin")) { %>
               		<a href="<%=contextPath%>/updateForm.no?nno=<%= n.getNoticeNo() %>" class="btn btn-warning">수정하기</a>
                	<button data-toggle="modal" data-target="#myModal" class="btn btn-warning">삭제하기</button>
       			<% } %>
        	</div>
	      </div>
      
		<br><br><br>
    <!-- The Modal -->
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
    
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">삭제하시겠습니까??</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		    
		        <!-- Modal footer -->
		        <div class="modal-footer">
		            <a href="<%= contextPath %>/delete.no?nno=<%= n.getNoticeNo() %>" class="btn btn-warning">삭제하기</a>
		            <button type="button" class="btn btn-warning" data-dismiss="modal">취소</button>
		        </div>
        
    		</div>
    	</div>
    </div>
	</div>














<br><br><br><br><br><br><br><br><br>
</body>
	<!-- footer start -->
	<%@ include file="../common/footer.jsp" %>
</html>
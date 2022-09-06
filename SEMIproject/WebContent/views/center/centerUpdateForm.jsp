<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.center.model.vo.*" %>
<%
	Center c = (Center)request.getAttribute("c");
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
		height: 800px;
		margin: auto;
		margin-top: 50px;
	}
	#update-form input, #update-form textarea{
		width: 100%;
		box-sizing: border-box;
		border-radius: border-box;
	}
</style>

</head>
<body>
  	<!-- header start -->
	<%@ include file="../common/header.jsp" %>

		<div class="outer">
        <br><br><br>
        <h4 align="center">1:1 문의 수정하기</h4>
		
		<!-- 파일을 첨부하는 요청을 할 때는 반드시 enctype="multipart/form-data"를 추가해야한다. -->
        <form id="update-form" action="<%=contextPath %>/update.ce" method="post">
            
            <input type="hidden" value="<%= c.getCenterNo() %>" name="ceno">
            
            <!-- 제목, 내용, centerNo -->
            <table class="table" align="center" border="2">
                <tr>
                    <th width="80">제목</th>
                    <td colspan="3"><input size="70" class="form-control" type="text" name="title" placeholder="<%= c.getCenterTitle() %>" required></td>
                </tr>
                <tr>
	                <th>작성자</th>
	                <td><%= c.getCenterWriter() %></td>
	                <th>작성일</th>
	                <td><%= c.getCreateDate() %></td>
	            </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3">
                        <textarea name="content" class="form-control" cols="80" rows="11" placeholder="<%=c.getCenterContent() %>" style="resize: none;" required ></textarea>
                    </td>
                </tr>
            </table>
            
            <br><br>

            <div align="center">
                <button type="submit" class="btn btn-warning">수정하기</button>
                <button type="reset" onclick="history.back();"  class="btn btn-warning">취소하기</button>
            </div>
        </form>
    
    
    </div>


























<br><br><br>
</body>
<!-- footer start -->
<%@ include file="../common/footer.jsp" %>
</html>
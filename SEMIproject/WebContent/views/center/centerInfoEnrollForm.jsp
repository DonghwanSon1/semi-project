<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#enroll-form>table{border: 2px solid #FFD000;}
	#enroll-form input, #enroll-form textarea{
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
	
		<br>
		<h2 align="center">이용 안내 작성</h2>
		<br><br>
		<form action="<%= contextPath%>/infoInsert.ce" id="enroll-form" method="post">
			<table class="table" align="center">
				<tr>
					<th width="50">제목 : </th>
					<td width="450"><input class="form-control" type="text" required name="title"></td>
				</tr>
				<tr>
					<th>내용 : </th>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="content" class="form-control" rows="20" style="resize: none;" required></textarea>
					</td>
				</tr>
			</table>

			<br><br>

			<div align="center">
				<button type="submit" class="btn btn-secondary">등록하기</button>
				<button type="button" onclick="history.back();" class="btn btn-secondary">뒤로가기</button>
				<!-- history.back() 이전페이지로 돌아가게 해주는 함수 -->
			</div>


		</form>
	</div>



	<br><br><br><br><br><br><br><br><br>
	
</body>
		<!-- footer start -->
		<%@ include file="../common/footer.jsp" %>
</html>
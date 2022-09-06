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
	.form-title{
		display: flex;
		width: 100%;
	}
	.form-title>#form-title-header{
		width : 50%;
	}
</style>
</head>
<body>

		<!-- header start -->
	<%@ include file="../common/header.jsp" %>
	
		<div class="outer">
	
		<br>
		<h4 align="center">1:1 문의 작성</h4>
		<br><br>
		<form action="<%= contextPath%>/insert.ce" id="enroll-form" method="post">
		
			<input type="hidden" name="memberNo" value="<%= loginMember.getMemberNo() %>">
			<table class="table" align="center">
				<tr>
					<th width="90">문의 제목 : </th>
					<td width="450"><input id="title" name="title" placeholder="제목을 입력해주세요." class="form-control" type="text" required></td>
				</tr>
				<tr>
					<th>문의 내용 : </th>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
                        <div class="form-group col-md-12">
                                  <textarea id="contents" name="content" cols="40" placeholder="문의 내용을 입력해주세요." rows="20" class="form-control" style="resize: none;" required></textarea>
                        </div>
					</td>
				</tr>
			</table>

			<br><br>

			<div align="center">
				<button type="submit" class="btn btn-warning">등록하기</button>
				<button type="button" onclick="history.back();" class="btn btn-warning">뒤로가기</button>
				<!-- history.back() 이전페이지로 돌아가게 해주는 함수 -->
			</div>


		</form>
	</div>



	<br><br><br><br><br><br><br><br><br>
	
</body>
<!-- footer start -->
<%@ include file="../common/footer.jsp" %>
</html>
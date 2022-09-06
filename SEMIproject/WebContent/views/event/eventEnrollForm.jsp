<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
	.outer{
		background-color : rgb(255, 255, 255);
		color : rgb(0, 0, 0);
		width : 1000px;
		height : 800px;
		margin: auto;
		margin-top: 50px;
	
	}
	#enroll-form>table{ border: 1px solid rgb(0, 0, 0);}
	#enroll-form input, #enroll-form textarea{
	width: 100%;
	box-sizing:border-box;
	
	}
	</style>
</head>
<body>

<%@ include file="../common/header.jsp" %>

<div class="outer">
	<br>
	<h2 align="center">이벤트게시판 작성</h2>
	<br>
	
	<form id="enroll-form" enctype="multipart/form-data" action="<%= contextPath %>/insert.ev" method="post">

	<input type="hidden" name="memberNo" value="<%= loginMember.getMemberNo() %>">
	
	<table align="center" border="1">

	<tr>
		<th width="100", bgcolor="#00FF00";>제목</th>
		<td colspan="3"><input type="text" name="title" required></td>
	</tr>
	
	<tr>
		<th bgcolor="#FFFF00";>내용</th>
		<td colspan="3">
			<textarea name="content" rows="11" required style="resize:none;"></textarea>
		</td>
	</tr>
	<!-- 미리보기 영역 -->
<tr>
	<th bgcolor="#00FF00">썸네일이미지</th>
	<td colspan="3" align="center" >
		<img id="titleImg" width="250" height="170">
	</td>
</tr>
<tr>
	<th bgcolor="#FFFF00">상세이미지</th>
	<td><img width="150" height="120" id="contentImg1"></td>
	<td><img width="150" height="120" id="contentImg2"></td>
	<td><img width="150" height="120" id="contentImg3"></td>
</tr>

	</table>
<br>

<div id="file-area">
	<input type="file" name="file1" id="file1" required onchange="loadImg(this, 1);"> <!-- 대표이미지 -->
	<input type="file" name="file2" id="file2" onchange="loadImg(this, 2);">
	<input type="file" name="file3" id="file3" onchange="loadImg(this, 3);">
	<input type="file" name="file4" id="file4" onchange="loadImg(this, 4);">
</div>
<script>

	$(function(){
		$("#file-area").hide();

		$("#titleImg").click(function(){
			$("#file1").click();
		});

		$("#contentImg1").click(function(){
			$("#file2").click();
		});

		$("#contentImg2").click(function(){
			$("#file3").click();
		});

		$("#contentImg3").click(function(){
			$("#file4").click();
		});

	});


	function loadImg(inputFile, num) {

	//console.log(inputFile.files.length);

		if(inputFile.files.length == 1) {
			var reader = new FileReader();

			reader.readAsDataURL(inputFile.files[0]);


			reader.onload = function(e) {

				switch(num) {
					case 1 : $("#titleImg").attr("src", e.target.result); break;
					case 2 : $("#contentImg1").attr("src", e.target.result); break;
					case 3 : $("#contentImg2").attr("src", e.target.result); break;
					case 4 : $("#contentImg3").attr("src", e.target.result); break;

				};

			};

		}
		else{
			
			switch(num) {
					case 1 : $("#titleImg").attr("src", ""); break;
					case 2 : $("#contentImg1").attr("src", ""); break;
					case 3 : $("#contentImg2").attr("src", ""); break;
					case 4 : $("#contentImg3").attr("src", ""); break;

				};
		}

	}


</script>

	<br>
	<div align="center">
	<button type="submit">작성하기</button>
	<button type="reset">취소하기</button>
	</div>

</form>
	
	
	
	
	

</div>


<%@ include file="../common/footer.jsp" %>

</body>
</html>
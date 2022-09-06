<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.wrapper{
		display: flex;
		justify-content: center;
	}
	.main-content{
		width: 1100px;
		height: 100%;
		display: flex;
		flex-direction: row;
		justify-content: center;
		flex-wrap: wrap;
	}
	.main-content__division {
		width: 400px;
		height: 400px;
		margin: 20px;
	}
	.main-content__division img {
		padding: 20px;
	}
	
</style>
<title>메인 페이지</title>
</head>
<body>
	<!-- header 시작 -->
	<%@ include file="views/common/header.jsp" %>
	<!-- header 끝 -->

	<!-- main content 영역 -->
	<div class="wrapper">
		<div class="main-content">
			<div class="main-content__division">
				<img width="500px" height="500px" src="<%= contextPath %>/resources/img/product/KakaoTalk_20220708_091230921.png">
			</div>
			<div class="main-content__division">
				<img width="500px" height="500px" src="<%= contextPath %>/resources/img/product/KakaoTalk_20220708_091232050.png">
			</div>
			<div class="main-content__division">
				<img width="500px" height="500px" src="<%= contextPath %>/resources/img/product/KakaoTalk_20220708_091233245.png">
			</div>
			<div class="main-content__division">
				<img width="500px" height="500px" src="<%= contextPath %>/resources/img/product/KakaoTalk_20220708_091233245.png">
			</div>
			
		</div>
	</div>
	<!-- main content 끝 -->
	
	<!-- footer 시작 -->
	<%@ include file="views/common/footer.jsp" %>
	<!-- footer 끝 -->
</body>
</html>
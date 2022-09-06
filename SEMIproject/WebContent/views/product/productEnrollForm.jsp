<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.product.model.vo.ProductCategory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<ProductCategory> categories = (ArrayList<ProductCategory>)request.getAttribute("categories");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 화면</title>
<style>
    .outer{

		background-color: #D88F06;
		color: white;
		width: 1000px;
		height: 1000px;
		margin: auto;
		margin-top: 50px;
	}

	#enroll-form> table{ border: 1px solid white;}
	#enroll-form input, #enroll-form textarea{
		width : 100%;
		box-sizing: border-box;
	}
	.chikin{
		-webkit-transform: scale(1);
		transform: scale(1);
		-webkit-transition: .3s ease-in-out;
		transition: .3s ease-in-out;
	}
	
	td .chikin:hover{
		-webkit-transform: scale(1.3);
		transform: scale(1.3);
	}
</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">상품 등록 하기</h2>
		<br>
		
		<form id="enroll-form" enctype="multipart/form-data" action="<%= contextPath %>/insert.pr" method="post">

			<input type="hidden" name="memberNo" value="<%= loginMember.getMemberNo() %>">
	
			<!-- 카테고리의 신상품값 넘기기 -->
			<% if(!categories.isEmpty()) { %>
				<label for="product-category">상품 카테고리</label>
				<select id="product-category" name="categoryNo">
					<% for(ProductCategory pc : categories) { %>
						<option value="<%= pc.getCategoryNo() %>"><%= pc.getCategoryName() %></option>
					<% } %>
				</select>					
			
			<% } %>
			<!-- 상품 제원 등록영역 -->
			<table align="center" border="1">
				<tr>
					<th>상품명</th>
					<td><input type="text" name="productName" required></td>
				</tr>
				<tr>
					<th>상품가격</th>
					<td><input type="text" name="price" required></td>
				</tr>
				<tr>
					<th>상품제고</th>
					<td><input type="text" name="stock" required></td>
				</tr>
				<tr>
					<th>판매량(현재 임의로 등록하기 위해 존재하는 영역)</th>
					<td><input type="text" name="salesQuantity" required></td>
				</tr>
				<tr>
					<th>상품상세내용</th>
					<td colspan="3">
						<textarea name="productDesc" rows="10" required style="resize:none;"></textarea>
					</td>
				</tr>
				<!-- 판매량을 여기서 작성? -->
				<!-- <tr>
					<th>판매량</th>
					<td><input type="text" name="salesQuantity" required></td>
				</tr> -->
				<tr>
					<!-- 상품 이미지 미리보기 영역 -->
					<th>상품대표이미지</th>
					<td colspan="3" align="center">
						<img id="productImg" class="chikin" width="250" height="170" src="<%= contextPath %>/resources/img/box1.png"">
					</td>
				</tr>
				<tr>
					<th>상품상세이미지</th>
					<td><img width="150" height="120" id="contentImg1" class="chikin" src="<%= contextPath %>/resources/img/box1.png"></td>
					<td><img width="150" height="120" id="contentImg2" class="chikin" src="<%= contextPath %>/resources/img/box1.png"></td>
					<td><img width="150" height="120" id="contentImg3" class="chikin" src="<%= contextPath %>/resources/img/box1.png"></td>
				</tr>
			</table>
			
			<!-- 상품 사진 등록영역 -->
			<div id="file-area">
				<input type="file" name="upfile1" id="file1" required onchange="loadImg(this, 1);">
				<input type="file" name="upfile2" id="file2" onchange="loadImg(this, 2);">
				<input type="file" name="upfile3" id="file3" onchange="loadImg(this, 3);">
				<input type="file" name="upfile4" id="file4" onchange="loadImg(this, 4);">
			</div>	
			<div align="center">
				<button type="submit">작성하기</button>
				<button type="reset">취소하기</button>
			</div>
		</form>
	</div>
	

	<script>

		$(function(){
			// 사진을 등록하는 input을 숨기고 해당 인풋의 결과가 들어가는 각각의 자리들(#productImg, #contentImg1, #contentImg2, #contentImg3) 들이
			// 클릭되면 파일을 넣을 수 있도록 바꾸자
			$("#file-area").hide();
			$("#productImg").click(function(){
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

		function loadImg(inputFile, num){
	
			// loadImg(1, 2) :
			// 첫번째 매개변수는 현재 변화가 생긴 type=file 인 input 태그 요소객체
			// 두번쨰 매개변수는 번호를 지정하는 변수
			
			// 파일의 유무 확인 조건문
			// inputFile.files.lengths는 파일의 유무를 확인하는 메소드로 파일이 존재한다면 1, else 0을 리턴한다.
			if(inputFile.files.length == 1){
			
				// 파일을 읽을 객체(FileReader) 생성
				var reader = new FileReader();

				// 객체(FileReader)로부터 파일을 읽어들이는 메소드 호출
				// 인자값으로 전달
				reader.readAsDataURL(inputFile.files[0]);

				// 파일 읽기 완료되면 실행할 함수(e) 정의 
				reader.onload = function(e){
					switch(num){
						case 1 : $("#productImg").attr("src",e.target.result); break;
						case 2 : $("#contentImg1").attr("src",e.target.result); break;
						case 3 : $("#contentImg2").attr("src",e.target.result); break;
						case 4 : $("#contentImg3").attr("src",e.target.result); break;
					}
				}
			}
			else{
				switch(num){
				case 1 : $("#productImg").attr("src","http://www.foodsafetykorea.go.kr/residue/assets/_new/img/noimage.gif"); break;
				case 2 : $("#contentImg1").attr("src","http://www.foodsafetykorea.go.kr/residue/assets/_new/img/noimage.gif"); break;
				case 3 : $("#contentImg2").attr("src","http://www.foodsafetykorea.go.kr/residue/assets/_new/img/noimage.gif"); break;
				case 4 : $("#contentImg3").attr("src","http://www.foodsafetykorea.go.kr/residue/assets/_new/img/noimage.gif"); break;
				}
					}

		}
	</script>
</body>
</html>
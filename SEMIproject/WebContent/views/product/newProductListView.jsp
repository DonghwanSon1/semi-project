<%@page import="com.kh.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/productList.css">
<title>상품 리스트</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
</div>

<!-- 상품 전체 영역 -->
<div class="outer">
	<!-- "상품"타이틀 전체 영역 -->
	<div class="new-prd-bnr">
	<!-- "상품" 타이틀 이미지 영역 -->
		<img src="<%= contextPath %>/resources/img/product/new_product_thumbnailtitle.png">
	</div>

	<div id="wrapper">
	<!-- 상품 등록하기 영역 -->
	<!-- 관리자계정으로만 등록가능하며 표시됨 -->
	<% if(loginMember != null && loginMember.getMemberId().equals("admin")) { %>
		<div align="right" style="width:800">
			<a href="<%= contextPath %>/productEnrollForm.pr" class="btn btn-sm btn-info">상품 등록하기</a>
			<br>
		</div>
	<% } %>

	<!-- "상품" 타이틀 텍스트 영역 -->
		<div class="page-description-area">
			<h2 class="page-title">신상품</h2>
			<span class="page-title-sub">닭치고 이거닭에서만 만날수 있는 이달의 신상품!!</span>
		</div>
		<!-- =================================  상품 리스트 나열  ========================================
			======================================================================================= -->
		<!-- 상품리스트 세부 영역-->
		<div class="list-area-cover">
			<!-- 
				리스트를 보여주는 페이지에서 필요한 값 
				- 상품번호, 상품명, 상품가격, 상품설명, 파일경로, 파일명(바뀐)
			-->	
			<ul class="product-list-area">
				<% if(!list.isEmpty()) { %>
					<% for(Product p : list) { %>
				<li class="product-list">
					<div class="product-area">
						<a href="#">
							<figure class="product-img">
								<img src="<%= p.getFilePathName() %>">
								<input type="hidden" value="<%= p.getProductNo() %>" />
								<div class="overlay-div">
									<div class="img-overlay">
										<div class="content-details fadeIn-bottom">
											<h5 class="content-title"><%= p.getProductDesc() %></h5>
											<!-- <p class="content-text"><%= p.getProductDesc() %></p> -->
										</div>
									</div>
									
								</div>
							</figure>
							<div class="product-info">
								<div id="product-info-name"><%= p.getProductName() %></div>
								<div id="product-info-price">
									<%= p.getPrice() %>원
								</div>
							</div>
						</a>	
					</div>
				</li>		
					<% } %>
				<% } else { %>
						<div>등록된 상품이 존재하지 않습니다</div>
				<% } %>
			</ul>
		</div>
	</div>
</div>

	<!-- footer -->
	<%@ include file="../common/footer.jsp" %>
	<!-- footer -->

	<script>
		$(function(){
			$('figure').click(function(){
				var pno = $(this).children().eq(1).val();

				console.log(pno);

				location.href = "<%= contextPath %>/detail.pr?pno=" + pno;
			})
		})
	</script>

</body>
</html>
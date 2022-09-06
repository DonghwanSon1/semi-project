<%@page import="com.kh.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Product> searchList = (ArrayList<Product>)request.getAttribute("searchList");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/productList.css">
		<title>상품 - 검색</title>
	</head>
	<body>
		<!-- header -->
		<%@ include file="../common/header.jsp" %>
		<!-- header -->
		
		<div class="outer">
			
			<div id="wrapper">
	
				<!-- =================================  상품 리스트 나열  ========================================
					======================================================================================= -->
				<!-- 상품리스트 세부 영역-->
				<div class="list-area-cover">
					<ul class="product-list-area">
						<% if(!searchList.isEmpty()) { %>
							<% for(Product p : searchList) { %>
								<li class="product-list">
									<div class="product-area">
										<a href="#">
											<figure class="product-img">
												<img src="<%= p.getFilePathName() %>">
												<div class="overlay-div">
													<div class="img-overlay">
														<div class="content-details fadeIn-bottom">
															<h5 class="content-title"><%= p.getProductDesc() %></h5>
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
						<% } %>
					</ul>
				</div>
			</div>
		</div>
		
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<!-- footer -->
		<%@ include file="../common/footer.jsp" %>
		<!-- footer -->
	</body>
</html>
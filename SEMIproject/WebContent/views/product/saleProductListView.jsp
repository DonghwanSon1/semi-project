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
<title>상품 리스트</title>
	<style>
		@charset "UTF-8";
.outer{
    display: flex;
    flex-direction: column;
    width: 1000px;
    justify-content: center;
    margin: auto;
}
.new-prd-bnr{
    display: flex;
    justify-content: center;
    margin-bottom: 50px;
}
/* 타이틀 css */
.page-description-area{
    border-bottom: 1px solid #ccc;
    display: flex;
    flex-direction: row;
    align-items: baseline;
}
.page-title{
    color: #E46C0B;
    margin-right: 10px;
}
.page-title-sub{
    font-size: 20px;
    line-height: 0px;
}
/* 상품리스트 css */
.list-area-cover{
    width: 1000px;
}
.product-list-area{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
}
.product-list{
    width: 220px;
    margin: 15px;
}
.product-area{
    position: relative;
    width: 90%;
    max-width: 400px;
    margin: auto;
    overflow: hidden;
}
.product-img{
    width: 100%;
    height: 220px;
}
.product-img img{
    width: 100%;
    height: 100%;
}
.product-info{
    color: black;
    font-size: 15px;
    margin: 5px 0;
}
#product-info-name{
    height: 50px;
}
#product-info-price{
    color: black;
    font-size: 15px;
}
.product-area .img-overlay {
    background: rgba(0,0,0,0.7);
    position: absolute;
    height: 220px;
    width: 100%;
    left: 0;
    top: 0;
    bottom: 0;
    right: 0;
    opacity: 0;
    -webkit-transition: all 0.4s ease-in-out 0s;
    -moz-transition: all 0.4s ease-in-out 0s;
    transition: all 0.4s ease-in-out 0s;
}
.product-area:hover .img-overlay{
    opacity: 1;
}
.content-details {
    position: absolute;
    text-align: center;
    padding-left: 1em;
    padding-right: 1em;
    width: 220px;
    top: 50%;
    left: 50%;
    opacity: 0;
    -webkit-transform: translate(-50%, -50%);
    -moz-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    -webkit-transition: all 0.3s ease-in-out 0s;
    -moz-transition: all 0.3s ease-in-out 0s;
    transition: all 0.3s ease-in-out 0s;
}
.product-area:hover .content-details{
    top: 50%;
    left: 50%;
    opacity: 1;
}
.product-area:hover a{
    text-decoration: none;
}
.content-details h5{
    color: #fff;
    font-weight: 500;
    letter-spacing: 0.15em;
    margin-bottom: 0.5em;
    text-transform: uppercase;
}
.content-details p{
    color: #fff;
    font-size: 0.8em;
}
.fadeIn-bottom{
      top: 80%;
}
	</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>


<!-- 상품 전체 영역 -->
<div class="outer">
	<!-- "상품"타이틀 전체 영역 -->
	<div class="new-prd-bnr">
	<!-- "상품" 타이틀 이미지 영역 -->
		<img src="<%= contextPath %>/resources/img/product/sale_product_thumbnailtitle.png">
	</div>


	<!-- "상품" 타이틀 텍스트 영역 -->
		<div class="page-description-area">
			<h2 class="page-title">할인상품</h2>
			<span class="page-title-sub">닭치고 이거닭에서만 만날수 있는 최저가 할인 상품들!!</span>
		</div>
		<!-- =================================  상품 리스트 나열  ========================================
			======================================================================================= -->
		<!-- 상품리스트 세부 영역-->
		<div class="list-area-cover">
			<ul class="product-list-area">
				<% if(!list.isEmpty()) { %>
					<% for(Product p : list) { %>
				<li class="product-list">
					<div class="product-area">
						<!--<a href="#">-->
							<figure class="product-img thumbnail">
								<img src="<%= p.getFilePathName() %>">
								<input type="hidden" value="<%= p.getProductNo()%>">
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
						<!--</a>-->	
					</div>
				</li>		
					<% } %>
				<% } else { %>
						<div>등록된 상품이 존재하지 않습니다</div>
				<% } %>
			<!--=======================================================================================  -->	
			</ul>
		</div>

		<script>
			$(function(){
				$(".thumbnail").click(function(){
					
					var pno = $(this).children().eq(1).val();
					
					location.href = "<%= contextPath %>/detail.pr?pno=" + pno;
				});
			});
		</script>

	</div>
</div>
	<br><br><br><br><br><br><br><br><br><br>
	<%@ include file="../common/footer.jsp" %>

</body>
</html>

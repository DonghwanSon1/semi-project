<%@page import="com.kh.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<Product> pList = (ArrayList<Product>)request.getAttribute("pList"); 
	int totalPrice = 0;
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장바구니</title>
	<style>
	        .outer{
	            background-color: white;
	            color: black;
	            width: 1000px;
	            height: 800px;
	            margin: auto;
	            margin-top: 50px;
	        }
	        #detail-area{
	        	border : 1px solid black;
	        }
			
    </style>
</head>
<body>


	<!-- header 시작 -->
	<%@ include file="../common/header.jsp" %>
	<!-- header 끝 -->

	
	
	<div class="outer">

        <br>
        <h2 align="center">장바구니</h2>
        <br>

		<hr>
       
		<table border="1" class="list-area" align="center">
			<thead>
				<tr>
					<th><input type="checkbox" checked="checked" id="chkBoxAll">전체선택</th>
					<th colspan="2">상품정보</th>
					<th>판매가</th>
					<th style="text-align: center;">수량</th>
					<th style="text-align: center;">합계</th>
				</tr>
			</thead>
			<tbody>
				
				<% for(Product p : pList) { %>
					<% int price = p.getPrice() * p.getStock(); 
						totalPrice += price;
					%>
					<tr>
						<td class="cartList"><input type="checkbox" checked="checked" class="chkBox">선택</td>
						<td><img src="<%= p.getFilePathName()%>" width="100" height="100"></td>
						<td><%= p.getProductName() %></td>
						<td><%= p.getPrice() %></td>
						<td>
							<span>
								<button type="button" class="minusBtn">-</button>
								<input type="text" style="width:20px; text-align: center;"  value="<%= p.getStock()%>">
								<button type="button" class="plusBtn">+</button>
							</span>
						</td>
						<td align="center" class="price"><%= price %></td>
					</tr>
				<% } %>
				
				
			</tbody>
		
		</table>

		<table border="1" class="list-area-foot" align="center">
			<thead>
				<tr>
					<th>총 상품금액</th>
					<th class="totalPrice1"><%= totalPrice %></th>
					<th>총 배송비</th>
					<th>3000</th>
					<th>결제예정금액</th>
					<th class="totalPrice2"><%= totalPrice+=3000 %></th>
				</tr>
			</thead>
		</table>
		<div align="center">
			<button type="button" id="submit">주문하기</button>	
			<button type="button" onclick="window.location.href='<%= contextPath %>'">쇼핑 계속하기</button>
		</div>
	
		<script>
			$(".plusBtn").click(function(){
				$.ajax({
					url : "cartQuanPlusMinus.my",
					data : {
						productName : $(this).parent().parent().prev().prev().text(),
						plusMinus : "+",
						quantity : $(this).prev('input').val()
					},
					context : this,
					type : "post",
					success : function(result){
						$(this).prev('input').val(result);
						var pPrice = Number($(this).parent().parent().prev().text());
						$(this).parent().parent().next().text(pPrice * Number(result));
						$('.totalPrice1').text(Number($('.totalPrice1').text())+pPrice);
						$('.totalPrice2').text(Number($('.totalPrice2').text())+pPrice);
					},
					error : function(){
						alert("수량조절실패");
					}
				});
			})
			
			$(".minusBtn").click(function(){
				if($(this).next('input').val() == 0){
					alert("0개 이하로는 설정 불가합니다.");
				} else {
					$.ajax({
						url : "cartQuanPlusMinus.my",
						data : {
							productName : $(this).parent().parent().prev().prev().text(),
							plusMinus : "-",
							quantity : $(this).next('input').val()
						},
						context : this,
						type : "post",
						success : function(result){
							$(this).next('input').val(result);
							var pPrice = Number($(this).parent().parent().prev().text());
							$(this).parent().parent().next().text(pPrice * Number(result));
							$('.totalPrice1').text(Number($('.totalPrice1').text())-pPrice);
							$('.totalPrice2').text(Number($('.totalPrice2').text())-pPrice);
						},
						error : function(){
							alert("수량조절실패");
						}
					});
				}
			})
			
			$(".chkBox").change(function(){
				if(this.checked) {
					var totalPrice1 = Number($('.totalPrice1').text());
					var totalPrice2 = Number($('.totalPrice2').text());
					var price = Number($(this).parent().next().next().next().text());
					var quan = Number($(this).parent().next().next().next().next().children().children().next().val());

					$('.totalPrice1').text(totalPrice1 + price*quan);
					$('.totalPrice2').text(totalPrice2 + price*quan);
					
				} else {
					var totalPrice1 = Number($('.totalPrice1').text());
					var totalPrice2 = Number($('.totalPrice2').text());
					var price = Number($(this).parent().next().next().next().text());
					var quan = Number($(this).parent().next().next().next().next().children().children().next().val());

					$('.totalPrice1').text(totalPrice1 - price*quan);
					$('.totalPrice2').text(totalPrice2 - price*quan);
				}
				
				
			})
			
			$('#chkBoxAll').change(function(){
				if(this.checked) {
					$('.chkBox').each(function(index, value) {
						value.checked = true;
						var totalPrice = 0;
					$('.price').each(function(index, value){
						totalPrice += Number(value.innerHTML);
					})

					$('.totalPrice1').text(totalPrice);
					$('.totalPrice2').text(totalPrice + 3000);
				})
				} else {
					$('.chkBox').each(function(index, value) {
						value.checked = false;
						$('.totalPrice1').text(0);
						$('.totalPrice2').text(3000);
						return;
					})
				}
			})
			
			$('#submit').click(function(){
				var pNames = "";

				$('.chkBox').each(function() {
					if(this.checked) {
						pNames += ($(this).parent().next().next().text()) + ",";
					}
				})
				
				location.href = "<%= contextPath %>" + "/cartOrder.my?pNames=" + pNames;
			})
		</script>
	</div>
	<!-- footer 시작 -->
	<%@ include file="../common/footer.jsp" %>
	<!-- footer 끝 -->
</body>
</html>
<%@page import="com.kh.member.model.vo.Address"%>
<%@page import="com.kh.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ArrayList<Product> pList = (ArrayList<Product>)request.getAttribute("pList"); 
	ArrayList<Address> aList = (ArrayList<Address>)request.getAttribute("aList");
	int totalPrice = 0;
	String productNames = "";
	String productTotalQuantity = "";
	String points = "";
%>	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주문/결제</title>
	
	<style>
		.outer{
	            background-color: white;
	            color: black;
	            width: 1000px;
	            margin: auto;
	            margin-top: 50px;
				margin-bottom: 200px;
		}
		/* 회원정보 영역 */
		.member-area{
			border: 1px solid red;
		}
		.member-info p {
			display: inline;
		}
		/* 배송지 영역 */
		.address-area{
			border: 1px solid slateblue;
		}

		/* 상품 정보 영역 */
		.product-area{
			border: 1px solid aqua;
		}

		/* 쿠폰 정보 영역 */
		.coupon-area{
			border: 1px solid blueviolet;
		}
		.adsModalTbody {
			border : 1px solid black;
		}

		/* 결제 방법 */
		

		#navi{
			list-style-type: none;
        }
        
        #navi>li{
            float:left;
            text-align: center;
            height: 100%;
			
        }

		#navi>li>ul{
            list-style-type: none;
            padding: 0%;
            display: none;
			
        }
    </style>


</head>
<body>
	<!-- header 시작 -->
	<%@ include file="../common/header.jsp" %>
	<!-- header 끝 -->
	
	<div class="outer">

        <br>
        <h2 align="center">주문 / 결제 페이지</h2>

		<!-- 주문자 정보 -->
		<div class="member-area">
			<h4>주문자 정보</h4>
			<div class="member-info">
				<p><%= loginMember.getMemberName() %></p>/
				<p><%= loginMember.getEmail() %></p>/
				<p><%= loginMember.getPhone() %></p>
			</div>	
		</div>
		
		<!-- 배송지 정보 -->
		<div class="address-area">
			<h4>배송지 정보</h4>
			<% if(!aList.isEmpty()) { %>
				<button id="adsBtn">배송지 변경</button>	
	
				<table>
					<!-- 처음 페이지를 로드했을때는 기본배송지의 값을 가진 주소지를 설정해줌 -->
					<tbody>
						<input id="adsNo" type="hidden" value="<%= aList.get(0).getAddressNo() %>">						
						<tr>
							<th scope="row" style="width: 120px;">수취인</th>
							<td id="adsName"><%= aList.get(0).getReceiver() %></td>
						</tr>
						<tr>
							<th scope="row">주소</th>
							<td id="adsads"><%= aList.get(0).getLocation() %></td>
						</tr>
						<tr>
							<th scope="row">연락처</th>
							<td id="adsPhone"><%= aList.get(0).getPhone() %></td>
						</tr>
					</tbody>
				</table>			
			<% } else { %>
				<div>배송지 등록을 해주세요!!</div>
				<!-- 기본 배송지 등록을 안했을때 페이지로 넘어오면 nullpointer 익셉션 발생함 -->
			<% } %>

			<!-- 배송지 Modal-->
			<div class="modal fade" id="addressModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">배송지 선택</h5>
							<button class="close" type="button" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">X</span>
							</button>
						</div>
						<div class="modal-body">
							<table id="adsBody">
								<tr>
									<th></th>
									<th>수취인</th>
									<th>주소</th>
									<th>연락처</th>
								</tr>
								<% for(Address a : aList) { %>
									<tr>
										<td>
											<button class="confirm-btn">선택</button>
											<input class="add-list-no" type="hidden" value="<%= a.getAddressNo() %>">
										</td>
										<td class="add-list-name"><%= a.getReceiver() %></td>
										<td class="add-list-location"><%= a.getLocation() %></td>
										<td class="add-list-phone"><%= a.getPhone() %></td>
									</tr>
								<% } %>
							</table>
						</div>
					</div>
				</div>
			</div>

			<script>
				$("#adsBtn").click(function(){
					$("#addressModal").modal("show");

					// 기본배송지는 선택이 되어있어야함
					// $(".main").each(function(index, item){
					// 	if(this.value == "Y"){
					// 		$(this).attr("checked", true);
					// 	}
					// })

					// 현재 선택되어 있는 배송지는 보여주지 않는다.
				})
				// 현재 모달창의 경우 이미 주문 페이지에서 선택된 주소지의 경우 안나오게 하거나 선택 불가로 만들고 싶은데 구현 안했습니다.
				const confirmBtn = document.getElementsByClassName("confirm-btn");
				
				$(confirmBtn).on("click", function(){
					const chosenNo = $(this).siblings(".add-list-no").val();
					const chosenReceiver = $(this).parent().siblings(".add-list-name").text();
					const chosenLocation = $(this).parent().siblings(".add-list-location").text();
					const chosenPhone = $(this).parent().siblings(".add-list-phone").text();

					$("#adsNo").val(chosenNo);
					$("#adsName").text(chosenReceiver);
					$("#adsads").text(chosenLocation);
					$("#adsPhone").text(chosenPhone);
					$("#addressModal").modal("hide");
				})

				
			</script>

			<!-- 배송지 리스트 스크립트 -->
			<script>
				// $('#adsBtn').click(function(e){
				// 	e.preventDefault();
				// 	$.ajax({
				// 		url : "getAddressInfo.my",
				// 		data : {},
				// 		//context : this,
				// 		type : "post",
				// 		success : function(list){
				// 			var result = '<tbody class="adsModalTbody"><tr> <th scope="row" style="width: 120px;">받는분</th><td id="adsName">받는사람</td></tr><tr><th scope="row">주소</th><td id="adsads">주소</td></tr><tr><th scope="row">휴대폰 번호</th><td id="adsPhone">폰</td></tr></tbody><tr><td>&nbsp;</td></tr>';

				// 			for(var i in list) {
				// 				result += "<tbody class='adsModalTbody'>"
				// 						+ "<tr>"
				// 						+ '<th scope="row" style="width: 120px;">받는분</th>'
				// 						+ '<td class="receiveData">' + list[i].receiver + '</td>'
				// 						+ '</tr>'
				// 						+ "<tr>"
				// 						+ '<th scope="row">주소</th>'
				// 						+ '<td>' + list[i].location + '</td>'
				// 						+ '</tr>'+ "<tr>"
				// 						+ '<th scope="row">휴대폰 번호</th>'
				// 						+ '<td>' + list[i].phone + '</td>'
				// 						+ '</tr>'
				// 						+ '</tbody>'
				// 						+ '<tr><td>&nbsp;</td></tr>';
				// 			}
							
							
				// 			$("#adsBody").html(result);
				// 			$('#addressModal').modal("show");
				// 		},
				// 		error : function(){
				// 			alert("쿠폰 불러오기 실패");
				// 		}
				// 	});
				// })

				// $('#adsBody'). on("click", ".adsModalTbody", function() {
				// 	var name = $(this).children(":eq(" + 0 + ")").children(":eq(" + 1 + ")").text();
				// 	var ads = $(this).children(":eq(" + 1 + ")").children(":eq(" + 1 + ")").text();
				// 	var phone = $(this).children(":eq(" + 2 + ")").children(":eq(" + 1 + ")").text();
					
				// 	$('#adsName').text(name);
				// 	$('#adsads').text(ads);
				// 	$('#adsPhone').text(phone);
				// 	$('#addressModal').modal('hide');

				// })
				
			</script>
		</div>

		<!-- 주문상품 정보 -->
		<div class="product-area">
			<h4>주문 상품 정보</h4>
			<br>

			<table border="1" class="list-area" align="center" >
				<thead>
					<tr>
						<!-- <th width="110" style="text-align: center;">주문일자</th> -->
						<th width="120"></th>
						<th width="300" >상품정보</th>
						<th width="100" style="text-align: center;">수량</th>
						<th width="100" style="text-align: center;">가격</th>
					</tr>
				</thead>
				
				<tbody id="body">
					<% for(Product p : pList) { %>
						<% productNames += p.getProductName() + ","; %>
						<% productTotalQuantity += p.getStock() + ","; %>
						<% points += (p.getPrice()*p.getStock()) + ","; %>
						
						<tr>
							<% totalPrice += p.getPrice()*p.getStock(); %>
							<td><img src="<%= p.getFilePathName()%>" width="100" height="100"></td>
							<td><%= p.getProductName() %></td>
							<td align="center"><%= p.getStock() %></td>
							<td align="center"><%= p.getPrice()*p.getStock() %></td>
						</tr>
					<% } %>
				</tbody>
				
				<tfoot>
					<tr>
						<th colspan="2" ><font size="5">총 금 액 : </font></th>
						<th colspan="2"><font size="5" id="totalPrice"><%= totalPrice %></font></th>
					</tr>
				</tfoot>
			</table>
		</div>

		<!-- 포인트 쿠폰 -->
		<div class="coupon-area">
			<h4>포인트/쿠폰 사용</h4>
			<table>
				<tbody>
					<tr>
						<th scope="row" style="width: 120px;">포인트 사용</th>
						<td>
							<div>
								<span><input type="text" id="usingPoint" value="0"></span>
								<span>
									<button id="removePoint">X</button>
									<button id="useAllPoint">전액사용</button>
								</span>
								<span style="color: gray;">잔여 포인트 : </span>
								<span style="color: gray;"><%= loginMember.getPoint() %></span>
							</div>
						</td>
					</tr>

					<!-- point관련 스크립트 -->
					<script>
						$('#useAllPoint').click(function(){
							var point = <%= loginMember.getPoint() %>;
							var totalPrice = <%= totalPrice%>;
		
							if(totalPrice >= point) {
								<% totalPrice -= loginMember.getPoint(); %>
								$('#usingPoint').val(point);
								$('#totalPrice').text(<%= totalPrice %>);
								
							} else {
								$('#usingPoint').val(totalPrice);
								$('#totalPrice').text(0);
							}
						})
		
						$('#removePoint').click(function(){
							var point = <%= loginMember.getPoint() %>;
							var totalPrice = <%= totalPrice%>;
		
							<% totalPrice += loginMember.getPoint(); %>
							$('#usingPoint').val(0);
							$('#totalPrice').text(<%= totalPrice%>);
						})
					</script>
					<!-- point관련 스크립트 -->

					<tr>
						<th scope="row" style="width: 120px;">쿠폰 사용</th>
						<td>
							<div>
								<span><input type="text" id="couponText"></span>
								<span>
									<span><button id="couponSelect" >쿠폰선택</button></span>
									
									<span style="color: gray; display: none;" class="hideCouponPoint">쿠폰 포인트 : </span>
									<span style="color: gray; display: none;" class="hideCouponPoint" id="showCouponPoint">0</span>
									<!-- 회원가입 확인 Modal-->
									<div class="modal fade" id="testModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">쿠폰선택</h5>
													<button class="close" type="button" data-dismiss="modal" aria-label="Close">
														<span aria-hidden="true">X</span>
													</button>
												</div>
												<div class="modal-body">
													<table class="list-area" align="center" >
														<thead>
															<tr>
																<th width="50" align="center"></th>
																<th width="300" style="text-align: center;">쿠폰 이름</th>
																<th width="100" style="text-align: center;">할인 금액</th>
															</tr>
														</thead>
												
														<tbody id="mBody">
															
														
															
														</tbody>
													</table>
												</div>
												<div class="modal-footer">
													<!-- <a class="btn" id="modalY" href="#as">예</a> -->
													<button class="btn" type="button" data-dismiss="modal" id="modalYesButton">예</button>
													<button class="btn" type="button" data-dismiss="modal">아니요</button>
												</div>
											</div>
										</div>
										<!-- 쿠폰 관련 스크립트 -->
										<script>
											$('#couponSelect').click(function(e){
												e.preventDefault();
												$.ajax({
													url : "getCouponsInfo.my",
													data : {},
													//context : this,
													type : "post",
													success : function(list){
														var result = "";
        
														for(var i in list) {
															result += "<tr>"
																	+ "<td><input type='checkbox' class='chkBox'></td>"
																	+ "<td align='center'>" + list[i].couponName + "</td>"
																	+ "<td align='center'>" + list[i].discount + "</td>"
																	+ "</tr>";
														}
														
														$("#mBody").html(result);
														$('#testModal').modal("show");
													},
													error : function(){
														alert("쿠폰 불러오기 실패");
													}
												});
											})

											$("#mBody").on("change", '.chkBox', function(){
												if(this.checked) {
													$('.chkBox').each(function(index, value) {
														value.checked = false;
													})
													this.checked = true;
												} 
											})

											$('#modalYesButton').click(function() {
												var cName = "";
												var cPrice = 0;
												$('.hideCouponPoint').hide();
												$('.chkBox').each(function(index, value) {
													if(value.checked) {
														cName = $(this).parent().next().text();
														cPrice = $(this).parent().next().next().text();
														$('.hideCouponPoint').show();
													}
												})
												$('#showCouponPoint').text(cPrice);
												$('#couponText').val(cName);
												$('#totalPrice').text(<%= totalPrice%> - cPrice - Number($('#usingPoint').val()));
											})
										</script>
										<!-- 쿠폰 관련 스크립트 -->
									</div>
								</span>
							</div>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>

		<!-- 결제 방법 선택 -->
		<div>
			<span style="display: flex;">
				카드 선택
				<ul id="navi" style="width: 500px;">
					<li>
						<div>카드사를 선택하세요</div>
						
						<ul>
							<li>신한</li>
							<li>국민</li>
							<li>우리</li>
						</ul>
					</li>
				</ul>
			</span>
		</div>

		<script>
			$("#navi>li").mouseover(function() {
				$("#navi>li>ul").css('display', 'block');
			})
			
			$('#navi>li>ul>li').click(function(){
				$('#navi>li>div').text($(this).text());
				$("#navi>li>ul").css('display', 'none');
			})
		</script>
		<!-- 주문하기 -->
		<div>
			<button id="order">주문하기</button>
		</div>

		<script>
			$("#order").click(function(){
				if($('#navi>li>div').text() == '카드사를 선택하세요'){
					alert('카드를 선택해 주세요');
				} else {
					var products = "<%= productNames%>";
					var point = Number($('#usingPoint').val());
					var couponName = $('#couponText').val();
					var discountRate = point + Number($('#showCouponPoint').text());
					var totalQuantity = "<%= productTotalQuantity%>";
					var points = "<%= points%>";
					var ano = $("#adsNo").val();
					location.href = "<%= contextPath %>" + "/orderProducts.my?products=" + products 
														 + "&discountRate=" + discountRate 
														 + "&totalQuantity=" + totalQuantity
														 + "&points=" + points
														 + "&point=" + point
														 + "&couponName=" + couponName
														 + "&ano=" + ano;
				}
			})
		</script>

	</div>
	<!-- footer 시작 -->
	<%@ include file="../common/footer.jsp" %>
	<!-- footer 끝 -->
</body>
</html>
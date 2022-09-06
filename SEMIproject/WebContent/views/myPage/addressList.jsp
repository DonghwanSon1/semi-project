<%@page import="com.kh.member.model.vo.Address"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Address> list = (ArrayList<Address>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/addressList.css">
	<title>마이페이지 - 배송지 등록/수정</title>
</head>
<body>
	<!-- header 시작 -->
	<%@ include file="../common/header.jsp" %>
	<% int memberNo = loginMember.getMemberNo(); %>
	<!-- header 끝 -->

	<!-- content-영역 -->
	<div id="wrapper">

		<div class="content">

			<div class="content__header">
				<div>
					<h2>배송지 관리</h2>
					<span style="color: rgba(0,0,0,0.5);">* 배송지는 최대 5개까지 등록 가능합니다.</span>
				</div>
				
				<!-- 배송지리스트가 5개 이상이면 추가 버튼 비활설화 -->
				<% if(list.size() < 5) { %>
					<div>
						<button id="add-newAddress-btn" type="button" class="btn btn-primary" data-toggle="modal" data-target="#insertAddressForm" data-backdrop="static" data-keyboard="false">+ 새로운 배송지 추가</button>
					</div>
				<% } %>
			</div>

			<table class="list-area table table-striped">
				
				<thead>
					<tr>
						<th>선택</th>
						<th>받으실 분</th>
						<th>배송 주소</th>
						<th>연락처</th>
						<th>관리</th>
					</tr>
				</thead>

				<tbody>
					<!-- 배송지 등록을 안했으면 -->
					<% if(list.isEmpty()) { %>
						<tr>
							<td align="center" colspan="6">배송지를 등록해주세요</td>
						</tr>						
					<% } else { %>
						<% for(Address a : list) { %>
							<tr class="address-info">
								<!-- 
									addressNo = Address테이블의 PK
									curMain = 현재 행의 main 값(Y/N)
									receiver = 수취인
									location = 배송지명
									phone = 연락처
								-->
								<td class="hidden"><input class="addressNo" type="hidden" name="addressNo" value="<%= a.getAddressNo() %>"></td>
								<td><input type="radio" name="curMain" class="main" value="<%= a.getMain() %>"></td>
								<td class="receiver"><%= a.getReceiver() %></td>
								<td class="location"><%= a.getLocation() %></td>
								<td class="phone"><%= a.getPhone() %></td>
								<td>
									<div class="list-area__modify-btn">
										<a class="btn-upd-add" data-toggle="modal" data-target="#modifyAddressForm" data-backdrop="static" data-keyboard="false">수정</a>|
										<a class="btn-dlt-add">삭제</a>
									</div>
								</td>
							</tr>
						<% } %>		
					<% } %> 
				</tbody>
			</table>

			<!-- 신규 배송지 등록 모달 -->
			<div class="modal fade" id="insertAddressForm">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content">
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">신규 등록</h4>
							<button type="button" class="close" data-dismiss="modal">×</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form id="new-address-form" method="post" action="insertAddress.my">
								<!-- input hidden으로 현재 로그인된 사용자의 PK인 memberNo를 가져옴 -->
								<!-- 식별용으로 넘겨준다. -->
								<input type="hidden" name="memberNo" value="<%= memberNo %>">
								<table>
									<tr>
										<th>수취인 *</th>
										<td><input class="new-address-values" type="text" name="receiver" required placeholder="받으시는 분 이름을 입력해 주세요"></td>
									</tr>
									<tr>
										<th>주소 *</th>
										<td><input class="new-address-values" type="text" name="location" required placeholder="주소를 입력해 주세요"></td>
									</tr>
									<tr>
										<th>연락처 *</th>
										<td><input class="new-address-values" type="text" name="phone" required placeholder="000-0000-0000 형식으로 입력해 주세요"></td>
									</tr>
									<tr>
										<td colspan="2">
											<!-- 첫 배송지 등록이면 무조건 기본배송지로 등록이 되어야함-->
											<% if(list.isEmpty()) { %>
												<div id="form-btn">
													<!-- 여기에 input 히든을 넣은 이유는 disabled 가 설정되어있으면 value가 안넘어가짐 -->
													<!-- 컨트롤러에서 키값으로 setMain을 받아준다 -->
													<input type="hidden" name="setMain" value="Y">
													<input id="setMainforNew" type="checkbox" disabled checked>
													<label for="setMainforNew">처음 등록하시는 배송지는 자동으로 기본 배송지로 설정 됩니다.</label>
												</div>						
											<% } else { %>
												<div id="form-btn">
													<input id="setMainforNew" type="checkbox" name="setMain" value="Y">
													<label for="setMainforNew">기본 배송지로 설정</label>
												</div>
											<% } %>
										</td>
									</tr>
								</table>
								<!-- Modal footer -->
								<div class="modal-footer">
									<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
									<button type="submit" class="btn btn-default" >등록</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<% if(!list.isEmpty()) { %>
				<button id="set-address-main" type="button" class="btn btn-default btn-lg">기본 배송지로 설정</button>			
			<% } %>

		</div>
	</div>

	<!-- 배송지 수정 모달 -->
	<div class="modal fade" id="modifyAddressForm">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">배송지 수정</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<!-- Modal body -->
				<form id="modify-form" action="<%= contextPath %>/modifyAddress.my" method="post">
					
					<div class="modal-body">
						<!-- hidden inputs -->
						<input class="addressNo-upd" type="hidden" name="addressNo">
						<input class="memberNo-upd" type="hidden" name="memberNo" value="<%= memberNo %>">
						<input class="curMain-upd" type="hidden" name="curMain">

						<table>
							<tr>
								<th>수취인 *</th>
								<td><input class="receiver-upd" type="text" name="receiver" required></td>
							</tr>
							<tr>
								<th>주소 *</th>
								<td><input class="location-upd" type="text" name="location" required></td>
							</tr>
							<tr>
								<th>연락처 *</th>
								<td><input class="phone-upd" type="text" name="phone" required></td>
							</tr>
							
							<tr>
								<td colspan="2">
									<div class="form-btn">
										<input id="newMain" class="newMain" type="checkbox" value="Y" name="newMain" >
										<label for="newMain">기본 배송지로 설정</label>
									</div>
								</td>
							</tr>
						</table>
					</div>

				<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary" >수정완료</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- content-영역 --> 
		
	<!-- footer 시작 -->
	<%@ include file="../common/footer.jsp" %>
	<!-- footer 끝 -->

	<script>
		$(function(){

			// 새로운 배송지 추가 버튼 닫았다가 다시 실행했을때 text영역에 남아있던 값 초기화(공백)
			$("#add-newAddress-btn").click(function(){
				$('.new-address-values').val("");
			})
			
			// 화면이 로드될때 기본 배송지로 선택한 radio input의 checked "true";
			$(".main").each(function(index, item){
				if(this.value == "Y"){
					$(this).attr("checked", true);
				}
			})
			
			// 배송지의 첫번째 행인 기본 배송지의 수정/삭제 버튼 선택하여 변수에 담아뒀음 
			const mainAddressDeletBtn = document.getElementsByClassName("btn-dlt-add")[0];

			// 삭제 버튼 => 기본 배송지의 삭제버튼은 비활성화
			$('.btn-dlt-add').click(function(){
				const ano = $(this).parents("tr").children("td").children(".addressNo").val();

				if(this == mainAddressDeletBtn){ // 현재 클릭한 삭제버튼이 기본배송지의 삭제 버튼일 경우
					alert("기본 배송지는 삭제가 불가능허요~~");
				} else{
					const answer = confirm("선택하신 배송지를 삭제하시겠습니까?");
					if(answer){ // 컨펌창에서 확인을 누르면 삭제
						location.href = "<%= contextPath %>/deleteAddress.my?ano="+ano
					}
				}
			})

			// 수정하기 버튼 클릭시 해당 행의 Address정보가 폼에 기본값으로 입력됨
			// 제이쿼리 선택자를 통해 수정 버튼을 선택한후 this를 통해 해당 행의 정보(수취인, 배송지, 연락처)들의 값(text())을 변수에 담아둠
			// 각각의 값이 저장된 변수들을 btn 에 지정
			$('.btn-upd-add').click(function(){
				const curMain = $(this).parents(".address-info").children("td").children(".main").val();
				const addressNo = $(this).parents(".address-info").children("td").children(".addressNo").val();
				const receiver = $(this).parents(".address-info").children(".receiver").text();
				const location = $(this).parents(".address-info").children(".location").text();
				const phone = $(this).parents(".address-info").children(".phone").text();

				switch(curMain){
					case "Y" : 
								$(".newMain").attr("checked", true).attr("disabled", true);
								$(".newMain").val("Y");
								break;
					case "N" : 
								$(".newMain").attr("checked", false).attr("disabled", false);
								break;
				}

				// 현재 설정된 값들을 각각의 인풋에 담아준다.
				// newMain의 input값은 
				$(".curMain-upd").val(curMain);
				$(".addressNo-upd").val(addressNo);
				$(".receiver-upd").val(receiver);
				$(".location-upd").val(location);
				$(".phone-upd").val(phone);
			})
			
			$('#set-address-main').click(function(){

				// 현재 화면에서 체크된 배송지 가져오기
				// console.log($("input[type=radio]:checked"));
				const beMain = $("input[type=radio]:checked");

				const ano = $(beMain).parent("td").siblings(".hidden").children(".addressNo").val();
				const mno = "<%= loginMember.getMemberNo() %>";

				if(beMain.val() == "Y"){
					alert("이미 기본 배송지로 설정된 배송지입니다.");
				} else{
					confirm("선택한 배송지를 기본배송지로 설정하시겠습니까?");
					
					if(confirm) location.href = "<%= contextPath %>/setMainAddress.my?ano=" + ano +"&mno=" + mno;
				}
			})

		})
	</script>
</body>
</html>

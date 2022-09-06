<%@page import="com.kh.myPage.model.vo.Coupon"%>
<%@page import="com.kh.common.model.vo.PageInfo"%>
<%@page import='java.text.SimpleDateFormat'%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage(); 
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>주문 내역</title>
	<style>
		.outer{
			background-color: white;
			color: black;
			width: 1000px;
			
			margin: auto;
			margin-top: 50px;
		}
		#list-area{
			border : 1px solid black;
		}
		.datePicker{
			width: 100px; 
			text-align: center;
		}
		
		tr {
			border-bottom: 20px solid #fff;
		}
	</style>

	
	
</head>
<body>
	<!-- header 시작 -->
	<%@ include file="../common/header.jsp" %>
	<!-- header 끝 -->
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

	<div class="outer">

        <br>
        <h2 align="center">주문 내역</h2>
        <br>

		<hr>
       	
       	<div align="center">
			<button class="ebtn">오늘</button>
			<button class="ebtn">1주일</button>
			<button class="ebtn">1개월</button>
			<button class="ebtn">3개월</button>
		</div>
		<br>
		<div align="center">
			<input type="text" class="datePicker" id="dateSearch1" readonly value="<%= new SimpleDateFormat("yyyy/MM/dd").format(new Date()) %>">
			~
			<input type="text" class="datePicker" id="dateSearch2" readonly value="<%= new SimpleDateFormat("yyyy/MM/dd").format(new Date()) %>">
			<button id="dateSearch">조회</button>
		</div>

		<script>
			$(function() {
				$('.datePicker').datepicker({
					changeMonth: true,
					changeYear: true,
					dateFormat: "yy/mm/dd"
					
				});
			});
		</script>

		<br><br><br><hr>
		<table class="list-area" align="center">
			<thead>
				<tr>
					<th width="110" style="text-align: center;">주문일자</th>
					<th width="120"></th>
					<th width="300" style="text-align: center;">상품정보</th>
					<th width="100" style="text-align: center;">수량</th>
					<th width="100" style="text-align: center;">배송 상태</th>
				</tr>
			</thead>
	
			
			<tbody id="body">
				
				
			</tbody>


		</table>

		<script>
			$(".ebtn").click(function() {
				var text = $(this).text();

				$.ajax({
					url: "orderHistoryButton.my",
					data : {date : text},
					type: "post",
					success: function(list) {
						var result = "";
                    	
                    	for(var i in list) {
							console.log(list[i].filePathName);
                    		result += "<tr>"
                    				+ "<td>" + list[i].productEnroll + "</td>"
                    				+ "<td>" + '<img src="'+list[i].filePathName+'" width="100" height="100">' + "</td>"
                    				+ "<td style='text-align: center;'>" + list[i].productName + "</td>"
                    				+ "<td style='text-align: center;'>" + list[i].stock + "</td>"
                    				+ "<td style='text-align: center;'> 배송 완료 </td>"
                    				+ "</tr>";
                    	}
                    	
                    	 $("#body").html(result);
					},
					error: function(){
						alert("주문내역 불러오기 실패");
					}
				});
			})
	
			$("#dateSearch").click(function() {
				var date1 = $('#dateSearch1').val();
				var date2 = $('#dateSearch2').val();
				
				$.ajax({
					url: "orderHistoryDateRange.my",
					data : {date1 : date1, date2: date2},
					type: "post",
					success: function(list) {
						var result = "";
                    	
                    	for(var i in list) {
                    		result += "<tr>"
                    				+ "<td>" + list[i].productEnroll + "</td>"
                    				+ "<td>" + '<img src="'+list[i].filePathName+'" width="100" height="100">' + "</td>"
                    				+ "<td style='text-align: center;'>" + list[i].productName + "</td>"
                    				+ "<td style='text-align: center;'>" + list[i].stock + "</td>"
                    				+ "<td style='text-align: center;'> 배송 완료 </td>"
                    				+ "</tr>";
                    	}
                    	
                    	 $("#body").html(result);
					},
					error: function(){
						alert("주문내역 불러오기 실패");
					}
				});
			})
		</script>
			
		<!-- <div align="center" class="paging-area">
        	
        	<% if(currentPage != 1) { %>
        		<button class="btn btn-sm btn-info" onclick="location.href='<%= contextPath %>/list.bo?cpage=<%= currentPage-1 %>'"> &lt; </button>
        	<% } %>

            <% for(int i=startPage ; i<=endPage ; i++){%>
            	<% if(i != currentPage) { %>
            		<button class="btn btn-sm btn-info" onclick="location.href='<%= contextPath %>/list.bo?cpage=<%= i %>'"><%= i %></button>
            	<% } else {%>
            		<button class="btn btn-sm btn-primary" disabled><%= i %></button>
            	<% } %>
            <%} %>
            
            <% if(currentPage != maxPage) { %>
        		<button class="btn btn-sm btn-info" onclick="location.href='<%= contextPath %>/list.bo?cpage=<%= currentPage+1 %>'"> &gt; </button>
        	<% } %>
        </div> -->
	</div>
	
	<!-- footer 시작 -->
	<%@ include file="../common/footer.jsp" %>
	<!-- footer 끝 -->
</body>
</html>
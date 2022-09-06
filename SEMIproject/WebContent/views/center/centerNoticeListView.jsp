<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, com.kh.center.model.vo.*, com.kh.common.model.vo.PageInfo" %>
<%
	ArrayList<CenterNotice> list = (ArrayList<CenterNotice>)request.getAttribute("list");
	
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// 페이징바 만들때 필요한 변수 미리 셋팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닭치고 이거닭</title>
<style>
	.outer{
		background-color: white;
		color: black;
		width: 1000px;
		margin: auto;
		margin-top: 30px;
	}

    .table{
        text-align: center;
        border: 2px solid white;
        font-weight: 300;
    }
    
    .table>tbody>.list-noti:hover{
        cursor: pointer;
    }
	
	.btn-div a{
		margin: 0 95px;
	}
	
	#del{
		text-align:right;
	}
	
	.notice-faq-btn{
		display: flex;
		justify-content: space-between;
		margin-bottom: 10px;
	}

	.noti-content{
		white-space: pre-wrap;
	}
   	
</style>
</head>
<body>
	<!-- header start -->
	<%@ include file="../common/header.jsp" %>
		
		
		<div class="outer">
			<br><br><br><br>
			<div class="btn-div">
				<a href="<%=contextPath%>/center.ce?cpage=1" class="btn btn-lg btn-secondary">자주묻는 FAQ</a>
				<a href="<%=contextPath%>/list.ce?cpage=1" class="forMember btn btn-lg btn-outline-secondary">1:1 문의</a>
				<a href="<%=contextPath%>/infoList.ce?cpage=1" class="btn btn-lg btn-outline-secondary"">이용안내</a>
			</div>


        	<br><br><br><br>
        	<h4 align="left" style="color:black">자주묻는 FAQ </h4>



        <!-- 관리자만 글작성 버튼이 보이게끔 -->
        <% if(loginMember != null && loginMember.getMemberId().equals("admin")) {%>
        <!-- 로그인이 되어있고, 그리고 관리자일 경우  -->
	        <div style="width:850px">
	            <!--
	            <button onclick="location.href="이동할페이지";">글작성</button>
				버튼에 href속성이 없기 때문에 버튼을 눌러서 페이지를 이동시키려면 onclick="location.href='요청url'"
	            -->
	            <!-- a태그를 쓰고도 버튼 모양을 만들고 싶다면? : 부트스트랩 활용 -->
				<div class="notice-faq-btn">
					<a href="<%=contextPath %>/enrollFormN.ce" class="btn btn-warning">글작성</a>
					<a data-toggle="modal" data-target="#deleteNotice" class="btn btn-warning">글삭제</a>
				</div>
				
				<table class="list-area, table">
            <thead>
                <tr>

                </tr>                
            </thead>
            <tbody>
            	<!-- 리스트가 비어있는가 확인 -->
            	<% if(list.isEmpty()) { %>
            		<!-- 비어 있을 경우 -->
	                 <tr>
	                     <th align="center">
	                         FAQ가 존재하지 않습니다!
	                     </th>
	                 </tr>
	             <% } else { %>
	                 <!-- 공지사항이 존재할 경우 -->
	                 <% for(CenterNotice n : list)  { %>
		                 <tr class="list-noti">
		                     <th width="100" Style="color:#FFD000">
		                         NO.<%= n.getNoticeNo() %>
		                     </th>
		                     <td>
		                     	<div data-toggle="collapse" data-target="#collapseExample<%= n.getNoticeNo() %>">
			                         <span>
			                         <%= n.getNoticeTitle() %>
			                         </span>
		                     	</div>
		                     	<br>
		                     	  <div class="collapse" id="collapseExample<%= n.getNoticeNo() %>">
									  <br>
									  <div class="card card-body">
									  	<pre class="noti-content"><%=n.getNoticeContent() %></pre>
									  </div>
								  </div>
		                     </td>
		                 </tr>
		              <% } %>
	             <% } %>
            		
            		
            </tbody>
        </table>
				
				
		<% } else {%>


	         <table class="list-area, table">
	            <thead>
	                <tr>
	
	                </tr>                
	            </thead>
	            <tbody>
	            	<!-- 리스트가 비어있는가 확인 -->
	            	<% if(list.isEmpty()) { %>
	            		<!-- 비어 있을 경우 -->
		                 <tr>
		                     <th align="center">
		                         FAQ가 존재하지 않습니다!
		                     </th>
		                 </tr>
		             <% } else { %>
		                 <!-- 공지사항이 존재할 경우 -->
		                 <% for(CenterNotice n : list)  { %>
			                 <tr class="list-noti">
			                     <th width="10" Style="color:#FFD000">
			                         Q
			                     </th>
			                     <td>
			                     	<div data-toggle="collapse" data-target="#collapseExample<%= n.getNoticeNo() %>">
				                         <span>
				                         <%= n.getNoticeTitle() %>
				                         </span>
			                     	</div>
			                     	<br>
			                     	  <div class="collapse" id="collapseExample<%= n.getNoticeNo() %>">
										  <br>
										  <div class="card card-body">
										  	<pre class="noti-content"><%=n.getNoticeContent() %></pre>
										  </div>
									  </div>
			                     </td>
			                 </tr>
			              <% } %>
		             <% } %>
	            		
	            		
	            </tbody>
	        </table>
	        <% } %>
        <br><br><br>
 
	
	    <!-- 삭제 모달 -->
    <form action="<%= contextPath %>/deleteN.ce" method="post" id="delete-Notice">
        <div class="modal fade" id="deleteNotice">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
    
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h5 class="modal-title">삭제하고 싶은 No.번호를 입력해주세요!</h5>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    
                    <!-- Modal body -->
                    <div class="modal-body">
                        <table>
                            <tr>
                                <th>No.(번호)=></th>
                                <td>
                                    <input type="text" name="deleteNo">
                                </td>
                            </tr>
                        </table>
                    </div>
        
                <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-secondary">삭제하기</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
                    </div>
        
                </div>
            </div>
        </div>
    </form>

        
        

    </div>
    
    <script>
		let isLogIn = false;
	    
	    // 로그인이 돼있으면 true else false
	    if("<%= loginMember %>" != "null"){
	        isLogIn = true;
	    }
	
	    // 로그인이 안돼있으면 클래스속성값이 forMember인 태그의 이벤트 실행 X
	    if(!isLogIn){
	        $('.forMember').click(function(e){
	            alert("로그인 후 이용이 가능합니다. 로그인 하시겠습니까?");
	            e.preventDefault();
	            location.href="<%= contextPath %>/loginform.me";
	        })
	    }
    
    </script>
	
		<div align="center" class="paging-area">
			<% if(currentPage != 1 ) { %>
				<button onclick="location.href='<%= contextPath%>/center.ce?cpage=<%= currentPage -1 %>'" class="btn btn-sm">&lt;</button>
			<% } %>
			<% for(int i = startPage; i <= endPage; i++) { %>
				<% if(i != currentPage) { %>
					<button onclick="location.href='<%= contextPath%>/center.ce?cpage=<%= i %>'" class="btn btn-sm" ><%= i %></button>
				<% } else { %>
					<button class="btn btn-sm btn-red" style="font-weight: 1000; text-decoration: underline; color:red;" disabled><%= i %></button>
				<% } %>		
			
			<% } %>
			<% if(currentPage != maxPage) { %> 
				<button onclick="location.href='<%= contextPath%>/center.ce?cpage=<%= currentPage +1 %>'" class="btn btn-sm">&gt;</button>
			<% } %>

		</div>





	<br><br><br><br><br><br><br><br><br>
	<!-- footer start -->
	<%@ include file="../common/footer.jsp" %>
</body>
</html>
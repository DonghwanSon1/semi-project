<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kh.event.model.vo.*" %>
<%
   Event e = (Event)request.getAttribute("e");
   ArrayList<EventAttachment> list = (ArrayList<EventAttachment>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
   .outer {
      background-color: white;
      color: black;
      width: 1000px;
      margin: auto;
      margin-top: 30px;
     }
     
     table tr:first-child td input{
        color : darkcyan;
        width: 100%;
     }
     table{
      width: 700px;
     }
     table tr td * {
      width: 100%;
     }
     #file-area{
      display: flex;
      flex-direction: row;
      width: 700px;
      flex-wrap: wrap;
      position: relative;
      left: 250px;
     }
     #backlist{  position: relative;
                  left: 470px;
     }

      thead>tr{
         table-layout: fixed;
      }

      .title, .writer{
         height: 60px;
         text-align: center;
         width: 200px;
      }

      tbody .subImg{
         width: 100% ;
      }
   
         

      

   
</style>
<title>이벤트게시판 상세보기</title>
</head>
<body>
<%@ include file="../common/header.jsp" %>
   
   <div class="outer">
      <br>
      <h2 align="center">이벤트게시판</h2>
      <hr>
      <br>
      
      
         
         <table id="detail-form" align="center" border="1">
            <thead>   
            <tr>
               <td class="title" width="100", bgcolor="#FFFF00";>제목</td>
               <td colspan="3" width="600"><%= e.getEventTitle() %></td>
            </tr>
            <tr>
               <td class="writer" bgcolor="#FFFF00";>작성자</td>   
               <td><%= e.getEventWriter() %></td>
            </tr>
         </thead>

            
            <!-- 미리보기 영역 -->
            <tbody>
            <tr>
               <!--타이틀-->
               <td colspan="3" align="center">
                  <img src="<%= contextPath %>/<%= list.get(0).getFilePath()+list.get(0).getChangeName() %>" class="titleImg" id="titleImg" width="300" height="500">
               
               </td>
               
            </tr>
            <tr>
            <!-- 상세 -->
        
               <td colspan="3" align="center">
						<% for(int i = 1; i < list.size(); i++){ %>
							<img src="<%= contextPath %>/<%= list.get(i).getFilePath()+list.get(i).getChangeName() %>" height="500">
						<% } %>
					</td>

               
           
            </tr>
            
            <tr>

               <td colspan="3">
                  <p style="height: 100px;"><%= e.getEventContent() %></p>
               </td>
            </tr>
            <tbody>

         </table>
         <br>
         <div id="backlist" align="center">
            <a href="<%= contextPath %>/list.ev" class="btn btn-primary">목록</a>
            <% if(loginMember != null && loginMember.getMemberId().equals("admin")) { %>
      
            <a href="<%= contextPath %>/delete.ev?eno=<%= e.getEventNo() %>" class="btn btn-sm btn-danger">삭제하기</a>
         <% } %>
         </div>
         <br>
         <br>
   
         

   </div>
   
   <%@ include file="../common/footer.jsp" %>
   
   
</body>
</html>
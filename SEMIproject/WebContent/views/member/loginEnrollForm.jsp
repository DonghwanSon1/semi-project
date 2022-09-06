<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String contextPath = (String)request.getContextPath();
	%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>닭치고이거닭</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginEnroll.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>

</head>
<body>
	<form action="<%= contextPath %>/insert.me" method="post" id="login-enroll">
	 <!-- header -->
        <div id="header">
           <h2>회원가입</h2>
        </div>


        <!-- wrapper -->
        <div id="wrapper">

            <!-- content-->
            <div id="content">

                <!-- ID -->
                <div>
                    <h3 class="join_title">
                        <label for="id">아이디</label>
                    </h3>
                    <span class="box int_id">
                        <input type="text" id="checkId" name="memberId" class="int" maxlength="20" placeholder="">
                  
                    </span>
                    <span class="error_next_box"></span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="password" id="pswd1"  class="int" maxlength="20" placeholder="" name="memberPwd">
                        <span id="alertTxt">사용불가</span>
                        <img src="${pageContext.request.contextPath}/resources/img/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- PW2 -->
                <div>
                    <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                    <span class="box int_pass_check">
                        <input type="password" id="pswd2" class="int" maxlength="20" placeholder="">
                        <img src="${pageContext.request.contextPath}/resources/img/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- NAME -->
                <div>
                    <h3 class="join_title"><label for="name">이름</label></h3>
                    <span class="box int_name">
                        <input type="text" id="name" name="memberName" class="int" maxlength="20" placeholder="이름" >
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- BIRTH -->
                <div>
                    <h3 class="join_title"><label for="yy">생년월일</label></h3>

                    <div id="bir_wrap">
                        <!-- BIRTH_YY -->
                        <div id="bir_yy">
                            <span class="box">
                                <input type="text" id="yy" class="int" maxlength="4" placeholder="년(4자)" name="yy">
                            </span>
                        </div>

                        <!-- BIRTH_MM -->
                        <div id="bir_mm">
                            <span class="box">
                                <input type="text" id="mm" class="int" maxlength="2" placeholder="월 (ex 1월 : 01)" name="mm">
                            </span>
                        </div>

                        <!-- BIRTH_DD -->
                        <div id="bir_dd">
                            <span class="box">
                                <input type="text" id="dd" class="int" maxlength="2" placeholder="일" name="dd">
                            </span>
                        </div>

                    </div>
                    <span class="error_next_box"></span>    
                </div>

                <!-- GENDER -->
                <div>
                    <h3 class="join_title"><label for="gender">성별</label></h3>
                    <span class="box gender_code">
                        <select id="gender" class="sel">
                            <option>성별</option>
                            <option value="M">남자</option>
                            <option value="F">여자</option>
                        </select>                            
                    </span>
                    <span class="error_next_box">필수 정보입니다.</span>
                </div>


                <!-- Question -->

                <div>
                    <h3 class="join_title"><label for="question">질문</label></h3>
                    <span class="box question_code">
                        <select id="question" class="sel" name="question">
                            <option value="0">질문</option>
                            <option value="1">자신의 보물 1호는?</option>
                            <option value="2">가장 기억에 남는 선생님 성함은?</option>
                            <option value="3">다시 태어나면 되고 싶은것은?</option>
                            <option value="4">존경하는 인물은?</option>
                            <option value="5">자신의 인생 좌우명은?</option>
                        </select>                            
                    </span>
                    <span class="error_next_box">필수 정보입니다.</span>
                </div>

                <!-- Answer -->

                <div class="answer-play" id="answer-play1">
                    <h3 class="join_title"><label for="answer">답변</label></h3>
                    <span class="box int_answer">
                        <input type="text" id="answer" class="int" maxlength="20" placeholder="" name="answer">
                       
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- EMAIL -->
                <div>
                    <h3 class="join_title"><label for="email">이메일</label></h3>
                    <span class="box int_email">
                        <input type="text" id="email" class="int" maxlength="100" placeholder="선택입력" name="email">
                    </span>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>
                        
                </div>

                <!-- MOBILE -->
                <div>
                    <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
                    <span class="box int_mobile">
                        <input type="tel" id="mobile" class="int" maxlength="11" placeholder="전화번호 입력(-제외)" name="phone">
                    </span>
                    <span class="error_next_box"></span>    
                </div>

                <!-- NICKNAME -->

                <div>
                    <h3 class="join_title"><label for="nickName">닉네임</label></h3>
                    <span class="box int_nickName">
                        <input type="text" id="nickName" name="loginNickName" class="int" maxlength="20" placeholder="이름">
                    </span>
                    <span class="error_next_box"></span>
                </div>


                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="submit" id="btnJoin">
                        <span>가입하기</span>
                    </button>
                </div>

                

            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
        </form>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    <script>
        $(document).ready(function() {
            $('.answer-play').hide();
            $('#question').change(function() {
                var result = $('#question option:selected').val();
                if (result != "0") {
                $('.answer-play').show();
                } else {
                $('.answer-play').hide();
                }
            }); 
        }); 

    </script>


</body>
</html>
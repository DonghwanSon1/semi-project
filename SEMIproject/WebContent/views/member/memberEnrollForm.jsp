<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    .wrapper{
        display: flex;
        justify-content: center;
    }
</style>
<title>닭치고 이거닭</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>

    <div class="wrapper">
        <form action="<%= contextPath %>/insert.me">
            <h2>회원가입</h2>
            <table>
                <tr>
                    <th>아이디 : </th>
                    <td>
                        <input type="text" name="userId" id="userId" placeholder="아이디를 입력하세요" class="form-control" autofocus required>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호 : </th>
                    <td>
                        <input type="password" name="userPwd" id="userPwd" placeholder="비밀번호 입력" class="form-control" required>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호 확인 : </th>
                    <td>
                        <input type="password" name="userPwdCheck" id="userPwdCheck" placeholder="비밀번호 확인" class="form-control" required>
                    </td>
                </tr>
                <tr>
                    <th>이름 : </th>
                    <td>
                        <input type="text" name="userName" id="userName" placeholder="이름을 입력하세요" class="form-control" autofocus required>
                    </td>
                </tr>
                <tr>
                    <th>이메일 : </th>
                    <td>
                        <input type="email" name="email" id="email" placeholder="Email" class="form-control" name= "email">
                    </td>
                </tr>
                <tr>
                    <th>연락처 : </th>
                    <td>
                        <input type="text" name="phone" id="phoneNumber" placeholder="- 포함 (000-0000-0000)" class="form-control">
                    </td>
                </tr>
                <tr>
                    <th>주소 : </th>
                    <td>
                        <input type="text" name="address" id="address" placeholder="주소 입력" class="form-control">
                    </td>
                </tr>
                <tr>
                	<th>취미 : </th>
                    <td>
                        <label for="sport">운동</label>
                        <input type="checkbox" name="interest" id="sport" value="운동">
                        <label for="sing">노래</label>
                        <input type="checkbox" name="interest" id="sing" value="노래">
                        <label for="travel">여행</label>
                        <input type="checkbox" name="interest" id="travel" value="여행">
                        <label for="game">게임</label>
                        <input type="checkbox" name="interest" id="game" value="게임">
                        <label for="movie">영화</label>
                        <input type="checkbox" name="interest" id="movie" value="영화">
                        <label for="instrument">악기</label>
                        <input type="checkbox" name="interest" id="instrument" value="악기">
                    </td>
                </tr>
            </table>

            <button type="submit" class="btn btn-primary">회원가입</button>
            <button type="reset" class="btn btn-warning">초기화</button>
        </form>
    </div>
</body>
</html>
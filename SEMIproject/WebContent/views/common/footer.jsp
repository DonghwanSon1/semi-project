<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    .footer *{
        margin: auto;
    }
    .footer-wrapper{
        width: 1130px;
        height: 100%;
        display: flex;
    }
    .footer{
        border-top: 1px solid #FFD000;
        display: flex;
        flex-direction: row;
        resize: none;
    }
    .footer__row{
        background-color: #FAFBFC;
        height: 100px;
        width: 100%;
        padding: 20px;
    }
    .footer__row--head{
        margin-bottom: 10px;
    }

</style>
<title>푸터</title>
</head>
<body>
    <div class="footer">
        <div class="footer-wrapper">
            <div class="footer__row">
                <div>
                    <h2 class="footer__row--head">닭치고 이거닭</h2>
                    <p>
                        바쁜일상 충분한단백질 또는 영양 섭취에 어려움을 <br>겪는 사람들을 위해
                        간편하고 빠른 건강 식품추천<br> 및 제공 업체를 소개 해주기위한 곳입니다.
                    </p>
                </div>
            </div>
            <div class="footer__row">
                <div>
                    <h4 class="footer__row--head">(주) 버터구이오징어</h4>
                    <span>대표 : 김정길</span><br>
                    <span>주소 : 중구 신당동</span><br>
                    <span>사업자등록번호 : 1234-56-1234</span><br>
                    <span>Copyright©닭치고이거닭 All rights reserved.</span>
                </div>
            </div>
            <div class="footer__row">
                <div>
                    <h3 class="footer__row--head">고객센터</h3>
                    <h4>대표번호 : 02-123-4567</h4>
                    <p>월-금 10:00 ~ 17:00 (점심 12:30 ~ 13:30)<br>주말/공휴일 제외</p>
                    <p>Fax : 02-0000-0000</p>
                    <p>Email : chicken@asdasd.com</p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
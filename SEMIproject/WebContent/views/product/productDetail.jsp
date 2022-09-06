<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.ATHROW"%>
<%@page import="com.kh.product.model.vo.ProductAttachment"%>
<%@page import="com.kh.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%
 Product p = (Product)request.getAttribute("p");
 ArrayList<ProductAttachment> pa = (ArrayList<ProductAttachment>)request.getAttribute("pa");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    html {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        height: 100%;
        color: #333;
        font-size: 14px;
        font-weight: 400;
        font-family: 'Pretendard', sans-serif;
        word-break: break-all;
        justify-content: center;
        align-items: center;
    }

    .blind{
        position:absolute;
        width:1px;
        height:1px;
        padding:0;
        overflow:hidden;
        clip:rect(0,0,0,0);
        border:0
    }

    .frame-sm {
        position: relative;
        max-width: 1100px;
        margin: 0 auto;
    }

    .goods-top-wrap {
    padding-top: 70px;
    }

    .goods-top-wrap .goods-img-area {
    float: left;
    width: 480px;
    height: 550px;
    }

    img {
    border: 0;
    }

    img {
    max-width: 100%;
    }

    .goods-top-wrap .goods-info-area {
    float: right;
    width: 560px;
    padding-right: 40px;
    }


    .goods-info-area .goods-tit {
    font-size: 26px;
    font-weight: 500;
    line-height: 40px;
    margin-bottom: 10px;
    }

    .goods-info-area .brand-line + .goods-tit {
    margin-top: 5px;
    }

    h2 {
    display: block;
    font-weight: bold;
    }

    .goods-price {
    margin-top: 18px;
    position: relative;
    }


    .goods-price > p {
    display: inline-block;
    margin-right: 4px;
    }

    .goods-price .sale {
    color: #ff6001;
    font-size: 20px;
    font-weight: 700;
    }

    .goods-price .price > strong {
    font-size: 35px;
    }

    address, caption, cite, code, dfn, em, strong, th, var {
    font-style: normal;
    }

    .goods-price .option {
    font-size: 13px;
    color: #666;
    margin-top: 4px;
    }

    .goods-price .sns-share {
    position: absolute;
    top: 10px;
    right: 2px;
    }

    .btn-icon-share:after {
    width: 20px;
    height: 20px;
    background-position: -30px -190px;
    }

    .goods-price .origin > span {
    font-weight: 400;
    font-size: 14px;
    text-decoration: line-through;
    }

    .goods-price .origin {
    color: #aaa;
    }

    .dl-table-group .dl-row > dt {
    display: table-cell;
    vertical-align: top;
    width: 100px;
    border-bottom: 1px solid #EDEDED;
    padding: 17px 0;
    color: #666;
    }

    .dl-table-group .dl-row > dd {
    display: table-cell;
    position: relative;
    vertical-align: top;
    border-bottom: 1px solid #EDEDED;
    padding: 17px 0;
    color: #333;
    }

    .option-select-area {
    padding-top: 15px;
    }

    .option-select-area .tit {
    display: block;
    color: #666;
    font-weight: 400;
    margin-bottom: 20px;
    }

    a {
    background: transparent;
    text-decoration: none;
    color: inherit;
    }

    .dropdown-box .dropdown-value {
    width: 450;
    display: block;
    position: relative;
    height: 100%;
    padding: 12px 40px 9px 15px;
    border: 1px solid #ccc;
    font-size: 15px;
    color: #666;
    box-sizing: border-box;
    background: #fff;
    line-height: 24px;
    }

    .option-select-area.new .dropdown-box .dropdown-value {
    padding: 12px 40px 12px 15px;
    }


    .option-select-area .total-area {
    text-align: right;
    margin-top: 30px;
    }

    .txt, .txt span {
    word-break: break-all;
    }

    .option-select-area .total-area .txt {
    display: inline-block;
    font-size: 16px;
    }

    .option-select-area .total-area {
    text-align: right;
    margin-top: 30px;
    }



    .option-select-area .total-area .price {
    display: inline-block;
    font-size: 16px;
    font-weight: 700;
    margin-left: 50px;
    }

    .option-select-area .total-area .price strong {
    font-size: 34px;
    }


    /* 버튼 */

    button {
    font: inherit;
    color: inherit;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    appearance: none;
    outline: none;
    cursor: pointer;
    }

    button {
    overflow: visible;
    }

    button {
    text-transform: none;
    }

    [class*="btn-basic-"], [class*="btn-option"], [class*="btn-rud-"] {
    display: inline-block;
    text-align: center;
    box-sizing: border-box;

    }

    [class*="btn-basic-"], [class*="btn-option"] {
    border-radius: 2px;
    }

    .btn-basic-lg {
    min-width: 215px;
    height: 56px;
    padding: 10px 25px 11px;
    }

    .btn-primary-line {
    background: #fff;
    color: black;
    border: 1px solid #3e3732;
    }

    .goods-info-area .option-select-area .btn-area > [class*="btn-basic-"] {
    vertical-align: top;
    flex-grow: 1;
    -webkit-box-flex: 1;
    width: 50%;
    margin: 0 3px;
    min-width: auto;
    }

    .goods-info-area .option-select-area .btn-area > [class*="btn-basic-"]:first-child {
    margin: 0 3px 0 0;
    }

    .btn-primary-ex {
    background: #f3f046;
    color: #fff;
    border: 1px solid #3e3732;
    }

    .goods-info-area .option-select-area .btn-area > [class*="btn-basic-"]:last-child {
    margin: 0 0 0 3px;
    }

    .btn-area {
    position: relative;
    text-align: center;
    display: flex;
    align-items: stretch;
    
    }

    button span {
    position: relative;
    }

    [class*="btn-basic-"] > span, [class*="btn-option"] > span, [class*="btn-rud-"] > span {
    display: inline-block;
    vertical-align: top;
    }

    .btn-basic-lg > span {
    font-size: 18px;
    line-height: 1.8;
    }

    .goods-info-area .option-select-area .btn-area > [class*="btn-basic-"] {
    vertical-align: top;
    flex-grow: 1;
    width: 50%;
    margin: 0 3px;
    min-width: auto;
    }

    [class*="btn-basic-"] > span, [class*="btn-option"] > span, [class*="btn-rud-"] > span {
    display: inline-block;
    vertical-align: top;
    }

    .btn-basic-lg > span {
    font-size: 18px;
    line-height: 1.8;
    }

    .btn-primary-ex > span, .btn-primary-exline > span {
    font-weight: 700;
    }


    /* 별점 */

    .rating-point-md {
    position: relative;
    display: inline-block;
    vertical-align: top;
    width: 98px;
    height: 18px;
    background: url(rating.png) 0 -40px;
    }

    .rating-point-md [class*="point"] {
    display: block;
    width: 98px;
    height: 18px;
    background: url(rating.png) 0 -60px;
    }

    .goods-info-area .rating-div .score {
    font-size: 13px;
    color: #555;
    }

    .goods-info-area .rating-div .num {
    font-size: 13px;
    color: #999;
    }

    a {
    background: transparent;
    text-decoration: none;
    color: inherit;
    }


    /* 수량 */

    .item_result li {
    overflow: hidden;
    position: relative;
    margin-top: 10px;
    margin-left: -40px;
    padding: 13px 15px 15px;
    background: #fafafa;
    border: 1px solid #f0f0f0;
    border-bottom: 1px solid #cccccc;

    }

    .bt_increase, .bt_decrease {
    border: none;
    }

    .item_result li:first-child {
    margin-top: 0;
    }

    .item_result .type__add-item .prod_area .prod_name {
    width: 440px;
    }

    .item_result li .prod_area .prod_name {
    overflow: hidden;
    margin-bottom: 6px;
    color: #222222;
    text-overflow: ellipsis;
    white-space: nowrap;
    }

    .item_result li .prod_area > span {
    display: block;
    width: 480px;
    }

    .item_result li .prod_area {
    float: left;
    overflow: hidden;
    width: 100%;
    margin-bottom: 14px;
    padding-bottom: 12px;
    border-bottom: 1px dotted #e1e1e1;
    font-size: 14px;
    line-height: 20px;
    }

    .item_result .result_price {
    display: block;
    float: right;
    font-size: 18px;
    line-height: 25px;
    color: #222;
    }

    .item_result .num-ctrl .bt_decrease {
    left: 0;
    background-position: -27px -106px;
    }

    .item_result .bt_increase, .item_result .bt_decrease, .item_result .btns button {
    background: url(direction.png) no-repeat;
    }

    .item_result .bt_increase, .item_result .bt_decrease {
    position: absolute;
    top: 79.9px;
    left: 59px;
    display: block;
    width: 25px;
    height: 25px;
    background-position: -108px -106px;
    outline: none;
    }
    .item_result .num-ctrl .bt_decrease {
    left: 0;
    background-position: -27px -106px;
    }

    .item_result .num-ctrl .bt_increase {
    background-position: -108px -106px;
    }
    .vip-content button {
    margin: 0;
    padding: 0;
    border: none;
    }
    ul, ol {
    list-style: none;
    }

    .vip-content button {
    margin: 0;
    padding: 0;
    border: none;
    }

    .item_result .num-ctrl .bt_increase {
    background-position: -108px -106px;
    }

    .item_result .num-ctrl .num {
    border: 1px solid #cccccc;
    }

    .item_result .num {
    width: 32px;
    height: 22px;
    margin: 0px 10px 3px 10px;
    border: 1px solid #cccccc;
    line-height: 19px;
    color: #233549;
    font-size: 14px;
    text-align: center;
    vertical-align: middle;
    padding: 1px 0 !important;
}
</style>
<title>상품 상세 페이지</title>
</head>
<body>

    <%@ include file="../common/header.jsp" %>

    <div class="wrap ">
        <div class="goods-top-wrap frame-sm">
            <div class="goods-img-area">
                <div class="goods-top">
                    <div class="img">
                        <img src="<%= pa.get(0).getFilePath() %>" style="height: 550px;">
                    </div>            
                </div>
            </div>
            <div class="goods-info-area">
                <div class="brand-line">
                </div>
                <h2 class="goods-tit"><%= p.getProductName() %></h2>
                <div class="rating-div">
                    <a href="" class="rating-point-md" >
                        <span class="point48"></span><span class="blind">별점4.6~4.9</span>
                        <span class="blind">별점</span>
                    </a>
                    <a href="" class="score" >5.0점</a>
                    <a href="" class="num">(28)</a>
                </div>
    
                <div class="goods-price">
                    <p class="sale"><strong>29</strong>%</p>
                    <p class="price"><strong><%= p.getPrice() %></strong>원</p>
                    <p class="origin"><span>31,950</span>원</p>
                    <div class="option">
                        (100g당 : 1,290원~1,520원)
                    </div>
                </div>

                <div class="option-select-area new">
                    <div class="optiontype type_result" id="divOrderList">
                        <ul class="item_result">
                            <li id="hliSelectedRequet" class="type__add-item">
                                <p class="prod_area">
                                    <span class="prod_name">수량</span>
                                </p>
                                <span class="num-ctrl uxequnatity-ctrl num-ctrl-option">
                                    <input type="text" title="수량" value="1" id="orderQtyNoOption" class="num" name="quantity" >
                                </span>
                                <strong class="result_price">수량에 따른 가격 증가</strong>	
                            </li>								
                        </ul>
                    </div>                   
                    <div class="total-area">
                        <div class="btn-area">
                            <button type="button" onclick="addCart();" class="btn-basic-lg btn-primary-line btnCartAdd" >
                                <span>장바구니</span>
                            </button>     
                        </div>
                    </div>
                </div>

                <div id="detail-area">
                    <% for(ProductAttachment at : pa) { %>
                        <dir><img src="<%= at.getFilePath() %>" alt=""></dir>
                    <% } %>
                </div>
            </div>
        </div>

        <div id = "review-area">
            <table border="1" align="center">
                <thead>
                    <% if(loginMember != null) { %>
                        <!-- 로그인이 O -->
                        <tr>
                            <th>리뷰작성</th>
                            <td>
                                <textarea id="reviewContent" cols= "50" rows="4" style="resize:none;"></textarea>
                            </td> 
                            <td><button onclick="insertReview();">리뷰등록</button></td>
                        </tr>
                    <% } else { %>
                        <!-- 로그인이 X-->
                        <tr>
                            <th>리뷰작성</th>
                            <td>
                                <textarea rows="4" cols= "50" style="resize:none;" readonly>로그인 후 이용가능한 서비스입니다.</textarea>
                            </td>
                            <td><button>리뷰등록</button></td>
                        </tr>
                    <% } %>
                </thead>
                <tbody>
                	
                </tbody>
            </table>
        </div> 
    </div>

    <br><br><br><br><br><br><br><br><br><br>

    <!-- footer -->
	<%@ include file="../common/footer.jsp" %>
	<!-- footer -->

    <script>
        function addCart(){

            const pno = "<%= p.getProductNo() %>";
            const mno = "<%= loginMember.getMemberNo() %>";
            const quant = $("input[name=quantity]").val();
            if(confirm("장바구니에 추가합니다.")) location.href = "<%= contextPath %>" + "/insertCart.pr?pno=" + pno +"&mno=" + mno + "&quant=" + quant;
        
        }
    </script>

    <script>
        function selectReviewList(){
            $.ajax({
                url : "rlist.pr",
                data : {pno : <%= p.getProductNo() %>},
                success : function(list){
                    
                    // 댓글갯수만큼 반복 => 누적(문자열)
                    var result ="";
                    for(var i in list){
                        result += "<tr>"
                                + "<td>" + list[i].reviewWriter + "</td>"
                                + "<td>" + list[i].reviewContent + "</td>"
                                + "<td>" + list[i].createDate + "</td>"
                                +"</tr>";
                    }
                    $("#review-area tbody").html(result);
                },
                error : function(){
                    console.log("리뷰 읽어오기 실패 ~");
                }
            });
        }
        
        // 리뷰는 화면이 로딩되었을 때 곧바로 뿌려줘야함 => window.onload => $(function(){})
        $(function(){
            selectReviewList();
            //setInterval(selectReviewList, 1000);
        });

        function insertReview(){
            $.ajax({
                url : "review.pr",
                data : {
                    pno : <%= p.getProductNo() %>,
                    content : $("#reviewContent").val()
                },
                type : "post",
                success : function(result){
                    // result값에 따라서 성공했으면 성공메시지 띄우기
                    if(result > 0){
                        alert("댓글작성에 성공하셨습니다!");
                        selectReviewList();
                        $('#reviewContent').val("");
                    }
                },
                error : function(){
                    console.log("댓글 작성 실패!")
                }
            });
        }
    </script>
</body>
</html>
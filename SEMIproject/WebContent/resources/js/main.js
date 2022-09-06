

/*변수 선언*/


var id = document.querySelector('#checkId');

var pw1 = document.querySelector('#pswd1');
var pwMsg = document.querySelector('#alertTxt');
var pwImg1 = document.querySelector('#pswd1_img1');

var pw2 = document.querySelector('#pswd2');
var pwImg2 = document.querySelector('#pswd2_img1');
var pwMsgArea = document.querySelector('.int_pass');

var userName = document.querySelector('#name');

var yy = document.querySelector('#yy');
var mm = document.querySelector('#mm');
var dd = document.querySelector('#dd');

var gender = document.querySelector('#gender');

var question = document.querySelector('#question');

var questionAnswer = document.querySelector('#question');



var answerPlay = document.querySelector('.answerPlay');


var email = document.querySelector('#email');

var mobile = document.querySelector('#mobile');

var nickName = document.querySelector('#nickName');

var error = document.querySelectorAll('.error_next_box');

var exist = document.querySelector('#exist');



/*이벤트 핸들러 연결*/


id.addEventListener("focusout", checkId);
pw1.addEventListener("focusout", checkPw);
pw2.addEventListener("focusout", comparePw);
userName.addEventListener("focusout", checkName);
yy.addEventListener("focusout", isBirthCompleted);
mm.addEventListener("focusout", isBirthCompleted);
dd.addEventListener("focusout", isBirthCompleted);
gender.addEventListener("focusout", function() {
    if(gender.value === "성별") {
        error[5].style.display = "block";
    } else {
        error[5].style.display = "none";
    }
})


question.addEventListener("focusout", function() {
    if(question.value === "질문") {
        error[6].style.display = "block";
    } else {
        error[6].style.display = "none";
    }
})



answer.addEventListener("focusout", checkAnswer);
email.addEventListener("focusout", isEmailCorrect);
mobile.addEventListener("focusout", checkPhoneNum);
nickName.addEventListener("focusout", checkNickName);


/*아이디 중복 체크 */

function resultCheck(res){
		if(res!=null && res.resultCode != null){
			if(res.resultCode == 1000){
				return res.data; 					
			}
			else{
				return false; 					
			}
		}
	}
  $("#checkId").on("change keyup paste", function(){			 
        
        $.ajax({
            type : "POST",            
            url : "idCheck.me",    
            data : {
            	memberId:$("#checkId").val(),	                	                	
            },            
            success : function(res){ // 비동기통신의 성공일경우 success콜백으로 . 'res'는 응답받은 데이터
            	var result = resultCheck(res)
            	
            	if(!result){
            	
            		alert(res.resultMsg + "\n잠시후 다시 시도하세요.");
            		
            		return;
            	}
            
            	console.log(JSON.stringify(res));
            	console.log(res);
            	
            	var exist = result.exist;
            	
            	if(exist == "T"){
            		 error[1].innerHTML = "중복된 ID입니다.";
            	     error[1].style.display = "block";
            	     error[1].style.color = "red";
            	    
            	}
            	else{
            		 error[1].innerHTML = "중복되지않은 ID입니다.";
            	     error[1].style.display = "block";
            	     error[1].style.color = "#08A600";
            	}
            	
            	
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                alert(textStatus);
            }
        });
    });




/*닉네임 중복 체크 */
  
  
  
  function resultCheck(res){
		if(res!=null && res.resultCode != null){
			if(res.resultCode == 1000){
				return res.data; 					
			}
			else{
				return false; 					
			}
		}
	}
$("#nickName").on("change keyup paste", function(){			 
      
      $.ajax({
          type : "POST",            
          url : "nicknamecheck.me",    
          data : {
        	  loginNickName:$("#nickName").val(),	                	                	
          },            
          success : function(res){ // 비동기통신의 성공일경우 success콜백으로 . 'res'는 응답받은 데이터
          	var result = resultCheck(res)
          	
          	if(!result){
          	
          		alert(res.resultMsg + "\n잠시후 다시 시도하세요.");
          		
          		return;
          	}
          
          	console.log(JSON.stringify(res));
          	console.log(res);
          	
          	var exist = result.exist;
          	
          	if(exist == "T"){
          		 error[11].innerHTML = "중복된 닉네임입니다.";
          	     error[11].style.display = "block";
          	     error[11].style.color = "red";
          	    
          	}
          	else{
          		 error[11].innerHTML = "사용가능한 닉네임 입니다.";
          	     error[11].style.display = "block";
          	     error[11].style.color = "#08A600";
          	}
          	
          	
          },
          error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
              alert(textStatus);
          }
      });
  });



/*콜백 함수*/

/*아이디 체크(중복체크 포함) */
function checkId() {
    var idPattern = /[a-zA-Z0-9_-]{5,20}/;
    if(id.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
    } else if(!idPattern.test(id.value)) {
        error[0].innerHTML = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        error[0].style.display = "block";
        error[0].style.color = "red";
    }    
    
    else if(error[1].innerHTML = "중복되지않은 ID입니다."){
        error[0].innerHTML = "멋진 아이디네요!";
        error[0].style.color = "#08A600";
        error[0].style.display = "block";
    }
}

function checkPw() {
    var pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
    if(pw1.value === "") {
        error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block";
    } else if(!pwPattern.test(pw1.value)) {
        error[2].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        pwMsg.innerHTML = "사용불가";
        pwMsgArea.style.paddingRight = "93px";
        error[2].style.display = "block";
        
        pwMsg.style.display = "block";
        pwImg1.src = "resources/img/m_icon_not_use.png";
    } else {
        error[2].style.display = "none";
        pwMsg.innerHTML = "안전";
        pwMsg.style.display = "block";
        pwMsg.style.color = "#03c75a";
        pwImg1.src = "resources/img/m_icon_safe.png";
    }
}

function comparePw() {
    if(pw2.value === pw1.value && pw2.value != "") {
        pwImg2.src = "resources/img/m_icon_check_enable.png";
        error[3].style.display = "none";
    } else if(pw2.value !== pw1.value) {
        pwImg2.src = "resources/img/m_icon_check_disable.png";
        error[3].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[3].style.display = "block";
    } 

    if(pw2.value === "") {
        error[3].innerHTML = "필수 정보입니다.";
        error[3].style.display = "block";
    }
}

function checkName() {
    var namePattern = /[a-zA-Z가-힣]/;
    if(userName.value === "") {
        error[4].innerHTML = "필수 정보입니다.";
        error[4].style.display = "block";
    } else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
        error[4].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[4].style.display = "block";
    } else {
        error[4].style.display = "none";
    }
}


function isBirthCompleted() {
    var yearPattern = /[0-9]{4}/;

    if(!yearPattern.test(yy.value)) {
        error[5].innerHTML = "태어난 년도 4자리를 정확하게 입력하세요.";
        error[5].style.display = "block";
    } else {
        isMonthSelected();
    }


    function isMonthSelected() {
        if(mm.value === "월") {
            error[5].innerHTML = "태어난 월을 선택하세요.";
        } else {
            isDateCompleted();
        }
    }

    function isDateCompleted() {
        if(dd.value === "") {
            error[5].innerHTML = "태어난 일(날짜) 2자리를 정확하게 입력하세요.";
        } else {
            isBirthRight();
        }
    }
}



function isBirthRight() {
    var datePattern = /\d{1,2}/;
    if(!datePattern.test(dd.value) || Number(dd.value)<1 || Number(dd.value)>31) {
        error[5].innerHTML = "생년월일을 다시 확인해주세요.";
    } else {
        checkAge();
    }
}

function checkAge() {
    if(Number(yy.value) < 1920) {
        error[5].innerHTML = "정말이세요?";
        error[5].style.display = "block";
    } else if(Number(yy.value) > 2020) {
        error[5].innerHTML = "미래에서 오셨군요.";
        error[5].style.display = "block";
    } else if(Number(yy.value) > 2005) {
        error[5].innerHTML = "만 14세 미만의 어린이는 보호자 동의가 필요합니다.";
        error[5].style.display = "block";
    } else {
        error[5].style.display = "none";
    }
}




function checkAnswer() {
    var answerPattern = /[a-zA-Z가-힣]/;
    if(answer.value === "") {
        error[8].innerHTML = "필수 정보입니다.";
        error[8].style.display = "block";
    } else {
        error[8].innerHTML = "멋진 답변이네요!";
        error[8].style.color = "#08A600";

    }
}



function isEmailCorrect() {
    var emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;

    if(email.value === ""){ 
        error[9].innerHTML = "필수 정보입니다.";
        error[9].style.display = "block";
    } else if(!emailPattern.test(email.value)) {
        error[9].style.display = "block";
    } else {
        error[9].style.display = "none"; 
    }

}

function checkPhoneNum() {
    var isPhoneNum = /([01]{2})([01679]{1})([0-9]{3,4})([0-9]{4})/;

    if(mobile.value === "") {
        error[10].innerHTML = "필수 정보입니다.";
        error[10].style.display = "block";
    } else if(!isPhoneNum.test(mobile.value)) {
        error[10].innerHTML = "형식에 맞지 않는 번호입니다.";
        error[10].style.display = "block";
    } else {
        error[10].style.display = "none";
    }

    
}

function checkNickName() {
    var nickNamePattern = /[a-zA-Z가-힣]/;
    if(answer.value === "") {
        error[11].innerHTML = "필수 정보입니다.";
        error[11].style.color = "red";
        error[11].style.display = "block";
    } else {
        error[11].innerHTML = "멋진 답변이네요!";
        error[11].style.color = "#08A600";

    }
}



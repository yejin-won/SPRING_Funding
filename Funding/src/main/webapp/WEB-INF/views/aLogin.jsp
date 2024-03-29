<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin page</title>
<style type="text/css">
html {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	height: 100%;
	z-index: 1;
}

.signIn__wrap {
	z-index: 1;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 400% 400%;
	animation: gradientBG 15s ease infinite;
}

@
keyframes gradientBG { 0% {
	background-position: 0% 50%;
}

50
%
{
background-position
:
100%
50%;
}
100
%
{
background-position
:
0%
50%;
}
}
.signIn__content {
	width: 280px;
	padding: 30px;
	background-color: white;
	border-radius: 16px;
}

.signIn__title {
	margin: 12px 0 16px;
}

.signIn__description {
	color: #555;
	margin: 0 0 24px;
}

.signIn__subTitle {
	font-size: 14px;
	font-weight: bold;
	margin: 4px 0;
}

.signIn__input {
	width: 280px;
	height: 40px;
	box-sizing: border-box;
	border-radius: 32px;
	border: 1px solid #aaa;
	padding: 8px 16px;
	line-height: 24px;
}

.signIn__warning {
	margin: 4px 4px 16px;
	font-size: 13px;
	color: red;
}

.signIn__submit {
	width: 280px;
	background-color: royalblue;
	color: white;
	height: 44px;
	margin: 24px 0;
	border-radius: 32px;
	cursor: pointer;
}

.signIn__submit:hover {
	filter: brightness(105%);
}

.signIn__submit:disabled {
	background-color: #aaa;
}

.signIn__submit:active {
	filter: brightness(95%);
}

.signIn__info {
	margin: 0;
	font-size: 14px;
}

#toast {
	position: fixed;
	bottom: 30px;
	left: 50%;
	padding: 15px 20px;
	transform: translate(-50%, 10px);
	border-radius: 30px;
	overflow: hidden;
	opacity: 0;
	visibility: hidden;
	transition: opacity .5s, visibility .5s, transform .5s;
	background: rgba(0, 0, 0, .35);
	color: #fff;
	z-index: 5;
}

#toast.reveal {
	opacity: 1;
	visibility: visible;
	transform: translate(-50%, 0)
}
</style>
</head>
<script type="text/javascript">
	let emailPattern = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	window.onload = function(){
		let errorCode = "<%=request.getParameter("error")%>"
		console.log(errorCode)
		if(errorCode !== "null"){
			toast("관리자 로그인 정보를 확인해주세요")
		}
		if(localStorage.getItem("aid")){
			document.getElementById('aid').value = localStorage.getItem("aid");
			document.getElementById("rememberMe").checked = true;
		}
	}


	function validate(){
		const id = document.getElementById('aid').value
		const pw = document.getElementById('apw').value

		if(id.match(emailPattern) && pw.length >= 4){
			document.getElementById('submit').disabled = false;
		}else{
			document.getElementById('submit').disabled = true;
		}
	}

	function idFocus(){
		document.getElementById('idValidate').innerHTML = ''
	}
	function pwFocus(){
		document.getElementById('pwValidate').innerHTML = ''
	}

	function idValidate(){
		const id = document.getElementById('aid').value
		if(!id.match(emailPattern)){
			document.getElementById('idValidate').innerHTML = '아이디는 이메일 형식으로 입력해야 합니다'
		}else{

			document.getElementById('idValidate').innerHTML = ''
		}
	}
	function pwValidate(){
		const pw = document.getElementById('apw').value
		if(pw.length < 4){
			document.getElementById('pwValidate').innerHTML = '4자 이상의 패스워드를 입력해주세요'
		}else{
			document.getElementById('pwValidate').innerHTML = ''
		}
	}
	function checkCheck(){
		const check = document.getElementById("rememberMe");
		if(check.checked){
			localStorage.setItem('aid', document.getElementById('aid').value);
		}else{
			localStorage.setItem('aid', "");
		}
	}

	function toast(string) {
	    const toast = document.getElementById("toast");

	    toast.classList.contains("reveal") ?
	        (clearTimeout(removeToast), removeToast = setTimeout(function () {
	            document.getElementById("toast").classList.remove("reveal")
	        }, 3000)) :
	        removeToast = setTimeout(function () {
	            document.getElementById("toast").classList.remove("reveal")
	        }, 3000)
	    toast.classList.add("reveal"),
	        toast.innerText = string
	}
</script>


<body>

	<div class="signIn__wrap">
		<div class="signIn__content">
			<h1 class="signIn__title">관리자 로그인</h1>
			<p class="signIn__description">관리자 아이디로 로그인하세요!</p>
			<form action="aLogin.do" name="signInForm" method="post"
				onsubmit="checkCheck()">
				<div class="signIn__liner">
					<p class="signIn__subTitle">아이디</p>
					<input class="signIn__input" id="aid" name="adminId"
						placeholder="example@admin.com" onkeyup="validate()"
						onfocus="idFocus()" onblur="idValidate()">
					<p id="idValidate" class="signIn__warning"></p>
				</div>
				<div class="signIn__liner">
					<p class="signIn__subTitle">패스워드</p>
					<input class="signIn__input" id="apw" type="password"
						name="adminPw" onkeyup="validate()" onfocus="pwFocus()"
						onblur="pwValidate()">
					<p id="pwValidate" class="signIn__warning"></p>
				</div>
				<div class="signIn__rememberLiner">
					<input type="checkbox" name="rememberMe" id="rememberMe"> <label
						for="rememberMe">아이디 저장</label>
				</div>
				<input class="signIn__submit" id="submit" type="submit" value="로그인"
					disabled>

			</form>
		</div>
	</div>
	<div id="toast"></div>

</body>
</html>
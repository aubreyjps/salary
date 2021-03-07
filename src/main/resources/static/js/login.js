function login(){
	var phonenum = $(".loginForm input[name='phonenum']").val();
	var password = $(".loginForm input[name='password']").val();
	var num = sessionStorage.getItem("num")
	if(phonenum.length == 0)
		$(".loginForm input[name='phonenum']").css('border-color','red')
	else if(password.length == 0)
		$(".loginForm input[name='password']").css('border-color','red')
	else {
		if (validate() || num <3) {
			$(".loginForm").submit();
			sessionStorage.setItem("phonenum", phonenum);
		}
	}
	num++
	sessionStorage.setItem("num",num)
	if (num>=3)
		$(".yanzhengma").css("display","block")
}

function register() {
	var phonenum = $(".registerForm input[name='phonenum']").val();
	var name = $(".registerForm input[name='name']").val();
	var password = $(".registerForm input[name='password']").val();
	var confim = $("input[name='confim']").val();
	var num = sessionStorage.getItem("num")
	if (phonenum.length == 0)
		$(".registerForm input[name='phonenum']").css('border-color','red')
	else if (name.length == 0)
		$(".registerForm input[name='name']").css('border-color','red')
	else if (password.length == 0)
		$(".registerForm input[name='password']").css('border-color','red')
	else if (confim != password)
		$("p[text='rinfo']").text("两次密码输入不一致");
	else {
		if (validate() || num <3) {
			$(".registerForm").submit();
			sessionStorage.setItem("phonenum", phonenum);
		}
	}
	num++
	sessionStorage.setItem("num",num)
	if (num>=3)
		$(".yanzhengma").css("display","block")
}
function validate() {
	var inputCode = $(".input1").val().toUpperCase();
	if (inputCode.length <= 0) {
		$("p[text='info']").text("请输入验证码");
		return false;
	} else if (inputCode != code) {
		$("p[text='info']").text("验证码输入错误，请重新舒输入");
		createCode();
		return false;
	} else {
		return true;
	}
}
var code; //在全局 定义验证码
function createCode() {
	code = new Array();
	var codeLength = 4; //验证码的长度
	var checkCode = $(".checkCode");
	var selectChar = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
	for (var i = 0; i < codeLength; i++) {
		var charIndex = Math.floor(Math.random() * 32);
		code += selectChar[charIndex];
	}
	if (code.length != codeLength) {
		createCode();
	}
	checkCode.val(code);
}

$(function () {
	if (sessionStorage.getItem("num") == undefined)
		sessionStorage.setItem("num",0)
	createCode()
	var str = window.location.href
	if (str.indexOf("error") != -1){
		$("p[text='info']").text("密码输入有误，请重新舒输入");
	}
	document.getElementsByTagName("img")[1].style.width  = document.body.scrollWidth+"px";
	
	$(".toRegister").click(function () {
		$(".log").css('display','none')
		$(".reg").css('display','block')
	})

	$(".toLogin").click(function () {
		$(".log").css('display','block')
		$(".reg").css('display','none')
	})

	$("input").focus(function(){
		$(this).css("border-color","#76d4f5")
	});

	$("input").blur(function(){
		$(this).css("border-color","#ccc")
	});
})


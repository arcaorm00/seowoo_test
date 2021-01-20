<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#signinBtn").click(function(){
		var id = $("#id").val();
		var password = $("#password").val();
		
		$.ajax({
			data: JSON.stringify({id: id, password: password}),
			url: "./memberSigninPro.ino",
			type: "POST",
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			success: function(res){
				var isCorrectPwd = res.isCorrectPwd;
				var member = res.member;
				
				if (isCorrectPwd){
					sessionStorage.setItem("id", member.ID);
					location.href="./main.ino";
				}
			}
		});
	});
});
</script>
</head>
<body>
	<div>
		<h1>로그인</h1>
		<br/>
		<table>
			<tr>
				<td>아이디&nbsp;</td>
				<td><input type="text" id="id" name="id"/></td>
			</tr>
			<tr>
				<td>비밀번호&nbsp;</td>
				<td><input type="password" id="password" name="password"/></td>
			</tr>
			<tr align="right">
				<td colspan="2"><button id="signinBtn">로그인</button></td>
			</tr>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<h1>공통코드 등록</h1>
	</div>
	
	<div style="width:650px;" align="right">
		<button id="addBtn" name="addBtn">추가</button>
		<button id="insertBtn" name="insertBtn">등록</button>
	</div>
	<hr style="width: 600px;">
	<div style="padding-bottom: 10px;">
		<table border="1">
			<thead>
				<tr>
					<td style="width: 80px; padding-left: 30px;" align="center">CODE</td>
					<td style="width: 80px; padding-left: 10px;" align="center">DECODE</td>
					<td style="width: 200px;" align="center">코드 이름</td>
					<td style="width: 100px; padding-left: 50px;" align="center">사용여부</td>
				</tr>
			</thead>
		</table>
	</div>
	<hr style="width: 600px;">

	<div id="boardDiv">
		<table id="boardTable" border="1">
			<tbody>
				
			</tbody>
		</table>
	</div>
</body>
</html>
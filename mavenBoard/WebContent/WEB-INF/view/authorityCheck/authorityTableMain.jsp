<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>그룹목록</h1>
	</div>

	<hr style="width: 600px">
	<table style="width: 600px;" border="1">
		<thead>
			<tr>
				<th>그룹 아이디</th>
				<th>그룹이름</th>
				<th>사용유무</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="nRow" items="${ list }">
				<tr align="center">
					<td style="width: 100px;">${ nRow.groupId }</td>
					<td style="width: 100px;"><a href="./authorityDetail.ino?check=${ nRow.groupId }">${ nRow.groupName }</a></td>
					<td style="width: 100px;">${ nRow.useYn }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
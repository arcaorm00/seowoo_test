<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>
<script type="text/javascript">
$(function(){

	$("#registerBtn").click(function(){
		var groupId = $("#groupId").val();
		var list = [];
		$("input[name=objCheck]").each(function(){
			var objId = $(this).parents("tr").children(".objId").text();
			
			if($(this).is(":checked") && $(this).parents("tr").children(".useYn").text() == "미사용"){
				var row = {groupId: groupId, objId: objId, FLAG: 'I'}
				list.push(row);
			}else if(!$(this).is(":checked") && $(this).parents("tr").children(".useYn").text() == "사용중"){
				var row = {groupId: groupId, objId: objId, FLAG: 'D'}
				list.push(row);
			}
		});
		
		console.log(list);
		
		$.ajax({
			data: JSON.stringify(list),
			url: "./registerMappingTable.ino",
			datatype: "json",
			async: false,
			contentType: "application/json; charset=UTF-8",  
			type: "POST",
			transactional: true,
			success: function(re){
				if (re){
					alert("저장되었습니다.");
				}
			},
			error: function(request, status, error){
				console.log(status);
				console.log(error);
			}
		});
	});
	
});
</script>

</head>
<body>

	<div>
		<h1>권한 설정</h1>
	</div>
	<input type="hidden" id="code" value="${ code }"/>
	<div style="width: 700px;" align="right">
		<button id="registerBtn" name="registerBtn">등록</button>
	</div>
	<hr style="width: 600px;">
	<div style="padding-bottom: 10px;">
		<table border="1">
			<thead>
				<tr>
					<td style="width: 20px;" align="center"></td>
					<td style="width: 100px;" align="center">OBJID</td>
					<td style="width: 180px;" align="center">OBJNAME</td>
					<td style="width: 180px;" align="center">DEPT</td>
					<td style="width: 100px;" align="center">사용여부</td>
				</tr>
			</thead>
		</table>
	</div>
	<hr style="width: 600px;">

	<div id="authorityDiv">
		<input type="hidden" id="groupId" name="groupId" value="${ groupId }"/>
		<table border="1">
			<tbody>			
				<c:forEach var="nRow" items="${ objectList }">
					<tr>
						<c:if test="${ nRow.useYn == '사용중' }">
							<td style="width: 20px;" align="center"><input type="checkbox" name="objCheck" checked="checked"/></td>
						</c:if>
						<c:if test="${ nRow.useYn == '미사용' }">
							<td style="width: 20px;" align="center"><input type="checkbox" name="objCheck"/></td>
						</c:if>
						<td style="width: 100px;" align="center" class="objId">${ nRow.objId }</td>
						<td style="width: 180px;" align="center" class="objName">${ nRow.objName }</td>
						<td style="width: 180px;" align="center" class="dept">${ nRow.dept }</td>
						<td style="width: 100px;" align="center" class="useYn">${ nRow.useYn }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
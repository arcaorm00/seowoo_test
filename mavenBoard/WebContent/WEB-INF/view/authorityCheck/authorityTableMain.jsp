<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 15% auto; /* 15% from the top and centered */
    padding: 20px;
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* The Close Button */
#close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
    margin-right: 15px;
}

#close:hover,
#close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
} 

/* Modal Header */
.modal-header {
    padding: 2px 16px;
    background-color: #5cb85c;
    color: white;
}

/* Modal Body */
.modal-body {padding: 10px 16px 50px;}

/* Modal Footer */
.modal-footer {
    padding: 2px 16px;
    background-color: #dedede;
    color: white;
}

/* Modal Content */
.modal-content {
    position: relative;
    background-color: #fefefe;
    padding: 0;
    border: 1px solid #888;
    width: 80%;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
    -webkit-animation-name: animatetop;
    -webkit-animation-duration: 0.4s;
    animation-name: animatetop;
    animation-duration: 0.4s
}

/* Add Animation */
@-webkit-keyframes animatetop {
    from {top: -300px; opacity: 0}
    to {top: 0; opacity: 1}
}

@keyframes animatetop {
    from {top: -300px; opacity: 0}
    to {top: 0; opacity: 1}
}
</style>
<script src="https://code.jquery.com/jquery-2.2.1.js"></script>
<script type="text/javascript">

var groupId = null;
var groupName = null;
var groupUseYn = null;

function showModel(id, name, useyn){
	
	console.log(id);
	groupId = id;
	groupName = name;
	groupUseYn = useyn;
	
	drawTable(groupId);
	
	$("#myModal").css("display", "block");
}

function changeRowColor(checkBox){
	var tr = $(checkBox).parents("tr");
	(checkBox.checked) ? tr.css("background", "#f0f0f0") : tr.css("background", "white");
}

function drawTable(groupId){
	$.ajax({
		data: {groupId: groupId},
		url: "./authorityDetail.ino",
		success: function(res){
			$("#authorityTbody").empty();
			for (var i = 0 ; i < res.length ; i++){
				var nRow = res[i];

				var tr = $("<tr></tr>");
				var checkBox = null;
				if (nRow.useYn == '사용중'){
					checkBox = $("<td style='width: 20px;' align='center'><input type='checkbox' name='objCheck' onClick='changeRowColor(this);' checked='checked'/></td>");
				}else{
					checkBox = $("<td style='width: 20px;' align='center'><input type='checkbox' onClick='changeRowColor(this);' name='objCheck'/></td>");
				}
				var objId = $("<td style='width: 160px;' align='center' class='objId'>" + nRow.objId + "</td>");
				var objName = $("<td style='width: 180px;' align='center' class='objName'>" + nRow.objName + "</td>");
				var dept = $("<td style='width: 100px;' align='center' class='dept'>" + nRow.dept + "</td>");
				var useYn = $("<td style='width: 120px;' align='center' class='useYn'>" + nRow.useYn + "</td>");

				tr.append(checkBox, objId, objName, dept, useYn);
				$("#authorityTbody").append(tr);
			}
		}
	});
}

$(function(){
	
	$("#close").click(function(){
		$("#myModal").css("display", "none");
	});
	
	$("#registerBtn").click(function(){
		var list = [];
		$("input[name=objCheck]").each(function(){
			var objId = $(this).parents("tr").children(".objId").text();
			var objName = $(this).parents("tr").children(".objName").text();
			var dept = $(this).parents("tr").children(".dept").text();
			
			if($(this).is(":checked") && $(this).parents("tr").children(".useYn").text() == "미사용"){
				var row = {groupId: groupId, groupName: groupName, useYn: groupUseYn, objId: objId, objName: objName, dept: dept, FLAG: 'I'}
				list.push(row);
			}else if(!$(this).is(":checked") && $(this).parents("tr").children(".useYn").text() == "사용중"){
				var row = {groupId: groupId, groupName: groupName, useYn: groupUseYn, objId: objId, objName: objName, dept: dept, FLAG: 'D'}
				list.push(row);
			}
		});
		
		if (list.length == 0){
			alert("수정된 정보가 없습니다.");
		}else{
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
					}else{
						alert("예기치 못한 오류로 권한이 저장되지 못 했습니다.");
					}
					drawTable(groupId);
				},
				error: function(request, status, error){
					console.log(status);
					console.log(error);
				}
			});
		}
	});
	
});
</script>
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
					<td style="width: 100px;"><a href="#" onClick="showModel('${nRow.groupId}', '${ nRow.groupName }', '${ nRow.useYn }');">${ nRow.groupName }</a></td>
					<td style="width: 100px;">${ nRow.useYn }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- The Modal -->
	<div id="myModal" class="modal">
		<!-- Modal content -->
		
		<div class="modal-content">
		<span id="close">×</span>
		  <div class="modal-header">
		    
		    <h2>객체 목록</h2>
		  </div>
		  <div class="modal-body">
		  
		    <input type="hidden" id="code" value="${ code }"/>
			<div style="padding-bottom: 10px;">
				<table style="background: #dedede;">
					<thead>
						<tr>
							<td style="width: 20px;" align="center"></td>
							<td style="width: 160px;" align="center">OBJID</td>
							<td style="width: 180px;" align="center">OBJNAME</td>
							<td style="width: 100px;" align="center">DEPT</td>
							<td style="width: 120px;" align="center">사용여부</td>
						</tr>
					</thead>
				</table>
			</div>
		
			<div id="authorityDiv">
				<table>
					<tbody id="authorityTbody">			
						
					</tbody>
				</table>
			</div>
		  </div>
		  
		  <div class="modal-footer">
		    <h3 id="registerBtn" style="cursor: pointer;">[ 저장 ]</h3>
		  </div>
		</div>	
	</div>

</body>
</html>
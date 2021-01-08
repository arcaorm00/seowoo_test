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
	var code = $("#code").val();
	var round = 0;
	
	$("#addBtn").click(function(){
		$("#insertBtn").attr("disabled", false);
		if (round < 3){
			var tr = $("<tr></tr>");
			var mastercodeTd = $("<td style='width: 100px;' align='center'></td>").html(code);
			var detailcodeTd = $("<td style='width: 180px;' align='center'><input type='text' width='100%' id='detailcodeTd"+round+"'/></td>");
			var codenameTd = $("<td style='width: 180px;' align='center'><input type='text' width='100%' id='codenameTd"+round+"'/></td>");
			var useynTd = $("<td style='width: 100px;' align='center'><input type='radio' name='useYnRadio"+round+"' value='Y'/>Y<input type='radio' name='useYnRadio"+round+"' value='N'/>N</td>");
			tr.append(mastercodeTd, detailcodeTd, codenameTd, useynTd);
			$("#codeTable").append(tr);
			round += 1;
		}else{
			alert("한번에 입력할 수 있는 코드는 최대 3개입니다.");
		}
	});
	
	var confirmed = false;
	$("#insertBtn").click(function(){
		var codeList = [];
		var duplicated = "";
		confirmed = false;

		for(var i = 0; i < round; i++){
			var detailcode = $("#detailcodeTd"+i).val().trim();
			var codename = $("#codenameTd"+i).val().trim();
			var useyn = $("input[name=useYnRadio"+i+"]:checked").val();
			
			// 입력 확인
			if(detailcode == "" && codename == "" && useyn == undefined){
				continue;
			}
			if(detailcode == "" || codename == "" || useyn == undefined){
				alert("입력이 완료되지 않은 행이 있습니다.");
				return;
			}
			if(detailcode == duplicated){
				alert("세부 코드에 중복되는 값을 입력했습니다.");
				return;
			}
			
			duplicated = detailcode;
			
			var row = {CODE: code, DECODE: detailcode, DECODE_NAME: codename, USE_YN: useyn};
			codeList.push(row);
		}
		console.log(codeList);
		var list = {'codeList': JSON.stringify(codeList)};
		
		// 중복 확인
		$.ajax({
			data: list,
			url: "./detailCodeIsExist.ino",
			async: false,
			success: function(re){
				confirmed = false;
				if(re > 0){
					alert("세부 코드는 중복될 수 없습니다.\n다시 한번 확인해주시기 바랍니다.");
					return false;
				}else{
					confirmed = true;
				}
			},
			error: function(request, status, error){
				console.log(status);
				console.log(error);
			}
		});
		
		console.log(list);
		console.log("confirmed:: " + confirmed);
		
		if(confirmed){
			
			$.ajax({
				data: list,
				url: "./insertDetailCode.ino",
				success: function(re){
					if(re){
						alert("코드가 정상적으로 등록되었습니다.");
						location.reload();
					}else{
						alert("예기치 못한 오류로 코드가 등록되지 못 했습니다.");
					}
				},
				error: function(request, status, error){
					console.log(status);
					console.log(error);
				}
			});
		}
		
	});

});

function isReduplicate(list){
	// 중복 확인
	$.ajax({
		data: list,
		url: "./detailCodeIsExist.ino",
		async: false,
		success: function(re){
			confirmed = false;
			if(re > 0){
				alert("세부 코드는 중복될 수 없습니다.\n다시 한번 확인해주시기 바랍니다.");
				return false;
			}else{
				confirmed = true;
			}
		},
		error: function(request, status, error){
			console.log(status);
			console.log(error);
		}
	});
}
</script>
</head>
<body>

	<div id="bodyAll" align="center" style="width: 800px;">
		<div class="contents" style="width: 800px; margin: 0;">
			 <section>
                <div style="background-color:#dedede; height:700px; padding: 20px;">
				
					<div>
						<h1>세부 코드 등록</h1>
					</div>
					<input type="hidden" id="code" value="${ code }"/>
					<div style="width:650px;" align="right">
						<button id="addBtn" name="addBtn">추가</button>
						<button id="insertBtn" name="insertBtn">등록</button>
					</div>
					<hr style="width: 600px;">
					<div style="padding-bottom: 10px;">
						<table border="1">
							<thead>
								<tr>
									<td style="width: 100px;" align="center">기준 코드</td>
									<td style="width: 180px;" align="center">세부 코드</td>
									<td style="width: 180px;" align="center">코드 이름</td>
									<td style="width: 100px;" align="center">사용여부</td>
								</tr>
							</thead>
						</table>
					</div>
					<hr style="width: 600px;">
				
					<div id="boardDiv">
						<table id="codeTable" border="1">
							<tbody>
								<c:forEach var="nRow" items="${ list }">
									<tr>
										<td style="width: 100px;" align="center">${ nRow.CODE }</td>
										<td style="width: 180px;" align="center">${ nRow.DECODE }</td>
										<td style="width: 180px;" align="center">${ nRow.DECODE_NAME }</td>
										<td style="width: 100px;" align="center">${ nRow.USE_YN }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
		
				 </div>
	        </section>
		</div>
	</div>
	
	
</body>
</html>
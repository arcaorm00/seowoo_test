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
			var form = $("<form name='codeForm'  onsubmit='return false'></form>");
			var flag = $("<input type='hidden' name='FLAG' value='I'/>");
			var checkbox = $("<input type='checkbox' name='codeCheck' disabled='disabled'/>");
			var mastercode = $("<input type='text' style='width: 100px; margin-left: 6px;' name='CODE' value='"+code+"'/>");
			var detailcode = $("<input type='text' style='width: 170px; margin-left: 6px;' name='DECODE'/>");
			var decodename = $("<input type='text' style='width: 170px; margin-left: 6px;' name='DECODE_NAME'/>");
			var useyn = $("<span style='display: inline-block; width: 100px; margin-left: 15px;'><input type='radio' name='USE_YN' value='Y'/>Y<input type='radio' name='USE_YN' value='N'/>N</span>");
			form.append(flag, checkbox, mastercode, detailcode, decodename, useyn);
			$("#codeBoard").append(form);
			round += 1;
		}else{
			alert("한번에 입력할 수 있는 코드는 최대 3개입니다.");
		}
	});
	
	$("#updateBtn").click(function(){
		$("input[name='codeCheck']:checked").parent().each(function(idx, row){
			var decodename = row[3];
			var useYn = row[4];
			
			decodename.disabled = false;
			useYn.disabled = false;
		});
	});
	
	var confirmed = false;
	$("#registerBtn").click(function(){
		var codeList = [];
		var duplicated = "";
		confirmed = false;
		
		//var trs = $("input[name='codeCheck']:checked").parents("tr");
		var formData = $("form[name='codeForm']").serializeObject();
		
		/*
		for(var i = 0; i < round; i++){
			var detailcode = $("#detailcode"+i).val().trim();
			var decodename = $("#decodename"+i).val().trim();
			var useyn = $("input[name=useYnRadio"+i+"]:checked").val();
			
			// 입력 확인
			if(detailcode == "" && decodename == "" && useyn == undefined){
				continue;
			}
			if(detailcode == "" || decodename == "" || useyn == undefined){
				alert("입력이 완료되지 않은 행이 있습니다.");
				return;
			}
			if(detailcode == duplicated){
				alert("세부 코드에 중복되는 값을 입력했습니다.");
				return;
			}
			
			duplicated = detailcode;
			
			var row = {CODE: code, DECODE: detailcode, DECODE_NAME: decodename, USE_YN: useyn};
			codeList.push(row);
		}
		*/

		console.log(codeList);
		var list = JSON.stringify(codeList);
		
		// 중복 확인
		$.ajax({
			data: list,
			url: "./detailCodeIsExist.ino",
			async: false,
			datatype: "json",
			contentType: "application/json; charset=UTF-8",  
			type: "POST",
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
		
		console.log("----------- list ------------");
		console.log(list);
		console.log("confirmed:: " + confirmed);
		
		if(confirmed){
			
			$.ajax({
				data: list,
				url: "./registerDetailCode.ino",
				datatype: "json",
				contentType: "application/json; charset=UTF-8",  
				type: "POST",
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

var list = [];

$.fn.serializeObject = function() {
    var obj = null;
    console.log(this);
    try {
    	
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
            console.log(arr);
            if (arr) {
            	obj = {};
                $.each(arr, function(idx, input) {
					obj[this.name] = this.value;
                });
            }
        }
    } catch (e) {
        alert(e.message);
    } finally {
    }
    console.log(obj);
    return obj;
};


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
						<button id="updateBtn" name="updateBtn">수정</button>
						<button id="registerBtn" name="registerBtn">등록</button>
					</div>
					<hr style="width: 600px;">
					<div style="padding-bottom: 10px;">
						<table border="1">
							<thead>
								<tr>
									<td style="width: 20px;" align="center"></td>
									<td style="width: 100px;" align="center">기준 코드</td>
									<td style="width: 180px;" align="center">세부 코드</td>
									<td style="width: 180px;" align="center">코드 이름</td>
									<td style="width: 100px;" align="center">사용여부</td>
								</tr>
							</thead>
						</table>
					</div>
					<hr style="width: 600px;">
				
					<div id="codeBoard">
						<c:forEach var="nRow" items="${ list }">
							<form name="codeForm"  onsubmit="return false">
								<input type="checkbox" name="codeCheck" value="${ nRow.DECODE }"/>
								<input type='text' style='width: 100px;' name='CODE' value="${ nRow.CODE }" disabled="disabled"/>
								<input type='text' style='width: 170px;' name='DECODE' value="${ nRow.DECODE }" disabled="disabled"/>
								<input type='text' style='width: 170px;' name='DECODE_NAME' value="${ nRow.DECODE_NAME }" disabled="disabled"/>
								<input type='text' style='width: 100px;' name='USE_YN' value="${ nRow.USE_YN }" disabled="disabled"/>
							</form>
						</c:forEach>
					</div>
		
				 </div>
	        </section>
		</div>
	</div>
	
	
</body>
</html>
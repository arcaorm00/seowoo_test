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
	
	// 추가
	$("#addBtn").click(function(){
		$("#registerBtn").attr("disabled", false);
		if (round < 3){
			var form = $("<form name='codeForm'  onsubmit='return false'></form>");
			var flag = $("<input type='hidden' name='FLAG' value='I'/>");
			var checkbox = $("<input type='checkbox' name='codeCheck' disabled='disabled' checked/>");
			var mastercode = $("<input type='text' style='width: 100px; margin-left: 6px;' name='CODE' value='"+code+"' readonly/>");
			var detailcode = $("<input type='text' style='width: 170px; margin-left: 6px;' name='DECODE'/>");
			var decodename = $("<input type='text' style='width: 170px; margin-left: 6px;' name='DECODE_NAME'/>");
			var useyn = $("<span style='display: inline-block; width: 100px; margin-left: 11px; margin-right: 9px;'>"
			+"<input type='radio' name='USE_YN' value='Y'/>Y<input type='radio' name='USE_YN' value='N'/>N</span>");
			form.append(flag, checkbox, mastercode, detailcode, decodename, useyn);
			$("#codeBoard").append(form);
			round += 1;
		}else{
			alert("한번에 입력할 수 있는 코드는 최대 3개입니다.");
		}
	});
	
	// 수정
	$("#updateBtn").click(function(){
		$("input[name='codeCheck']:checked").parent().each(function(){
			if($(this).children("input[name='FLAG']").val() == "I" || $(this).children("input[name='FLAG']").val() == "D"){
				return;
			}
			var decodename = $(this).children("input[name='DECODE_NAME']");
			var useyn = $(this).find("input[name='USE_YN']");
			
			/*
			var useynValue = null;
			if ($(this).children("span").length <= 0){
				console.log(useyn.val());
				useynValue = useyn.val();
			}else{
				// 해결은 했는데 왜 $(this).children("input[name='USE_YN']:checked").val()은 undefined인지 이해 못함
				console.log($(this).children("span").children("input[name='USE_YN']:checked").val());		
				useynValue = $(this).children("span").children("input[name='USE_YN']:checked").val();
			}
			
			var newUseYn = null;
			if (useynValue == "Y"){
				newUseYn = $("<span style='display: inline-block; width: 100px; margin-right: 8px;'><input type='radio' name='USE_YN' value='Y' checked/>Y<input type='radio' name='USE_YN' value='N'/>N</span>");
			}else if (useynValue == "N"){
				newUseYn = $("<span style='display: inline-block; width: 100px; margin-right: 8px;'><input type='radio' name='USE_YN' value='Y'/>Y<input type='radio' name='USE_YN' value='N' checked/>N</span>");
			}
			
			useyn.remove();
			$(this).children("span").remove();
			$(this).append(newUseYn);
			*/
			
			var flag = $("<input type='hidden' name='FLAG' value='U'/>");
			if ($(this).children("input[name='FLAG']").length <= 0){
				$(this).append(flag);
			}

			decodename.attr("disabled", false);
			useyn.attr("disabled", false);
			$("#registerBtn").attr("disabled", false);
		});
	});
	
	// 삭제
	$("#deleteBtn").click(function(){
		$("input[name='codeCheck']:checked").parent().each(function(){
			if($(this).children("input[name='FLAG']").length > 0){
				return;
			}
			$(this).find("input[name='FLAG']").remove();
			var flag = $("<input type='hidden' name='FLAG' value='D'/>");
			$(this).append(flag);
			$(this).children().css("text-decoration", "line-through");
			$("#registerBtn").attr("disabled", false);
		});
	});
	
	
	var confirmed = false;
	$("#registerBtn").click(function(){
		var codeList = [];
		var duplicated = "";
		var msg = "";
		var cnt = $("input[name='codeCheck']:checked").parent().length;
		confirmed = false;
		
		//$("form[name='codeForm']").each(function(){
		$("input[name='codeCheck']:checked").parent().each(function(){
			
			var detailcode = $(this).children("input[name='DECODE']").val().trim();
			var decodename = $(this).children("input[name='DECODE_NAME']").val().trim();
			var useyn = $(this).find("input[name='USE_YN']:checked").val();
			
			$(this).children("input[name='CODE']").attr("disabled", false);
			$(this).children("input[name='DECODE']").attr("disabled", false);
			
			console.log(detailcode + "/" + decodename + "/" + useyn);
			
			// 입력 확인
			if(detailcode == "" || decodename == "" || useyn == undefined){
				msg = "입력이 완료되지 않은 행이 있습니다.";
				confirmed = false;
			}else if(detailcode == duplicated){
				msg = "세부 코드에 중복되는 값을 입력했습니다.";
				confirmed = false;
			}else {
				cnt -= 1;
			}
			
			duplicated = detailcode;
			
			var formData = $(this).serializeObject();
			codeList.push(formData);
			
			if ($(this).children("input[name='FLAG']").val() != "I"){
				$(this).children("input[name='CODE']").attr("disabled", true);
				$(this).children("input[name='DECODE']").attr("disabled", true);
			}
			
		});
		
		if (cnt == 0){
			confirmed = true;
		}
		
		if (confirmed){
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
					transactional: true,
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
		}else{
			alert(msg);
		}
		
	});

});

var list = [];

$.fn.serializeObject = function() {
    var obj = null;
    try {
    	
        if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
            var arr = this.serializeArray();
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
    return obj;
};


</script>
</head>
<body>

	<div id="bodyAll" align="center" style="width: 800px;">
		<div class="contents" style="width: 800px; margin: 0;">
               <div style="background-color:#dedede; height:700px; padding: 20px;">
			
				<div>
					<h1>세부 코드 등록</h1>
				</div>
				<input type="hidden" id="code" value="${ code }"/>
				<div style="width:650px;" align="right">
					<button id="addBtn" name="addBtn">추가</button>
					<button id="updateBtn" name="updateBtn">수정</button>
					<button id="deleteBtn" name="deleteBtn">삭제</button>
					<button id="registerBtn" name="registerBtn" disabled>등록</button>
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
						<form name="codeForm" onsubmit="return false">
							<input type="checkbox" name="codeCheck" value="${ nRow.DECODE }"/>
							<input type='text' style='width: 100px;' name='CODE' value="${ nRow.CODE }" disabled="disabled"/>
							<input type='text' style='width: 170px;' name='DECODE' value="${ nRow.DECODE }" disabled="disabled"/>
							<input type='text' style='width: 170px;' name='DECODE_NAME' value="${ nRow.DECODE_NAME }" disabled="disabled"/>
							<!-- <input type='text' style='width: 100px;' name='USE_YN' value="${ nRow.USE_YN }" disabled="disabled"/>-->
							<span style='display: inline-block; width: 100px; margin-left: 6px; margin-right: 8px;'>
								<input type='radio' name='USE_YN' value='Y' <c:if test="${ nRow.USE_YN eq 'Y' }">checked</c:if> disabled="disabled"/>Y
								<input type='radio' name='USE_YN' value='N' <c:if test="${ nRow.USE_YN eq 'N' }">checked</c:if> disabled="disabled"/>N
							</span>
						</form>
					</c:forEach>
				</div>
	
			 </div>
		</div>
	</div>
	
	
</body>
</html>
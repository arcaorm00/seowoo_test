<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function resetForm(){
		$("#title").val("");
		$("#content").val("");
	}
	
	$(function(){
		
		$("#modifyBtn").click(function(e){
			
			e.preventDefault();
			
			var deleteBlank = / /gi;
			
			var title = $("#title").val().replace(deleteBlank, "");
			var content = $("#content").val().replace(deleteBlank, "");
			
			if ( title == "" || content == "" ){
				alert("제목이나 내용을 비워둘 수는 없습니다.");
				return;
			}
			
			var inputData = $("#modifyForm").serialize();
			
			$.ajax({
				data: inputData,
				type: "POST",
				url: "./freeBoardModifyPro.ino",
				success: function(data){
					var re = data.re;
					var num = data.num;
					var list = data.list;
					console.log(list);
					
					if(re > 0){
						alert("게시물이 수정되었습니다!");
						location.href="/mavenBoard/main.ino";
					}else{
						alert("게시물 수정에 실패했습니다!\n게시물 글자 수가 너무 많을 수 있습니다.");
					}
					//location.href="/mavenBoard/freeBoardDetail.ino?num="+num;
				}
			});
		});
		
	});
	
	
</script>
</head>
<body>

	<div>
		<h1>자유게시판</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./main.ino">리스트로</a>
	</div>
	<hr style="width: 600px">

	<form id="modifyForm" method="POST">
		
		<input type="hidden" name="num" value="${ freeBoardDto.NUM }"/>
		<table border="1">
			<tbody>
				<tr>
					<td style="width: 150px;" align="center">타입 :</td>
					<td style="width: 400px;">
						<select id="codeTypeSelect" name="codeType">
							<c:forEach var="nRow" items="${ writeTypeCodeList }">
								<option value="${ nRow.DECODE }" <c:if test="${ freeBoardDto.CODETYPE eq nRow.DECODE }">selected</c:if>>${ nRow.DECODE_NAME }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td style="width: 150px;"align="center">이름 :</td>
					<td style="width: 400px;"><input type="text" name="name" value="${ freeBoardDto.NAME }" readonly/></td>
				</tr>
				<tr>
					<td style="width: 150px;"align="center">제목 :</td>
					<td style="width: 400px;"><input type="text" id="title" name="title" value="${ freeBoardDto.TITLE }"/></td>
				</tr>
				<tr>
					<td style="width: 150px;"align="center">내용 :</td>
					<td style="width: 400px;"><textarea id="content" name="content" rows="25" cols="65" >${ freeBoardDto.CONTENT }</textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td align="right">
					<input type="submit" value="수정하기" id="modifyBtn">
					<input type="button" value="다시쓰기" onClick="resetForm();">
					<input type="button" value="취소" onclick="location.href='./main.ino'">
					&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</tfoot>
		</table>

	</form>
</body>
</html>
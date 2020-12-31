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
				alert("�����̳� ������ ����� ���� �����ϴ�.");
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
						alert("�Խù��� �����Ǿ����ϴ�!");
						location.href="/mavenBoard/main.ino";
					}else{
						alert("�Խù� ������ �����߽��ϴ�!\n�Խù� ���� ���� �ʹ� ���� �� �ֽ��ϴ�.");
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
		<h1>�����Խ���</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./main.ino">����Ʈ��</a>
	</div>
	<hr style="width: 600px">

	<form id="modifyForm" method="POST">
		
		<input type="hidden" name="num" value="${ freeBoardDto.NUM }"/>
		<table border="1">
			<tbody>
				<tr>
					<td style="width: 150px;" align="center">Ÿ�� :</td>
					<td style="width: 400px;">
						<select id="codeTypeSelect" name="codeType">
							<c:forEach var="nRow" items="${ writeTypeCodeList }">
								<option value="${ nRow.DECODE }" <c:if test="${ freeBoardDto.CODETYPE eq nRow.DECODE }">selected</c:if>>${ nRow.DECODE_NAME }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td style="width: 150px;"align="center">�̸� :</td>
					<td style="width: 400px;"><input type="text" name="name" value="${ freeBoardDto.NAME }" readonly/></td>
				</tr>
				<tr>
					<td style="width: 150px;"align="center">���� :</td>
					<td style="width: 400px;"><input type="text" id="title" name="title" value="${ freeBoardDto.TITLE }"/></td>
				</tr>
				<tr>
					<td style="width: 150px;"align="center">���� :</td>
					<td style="width: 400px;"><textarea id="content" name="content" rows="25" cols="65" >${ freeBoardDto.CONTENT }</textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td align="right">
					<input type="submit" value="�����ϱ�" id="modifyBtn">
					<input type="button" value="�ٽþ���" onClick="resetForm();">
					<input type="button" value="���" onclick="location.href='./main.ino'">
					&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</tfoot>
		</table>

	</form>
</body>
</html>
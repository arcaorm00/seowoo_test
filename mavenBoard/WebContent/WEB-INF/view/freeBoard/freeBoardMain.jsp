<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<script type="text/javascript">

	// 검색
	function searchFunction(page){
		
		var regExIsNumeric = /^[0-9]+$/;
		var deleteBlank = / /gi;

		var searchSelect = $("#searchSelect").val();
		var searchKeyword = $("#searchKeyword").val().replace(deleteBlank, "");
		
		if(searchSelect == 'DCOM001' && !searchKeyword.replace(regExIsNumeric, "") == ""){
			alert("검색어를 확인해주세요.\n글번호 검색은 숫자만 가능합니다.");
			return;
		}
		
		// 날짜 검색
		var regExIsDate = /[0-9]{4}\/[0-9]{2}\/[0-9]{2}/;
		var startDate = $("#startDate").val().replace(deleteBlank, "");
		var endDate = $("#endDate").val().replace(deleteBlank, "");
			
		if((startDate != "" && endDate != "") && (!regExIsDate.test(startDate) || !regExIsDate.test(endDate))){
			alert("날짜 입력 형식이 올바르지 않습니다.");
			return;
		}
		if((startDate != "" && endDate == "") || (startDate == "" && endDate != "")){
			alert("시작일과 종료일 중 하나를 비워둘 수는 없습니다.");
			return;
		}
		if(parseInt(startDate.replaceAll("/", "")) > parseInt(endDate.replaceAll("/", ""))){
			alert("종료일이 시작일보다 이전 날짜가 될 수는 없습니다.");
			return;
		}
		
		var startArr = startDate.split("/");
		var endArr = endDate.split("/");
		var startTypeDate = new Date(startArr[0], startArr[1]-1, startArr[2]);
		var endTypeDate = new Date(endArr[0], endArr[1]-1, endArr[2]);
		
		/*
		var twoYearsAgo = new Date();
		twoYearsAgo.setFullYear(twoYearsAgo.getFullYear() - 2);
		
		if(startTypeDate.getTime() < twoYearsAgo.getTime() || endTypeDate.getTime() < twoYearsAgo.getTime()){
			alert("기간 검색의 날짜는 최대 2년 전까지만 입력할 수 있습니다.");
			return;
		}
		*/
		
		startTypeDate.setMonth(startTypeDate.getMonth() + 1);
		if(startTypeDate.getTime() < endTypeDate.getTime()){
			alert("시작일과 종료일의 날짜 간격은 최대 한달까지 가능합니다.");
			return;
		}
		
		var searchJson = {searchField: searchSelect, keyword: searchKeyword, startDate: startDate, endDate: endDate, page: page};
		console.log(searchJson);
		
		$.ajax({
			data: searchJson,
			contentType: 'application/json;charset=UTF-8',
			url: "./mainSearch.ino",
			success: function(data){
				console.log(data);
				var list = data.list;
				var pagination = data.page;
				
				console.log(pagination);

				$("#boardTable").empty();
				
				var tbody = $("<tbody></tbody>");
				
				if(list.length > 0){
					for (var i = 0; i < list.length; i++) {
						var board = list[i];
						var tr = $("<tr></tr>");
						var type = $("<td style='width: 55px; padding-left: 30px;' align='center'></td>").html(board.codeType);
						var num = $("<td style='width: 50px; padding-left: 10px;' align='center'></td>").html(board.num);
						var link = $("<a href='./freeBoardDetail.ino?num="+board.num+"'></a>").text(board.title);
						var title = $("<td style='width: 125px;' align='left'></td>");
						title.append(link);
						var name = $("<td style='width: 48px; padding-left: 50px;' align='center'></td>").html(board.name);
						var regdate = $("<td style='width: 100px; padding-left: 95px;' align='center'></td>").html(board.regdate);
						tr.append(type, num, title, name, regdate);
						tbody.append(tr);
					}
				}else{
					var h4 = $("<h4 style='padding: 20px'></h4>").html("검색어에 해당하는 결과가 존재하지 않습니다.");
					var button = $("<button>목록으로</button>").attr("onClick", "location.href='./main.ino'");
					tbody.append(h4, button);
				}
				
				$("#boardTable").append(tbody);
				searchPagination(pagination);
				history.pushState('', null, '?searchField=' + searchSelect + "&keyword=" + searchKeyword + "&startDate=" + startDate + "&endDate=" + endDate + "&page=" + page);
			},
			error: function(request, status, error){
				console.log(status);
				console.log(error);
			}
		});	
	}
	
	// 페이징
	function searchPagination(page){
		
		$("#paginationDiv").empty();
		
		var alpha = $("<span><a href='#' onClick='searchFunction(1);'>[처음]</a></span>");
		var prev = $("<span><a href='#' onClick='searchFunction(" + page.prevPage + ");'>[이전]</a></span>");
		var next = $("<span><a href='#' onClick='searchFunction(" + page.nextPage +");'>[다음]</a></span>");
		var omega = $("<span><a href='#' onClick='searchFunction(" + page.totalPage +");'>[끝]</a></span>");
		// var alpha = $("<span><a href='./main.ino?page=1'>[처음]</a></span>");
		// var prev = $("<span><a href='./main.ino?page=" + page.prevPage + "'>[이전]</a></span>");
		// var next = $("<span><a href='./main.ino?page=" + page.nextPage + "'>[다음]</a></span>");
		// var omega = $("<span><a href='./main.ino?page=" + page.totalBlock + "'>[끝]</a></span>");
		
		if(page.currentPage != 1){
			$("#paginationDiv").append(alpha, prev);
		}
		
		for (var pageNum = page.startBlock; pageNum <= page.endBlock; pageNum++){
			var span;
			if (pageNum == page.currentPage){
				span = $("<span style='color: red;'>" + pageNum + " </span>");
			}else{
				span = $("<span><a href='#' onClick='searchFunction(" + pageNum + ");'>" + pageNum + "</a> </span>");
			}
			$("#paginationDiv").append(span);
		}
		
		if(page.currentPage != page.totalPage && page.totalPage > 0){
			$("#paginationDiv").append(next);
		}
		if(page.currentPage != page.totalPage && page.totalPage > 0){
			$("#paginationDiv").append(omega);
		}
	}
	
	function textAutocomplete(event, date){
		var len = date.value.length;

		if(len == 4){ date.value += "/"; }
		if(len == 7){ date.value += "/"; }
		if(len == 9){ $("#endDate").focus(); }
	}
	
	$(function(){
		
		$("#searchKeyword").keypress(function(event){
			if(event.keyCode == 13){
				searchFunction(1);
			}
		})
	})
</script>
</head>
<body>

	<div>
		<h1>자유게시판</h1>
	</div>
	
	<div>
		<select id="searchSelect">
			<option value="">전체보기</option>
			<c:forEach var="nRow" items="${ searchList }">
				<option value="${ nRow.DECODE }" <c:if test="${ searchField eq nRow.DECODE }">selected</c:if>>${ nRow.DECODE_NAME }</option>
			</c:forEach>
		</select>
		<select id="yearSelect">
			<c:forEach var="nRow" items="${ yearList }">
				<option value="${ nRow.DECODE }" <c:if test="${ searchField eq nRow.DECODE }">selected</c:if>>${ nRow.DECODE_NAME }</option>
			</c:forEach>
		</select>
		<input type="text" id="searchKeyword" value="${ keyword }"/>
		<button type="button" id="searchBtn" name="searchBtn" onClick="searchFunction(1);">검색</button>
	</div>
	
	<div>
		시작일 : <input type="text" id="startDate" name="startDate" maxlength="10" 
				onkeypress="textAutocomplete(event, this);" value="${ startDate }" placeholder="0000/00/00"/> ~ 
		종료일 : <input type="text" id="endDate" name="endDate" maxlength="10" 
				onkeypress="textAutocomplete(event, this);" value="${ endDate }" placeholder="0000/00/00"/>
	</div>
	
	<div style="width:650px;" align="right">
		<a href="./freeBoardInsert.ino">글쓰기</a>
	</div>
	<hr style="width: 600px;">
	<div style="padding-bottom: 10px;">
		<table border="1">
			<thead>
				<tr>
					<td style="width: 55px; padding-left: 30px;" align="center">타입</td>
					<td style="width: 50px; padding-left: 10px;" align="center">글번호</td>
					<td style="width: 125px;" align="center">글제목</td>
					<td style="width: 48px; padding-left: 50px;" align="center">글쓴이</td>
					<td style="width: 100px; padding-left: 95px;" align="center">작성일시</td>
				</tr>
			</thead>
		</table>
	</div>
	<hr style="width: 600px;">

	<div id="boardDiv">
		<table id="boardTable" border="1">
			<tbody>
					<c:forEach var="dto" items="${ freeBoardList }">
					<tr>
						<td style="width: 55px; padding-left: 30px;" align="center">${ dto.codeType }</td>
						<td style="width: 50px; padding-left: 10px;" align="center">${ dto.num }</td>
						<td style="width: 125px;" align="left"><a href="./freeBoardDetail.ino?num=${ dto.num }">${ dto.title }</a></td>
						<td style="width: 48px; padding-left: 50px;" align="center">${ dto.name }</td>
						<td style="width: 100px; padding-left: 95px;" align="center">${ dto.regdate }</td>
					<tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
	
	<br>
	
	<div id="paginationDiv">
		<c:if test="${ pagination.currentPage != 1 }">
			<span><a href="#" onClick="searchFunction(1);">[처음]</a></span>
		</c:if>
		<c:if test="${ pagination.currentPage != 1 }">
			<span><a href="#" onClick="searchFunction(${ pagination.prevPage });">[이전]</a></span>
		</c:if>
		
		<c:forEach var="pageNum" begin="${ pagination.startBlock }" end="${ pagination.endBlock }">
			<c:choose>
				<c:when test="${ pageNum == pagination.currentPage }">
					<span style="color: red;">${ pageNum }</span>
				</c:when>
				<c:otherwise>
					<span><a href="#" onClick="searchFunction(${ pageNum });">${ pageNum }</a></span>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${ pagination.currentPage != pagination.totalPage && pagination.totalPage > 0 }">
			<span><a href="#" onClick="searchFunction(${ pagination.nextPage });">[다음]</a></span>
		</c:if>
		<c:if test="${ pagination.currentPage != pagination.totalBlock && pagination.totalBlock > 0 }">
			<span><a href="#" onClick="searchFunction(${ pagination.totalBlock });">[끝]</a></span>
		</c:if>
	</div>

</body>
</html>
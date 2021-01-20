<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
function redrawBoard(page){
	var searchField = $("#searchOption").val();
	var keyword = $("#keyword").val();
	console.log(searchField + "/" + keyword);
	
	var regExpBlank = / /gi;
	var regExpNumeric = /^[0-9]+$/;
	if (searchField == "num" && !keyword.replace(regExpBlank, "").replace(regExpNumeric, "") == ""){
		alert("글번호 검색은 숫자만 가능합니다.");
		return;
	}
	
	$.ajax({
		data: {searchField: searchField, keyword: keyword, page: page},
		url: "./mainSearch.ino",
		success: function(res){
			console.log(res);
			var list = res.list;
			var pagination = res.pagination;
			
			$("tbody").empty();
			
			if (list.length > 0){
				for (var i = 0 ; i < list.length ; i++){
					var tr = $("<tr></tr>");
					var board = list[i];
					var codetype = $("<td width='50px;' align='center'></td>").html(board.CODETYPE);
					var num = $("<td width='50px;' align='center'></td>").html(board.NUM);
					var title = $("<td width='200px;'></td>");
					var anchor = $("<a href='./detailFreeBoard.ino?num="+ board.NUM +"'></a>").html(board.TITLE);
					var name = $("<td width='100px;'></td>").html(board.NAME);
					var regdate = $("<td width='130px;'></td>").html(board.REGDATE);
					title.append(anchor);
					tr.append(codetype, num, title, name, regdate);
					$("tbody").append(tr);
				}
			}else{
				var notice = $("<h4>검색어에 해당하는 게시물이 존재하지 않습니다.</h4>");
				var button = $("<button>목록으로</button>").attr("onClick", "location.href='./main.ino'");
				$("tbody").append(notice, button);
			}
			
			redrawPagination(pagination);
		}
	});
}

function redrawPagination(pagination){
	$("#divForPagination").empty();
	var alpha = $("<a href='#' onClick='redrawBoard(1);'>[처음]</a>");
	var prev = $("<a href='#' onClick='redrawBoard(" + pagination.prevPage + ");'>[이전]</a>");
	var next = $("<a href='#' onClick='redrawBoard(" + pagination.nextPage + ");'>[다음]</a>");
	var omega = $("<a href='#' onClick='redrawBoard(" + pagination.totalBlock + ");'>[끝]</a>");
	
	
	if(pagination.currentPage != 1){
		$("#divForPagination").append(alpha, prev);
	}
	
	for (var pageNum = pagination.startBlock ; pageNum <= pagination.endBlock ; pageNum++){
		var page;
		if (pageNum == pagination.currentPage){
			page = $("<span style='color: red'>" + pageNum + "&nbsp;</span>");
		}else{
			page = $("<span><a href='#' onClick='redrawBoard(" + pageNum + ");'>" + pageNum + "</a>&nbsp;</span>");
		}
		$("#divForPagination").append(page);
	}
	
	if ( pagination.currentPage < pagination.totalBlock ){
		$("#divForPagination").append(next, omega);
	}
}

$(function(){

});
</script>
</head>
<body>

<h2>자유 게시판</h2>

<div style="float: right; margin-right: 50px;">
	<button onClick="location.href='./insertFreeBoard.ino'">글쓰기</button>
</div>
<div id="divForSearch">
	<select id="searchOption">
		<option value="">전체보기</option>
		<option value="num">글번호</option>
		<option value="title">글제목</option>
	</select>
	<input type="text" id="keyword" name="keyword" value=""/>
	<button id="searchBtn" onClick="redrawBoard(1);">검색</button>
</div>
<br/>
<table border="1">
	<thead>
		<tr>
			<th width="50px;">타입</th>
			<th width="50px;">글번호</th>
			<th width="200px;">글제목</th>
			<th width="100px;">글쓴이</th>
			<th width="130px;">작성날짜</th>
		</tr>
	</thead>
</table>

<table border="1">
	<tbody>
	<c:forEach items="${ list }" var="board">
		<tr>
			<td width="50px;" align="center">${ board.CODETYPE }</td>
			<td width="50px;" align="center">${ board.NUM }</td>
			<td width="200px;"><a href="./detailFreeBoard.ino?num=${ board.NUM }">${ board.TITLE }</a></td>
			<td width="100px;">${ board.NAME }</td>
			<td width="130px;">${ board.REGDATE }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<br/>
<div id="divForPagination">
	<c:if test="${ pagination.currentPage != 1 }">
		<a href="#" onClick="redrawBoard(1);">[처음]</a>
		<a href="#" onClick="redrawBoard(${ pagination.prevPage });">[이전]</a>
	</c:if>
	<c:forEach var="pageNum" begin="${ pagination.startBlock }" end="${ pagination.endBlock }" >
		<c:choose>
			<c:when test="${ pageNum == pagination.currentPage }">
				<span style="color: red;">${ pageNum }</span>
			</c:when>
			<c:otherwise>
				<span><a href="#" onClick="redrawBoard(${ pageNum });">${ pageNum }</a></span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${ pagination.currentPage < pagination.totalBlock }">
		<a href="#" onClick="redrawBoard(${ pagination.nextPage });">[다음]</a>
		<a href="#" onClick="redrawBoard(${ pagination.totalBlock });">[끝]</a>
	</c:if>
</div>

</body>
</html>
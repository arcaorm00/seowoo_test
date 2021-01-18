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
	
	$.ajax({
		data: {searchField: searchField, keyword: keyword},
		url: "./mainSearch.ino",
		success: function(res){
			console.log(res);
		}
	});
}
$(function(){
	$("#searchBtn").click(function(){
		
	});
});
</script>
</head>
<body>

<h2>자유 게시판</h2>

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
			<th width="100px;">타입</th>
			<th width="50px;">글번호</th>
			<th width="200px;">글제목</th>
			<th width="100px;">글쓴이</th>
			<th width="100px;">작성날짜</th>
		</tr>
	</thead>
</table>

<table border="1">
	<tbody>
	<c:forEach items="${ list }" var="board">
		<tr>
			<td width="100px;">${ board.CODETYPE }</td>
			<td width="50px;">${ board.NUM }</td>
			<td width="200px;">${ board.TITLE }</td>
			<td width="100px;">${ board.NAME }</td>
			<td width="100px;">${ board.REGDATE }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<br/>
<div id="divForPagination">
	<c:if test="${ pagination.currentPage != 1 }">
		<a href="#">[처음]</a>
		<a href="#">[이전]</a>
	</c:if>
	<c:forEach var="pageNum" begin="${ pagination.startBlock }" end="${ pagination.endBlock }" >
		<c:choose>
			<c:when test="${ pageNum == pagination.currentPage }">
				<span style="color: red;">${ pageNum }</span>
			</c:when>
			<c:otherwise>
				<span><a href="#" onClick="">${ pageNum }</a></span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${ pagination.currentPage < pagination.endBlock }">
		<a href="#">[다음]</a>
		<a href="#">[끝]</a>
	</c:if>
</div>

</body>
</html>
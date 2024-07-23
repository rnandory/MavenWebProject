<%@page import="jakarta.servlet.jsp.tagext.Tag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
		<h1>성적목록${name}</h1>
		<table>
			<caption>성적출력</caption>
			<thead>
				<tr>
					<th>이름</th>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>총점</td>
					<td>평균</td>
					<td>학점</td>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="exam" items="${list}">
					<tr>
						<th><a href="detail">${exam.name}</a></th>
						<td>${exam.kor}</td>
						<td>${exam.eng}</td>
						<td>${exam.math}</td>
						<td>${exam.total}</td>
						<td><fmt:formatNumber pattern="#.00" value="${exam.avg}" /></td>
						<td>${exam.grade}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</section>

	<div>${page}page</div>
	
	<nav id="pager">
		<ul>
			<li><a href="?p=1&c=빨  강&c=blue">1</a></li>
			<li><a href="?p=2&c=b  lue">2</a></li>
			<li><a href="?p=3&c=green">3</a></li>
			<li><a href="?p=4&c=red">4</a></li>
			<li><a href="?p=5&c=red">5</a></li>						
		</ul>
	</nav>

	<form>
		<fieldset>
			<legend>페이지 입력</legend>
			<label>page</label> <input name="p">
		</fieldset>
		<fieldset>
			<legend>좋아하는 색상</legend>
			<label>빨강<input type="checkbox" name="c" value="red"></label>
			<label>파랑<input type="checkbox" name="c" value="blue"></label>
		</fieldset>
		<div>
			<button>확인</button>	
		</div>
	</form>
	
	
	<section>
		<form method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>파일업로드</legend>
				<label>파일선택<input type="file" name="img" style="display:none;" multiple></label>
				<button>업로드</button>
			</fieldset>
		</form>
	</section>
	
	<section>
		<div>
			<img src="/javaprj/notice/upload/고창청보리밭.jpg">
		</div>
		<div>
			<a download href="/javaprj/notice/upload/고창청보리밭.jpg">다운로드</a>
		</div>
	</section>
</body>
</html>
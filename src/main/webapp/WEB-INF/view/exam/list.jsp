<%@page import="jakarta.servlet.jsp.tagext.Tag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
					<td>110</td>
					<td>36.67</td>
					<td>F</td>
				</tr>
			</c:forEach>
							
			</tbody>
		</table>
	</section>
	
	<div>1 page</div>
</body>
</html>
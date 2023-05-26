<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>수정폼</h1>

	<form action="/phonebook3/update" method="get">
		번호: <input type="text" name="person_id" value="${vo.person_id }">
		<br> 이름(name): <input type="text" name="name" value="${vo.name }">
		<br> 핸드폰(hp): <input type="text" name="hp" value="${vo.hp }">
		<br> 회사(company): <input type="text" name="company" value="${vo.company }"> <br>

		<button type="submit">수정</button>
	</form>
	
	<p>
		<a href="/phonebook3/list">리스트로 바로가기</a>
	</p>
	
</body>

</html>
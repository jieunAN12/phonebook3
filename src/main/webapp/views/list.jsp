<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.javaex.vo.PersonVO"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<PersonVO> plist = (ArrayList<PersonVO>) request.getAttribute("plist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>

	<!-- 메일정보 리스트 -->
	<c:forEach items="${ plist}" var="phone">
		<table border="1">
			<colgroup>
				<col style="width: 120px;">
				<col style="width: 170px;">
			</colgroup>
			<tbody>
				<tr>
					<td>이름(name)</td>
					<td>${phone.name }</td>
				</tr>
				<tr>
					<td>핸드폰(hp)</td>
					<td>${phone.hp }</td>
				</tr>
				<tr>
					<td>회사(company)</td>
					<td>${phone.company }</td>
				</tr>
				<tr>
					<td><a href="/phonebook3/updateForm?person_id=${phone.person_id }">수정</a></td>
					<td><a href="/phonebook3/delete?person_id=${phone.person_id }">삭제</a></td>
				</tr>
			</tbody>
		</table>
		<br>
	</c:forEach>
	<p>
		<a href="/phonebook3/writeForm">추가 등록</a>
	</p>
	<br>
</body>
</html>
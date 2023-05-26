<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/phone2/PhoneController" method="get">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
				<td><button type="submit">삭제</button></td>
				<td><a href="">메인으로 돌아가기</a></td>
			</tr>
		</table>
		<input type='text' name="delete" value="delete"><br>
	</form>
</body>
</html>
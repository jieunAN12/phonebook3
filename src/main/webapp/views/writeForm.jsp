<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 등록폼</h1>
	<p>
		전화번호를 등록하려면 <br>
		아래 항목을 기입하고 "등록" 버튼을 클릭하세요.
	</p>
	
	<form action="/phonebook3/write2" method="get"> <!-- controller에 write로 보내겠다 -->
		번호: <input type="text" name=""> <br>
		이름(name): <input type="text" name="name"> <br>
		핸드폰(hp):  <input type="text" name="hp"> <br>
		회사(company): <input type="text" name="company"> <br>
		
		<button type="submit">등록</button>
	</form>
	
	<p>
		<a href="/phonebook3/list">리스트로 바로가기</a>
	</p>

</body>
</html>
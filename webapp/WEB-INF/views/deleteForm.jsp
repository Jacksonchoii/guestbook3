<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook3/gbc/delete" method="post">
		비밀번호: <input type="password" name="password">
		<button type="submit">확인</button>
		<input type="hidden" name="no" value="${param.no}"> 		
	</form>
	
	<c:choose>
		<c:when test = "${empty param.password}"> <!-- 기본or빈칸일 때 메시지 출력 -->
			<p>비밀번호를 입력해주세요</p>
		</c:when>
		<c:otherwise>
			<p>비밀번호를 확인하고 다시 입력해주세요</p> <!-- 비밀번호가 다를 경우 메시지 출력 -->
		</c:otherwise>
	</c:choose>
	<a href="/guestbook3/gbc/addList">메인으로 돌아가기</a>
	
</body>
</html>
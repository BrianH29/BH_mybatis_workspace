<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!--   
		* MyBatis를 사용하기 위해 mybatis 관련 라이브러리도 추가행됨 (SqlSession, Resource, ...)
		- 마이바티스 한국 사이트 들어가기(북마크 추가)
		- 시작하기 => mybatis-x.x.x.jar 클릭 => github로 이동 => 최신버전 클릭 
		- zip 다운받은 후 => zip pull해서 해다 jar 파일 => webapp\WEB-INF\lib\추가
	-->
	
	<!-- 
		WEB-INF 폴더는 WAS 서버가 관리하는 폴더이기 때문에 views 폴더가 WEB-INF안에 있을 경우
		직접적으로 url로 페이지 요청이 불가함
		직접 WAS서버에서 경로를 이동하는 방식인 forward를 통해서만 접근 가능함
	 -->
	
	<jsp:forward page="WEB-INF/views/main/main.jsp" />
	
</body>
</html>
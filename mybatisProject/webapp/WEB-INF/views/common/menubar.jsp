<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.login-area a {
	text-decoration: none;
	color: black;
	font-size: 12px;
}

.login-area button[type="submit"] {
	height: 50px;
}

.nav-area {
	background: black;
	color: white;
	height: 50px;
}

.menu {
	display: table-cell;
	width: 250px;
	height: 50px;
	font-size: 20px;
	line-height: 50px;
	font-weight: bold;
}

.menu:hover {
	cursor: pointer;
	background: darkgrey;
}

.outer {
	background: black;
	color: white;
	margin-top: 50px;
	width: 900px;
	margin: auto;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1 align="center">Welcome to MyBatis World!</h1>
    <br />

    <div class="login-area" align="right">
      <c:choose>
      	<c:when test="${loginUser eq null }">
		      <!-- 1. 로그인 요청전 보여질 폼 -->
		      <form action="login.me" method="post">
		        <table>
		          <tr>
		            <td>아이디</td>
		            <td><input type="text" name="userId" /></td>
		            <td rowspan="2"><button type="submit">로그인</button></td>
		          </tr>
		          <tr>
		            <td>비밀번호</td>
		            <td><input type="password" name="userPwd" /></td>
		          </tr>
		          <tr>
		            <td colspan="3" align="center">
		              <a href="enrollForm.me">회원가입</a> &nbsp;&nbsp;
		              <!-- 
		              	enrollForm.me 로 요청시 구동이 될 Servlet클래스 만들기 (MemberEnrollFormController)
		              	서블릿 클래스 만든 후 WEB-INF/views/member/memberEnrollForm.jsp 로 포워딩
		               -->
		              <a href="">ID/PWD 찾기</a>
		            </td>
		          </tr>
		        </table>
		      </form>
		</c:when>
		<c:otherwise>
		      <!-- 2. 로그인 성공후 보요질 div -->
		      <div>
		        <table>
		          <tr>
		            <td colspan="2">
		              <h3>${loginUser.userName }님 환영합니다.</h3>
		            </td>
		          </tr>
		          <tr>
		            <td><a href="">my page</a></td>
		            <td><a href="logout.me">logout</a></td>
		          </tr>
		        </table>
		      </div>
	      </c:otherwise>
      </c:choose>
    </div>

    <div class="nav-area" align="center">
      <div class="menu">HOME</div>
      <div class="menu">공지사항</div>
      <div class="menu" onclick="location.href='list.bo?currentPage=1';">게시판</div> <!-- location.href 자바스크립트 -->
      <div class="menu">ETC</div>
    </div>
</body>
</html>
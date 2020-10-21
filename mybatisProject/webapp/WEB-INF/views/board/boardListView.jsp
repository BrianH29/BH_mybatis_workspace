<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#list-area {
	border: 1px solid white;
	text-align: center;
}

#list-area>tbody>tr:hover {
	background: darkgrey;
	cursor: pointer;
}

#paging-area a {
	color: white;
	text-decoration: none;
}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />

    <div class="outer">
      <br />
      <h1 align="center">게시판</h1>
      <br />

      <!--검색영역-->
      <div id="search-area" align="center">
        <form action="search.bo">
          <select name="condition">
            <option value="writer">작성자</option>
            <option value="title">제목</option>
            <option value="content">내용</option>
          </select>
          <input type="text" name="keyword" />
          <button type="submit">검색</button>
        </form>
      </div>

      <br /><br />

      <table id="list-area" align="center">
        <thead>
          <tr>
            <th>글번호</th>
            <th width="400">제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="b" items="${list }">
	          <tr>
	            <td>${b.boardNo }</td>
	            <td>${b.boardTitle }</td>
	            <td>${b.boardWriter }</td>
	            <td>${b.count }</td>
	            <td>${b.createDate }</td>
	          </tr>
          </c:forEach>
        </tbody>
      </table>
      <br /><br />

      <div id="paging-area" align="center">
        <a href="">[이전]</a>
		
		<c:forEach var="p" begin="${ pi.startPage }" end="${pi.endPage }">
        	<a href="">[${p }]</a>
		</c:forEach>
        <a href="">[다음]</a>
      </div>
      <br /><br />
    </div>
</body>
</html>
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
        <input type="hidden" name="currentPage" value="1"> <!-- name=key값 value=키의 값 -->
          <select name="condition">
            <option value="writer">작성자</option>
            <option value="title">제목</option>
            <option value="content">내용</option>
          </select>
          <input type="text" name="keyword" value="${ keyword }"/>
          <button type="submit">검색</button>
        </form>
      </div>
      
      <script>
      		$(function(){
      			$("#search-area option[value=${condition}]").attr("selected", true);
      		});
      </script>

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
      <script>
      	$(function(){
      			$("#list-area tbody tr").click(function(){
      				location.href="detail.bo?bno=" + $(this).children().eq(0).text(); 
      				//$(this).children().eq(0).text() tr안에 children == td 이고 그중에서 첫번쨰 b.boardNo 의 값을 받기 위해 text()
      				//html()로 하면 tag까지 다 넘어옴.
      			});
      	});
      </script>
      <br /><br />

		<div id="paging-area" align="center">
			<c:if test="${ pi.currentPage ne 1}">
				<a href="list.bo?currentPage=${ pi.currentPage - 1 }">[이전]</a>
			</c:if>
			<c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
				<c:choose>
					<c:when test="${pi.currentPage ne p}">
						<c:choose>
							<c:when test="${empty sc }">
								<!-- 검색하기 전에 요청할 url -->
								<a href="list.bo?currentPage=${p }">[${ p }]</a>
							</c:when>
							<c:otherwise>
							
								<c:url var="searchUrl" value="search.bo">
									<c:param name="currentPage" value="${ p }" />
									<c:param name="condition" value="${ condition }" />
									<c:param name="keyword" value="${ keyword }" />
								</c:url>
								<!-- 검색 후 요청할 url 위의 코드로 길이를 줄일수 있다.-->
								<!-- <a href="search.bo?currentPage=${ p }&condition=${condition}&keyword=${keyword}">[${ p }]</a> -->
								<a href="${searchUrl }">[${ p }]</a>
							</c:otherwise>
						</c:choose>	
					</c:when>
					<c:otherwise>
						<font color="red" size="4">[${ p }]</font>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pi.currentPage ne pi.maxPage }">
				<a href="list.bo?currentPage=${pi.currentPage + 1 }">[다음]</a>
			</c:if>
		</div>
		<br /><br />
    </div>
</body>
</html>
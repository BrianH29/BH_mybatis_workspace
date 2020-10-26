package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.SearchCondition;
import com.kh.mybatis.common.Pagination;
import com.kh.mybatis.common.vo.PageInfo;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String condition = request.getParameter("condition"); // writer, title, content
		String keyword = request.getParameter("keyword"); // 검색 키워드
		
		SearchCondition sc = new SearchCondition(); 
		
		switch(condition){
		case "writer" : sc.setWriter(keyword); break;
		case "title" : sc.setTitle(keyword); break;
		case "content" : sc.setContent(keyword);break;
		}
		
		//SearchCondition 객체의 세개의 필드 중 한군데에 키워드 값이 담겨 있을것!! 나머지 두군데는 null
		
		BoardService bService = new BoardServiceImpl(); 
		// *listCount : 검색 결과에 해당하는 게시글 총 갯수 
		int listCount = bService.selectSearchListCount(sc);
		
		//*currentPage
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//*pageLimit =10 / *boardLimit = 5
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);
		
		ArrayList<Board> list = bService.selectSearchList(sc,pi); 
		// 검색결과의 일부분만 추출해야 하기 떄문에 페이징 처리해줘서 페이지에 limit을두고 받아서 뿌리기 위해
		
		request.setAttribute("pi",pi);
		request.setAttribute("list", list);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		request.setAttribute("sc", sc);
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

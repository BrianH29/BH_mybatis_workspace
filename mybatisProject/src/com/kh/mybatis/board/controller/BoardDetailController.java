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
import com.kh.mybatis.board.model.vo.Reply;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno")); 
		
		BoardService bService = new BoardServiceImpl(); 
		//상세보기 요청시 실행할 서비스
		// 1. 해당 게시글 조회수 증가 시키는 서비스
		int result = bService.updateCount(bno); 
		
		if(result>0) {
			
		// 2. 해당 게시글 내용 상세 조회 서비스(글번호, 제목, 작성자, 조회수, 작성일, 내용)
			Board b = bService.selectBoard(bno);
		// 3. 해당 게시글에 딸려있는 댓글리스트 조회 서비스(작성자, 댓글내용, 작성일)
			ArrayList<Reply> list = bService.selectReplyList(bno);
			
			request.setAttribute("b",b);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);
		} else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

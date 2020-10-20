package com.kh.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.member.model.service.MemberServiceImpl;
import com.kh.mybatis.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 요청시 전달값 뽑아서 변수 또는 객체에 기록해주기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName"); 
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		Member m = new Member(userId, userPwd, userName, email, birthday, gender, phone, address); 
		
		//2. 해당 요청을 처리해주는 서비스 호출 및 결과 받기
		int result = new MemberServiceImpl().insertMember(m);
		
		//3. 결과에 따른 응답 뷰 지정
		if(result>0) { //회원가입 성공
			response.sendRedirect(request.getContextPath());
		} else { // 회원가입 실패
			request.setAttribute("errorMsg", "회원가입실패"); 
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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

package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class IdPwdFindController
 */
@WebServlet("/idFind.me")
public class IdFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdFindController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("memberName");
		String email = request.getParameter("email");

		Member loginUser = new MemberService().idFind(name, email);
		
		
		if (loginUser == null) {
			
			request.setAttribute("errorMsg", "아이디찾기에 실패했습니다.");
			
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
			/*
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
			view.forward(request, response);
			*/
		} else {
			
			HttpSession session = request.getSession();
			
			
			session.setAttribute("alertMsg", "아이디찾기 성공");
			session.setAttribute("loginMember", loginUser);
			
			response.sendRedirect(request.getContextPath()+ "/findidresult.me");
			
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

package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class PwdFindController
 */
@WebServlet("/pwdFind.me")
public class PwdFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PwdFindController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("memberId");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		Member pwd = new MemberService().pwdFind(id, question, answer);
		
		System.out.println(pwd);
		if (pwd == null) {
			request.setAttribute("errorMsg", "비밀번호찾기에 실패했습니다.");
			
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
			
		} else { 
			HttpSession session = request.getSession();
			
			session.setAttribute("loginMember", pwd);
			
			response.sendRedirect(request.getContextPath()+ "/findpwdresult.me");
			
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

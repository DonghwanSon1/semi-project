package com.kh.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

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
		
				request.setCharacterEncoding("UTF-8");
				
				String yy = request.getParameter("yy");
				String mm = request.getParameter("mm");
				String dd = request.getParameter("dd");
				
			
						
				Date birthday = Date.valueOf(yy+"-"+mm+"-"+dd);
				
				
				
				String memberId = request.getParameter("memberId"); 
				String memberPwd = request.getParameter("memberPwd"); 
				String memberName = request.getParameter("memberName"); 
				String question = request.getParameter("question"); 
				String answer = request.getParameter("answer"); 
				String email = request.getParameter("email"); 
				String phone = request.getParameter("phone"); 
				String memberNick = request.getParameter("loginNickName");
				
				
				
				Member m = new Member(memberId, memberPwd, memberName, birthday, question, answer, email, phone, memberNick);
				
				
				int result = new MemberService().insertMember(m);
				
				
				if (result > 0) {  
					request.getSession().setAttribute("alertMsg", "회원가입 성공");
					response.sendRedirect(request.getContextPath());
					
				} else { 
					request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
					
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
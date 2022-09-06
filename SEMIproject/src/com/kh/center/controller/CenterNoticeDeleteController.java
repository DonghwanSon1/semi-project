package com.kh.center.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.center.model.service.CenterService;

/**
 * Servlet implementation class CenterNoticeDeleteController
 */
@WebServlet("/deleteN.ce")
public class CenterNoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterNoticeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값 뽑기
		int noticeNo  = Integer.parseInt(request.getParameter("deleteNo"));
		// 가공 => 패스
		
		// 서비스단으로 토스
		int result = new CenterService().deleteCenterNotice(noticeNo);
		
		// 응답뷰 지정
		if (result > 0) { // 성공적으로 로그인을하고 회원정보가 들어왔을때
			
			request.getSession().setAttribute("alertMsg", "FAQ 삭제했습니다.");
			response.sendRedirect(request.getContextPath() + "/center.ce?cpage=1");
			
		} else {
			request.setAttribute("errorMsg", "FAQ 삭제를 실패했습니다.");
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

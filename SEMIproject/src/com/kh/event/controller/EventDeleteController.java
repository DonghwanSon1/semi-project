package com.kh.event.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.event.model.service.EventService;


/**
 * Servlet implementation class BoardDeleteController
 */
@WebServlet("/delete.ev")
public class EventDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 인코딩 X
		
		// 2) 값 뽑기
		int EventNo = Integer.parseInt(request.getParameter("eno"));
		
		// 3) 가공 X
		
		// 4) 서비스단으로 토스~
		int result = new EventService().deleteEvent(EventNo);
		
		if (result > 0) { // 성공
			
			request.getSession().setAttribute("alertMsg", "이벤트페이지를 삭제했습니다.");
			response.sendRedirect(request.getContextPath() + "/list.ev?cpage=1");
			
			
		} else { // 실패
			request.setAttribute("errorMsg", "이벤트페이지 삭제 실패!");
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

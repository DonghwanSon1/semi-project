package com.kh.center.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.center.model.service.CenterService;
import com.kh.center.model.vo.Center;

/**
 * Servlet implementation class CenterUpdateController
 */
@WebServlet("/update.ce")
public class CenterUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		// 인코딩
		request.setCharacterEncoding("UTF-8");
	
		// 값 뽑기
		int centerNo = Integer.parseInt(request.getParameter("ceno"));
		String centerTitle = request.getParameter("title");
		String centerContent = request.getParameter("content");
	
		
		Center c = new Center();
		c.setCenterNo(centerNo);
		c.setCenterTitle(centerTitle);
		c.setCenterContent(centerContent);
		
	
		int result = new CenterService().updateCenter(c);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "문의 글이 수정되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.ce?ceno=" + centerNo);
		} else {
			request.setAttribute("errorMsg", "문의 글 수정 실패!");
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

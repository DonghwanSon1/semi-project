package com.kh.center.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.center.model.service.CenterService;

/**
 * Servlet implementation class CenterDeleteController
 */
@WebServlet("/delete.ce")
public class CenterDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int centerNo = Integer.parseInt(request.getParameter("ceno"));
		
		// ================== 문의 글번호로 문의 글 삭제 ====================
		int result1 = new CenterService().deleteCenter(centerNo);
		
		// ================== 문의 글번호로 문의 댓글 전체 삭제 ================
		int result2 = new CenterService().allDeleteReply(centerNo);
		
		if((result1 > 0) || ((result1 * result2) > 0)) {
			
			request.getSession().setAttribute("alertMsg", "문의 글을 삭제했습니다.");
			response.sendRedirect(request.getContextPath() + "/list.ce?cpage=1");
			
		}else {
			request.setAttribute("errorMsg", "문의 글 삭제 실패했습니다!");
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

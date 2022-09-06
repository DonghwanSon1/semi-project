package com.kh.center.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.center.model.service.CenterService;
import com.kh.center.model.vo.CenterInfo;

/**
 * Servlet implementation class CenterInfoInsertController
 */
@WebServlet("/infoInsert.ce")
public class CenterInfoInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterInfoInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// POST방식이라 인코딩해야된다.
		request.setCharacterEncoding("UTF-8");
		
		// jsp에서 입력한 값 뽑기
		String infoTitle = request.getParameter("title");
		String infoContent = request.getParameter("content");
		
		// VO 객체로 가공
		CenterInfo ci = new CenterInfo();
		ci.setInfoTitle(infoTitle);
		ci.setInfoContent(infoContent);
		
		// 서비스단으로 넘겨줌 (성공,실패로만 이루어져있으니 int로 받음)
		int result = new CenterService().insertCenterInfo(ci);
		
		// 결과에 따른 응답페이지 지정
		if(result > 0 ) {
			// 성공시
			request.getSession().setAttribute("alertMsg", "이용안내 등록되었습니다.");
			response.sendRedirect(request.getContextPath() + "/infoList.ce?cpage=1");
		} else {
			request.setAttribute("errorMsg", "이용안내 등록 실패했습니다.");
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

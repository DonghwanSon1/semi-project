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
 * Servlet implementation class CenterUpdateFormController
 */
@WebServlet("/updateForm.ce")
public class CenterUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int centerNo = Integer.parseInt(request.getParameter("ceno"));
	
	
		Center c = new CenterService().selectDetailCenter(centerNo);
		
		request.setAttribute("c", c);
		
		request.getRequestDispatcher("views/center/centerUpdateForm.jsp").forward(request, response);
	
	
	
	
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

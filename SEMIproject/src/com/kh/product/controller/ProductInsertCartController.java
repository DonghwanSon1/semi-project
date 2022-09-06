package com.kh.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService;

/**
 * Servlet implementation class ProductInsertCartController
 */
@WebServlet("/insertCart.pr")
public class ProductInsertCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩 노
		
		// 값 뽑기
		int memberNo = Integer.parseInt(request.getParameter("mno"));
		int productNo = Integer.parseInt(request.getParameter("pno"));
		int quantity = Integer.parseInt(request.getParameter("quant"));
		
		int result = new ProductService().insertCart(memberNo, productNo, quantity);
		
		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/cart.my");
		} else {
			request.setAttribute("errorMsg", "장바구니에 담기 실패했습니다.");
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

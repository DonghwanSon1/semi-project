package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class ProductSearchController
 */
@WebServlet("/search.pr")
public class ProductSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩 NO
		
		// 값 뽑기 => 쿼리스트링을 이용해서 사용가 입력한 값을 넘겨 받음 (search.pr?keyword="사용자의 입력 값")
		String keyword = request.getParameter("keyword");
		// System.out.println(keyword);
		
		// 가공 불필요
		
		// 서비스단으로 토스 => ArrayList로 반환 값 받음
		ArrayList<Product> searchList = new ProductService().searchProduct(keyword);
		
		if (!searchList.isEmpty()) {			
			request.setAttribute("searchList", searchList);
			request.getRequestDispatcher("views/product/searchProduct.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "검색하신 조건을 만족하는 결과가 존재하지 않습니다.");
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

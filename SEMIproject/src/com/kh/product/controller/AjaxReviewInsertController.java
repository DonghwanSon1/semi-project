package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;
import com.kh.member.model.vo.Member;


/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/review.pr")
public class AjaxReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		// request로부터 값 뽑기
		String reviewContent = request.getParameter("content");
		int productNo = Integer.parseInt(request.getParameter("pno"));
		
		// 로그인한 회원정보
		int memberNo = ((Member)request.getSession().getAttribute("loginMember")).getMemberNo();
		
		// VO 가공 => Reply
		Review r = new Review();
		r.setReviewContent(reviewContent);
		r.setReviewPno(productNo);
		r.setReviewWriter(String.valueOf(memberNo));
		
		// Service단 호출
		int result = new ProductService().insertReview(r);
		
		// Gson, Json => 넘겨야할 값이 여러개일때 묶을때
		
		// result 1객뿐임 그냥 넘기기
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

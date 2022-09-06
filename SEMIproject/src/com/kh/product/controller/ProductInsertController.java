package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.product.model.service.ProductService;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProductInsertController
 */
@WebServlet("/insert.pr")
public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상품등록은 방대한 정보가 들어오기 때문에 POST 방식으로 전송함
		request.setCharacterEncoding("UTF-8");
		
		// 파일 등록을 하기때문에 multipart객체에 값을 이관시켜줘야한다.
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 용량 제한 == 10mb
			int maxSize = 10 * 1024 * 1024;
			
			// 저장경로 지정
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			
			String savePath = application.getRealPath("/resources/product_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 값뽑기
			// 상품 등록하는데 필요한 값 : 상품명, 가격, 재고수량, 상품상세정보, 카테고리번호
			// multiRequest 객체를 통해 값을 받아야한다 (request객체 X)
//			int categoryNo = Integer.parseInt(multiRequest.getParameter("categoryNo"));
//			String pName = multiRequest.getParameter("productName");
//			int price = Integer.parseInt(multiRequest.getParameter("price"));
//			int stock = Integer.parseInt(multiRequest.getParameter("stock"));
//			String pDesc = multiRequest.getParameter("productDesc");
			
			Product p = new Product();
			p.setProductName(multiRequest.getParameter("productName"));
			p.setCategory(Integer.parseInt(multiRequest.getParameter("categoryNo")));
			p.setProductDesc(multiRequest.getParameter("productDesc"));
			p.setStock(Integer.parseInt(multiRequest.getParameter("stock")));
			p.setSalesQuantity(Integer.parseInt(multiRequest.getParameter("salesQuantity")));
			//p.setProductEnroll(multiRequest.getParameter("productEnroll"));
			p.setPrice(Integer.parseInt(multiRequest.getParameter("price")));
			p.setStatus(multiRequest.getParameter("status"));
			
			// 가공처리
//			Product p = new Product(categoryNo, pName, price, stock, pDesc);
			
			// 두번째 insert (productAttachment)를 위한 값
			// 상품의 사진은 무조건 하나 이상은 들어온다 (최대 4개)
			// 여러개의 Attachment객체를 다뤄야하기 때문에 ArrayList로 담아준다.
			ArrayList<ProductAttachment> list = new ArrayList<ProductAttachment>();
			
			// input file 의 키값은 upfile1~4
			for(int i = 1; i <= 4; i++) {
				
				// 키값만 미리 변수로 세팅
				String key = "upfile" + i;
				
				// 원본파일명이 존재하는지 메소드를 이용해서 확인
				if(multiRequest.getOriginalFileName(key) != null) { // 원본파일이 존재
					
					// 첨부파일이 존재할 경우 ProductAttachment객체 생
					ProductAttachment pImg = new ProductAttachment();
					pImg.setOriginName(multiRequest.getOriginalFileName(key)); // 원본명
					pImg.setChangeName(multiRequest.getFilesystemName(key)); // 수정명
					pImg.setFilePath("resources/product_upfiles/"); // 경로명
					
					// 파일레벨을 지정해줘야한다.
					// 대표이미지는 fileLevel이 1 / 서브이미지들은 2
					// 대표이미지의 키값은 file1
					
					if(i == 1) {
						// 대표이미지
						pImg.setFileLevel(1);
					} else {
						pImg.setFileLevel(2);
					}
					list.add(pImg);
				}
				
			}
			
			// 서비스단으로 토스 => insert문 사용
			int result = new ProductService().insertProduct(p, list);
			
			// 응답뷰 지정
			if (result > 0 ) {
				request.getSession().setAttribute("alertMsg", "신상품 추가 성공!");
				response.sendRedirect(request.getContextPath() + "/allproduct.pr");
			} else {
				request.setAttribute("alertMsg", "에러발생! 상품 추가 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			
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

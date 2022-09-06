package com.kh.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductAttachment;
import com.kh.product.model.vo.ProductCategory;
import com.kh.product.model.vo.Review;

import static com.kh.common.Template.*;

public class ProductDao {

	private Properties prop = new Properties();
	
	public ProductDao() {
		
		String file = ProductDao.class.getResource("/sql/product/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ProductCategory> getCategory(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<ProductCategory> categories = new ArrayList<ProductCategory>();
		
		String sql = prop.getProperty("getCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				categories.add(new ProductCategory(rSet.getInt("CATEGORY_NO"), rSet.getString("CATEGORY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pstmt);
		}
		return categories;
	}

	// ******************************************************************************************
	// 상품 INSERT문
	// ******************************************************************************************	
	public int insertProduct(Connection conn, Product p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getProductName());
			pstmt.setInt(2, p.getPrice());
			pstmt.setInt(3, p.getStock());
			pstmt.setString(4, p.getProductDesc());
			pstmt.setString(5, p.getStatus());
			pstmt.setInt(6, p.getSalesQuantity());
			pstmt.setInt(7, p.getCategoryNo());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// ******************************************************************************************
	// 상품 이미지 INSERT문
	// ******************************************************************************************
	public int insertProductAttachmentList(Connection conn, ArrayList<ProductAttachment> list){
		
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProductAttachment");
		try {
			
			for(ProductAttachment pat : list) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,  pat.getOriginName());
				pstmt.setString(2, pat.getChangeName());
				pstmt.setString(3, pat.getFilePath());
				pstmt.setInt(4, pat.getFileLevel());
				pstmt.setString(5, pat.getStatus());
				
				result *= pstmt.executeUpdate();
			}
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	

	public ArrayList<Product> selectNewProduct(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<Product> list = new ArrayList<Product>();
		
		String sql = prop.getProperty("selectNewProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				// 조회하는 값 : 상품번호, 상품명, 가격, (파일경로 + 파일명) 
				
				Product p = new Product();
				p.setProductNo(rSet.getInt("PRODUCT_NO"));
				p.setProductName(rSet.getString("PRODUCT_NAME"));
				p.setPrice(rSet.getInt("PRICE"));
				p.setProductDesc(rSet.getString("PRODUCT_DESC"));
				p.setFilePathName(rSet.getString("FILEPATHNAME"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Product> searchProduct(Connection conn, String keyword) {
		
		PreparedStatement pstmt = null;
		ArrayList<Product> searchList = new ArrayList<Product>();
		ResultSet rSet = null;
		
		String sql = prop.getProperty("searchProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				Product p = new Product();
				
				p.setProductNo(rSet.getInt("PRODUCT_NO"));
				p.setProductName(rSet.getString("PRODUCT_NAME"));
				p.setPrice(rSet.getInt("PRICE"));
				p.setProductDesc(rSet.getString("PRODUCT_DESC"));
				p.setFilePathName(rSet.getString("PIMG"));
				
				searchList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

	public Product selectProduct(Connection conn, int productNo) {
		
		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			
			rSet = pstmt.executeQuery();
			
			if (rSet.next()) {
				p = new Product(rSet.getInt("PRODUCT_NO"),
								rSet.getString("PRODUCT_NAME"),
								rSet.getInt("PRICE"),
								rSet.getInt("STOCK"),
								rSet.getString("PRODUCT_DESC"),
								rSet.getInt("SALES_QUANTITY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pstmt);
		}
		
		return p;
	}
	
	public ArrayList<ProductAttachment> selectProductAttachment(Connection conn, int productNo) {
		
		ArrayList<ProductAttachment> pa = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,productNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ProductAttachment at = new ProductAttachment();
				
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setRefPno(rset.getInt("REF_PNO"));
				at.setFilePath(rset.getString("PIMG"));
				at.setUpdloadDate(rset.getDate("UPLOAD_DATE"));
				
				pa.add(at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return pa;
	}

	public int insertCart(Connection conn, int memberNo, int productNo, int quantity) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.println(memberNo);
		System.out.println(productNo);
		System.out.println(quantity);
		
		String sql = prop.getProperty("insertCart");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, productNo);
			pstmt.setInt(3, quantity);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
// ******************************************************************************************
	// 전체 등록 상품 조회 하도록 구현
	// ******************************************************************************************
	public ArrayList<Product> selectAllProduct(Connection conn){
			
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllProduct");
			
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			Product p = null;
			while(rset.next()) {
				
				p = new Product();
				p.setProductNo(rset.getInt("PRODUCT_NO"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setStock(rset.getInt("STOCK"));
				p.setProductDesc(rset.getString("PRODUCT_DESC"));
				p.setStatus(rset.getString("STATUS"));
				p.setSalesQuantity(rset.getInt("SALES_QUANTITY"));
				p.setFilePathName(rset.getString("PRODUCTIMG"));
					
				list.add(p);
			}
		}catch(Exception e) {
				e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	// ******************************************************************************************
	// 할인중인 상품 조회 하도록 구현
	// ******************************************************************************************
	public ArrayList<Product> selectSaleProduct(Connection conn){
		
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSaleProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			Product p = null;
			while(rset.next()) {
			
				p = new Product();
				p.setProductNo(rset.getInt("PRODUCT_NO"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setStock(rset.getInt("STOCK"));
				p.setProductDesc(rset.getString("PRODUCT_DESC"));
				p.setStatus(rset.getString("STATUS"));
				p.setSalesQuantity(rset.getInt("SALES_QUANTITY"));
				p.setFilePathName(rset.getString("PRODUCTIMG"));
				
				list.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	// ******************************************************************************************
	// 판매량 상위 10건 상품 조회 하도록 구현
	// ******************************************************************************************
	public ArrayList<Product> selectRankingProduct(Connection conn){
		
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectRankingProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			Product p = null;
			while(rset.next()) {
			
				p = new Product();
				p.setProductNo(rset.getInt("PRODUCT_NO"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setStock(rset.getInt("STOCK"));
				p.setProductDesc(rset.getString("PRODUCT_DESC"));
				p.setStatus(rset.getString("STATUS"));
				p.setSalesQuantity(rset.getInt("SALES_QUANTITY"));
				p.setFilePathName(rset.getString("PRODUCTIMG"));
				
				list.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int insertReview(Connection conn, Review r) {
			
			// INSERT문 => 처리된 행의 갯수
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertReview");
			
			try {
				pstmt = conn.prepareStatement(sql);
	
				pstmt.setInt(1,  Integer.parseInt(r.getReviewWriter()));
				pstmt.setInt(2, r.getReviewPno());
				pstmt.setString(3, r.getReviewContent());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
	}
	
	public ArrayList<Review> selectReviewList(Connection conn, int productNo){
		// SELECT => ResultSet => ArratList, while
		//변수
		ArrayList<Review> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,  productNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("REVIEW_NO"),
								   rset.getString("MEMBER_ID"),
								   rset.getString("REVIEW_CONTENT"),
								   rset.getString("CREATE_DATE")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}

package com.kh.center.model.dao;

import static com.kh.common.Template.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.center.model.vo.Center;
import com.kh.center.model.vo.CenterInfo;
import com.kh.center.model.vo.CenterNotice;
import com.kh.center.model.vo.CenterReply;
import com.kh.common.model.vo.PageInfo;

public class CenterDao {

	private Properties prop = new Properties();
	
	public CenterDao() {
		String fileName = CenterDao.class.getResource("/sql/center/center-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<CenterNotice> selectCenterNoticeList(Connection conn, PageInfo pi){
		
		ArrayList<CenterNotice> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCenterNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; 
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CenterNotice cn = new CenterNotice( rset.getInt("NOTICE_NO"),
													rset.getString("NOTICE_TITLE"),
													rset.getString("NOTICE_CONTENT"));
				list.add(cn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
		
	}
	
	
	
	public int insertCenterNotice(Connection conn, CenterNotice cn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCenterNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cn.getNoticeTitle());
			pstmt.setString(2, cn.getNoticeContent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	public int deleteCenterNotice(Connection conn, int noticeNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteCenterNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	
	// ------------------ Center -------------------------------------
	
	public ArrayList<Center> selectCenterList(Connection conn, String MemberId, PageInfo pi){
		
		ArrayList<Center> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCenterList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; 
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, MemberId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Center(rset.getInt("CENTER_NO"),
									rset.getString("CENTER_TITLE"),
									rset.getString("CENTER_CONTENT"),
									rset.getString("MEMBER_ID"),
									rset.getDate("CREATE_DATE"),
									rset.getString("STATUS")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	public ArrayList<Center> selectCenterAdminList(Connection conn, PageInfo pi){
		
		ArrayList<Center> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCenterAdminList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; 
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Center(rset.getInt("CENTER_NO"),
									rset.getString("CENTER_TITLE"),
									rset.getString("CENTER_CONTENT"),
									rset.getString("MEMBER_ID"),
									rset.getDate("CREATE_DATE"),
									rset.getString("STATUS")));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	public int insertCenter(Connection conn, Center c) {
		
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCenter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getCenterTitle());
			pstmt.setString(2, c.getCenterContent());
			pstmt.setString(3, c.getCenterWriter());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	public Center selectDetailCenter(Connection conn, int centerNo) {
		
		Center c = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDetailCenter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, centerNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Center(rset.getInt("CENTER_NO"),
							  rset.getString("CENTER_TITLE"),
							  rset.getString("CENTER_CONTENT"),
							  rset.getString("MEMBER_ID"),
							  rset.getDate("CREATE_DATE"),
							  rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return c;
	}
	
	
	public int deleteCenter(Connection conn, int centerNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteCenter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, centerNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}
	
	
	public int updateCenter(Connection conn, Center c) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateCenter");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCenterTitle());
			pstmt.setString(2, c.getCenterContent());
			pstmt.setInt(3, c.getCenterNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	
	
	public ArrayList<CenterReply> selectReplyList(Connection conn, int centerNo){
		
		// SELECT => ResultSet => ArrayList, while
		
		ArrayList<CenterReply> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReplyList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, centerNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new CenterReply(rset.getInt("REPLY_NO"),
								   rset.getString("REPLY_CONTENT"),
								   rset.getString("MEMBER_ID"),
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
	
	
	public int insertReply(Connection conn, CenterReply c) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getReplyContent());
			pstmt.setInt(2, c.getRefBno());
			pstmt.setInt(3, Integer.parseInt(c.getReplyWriter()));
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteReply(Connection conn, int replyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
		
	}
	
	
	public int allDeleteReply(Connection conn, int centerNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("allDeleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, centerNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
		
	}
	
	
	// -------------------- CenterInfo --------------------------------
	
	public ArrayList<CenterInfo> selectCenterInfoList(Connection conn, PageInfo pi){
		
		ArrayList<CenterInfo> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCenterInfoList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; 
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				CenterInfo ci = new CenterInfo( rset.getInt("INFO_NO"),
													rset.getString("INFO_TITLE"),
													rset.getString("INFO_CONTENT"));
				list.add(ci);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
		
	}
	
	
	public int insertCenterInfo(Connection conn, CenterInfo ci) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCenterInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ci.getInfoTitle());
			pstmt.setString(2, ci.getInfoContent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteCenterInfo(Connection conn, int infoNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteCenterInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, infoNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
		
	}
	
	// ===================== page list =========================
	
	public int selectListCount(Connection conn) {
		// SELECT => ResultSet => 근데 반환형은 int
		// 변수
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}
	
	
	public int selectInfoListCount(Connection conn) {
		// SELECT => ResultSet => 근데 반환형은 int
		// 변수
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectInfoListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}
	
	
	public int selectInqListCount(Connection conn) {
		// SELECT => ResultSet => 근데 반환형은 int
		// 변수
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectInqListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}
	
	
	
}

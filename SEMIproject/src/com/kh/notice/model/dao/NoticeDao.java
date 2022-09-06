package com.kh.notice.model.dao;

import static com.kh.common.Template.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.center.model.dao.CenterDao;
import com.kh.center.model.vo.Center;
import com.kh.center.model.vo.CenterNotice;
import com.kh.common.model.vo.PageInfo;
import com.kh.notice.model.vo.Notice;

public class NoticeDao {
	
	
	private Properties prop = new Properties();
		
		public NoticeDao() {
			String fileName = CenterDao.class.getResource("/sql/notice/notice-mapper.xml").getPath();
			
			try {
				prop.loadFromXML(new FileInputStream(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	//===================== page =============================
		
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
	
	//==================== Notice =============
	
		public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi){
			
			ArrayList<Notice> list = new ArrayList();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectNoticeList");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1; 
				int endRow = startRow + pi.getBoardLimit() - 1;
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Notice(rset.getInt("NOTICE_NO"),
										rset.getString("MEMBER_ID"),
										rset.getString("NOTICE_TITLE"),
										rset.getString("NOTICE_CONTENT"),
										rset.getInt("COUNT"),
										rset.getDate("CREATE_DATE"),
										rset.getString("STATUS")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			
			return list;
			
		}
	
	
	
		public Notice selectDetailNotice(Connection conn, int noticeNo) {
			
			Notice n = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectDetailNotice");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, noticeNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					n = new Notice(rset.getInt("NOTICE_NO"),
								  rset.getString("MEMBER_ID"),
								  rset.getString("NOTICE_TITLE"),
								  rset.getString("NOTICE_CONTENT"),
								  rset.getInt("COUNT"),
								  rset.getDate("CREATE_DATE"),
								  rset.getString("STATUS"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return n;
		}
	
	
		
		public int insertNotice(Connection conn, Notice n) {
			
			
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertNotice");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, n.getNoticeTitle());
				pstmt.setString(2, n.getNoticeContent());
				
				result = pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
			
		}
	
	
		public int deleteNotice(Connection conn, int noticeNo) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("deleteNotice");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, noticeNo);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(conn);
			}
			
			return result;
		}
	
		
		public int updateNotice(Connection conn, Notice n) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("updateNotice");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, n.getNoticeTitle());
				pstmt.setString(2, n.getNoticeContent());
				pstmt.setInt(3, n.getNoticeNo());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
			
		}
	

		// ================= 조회수 ====================
		
		public int increaseCount(Connection conn, int noticeNo) {
			
			// UPDATE => 처리된 행의 개수
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("increaseCount");
			
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
		
}

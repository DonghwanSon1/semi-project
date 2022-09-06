package com.kh.event.model.dao;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.kh.common.Template.*;

import java.util.ArrayList;
import java.util.Properties;
import java.sql.SQLException;

import com.kh.event.model.dao.EventDao;
import com.kh.event.model.vo.Event;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;


import com.kh.event.model.vo.EventAttachment;

public class EventDao {
	
	private Properties prop = new Properties();
	
	public EventDao() {
		
		String fileName = EventDao.class.getResource("/sql/event/event-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public Event selectEventBoard(Connection conn, int eventNo) {
		// select문 => resultset => primary키는 한건만 => board
		Event e = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEventBoard");
		
		 try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				e = new Event(rset.getInt("EVENT_NO"),
							rset.getString("MEMBER_ID"),
							rset.getString("EVENT_TITLE"),
							rset.getString("EVENT_CONTENT"));
									
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		return e;
		
		
		
	}
		
public int increaseEventCount(Connection conn, int EventNo) {
		
		// update문
		// 변수
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseEventCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, EventNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
		return result;
		
}
	
	public int insertEventBoard(Connection conn, Event e) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertEventBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, e.getEventTitle());
			pstmt.setString(2, e.getEventContent());
			pstmt.setString(3, e.getEventWriter());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertEventAttachmentList(Connection conn, ArrayList<EventAttachment> list) {
		
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertEventAttachmentList");

		try {
			for(EventAttachment et : list) {
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, et.getOriginName());
			pstmt.setString(2, et.getChangeName());
			pstmt.setString(3, et.getFilePath());
			pstmt.setInt(4, et.getFileLevel());
			
			
			// 실행
			result *= pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
	}
	
	public ArrayList<Event> selectEventList(Connection conn){
		
		
		ArrayList<Event> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEventList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Event e = new Event();
				e.setEventNo(rset.getInt("EVENT_NO"));
				e.setEventTitle(rset.getString("EVENT_TITLE"));
				e.setCount(rset.getInt("COUNT"));
				e.setEventtitleImg(rset.getString("EVENTTITLEIMG"));
				
				list.add(e);
				
				
			}
			System.out.println(list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
		
	}

	public ArrayList<EventAttachment> selectEventAttachmentList(Connection conn, int eventNo) {
		ArrayList<EventAttachment> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEventAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				EventAttachment et = new EventAttachment();
				
				et.setFileNo(rset.getInt("FILE_NO"));
				et.setOriginName(rset.getString("ORIGIN_NAME"));
				et.setChangeName(rset.getString("CHANGE_NAME"));
				et.setFilePath(rset.getString("FILE_PATH"));
				
				list.add(et);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
public int deleteEvent(Connection conn, int EventNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteEvent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, EventNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateEvent(Connection conn, Event e) {
	
	// UPDATE => 처리된 행의 갯수
	int result = 0;
	
	PreparedStatement pstmt = null;
	
	String sql = prop.getProperty("updateEvent");
	

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, e.getEventTitle());
			pstmt.setString(2, e.getEventContent());
			pstmt.setInt(3, e.getEventNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	


}
	
	
public EventAttachment selectEventAttachment(Connection conn, int eventNo) {
		
		// 첨부파일 1개 => attachment
		
		EventAttachment et = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEventAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				et = new EventAttachment();
				et.setFileNo(rset.getInt("FILE_NO"));
				et.setOriginName(rset.getString("ORIGIN_NAME"));
				et.setChangeName(rset.getString("CHANGE_NAME"));
				et.setFilePath(rset.getString("FILE_PATH"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			
		return et;
	}
	
}

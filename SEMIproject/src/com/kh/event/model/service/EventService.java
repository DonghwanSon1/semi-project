package com.kh.event.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.kh.common.Template.*;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.event.model.dao.EventDao;
import com.kh.event.model.vo.Event;
import com.kh.event.model.vo.EventAttachment;

public class EventService {

	
	public int insertEventBoard(Event e, ArrayList<EventAttachment> list) {
		
		Connection conn = getConnection();
		
		int result1 = new EventDao().insertEventBoard(conn, e);
		
		
		int result2 = new EventDao().insertEventAttachmentList(conn, list);
		
		if(result1 * result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2);
		
	}
	
	public Event selectEventBoard(int eventNo) {
		
		Connection conn = getConnection();
		
		Event e = new EventDao().selectEventBoard(conn, eventNo);
		close(conn);
		
		return e;
	}
		
	
	public int increaseEventCount(int EventNo) {
		
		Connection conn = getConnection();
		
		int result = new EventDao().increaseEventCount(conn, EventNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	public ArrayList<Event> selectEventList() {
		
		
		Connection conn = getConnection();
		
		ArrayList<Event> list = new EventDao().selectEventList(conn);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<EventAttachment> selectEventAttachmentList(int eventNo){
		Connection conn = getConnection();
		
		ArrayList<EventAttachment> list = new EventDao().selectEventAttachmentList(conn, eventNo);
		
		close(conn);
		
		return list;
	}
	
	public int deleteEvent(int EventNo) {
		
		Connection conn = getConnection();
		
		int result = new EventDao().deleteEvent(conn, EventNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	// ============== 수정하기 하는즁 ===================
	public int updateEvent(Event e, EventAttachment et) {
		Connection conn = getConnection();
		
		int result1 = new EventDao().updateEvent(conn, e);
		
		// attachment 테이블과 관련된 결과물
		int result2 = 1;
		
		// 새롭게 첨부파일이 있을경우
		if(et != null) {
		
			
			// 기존에 첨부파일이 있었을 경우
			if(et.getFileNo() != 0) {
				result2 = new EventDao().updateEventAttachment(conn, et);
				System.out.println(result2);
			}else {
				result2 = new EventDao().insertEventNewAttachment(conn, et);
			}	
			
		} // 아닐 경우 attachment 구문 해줄일이 없으니 else구문 x
		
//		System.out.println(result1);
//		System.out.println(result2);
		
		if(result1 * result2 > 0) { // 둘다 성공할 경우에 commit
			commit(conn);
		}else {
			rollback(conn);
			
		}
		close(conn);
		
		return (result1 * result2);
	}

	
}

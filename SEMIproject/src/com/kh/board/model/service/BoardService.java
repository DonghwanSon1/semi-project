package com.kh.board.model.service;
import static com.kh.common.Template.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.common.model.vo.PageInfo;
public class BoardService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
	int listCount = new BoardDao().selectListCount(conn);
	
	close(conn);
	
	return listCount;
	}
	
	public ArrayList<Board> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Category> selectCategoryList() {
		
		Connection conn = getConnection();
		
		ArrayList<Category> list = new BoardDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
		
	}
	
	public int insertBoard(Board b, Attachment at) {
		
		Connection conn = getConnection();
		
		// board테이블에 INSERT
		int result1 = new BoardDao().insertBoard(conn, b);
		
		int result2 = 1;
		if(at != null) {
			result2 = new BoardDao().insertAttachment(conn, at);
		}
		if((result1 * result2) > 0) {
			commit(conn);
		}else{
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2);
			
			
		}
		
		
		
		public int increaseCount(int boardNo) {
			
			Connection conn = getConnection();
			
			int result = new BoardDao().increaseCount(conn, boardNo);
			
			if(result > 0) commit(conn);
			else rollback(conn);
			
			close(conn);
			
			return result;
		}
		
		public Board selectBoard(int boardNo) {
			
			Connection conn = getConnection();
			
			Board b = new BoardDao().selectBoard(conn, boardNo);
			close(conn);
			
			return b;
			
			
		}
		public Attachment selectAttachment(int boardNo) {
			Connection conn = getConnection();
			Attachment at = new BoardDao().selectAttachment(conn, boardNo);
			close(conn);
			
			return at;
			
		}
		
		public int updateBoard(Board b, Attachment at) {
			Connection conn = getConnection();
			
			int result1 = new BoardDao().updateBoard(conn, b);
			
			// attachment 테이블과 관련된 결과물
			int result2 = 1;
			
			// 새롭게 첨부파일이 있을경우
			if(at != null) {
			
				
				// 기존에 첨부파일이 있었을 경우
				if(at.getFileNo() != 0) {
					result2 = new BoardDao().updateAttachment(conn, at);
					System.out.println(result2);
				}else {
					result2 = new BoardDao().insertNewAttachment(conn, at);
				}	
				
			} // 아닐 경우 attachment 구문 해줄일이 없으니 else구문 x
			
//			System.out.println(result1);
//			System.out.println(result2);
			
			if(result1 * result2 > 0) { // 둘다 성공할 경우에 commit
				commit(conn);
			}else {
				rollback(conn);
				
			}
			close(conn);
			
			return (result1 * result2);
		}
		
		public int insertThumbnailBoard(Board b, ArrayList<Attachment> list) {
			
			Connection conn = getConnection();
			
			// 1개의 트랜잭션에 2개의 insert문 => dao에서 각각 한번 씩 호출
			int result1 = new BoardDao().insertThumbnailBoard(conn, b);
			
			int result2 = new BoardDao().insertAttachmentList(conn, list);

		
			if(result1 * result2 > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
				return (result1 * result2);
			}
		public ArrayList<Board> selectThumbnailList() {
			
			Connection conn = getConnection();
			
			ArrayList<Board> list = new BoardDao().selectThumbnailList(conn);
			
			close(conn);
			
			return list;
		}
		
		
		
		public ArrayList<Attachment> selectAttachmentList(int boardNo) {
			Connection conn = getConnection();
			
			ArrayList<Attachment> list = new BoardDao().selectAttachmentList(conn, boardNo);
			
			close(conn);
			
			return list;
			
			
		}
		public int deleteBoard(int BoardNo) {
			
			Connection conn = getConnection();
			
			int result = new BoardDao().deleteBoard(conn, BoardNo);
			
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}

		
		}
	


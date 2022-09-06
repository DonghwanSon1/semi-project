package com.kh.center.model.service;


import static com.kh.common.Template.close;
import static com.kh.common.Template.commit;
import static com.kh.common.Template.getConnection;
import static com.kh.common.Template.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.center.model.dao.CenterDao;
import com.kh.center.model.vo.Center;
import com.kh.center.model.vo.CenterInfo;
import com.kh.center.model.vo.CenterNotice;
import com.kh.center.model.vo.CenterReply;
import com.kh.common.model.vo.PageInfo;

public class CenterService {

	
	public ArrayList<CenterNotice> selectCenterNoticeList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<CenterNotice> list = new CenterDao().selectCenterNoticeList(conn, pi);
		
		close(conn);
		
		
		return list;
	}
	
	
	public int insertCenterNotice(CenterNotice cn) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().insertCenterNotice(conn, cn);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}
	
	
	public int deleteCenterNotice(int noticeNo) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().deleteCenterNotice(conn, noticeNo);
		
		close(conn);
		
		return result;
	}
	
	


		
	// ------------------ Center -------------------------------------
	
	public ArrayList<Center> selectCenterList(String MemberId, PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Center> list = new CenterDao().selectCenterList(conn, MemberId, pi);
		
		close(conn);
		
		return list;
		
	}
	
	
	public ArrayList<Center> selectCenterAdminList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Center> list = new CenterDao().selectCenterAdminList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	
	
	public int insertCenter(Center c) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().insertCenter(conn, c);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public Center selectDetailCenter(int centerNo) {
		
		Connection conn = getConnection();
		
		Center c = new CenterDao().selectDetailCenter(conn, centerNo);
		
		close(conn);
		
		return c;
	}
	
	
	public int deleteCenter(int centerNo) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().deleteCenter(conn, centerNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public int updateCenter(Center c) {
		Connection conn = getConnection();
		
		int result = new CenterDao().updateCenter(conn, c);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public ArrayList<CenterReply> selectReplyList(int centerNo){
		
		Connection conn = getConnection();
		
		ArrayList<CenterReply> list = new CenterDao().selectReplyList(conn, centerNo);
		
		close(conn);
		
		return list;
	}
	
	
	public int insertReply(CenterReply c) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().insertReply(conn, c);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public int deleteReply(int replyNo) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().deleteReply(conn, replyNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	public int allDeleteReply(int centerNo) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().allDeleteReply(conn, centerNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	//------------------------ CenterInfo --------------------------------
	
	public ArrayList<CenterInfo> selectCenterInfoList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<CenterInfo> list = new CenterDao().selectCenterInfoList(conn, pi);
		
		close(conn);
		
		
		return list;
		
	}
	
	
	public int insertCenterInfo(CenterInfo ci) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().insertCenterInfo(conn, ci);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
		
	}
	
	public int deleteCenterInfo(int infoNo) {
		
		Connection conn = getConnection();
		
		int result = new CenterDao().deleteCenterInfo(conn, infoNo);
		
		close(conn);
		
		return result;
		
	}
	
	// ================== pagelist ==========================
	
	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new CenterDao().selectListCount(conn);
		// SELECT문의 결과는 ResultSet
		// 상식적으로 생각해보면 게시글의 총 갯수는 정수형
		
		close(conn);
		
		return listCount;
	}
	
	public int selectInfoListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new CenterDao().selectInfoListCount(conn);
		// SELECT문의 결과는 ResultSet
		// 상식적으로 생각해보면 게시글의 총 갯수는 정수형
		
		close(conn);
		
		return listCount;
	}
	
	public int selectInqListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new CenterDao().selectInqListCount(conn);
		// SELECT문의 결과는 ResultSet
		// 상식적으로 생각해보면 게시글의 총 갯수는 정수형
		
		close(conn);
		
		return listCount;
	}
	
	
	
	
	
	
}

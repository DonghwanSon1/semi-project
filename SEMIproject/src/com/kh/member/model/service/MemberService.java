package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Address;
import com.kh.member.model.vo.Member;

import static com.kh.common.Template.*;

public class MemberService {
	//-------------------------------------------------------------------------------------
	// Member 관련
	
	/**
	 * 로그인 요청
	 * @param memberId
	 * @param memberPwd
	 */
	public Member loginMember(String memberId, String memberPwd) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().loginMember(conn, memberId, memberPwd);
		
		close(conn);
		
		return m;
	}
	
	
	public int idCheck(String memberId) {
		
		Connection conn = getConnection();
		
		int check = new MemberDao().idCheck(conn, memberId);
		
		close(conn);
		return check;
		
		
	}
	
	public int nickNameCheck(String loginNickName) {
		
		Connection conn = getConnection();
		
		int check = (int)new MemberDao().nickNameCheck(conn, loginNickName);
		
		close(conn);
		return check;
		
		
	}
	
	
	
	
		public int insertMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
		
		public Member idFind(String memberName, String email) {
			
			Connection conn = getConnection();
			
			Member m = new MemberDao().idFind(conn, memberName, email);
			
			close(conn);
			return m;
			
			
		}
		
		
		public Member pwdFind(String memberId, String question, String answer) {
			
			Connection conn = getConnection();
			
			Member m = new MemberDao().pwdFind(conn, memberId, question, answer);
			
			close(conn);
			return m;
			
			
		}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// 마이페이지 배송지 관련
	
	/**
	 * 각 회원의 배송지리스트를 요청
	 * @param memberNo
	 * @return
	 */
	public ArrayList<Address> selectAddressList(int memberNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Address> list = new MemberDao().selectAddressList(conn, memberNo);
		
		close(conn);
		
		return list;
	}

	/**
	 * 새로운 배송지 추가 요청
	 * @param address
	 * @return
	 */
	public int insertAddress(Address address) {
		
		Connection conn = getConnection();
		
		int result = 0;
		int result2 = 0;
		
		// 사용자의 배송지 정보를 불러와 첫 배송지 등록인지 확인을 해야한다.
		// 만약 list가 비어있을 경우 새롭게 배송지를 넣을때는 무조건 기본배송지로 설정해야함
		// list가 비어있지 않을경우 => 1. 새롭게 기본배송지로 설정을 했는가? / 2. 기본 배송지 설정을 하지 않고 추가하는
		// 를 확인해야한다.
		ArrayList<Address> list = selectAddressList(address.getMemberNo());
		
		// System.out.println(address.getMemberNo() + "의 list :" + list.size());
		// System.out.println(address.getMain());
		
		if ((!list.isEmpty() && address.getMain().equals("N")) || list.isEmpty()) {
			// 첫번째 조건 => (!list.isEmpty() && address.getMain().equals("N")
			// => 리스트가 비어있지않고 기본배송지 체크를 하지 않았을때 "N" 는 새롭게 그냥 추가	
			result = new MemberDao().insertAddress(conn, address);
		} else {
			// 현재 사용자가 등록한 배송지가 있고 새로운 기본 배송지 설정이 체크되어 들어오면
			// 기존의 기본배송지를 "N"으로 변경해야한다.
			result2 = chageMainAddress(address.getMemberNo());
			if (result2 > 0) {
				result = new MemberDao().insertAddress(conn, address);
			}
		}
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int chageMainAddress(int memberNo) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().changeMainAddress(conn, memberNo);
		
		return result;
	}

	public int deleteAddress(int ano) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteAddress(conn, ano);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int updateAddress(Address address, String temp) {
		
		Connection conn = getConnection();
		
		int result = 0;
		int result2 = 0;
		
		if(temp.equals("NN") || temp.equals("YY")) {
			result = new MemberDao().updateAddress(conn, address);
		} else if(temp.equals("NY")){
			result2 = chageMainAddress(address.getMemberNo());
			
			if (result2 > 0) {
				result = new MemberDao().updateAddress(conn, address);
			}
		}
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int setMainAddress(int ano) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().setMainAddress(conn, ano);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

}

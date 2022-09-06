package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.member.model.vo.Address;
import com.kh.member.model.vo.Member;
import static com.kh.common.Template.*;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		
		String file = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Member loginMember(Connection conn, String memberId, String memberPwd) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			
			rset = pstmt.executeQuery();
			
			
			
			
			if (rset.next()) {
				m = new Member(rset.getInt("MEMBER_NO"),
							   rset.getString("MEMBER_ID"),
							   rset.getString("MEMBER_PWD"),
							   rset.getString("MEMBER_NAME"),
							   rset.getString("MEMBER_NICK"),
							   rset.getString("PHONE"),
							   rset.getString("EMAIL"),
							   rset.getDate("BIRTHDAY"),
							   rset.getString("QUESTION"),
							   rset.getString("ANSWER"),
							   rset.getString("STATUS"),
							   rset.getInt("POINT"),
							   rset.getDate("ENROLL_DATE"));
							 
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
		
		
	}



public int idCheck(Connection conn, String memberId) {
	
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	

	
	String sql = prop.getProperty("idCheck");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberId);
		
		rset = pstmt.executeQuery();
		
		
		
		
		if(rset.next() || memberId.equals("")) { // 결과가 있다면
			return 0; // 이미 존재하는 아이디
		} else {
			return 1; // 가입 가능한 아이디
		} 
						 
		
	} catch (SQLException e1) {
		e1.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	
	return -1;
	
	
}

	public int nickNameCheck(Connection conn, String loginNickName) {
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
	
		
		String sql = prop.getProperty("nickNameCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginNickName);
			
			rset = pstmt.executeQuery();
			
			
			
			
			if(rset.next() || loginNickName.equals("")) { // 결과가 있다면
				return 0; // 이미 존재하는 아이디
			} else {
				return 1; // 가입 가능한 아이디
			} 
							 
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return -1;
	
	
}



		public int insertMember(Connection conn, Member m) {
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("insertMember");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, m.getMemberId());
				pstmt.setString(2, m.getMemberPwd());
				pstmt.setString(3, m.getMemberName());
				pstmt.setDate(4, m.getBirthDay());
				pstmt.setString(5, m.getQuestion());
				pstmt.setString(6, m.getAnswer());
				pstmt.setString(7, m.getEmail());
				pstmt.setString(8, m.getPhone());
				pstmt.setString(9, m.getMemberNick());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}
		
		
		public Member idFind(Connection conn, String memberName, String email) {
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Member m = null;
			
			String sql = prop.getProperty("findId");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberName);
				pstmt.setString(2, email);
				
				rset = pstmt.executeQuery();
				
				
				
				
				if (rset.next()) {
					m = new Member(rset.getInt("MEMBER_NO"),
								   rset.getString("MEMBER_ID"),
								   rset.getString("MEMBER_PWD"),
								   rset.getString("MEMBER_NAME"),
								   rset.getString("MEMBER_NICK"),
								   rset.getString("PHONE"),
								   rset.getString("EMAIL"),
								   rset.getDate("BIRTHDAY"),
								   rset.getString("QUESTION"),
								   rset.getString("ANSWER"),
								   rset.getString("STATUS"),
								   rset.getInt("POINT"),
								   rset.getDate("ENROLL_DATE"));
								 
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return m;
			
			
		}
		
	public Member pwdFind(Connection conn, String memberId, String question, String answer) {
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Member m = null;
			
			String sql = prop.getProperty("findPwd");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberId);
				pstmt.setString(2, question);
				pstmt.setString(3, answer);
				
				rset = pstmt.executeQuery();
				
				
				
				
				if (rset.next()) {
					m = new Member(rset.getInt("MEMBER_NO"),
								   rset.getString("MEMBER_ID"),
								   rset.getString("MEMBER_PWD"),
								   rset.getString("MEMBER_NAME"),
								   rset.getString("MEMBER_NICK"),
								   rset.getString("PHONE"),
								   rset.getString("EMAIL"),
								   rset.getDate("BIRTHDAY"),
								   rset.getString("QUESTION"),
								   rset.getString("ANSWER"),
								   rset.getString("STATUS"),
								   rset.getInt("POINT"),
								   rset.getDate("ENROLL_DATE"));
								 
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return m;
			
			
		}
	
	
	
	
	
	
	
	
	
	// ----------------------------------------------------------------------------------------------------------------------------------------------------------------
	// 배송지 관련
	public ArrayList<Address> selectAddressList(Connection conn, int memberNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<Address> list = new ArrayList<Address>();
		
		String sql = prop.getProperty("selectAddressList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				list.add(new Address(rSet.getInt("ADDRESS_NO"),
									 rSet.getString("SET_MAIN"),
									 rSet.getString("RECEIVER"),
									 rSet.getString("LOCATION"),
									 rSet.getString("PHONE"),
									 rSet.getInt("MEMBER_NO")));
									 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pstmt);
		}
		
		return list;
	}

	public int insertAddress(Connection conn, Address address) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAddress");
		
		try {
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, address.getMain());
			pstmt.setString(2, address.getReceiver());
			pstmt.setString(3, address.getLocation());
			pstmt.setString(4, address.getPhone());
			pstmt.setInt(5, address.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int changeMainAddress(Connection conn, int memberNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("changeMainAddress");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateAddress(Connection conn, Address address) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAddress");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, address.getMain());
			pstmt.setString(2, address.getReceiver());
			pstmt.setString(3, address.getLocation());
			pstmt.setString(4, address.getPhone());
			pstmt.setInt(5, address.getMemberNo());
			pstmt.setInt(6, address.getAddressNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteAddress(Connection conn, int ano) {
			
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteAddress");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int setMainAddress(Connection conn, int ano) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("setMainAddress");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ano);	
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

}

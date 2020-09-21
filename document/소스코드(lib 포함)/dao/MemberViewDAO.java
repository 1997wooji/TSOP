package com.tsop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsop.db.ConnectDB;
import com.tsop.vo.MemberVO;

public class MemberViewDAO {
	public String addMember(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone, String memberEmail, String memberIntro, String imagePath){
		MemberDAO memberDAO = new MemberDAO();
		String id = null;
		id = memberDAO.addMember(memberId, memberPwd, memberNickName, memberName, memberPhone, memberEmail, memberIntro, imagePath);
		return id;
	}
	
	/**add�޼ҵ带  �и��� ����Ͽ� ���� add�޼ҵ�*/
	public String addMember(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone, String memberEmail){

		return null;
	}
	
	/**add�޼ҵ带  �и��� ����Ͽ� ���� add�޼ҵ�*/
	public String addMember(String memberId, String memberIntro, String imagePath){
		
		return null;
	}
	
	
	public String updateMember(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone, String memberEmail, String memberIntro, String imagePath) {
		MemberDAO member = new MemberDAO();
		// �̰� ������ member.updateMember(memberId, memberPwd, memberNickName, memberName, memberPhone, memberEmail, memberIntro, imagePath);
		if(member.updateMember(memberId, memberIntro, imagePath)==null){
			return null;
		}
		if(member.updateMember(memberId, memberPwd, memberNickName, memberName, memberPhone, memberEmail)==null){
			return null;
		}
		//�̰� ������
		return memberId;
	}
	
	public String updateMember(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone, String memberEmail){
		MemberDAO member = new MemberDAO();
		String id = null;
		id = member.updateMember(memberId, memberPwd, memberNickName, memberName, memberPhone, memberEmail);
		return id; 
	}
	
	public String updateMember(String memberId, String memberIntro, String imagePath){
		MemberDAO member = new MemberDAO();
		String id = null;
		id = member.updateMember(memberId, memberIntro, imagePath);
		return id; 
	}
	
	public String deleteMember(String memberId){
		MemberDAO member = new MemberDAO();
		String id = null;
		id = member.deleteMember(memberId);
		return id;
	}
	
	public String deleteMember(String memberId, String memberPwd){
		MemberDAO member = new MemberDAO();
		String id = null;
		
		id = member.deleteMember(memberId, memberPwd);
		return id;
	}
	
	public MemberVO searchMember(String memberId){
		String select = "SELECT * FROM member_view WHERE member_id = ? ";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			if(rs.next()){
				member = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)
						);
				return member;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	public MemberVO searchMemberNickName(String memberNickName){
		String select = "SELECT * FROM member_view WHERE member_nickname = ? ";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberNickName);
			rs = psmt.executeQuery();
			if(rs.next()){
				member = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)
						);
				return member;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	public Object searchMember(String memberId, String memberPwd){
		String select = "SELECT * FROM member_view WHERE member_id = ? AND member_password = ? ";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberId);
			psmt.setString(2, memberPwd);
			rs = psmt.executeQuery();
			if(rs.next()){
				member = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)
						);
				return member;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	public Object[] searchMembers(String key){
		String select = "SELECT * FROM member_view WHERE member_nickname like ? OR member_intro like ?";
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1,"%" +key+ "%");
			psmt.setString(2,"%" +key+ "%");
			rs = psmt.executeQuery();
			while(rs.next()){
				member = new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)
						);
				list.add(member);
			}
			return list.toArray();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	

	public String searchPhone(String memberName, String memberPhone){
		String select = "SELECT member_id FROM member_view WHERE member_name = ? AND member_phone = ? ";
		String update = "UPDATE member_tb SET member_password = ? WHERE member_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		String memberId = null;
		String pwd = ""+Math.random()*100000;
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberName);
			psmt.setString(2, memberPhone);
			rs = psmt.executeQuery();
			if(rs.next()){
				memberId = rs.getString(1);
				psmt.close();
				psmt = con.prepareStatement(update);
				psmt.setString(1, pwd);
				psmt.setString(2, memberId);
				psmt.executeUpdate();
				return pwd;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	public String searchPwd(String memberId, String memberName, String memberPhone, int flag){
		String select = "SELECT * FROM member_view WHERE member_id = ? AND member_name = ? AND member_phone = ? ";
		String update = "UPDATE member_tb SET member_password = ? WHERE member_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		String pwd = ""+Math.random()*100000;
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberId);
			psmt.setString(2, memberName);
			psmt.setString(3, memberPhone);
			rs = psmt.executeQuery();
			if(rs.next()){
				psmt.close();
				psmt = con.prepareStatement(update);
				psmt.setString(1, pwd);
				psmt.setString(2, memberId);
				psmt.executeUpdate();
				return pwd;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	public String searchPwd(String memberId, String memberName, String memberEmail){
		String select = "SELECT member_password FROM member_view WHERE member_id = ? AND member_name = ? AND member_email = ? ";
		String update = "UPDATE member_tb SET member_password = ? WHERE member_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String pwd = ""+Math.random()*100000;		
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberId);
			psmt.setString(2, memberName);
			psmt.setString(3, memberEmail);
			rs = psmt.executeQuery();
			if(rs.next()){
				psmt.close();
				psmt = con.prepareStatement(update);
				psmt.setString(1, pwd);
				psmt.setString(2, memberId);
				psmt.executeUpdate();
				return pwd;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	/**���̵�� �̸����� ��й�ȣ ã�� ����(�� �������?)*/
	public String searchPwd(String memberId, String memberName){
		return null;
	}
	
	public String searchId(String memberEmail){
		String select = "SELECT member_id FROM member_view WHERE member_email = ? ";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String memberId = null;
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberEmail);
			rs = psmt.executeQuery();
			if(rs.next()){
				memberId = rs.getString(1);
				return memberId;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	public String searchId(String memberPhone, int flag){
		String select = "SELECT member_id FROM member_view WHERE member_phone = ? ";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String memberId = null;
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberPhone);
			rs = psmt.executeQuery();
			if(rs.next()){
				memberId = rs.getString(1);
				return memberId;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	
	
	
}

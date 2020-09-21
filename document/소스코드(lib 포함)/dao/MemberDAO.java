package com.tsop.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tsop.db.ConnectDB;
import com.tsop.vo.MemberVO;




public class MemberDAO {
	
	public String addMember(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone, String memberEmail, String memberIntro, String imagePath) {
		
		if(memberId==null)
			return null;
		
		if(this.addMember(memberId, memberPwd, memberNickName, memberName, memberPhone, memberEmail)==null)
			return null;
		
		if(this.addMemberProfile(memberId, memberIntro, imagePath)==null)
			return null;
			
		return memberId;
	}
	
	private String addMember(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone, String memberEmail) {
		if(memberId==null)
			return null;
		
		Connection conn = 	null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectDB.connect();
			pstmt=conn.prepareStatement("insert into member_tb (member_id, member_password, member_nickname, member_name, member_phone, member_email,member_class_id) values (?,?,?,?,?,?,1)");
			pstmt.setString(1,memberId);
			pstmt.setString(2,memberPwd);
			pstmt.setString(3,memberNickName);
			pstmt.setString(4,memberName);
			pstmt.setString(5,memberPhone);
			pstmt.setString(6,memberEmail);
			pstmt.executeUpdate();			

			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally{
			ConnectDB.close(conn,pstmt);
		}

		return memberId;

	
	}
	
	private String addMemberProfile(String memberId, String memberIntro, String imagePath) {
		
		if(memberId==null)
			return null;
		
		ImageDAO imageDao=new ImageDAO();

		int imageId=imageDao.addImage(imagePath);
		
		Connection conn = 	null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectDB.connect();
			pstmt=conn.prepareStatement("insert into member_profile_tb (member_id, image_id, member_intro) values (?,?,?)");
			pstmt.setString(1,memberId);
			pstmt.setInt(2,imageId);
			pstmt.setString(3,memberIntro);
			pstmt.executeUpdate();			

			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally{
			ConnectDB.close(conn,pstmt);
		}

		return memberId;

	
	}
	
	public String updateMember(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone, String memberEmail, String memberIntro, String imagePath) {
		
		if(memberId==null)
			return null;
		
		if(this.updateMember(memberId, memberPwd, memberNickName, memberName, memberPhone, memberEmail)==null)
		{
			return null;
		}
		
		if(this.updateMember(memberId, memberIntro, imagePath)==null)
		{
			return null;
		}
		return memberId;
	}
	
	public String updateMember(String memberId, String memberPwd, String memberNickName, String memberName, String memberPhone, String memberEmail) {
		
		if(memberId==null)
			return null;
		
		Connection conn = 	null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectDB.connect();
			pstmt=conn.prepareStatement("update member_tb set member_password=?, member_nickname=?, member_name=?, member_phone=?, member_email=? where member_id=?");
			pstmt.setString(1,memberPwd);
			pstmt.setString(2,memberNickName);
			pstmt.setString(3,memberName);
			pstmt.setString(4,memberPhone);
			pstmt.setString(5,memberEmail);
			pstmt.setString(6,memberId);
			pstmt.executeUpdate();			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally{
			ConnectDB.close(conn,pstmt);
		}

		return memberId;

	}
	
	public String updateMember(String memberId, String memberIntro, String imagePath) {
		/*�̹��� ���� �� ���ϰ� ������Ʈ^^*/
		

		ImageDAO imageDao=new ImageDAO();
		
		/*��� delete �� add*/
		Connection conn = 	null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		int imageId=0;
		
		try {
			conn = ConnectDB.connect();
			pstmt=conn.prepareStatement("select image_id from member_profile_tb where member_id=?");
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				imageId=rs.getInt(1);
			}
			if(imageId!=0) //default image�� ����� �ȵ�
			{
				imageDao.deleteImage(imageId);
			}
			
			imageId=imageDao.addImage(imagePath); //�� �̹��� ���̵� �޾ƿ�
			
			rs.close();
			pstmt.close();
			
			pstmt=conn.prepareStatement("update member_profile_tb set image_id=?, member_intro=? where member_id=?");
			pstmt.setInt(1, imageId);
			pstmt.setString(2, memberIntro);
			pstmt.setString(3, memberId);
			rs=pstmt.executeQuery();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally{
			ConnectDB.close(conn,pstmt,rs);
		}
		return memberId;

	}
	
	public String deleteMember(String memberId) {
		
		if(memberId==null)
			return null;
		
		Connection conn = 	null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectDB.connect();
			pstmt=conn.prepareStatement("delete from member_tb where member_id=?");
			pstmt.setString(1,memberId);
			pstmt.executeUpdate();			

			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally{
			ConnectDB.close(conn,pstmt);
		}

		return memberId;

	}
	
public String deleteMember(String memberId, String memberPwd) {
		
		if(memberId==null)
			return null;
		
		Connection conn = 	null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectDB.connect();
			pstmt=conn.prepareStatement("delete from member_tb where member_id=? AND member_password = ?");
			pstmt.setString(1,memberId);
			pstmt.setString(2,memberPwd);
			pstmt.executeUpdate();			

			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		}finally{
			ConnectDB.close(conn,pstmt);
		}

		return memberId;

	}
	
	/*�г������� Member ã��. MemberView���� �ؾ���. �ϴ� ��ٵ�.*/
	public MemberVO searchMember(String memberNickName) {
		return null;
	}
}

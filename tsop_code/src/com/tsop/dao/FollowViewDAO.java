package com.tsop.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tsop.db.ConnectDB;
import com.tsop.vo.FollowVO;



public class FollowViewDAO {
	
/*	public static void main(String[] args){
		
		FollowViewDAO dao=new FollowViewDAO();
		String str=null;
		
		str=dao.addFollow("jiwookkkk", "soheesleep");
		
		str=dao.deleteFollow("jiwookkkk", "soheesleep");
		
		Object[] list=dao.searchFollow("jiwookkkk");
		
		Object[] list=dao.searchFollower("leejingoo");
		
		Object[] list=dao.searchTopMember();
		
		for(int i=0; i<list.length; i++)
		{
			FollowVO vo=(FollowVO)list[i];
			
			System.out.println(vo.toString());
		}
		
		
	}*/
	
	public String addFollow(String followId, String followerId) {
		FollowDAO followDao=new FollowDAO();
		return followDao.addFollow(followId, followerId);
	}
	
	/**占식븝옙키占쏙옙 占쏙옙占쏘서 String占쏙옙占쏙옙 followId/followerId 占쏙옙환占싹곤옙占쏙옙*/
	public String deleteFollow(String followId, String followerId) {
		FollowDAO followDao=new FollowDAO();
		return followDao.deleteFollow(followId, followerId);
	}
	
	/**占쏙옙占쏙옙 follow 占싹댐옙 占쏙옙占� 찾占쏙옙*/
	public Object[] searchFollow(String memberId) {
		
		Connection conn = 	null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		List<FollowVO> list=new ArrayList<FollowVO>();
		
		try {
			conn = ConnectDB.connect();
			
			pstmt=conn.prepareStatement("select * from follow_view where followerid=?");
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{	
				list.add(new FollowVO(rs.getString("followerid"), rs.getString("followid"), rs.getString("follownickname"), rs.getString("image_path")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			ConnectDB.close(conn,pstmt,rs);
		}
		
		//sql占쏙옙 null占쏙옙 占쏙옙占� 0 return;
		
		
		return list.toArray();
		
	
	}
	
	/**占쏙옙占쏙옙 follow 占싹댐옙 占쏙옙占� 찾占쏙옙*/
	public Object[] searchFollower(String memberId) {
	
		Connection conn = 	null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		List<FollowVO> list=new ArrayList<FollowVO>();
		
		try {
			conn = ConnectDB.connect();
			
			pstmt=conn.prepareStatement("select * from follower_view where followid=?");
			pstmt.setString(1, memberId);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{	
				list.add(new FollowVO(rs.getString("followerid"), rs.getString("followid"), rs.getString("follownickname"), rs.getString("image_path")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			ConnectDB.close(conn,pstmt,rs);
		}
		
		//sql占쏙옙 null占쏙옙 占쏙옙占� 0 return;
		
		
		return list.toArray();

	}
	
	/**占싫로울옙 占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙 top 10*/
	public Object[] searchTopMember() {
		

		Connection conn = 	null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		List<FollowVO> list=new ArrayList<FollowVO>();
		
		try {
			conn = ConnectDB.connect();
			
			pstmt=conn.prepareStatement("select count(followid) as cnt, followid, follownickname, image_path from follow_view group by(followid, follownickname, image_path) order by cnt desc");
			rs=pstmt.executeQuery();
			
			for(int i=0; i<10 ;i++)
			{
				if(rs.next())
				{
					list.add(new FollowVO("follower 필요 없음", rs.getString("followid"), rs.getString("follownickname"), rs.getString("image_path")));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			ConnectDB.close(conn,pstmt,rs);
		}
		
		//sql占쏙옙 null占쏙옙 占쏙옙占� 0 return;
		System.out.println(list + " "+list.size());
		
		return list.toArray();

	
	}
}

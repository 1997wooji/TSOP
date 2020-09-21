package com.tsop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsop.db.ConnectDB;
import com.tsop.vo.MemberVO;
import com.tsop.vo.MusicVO;

public class MusicViewDAO {
	public int addMusic(String musicTitle, String musicIntro, String imagePath, int fileId, String memberId, String genreName, String[] tags, boolean musicVisibility, boolean downloadAccept){
		MusicDAO musicDAO = new MusicDAO();
		int res = -1;
		res = musicDAO.addMusic(musicTitle, musicIntro, imagePath, fileId, memberId, genreName, tags, musicVisibility, downloadAccept);
		return res;
	}
	
	/**MusicVO ��ü�� �޾� �����͸� �����ϴ� �޼ҵ� MusicVO�� fileId�� memberId�� ��� ������ ���Ѵ�.*/
	public int addMusic(MusicVO obj){
		MusicDAO musicDAO = new MusicDAO();
		int res = -1;
		return -1;
	}
	
	public int addLikeMusic(String memberId, int musicId){
		MusicDAO musicDAO = new MusicDAO();
		int res = -1;
		res = musicDAO.addLikeMusic(memberId, musicId);
		return res;
	}
	
	public int deleteMusic(int musicId){
		MusicDAO musicDAO = new MusicDAO();
		int res = -1;
		res = musicDAO.deleteMusic(musicId);
		return res;
	}
	
	public int deleteMusic(int fileId, int flag){
		MusicDAO musicDAO = new MusicDAO();
		int res = -1;
		res = musicDAO.deleteMusic(fileId, flag);
		return res;
	}
	
	public int[] deleteMusic(String memberId){
		MusicDAO musicDAO = new MusicDAO();
		int res[] = null;
		res = musicDAO.deleteMusic(memberId);
		return res;
	}
	
	/**VO��ü�� �޾� �����͸� ��������� �޼ҵ�*/
	public int deleteMusic(MusicVO obj){
		return -1;
	}
	
	public MusicVO searchMusic(int musicId){
		String selectMusic = "SELECT * FROM music_view WHERE music_id = " + musicId;
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MusicVO music = null;
		try{
			psmt = con.prepareStatement(selectMusic);
			rs = psmt.executeQuery();
				if(rs.next()){
					music = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 
							rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getInt(11), Boolean.parseBoolean(rs.getString(12)), Boolean.parseBoolean(rs.getString(13)) );
				}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return music;
	}
	
	public MusicVO[] searchMusic(String memberId){
		String selectNick = "SELECT member_nickname FROM member_tb WHERE member_id = ?";
		String selectMusicCnt = "SELECT COUNT(*) FROM music_view WHERE member_nickname = ?";
		String selectMusic = "SELECT * FROM music_view WHERE member_nickname = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String nickName = null;
		MusicVO[] music = null;
		int cnt =-1;
		try{
			psmt = con.prepareStatement(selectNick);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			if(rs.next()){
				nickName = rs.getString(1);
				psmt.close();
				rs.close();
				
				psmt = con.prepareStatement(selectMusicCnt);
				psmt.setString(1, nickName);
				rs = psmt.executeQuery();
				if(rs.next()){
					cnt = rs.getInt(1);
					music = new MusicVO[cnt];
					psmt = con.prepareStatement(selectMusic);
					psmt.setString(1, nickName);
					rs = psmt.executeQuery();
					for(int i=0;i<cnt;i++){
						rs.next();
						music[i] = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 
								rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
								rs.getInt(11), Boolean.parseBoolean(rs.getString(12)), Boolean.parseBoolean(rs.getString(13)) );
						return music;
					}
				}
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	/***/
	public MusicVO searchFileMusic(int fileId){
		String select= "SELECT * FROM music_view WHERE file_id = ?";
		MusicVO music = null;
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			psmt = con.prepareStatement(select);
			rs = psmt.executeQuery();
			if(rs.next()){
				music = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 
						rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), Boolean.parseBoolean(rs.getString(12)), Boolean.parseBoolean(rs.getString(13)) );
				return music;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt,rs);
		}
		return music;
	}
	
	public Object[] searchGenreMusic(String genreName){
		String selectMusicCnt = "SELECT COUNT(*) FROM music_view WHERE genre_name = ?";
		String selectMusic = "SELECT * FROM music_view WHERE genre_name = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		MusicVO[] music = null;
		int cnt =-1;
		try{
				psmt = con.prepareStatement(selectMusicCnt);
				psmt.setString(1, genreName);
				rs = psmt.executeQuery();
				if(rs.next()){
					cnt = rs.getInt(1);
					music = new MusicVO[cnt];
					psmt.close();
					rs.close();
					psmt = con.prepareStatement(selectMusic);
					psmt.setString(1, genreName);
					rs = psmt.executeQuery();
					
					for(int i=0;i<cnt;i++){
						rs.next();
						music[i] = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 
								rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
								rs.getInt(11), Boolean.parseBoolean(rs.getString(12)), Boolean.parseBoolean(rs.getString(13)) );
						return music;
					}
				}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return music;
	}
	
	public Object[] searchTagMusic(String tagKey){
		String selectTag = "SELECT * FROM music_view WHERE tag_name like'%?%' ";
		List<MusicVO> list = new ArrayList<MusicVO>();
		Connection con = ConnectDB.connect();
		PreparedStatement psmt= null;
		ResultSet rs = null;
		MusicVO music = null;
		try{
			psmt = con.prepareStatement(selectTag);
			psmt.setString(1, tagKey);
			rs = psmt.executeQuery();
			while(rs.next()){
				music = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 
						rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), Boolean.parseBoolean(rs.getString(12)), Boolean.parseBoolean(rs.getString(13)) );
				list.add(music);
			}
			return list.toArray();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt,rs);
		}
		
		return null;
	}
	
	public Object[] searchTitleMusic(String musicKey){
		String selectTag = "SELECT * FROM music_view WHERE music_title like'%?%' ";
		List<MusicVO> list = new ArrayList<MusicVO>();
		Connection con = ConnectDB.connect();
		PreparedStatement psmt= null;
		ResultSet rs = null;
		MusicVO music = null;
		try{
			psmt = con.prepareStatement(selectTag);
			psmt.setString(1, musicKey);
			rs = psmt.executeQuery();
			while(rs.next()){
				music = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 
						rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), Boolean.parseBoolean(rs.getString(12)), Boolean.parseBoolean(rs.getString(13)) );
				list.add(music);
			}
			return list.toArray();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt,rs);
		}
		
		return null;
	}
	
	public Object[] searchTopLikeMusic(){
		String select = "SELECT music_title, like_cnt FROM music_view ORDER BY like_cnt desc";
		List<MusicVO> list = new ArrayList<MusicVO>();
		MusicVO music = null;
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			psmt = con.prepareStatement(select);
			rs = psmt.executeQuery();
			while(rs.next()){
				music = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 
						rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), Boolean.parseBoolean(rs.getString(12)), Boolean.parseBoolean(rs.getString(13)) );
				list.add(music);
			}
			return list.toArray();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	public Object[] searchTopPlayMusic(){
		String select = "SELECT music_title, like_cnt FROM music_view ORDER BY music_play_count desc";
		List<MusicVO> list = new ArrayList<MusicVO>();
		MusicVO music = null;
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			psmt = con.prepareStatement(select);
			rs = psmt.executeQuery();
			while(rs.next()){
				music = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), 
						rs.getDate(6).toString(), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11), Boolean.parseBoolean(rs.getString(12)), Boolean.parseBoolean(rs.getString(13)) );
				list.add(music);
			}
			return list.toArray();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	public Object[] searchLikeMusic(String memberId){
		MusicDAO musicDAO = new MusicDAO();
		Object[] music = musicDAO.searchLikeMusic(memberId);
		return music;
	}
	
	/**musicId�� �޾Ƽ� ���ƿ並 ���� ��� ����� ��ȯ�ϴ� �޼ҵ�*/
	public MemberVO[] searchLikeMusic(int musicId){
		
		return null;
	}
	
	public int updateMusic(int musicId, String musicTitle, String musicIntro, String imagePath, String genreName, String[] tags, boolean musicVisibility, boolean downloadAccpet){
		MusicDAO musicDAO = new MusicDAO();
		int res = -1;
		res = musicDAO.updateMusic(musicId, musicTitle, musicIntro, imagePath, genreName, tags, musicVisibility, downloadAccpet);
		return res;
	}
	
	/**��ü�� �޾� �����͸� �����ϱ� ���� �޼ҵ�*/
	public int updateMusic(MusicVO obj){
		
		return -1;
	}
}

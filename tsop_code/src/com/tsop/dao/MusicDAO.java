package com.tsop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tsop.db.ConnectDB;
import com.tsop.util.ErrorCheck;
import com.tsop.vo.MemberVO;
import com.tsop.vo.MusicVO;

public class MusicDAO {

	private int generatId(){
		String select = "SELECT MAX(music_id) FROM music_tb";
		Connection con = ConnectDB.connect();
		int maxId = -1;
		PreparedStatement psmt=null;
		try{
			psmt = con.prepareStatement(select);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
			maxId = rs.getInt(1);	
			return maxId+1;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return -1;
	}
	public int addMusic(String musicTitle, String musicIntro, String imagePath, int fileId, String memberId, String genreName, String[] tags, boolean musicVisibility, boolean downAccept){
		int musicId = generatId();
		if(musicId==-1){return -1;}
		ImageDAO imageDAO = new ImageDAO();
		int imageId = imageDAO.addImage(imagePath);
		if(imageId == -1) {return -1;}
		
		String select = "SELECT genre_id FROM genre_tb where genre_name = ?";
		
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, genreName);
			rs = psmt.executeQuery();
			if(rs.next()){
				int genreId = rs.getInt(1);
				int res = addMusic(musicId, musicTitle, musicIntro, imageId, fileId, memberId, genreId);
				if(res == -1){
					imageDAO.deleteImage(imageId);
					return -1;
				}
				res = addMusicConfig(musicId, musicVisibility, downAccept);
				if(res != musicId){
					imageDAO.deleteImage(imageId);
					deleteMusic(musicId);
					
					return -1;
				}
				res = addMusicTag(musicId, tags);
				if(res != musicId){
					con.prepareStatement("DELETE FROM music_config_tb WHERE"+musicId).executeUpdate();
					imageDAO.deleteImage(imageId);
					deleteMusic(musicId);
					return -1;
				}
				
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con,psmt,rs);
		}
		
		return musicId;
	}
	
	public int addMusic(int musicId, String musicTitle, String musicIntro, int imageId, int fileId, String memberId, int genreId){
		if(!ErrorCheck.nullCheck(new String[]{musicTitle, musicIntro, memberId})){return -1;} 
		String insert= "INSERT INTO music_tb values(?, ?, ?, sysdate, ?, ?, ?, ?)";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		System.out.println("musicId:"+musicId+"imageId: "+imageId+"/genreid: "+genreId+"fileId: "+fileId);
		
		try{
			psmt = con.prepareStatement(insert);
			psmt.setInt(1, musicId);
			psmt.setString(2, musicTitle);
			psmt.setString(3, musicIntro);
			psmt.setString(4, memberId);
			psmt.setInt(5, fileId);
			psmt.setInt(6, genreId);
			psmt.setInt(7, imageId);
			int res = psmt.executeUpdate();
			
			psmt.execute("commit");
			
			if(res <=0){ConnectDB.close(con, psmt); return -1;}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
			ConnectDB.close(con, psmt);
		}
		
		return musicId;
	}
	public int addMusicConfig(int musicId, boolean visibility, boolean downloadAccept){
		String insert = "INSERT INTO music_config_tb values(?,?,?)";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		String isVisibility = null;
		String isDownAccept = null;
		if(visibility){isVisibility="1";}
		else {isVisibility="0";}
		
		if(downloadAccept){isDownAccept="1";}
		else{isDownAccept="0";}
		
		try{
			psmt = con.prepareStatement(insert);
			psmt.setInt(1, musicId);
			psmt.setString(2,isVisibility);
			psmt.setString(3,isDownAccept);
			int res = psmt.executeUpdate();
			psmt.execute("commit");
			
			if(res<=0){ ConnectDB.close(con, psmt); return -1;}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return musicId;
	}
	
	public int addMusicTag(int musicId, String[] tags){
		String insert = "INSERT INTO tag_music_tb values(?,?)";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		try{
			for(int i=0;i<tags.length;i++)
			{
				psmt = con.prepareStatement(insert);
				psmt.setString(1, tags[i]);
				psmt.setInt(2, musicId);
				int res = psmt.executeUpdate();
				if(res<= 0){
					deleteMusicTag(musicId);
					ConnectDB.close(con, psmt);
					return -1;
				}
			}
			
			psmt.execute("commit");
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return musicId;
	}
	
	/**관리자가 장르를 추가하기 위해서 사용하는 장르 추가 메소드*/
	public int addGenre(String genreName){
		return -1;
	}
	
	/**관리자가 장르 이름을 변경하기 위한 메소드*/
	public int updateGenre(int genreId, String genreName){
		return -1;
	}
	
	/**관리자가 장르를 삭제하기 위한 메소드*/
	public int deleteGenre(String genreName){
		return -1;
	}
	
	/**관리자가 장르를 삭제하기 위한 메소드*/
	public int deleteGenre(int genreId){
		return -1;
	}
	
	public int addLikeMusic(String memberId, int musicId){
		String insert = "INSERT INTO like_music_tb values(?,?)";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		
		try{
			psmt = con.prepareStatement(insert);
			psmt.setInt(1, musicId);
			psmt.setString(2, memberId);
			int res = psmt.executeUpdate();
			if(res <= 0){return -1;}
			return musicId;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return -1;
	}
	
	public int deleteLikeMusic(String memberId, int musicId){
		String delete = "DELETE FROM like_music_tb WHERE member_id=? AND music_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		
		try{
			psmt = con.prepareStatement(delete);
			psmt.setString(1, memberId);
			psmt.setInt(2, musicId);
			int res = psmt.executeUpdate();
			if(res <= 0){return -1;}
			return musicId;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return -1;
		
	}
	
	public int deleteListMusic(String memberId, int musicId){
		String delete = "DELETE FROM like_music_tb WHERE music_id = ? AND member_id = ? ";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		try{
			psmt = con.prepareStatement(delete);
			psmt.setInt(1, musicId);
			psmt.setString(2, memberId);
			int res = psmt.executeUpdate();
			if(res <= 0){return -1;}
			return musicId;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return -1;
	}
	
	public int updateMusic(int musicId, String musicTitle, String musicIntro, String imagePath, String genreName, String[] tags, boolean musicVisibility, boolean downloadAccpet){
		int res = -1;
		res = updateMusic(musicId, musicTitle,musicIntro, imagePath, genreName);
		if(res != musicId){return -1;}
		
		res = updateMusicConfig(musicId, musicVisibility, downloadAccpet);
		if(res != musicId){return -1;}
		
		String deleteTag = "DELEFET FROM tag_music_tb WHERE music_id = "+musicId;
		String insertTag = "INSERT INTO tag_music_tb VALUES(?,?) ";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		
		try{
			deleteMusicTag(musicId);
			for(int i=0;i<tags.length;i++)
			{
				psmt = con.prepareStatement(insertTag);
				psmt.setString(1, tags[i]);
				psmt.setInt(2, musicId);
				res = psmt.executeUpdate();
				if(res<=0){
					deleteMusicTag(musicId);
					break;
				}
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return res;
	}
	
	
	public int updateMusic(int musicId, String musicTitle,String musicIntro, String imagePath, String genreName){
		String selectImgid = "SELECT image_id FROM music_tb WHERE music_id = "+musicId;
		String updateMusic ="UPDATE music_tb SET music_title = ?, genre_id = ?,music_intro = ? WHERE music_id ="+musicId;
		String selectGenre = "SELECT genre_id FROM genre_tb WHERE genre_name = ?";
		
		ImageDAO imageDAO = new ImageDAO();
		int imageId = -1;
		int genreId = -1;
		
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null; 
		try{
			psmt = con.prepareStatement(selectImgid);
			rs = psmt.executeQuery();
			rs.next();
			imageId = rs.getInt(1);
			
			int imgId = imageDAO.updateImage(imageId, imagePath);
			if(imageId != imgId){return -1;}
			
			psmt.close();
			rs.close();
			
			psmt = con.prepareStatement(selectGenre);
			psmt.setString(1, genreName);
			rs = psmt.executeQuery();
			rs.next();
			genreId = rs.getInt(1);
			
			psmt.close();
			rs.close();
			
			psmt = con.prepareStatement(updateMusic);
			psmt.setString(1,musicTitle);
			psmt.setInt(2, genreId);
			psmt.setString(3,musicIntro);
			psmt.executeUpdate();			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return musicId;
	}
	
	public int updateMusicConfig(int musicId, boolean musicVisibility, boolean downloadAccept){
		String update = "UPDATE music_config_tb SET music_visibility = ?, music_download_accept = ? WHERE music_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		String v = null;
		String d = null;
		
		if(musicVisibility){
			v = "1";
		}else{
			v = "0";
		}
		if(downloadAccept){
			d = "1";
		}else{
			d = "0";
		}
		try{
			psmt = con.prepareStatement(update);
			psmt.setString(1,v);
			psmt.setString(2, d);
			psmt.setInt(3, musicId);
			int res = psmt.executeUpdate();
			
			if(res <= 0){
				ConnectDB.close(con, psmt);
				return -1; 
			}
			

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return musicId;
	}
	
	public Object[] searchLikeMusic(String memberId){
		String selectMember = "SELECT member_nickname FROM member_tb WHERE member_id = ?";
		String selectLikeCnt = "SELECT COUNT(*) FROM like_musics_view WHERE member_nickname = ? GROUP BY(member_nickname)";
		String selectLike = "SELECT music_id FROM like_musics_view WHERE member_nickname = ? GROUP BY(member_nickname)";
		String selectMusic = "SELECT * FROM music_view WHERE music_id = ?";
		int cnt = -1;
		int[] musicId = null;
		String nickName = null;
		MusicVO[] music = null;
		
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			psmt = con.prepareStatement(selectMember);
			rs = psmt.executeQuery();
			
			if(rs.next()){
			nickName = rs.getString(1);
			
			psmt.close();
			rs.close();
			
			psmt = con.prepareStatement(selectLikeCnt);
			psmt.setString(1, nickName);
			rs = psmt.executeQuery();
			if(rs.next()){
				cnt = rs.getInt(1);
				if(cnt == 0 ){return null;}
				musicId = new int[cnt];
				music = new MusicVO[cnt];
				
				psmt = con.prepareStatement(selectLike);
				psmt.setString(1,nickName);
				rs = psmt.executeQuery();
				for(int i=0;i<cnt;i++)
				{
					rs.next();
					musicId[i] = rs.getInt(1);
				}
				
				psmt = con.prepareStatement(selectMusic);
				rs = psmt.executeQuery();
				for(int i=0;i<cnt;i++)
				{
					rs.next();
					music[i] = new MusicVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
							rs.getInt(6), rs.getDate(7).toString(), rs.getInt(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getInt(12), Boolean.parseBoolean(rs.getString(13)), Boolean.parseBoolean(rs.getString(14)) );
				}
				
				return music;
			}
		
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		return null;
	}
	
	/**곡 상세 페이지에서 곡을 좋아요한 사람들의 정보들을 보여주기 위해서 Member[]을 반환하는 메소드*/
	public MemberVO[] searchLikeMusic(int musicId){
		return null;
	}

	public int deleteMusic(int musicId){
		String delete = "DELETE FROM music_tb WHERE music_id = "+ musicId;
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		try{
			psmt = con.prepareStatement(delete);
			psmt.executeUpdate();
			return musicId;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return -1;
	}
	
	public int deleteMusic(int fileId, int flag){
		String select = "SELECT music_id FROM music_tb WHERE file_id = " + fileId; 
		String delete = "DELETE FROM music_tb WHERE music_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int musicId = -1;
		
		try{
			psmt = con.prepareStatement(select);
			rs = psmt.executeQuery();
			if(rs.next()){
				musicId = rs.getInt(1);
				psmt= con.prepareStatement(delete);
				psmt.setInt(1, musicId);
				psmt.executeUpdate();
				return musicId;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return -1;
	}
	
	public int[] deleteMusic(String memberId)
	{
		String select = "SELECT COUNT(*) FROM music_tb WHERE member_id = ?";
		String selectId = "SELECT music_id FROM music_tb WHERE member_id = ?";
		String delete = "DELETE FROM music_tb WHERE member_id = ?";
		int[] musicId = null;
		int cnt = -1;
		
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			psmt = con.prepareStatement(select);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				cnt = rs.getInt(1);
				musicId = new int[cnt];
				
				for(int i=0;i<cnt;i++){
					psmt = con.prepareStatement(selectId);
					psmt.setString(1, memberId);
					rs = psmt.executeQuery();
					musicId[i] = rs.getInt(1);
				}
				
				psmt = con.prepareStatement(delete);
				psmt.setString(1, memberId);
				psmt.executeUpdate();
				
				return musicId;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return null;
	}
	
	/***/
	public int deleteMusicTag(int musicId){
		String delete = "DELETE FROM tag_music_tb WHERE music_id = " + musicId;
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		
		try{
			psmt = con.prepareStatement(delete);
			psmt.executeUpdate();
			return musicId;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt);
		}
		return -1;
	}
	
	public int searchMusicFileId(int musicId){
		
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs=null;
		
		int fileId=-1;
		
		try{
			psmt = con.prepareStatement("select file_id from music_tb where music_id=?");
			psmt.setInt(1, musicId);
			rs=psmt.executeQuery();
			
			rs.next();
			
			fileId=rs.getInt("file_id");
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return fileId;
		
	}
}

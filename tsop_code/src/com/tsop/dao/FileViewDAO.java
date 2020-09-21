package com.tsop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsop.db.ConnectDB;
import com.tsop.vo.FileVO;

public class FileViewDAO {
	public int addFile(String fileName,String fileExtension, String memberId, int folderId, int fileSize, boolean fileImportant, String localFilePath, int playTime)
	{
		FileDAO dao = new FileDAO();
		int res = 0;
		res = dao.addFile(fileName, fileExtension, memberId, folderId, fileSize, fileImportant, localFilePath, playTime);
		return res;
	}
	public int updateFile(int fileId, String fileName){
		FileDAO dao = new FileDAO();
		int res = 0;
		res = dao.updateFile(fileId, fileName);
		return res;
	}
	public int updateFile(int fileId, int folderId){
		FileDAO dao = new FileDAO();
		int res = 0;
		res = dao.updateFile(fileId, folderId);
		return res;
	}
	
	public String searchFilePath(int fileId){
		FileDAO fileDAO = new FileDAO();
		String filePath = fileDAO.searchFilePath(fileId);
		return filePath;
	}

	
	public int updateFile(int fileId, boolean fileImportant){
		
		FileDAO dao = new FileDAO();
		int res = 0;
		res = dao.updateFile(fileId, fileImportant);
		return res;
		
	}
	public int deleteFile(int fileId){
		FileDAO dao = new FileDAO();
		int res = 0;
		res = dao.deleteFile(fileId);
		return res;
	}
	public int[] deleteFile(int folderId,int flag){
		FileDAO dao = new FileDAO();
		int res[] = null;
		res = dao.deleteFile(folderId, flag);
		return res;
	}
	public int[] deleteMemberFile(String memberId){
		FileDAO dao = new FileDAO();
		int res[] = null;
		res = dao.deleteMemberFile(memberId);
		return res;
	}
	public int deleteLocalFile(int localFileId){
		FileDAO dao = new FileDAO();
		int res = 0;
		res = dao.deleteLocalFile(localFileId);
		return res;
	}
	
	public Object[] searchFile(int fileId){
		String selectMusicFileCnt = "SELECT COUNT(*) FROM music_file_view WHERE file_id = ?";
		String selectMusicFile = "SELECT * FROM music_file_view WHERE file_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FileVO[] music = null;
		int cnt =-1;
		try{
				psmt = con.prepareStatement(selectMusicFileCnt);
				psmt.setInt(1, fileId);
				rs = psmt.executeQuery();
				if(rs.next()){
					cnt = rs.getInt(1);
				}
				
				ConnectDB.close(con, psmt, rs);
				
				music = new FileVO[cnt];
				psmt = con.prepareStatement(selectMusicFile);
				psmt.setInt(1, fileId);
				rs = psmt.executeQuery();
				int index = 0;
				while(rs.next()){
					music[index] = new FileVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11) );
					return music;
				}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return music;
		
	}
	
	public Object[] searchFolderFiles(int folderId, String memberId){
		String selectMusicFileCnt = "SELECT COUNT(*) FROM music_file_view WHERE super_folder_id = ?";
		String selectMusicFile = "SELECT * FROM music_file_view WHERE super_folder_id = ? AND member_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FileVO[] music = null;
		int cnt =-1;
		try{
				psmt = con.prepareStatement(selectMusicFileCnt);
				psmt.setInt(1, folderId);
				rs = psmt.executeQuery();
				if(rs.next()){
					cnt = rs.getInt(1);
					music = new FileVO[cnt];
						
					}
			ConnectDB.close(con, psmt, rs);
			con = ConnectDB.connect();
			psmt = con.prepareStatement(selectMusicFile);
			psmt.setInt(1, folderId);
			psmt.setString(2, memberId);
			rs = psmt.executeQuery();
			int index = 0;
			while(rs.next()) {
				music[index++] = new FileVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11) );
			}
		return music;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return music;
	}
	
	public FileVO searchLocalFile(int localFileId){
		String selectLocalFile = "SELECT file_id FROM file_tb WHERE local_file_id = ?";
		String selectMusicFile = "SELECT * FROM music_file_view WHERE file_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FileVO music = null;
		int fileId = 0;
		try{
			psmt = con.prepareStatement(selectLocalFile);
			psmt.setInt(1, localFileId);
			rs = psmt.executeQuery();
			rs.next();
			fileId = rs.getInt(1);
			if(fileId == 0){
				return null;
			}
			psmt = con.prepareStatement(selectMusicFile);
			psmt.setInt(1, fileId);
			rs = psmt.executeQuery();
			rs.next();
			music = new FileVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11) );
			
			return music;
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		return null;
	}
	
	public Object[] searchMemberFile(String memberId){
		String selectMusicFileCnt = "SELECT COUNT(*) FROM music_file_view WHERE member_id = ?";
		String selectMusicFile = "SELECT * FROM music_file_view WHERE member_id = ?";
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		FileVO[] music = null;
		int cnt =-1;
		try{
				psmt = con.prepareStatement(selectMusicFileCnt);
				psmt.setString(1, memberId);
				rs = psmt.executeQuery();
				if(rs.next()){
					cnt = rs.getInt(1);
					music = new FileVO[cnt];
					psmt = con.prepareStatement(selectMusicFile);
					psmt.setString(1, memberId);
					rs = psmt.executeQuery();
					for(int i=0;i<cnt;i++){
						rs.next();
						music[i] = new FileVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11) );
						
					}
				}
				return music;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			ConnectDB.close(con, psmt, rs);
		}
		
		return music;
	}
	
	public Object[] searchFileName(String keyName){
		String selectFileName = "SELECT * FROM music_file_view WHERE file_name like ? ";
		List<FileVO> list = new ArrayList<FileVO>();
		Connection con = ConnectDB.connect();
		PreparedStatement psmt= null;
		ResultSet rs = null;
		FileVO music = null;
		try{
			psmt = con.prepareStatement(selectFileName);
			psmt.setString(1,"%" + keyName + "%");
			rs = psmt.executeQuery();
			while(rs.next()){
				music = new FileVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getBoolean(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11) );
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
	
	public void load(){
		
	}
	private FileVO add(FileVO obj){
		
		return null;
	}
	private FileVO update(int fileId, String fileName){
		return null;
	}
	private FileVO update(int fileId, int folderId){
		return null;
	}
	private FileVO update(int fileId, boolean fileImportant){
		return null;
	}
	private FileVO delete(int fileId){
		return null;
	}
	private FileVO delete(int folderId, int flag){
		return null;
	}
	private FileVO delete(String memberId){
		return null;
	}
	private FileVO deleteCLocalFile(int localFileId){
		return null;
	}
	private FileVO search(int fileId){
		return null;
	}
	private FileVO[] search(int folderId, int flag){
		return null;
	}
	private FileVO[] search(String memberId){
		return null;
	}
	
	private FileVO searchCLocalFile(String localFileId){
		return null;
	}
	private FileVO[] searchFileName(String keyName,int flg){
		return null;
	}
	public void save(){
		
	}
}

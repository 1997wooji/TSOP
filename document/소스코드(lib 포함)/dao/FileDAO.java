package com.tsop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import com.tsop.db.ConnectDB;



public class FileDAO {
	
	private int generateId(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int max = 0;
		try{
			conn=ConnectDB.connect();
			pstmt=conn.prepareStatement("select max(file_id) from file_tb");
			
			rs=pstmt.executeQuery();
			if(rs.next()){
				max = rs.getInt(1) + 1;
			}
		}
		catch(Exception e){
			System.out.println("오류발생");
		}
		finally{
			ConnectDB.close(conn,pstmt,rs);
		}
		return max;
	}
	
	public int addFile(String fileName, String fileExtension, String memberId, int folderId, int fileSize, boolean fileImportant, String localFilePath, int playTime)
	{
		int fileId = generateId();
		int rVal1 = addFile(fileId, fileName, fileExtension, memberId,folderId, fileSize, localFilePath);
		if(rVal1 == 0){
			return 0;
		}else{
			int rVal2 = addMediaFile(fileId,playTime);
			if(rVal2 == 0){
				return 0;
			}else{
				int rVal3 = addFileImportant(fileId, fileImportant);
				if(rVal3 == 0){
					return 0;
				}
			}
		}
		return fileId;
	}
	public int addFile(int fileId, String fileName, String fileExtension, String memberId, int folderId, int fileSize, String localFilePath){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int localFileId = generateLocalId();
		try{
			conn=ConnectDB.connect();
			if(conn!=null){
				pstmt=conn.prepareStatement("insert into local_file_tb(local_file_id,local_file_path) values(?,?)");
				pstmt.setInt(1, localFileId);
				pstmt.setString(2, localFilePath);

				System.out.println("??1");
				pstmt.executeUpdate();
				
				pstmt=conn.prepareStatement("insert into file_tb(file_id, file_name, file_extension, file_upload_date, file_size, folder_id, member_id, local_file_id) values(?,?,?,sysdate,?,?,?,?)");
				pstmt.setInt(1, fileId);
				pstmt.setString(2, fileName);
				pstmt.setString(3, fileExtension);
				pstmt.setInt(4, fileSize);
				pstmt.setInt(5, folderId);
				pstmt.setString(6, memberId);
				pstmt.setInt(7, localFileId);
				pstmt.executeUpdate();
				System.out.println("??2");
				return fileId;
			}
		}
		catch(SQLException e){
			System.out.println("SQL 에러");
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	
	public int addMediaFile(int fileId, int playTime){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=ConnectDB.connect();
			if(conn!=null){
				
				pstmt=conn.prepareStatement("INSERT INTO media_file_tb (file_id, file_play_time) VALUES (?, ?)");
				pstmt.setInt(1, fileId);
				pstmt.setInt(2, playTime);
				pstmt.executeUpdate();
				return fileId;
			}
		}
		catch(SQLException e){
			System.out.println("SQL 에러");
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	public int addFileImportant(int fileId, boolean fileImportant){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=ConnectDB.connect();
			if(conn!=null){
				
				pstmt=conn.prepareStatement("insert into important_file_tb(file_id,file_important) values(?,?)");
				pstmt.setInt(1, fileId);
				pstmt.setBoolean(2, fileImportant);
				pstmt.executeUpdate();
				return fileId;
			}
		}
		catch(SQLException e){
			System.out.println("SQL 에러");
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	public int updateFile(int fileId, String fileName){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=ConnectDB.connect();
			pstmt=conn.prepareStatement("update file_tb set file_name=? where file_id=?");
			pstmt.setString(1,fileName);
			pstmt.setInt(2,fileId);
			pstmt.executeUpdate();
			return fileId;
		}
		catch(Exception e){
			System.out.println("���� �߻�");
			
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	public int updateFile(int fileId, int folderId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=ConnectDB.connect();
			pstmt=conn.prepareStatement("update file_tb set folder_id=? where file_id=?");
			pstmt.setInt(1,folderId);
			pstmt.setInt(2,fileId);
			pstmt.executeUpdate();
			return fileId;
		}
		catch(Exception e){
			System.out.println("sql 오류");
			
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	public int updateFile(int fileId, boolean fileImportant){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=ConnectDB.connect();
			pstmt=conn.prepareStatement("update important_file_tb set file_important=? where file_id=?");
			pstmt.setBoolean(1,fileImportant);
			pstmt.setInt(2,fileId);
			pstmt.executeUpdate();
			return fileId;
		}
		catch(Exception e){
			System.out.println("sql 오류");
			
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	public int deleteFile(int fileId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		
		try{
			conn=ConnectDB.connect();
			pstmt=conn.prepareStatement("delete from file_tb where file_id=?");
			pstmt.setInt(1,fileId);
			pstmt.executeUpdate();
			return fileId;
		}
		catch(Exception e){
			System.out.println("sql 오류");
			
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	public int[] deleteFile(int folderId, int flag){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		int fileIds[] = null;
		int cnt = -1;
		
		try{
			
				conn=ConnectDB.connect();
				pstmt=conn.prepareStatement("SELECT COUNT(*) FROM file_tb WHERE folder_id = ?");
				pstmt.setInt(1, folderId);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					cnt = rs.getInt(1);
					fileIds = new int[cnt];
					
					pstmt=conn.prepareStatement("select file_id from file_tb where folder_id=?");
					pstmt.setInt(1,folderId);
					rs=pstmt.executeQuery();
					for(int i=0;i<cnt;i++)
					{
						if(rs.next()){
							fileIds[i] = rs.getInt(1);
							System.out.println(fileIds[i]);
						}
						
					}
					
				}
				pstmt=conn.prepareStatement("delete from folder_tb where folder_id=?");
				pstmt.setInt(1,folderId);
				pstmt.executeUpdate();
				
				return fileIds;
			}
			
		
		catch(Exception e){
			System.out.println("sql 오류");
			
		}
		finally{
			ConnectDB.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int deleteFileMedia(int fileId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		
		try{
			conn=ConnectDB.connect();
			pstmt=conn.prepareStatement("delete from media_file_tb where file_id=?");
			pstmt.setInt(1,fileId);
			pstmt.executeUpdate();
			
			return fileId;
		}
		catch(Exception e){
			System.out.println("sql 오류");
			
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	public int deleteFileImportant(int fileId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			conn=ConnectDB.connect();
			pstmt=conn.prepareStatement("delete from important_file_tb where file_id=?");
			pstmt.setInt(1,fileId);
			pstmt.executeUpdate();
			
			return fileId;
		}
		catch(Exception e){
			System.out.println("sql 오류");
			
		}
		finally{
			ConnectDB.close(conn,pstmt);
		}
		return 0;
	}
	public int[] deleteMemberFile(String memberId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		int fileIds[] = null;
		int cnt = -1;
		
		try{
				conn=ConnectDB.connect();
				pstmt=conn.prepareStatement("SELECT COUNT(*) FROM file_tb WHERE member_id = ?");
				pstmt.setString(1, memberId);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					cnt = rs.getInt(1);
					fileIds = new int[cnt];
					
					pstmt=conn.prepareStatement("select file_id from file_tb where member_id=?");
					pstmt.setString(1,memberId);
					rs=pstmt.executeQuery();
					for(int i=0;i<cnt;i++)
					{
						if(rs.next()){
							fileIds[i] = rs.getInt(1);
						}
					}
					
				}
				pstmt=conn.prepareStatement("delete from file_tb where member_id=?");
				pstmt.setString(1,memberId);
				pstmt.executeUpdate();
				
				return fileIds;
			}
			
		
		catch(Exception e){
			System.out.println("sql 오류");
			
		}
		finally{
			ConnectDB.close(conn, pstmt, rs);
		}
		return null;
	}
	public int deleteLocalFile(int localFileId){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int fileId = 0;
		try{
			conn=ConnectDB.connect();
			
			pstmt = conn.prepareStatement("select file_id from file_tb where local_file_id=?");
			pstmt.setInt(1,localFileId);
			rs=pstmt.executeQuery();
			rs.next();
			fileId = rs.getInt(1);
			pstmt=conn.prepareStatement("delete from file_tb where file_id=?");
			pstmt.setInt(1,fileId);
			pstmt.executeUpdate();
			System.out.println("22");
			
			pstmt=conn.prepareStatement("delete from local_file_tb where local_file_id=?");
			pstmt.setInt(1,localFileId);
			pstmt.executeUpdate();
			
			
			return fileId;
		}
		catch(Exception e){
			System.out.println("sql 오류");
			
		}
		finally{
			ConnectDB.close(conn, pstmt, rs);
		}
		return fileId;
	}
	
	private int generateLocalId(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int max = 0;
		try{
			conn=ConnectDB.connect();
			pstmt=conn.prepareStatement("select max(local_file_id) from local_file_tb");
			
			rs=pstmt.executeQuery();
			if(rs.next()){
				max = rs.getInt(1) + 1;
			}
		}
		catch(Exception e){
			System.out.println("오류발생");
		}
		finally{
			ConnectDB.close(conn,pstmt,rs);
		}
		return max;
	}
	
	
}

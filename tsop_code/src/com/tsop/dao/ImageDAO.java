package com.tsop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tsop.db.ConnectDB;
import com.tsop.vo.ImageVO;

public class ImageDAO {
	
/*	public static void main(String[] args){
		ImageDAO dao=new ImageDAO();
		System.out.println(dao.addImage("\\image\\member\\20.png"));
		System.out.println(dao.deleteImage(32));
		System.out.println(dao.searchimage(31).toString());
	}*/
	
	private static int generateId(){
		String select = "SELECT MAX(image_id) as max FROM image_tb";
		Connection con = null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		int imageId = -1;
		
		try{
			con = ConnectDB.connect();
			psmt = con.prepareStatement(select);
			rs = psmt.executeQuery();
			rs.next();
			
			imageId = rs.getInt("max");
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			return -1;
		}
		finally{
			ConnectDB.close(con, psmt);
		}
		return imageId+1;
	}
	
	public int addImage(String imagePath){
		if(imagePath == null || imagePath.equals("")){return -1;}
		String insert = "INSERT INTO image_tb (image_id, image_path) values(?,?)";
		
		int imageId = generateId();
		
		Connection con = null;
		PreparedStatement psmt=null;
		if(imageId == -1){return -1;}
		
		try{
			con = ConnectDB.connect();
			psmt = con.prepareStatement(insert);
			psmt.setInt(1, imageId);
			psmt.setString(2, imagePath);
			psmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
			
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return imageId;
	}
	
	public int updateImage(int imageId, String newImagePath){
		String update ="UPDATE image_tb SET image_path = ? WHERE image_id = "+imageId;
		Connection con = ConnectDB.connect();
		PreparedStatement psmt = null;
		
		try{
			psmt = con.prepareStatement(update);
			psmt.setString(1, newImagePath);
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
		
		return imageId;
	}
	
	public int deleteImage(int imageId){
		if(imageId < 0 ){return -1;}
		String delete = "DELETE FROM image_tb WHERE image_id = ?";
		Connection con = null;
		PreparedStatement psmt=null;
		try{
			con = ConnectDB.connect();
			 psmt = con.prepareStatement(delete);
			psmt.setInt(1, imageId);
			psmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}finally{
			ConnectDB.close(con, psmt);
		}
		
		return imageId;
	}
	
	public ImageVO searchimage(int imageId){
		if(imageId < 0 ){return null;}
		String select = "SELECT * FROM image_tb WHERE image_id ="+ imageId;
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		ImageVO vo=null;
		
		try{
			con = ConnectDB.connect();
			psmt = con.prepareStatement(select);
			rs = psmt.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			String imagePath = rs.getString(2);
			vo = new ImageVO(id, imagePath);
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			ConnectDB.close(con, psmt,rs);
		}
		
		return vo;
	}
	
	/**
  	������ �����ϸ� image_tb �����͸� �÷��ǿ� �����ϱ� ���� �޼ҵ�*/
	public boolean load(){
		
		return false;
	}
	/**
	 addImage�޼ҵ� ���ο��� �÷��ǿ� �Ķ���ͷ� ���� ������ ��ġ�ϴ� ��ü�� ���ٸ� DB�� �Է¹��� image ������ �߰��ϰ� �÷��ǿ� ����ȭ �ϱ� ���� add�޼ҵ�*/
	private ImageVO add(ImageVO obj){
		return null;
	}
	
	/**
	 updateImage�޼ҵ� ���ο��� �÷��ǿ� �Ķ���ͷ� ���� ������ ��ġ�ϴ� ��ü�� ���ٸ� DB�� �Է¹��� image ������ �����ϰ� �÷��ǿ� ����ȭ �ϱ� ���� update�޼ҵ�*/
	private ImageVO update(ImageVO obj){
		return null;
	}
	 
	/**
	 DB�� �Է¹��� image ������ ��ġ�ϴ� �����͸� �����ϰ� �÷��ǿ� ����ȭ �ϱ� ���� delete�޼ҵ�*/
	private ImageVO delete(int imageId){
		return null;
	}
	
	/**
	 DB�� �Է¹��� image ������ ��ġ�ϴ� �����͸� �����ϰ� �÷��ǿ� ����ȭ �ϱ� ���� delete�޼ҵ�*/
	private ImageVO delete(String imagePath){		
		return null;
	}
	
	/**�÷��ǿ� ����� ������ DB�� �����ϱ� ���� �޼ҵ�*/
	public boolean save(){
		return false;
	}

}

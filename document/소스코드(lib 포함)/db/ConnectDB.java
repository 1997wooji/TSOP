package com.tsop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection connect(){
		String conStr = "jdbc:oracle:thin:@192.168.30.14:1521:xe";
		String user = "tsop";
		String pass = "8650";
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(conStr, user, pass);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet res){
		try {
			
			if(res!=null) res.close();
			close(con,pstmt);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection con, PreparedStatement pstmt) {
		try{
			pstmt.execute("commit");
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
}

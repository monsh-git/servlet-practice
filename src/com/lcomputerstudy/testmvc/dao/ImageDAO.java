package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lcomputerstudy.testmvc.database.DBConnection;
import com.lcomputerstudy.testmvc.vo.Image;

public class ImageDAO {
	private static ImageDAO dao = null;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = null;
	
	private ImageDAO() {
		
	}
	
	public static ImageDAO getInstance() {
		if(dao == null) {
			dao = new ImageDAO();
		}
		return dao;
	}
	
	public Image getImage(int b_idx) {
		Image image = new Image();
		
		return image;
	}
	
	public void insertImage(String i_name, String i_real_name) {

		try {
			conn = DBConnection.getConnection();
			query = "INSERT INTO image(i_name, i_real_name) VALUES(?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, i_name);
			pstmt.setString(2, i_real_name);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

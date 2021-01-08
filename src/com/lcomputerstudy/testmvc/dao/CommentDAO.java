package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lcomputerstudy.testmvc.database.DBConnection;
import com.lcomputerstudy.testmvc.vo.Comment;

public class CommentDAO {
	private static CommentDAO dao = null;
	
	private CommentDAO() {
		
	}
	
	Comment comment;
	ArrayList<Comment> comments;
	
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    String query;

	public static CommentDAO getInstance() {
		if(dao == null) {
			dao = new CommentDAO();
		}
		return dao;
	}
	
	public void writeComment(Comment comment) {
		
		try {
			conn = DBConnection.getConnection();
			query = "INSERT INTO comment(b_idx, u_idx, c_content) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, comment.getB_idx());
			pstmt.setInt(2, comment.getU_idx());
			pstmt.setString(3, comment.getC_content());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("SQLException : " + e.getMessage());
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

package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lcomputerstudy.testmvc.database.DBConnection;
import com.lcomputerstudy.testmvc.vo.Board;
import com.lcomputerstudy.testmvc.vo.Comment;

public class BoardDAO {
	private static BoardDAO dao = null;
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query = null;
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public ArrayList<Board> getBoards(){
		ArrayList<Board> list = null;
		
		try {
			conn = DBConnection.getConnection();
			
			query = "SELECT * FROM board ORDER BY b_origin DESC, b_group_idx ASC";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			list = new ArrayList<Board>();
			
			while(rs.next()) {
				Board board = new Board();
				board.setB_idx(rs.getInt("b_idx"));
				
				board.setB_content(rs.getString("b_content"));
				board.setB_date(rs.getString("b_date"));
				board.setB_writer(rs.getString("b_writer"));
				board.setU_idx(rs.getInt("u_idx"));
				board.setB_origin(rs.getInt("b_origin"));
				board.setB_group_idx(rs.getInt("b_group_idx"));
				board.setB_layer_idx(rs.getInt("b_layer_idx"));
				
				String reStr = "";
				for(int i = 0; i < board.getB_layer_idx(); i++) {
					reStr = reStr + "RE : ";
				}
				board.setB_title(reStr + rs.getString("b_title"));
				list.add(board);
			}
		} catch (Exception e) {
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public Board getBoard(String b_idx) {
		Board board = null;
		
		try {
			conn = DBConnection.getConnection();
			
			query = "SELECT * FROM board WHERE b_idx=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();
			
			board = new Board();
			if(rs.next()) {
				board.setB_idx(rs.getInt("b_idx"));
				board.setB_title(rs.getString("b_title"));
				board.setB_content(rs.getString("b_content"));
				board.setB_date(rs.getString("b_date"));
				board.setB_writer(rs.getString("b_writer"));
				board.setU_idx(rs.getInt("u_idx"));
				board.setB_origin(rs.getInt("b_origin"));
				board.setB_group_idx(rs.getInt("b_group_idx"));
				board.setB_layer_idx(rs.getInt("b_layer_idx"));
			}
			
			query = "SELECT count(*) FROM comment WHERE b_idx=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getB_idx());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setB_c_count(rs.getInt(1));
			}
			
		} catch (Exception e) {
			e.setStackTrace(null);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return board;
	}
	
	public void insertBoard(Board board) {
		
		try {
			conn = DBConnection.getConnection();
			query = "INSERT INTO board(b_title, b_content, b_date, b_writer, u_idx, b_origin, b_group_idx, b_layer_idx) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setString(3, board.getB_date());
			pstmt.setString(4, board.getB_writer());
			pstmt.setInt(5, board.getU_idx());
			pstmt.setInt(6, 0);
			pstmt.setInt(7, board.getB_group_idx());
			pstmt.setInt(8, board.getB_layer_idx());
			pstmt.executeUpdate();
			
			query = "SELECT @last_b_idx := MAX(b_idx) FROM board";
			pstmt = conn.prepareStatement(query);
			pstmt.executeQuery();
			
			query = "UPDATE board SET b_origin = @last_b_idx WHERE b_idx = @last_b_idx";
			pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
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
	
	public void editBoard(Board board) {
		
		try {
			conn = DBConnection.getConnection();
			query = "UPDATE board SET b_title=?, b_content=? WHERE b_idx=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setInt(3, board.getB_idx());
			pstmt.executeUpdate();
		} catch (Exception e) {
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
	
	public void deleteBoard(String b_idx) {
		
		try {
			conn = DBConnection.getConnection();
			query = "DELETE FROM board WHERE b_idx=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b_idx);
			pstmt.executeUpdate();
		} catch (Exception e) {
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
	
	public void replyBoard(Board board) {
		
		try {
			conn = DBConnection.getConnection();

			if(board.getB_group_idx() == 0) {
				query = "UPDATE board SET b_group_idx = b_group_idx+1 WHERE b_origin = ? AND b_group_idx > ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, board.getB_origin());
				pstmt.setInt(2, board.getB_group_idx());
				pstmt.executeUpdate();
			}
			
			query = "INSERT INTO board(b_title, b_content, b_date, b_writer, u_idx, b_origin, b_group_idx, b_layer_idx) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getB_title());
			pstmt.setString(2, board.getB_content());
			pstmt.setString(3, board.getB_date());
			pstmt.setString(4, board.getB_writer());
			pstmt.setInt(5, board.getU_idx());
			pstmt.setInt(6, board.getB_origin());
			if(board.getB_group_idx() == 0) {
				pstmt.setInt(7, board.getB_group_idx()+1);
			} else {
				pstmt.setInt(7, board.getB_group_idx());
			}
			pstmt.setInt(8, board.getB_layer_idx()+1);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
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
	
	public ArrayList<Comment> getComments(String b_idx){
		
		Comment comment = null;
		ArrayList<Comment> c_list = null;
		
		try {
			conn = DBConnection.getConnection();
			query = "SELECT * FROM comment WHERE b_idx=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b_idx);
			rs = pstmt.executeQuery();
			c_list = new ArrayList<Comment>();
			
			while(rs.next()) {
				comment = new Comment();
				comment.setC_idx(rs.getInt("c_idx"));
				comment.setB_idx(rs.getInt("b_idx"));
				comment.setU_idx(rs.getInt("u_idx"));
				comment.setC_content(rs.getString("c_content"));
				comment.setC_date(rs.getDate("c_date"));
				c_list.add(comment);
			}
			
		} catch(Exception e) {
			System.out.println("Exception on getComments : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return c_list;
	}
}

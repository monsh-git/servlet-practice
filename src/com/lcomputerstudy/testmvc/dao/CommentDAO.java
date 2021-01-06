package com.lcomputerstudy.testmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    StringBuffer query;

	public static CommentDAO getInstance() {
		if(dao == null) {
			dao = new CommentDAO();
		}
		return dao;
	}
	
	
	
}

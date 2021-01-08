package com.lcomputerstudy.testmvc.service;

import com.lcomputerstudy.testmvc.dao.CommentDAO;
import com.lcomputerstudy.testmvc.vo.Comment;

public class CommentService {
	private static CommentService service = null;
	private static CommentDAO dao = null;
	
	private CommentService() {
		
	}
	
	public static CommentService getInstance() {
		if(service == null) {
			service = new CommentService();
			dao = CommentDAO.getInstance();
		}
		return service;
	}
	
	public void writeComment(Comment comment) {
		dao.writeComment(comment);
	}
}

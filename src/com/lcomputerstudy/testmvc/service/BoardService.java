package com.lcomputerstudy.testmvc.service;

import java.util.ArrayList;

import com.lcomputerstudy.testmvc.dao.BoardDAO;
import com.lcomputerstudy.testmvc.vo.Board;
import com.lcomputerstudy.testmvc.vo.User;

public class BoardService {
	
	private static BoardService service = null;
	private static BoardDAO dao = null;
	
	private BoardService() {
		
	}
	
	public static BoardService getInstance() {
		if(service == null) {
			service = new BoardService();
			dao = BoardDAO.getInstance();
		}
		return service;
	}
	
	public ArrayList<Board> getBoards() {
		return dao.getBoards();
	}
	
	public Board getBoard(String b_idx) {
		return dao.getBoard(b_idx);
	}
	
	public void insertBoard(Board board) {
		dao.insertBoard(board);
	}
	
	public void editBoard(Board board) {
		dao.editBoard(board);
	}
	
	public void deleteBoard(String b_idx) {
		dao.deleteBoard(b_idx);
	}
	
	public void replyBoard(Board board) {
		dao.replyBoard(board);
	}
}

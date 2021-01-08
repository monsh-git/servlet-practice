package com.lcomputerstudy.testmvc.vo;

import com.lcomputerstudy.testmvc.service.BoardService;

public class BoardPagination {
	int boardCount;
	int page;
	int pageNum;
	int startPage;
	int endPage;
	int lastPage;
	int prevPage;
	int nextPage;
	public static final int pageUnit = 5;
	public static final int perPage = 10;
	BoardService boardService = null;
	
	public BoardPagination() {
		
	}
	
	public BoardPagination(int page) {
		this.page = page;
		boardService = BoardService.getInstance();
		boardCount = boardService.getBoardsCount();
		startPage = ((page-1)/pageUnit) * pageUnit + 1;
		lastPage = (int)Math.ceil(boardCount / (float)perPage);
		endPage = startPage + pageUnit - 1;
		endPage = endPage < lastPage ? endPage : lastPage;
		prevPage = (startPage - 1);
		nextPage = (startPage + pageUnit);
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public BoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
}

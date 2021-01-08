package com.lcomputerstudy.testmvc.vo;

import com.lcomputerstudy.testmvc.service.UserService;

public class UserPagination {
	int userCount;
	int page;
	int pageNum;
	int startPage;
	int endPage;
	int lastPage;
	int prevPage;
	int nextPage;
	public static final int pageUnit=5;
	public static final int perPage=3;
	UserService userService = null;
	
	public UserPagination() {
		
	}
	
	public UserPagination(int page) {
		this.page = page;
		userService = UserService.getInstance();
		userCount = userService.getUsersCount();
		startPage = ((page-1)/pageUnit) * pageUnit + 1;
		lastPage = (int)Math.ceil(userCount / (float)perPage);
		endPage = startPage + pageUnit - 1;
		endPage = endPage < lastPage ? endPage : lastPage;
		prevPage = (startPage - 1);
		nextPage = (startPage + pageUnit);
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public static int getPageunit() {
		return pageUnit;
	}

	public static int getPerpage() {
		return perPage;
	}
}

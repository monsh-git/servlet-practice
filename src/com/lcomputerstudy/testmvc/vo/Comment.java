package com.lcomputerstudy.testmvc.vo;

import java.util.Date;

public class Comment {
	private int c_idx;
	private int b_idx;
	private int u_idx;
	private String c_content;
	private Date c_date;
	
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	
	@Override
	public String toString() {
		return "Comment [c_idx=" + c_idx + ", b_idx=" + b_idx + ", u_idx=" + u_idx + ", c_content=" + c_content
				+ ", c_date=" + c_date + "]";
	}
}

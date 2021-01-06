package com.lcomputerstudy.testmvc.vo;

public class Board {
	private int b_idx;
	private String b_title;
	private String b_content;
	private String b_date;
	private String b_writer;
	private int u_idx;
	private int b_origin;		// the idx of an origin board
	private int b_group_idx;	// an index in a group
	private int b_layer_idx;	// an index of layer in a group
	private int b_c_count;
	
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public int getB_origin() {
		return b_origin;
	}
	public void setB_origin(int b_origin) {
		this.b_origin = b_origin;
	}
	public int getB_group_idx() {
		return b_group_idx;
	}
	public void setB_group_idx(int b_group_idx) {
		this.b_group_idx = b_group_idx;
	}
	public int getB_layer_idx() {
		return b_layer_idx;
	}
	public void setB_layer_idx(int b_layer_idx) {
		this.b_layer_idx = b_layer_idx;
	}
	public int getB_c_count() {
		return b_c_count;
	}
	public void setB_c_count(int b_c_count) {
		this.b_c_count = b_c_count;
	}
	
}
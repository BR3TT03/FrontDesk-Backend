package com.example.demo.model;

import java.sql.Date;

public class RecentlyVisited {
	private int id;
	private String name;
	private boolean view;
	private String remark;
	private Date date;
	public RecentlyVisited(int id, String name, boolean view, String remark, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.view = view;
		this.remark = remark;
		this.date = date;
	}
	public RecentlyVisited() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isView() {
		return view;
	}
	public void setView(boolean view) {
		this.view = view;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}

package com.example.demo.model;

import java.sql.Date;

public class Reminder {
	private int id;
	private String task;
	private Date date;
	private String status;
	public Reminder(int id, String task, Date date, String status) {
		super();
		this.id = id;
		this.task = task;
		this.date = date;
		this.status = status;
	}
	public Reminder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}

package com.KeepinItSimpleApps;

import java.sql.Date;

public class Entry {

	private String text;
	private Date time;
	
	public Entry(String text, Date time) {
		this.text = text;
		this.time = time;
	}
	
	public Entry() {
		this.text = null;
		this.time = null;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}

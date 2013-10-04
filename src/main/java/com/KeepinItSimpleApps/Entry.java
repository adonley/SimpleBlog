package com.KeepinItSimpleApps;

import java.sql.Time;
import java.sql.Timestamp;

public class Entry {

	private String text;
	private Timestamp time;
	
	public Entry(String text, Timestamp time) {
		this.text = text;
		this.time = time;
	}
	
	public Entry(String text) {
		this.text = text;
		java.util.Date today = new java.util.Date();
		long time = today.getTime();
		Timestamp sqlToday = new Timestamp(time);
		this.time = sqlToday;
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}

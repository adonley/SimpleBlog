package com.KeepinItSimpleApps;

import java.sql.Timestamp;

public class Entry {

	private String text;
	private Timestamp time;
	
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

package com.KeepinItSimpleApps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Persistance {
	
	private Connection conn = null;
	private String initDB = "CREATE DATABASE IF NOT EXISTS blog";
	private String initTable = "CREATE TABLE IF NOT EXISTS entries_tbl(entry_id INT NOT NULL AUTO_INCREMENT, entry VARCHAR(500), submission_date DATE,  PRIMARY KEY ( entry_id ))";
	private Statement stmt = null;
	
	public List<Entry> updateEntryList() throws SQLException {
		
		List<Entry> list = new ArrayList<Entry>();
		stmt = conn.createStatement();
		//stmt.executeQuery(initDB);
		//stmt.executeQuery("use blog");
		stmt.executeQuery(initTable);
		ResultSet rs = stmt.executeQuery("SELECT * FROM entries_tbl");
		while(rs.next()) {
			list.add(new Entry(rs.getString("entry"),rs.getDate("submission_date")));
		}
		
		return list;
		
	}
	
	public void updateEntryList(List <Entry> list) throws SQLException {
		
		Entry tempEntry;
		stmt = null;
		stmt = conn.createStatement();
		stmt.executeUpdate("TRUNCATE TABLE entries_tbl");
		Iterator<Entry> it = list.iterator();
		while(it.hasNext()) {
			tempEntry = it.next();
			stmt.executeUpdate("INSERT INTO entries_tbl (entry , submission_date) VALUES (" + tempEntry.getText() + "," + 
					tempEntry.getTime() +")");
		}
		
		return;
		
	}
	
	public void getConnection() throws SQLException {
	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/blog","root","67bah67");
	}
	
	public void closeConnection() throws SQLException {
		
		if(conn != null)
			conn.close();
		
	}
	
}
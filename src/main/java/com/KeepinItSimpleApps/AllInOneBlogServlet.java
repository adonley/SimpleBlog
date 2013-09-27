package com.KeepinItSimpleApps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class AllInOneBlogServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(getClass());
	
	// All of this should be in a different class, but this is simple enough to stay here for now.
	private String userName = "root";
	private String password = "67bah67";
	private String dbms = "mysql";
	private String dbName = "blog";
	private String serverName = "127.0.0.1";
	private String portNumber = "3306";
	private Connection conn;
	private String initDB = "CREATE DATABASE IF NOT EXISTS blog;";
	private String initTable = "CREATE TABLE IF NOT EXISTS entries_tbl(entry_id INT NOT NULL AUTO_INCREMENT, "
			+ "entry VARCHAR(500), submission_date DATE,  PRIMARY KEY ( entry_id ));";
	private Statement stmt = null;
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			List<Entry> entries = new ArrayList<Entry>();
			
			getConnection();
				
			closeConnection();
			
			request.setAttribute("entries", entries);

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("my.vm");
			requestDispatcher.forward(request, response);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
	
	public void getConnection() throws SQLException {

	    conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

	    conn = DriverManager.getConnection("jdbc:" + this.dbms + "://" + this.serverName +
	    		":" + this.portNumber + "/",connectionProps);
	    
	    System.out.println("Connected to database");
	    return;
	}
	
	public void closeConnection() throws SQLException {
		if(conn != null)
			conn.close();
	}
	
	
}

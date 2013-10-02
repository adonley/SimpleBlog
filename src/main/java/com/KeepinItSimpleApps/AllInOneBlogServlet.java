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
	private Persistence db;
	
	// All of this should be in a different class, but this is simple enough to stay here for now.
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			db = new Persistence();
			db.getConnection();
			
			List<Entry> entries = new ArrayList<Entry>(db.updateEntryList());
			
			request.setAttribute("entries", entries);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("blog_layout.vm");
			requestDispatcher.forward(request, response);			
			
			//db.updateEntryList(entries);
			
			db.closeConnection();
			

		} catch (Exception ex) {
			logger.error(ex);
			System.out.println("SQLException: " + ex.getMessage());
		}
	}
	
	
}

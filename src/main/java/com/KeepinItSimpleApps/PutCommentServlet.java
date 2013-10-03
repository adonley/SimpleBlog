package com.KeepinItSimpleApps;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PutCommentServlet extends HttpServlet {

	private Persistence db;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			db = new Persistence();
			db.getConnection();
			
			ArrayList<Entry> entries = new ArrayList<Entry>(db.updateEntryList());
			entries.add(new Entry(request.getParameter("comments")));
			
			request.setAttribute("entries", entries);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("put_comment.vm");
			requestDispatcher.forward(request, response);			
			
			db.updateEntryList(entries);
			
			db.closeConnection();
			

		} catch (Exception ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
	}
}

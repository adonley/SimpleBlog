package com.KeepinItSimpleApps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class MyVelocityServlet extends HttpServlet {

	private Logger logger = Logger.getLogger(getClass());

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			List<Bean> beans = new ArrayList<Bean>();
			for (int i = 0; i < 5; i++) {
				Bean bean = new Bean("fv" + i, "lv" + i);
				beans.add(bean);
			}			
			request.setAttribute("beans", beans);
			request.setAttribute("list", beans);
			
			
			Bean publicFieldBean = new Bean();
			publicFieldBean.publicField = "public field";
			request.setAttribute("publicFieldBean", publicFieldBean);
			
			Bean bean = new Bean("fvn", "lvn");		
			request.setAttribute("bean", bean);
			

			Bean emptyBean = new Bean();
			request.setAttribute("emptyBean", emptyBean);
			
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("firstKey", "firstValue");
			map.put("lastKey", "lastValue");
			request.setAttribute("map", map);
			
			request.setAttribute("size", "100");

			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("my.vm");
			requestDispatcher.forward(request, response);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
}

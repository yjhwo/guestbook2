package com.estsoft.web;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		// 굳이 sendRedirect 할 필요 없는데 일관성 때문에 만들었다.
		response.sendRedirect(url);
	}
	
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException  {
		
		// forwarding(request 확장, request dispatcher)
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
}

package com.estsoft.guestbook.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estsoft.web.WebUtil;
import com.estsoft.web.action.Action;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
//		rd.forward(request, response);
		WebUtil.forward(request, response, "/WEB-INF/views/deleteform.jsp");
	}

}

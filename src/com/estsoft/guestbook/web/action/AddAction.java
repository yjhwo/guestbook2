package com.estsoft.guestbook.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estsoft.db.MySQLWebDBConnection;
import com.estsoft.guestbook.dao.GuestBookDAO;
import com.estsoft.guestbook.vo.GuestBookVO;
import com.estsoft.web.WebUtil;
import com.estsoft.web.action.Action;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");

		GuestBookVO vo = new GuestBookVO(name, password, content);
		GuestBookDAO dao = new GuestBookDAO(new MySQLWebDBConnection());
		dao.insert(vo);

//		response.sendRedirect("/guestbook2/gb");
		WebUtil.redirect(request, response, "/guestbook2/gb");
	}

}

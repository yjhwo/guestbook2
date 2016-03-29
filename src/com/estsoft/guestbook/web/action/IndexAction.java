package com.estsoft.guestbook.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estsoft.db.MySQLWebDBConnection;
import com.estsoft.guestbook.dao.GuestBookDAO;
import com.estsoft.guestbook.vo.GuestBookVO;
import com.estsoft.web.WebUtil;
import com.estsoft.web.action.Action;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GuestBookDAO dao = new GuestBookDAO(new MySQLWebDBConnection());
		List<GuestBookVO> list = dao.getList();

		// 포워딩전에 JSP로 보낼 데이터를 request범위(scope)에 저장한다.
		request.setAttribute("list", list);			
//		// forwarding(request 확장, request dispatcher)
		
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
//		rd.forward(request, response);
		
		WebUtil.forward(request, response, "/WEB-INF/views/index.jsp");
		
	}

}

package com.estsoft.guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estsoft.db.MySQLWebDBConnection;
import com.estsoft.guestbook.dao.GuestBookDAO;
import com.estsoft.guestbook.vo.GuestBookVO;

@WebServlet("/gb")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청데이터를 post방식의 한글(UTF-8)데이터 처리
		request.setCharacterEncoding("UTF-8");

		// 요청분석
		String actionName = request.getParameter("a");
		
		if ("add".equals(actionName)) { // 리스트에 추가

			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			GuestBookVO vo = new GuestBookVO(name, password, content);
			GuestBookDAO dao = new GuestBookDAO(new MySQLWebDBConnection());
			dao.insert(vo);

			response.sendRedirect("/guestbook2/gb");
			
		} else if ("deleteform".equals(actionName)) { // 삭제
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);

		} else if ("delete".equals(actionName)) {

			String no = request.getParameter("no");
			String password = request.getParameter("password");

			if (!no.equals(null)) { // no가 제대로 넘어온 경우에만 처리

				GuestBookDAO dao = new GuestBookDAO(new MySQLWebDBConnection());
				int chk = dao.delete(Integer.parseInt(no), password);

				if (chk > 0)
					response.sendRedirect("/guestbook2/gb");
				else{
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deletefail.jsp?no="+no);
					rd.forward(request, response);
					/*response.sendRedirect("/guestbook2/deletefail.jsp?no=" + no);*/
				}
			}

		} else { // default action(list, index action)

			GuestBookDAO dao = new GuestBookDAO(new MySQLWebDBConnection());
			List<GuestBookVO> list = dao.getList();

			// 포워딩전에 JSP로 보낼 데이터를 request범위(scope)에 저장한다.
			request.setAttribute("list", list);

			// forwarding(request 확장, request dispatcher)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}

		/*이해 가기 쉽게 말하자면★★★★★★
		보여줄 View가 있으면 forward,
		보여줄 View가 없으면 sendRedirect로 넘겨주면 된다!!!
		
		☆ sendRedirect : 현재 실행중인 JSP페이지의 실행을 중단하고 다른 웹 자원이 대신 호출되도록 만드는 기능
		파라미터로 지정한 URL을 직접 호출하는 것이 아니라,
		웹 브라우저에 메세지를 보내, 웹 브라우저가 URL을 가지고 웹 서버에 웹 자원을 다시 요청.
		
		☆ forward : JSP페이지 안에서 다른 JSP페이지를 호출할 때 사용하는 메서드.
		호출된 JSP페이지가 끝나고 나도 실행 흐름의 제어를 되돌려주지 않음.
		그러므로 어떤 JSP페이지가 할 일을 모두 마치고 난 다음에 다른 JSP페이지를 호출하고자 할 때 사용.
		JSP페이지가 아닌 다른 종류의 웹 자원(서블릿, HTML문서 등)호출도 가능.
		*/
		
		
		/*
		 * response.setContentType("text/html; charset=utf-8"); PrintWriter out
		 * = response.getWriter(); out.println("<h1>GuestBook</h1>");
		 */
	}

}

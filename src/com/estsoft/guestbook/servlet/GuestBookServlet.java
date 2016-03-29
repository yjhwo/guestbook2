package com.estsoft.guestbook.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.estsoft.guestbook.web.action.GuestBookActionFactory;
import com.estsoft.web.action.Action;
import com.estsoft.web.action.ActionFactory;

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
		ActionFactory actionFactory = new GuestBookActionFactory();		
		Action action = actionFactory.getAction(actionName);
		// 액션 실행
		action.execute(request, response);

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

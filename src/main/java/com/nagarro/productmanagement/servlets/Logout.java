package com.nagarro.productmanagement.servlets;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

/**
 * Servlet implementation class Logout.
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("UserName");
		Session hibernateSession =  (Session) httpSession.getAttribute("HIBERNATE_SESSION");
		hibernateSession.close();
		httpSession.removeAttribute("HIBERNATE_SESSION");
		response.sendRedirect("login.jsp");
	}

}

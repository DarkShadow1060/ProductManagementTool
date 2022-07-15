package com.nagarro.productmanagement.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nagarro.productmanagement.entity.UserEntity;
import com.productmanagement.hibernateutil.ConnectorDB;

/**
 * Servlet implementation class UserSession.
 */
@WebServlet("/UserSession")
public class UserSession extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = ConnectorDB.getConnectorDB().getSessionFactory();
		Session hibernateSession=factory.openSession();
		UserEntity usr = hibernateSession.get(UserEntity.class,request.getParameter("userName"));
		if(usr!=null) {
			if(usr.getPassWord().equals(request.getParameter("passWord"))) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute( "HIBERNATE_SESSION", hibernateSession); // constant class 
				httpSession.setAttribute("UserName",request.getParameter("userName"));
				response.sendRedirect("userLoginAccount.jsp");
			}
			else {
				hibernateSession.close();
				response.sendRedirect("login.jsp");
			}
		}
		else {
			hibernateSession.close();
			response.sendRedirect("login.jsp");
		}
		
	}

}

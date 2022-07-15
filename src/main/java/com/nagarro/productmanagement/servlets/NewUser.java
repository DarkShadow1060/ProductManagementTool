package com.nagarro.productmanagement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.productmanagement.entity.UserEntity;
import com.productmanagement.hibernateutil.ConnectorDB;

/**
 * Servlet implementation class NewUser.
 */
@WebServlet("/NewUser")
public class NewUser extends HttpServlet {
	
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = ConnectorDB.getConnectorDB().getSessionFactory();
		UserEntity newuser= new UserEntity();
		newuser.setUserName(request.getParameter("userName"));
		newuser.setName(request.getParameter("name"));
		newuser.setemail(request.getParameter("emailID"));
		newuser.setPassWord(request.getParameter("passWord"));
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		if(session.get(UserEntity.class , newuser.getUserName()) !=null ) {
			session.close();
			response.sendRedirect("createUser.jsp"); 
		}
		else {
			session.save(newuser);//			
			tx.commit();
			session.close();
			response.sendRedirect("login.jsp");
		}
		
	}

}

package com.nagarro.productmanagement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

import com.nagarro.productmanagement.entity.ProductEntity;

/**
 * Servlet implementation class Delete.
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSesssion = request.getSession();
		try {
			Session hibernateSession = (Session)httpSesssion.getAttribute("HIBERNATE_SESSION"); 
			Transaction tx = hibernateSession.beginTransaction();
			int productID = Integer.parseInt(request.getParameter("product_id").trim());
			ProductEntity object = hibernateSession.get(ProductEntity.class,productID);
			System.out.println(object.toString());
			
			
			if(object!=null) {
				hibernateSession.delete(object);
				tx.commit();
				System.out.println("object deleted");
			}
			
			response.sendRedirect("userLoginAccount.jsp");
		}
		catch (SessionException e){
			response.sendRedirect("Error.jsp");
		}
		
	}

}

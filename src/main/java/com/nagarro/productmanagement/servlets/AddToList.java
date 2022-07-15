package com.nagarro.productmanagement.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.productmanagement.entity.ProductEntity;

/**
 * Servlet implementation class AddToList.
 */
@WebServlet("/AddToList")
public class AddToList extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Storeimg.
	 *
	 * @param part the part
	 * @param object1 the object 1
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void storeimg(String part,ProductEntity object1) throws IOException
	{
		File imagePath = new File(part); //here we given fully specified image path.
		System.out.println(part);
		
		byte[] imageInBytes = new byte[(int)imagePath.length()]; //image convert in byte form
		FileInputStream inputStream = new FileInputStream(imagePath); //input stream object create to read the file			
			inputStream.read(imageInBytes); // here inputstream object read the file
			inputStream.close();
			object1.setImgname("part");
			object1.setImage( imageInBytes );
			inputStream.close();
		
	}
	
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
		HttpSession httpSesssion = request.getSession();
		Session hibernateSession =  (Session) httpSesssion.getAttribute("HIBERNATE_SESSION");
		
		Transaction tx = hibernateSession.beginTransaction();
		
		ProductEntity newProduct= new ProductEntity();
		newProduct.setUserName((String) httpSesssion.getAttribute("UserName"));
		newProduct.setTitle(request.getParameter("ProductName"));
		newProduct.setSize(request.getParameter("ProductSize"));
		newProduct.setQuantity(Integer.parseInt(request.getParameter("ProductQuantity")));
		String part = request.getParameter("ProductImage");///
		if(!part.equals("")) {
			storeimg(part, newProduct);			
		}
		hibernateSession.save(newProduct);
		System.out.println(newProduct.toString());
		tx.commit();
		response.sendRedirect("userLoginAccount.jsp");
		
	}

}

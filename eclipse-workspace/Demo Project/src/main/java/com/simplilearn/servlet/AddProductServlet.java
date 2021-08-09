package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.eproduct;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-product.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Fetch data from request
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		//1.load sessionFactory
		SessionFactory factory = HibernateUtil.buildSessionFactory();
		
		//2.create a session
		Session session = factory.openSession();
		
		//3.begin transaction
		Transaction tx = session.beginTransaction();
		
		//4.create persistance object/add product
		eproduct product = new eproduct(name, Double.parseDouble(price));
		
		//5.save product
		session.save(product);
		
		//6.commit transaction
		tx.commit();
		
		out.print("<h3 style='color:green'> Product is created successfully !<h3>");
		
		//7.close session
		session.close();
		
	}

}

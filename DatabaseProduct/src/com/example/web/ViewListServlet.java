package com.example.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.example.dao.*;
import com.example.model.*;


public class ViewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao; 
	
	public void init() {
		productDao = new ProductDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listProduct(request, response);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> listProduct = productDao.getAllProduct();
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
		dispatcher.forward(request, response);
	}

}

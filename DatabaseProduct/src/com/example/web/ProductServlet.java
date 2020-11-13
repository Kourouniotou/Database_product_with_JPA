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



public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao; 
	int result;
    
	public void init() {
		productDao = new ProductDao();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			insertProduct(request, response);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		try {
			String barcode = request.getParameter("barcode");
			String name = request.getParameter("name");
			String color = request.getParameter("color");
			String description = request.getParameter("description");
			Product newProduct = new Product(Integer.parseInt(barcode), name, color, description);
			result = productDao.searchProduct(newProduct);
			if (result == 1) {
				productDao.saveProduct(newProduct);
				RequestDispatcher view = request.getRequestDispatcher("product_view.jsp");
				view.forward(request,response);
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher("error_view.jsp");
				view.forward(request,response);
			}
		}catch(Exception exc){
			exc.printStackTrace();
		}
		
	}
}

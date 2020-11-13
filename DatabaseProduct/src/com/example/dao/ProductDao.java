package com.example.dao;

import javax.persistence.Id;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Product;
import com.example.utl.HibernateUtil;

import java.util.List;


public class ProductDao {
	
	public void saveProduct(Product product) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			session.save(product);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public int searchProduct(Product product) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Product products = session.get(Product.class, product.getBarcode());
			if(products != null) {
				transaction.commit();
				return(0);
			}
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return(1);
	}
	
	
	public List<Product> getAllProduct() {

		Transaction transaction = null;
		List<Product> listOfProduct = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfProduct = session.createQuery("from Product").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfProduct;
	}
}

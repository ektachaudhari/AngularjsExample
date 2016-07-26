package com.auskeny.hibernate.bdo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auskeny.application.exception.ApplicationException;
import com.auskeny.application.utils.JsonUtils;
import com.auskeny.hibernate.dao.ProductDAO;
import com.auskeny.hibernate.pojo.Product;
import com.google.gson.Gson;

public class ProductBDO  implements BDO {
	private static final Logger logger = LoggerFactory.getLogger(ProductBDO.class);
	private ProductDAO productDAO=new ProductDAO();
	
	/* create Product detail */
	@Override
	public String create(String productJsonString) throws ApplicationException, Exception {
		System.out.println("productJsonString "+productJsonString);
		Product product=JsonUtils.getJavaObjectFromJson(productJsonString,Product.class);	
		System.out.println("ProductBDO-convert jsonString to javaObject: "+product);
		Session session=productDAO.getSession();		
		Transaction transaction=session.getTransaction();		
		try{			
			transaction.begin();
			System.out.println("sessiom begin");
			productDAO.save(product);
			session.save(product);
			System.out.println("session saved");
			transaction.commit();
			productJsonString=JsonUtils.getJsonFromJavaObject(product,Product.class).toString();
			System.out.println("productBDO-convert java object into json "+productJsonString);
		}catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
			logger.error(ex.getMessage()+" "+ex.getCause().getMessage());
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
		} finally {
			session.clear();
		}
		return productJsonString;
	}

	@Override
	public String update(String productJsonString) throws ApplicationException, Exception {
		Product product=JsonUtils.getJavaObjectFromJson(productJsonString, Product.class);
		Session session=productDAO.getSession();
		Transaction transaction=session.getTransaction();
		try{
			transaction.begin();
			System.out.println("sessiom begin");			
			session.update(session.merge(product));
			System.out.println("session updated");
			transaction.commit();
			productJsonString=JsonUtils.getJsonFromJavaObject(product,Product.class).toString();
		}catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
			logger.error(ex.getMessage()+" "+ex.getCause().getMessage());
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
		} finally {
			session.clear();
		}
		return productJsonString;
	}

	@Override
	public void delete(int productIdPk) throws ApplicationException, Exception {
		Session session = productDAO.getSession();
		Transaction transaction = session.getTransaction();
		try{
			transaction.begin();
			System.out.println("transction begin");						
			session.delete(session.merge(productDAO.findById(productIdPk)));
			transaction.commit();
		}catch(Exception ex){
			transaction.rollback();
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());

		}finally {
			session.clear();
		}
	}
	

	@Override
	public String list() throws ApplicationException, Exception {	
		return new Gson().toJson(productDAO.findAll());
	}

	

}

package com.auskeny.hibernate.dao;

import java.util.List;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auskeny.hibernate.pojo.Product;

public class ProductDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ProductDAO.class);

	/* saving product instance */
	public void save(Product productInstance) {
		System.out.println("product saved");
		log.debug("saving product instance");
		try {

			getSession().save(productInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* deleting product instance */
	public void delete(Product productInstance) {
		System.out.println("in delete");
		log.debug("deleting product instance");
		try {
			getSession().delete(productInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* find product instance with id */
	public Product findById(java.lang.Integer id) {
		log.debug("getting product instance with id: " + id);
		try {
			Product instance = (Product) getSession().get("com.auskeny.hibernate.pojo.Product", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* finding all Product instances */
	public List<Product> findAll() {
		// System.out.println("findAll");
		log.debug("finding all Product instances");

		try {
			String queryString = "from com.auskeny.hibernate.pojo.Product";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Product employee = new Product(); ProductDAO employeeDao = new
	 * ProductDAO();
	 * 
	 * Session session = employeeDao.getSession(); Transaction transaction =
	 * session.getTransaction();
	 * 
	 * try { transaction.begin(); employee.setProductName("Real Fruit Juice");
	 * employee.setPrice(100.00); //employee.setCountry("india");
	 * employeeDao.save(employee); // session.save(employee); if
	 * (!transaction.wasCommitted()) { transaction.commit(); } } catch
	 * (Exception ex) { transaction.rollback();
	 * System.err.println(ex.getMessage() + " " + ex.getCause().getMessage()); }
	 * finally { session.clear(); }
	 * 
	 * }
	 */
}

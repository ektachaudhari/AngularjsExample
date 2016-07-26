package com.auskeny.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auskeny.hibernate.dao.CustomerDAO;
import com.auskeny.hibernate.pojo.Customer;
import com.auskeny.hibernate.dao.BaseHibernateDAO;

public class CustomerDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CustomerDAO.class);

	
	/*saving customer instance*/
	public void save(Customer customerInstance) {
		System.out.println("customer save");
		log.debug("saving customer instance");
		try {

			getSession().save(customerInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*deleting customer instance*/
	public void delete(Customer customerInstance) {
		System.out.println("in delete");
		log.debug("deleting customer instance");
		try {
			getSession().delete(customerInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Customer findById(java.lang.Integer id) {
		log.debug("getting Customer instance with id: " + id);
		try {
			Customer instance = (Customer) getSession().get("com.auskeny.hibernate.pojo.Customer", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Customer> findAll() {
		// System.out.println("findAll");
		log.debug("finding all Customer instances");

		try {
			String queryString = "from Customer";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}

	}
	
	/*public static void main(String[] args) {

		Customer employee = new Customer(); 
		CustomerDAO employeeDao = new CustomerDAO();
	
		Session session = employeeDao.getSession(); 
		Transaction transaction = session.getTransaction(); 
	
	try {
		transaction.begin();
		employee.setCustomerName("ekta");
		employee.setCity("mahesana");
		employee.setCountry("india");
		employeeDao.save(employee);		
		//session.save(employee);
		if (!transaction.wasCommitted()) {
			transaction.commit();
		}
	} catch (Exception ex) {
		transaction.rollback();
		System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
	} finally {
		session.clear();
	}

}*/

	

}

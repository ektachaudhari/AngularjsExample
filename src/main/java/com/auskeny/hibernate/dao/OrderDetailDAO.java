package com.auskeny.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.auskeny.hibernate.pojo.OrderDetail;


public class OrderDetailDAO extends BaseHibernateDAO{
	private static final Logger log = LoggerFactory.getLogger(OrderDetailDAO.class);
	
	/* saving  order instance */
	public void save(OrderDetail orderInstance) {
		System.out.println("order saved");
		log.debug("saving product instance");
		try {

			getSession().save(orderInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* find OrderDetail instance with id */
	public OrderDetail findById(java.lang.Integer id) {
		log.debug("getting OrderDetail instance with id: " + id);
		try {
			OrderDetail instance = (OrderDetail) getSession().get("com.auskeny.hibernate.pojo.OrderDetail", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* finding all order instances */
	public List<OrderDetail> findAll() {
		// System.out.println("findAll");
		log.debug("finding all order instances");

		try {
			String queryString = "from OrderDetail";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}	

	}
	
}

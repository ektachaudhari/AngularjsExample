package com.auskeny.hibernate.bdo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auskeny.application.exception.ApplicationException;
import com.auskeny.application.utils.JsonUtils;
import com.auskeny.hibernate.dao.OrderDetailDAO;
import com.auskeny.hibernate.pojo.OrderDetail;

public class OrderDetailBDO {
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailBDO.class);
	OrderDetailDAO orderDetailDAO=new OrderDetailDAO();
	
	
	
	public String create(String orderJsonString) throws ApplicationException, Exception {
		OrderDetail orderDetail=JsonUtils.getJavaObjectFromJson(orderJsonString,OrderDetail.class);
		System.out.println("");
		Session session=orderDetailDAO.getSession();
		Transaction transaction=session.getTransaction();
		try{
			System.out.println("session1");
			transaction.begin();
			System.out.println("transaction begin");
			orderDetailDAO.save(orderDetail);
			session.save(orderDetail);
			transaction.commit();
			orderJsonString=JsonUtils.getJsonFromJavaObject(orderDetail, OrderDetail.class);
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			logger.error(ex.getMessage()+" "+ex.getCause().getMessage());
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
		}finally {
			session.clear();
		}
		return orderJsonString;
	}

	
	
}

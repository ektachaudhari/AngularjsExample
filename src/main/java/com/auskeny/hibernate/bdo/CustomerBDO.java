package com.auskeny.hibernate.bdo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.google.gson.Gson;
import com.auskeny.application.exception.ApplicationException;
import com.auskeny.application.session.ApplicationSessionManager;
import com.auskeny.hibernate.dao.CustomerDAO;
import com.auskeny.hibernate.pojo.Customer;

public class CustomerBDO {
	private Gson gson = new Gson();
	CustomerDAO customerDAO = new CustomerDAO();

	/* create customer detail */
	public String create(String jsonString) throws ApplicationException, Exception {
		System.out.println("customerBDO-create");
		Customer customer = gson.fromJson(jsonString, Customer.class);
		Session session = customerDAO.getSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();			
			new ApplicationSessionManager().put(jsonString, customer);
			session.save(customer);			
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
		} finally {
			session.clear();
		}
		
		return gson.toJson(customer, Customer.class);
	}

	/* update customer detail */
	public String update(String jsonString) throws ApplicationException, Exception {

		Customer customer = gson.fromJson(jsonString, Customer.class);
		Session session = customerDAO.getSession();
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			System.out.println("transction begin");
			new ApplicationSessionManager().put(jsonString, customer);
			session.update(session.merge(customer));
			transaction.commit();
		} catch (Exception ex) {

			transaction.rollback();
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());
		} finally {
			session.clear();
		}
		return gson.toJson(customer, Customer.class);
	}

	/* delete customer detail */
	public void delete(int id) throws Exception {	
		
		Session session = customerDAO.getSession();
		Transaction transaction = session.getTransaction();
		try{
			transaction.begin();
			System.out.println("transction begin");						
			session.delete(session.merge(customerDAO.findById(id)));
			transaction.commit();
		}catch(Exception ex){
			transaction.rollback();
			System.err.println(ex.getMessage() + " " + ex.getCause().getMessage());

		}finally {
			session.clear();
		}
		
	}

	/* get all customer list */
	public String list() throws ApplicationException, Exception {
		// System.out.println("in bdo-list");
		return gson.toJson(customerDAO.findAll());

	}

}

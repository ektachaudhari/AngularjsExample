package com.auskeny.hibernate.dao;

import org.hibernate.Session;
import com.auskeny.hibernate.util.HibernateSessionFactory;

public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
		
}
package com.auskeny.hibernate.bdo;

import com.auskeny.application.exception.ApplicationException;
public interface BDO {
	public String create(String jsonString) throws ApplicationException, Exception;
	public String update(String jsonString) throws ApplicationException, Exception;
	public void delete(int id) throws ApplicationException, Exception;
	public String list() throws ApplicationException, Exception;
		
}

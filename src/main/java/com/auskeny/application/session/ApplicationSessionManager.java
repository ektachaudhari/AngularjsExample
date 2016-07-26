package com.auskeny.application.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.auskeny.hibernate.pojo.Customer;;

public class ApplicationSessionManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Map<String, Customer> sessionMap;

	public static void initialize() {
		if (sessionMap == null) {
			sessionMap = new HashMap<String, Customer>();
		}
	}

	public void put(String token, Customer customer) {
		sessionMap.put(token, customer);
		
	}

	public void remove(int key) {
		System.out.println("remove-sessionmanager");
		sessionMap.remove(key);
	}

	public List<Customer> getList() {
		List<Customer> customerList = new ArrayList<>();
		customerList.addAll(sessionMap.values());
		for (int i = 0; i < customerList.size(); i++) {
		}
		return customerList;
	}

	public static Customer getValue(int key) {
		return sessionMap.get(key);
	}

	public static void destory() {
		if (sessionMap != null) {
			sessionMap.clear();
			sessionMap = null;
		}
	}
}

package com.deloitte.ecommerce.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.deloitte.ecommerce.entity.Customer;
import com.deloitte.ecommerce.exception.CustomerNotFoundException;

public class DaoImpl implements Dao {
	private Map<String, Customer> store = new HashMap<>();

	public DaoImpl() {
		Customer c1 = new Customer("teju", "7893378000", "t", 100);
		store.put("7893378000", c1);
		Customer c2 = new Customer("sara", "7893389000", "s", 200);
		store.put("7893389000", c2);
	}

	@Override
	public void addCustomer(Customer c) {
		store.put(c.getMobileno(), c);
	}

	@Override
	public Customer findById(String mobileno) {
		Customer c = store.get(mobileno);
		if (c == null) {
			throw new CustomerNotFoundException("customer not found =" + mobileno);
		}
		return c;
	}

	@Override
	public boolean credentialsCorrect(String mobileno, String password) {
		Customer user = store.get(mobileno);
		if (user == null) {
			return false;
		}
		return user.getPassword().equals(password);
	}

}

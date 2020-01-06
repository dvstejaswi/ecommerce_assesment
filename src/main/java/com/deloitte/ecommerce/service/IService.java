package com.deloitte.ecommerce.service;

import java.util.Set;

import com.deloitte.ecommerce.entity.Customer;

public interface IService {
	Customer findById(String mobileno);
	void addCustomer(Customer c);
	boolean credentialsCorrect(String mobileno, String password);

}

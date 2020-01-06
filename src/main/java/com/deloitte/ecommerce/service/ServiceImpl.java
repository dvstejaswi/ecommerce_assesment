package com.deloitte.ecommerce.service;

import java.util.Set;

import com.deloitte.ecommerce.dao.Dao;
import com.deloitte.ecommerce.dao.DaoImpl;
import com.deloitte.ecommerce.entity.Customer;
import com.deloitte.ecommerce.exception.IncorrectIdException;



public class ServiceImpl implements IService {
private Dao dao = new DaoImpl();
	
public ServiceImpl(Dao dao) {
	this.dao = dao;
}


	
	 @Override
	 public void addCustomer(Customer c) {
		 dao.addCustomer(c);
	 }
	
	
	@Override
	public Customer findById(String mobileno) {
		if(mobileno==null || mobileno.length()!=10) {
			throw new IncorrectIdException("incorrect id");	
		}
		Customer c=dao.findById(mobileno);
		return c;
	}
	
	 @Override
	    public boolean credentialsCorrect(String mobileno, String password) {
	        boolean correct = dao.credentialsCorrect(mobileno, password);
	        return correct;
	    }

}




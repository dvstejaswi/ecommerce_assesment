package com.deloitte.ecommerce.dao;

import java.util.Set;

import com.deloitte.ecommerce.entity.Customer;

public interface Dao {Customer findById(String mobileno);
void addCustomer(Customer c);
boolean credentialsCorrect(String mobileno, String password);



}

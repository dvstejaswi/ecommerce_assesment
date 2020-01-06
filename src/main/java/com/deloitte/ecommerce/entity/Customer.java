package com.deloitte.ecommerce.entity;

public class Customer {

    public Customer() {

    }
private String name;
private String mobileno;
private String password;
private double balance;

    
    public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getMobileno() {
	return mobileno;
}


public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public double getBalance() {
	return balance;
}


public void setBalance(double balance) {
	this.balance = balance;
}


	public Customer(String name, String mobileno, String password, double balance) {
        this.name = name;
        this.password = password;
        this.mobileno = mobileno;
        this.balance = balance;
        
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Customer)) {
            return false;
        }
        Customer user = (Customer) obj;
        return user.mobileno.equals(this.mobileno);
    }

    @Override
    public int hashCode() {
        return mobileno.hashCode();
    }
}

package com.mrghz.crmapp.service;

import java.util.List;

import com.mrghz.crmapp.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theEmployee);

	public void deleteById(int theId);

}

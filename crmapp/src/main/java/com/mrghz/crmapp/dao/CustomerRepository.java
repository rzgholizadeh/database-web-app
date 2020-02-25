package com.mrghz.crmapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrghz.crmapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	// method for sorting
	public List<Customer> findAllByOrderByLastNameAsc();
}

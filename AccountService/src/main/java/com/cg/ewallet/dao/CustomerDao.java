package com.cg.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ewallet.entity.Customer;


public interface CustomerDao extends JpaRepository<Customer,Integer> {

	
}

package com.cg.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ewallet.dto.Customer;


public interface CustomerDao extends JpaRepository<Customer,Integer> {

	
}

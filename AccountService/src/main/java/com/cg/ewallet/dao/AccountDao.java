package com.cg.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ewallet.dto.Account;



public interface AccountDao extends JpaRepository<Account,Integer> {
	
}

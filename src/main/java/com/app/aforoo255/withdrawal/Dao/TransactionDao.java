package com.app.aforoo255.withdrawal.Dao;

import org.springframework.data.repository.CrudRepository;

import com.app.aforoo255.withdrawal.domain.Transaction;


public interface TransactionDao extends CrudRepository<Transaction, Integer> {

}

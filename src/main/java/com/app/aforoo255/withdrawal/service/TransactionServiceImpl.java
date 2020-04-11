package com.app.aforoo255.withdrawal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.aforoo255.withdrawal.Dao.TransactionDao;
import com.app.aforoo255.withdrawal.domain.Transaction;

@Service
public class TransactionServiceImpl  implements ITransactionService{

	@Autowired
	private TransactionDao transactionDao;
	
	@Override
	@Transactional
	public Transaction save(Transaction transaction) {
		return transactionDao.save(transaction);
	}

}

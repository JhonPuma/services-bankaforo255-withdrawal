package com.app.aforoo255.withdrawal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.aforoo255.withdrawal.domain.Transaction;
import com.app.aforoo255.withdrawal.producer.WithdrawalEventProducer;
import com.app.aforoo255.withdrawal.service.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class WithdrawalEventsController {

	private Logger log =LoggerFactory.getLogger(WithdrawalEventsController.class);
	
	@Autowired
	WithdrawalEventProducer withdrawalEventProducer;
	
	@Autowired
	private ITransactionService transactionService;
	
	@PostMapping("/v1/withdrawalEvent")
	public ResponseEntity<Transaction> postLibraryEvent(@RequestBody Transaction transactionEvent) throws JsonProcessingException{
		Transaction transactionSQL = transactionService.save(transactionEvent);
		
		log.info("Antes de sendDepositEvent_Approach3");
		withdrawalEventProducer.sendDepositEvent_Approach3(transactionSQL);
		log.info("Despues de sendDepositEvent_Approach3");
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionSQL);
	}
}

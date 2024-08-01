package com.thoma.finmanapi.controller;

import com.thoma.finmanapi.request.TransactionDetailRequest;
import com.thoma.finmanapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The controller class exposes api for managing the expense transactions
 *
 */
@RestController
@RequestMapping(value = "/api")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping("/transaction")
	public ResponseEntity<?> getTransactions() {
		return new ResponseEntity<>(transactionService.listTransactionDetail(), HttpStatus.OK);
	}

	@PostMapping("/transaction")
	public ResponseEntity<?> recordTransaction(@RequestBody TransactionDetailRequest req) {
		return new ResponseEntity<>(transactionService.createNewTransaction(req), HttpStatus.OK);
	}
}

package com.thoma.finmanapi.controller;

import com.thoma.finmanapi.dto.request.TransactionDetailRequest;
import com.thoma.finmanapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The controller class exposes api for managing the expense transactions
 */
@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<?> getTransactions(@RequestParam int page, @RequestParam(required = false, defaultValue = "10") int size   ) {
        return new ResponseEntity<>(transactionService.listTransactionDetail(page,size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewTransaction(@RequestBody TransactionDetailRequest req) {
        return new ResponseEntity<>(transactionService.createNewTransaction(req), HttpStatus.OK);
    }
}

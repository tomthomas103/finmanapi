package com.thoma.finmanapi.service;

import com.thoma.finmanapi.entity.TransactionDetail;
import com.thoma.finmanapi.dto.request.TransactionDetailRequest;

import java.util.List;

public interface TransactionService {
    public List<TransactionDetail> listTransactionDetail(int page, int size);
    public TransactionDetail createNewTransaction(TransactionDetailRequest req);
    public TransactionDetail updateTransaction(TransactionDetailRequest request);
    public TransactionDetail deleteTransaction(String transactionId);
    public TransactionDetail getTransactionDetail(String transactionId);

}

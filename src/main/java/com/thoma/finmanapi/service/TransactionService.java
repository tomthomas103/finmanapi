package com.thoma.finmanapi.service;

import com.thoma.finmanapi.entity.TransactionDetail;
import com.thoma.finmanapi.request.TransactionDetailRequest;

import java.util.List;

public interface TransactionService {
    public List<TransactionDetail> listTransactionDetail();
    public TransactionDetail createNewTransaction(TransactionDetailRequest req);
}

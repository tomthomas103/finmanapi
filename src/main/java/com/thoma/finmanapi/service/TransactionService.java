package com.thoma.finmanapi.service;

import com.thoma.finmanapi.entity.TransactionDetail;
import com.thoma.finmanapi.dto.request.TransactionDetailRequest;

import java.util.List;

public interface TransactionService {
    public List<TransactionDetail> listTransactionDetail(int page, int size);
    public TransactionDetail createNewTransaction(TransactionDetailRequest req);

}

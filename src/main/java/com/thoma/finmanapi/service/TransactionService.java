package com.thoma.finmanapi.service;

import com.thoma.finmanapi.dto.response.PaginationResponse;
import com.thoma.finmanapi.dto.response.TransactionResponse;
import com.thoma.finmanapi.entity.TransactionDetail;
import com.thoma.finmanapi.dto.request.TransactionDetailRequest;

public interface TransactionService {
    public PaginationResponse<TransactionResponse> listTransactionDetail(int page, int size);
    public TransactionResponse createNewTransaction(TransactionDetailRequest req);
    public TransactionDetail updateTransaction(TransactionDetailRequest request);
    public TransactionDetail deleteTransaction(String transactionId);
    public TransactionDetail getTransactionDetail(String transactionId);

}

package com.thoma.finmanapi.repository;

import com.thoma.finmanapi.entity.TransactionDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {
    @Override
    Page<TransactionDetail> findAll(Pageable pageable);
}

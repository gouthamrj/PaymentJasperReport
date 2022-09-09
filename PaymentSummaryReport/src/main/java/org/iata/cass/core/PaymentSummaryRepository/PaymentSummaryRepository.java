package org.iata.cass.core.PaymentSummaryRepository;


import org.iata.cass.core.PaymentSummaryEntity.PaymentSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentSummaryRepository extends JpaRepository<PaymentSummaryEntity, Integer> {



}

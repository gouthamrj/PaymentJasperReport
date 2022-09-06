package org.iata.cass.core.PaymentRepository;

import org.iata.cass.core.PaymentSummaruEntity.Paymentsummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Paymentsummary, Long> {

}

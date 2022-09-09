package org.iata.cass.core.PaymentSummaryService;

import java.util.List;

import org.iata.cass.core.PaymentSummaryEntity.PaymentSummaryEntity;

public interface PayService {
	
	public List<PaymentSummaryEntity> getDetails();
	public PaymentSummaryEntity getId(int id);

}

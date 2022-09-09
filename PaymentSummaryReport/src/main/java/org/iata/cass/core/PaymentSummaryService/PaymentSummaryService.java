package org.iata.cass.core.PaymentSummaryService;

import java.util.ArrayList;
import java.util.List;

import org.iata.cass.core.PaymentSummaryEntity.PaymentSummaryEntity;
import org.iata.cass.core.PaymentSummaryRepository.PaymentSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentSummaryService implements PayService {

	@Autowired
	private PaymentSummaryRepository repo;
	
	@Override
	public List<PaymentSummaryEntity> getDetails() {
		List<PaymentSummaryEntity> list=new ArrayList<>();
		for(PaymentSummaryEntity pay:repo.findAll()) {
			list.add(pay);
		}
		return list;
	}

	@Override
	public PaymentSummaryEntity getId(int id) {
		
		return repo.findById(id).get();
	}
	
	
	
	

}

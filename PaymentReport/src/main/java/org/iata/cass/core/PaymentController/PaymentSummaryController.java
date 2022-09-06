package org.iata.cass.core.PaymentController;

import org.iata.cass.core.PaymentService.PaymentSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentSummaryController {
	
	@Autowired
	private PaymentSummaryService paymentService;
	@GetMapping("/report")
	public String generateReport() {

		return paymentService.generateReport();
	}

}

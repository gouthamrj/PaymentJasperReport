package org.iata.cass.core.PaymentSummaryController;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iata.cass.core.PaymentSummaryEntity.PaymentSummaryEntity;
import org.iata.cass.core.PaymentSummaryService.PaymentSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class PaymentSummaryContoller {
	
	@Autowired
	PaymentSummaryService service;
	
	@RequestMapping("/pamentsummary")
	public List<PaymentSummaryEntity> getPaydetails(){
		return service.getDetails();
	}
	@RequestMapping("/pamentsummary/{id}")
	public PaymentSummaryEntity getDetail(@PathVariable int id) {
		return service.getId(id);
	}
	
	
	
	@RequestMapping("/pamentsummary/report/{id}")
	public ResponseEntity<byte[]> generatePdf(@PathVariable int id) throws Exception, JRException {
		JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(service.getDetails());
		JasperReport compileReport= JasperCompileManager.compileReport(new FileInputStream("src/main/resources/templates/PaymentSummaryReport.jrxml"));
		
		Map<String, Object> parameters = new HashMap<>();

		parameters.put("title", "PAYMENT SUMMARY");
		
		JasperPrint report= JasperFillManager.fillReport(compileReport, parameters, dataSource);
//		JasperExportManager.exportReportToPdfFile(report, "PaymentSummary.pdf");
		byte[] data= JasperExportManager.exportReportToPdf(report);
		
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.set(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,"inline;filename=PaymentSummary.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
	}

}

package org.iata.cass.core.PaymentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iata.cass.core.PaymentRepository.PaymentRepo;
import org.iata.cass.core.PaymentSummaruEntity.Paymentsummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PaymentSummaryService {
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	public String generateReport() {
		try {
			
			List<Paymentsummary> pay=paymentRepo.findAll();
			
			String reportpath="E:\\Report\\pdf";
			
			//Compile the Jasper report from.jrxml to .jasper
			JasperReport jasperReport= JasperCompileManager
					.compileReport(reportpath + "\\paymentsummary.jrxml");
			
			//Get data source
			JRBeanCollectionDataSource jrbeanCollection=new JRBeanCollectionDataSource(pay);
			
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("title", "PAYMENT SUMMARY");
			
			// Fill the report
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrbeanCollection);
			
			
			// Export the report to a PDF file
						JasperExportManager.exportReportToPdfFile(jasperPrint, reportpath + "\\paymentsummary.pdf");

						System.out.println("Done");

						return "Report successfully generated @path= " + reportpath;
					} catch (Exception e) {
						e.printStackTrace();
						return "Error--> check the console log";
					}
			
			
		}
	}
	

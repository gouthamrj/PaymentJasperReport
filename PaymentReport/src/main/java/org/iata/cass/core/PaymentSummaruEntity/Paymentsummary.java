package org.iata.cass.core.PaymentSummaruEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

@Entity
@Table(name = "Payment")
public class Paymentsummary {

	@Id
	@Column(name = "NUMERIC CODE")
	private long numericCode;
	@Column(name = "USER")
	private String user;
	@Column(name = "USER NAME")
	private String userName;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "TAX/VAT NUMBER")
	private double tax_vat_Number;
	@Column(name = "FROM DATE")
	private String fromDate;
	@Column(name = "TO DATE")
	private String toDate;
	@Column(name = "GENERATED DATE")
	private String fileGeneratedDate;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "TYPE DATE")
	private String typeDate;
	@Column(name = "CURRENCY")
	private String currency;
	@Column(name = "DUE TYPE")
	private String netDueType;
	@Column(name = "NET DUE")
	private double netdueAgent;
	@Column(name = "GRAND TOTAL")
	private double grandTotal;

}

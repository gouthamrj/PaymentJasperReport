package org.iata.cass.core.PaymentSummaryEntity;

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
@Table(name = "PaymentSummary")
public class PaymentSummaryEntity {

//	public PaymentSummaryEntity() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	@Id
	@Column(name = "NUMERIC_CODE")
	private int numericCode;
	@Column(name = "USER")
	private String user;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "TAX_VAT_NUMBER")
	private String tax_vat_Number;
	@Column(name = "FROM_DATE")
	private String fromDate;
	@Column(name = "TO_DATE")
	private String toDate;
	@Column(name = "GENERATED_DATE")
	private String fileGeneratedDate;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "TYPE_DATE")
	private String typeDate;
	@Column(name = "CURRENCY")
	private String currency;
	@Column(name = "DUE_TYPE")
	private String netDueType;
	@Column(name = "NET_DUE_Agent")
	private Double netdueAgent;
	@Column(name = "NET_DUE_Airline")
	private Double netdueAirline;
	@Column(name = "GRAND_TOTAL")
	private Double grandTotal;

}

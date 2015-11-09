package com.dev.persistence.model;
// Generated 09/11/2015 04:31:59 by Hibernate Tools 3.5.0.Final

import java.math.BigDecimal;

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = -6399419513889527335L;
	
	private long cusId;
	private String cusCode;
	private String cusName;
	private String cusAddress;
	private String cusPhone1;
	private String cusPhone2;
	private BigDecimal cusCreditLimit;
	private BigDecimal cusCurrentCredit;

	public Customer() {
	}

	public Customer(long cusId, String cusCode, String cusName, BigDecimal cusCreditLimit,
			BigDecimal cusCurrentCredit) {
		this.cusId = cusId;
		this.cusCode = cusCode;
		this.cusName = cusName;
		this.cusCreditLimit = cusCreditLimit;
		this.cusCurrentCredit = cusCurrentCredit;
	}

	public Customer(long cusId, String cusCode, String cusName, String cusAddress, String cusPhone1, String cusPhone2,
			BigDecimal cusCreditLimit, BigDecimal cusCurrentCredit) {
		this.cusId = cusId;
		this.cusCode = cusCode;
		this.cusName = cusName;
		this.cusAddress = cusAddress;
		this.cusPhone1 = cusPhone1;
		this.cusPhone2 = cusPhone2;
		this.cusCreditLimit = cusCreditLimit;
		this.cusCurrentCredit = cusCurrentCredit;
	}

	public long getCusId() {
		return this.cusId;
	}

	public void setCusId(long cusId) {
		this.cusId = cusId;
	}

	public String getCusCode() {
		return this.cusCode;
	}

	public void setCusCode(String cusCode) {
		this.cusCode = cusCode;
	}

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddress() {
		return this.cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getCusPhone1() {
		return this.cusPhone1;
	}

	public void setCusPhone1(String cusPhone1) {
		this.cusPhone1 = cusPhone1;
	}

	public String getCusPhone2() {
		return this.cusPhone2;
	}

	public void setCusPhone2(String cusPhone2) {
		this.cusPhone2 = cusPhone2;
	}

	public BigDecimal getCusCreditLimit() {
		return this.cusCreditLimit;
	}

	public void setCusCreditLimit(BigDecimal cusCreditLimit) {
		this.cusCreditLimit = cusCreditLimit;
	}

	public BigDecimal getCusCurrentCredit() {
		return this.cusCurrentCredit;
	}

	public void setCusCurrentCredit(BigDecimal cusCurrentCredit) {
		this.cusCurrentCredit = cusCurrentCredit;
	}

}

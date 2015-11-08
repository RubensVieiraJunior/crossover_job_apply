package com.dev.persistence.model;

import java.math.BigDecimal;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class Customer {

	private Long cusCode;
	private String cusName;
	private String cusAddress;
	private String cusPhone1;
	private String cusPhone2;
	private BigDecimal cusCreditLimit;
	private BigDecimal cusCurrentCredit;
	
	/**
	 * @return the cusCode
	 */
	public Long getCusCode() {
		return cusCode;
	}

	/**
	 * @param cusCode the cusCode to set
	 */
	public void setCusCode(Long cusCode) {
		this.cusCode = cusCode;
	}

	/**
	 * @return the cusName
	 */
	public String getCusName() {
		return cusName;
	}

	/**
	 * @param cusName the cusName to set
	 */
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	/**
	 * @return the cusAddress
	 */
	public String getCusAddress() {
		return cusAddress;
	}

	/**
	 * @param cusAddress the cusAddress to set
	 */
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	/**
	 * @return the cusPhone1
	 */
	public String getCusPhone1() {
		return cusPhone1;
	}

	/**
	 * @param cusPhone1 the cusPhone1 to set
	 */
	public void setCusPhone1(String cusPhone1) {
		this.cusPhone1 = cusPhone1;
	}

	/**
	 * @return the cusPhone2
	 */
	public String getCusPhone2() {
		return cusPhone2;
	}

	/**
	 * @param cusPhone2 the cusPhone2 to set
	 */
	public void setCusPhone2(String cusPhone2) {
		this.cusPhone2 = cusPhone2;
	}

	/**
	 * @return the cusCreditLimit
	 */
	public BigDecimal getCusCreditLimit() {
		return cusCreditLimit;
	}

	/**
	 * @param cusCreditLimit the cusCreditLimit to set
	 */
	public void setCusCreditLimit(BigDecimal cusCreditLimit) {
		this.cusCreditLimit = cusCreditLimit;
	}

	/**
	 * @return the cusCurrentCredit
	 */
	public BigDecimal getCusCurrentCredit() {
		return cusCurrentCredit;
	}

	/**
	 * @param cusCurrentCredit the cusCurrentCredit to set
	 */
	public void setCusCurrentCredit(BigDecimal cusCurrentCredit) {
		this.cusCurrentCredit = cusCurrentCredit;
	}

}

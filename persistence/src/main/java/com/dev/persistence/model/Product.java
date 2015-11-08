/**
 * 
 */
package com.dev.persistence.model;

import java.math.BigDecimal;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class Product {

	private Long prdCode;
	private String prdDescription;
	private int prdQuantity;
	private BigDecimal prdPrice;
	
	/**
	 * @return the prdCode
	 */
	public Long getPrdCode() {
		return prdCode;
	}

	/**
	 * @param prdCode the prdCode to set
	 */
	public void setPrdCode(Long prdCode) {
		this.prdCode = prdCode;
	}

	/**
	 * @return the prdDescription
	 */
	public String getPrdDescription() {
		return prdDescription;
	}

	/**
	 * @param prdDescription the prdDescription to set
	 */
	public void setPrdDescription(String prdDescription) {
		this.prdDescription = prdDescription;
	}

	/**
	 * @return the prdQuantity
	 */
	public int getPrdQuantity() {
		return prdQuantity;
	}

	/**
	 * @param prdQuantity the prdQuantity to set
	 */
	public void setPrdQuantity(int prdQuantity) {
		this.prdQuantity = prdQuantity;
	}

	/**
	 * @return the prdPrice
	 */
	public BigDecimal getPrdPrice() {
		return prdPrice;
	}

	/**
	 * @param prdPrice the prdPrice to set
	 */
	public void setPrdPrice(BigDecimal prdPrice) {
		this.prdPrice = prdPrice;
	}

}

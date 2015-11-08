/**
 * 
 */
package com.dev.persistence.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class SalesOrder {

	private long sorOrderNum;
	private long sorCusCode;
	private Date sorDate;
	private int sorQuantity;
	private BigDecimal sorTotalPrice;
	
	/**
	 * @return the sorOrderNum
	 */
	public long getSorOrderNum() {
		return sorOrderNum;
	}

	/**
	 * @param sorOrderNum the sorOrderNum to set
	 */
	public void setSorOrderNum(long sorOrderNum) {
		this.sorOrderNum = sorOrderNum;
	}

	/**
	 * @return the sorCusCode
	 */
	public long getSorCusCode() {
		return sorCusCode;
	}

	/**
	 * @param sorCusCode the sorCusCode to set
	 */
	public void setSorCusCode(long sorCusCode) {
		this.sorCusCode = sorCusCode;
	}
	
	/**
	 * @return the sorDate
	 */
	public Date getSorDate() {
		return sorDate;
	}

	/**
	 * @param sorDate the sorDate to set
	 */
	public void setSorDate(Date sorDate) {
		this.sorDate = sorDate;
	}

	/**
	 * @return the sorQuantity
	 */
	public int getSorQuantity() {
		return sorQuantity;
	}

	/**
	 * @param sorQuantity the sorQuantity to set
	 */
	public void setSorQuantity(int sorQuantity) {
		this.sorQuantity = sorQuantity;
	}

	/**
	 * @return the sorTotalPrice
	 */
	public BigDecimal getSorTotalPrice() {
		return sorTotalPrice;
	}

	/**
	 * @param sorTotalPrice the sorTotalPrice to set
	 */
	public void setSorTotalPrice(BigDecimal sorTotalPrice) {
		this.sorTotalPrice = sorTotalPrice;
	}

}

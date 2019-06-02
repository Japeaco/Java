/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: Class for Multiple Offer that calculates the total amount saved on Sku Objects with a MultipleOffer Type.
 */

package org.shoppingcartapp;

import java.math.BigDecimal;

public class MultipleOffer implements Offer{
	
	private int count;
	private BigDecimal totalPrice;
	
	public MultipleOffer(int count, BigDecimal totalPrice){
		this.count = count;
		this.totalPrice = totalPrice;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	//calculates the total amount saved 
	public BigDecimal totalSavings(int quantity, BigDecimal itemPrice) {
		
		if(quantity >= getCount()) {
			BigDecimal q = BigDecimal.valueOf(quantity);
			BigDecimal fullPrice = itemPrice.multiply(BigDecimal.valueOf(getCount()));
			BigDecimal saving = fullPrice.subtract(getTotalPrice());
			if(quantity == getCount()) {
				return saving;
			}
			else {
				BigDecimal[] remainder = q.divideAndRemainder(BigDecimal.valueOf(getCount()));
				return saving.multiply(remainder[0]);
			}
		}
		else {
			return null;
		}
	}

	@Override 
	public String toString() {
		return getCount() + " for " + getTotalPrice();
	}
	
}

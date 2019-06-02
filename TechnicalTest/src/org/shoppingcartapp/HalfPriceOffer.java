/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: Class for Half Price Offer that calculates the total amount saved on Sku Objects with a HalfPriceOffer Type.
 */

package org.shoppingcartapp;

import java.math.BigDecimal;

public class HalfPriceOffer implements Offer{
	
	public HalfPriceOffer(){}

	@Override
	public BigDecimal totalSavings(int quantity, BigDecimal itemPrice) {
		
		BigDecimal half = new BigDecimal("2");
		BigDecimal halfPrice = itemPrice.divide(half);
		
		return halfPrice.multiply(BigDecimal.valueOf(quantity));
		
	}
	
	@Override 
	public String toString() {
		return "Half Price";
	}

}

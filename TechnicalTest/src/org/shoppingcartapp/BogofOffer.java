package org.shoppingcartapp;

import java.math.BigDecimal;

public class BogofOffer extends MultipleOffer implements Offer{
	
	public BogofOffer(int count, BigDecimal totalPrice){
		super(count, totalPrice);
	}
	
	@Override 
	public String toString() {
		return "BOGOF";
	}
}

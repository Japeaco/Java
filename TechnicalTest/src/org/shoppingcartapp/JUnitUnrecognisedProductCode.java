/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: JUnit tests for unrecognised product codes;
 * 	Only product codes that exist in the list of Sku objects can be 'scanned' with the scan method of the Till class
 * 	Otherwise an Error must be produced.
 */

package org.shoppingcartapp;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JUnitUnrecognisedProductCode {
	
	Store store = new Store();
	ArrayList<Sku> skuList = new ArrayList<>();
	
	@Before
	public void setUp() {
		
		Sku sku1 = new Sku();
		Sku sku2 = new Sku();
		Sku sku3 = new Sku();
		
		BigDecimal sku1BD = new BigDecimal("3.65");
		BigDecimal sku2BD = new BigDecimal("0.54");
		BigDecimal sku3BD = new BigDecimal("3.20");
		BigDecimal bogofBD = new BigDecimal("0.54");
		BigDecimal multipleBD = new BigDecimal("7.00");
		
		HalfPriceOffer halfPriceOffer = new HalfPriceOffer();
		BogofOffer bogofOffer = new BogofOffer(2, bogofBD);
		MultipleOffer multipleOffer = new MultipleOffer(3, multipleBD);
		
		sku1.setProductCode("B45");
		sku1.setDescription("Milk");
		sku1.setPrice(sku1BD);
		sku1.setOffer(halfPriceOffer);
		
		sku2.setProductCode("C330");
		sku2.setDescription("Fruity Drink");
		sku2.setPrice(sku2BD);
		sku2.setOffer(bogofOffer);
		
		sku3.setProductCode("H798");
		sku3.setDescription("Chocolate");
		sku3.setPrice(sku3BD);
		sku3.setOffer(multipleOffer);
		
		skuList.add(sku1);
		skuList.add(sku2);
		skuList.add(sku3);

		store.setSkuList(skuList);
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void errorThrownWhenIncorrectProductCodeUsed1() {
		Till till = new Till(store.getSkuList());
		till.scan("Q456");
    }	
	
	@Test(expected = IllegalArgumentException.class)
    public void errorThrownWhenIncorrectProductCodeUsed2() {
		Till till = new Till(store.getSkuList());
		till.scan("Z45");
    }	
}

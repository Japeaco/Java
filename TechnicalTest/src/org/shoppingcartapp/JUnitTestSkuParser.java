/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: JUnit tests for the parser method of the Sku object; 
 * 	A string is parsed and the appropriate fields of the Sku object are set.
 */

package org.shoppingcartapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;

import org.junit.Test;

public class JUnitTestSkuParser {
	
	String product1 = "H57	Tin o Beans	1.23";
	
	@Test
    public void productCodeFieldOfObjectEqualToExpectedString() {
		Sku sku = new Sku();
		Sku newProduct = sku.parser(product1);
		assertEquals(newProduct.getProductCode(),("H57"));
    }
	
	@Test
    public void descriptionFieldOfObjectEqualToExpectedString() {
		Sku sku = new Sku();
		Sku newProduct = sku.parser(product1);
		assertEquals(newProduct.getDescription(),("Tin o Beans"));
    }
	
	@Test
    public void priceFieldOfObjectEqualToExpectedBigDecimal() {
		Sku sku = new Sku();
		Sku newProduct = sku.parser(product1);
		BigDecimal price = new BigDecimal("1.23");
		assertEquals(newProduct.getPrice(),(price));
    }
	
	@Test
    public void productCodeFieldOfObjectNotEqualToUnExpectedString() {
		Sku sku = new Sku();
		Sku newProduct = sku.parser(product1);
		assertFalse(newProduct.getProductCode().equals("C56"));
    }
	
	@Test
    public void descriptionFieldOfObjectNotEqualToUnExpectedString() {
		Sku sku = new Sku();
		Sku newProduct = sku.parser(product1);
		assertFalse(newProduct.getDescription().equals("Loaf o Bread"));
    }
	
	@Test
    public void priceFieldOfObjectNotEqualToUnExpectedBigDecimal() {
		Sku sku = new Sku();
		Sku newProduct = sku.parser(product1);
		BigDecimal price = new BigDecimal("34.56");
		assertFalse(newProduct.getPrice().equals(price));
    }
}

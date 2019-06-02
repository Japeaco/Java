/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: JUnit tests for the overridden Equals and HashCode methods of the Sku object.
 */

package org.shoppingcartapp;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class JUnitTestSku {
	
	BigDecimal sku1BD = new BigDecimal("0.99");
	BigDecimal sku2BD = new BigDecimal("0.99");
	BigDecimal sku3BD = new BigDecimal("0.54");
	
	Sku sku1 = new Sku();
	Sku sku2 = new Sku();
	Sku sku3 = new Sku();
	Sku sku4 = new Sku();
	Sku sku5 = new Sku();
	Sku sku6 = new Sku();
	
	@Before
	public void setUp() {
		
		sku1.setProductCode("R345");
		sku1.setDescription("Apple");
		sku1.setPrice(sku1BD);
		
		sku2.setProductCode("R345");
		sku2.setDescription("Apple");
		sku2.setPrice(sku1BD);
		
		sku3.setProductCode("R345");
		sku3.setDescription("Apple");
		sku3.setPrice(sku1BD);
		
		sku4.setProductCode("C44");
		sku4.setDescription("Loaf");
		sku4.setPrice(sku3BD);
		
		sku5.setProductCode(null);
		sku5.setDescription(null);
		sku5.setPrice(null);
		
		sku6.setProductCode(null);
		sku6.setDescription(null);
		sku6.setPrice(null);
	}
	
	//reflexive testing
	@Test
    public void reflexiveTest() {
       assertTrue(sku1.equals(sku1));
    }
	
	//symmetric testing
	@Test
    public void symmetricTest1() {
       assertTrue(sku1.equals(sku2));
    }
	
	@Test
    public void symmetricTest2() {
       assertTrue(sku2.equals(sku1));
    }
	
	//transitive testing
	@Test
    public void transitiveTest1() {
       assertTrue(sku2.equals(sku3));
    }
	
	@Test
    public void transitiveTest2() {
       assertTrue(sku1.equals(sku3));
    }
	
	//consistent testing
	@Test
	public void consistentTest1() {
		assertTrue(sku1.equals(sku2));
	}
	
	@Test
	public void consistentTest2() {
		assertTrue(sku1.equals(sku2));
	}
	
	//not equals testing
	@Test
	public void notEqual1() {
		assertFalse(sku1.equals(sku4));
	}
	
	@Test
	public void notEqual2() {
		assertFalse(sku4.equals(sku1));
	}
	
	//null testing
	@Test
	public void objectNotEqualToNullObject() {
		assertFalse(sku1.equals(sku5));
	}
	
	//null objects equal
	@Test
	public void twoNullObjectsEqual() {
		assertTrue(sku5.equals(sku6));
	}
	
	@Test
	public void nullObjectEqualToItself() {
		assertTrue(sku6.equals(sku6));
	}
	
	//hash code equal testing
	@Test
	public void hashCodeEqualBetweenTwoIdenticalObjects() {
		assertTrue(sku1.hashCode() == sku2.hashCode());
	}
	
	//hash code not equal
	@Test
	public void hashCodeNotEqualBetweenTwoDifferentObjects() {
		assertFalse(sku1.hashCode() == sku4.hashCode());
	}
}

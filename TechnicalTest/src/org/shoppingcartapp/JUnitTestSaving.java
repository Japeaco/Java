/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: JUnit tests for the overridden Equals and HashCode methods of the Saving object.
 */

package org.shoppingcartapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class JUnitTestSaving {
	
	BigDecimal saving1BD = new BigDecimal("14.40");
	BigDecimal saving2BD = new BigDecimal("3.50");
	BigDecimal saving3BD = new BigDecimal("2.02");
	
	Saving saving1 = new Saving();
	Saving saving2 = new Saving();
	Saving saving3 = new Saving();
	Saving saving4 = new Saving();
	Saving saving5 = new Saving();
	Saving saving6 = new Saving();
	
	@Before
	public void setUp() {
		
		saving1.setDescription("Apple");
		saving1.setSavingType("Half Price");
		saving1.setTotalSaving(saving1BD);
		
		saving2.setDescription("Apple");
		saving2.setSavingType("Half Price");
		saving2.setTotalSaving(saving1BD);
		
		saving3.setDescription("Apple");
		saving3.setSavingType("Half Price");
		saving3.setTotalSaving(saving1BD);
		
		saving4.setDescription("Banana");
		saving4.setSavingType("BOGOF");
		saving4.setTotalSaving(saving3BD);
		
		saving5.setDescription(null);
		saving5.setSavingType(null);
		saving5.setTotalSaving(null);
		
		saving6.setDescription(null);
		saving6.setSavingType(null);
		saving6.setTotalSaving(null);
	}
	
	//reflexive testing
	@Test
    public void reflexiveTest() {
       assertTrue(saving1.equals(saving1));
    }
	
	//symmetric testing
	@Test
    public void symmetricTest1() {
       assertTrue(saving1.equals(saving2));
    }
	
	@Test
    public void symmetricTest2() {
       assertTrue(saving2.equals(saving1));
    }
	
	//transitive testing
	@Test
    public void transitiveTest1() {
       assertTrue(saving2.equals(saving3));
    }
	
	@Test
    public void transitiveTest2() {
       assertTrue(saving1.equals(saving3));
    }
	
	//consistent testing
	@Test
	public void consistentTest1() {
		assertTrue(saving1.equals(saving2));
	}
	
	@Test
	public void consistentTest2() {
		assertTrue(saving1.equals(saving2));
	}
	
	//not equals testing
	@Test
	public void objectNotEqualToDferentObject() {
		assertFalse(saving1.equals(saving4));
	}
	
	@Test
	public void nullObjectNotEqualToDifferentObject() {
		assertFalse(saving4.equals(saving1));
	}
	
	//null testing
	@Test
	public void objectNotEqualToAnotherNullObject() {
		assertFalse(saving1.equals(saving5));
	}
	
	//null objects equal
	@Test
	public void nullObjectEqualToAnotherNullObject() {
		assertTrue(saving5.equals(saving6));
	}
	
	@Test
	public void nullObjectEqualsItself() {
		assertTrue(saving6.equals(saving6));
	}
	
	//hash code equal testing
	@Test
	public void hashCodeEqualBetweenTwoIdenticalObjects() {
		assertTrue(saving1.hashCode() == saving2.hashCode());
	}
	
	//hash code not equal
	@Test
	public void hashCodeNotEqualBetweenTwoDifferentObjects() {
		assertFalse(saving1.hashCode() == saving4.hashCode());
	}

}

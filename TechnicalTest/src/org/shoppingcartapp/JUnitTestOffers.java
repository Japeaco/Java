package org.shoppingcartapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

public class JUnitTestOffers {
	
	BigDecimal itemPrice = new BigDecimal("2.50");
	BigDecimal multTotalPrice = new BigDecimal("5.00");
	BigDecimal bogofTotalPrice = new BigDecimal("2.50");
	HalfPriceOffer halfPrice = new HalfPriceOffer();
	MultipleOffer multipleOffer = new MultipleOffer(3, multTotalPrice);
	BogofOffer bogofOffer = new BogofOffer(2, bogofTotalPrice);
	
	
	@Test
    public void halfPriceEqualsHalfPriceOfOneItem() {
		BigDecimal expectedSaving = new BigDecimal("1.25");
		assertTrue(halfPrice.totalSavings(1, itemPrice).equals(expectedSaving));
    }
	
	@Test
    public void halfPriceEqualsHalfPriceOfThreeItems() {
		BigDecimal expectedSaving = new BigDecimal("3.75");
		assertTrue(halfPrice.totalSavings(3, itemPrice).equals(expectedSaving));
    }
	
	@Test
    public void halfPriceNotEqualToIncorrectSavingAmount() {
		BigDecimal unExpectedSaving = new BigDecimal("10.00");
		assertFalse(halfPrice.totalSavings(2, itemPrice).equals(unExpectedSaving));
    }
	
	@Test
    public void multiOfferOnThreeItemsEqualsCorrectSavingWhenBuyingThreeItems() {
		BigDecimal expectedSaving = new BigDecimal("2.50");
		assertTrue(multipleOffer.totalSavings(3, itemPrice).equals(expectedSaving));
    }
	
	@Test
    public void multiOfferOnThreeItemsEqualsCorrectSavingWhenBuyingSixItems() {
		BigDecimal expectedSaving = new BigDecimal("5.00");
		assertTrue(multipleOffer.totalSavings(6, itemPrice).equals(expectedSaving));
    }
	
	@Test
    public void multiOfferEqualsNullToAmountOfItemsToEligibleForOffer() {
		assertTrue(multipleOffer.totalSavings(1, itemPrice) == null);
    }
	
	@Test
    public void multiOfferDoesNotEqualIncorrectSavingAmount() {
		BigDecimal expectedSaving = new BigDecimal("5.00");
		assertFalse(multipleOffer.totalSavings(4, itemPrice).equals(expectedSaving));
    }
	
	@Test
    public void bogofEqualsPriceOfOneItemWhenTwoItemsPurchased() {
		BigDecimal expectedSaving = new BigDecimal("2.50");
		assertTrue(bogofOffer.totalSavings(2, itemPrice).equals(expectedSaving));
    }
	
	@Test
    public void bogofEqualsPriceOfOneItemWhenThreeItemsPurchased() {
		BigDecimal expectedSaving = new BigDecimal("2.50");
		assertTrue(bogofOffer.totalSavings(3, itemPrice).equals(expectedSaving));
    }
	
	@Test
    public void bogofEqualsNullWhenOnlyOneItemPurchased() {
		assertTrue(bogofOffer.totalSavings(1, itemPrice) == null);
    }
	
	@Test
    public void bogofOfferDoesNotEqualIncorrectSavingAmount() {
		BigDecimal expectedSaving = new BigDecimal("5.00");
		assertFalse(bogofOffer.totalSavings(7, itemPrice).equals(expectedSaving));
    }

}

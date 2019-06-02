package org.shoppingcartapp;

/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: JUnit tests for the order in which items appear in the list and
 * 	for the correct total saving amount on the Receipt dependent on the Offer Type.
 */

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JUnitTestTill {
	
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
	
	@Test
    public void firstItemAddedToBasketIsExpectedItem() {
		Till till = new Till(store.getSkuList());
		till.scan("C330");
		assertTrue(till.getReceipt().getBasket().get(0).getProductCode().equals("C330"));
    }
	
	@Test
    public void itemsPrintedOnReceiptInOrderScanned() {		
		Till till = new Till(store.getSkuList());
		till.scan("C330");
		till.scan("B45");
		assertTrue(till.getReceipt().getBasket().get(0).getProductCode().equals("C330"));
    }
	
	@Test
    public void oneItemHalfPriceOfferEqualsHalfPriceofOneItem() {		
		BigDecimal expected = new BigDecimal("1.825");
		Till till = new Till(store.getSkuList());
		till.scan("B45");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving().equals(expected));
    }
	
	@Test
    public void twoItemsHalfPriceOfferEqualsHalfPriceOfTwoItems() {		
		BigDecimal expected = new BigDecimal("3.650");
		Till till = new Till(store.getSkuList());
		till.scan("B45");
		till.scan("B45");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving().equals(expected));
    }
	
	@Test
    public void twoItemsBogofOfferEqualsPriceOfOneItem() {		
		BigDecimal expected = new BigDecimal("0.54");
		Till till = new Till(store.getSkuList());
		till.scan("C330");
		till.scan("C330");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving().equals(expected));
    }
	
	@Test
    public void bogofOfferDoesNotApplySoReturnsNull() {		
		Till till = new Till(store.getSkuList());
		till.scan("C330");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving() == null);
    }
	
	@Test
    public void threeItemsBogofOfferEqualsPriceOfOneItem() {		
		BigDecimal expected = new BigDecimal("0.54");
		Till till = new Till(store.getSkuList());
		till.scan("C330");
		till.scan("C330");
		till.scan("C330");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving().equals(expected));
    }
	
	@Test
    public void fourItemsBogofOfferEqualsPriceOfTwoItems() {		
		BigDecimal expected = new BigDecimal("1.08");
		Till till = new Till(store.getSkuList());
		till.scan("C330");
		till.scan("C330");
		till.scan("C330");
		till.scan("C330");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving().equals(expected));
    }
	
	@Test
    public void multipleOfferDoesNotApplySoReturnsNull() {		
		Till till = new Till(store.getSkuList());
		till.scan("H798");
		till.scan("H798");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving() == null);
    }
	
	@Test
    public void threeItemsMultipleOfferApplicableSoSaveExpectedAmount() {		
		BigDecimal expected = new BigDecimal("2.60");
		Till till = new Till(store.getSkuList());
		till.scan("H798");
		till.scan("H798");
		till.scan("H798");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving().equals(expected));
    }
	
	@Test
    public void fourItemsMultipleOfferApplicableOnThreeItemsSoSaveExpectedAmount() {		
		BigDecimal expected = new BigDecimal("2.60");
		Till till = new Till(store.getSkuList());
		till.scan("H798");
		till.scan("H798");
		till.scan("H798");
		till.scan("H798");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving().equals(expected));
    }
	
	@Test
    public void sixItemsMultipleOfferApplicable() {		
		BigDecimal expected = new BigDecimal("5.20");
		Till till = new Till(store.getSkuList());
		till.scan("H798");
		till.scan("H798");
		till.scan("H798");
		till.scan("H798");
		till.scan("H798");
		till.scan("H798");
		assertTrue(till.getReceipt().getSavingList().get(0).getTotalSaving().equals(expected));
    }
	
}

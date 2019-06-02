/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: JUnit tests for the parsing of a text file to the Store object.
 */

package org.shoppingcartapp;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class JUnitTestStore {
	
	Store store = new Store();
	ArrayList<Sku> skuList = new ArrayList<>();
	
	@Test
    public void fileParsesAndFirstItemInStoreListIsSameAsFile() throws IOException {
		skuList = store.parseFile("C:\\Users\\japea\\OneDrive\\Pictures\\University\\Year4\\SkuFile.txt");
		store.setSkuList(skuList);
		assertTrue(store.getSkuList().get(0).getProductCode().equals("H57"));
    }	
	
	@Test
    public void fileParsesAndLastItemInStoreListIsSameAsFile() throws IOException {
		skuList = store.parseFile("C:\\Users\\japea\\OneDrive\\Pictures\\University\\Year4\\SkuFile.txt");
		store.setSkuList(skuList);
		assertTrue(store.getSkuList().get((store.getSkuList().size())-1).getProductCode().equals("K65"));
    }	
}

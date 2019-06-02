/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: Till class where Sku objects can be 'scanned' and added to a basket list;
 * 	the Receipt method returns this list of Sku objects, as well as a second list
 * 	that calculates total amount saved dependent on the Offer Type of the Sku object.
 */

package org.shoppingcartapp;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Till {

	private ArrayList<Sku> basket = new ArrayList<>();
	private ArrayList<Sku> skuList = new ArrayList<>();
	
	public Till(ArrayList<Sku> skuList){
		this.skuList = skuList;
	}
	
	public ArrayList<Sku> getBasket() {
		return basket;
	}
	
	public void scan(String productCode) {
		
		for(int i = 0; i < skuList.size(); i++) {
			if(skuList.get(i).getProductCode().equals(productCode)) {
				getBasket().add(skuList.get(i));
				break;
			}
			else if(i == skuList.size() - 1) {
				throw new IllegalArgumentException("Error: Product not found");
			}
		}	
	}
	
	/*Calculates the total amount saved dependent on the Offer Type
	 * If a Sku with an Offer Type is found then the method counts how many of that Sku are in the list based on their Product Code.
	 * The appropriate Offer Type is then called, based on the Offer Type String, and total Savings are calculated.
	 * A new Saving object is populated with this information and added to a savingList.
	 * The list of 'scanned' Sku objects, and a list of total savings, are returned.
	 */
	public Receipt getReceipt(){
		
		ArrayList<String> usedCodes = new ArrayList<>();
		ArrayList<Saving> savingList = new ArrayList<>();
		Receipt receipt = new Receipt();
		int quantity = 0;
		
		for(int i = 0; i < getBasket().size(); i++) {
			if(getBasket().get(i).getOffer() != null && !(usedCodes.contains(getBasket().get(i).getProductCode()))) {
				for(int j = 0; j < getBasket().size(); j++) {
					if(getBasket().get(j).getProductCode().equals(getBasket().get(i).getProductCode())) {
						quantity++;
					}
				}
				
				Saving save = new Saving();
				BigDecimal totalSavings = getBasket().get(i).getOffer().totalSavings(quantity, getBasket().get(i).getPrice());
				save.setDescription(getBasket().get(i).getDescription());
				save.setSavingType(getBasket().get(i).getOffer().toString());
				save.setTotalSaving(totalSavings);
				quantity = 0;
				
				savingList.add(save);
				usedCodes.add(getBasket().get(i).getProductCode());
			}
		}
		
		receipt.setBasket(getBasket());
		receipt.setSavingList(savingList);
		
		return receipt;
		
	}
	
	@Override
	public final String toString() {

		String txt = "";
		
		for(int i = 0; i < basket.size(); i++) {
			txt += basket.get(i).toString() + "\n";
		}
		
		return txt;
	}	

}

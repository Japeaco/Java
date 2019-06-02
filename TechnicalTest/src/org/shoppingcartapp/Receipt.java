/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: Receipt object that contains the list of Sku objects 'scanned', as well as
 * 	a list of all the total savings dependent on the Offer Type of each Sku object.
 */

package org.shoppingcartapp;

import java.util.ArrayList;

public class Receipt {
	
	private ArrayList<Sku> basket = new ArrayList<Sku>();
	private ArrayList<Saving> savingList = new ArrayList<Saving>();
	
	public Receipt() {}
	
	public void setBasket(ArrayList<Sku> basket) {
		this.basket = basket;
	}
	
	public ArrayList<Sku> getBasket() {
		return basket;
	}
	
	public void setSavingList(ArrayList<Saving> savingList) {
		this.savingList = savingList;
	}
	
	public ArrayList<Saving> getSavingList() {
		return savingList;
	}
	
	@Override
	public String toString() {
		
		String txt = "";
		
		for(int i=0; i < basket.size(); i++) {
			txt += basket.get(i).toString() + "\n";
		}
		
		for(int i=0; i<savingList.size(); i++) {
			txt += savingList.get(i).toString() + "\n";
		}
		
		return txt;
	}
}

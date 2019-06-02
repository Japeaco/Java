/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: Store object with a skuList field that returns a list of all Sku objects.
 * 	Text files can be parsed to the object, which populates the list of items in the store;
 * 	the items can then be 'scanned' by the Till and a Receipt is returned.
 */

package org.shoppingcartapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store{
	
	private ArrayList<Sku> skuList = new ArrayList<>();
	
	public Store(){}
	
	public void setSkuList(ArrayList<Sku> skuList) {
		this.skuList = skuList;
	}
	
	public ArrayList<Sku> getSkuList() {
		return skuList;
	}
	
	/*parses a text file and creates new Sku objects that are added to the skuList
	 * The first line is ignored as this contains headers such as 'Product Code', and not Sku's
	 */
	public ArrayList<Sku> parseFile(String filename) throws IOException{
		
		Sku sku = new Sku();
		ArrayList<Sku> list = new ArrayList<>();
		
		try (FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr)){
			br.readLine();
			String line;
			while((line = br.readLine()) != null) {
				sku = sku.parser(line);
				list.add(sku);	
			}
		}	
		return list;
	}
	
	/*Reads in user input of Product Codes and returns a Receipt object of scanned items and total saving details
	 * See the 'GetReceipt' method of the Till class for more information
	 */
	public Receipt scanItems() {
		
		Till till = new Till(getSkuList());
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		while(!(input = sc.nextLine()).equals("*")) {
			till.scan(input);
		}
		sc.close();
		return till.getReceipt();
	}
	
	@Override
	public String toString() {
		
		String txt = "";
		
		for(int i=0; i < skuList.size(); i++) {
			txt += skuList.get(i).toString() + "\n";
		}
		
		return txt;
	}	
}

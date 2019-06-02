/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: Saving object with Description, savingType and totalSaving fields.
 */

package org.shoppingcartapp;

import java.math.BigDecimal;

public class Saving implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3269560739463699621L;
	private String description;
	private String savingType;
	private BigDecimal totalSaving;
	
	public Saving(){}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescripton() {
		return description;
	}
	
	public void setSavingType(String savingType) {
		this.savingType = savingType;
	}
	
	public String getSavingType() {
		return savingType;
	}
	
	public void setTotalSaving(BigDecimal totalSaving) {
		this.totalSaving = totalSaving;
	}
	
	public BigDecimal getTotalSaving() {
		return totalSaving;
	}
	
	@Override
	public final boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Sku)) {
			return false;
		}
		
		Saving other = (Saving) o;
		
		boolean descriptionEquals = (this.description == null && other.description == null) 
				|| (this.description!= null && this.description == other.description);
		boolean savingTypeEquals = (this.savingType == null && other.savingType == null) 
				|| (this.savingType != null && this.savingType == other.savingType);
		boolean totalSavingEquals = (this.totalSaving == null && other.totalSaving == null) 
				|| (this.totalSaving != null && this.totalSaving == other.totalSaving);
		
		return descriptionEquals && savingTypeEquals && totalSavingEquals;
	}
	
	@Override
	public final int hashCode() {
		int result = 17;
		
		if(description != null) {
			result = 31 * result + description.hashCode();
		}
		if(savingType != null) {
			result = 31 * result + savingType.hashCode();
		}
		if(totalSaving != null) {
			result = 31 * result + totalSaving.hashCode();
		}
		return result;
	}

	@Override
	public String toString() {
		
		return "Description: " + this.getDescripton() + ", Saving Type: " + this.getSavingType() + ", Total Saving: " + this.getTotalSaving();
	}
}

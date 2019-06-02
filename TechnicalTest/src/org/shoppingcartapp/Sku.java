/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: Sku object with Product Code, Description, Price, and Offer Type fields.
 */

package org.shoppingcartapp;
import java.math.BigDecimal;

public class Sku implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6256837298372311377L;
	private String productCode;
	private String description;
	private BigDecimal price;
	private Offer offer;
	
	public Sku() {}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	public Offer getOffer() {
		return offer;
	}
	
	/* Creates new Sku Object from a parsed String; 
	 * the string is split via the tab key and each section is parsed to the appropriate field of the Sku object
	 * The Offer Type is based on which word is parsed, such as Half Price, BOGOF, or the Regular expression e.g. '1 for 5.00'
	 */
	public Sku parser(String parsedString) {
		
		String[] split = parsedString.split("	");
		final String pattern = "^[0-9]+\\sfor\\s[0-9]+.[0-9]+";
		
		Sku sku = new Sku();
		
		sku.setProductCode(split[0]);
		sku.setDescription(split[1]);
		BigDecimal p = new BigDecimal(split[2]);
		sku.setPrice(p);
		
		if(split.length == 4) {
				switch (split[3]) {
					case "Half Price":
						HalfPriceOffer halfprice = new HalfPriceOffer();
						sku.setOffer(halfprice);
						break;
					case "BOGOF":
						BogofOffer bogofOffer = new BogofOffer(2, p);
						sku.setOffer(bogofOffer);
						break;
					case pattern:
						String[] sp = split[3].split(" ");
						int count = Integer.parseInt(sp[0]);
						BigDecimal totalPrice = new BigDecimal(sp[2]);
						MultipleOffer multipleOffer = new MultipleOffer(count, totalPrice);
						sku.setOffer(multipleOffer);
						break;
					default:
						break;
			}		
		}
		return sku;	
	}
	
	@Override
	public final boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof Sku)) {
			return false;
		}
		
		Sku other = (Sku) o;
		
		boolean productCodeEquals = (this.productCode == null && other.productCode == null) 
				|| (this.productCode != null && this.productCode == other.productCode);
		boolean descriptionEquals = (this.description == null && other.description == null) 
				|| (this.description!= null && this.description == other.description);
		boolean priceEquals = (this.price == null && other.price == null) 
				|| (this.price != null && this.price == other.price);
		
		return productCodeEquals && descriptionEquals && priceEquals;
	}
	
	@Override
	public final int hashCode() {
		int result = 17;
		
		if(productCode != null) {
			result = 31 * result + productCode.hashCode();
		}
		if(description != null) {
			result = 31 * result + description.hashCode();
		}
		if(price != null) {
			result = 31 * result + price.hashCode();
		}
		return result;
	}
	
	@Override
	public final String toString() {
		
		String string = "Product Code: " + this.productCode + ", Description: " + this.description 
				+ ", Price: " + this.price;
		
		if(this.offer != null) {
			return string + ", Offer: " + this.offer.toString();
		}
		else {
			return string;
		}
	}
}

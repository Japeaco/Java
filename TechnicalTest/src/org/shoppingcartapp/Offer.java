/**
 * Date: 02/06/2019
 * Author: James Alexander Peacock
 * Purpose: Interface for objects of type Offer; each class made of this type must include the totalSavings method.
 */

package org.shoppingcartapp;

import java.math.BigDecimal;

public interface Offer {

	BigDecimal totalSavings(int quantity, BigDecimal itemPrice);
	
}

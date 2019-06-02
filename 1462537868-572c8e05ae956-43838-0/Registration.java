/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: Creates a registration object with a unique registration number consisting of a letter and a four
 * digit number
 */

package project1;

import java.util.HashMap;
import java.util.Map;

public final class Registration{
	
	private static int i = 0;

	private final String number;
	private static final Map<String, Registration> REG = new HashMap<String, Registration>();

	public Registration(String number) {
		this.number = number;
		
		if(number == null)
			throw new NullPointerException();
	}

	public String getNumber() {
		return number;
	}
	    
	public String toString() {
		return number;
	}

	//factory that produces a unique registration number
    public static Registration getInstance() 
    {
    	i++;
    	char letter = (char)('a' + (i / 10000));
    	int number = i % 10000;
    	
    	//converts the variables to a string
    	final String k = String.valueOf(letter + number);
    	
    	//if the number does not already exist in the map, then create the new registration number
    	if(!REG.containsKey(k))
    		REG.put(k, new Registration(String.format("%s%04d", letter, number)));
    	
    	//return the registration number
    	return REG.get(k);
    }	         
}


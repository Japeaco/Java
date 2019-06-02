/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: Creates a license number object with a unique number consisting of the initials, year of issue and
 * a serial number
 */

package project1;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class LicenseNumber{
	
	private static int i = 0;

	public final String number;
	private static final Map<String, LicenseNumber> NUMB = new HashMap<String, LicenseNumber>();
	
	public LicenseNumber(String number)
	{
		this.number = number;
		
		if(number == null)
			throw new NullPointerException();
	}

	public String getnumber()
	{
		return number;
	}
	
	public String toString()
	{
		return number;
	}
	
	//method that produces a unique license number
	public static LicenseNumber getInstance(Name name, Date doi) 
	{
	    i++;
	    //return the initials and the year of issue
	    String initials = name.getFirstName().substring(0, 1) 
	        	+ name.getLastName().substring(0, 1);
	    String year = doi.toString().substring(24, 28);
	    
	    int val = i % 100;
	    
	    //convert variables to a string
	    final String k = String.valueOf(val);
    	
	    //if the license number does not already exist in the map, then create the new license number
    	if(!NUMB.containsKey(k))
    		NUMB.put(k, new LicenseNumber(String.format("%s-%s-%02d", initials, year, val)));
    	
    	//return the license number
    	return NUMB.get(k);
	}
     
}

/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: Creates a name object consisting of a first and second name
 */

package project1;

public final class Name {
	
	private String firstName;
	private String lastName;
	
	public Name(String firstName, String lastName){		
		
		this.firstName = firstName;
		this.lastName = lastName;
		
		if (firstName == null || lastName == null)
			 throw new NullPointerException();
	}

	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
}
/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: To test the uniqueness of the registration numbers
*/

package project1;

public class RegistrationTest {
	
	public static void main(String args[]){
		
		//test to determine if registration numbers are different/unique
		System.out.println(Registration.getInstance());
		System.out.println(Registration.getInstance());
		System.out.println(Registration.getInstance());
		System.out.println(Registration.getInstance());
		
	}

}

/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: A car interface that establishes the methods to be used in my small and large car classes.
 */

package project1;

public interface Car {
	
	//method to return registration number
	public String getRegistration();
	
	//method to set if car has been rented
	public boolean setRented(boolean rented);
	
	//returns whether car has been rented
	public boolean getRented();
	
	//returns capacity of the tank
	public int Capacity();
	
	//returns amount of fuel currently in the tank
	public int getFuelInTank();
	
	//returns whether tank is full
	public boolean isTankFull();
	
	//method that adds fuel to the tank
	public int addFuel();
	
	//method that drives the car and returns amount of fuel consumed
	public int drive(int kilometresDriven);

}

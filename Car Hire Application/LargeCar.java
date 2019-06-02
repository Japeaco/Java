/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: Creates a large car object that implements the car interface with a registration number, whether
 * it is rented or not, and establishes how much fuel is in the tank
 */

package project1;

public final class LargeCar implements Car{
	
	final private String reg;
	private boolean rented;
	private int fuelInTank;
	private double fuelConsumed;
		
	/**
	 * Creates a large car object with a registration number, and fuel capacity.
	 */
	public LargeCar()
	{
		Registration reg = Registration.getInstance();
		String str = reg.toString();
		this.reg = str;
		this.rented = getRented();
		this.fuelInTank = Capacity();
	}
	
	public String getRegistration(){
		return reg;
	}
	
	public boolean setRented(boolean rented){
		return this.rented = rented;
	}

	public boolean getRented() {
		return rented;
	}

	public int Capacity() {

		int capacity = Integer.valueOf(65);
		
		return capacity;
	}

	public int getFuelInTank() {
		return fuelInTank;
	}

	public boolean isTankFull() {

		boolean isTankFull = false;
		
		//if fuel in tank matches the capacity return true
		if (getFuelInTank() == Capacity())
			isTankFull = true;
		
		//return boolean
		return isTankFull;
	}

	public int addFuel() {

		int addFuelToTank = 0;
		
		//if tank is full add no fuel to the tank
		if (isTankFull() == true)
			addFuelToTank = 0;
		//if tank is not full then amount of fuel needed was amount consumed
		if (isTankFull() == false)
			addFuelToTank = (int) fuelConsumed;
		
		//add fuel to the tank
		fuelInTank += addFuelToTank;	
		
		//return amount of fuel added
		return (int) fuelConsumed;
	}

	public int drive(int kilometresDriven) {
		
		//if car has been rented and there is fuel in the tank
		if(getRented() == true && getFuelInTank() > 0){
			//first 50km consumes one litre per 15km
			if(kilometresDriven <= 50)
				fuelConsumed = (kilometresDriven/15) + 1;
			//after first 50km consumes one litre per 20km
			if(kilometresDriven > 50)
				fuelConsumed = ((50/15) + 1) + (((kilometresDriven-50)/20) + 1);
		}
		//if the car is not rented or the tank is empty no fuel will be consumed/car will not be driven
		else if(getRented() == false || getFuelInTank() <= 0)
			fuelConsumed = 0;
		
		//deduct fuel consumed from fuel in the tank
		fuelInTank = getFuelInTank() - (int) fuelConsumed;
		
		//return fuel consumed
		return (int) fuelConsumed;
	}
	
	public String toString()
	{
		return ("\nRegistration: " + getRegistration() + "\nCar Type: Large" + "\nFuel: " + getFuelInTank() + "\nRented: " + getRented());
	}

}

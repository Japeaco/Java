/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: A car hire rental system that prints the cars available for rent, returns a collection of the cars
 * currently rented, issues the car to a driving license, returns the car associated with the driving license,
 * and terminates the rental from the driving license.
 */

package project1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CarHire {
	
	public static int MAX_NUMBER_OF_SMALL_CARS = 20;
	public static int MAX_NUMBER_OF_LARGE_CARS = 10;
	public static int MAX_NUMBER_OF_RENTED_CARS = 1;
	private final List<Car> smallCars;
	private final List<Car> largeCars;
	
	/**
	 * @param small
	 * @param large
	 * CarHire object that uses both a list of small cars and large cars
	 */
	public CarHire(List<Car> small, List<Car> large)
	{
		this.smallCars = small;
		this.largeCars = large;
	}
	
	/**
	 * @param typeOfCar
	 * @return
	 * This method returns the number of cars of the specified type that are available to rent
	 */
	public int availableCars(String typeOfCar) 
	{
		int available = 0;
		
		//if the type of car is of type small
		if(typeOfCar == "small" || typeOfCar == "Small"){
			//loop through the maximum number of small cars; 20
			for (int i = 0; i < MAX_NUMBER_OF_SMALL_CARS; i++) 
			{
				//if there is a car and it is not currently rented
				if (smallCars.get(i) != null && smallCars.get(i).getRented() != true) 
					//increment available
						available++;
			}
		}
		//if the type of car is of type large
		else if(typeOfCar == "large" || typeOfCar == "Large"){
			//loop through the maximum number of large cars; 10
			for (int i = 0; i < MAX_NUMBER_OF_LARGE_CARS; i++) 
			{
				//if there is a car and it is not currently rented
				if (largeCars.get(i) != null && largeCars.get(i).getRented() != true)
					//Increment available
						available++;
			}
		}
		//if the type of car is neither small nor large, return 0
		else{
			available = 0;
		}
		
		//return number of available cars
		return available;
	}
	
	/**
	 * @return
	 * This method returns a collection of all that cars that are currently rented
	 */
	public List<Car> getRentedCars()  
	{
			List<Car> Rented = new ArrayList<>();
			
			//loop through maximum number of small cars; 20
			for (int i = 0; i < MAX_NUMBER_OF_SMALL_CARS; i++) 
			{
				//if there is a car and it is currently rented, add it to the list
				if (smallCars.get(i) != null && smallCars.get(i).getRented() == true) 
						Rented.add(smallCars.get(i));
			}
			//loop through maximum number of large cars; 10
			for (int i = 0; i < MAX_NUMBER_OF_LARGE_CARS; i++) 
			{
				//if there is a car and it is currently rented, add it to the list
				if (largeCars.get(i) != null && largeCars.get(i).getRented() == true) 
						Rented.add(largeCars.get(i));
			}
		
		//return the list
		return Rented;
	}
 
	/**
	 * @param drivingLicense
	 * @param typeOfCar
	 * @return
	 *  method determines whether the person is eligible to rent a car of the specified type and,
	 *  if there is a car available, issues and associates that car with the driving license
	 */
	public String issueCar(DrivingLicense drivingLicense, String typeOfCar) 
	{		
		  Calendar cal = Calendar.getInstance();
	      int year = cal.get(Calendar.YEAR);
	      int month = cal.get(Calendar.MONTH);
	      int day = cal.get(Calendar.DAY_OF_MONTH);
	      int age = Integer.parseInt(drivingLicense.getDateOfBirth().toString().substring(24, 28));
	      int issue = Integer.parseInt(drivingLicense.getDateOfBirth().toString().substring(24, 28));
	      Boolean valid = drivingLicense.isLicenseValid();
	      List<Car> car = drivingLicense.carAssociated();
	      
	    //if the type of car is of type small
	      if(typeOfCar == "small" || typeOfCar == "Small"){
	    	  //if the driving license is valid, is over 21 years old and has held the license for a year
	    	  if(valid == true && year - age >= 21 && year - issue >= 1){
	    		  //method call to find a free small car
	    		  	int i = findFreeSmallCar();
	    		  	//if size of list is less than 1
	    		  		if(car.size() < MAX_NUMBER_OF_RENTED_CARS){
	    		  			//add a small car to the list and set the car as rented
	    		  			car.add(smallCars.get(i));
	    		  			smallCars.get(i).setRented(true);
	    		  		}
	    	  }
	      }
	    //if the type of car is of type large
	      else if(typeOfCar == "large" || typeOfCar == "Large"){
	    	//if the driving license is valid, is over 25 years old and has held the license for 5 years
	    	  if(valid == true && year - age >= 25 && year - issue >= 5){
	    		  //method call to find a free large car
	    		  	int i = findFreeLargeCar();
	    		  	//if size of list is less than 1
	    		  		if(car.size() < MAX_NUMBER_OF_RENTED_CARS){
	    		  			//add a small car to the list and set the car as rented
	    		  			car.add(largeCars.get(i));
	    		  			smallCars.get(i).setRented(true);
	    		  		}
	    	  }
	      }
	      else
	      {
	    	  //if conditions for rental are not met then print statement
	    	  return "Car cannot be issued.";
	      }
	      
	    return "Car can be issued.";
	}
	
	/**
	 * @return
	 * method locates a free small car that is available to rent
	 */
	private int findFreeSmallCar() {
		
		int i;
		//loops through the maximum number of small cars; 20
		for (i = 0; i < MAX_NUMBER_OF_SMALL_CARS; i++) {
			//if there is a car, it is not currently rented, and its tank is full, return that car
			if (smallCars.get(i) != null && smallCars.get(i).getRented() == false && smallCars.get(i).isTankFull() == true) {
				break;
			}
		}
		//return car
		return i;
		
	}
	
	/**
	 * @return
	 *method locates a free large car that is available to rent
	 */
	private int findFreeLargeCar() {
		
		int i;
		//loops through the maximum number of large cars; 10
		for (i = 0; i < MAX_NUMBER_OF_LARGE_CARS; i++) {
			//if there is a car, it is not currently rented, and its tank is full, return that car
			if (largeCars.get(i) != null && largeCars.get(i).getRented() == false && largeCars.get(i).isTankFull() == true) {
				break;
			}
		}
		//return car
		return i;
	}

	/**
	 * @param drivingLicense
	 * @return
	 * 	method to return the car someone is currently renting
	 */
	public List<Car> getCar(DrivingLicense drivingLicense) 
	{
		//returns list of single car currently associated with the driving license
		return drivingLicense.carAssociated();	
	}
	
	/**
	 * @param drivingLicense
	 * @return
	 * method disassociates the car currently rented with the driving license and returns fuel to fill the tank
	 */
	public int terminateRental(DrivingLicense drivingLicense) 
	{
		List<Car> car = drivingLicense.carAssociated();	
		int i;

		//loops through maximum number of rented cars; 1
		for (i = 0; i < MAX_NUMBER_OF_RENTED_CARS; i++) {
			//if a car is there, break
			if (car != null) {
				break;
			}
		}
		
		//change cars status to not rented and remove it from the driving license
		car.get(i).setRented(false);
		int fuelConsumed = car.get(i).Capacity() - car.get(i).getFuelInTank();
		car.remove(i);
		
		//return fuel required to fill the tank
		return fuelConsumed;
	}
}


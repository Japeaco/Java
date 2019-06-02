/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: Multiple tests to test the methods within my CarHire class
 */

package project1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CarHireTest 
{
	public static void main(String args[])
	{	
		//create small and large car lists
		ArrayList<Car> small = new ArrayList<Car>();
		ArrayList<Car> large = new ArrayList<Car>();
		
		//add small cars to list
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		small.add(new SmallCar());
		
		//add large cars to list
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		large.add(new LargeCar());
		
		//add both lists to CarHire object
		CarHire list = new CarHire(small, large);
		
		//create Calendar objects
		Calendar dobcalendar = new GregorianCalendar();
		Calendar doicalendar = new GregorianCalendar();

		//set date of birth
		dobcalendar.set(Calendar.YEAR, 1975);
		dobcalendar.set(Calendar.MONTH, 11);
		dobcalendar.set(Calendar.DAY_OF_MONTH, 31);
		
		//set date of issue
		doicalendar.set(Calendar.YEAR, 1999);
		doicalendar.set(Calendar.MONTH, 8);
		doicalendar.set(Calendar.DAY_OF_MONTH, 25);
		
		Calendar dobcalendar2 = new GregorianCalendar();
		Calendar doicalendar2 = new GregorianCalendar();

		dobcalendar2.set(Calendar.YEAR, 1969);
		dobcalendar2.set(Calendar.MONTH, 5);
		dobcalendar2.set(Calendar.DAY_OF_MONTH, 12);
		
		doicalendar2.set(Calendar.YEAR, 1990);
		doicalendar2.set(Calendar.MONTH, 7);
		doicalendar2.set(Calendar.DAY_OF_MONTH, 19);
		
		//create list for associated car
		List<Car> driv1car = new ArrayList<Car>();
		//create Name object for driving license
		Name name1 = new Name("James", "Peacock");
		//create DrivingLicense object
		DrivingLicense driv1 = new DrivingLicense(name1, dobcalendar.getTime(), doicalendar.getTime(), true, driv1car);
		
		//create list for associated car
		List<Car> driv2car = new ArrayList<>();
		//create Name object for driving license
		Name name2 = new Name("David", "Peacock");
		//create DrivingLicense object
		DrivingLicense driv2 = new DrivingLicense(name2, dobcalendar2.getTime(), doicalendar2.getTime(), true, driv2car);
		
		//print available cars and cars that are currently rented out
		System.out.printf("Small cars available to rent: %s%n", list.availableCars("small"));
		System.out.printf("Large cars available to rent: %s%n", list.availableCars("large"));
		System.out.printf("Cars currently rented: %s%n", list.getRentedCars());
		//print out driving licenses
		System.out.printf("%n%s%n", driv1);
		System.out.printf("%s%n", driv2);
		
		//issue car to driving license
		list.issueCar(driv1, "small");
		//show car is associated with driving license
		System.out.printf("%nCar associated with driving license: %s%n", list.getCar(driv1));
		
		//show car has been rented
		System.out.printf("%nSmall cars available to rent: %s%n", list.availableCars("small"));
		System.out.printf("Large cars available to rent: %s%n", list.availableCars("large"));
		System.out.printf("Cars currently rented: %s%n", list.getRentedCars());
		
		//show fuel consumed after being driven and fuel required to fill tank
		driv1car.get(0).drive(400);
		System.out.printf("%nFuel required to fill the tank after being driven: %d%n", list.terminateRental(driv1));
		
		//show car is no long associated with the driving license after terminating rental
		System.out.printf("%nCar disassociated with driving license and returned: %s%n", list.getCar(driv1));
		
		//show all cars are now available to rent again
		System.out.printf("%nSmall cars available to rent: %s%n", list.availableCars("small"));
		System.out.printf("Large cars available to rent: %s%n", list.availableCars("large"));
		System.out.printf("Cars currently rented: %s%n", list.getRentedCars());
		
		//show next car to be issued is different from first because tank is not full in first car
		list.issueCar(driv2, "small");
		System.out.printf("%nCar associated with driving license: %s%n", list.getCar(driv2));
		
		//show adding a second car to the same driving license does nothing
		list.issueCar(driv2, "small");
		System.out.printf("%nCar associated with driving license: %s%n", list.getCar(driv2));

	}
}



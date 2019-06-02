/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: Class to test the uniqueness of the license numbers
 */

package project1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DrivingLicenseTest 
{

	public static void main(String args[])
	{
		Calendar dobcalendar = new GregorianCalendar();
		Calendar doicalendar = new GregorianCalendar();

		dobcalendar.set(Calendar.YEAR, 1994);
		dobcalendar.set(Calendar.MONTH, 3);
		dobcalendar.set(Calendar.DAY_OF_MONTH, 29);
		
		doicalendar.set(Calendar.YEAR, 2013);
		doicalendar.set(Calendar.MONTH, 8);
		doicalendar.set(Calendar.DAY_OF_MONTH, 25);
		
		Calendar dobcalendar2 = new GregorianCalendar();
		Calendar doicalendar2 = new GregorianCalendar();

		dobcalendar2.set(Calendar.YEAR, 1970);
		dobcalendar2.set(Calendar.MONTH, 5);
		dobcalendar2.set(Calendar.DAY_OF_MONTH, 12);
		
		doicalendar2.set(Calendar.YEAR, 1990);
		doicalendar2.set(Calendar.MONTH, 4);
		doicalendar2.set(Calendar.DAY_OF_MONTH, 19);
		
		Calendar dobcalendar3 = new GregorianCalendar();
		Calendar doicalendar3 = new GregorianCalendar();

		dobcalendar3.set(Calendar.YEAR, 1998);
		dobcalendar3.set(Calendar.MONTH, 2);
		dobcalendar3.set(Calendar.DAY_OF_MONTH, 12);
		
		doicalendar3.set(Calendar.YEAR, 2016);
		doicalendar3.set(Calendar.MONTH, 4);
		doicalendar3.set(Calendar.DAY_OF_MONTH, 19);
		
		Name name1 = new Name("James", "Peacock");
		DrivingLicense driv1 = new DrivingLicense(name1, dobcalendar.getTime(), doicalendar.getTime(), true, null);
		System.out.println(driv1);
		
		Name name2 = new Name("David", "Peacock");
		DrivingLicense driv2 = new DrivingLicense(name2, dobcalendar2.getTime(), doicalendar2.getTime(), true, null);
		System.out.println("\n\n" + driv2);
		
		Name name3 = new Name("John", "Smith");
		DrivingLicense driv3 = new DrivingLicense(name3, dobcalendar3.getTime(), doicalendar3.getTime(), true, null);
		System.out.println("\n\n" + driv3);
		
		
	}

}


/**
 * Date: 07/05/2016
 * Author: James Peacock
 * Purpose: A class that creates a driving license with a name, date of birth, date of issue, whether is is valid
 * or not, an associated car and a unique license number.
 */

package project1;

import java.util.Date;
import java.util.List;

public final class DrivingLicense {
	
	private final Name name;
	private final Date dateOfBirth;
	private final Date dateOfIssue;
	private final boolean valid;
	private final List<Car> carAssociated;
	private final String number;
	
	public DrivingLicense(Name name, Date dateOfBirth, Date dateOfIssue, boolean valid, List<Car> carAssociated)
	{
		LicenseNumber lic = LicenseNumber.getInstance(name, dateOfIssue);
		String str = lic.toString();
		this.number = str;
		this.name = new Name(name.getFirstName(), name.getLastName());
		this.dateOfBirth = new Date (dateOfBirth.getTime());
		this.dateOfIssue = new Date (dateOfIssue.getTime());
		this.valid = valid;
		this.carAssociated = carAssociated;
		
		if (str == null || name == null || dateOfBirth == null || dateOfIssue == null)
			 throw new NullPointerException();
	}
	
	public String getLicenseNumber()
	{
		return number;
	}
	
	public Name getName()
	{
		return new Name(name.getFirstName(), name.getLastName());
	}

	public Date getDateOfBirth()
	{
		return (Date) dateOfBirth.clone();
	}
	
	public Date getDateOfIssue()
	{
		return (Date) dateOfIssue.clone();
	}

	public Boolean getValid()
	{
		return valid;
	}
	
	public List<Car> carAssociated()
	{
		return carAssociated;
	}
	
	public boolean isLicenseValid()
	{
		boolean isLicenseValid = false;
		
		if (getValid() == true)
			isLicenseValid = true;
		
		return isLicenseValid;
			
	}
	
	public String toString()
	{
		return "Name: " + getName() + "\nDate Of Birth: " + getDateOfBirth().toString().substring(4,11)
				+ getDateOfBirth().toString().substring(24,28)+ "\nDate Of Issue: " 
				+ getDateOfIssue().toString().substring(4,11) + getDateOfIssue().toString().substring(24,28) 
				+ "\nValid: " + isLicenseValid() + "\nLicense Number: " + getLicenseNumber();
	}

}

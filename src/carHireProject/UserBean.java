package carHireProject;

public class UserBean {
	
	private int customerID ;

	private String FirstName ; 
	private String Surname ;
	private String DrivingLicense ; 
	private int AddressID ; 
	
	public UserBean(int customerID, String FirstName, String Surname, String DrivingLicense, int AddressID) {
		this.customerID = customerID ;
		this.FirstName = FirstName ;
		this.Surname = Surname ;
		this.DrivingLicense = DrivingLicense ;
		this.AddressID = AddressID ; 
	}
	
	public UserBean() {}


public int getCustomerID() {
	return customerID;
}

public void setCustomerID(int customerID) {
	this.customerID = customerID;
}

public String getFirstName() {
	return FirstName;
}

public void setFirstName(String firstName) {
	FirstName = firstName;
}

public String getSurname() {
	return Surname;
}

public void setSurname(String surname) {
	Surname = surname;
}

public String getDrivingLicense() {
	return DrivingLicense;
}

public void setDrivingLicense(String drivingLicense) {
	DrivingLicense = drivingLicense;
}

public int getAddressID() {
	return AddressID;
}

public void setAddressID(int addressID) {
	AddressID = addressID;
}
}
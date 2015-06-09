package carHireProject;

public class LoginBean {

	private int customerID ; 
	private String username ; 
	private String password ; 
	
	public LoginBean( int customerID, String username, String password) {
		this.customerID = customerID ; 
		this.username = username ;
		this.password = password ;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

package carHireProject;

import java.time.LocalDate;

public class ContractBean {

	private int ContractID ;
	private int CustomerID ;
	private int VehicleID ;
	private LocalDate HiredFrom ;
	private LocalDate HiredUntill ;
	
	public ContractBean (int ContractID, int CustomerID, int VehicleID, LocalDate HiredFrom, LocalDate HiredUntill) {
		this.ContractID = ContractID ;
		this.CustomerID = CustomerID ;
		this.VehicleID = VehicleID ;
		this.HiredFrom = HiredFrom ;
		this.HiredUntill = HiredUntill ;
	}

	public int getContractID() {
		return ContractID;
	}

	public void setContractID(int contractID) {
		ContractID = contractID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public int getVehicleID() {
		return VehicleID;
	}

	public void setVehicleID(int vehicleID) {
		VehicleID = vehicleID;
	}

	public LocalDate getHiredFrom() {
		return HiredFrom;
	}

	public void setHiredFrom(LocalDate hiredFrom) {
		HiredFrom = hiredFrom;
	}

	public LocalDate getHiredUntill() {
		return HiredUntill;
	}

	public void setHiredUntill(LocalDate hiredUntill) {
		HiredUntill = hiredUntill;
	}
	
	
	
}

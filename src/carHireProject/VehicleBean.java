package carHireProject;

public class VehicleBean {
	
	private int VehicleID ;
	private String Category ; 
	private String Make ;
	private String Model ;
	private float EngineSize ;
	private float PricePerDay ;
	private String FuelType ;
	private String NoOfDoors ;
	private String MaxWeight ;
	
	public VehicleBean (int VehicleID, String Category, String Make, String Model, float EngineSize, float PricePerDay, 
						String FuelType, String NoOfDoors, String MaxWeight) {
		this.VehicleID = VehicleID ;
		this.Category = Category ; 
		this.Make = Make ;
		this.Model = Model ;
		this.EngineSize = EngineSize ;
		this.PricePerDay = PricePerDay ;
		this.FuelType = FuelType ;
		this.NoOfDoors = NoOfDoors ;
		this.MaxWeight = MaxWeight ; 
	}
	
	public VehicleBean() {}

	public int getVehicleID() {
		return VehicleID;
	}

	public void setVehicleID(int vehicleID) {
		VehicleID = vehicleID;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public float getEngineSize() {
		return EngineSize;
	}

	public void setEngineSize(float engineSize) {
		EngineSize = engineSize;
	}

	public float getPricePerDay() {
		return PricePerDay;
	}

	public void setPricePerDay(float pricePerDay) {
		PricePerDay = pricePerDay;
	}

	public String getFuelType() {
		return FuelType;
	}

	public void setFuelType(String fuelType) {
		FuelType = fuelType;
	}

	public String getNoOfDoors() {
		return NoOfDoors;
	}

	public void setNoOfDoors(String noOfDoors) {
		NoOfDoors = noOfDoors;
	}

	public String getMaxWeight() {
		return MaxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		MaxWeight = maxWeight;
	}
	
}

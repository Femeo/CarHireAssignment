package carHireProject;

import java.util.*;

public class DirectoryBean {
	
	private HashMap<Integer, VehicleBean> vehicle = new HashMap<Integer, VehicleBean>();
	private static Integer index ; 

	
	public void setVehicle(int index, VehicleBean vehicles){
	    Integer i = new Integer(index);
		vehicle.put(i,vehicles);
	}
	
	
	public void next() {
		index++;
	}
	
	public void reset() {
		index=0;
	}
	
	public VehicleBean getVehicle(){
		return vehicle.get(index);
	}
	
	
	public int getSize() {
		return vehicle.size();
	}
	
	public boolean beforeEndOfMap(){
		return index < vehicle.size();
	
	}	
}

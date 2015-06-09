package carHireProject;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataAccess {
	
	private Connection connect = null ;
	private CallableStatement callstat = null ;
	private Statement statement = null ;
	
	public DataAccess(String databaseLocation, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection(databaseLocation, username, password) ;
		statement = connect.createStatement() ;
	}
	
	public ResultSet allcontracts() throws SQLException {
		callstat = connect.prepareCall("select * from allcontracts");
		return callstat.executeQuery();
	}
	
	public ResultSet allpreviouscontracts() throws SQLException {
		callstat = connect.prepareCall("select * from allpreviouscontracts");
		return callstat.executeQuery();
	}
	
	public ResultSet allupcomingcontracts() throws SQLException {
		callstat  = connect.prepareCall("select * from allupcomingcontacts");
		return callstat.executeQuery();
	}
	
	public ResultSet currentcontracts() throws SQLException {
		callstat = connect.prepareCall("select * from currentcontracts");
		return callstat.executeQuery();
	}
	
	public ResultSet vehicleusage() throws SQLException {
		callstat = connect.prepareCall("select * from vehicleusage");
		return callstat.executeQuery() ;
	}
	
	public ResultSet allAvailableVehicles(String req) throws SQLException {
		callstat = connect.prepareCall("call allAvailableVehicles(?)") ;
		callstat.setString(1, req);
		return callstat.executeQuery();
	}
	
	public ResultSet allAvailableByCategory(String req, String cat) throws SQLException {
		callstat = connect.prepareCall("call allAvailableByCategory(?,?)") ;
		callstat.setString(1, req);
		callstat.setString(2, cat);
		return callstat.executeQuery();
	}
	
	public ResultSet allHiredByCategory(String req, String cat) throws SQLException {
		callstat = connect.prepareCall("call allHiredByCategory(?,?)");
		callstat.setString(1, req);
		callstat.setString(2, cat);
		return callstat.executeQuery();
	}
	
	public ResultSet allHiredVehicles(String req) throws SQLException {
		callstat = connect.prepareCall("call allHiredVehicles(?)");
		callstat.setString(1, req);
		return callstat.executeQuery();
	}
	
	public ResultSet allVehiclesByCategory(String cat) throws SQLException {
		callstat = connect.prepareCall("call allVehiclesByCategory(?)");
		callstat.setString(1, cat);
		return callstat.executeQuery();
	}
	
	public ResultSet carsHiredForMonth(int mm, int yy) throws SQLException {
		callstat = connect.prepareCall("call carsHiredForMonth(?,?)");
		callstat.setInt(1, mm);
		callstat.setInt(2, yy);
		return callstat.executeQuery();
	}
	
	public ResultSet carsHiredForWeek(String beg_date) throws SQLException {
		callstat = connect.prepareCall("call carsHiredForWeek(?)");
		callstat.setString(1, beg_date);
		return callstat.executeQuery();
	}
	
	public ResultSet carsHiredForYear(int yy) throws SQLException {
		callstat = connect.prepareCall("call carsHiredForYear(?)");
		callstat.setInt(1, yy);
		return callstat.executeQuery();
	}
	
	public ResultSet customerHistory(int customerID) throws SQLException {
		callstat = connect.prepareCall("call customerHistory(?)");
		callstat.setInt(1, customerID) ;
		return callstat.executeQuery();
	}
	
	public ResultSet getContractID(int customerID, int vehicleID, LocalDate dateFrom, LocalDate dateUntill) throws SQLException {
		callstat = connect.prepareCall("call getContractID(?,?,?,?)");
		callstat.setInt(1, customerID);
		callstat.setInt(2, vehicleID);
		String startDate = dateFrom.toString();
		callstat.setString(3, startDate);
		String endDate = dateUntill.toString();
		callstat.setString(4, endDate);
		return callstat.executeQuery();
	}
	
	public ResultSet invoice(int vehicleID) throws SQLException {
		callstat = connect.prepareCall("call invoice(?)");
		callstat.setInt(1, vehicleID);
		return callstat.executeQuery();
	}
	
	public ResultSet paymentDetails(int customerID) throws SQLException {
		callstat = connect.prepareCall("call paymentDetails(?)");
		callstat.setInt(1, customerID);
		return callstat.executeQuery();
	}

	public ResultSet serviceHistory(int vehicleID) throws SQLException {
		callstat = connect.prepareCall("call serviceHistory(?)");
		callstat.setInt(1, vehicleID);
		return callstat.executeQuery();
	}
	
	public void updateVehicleHistory(int vehicleID, int miles, String serviceDate) throws SQLException {
		callstat = connect.prepareCall("call updateVehicleHistory(?,?,?)"); 
		callstat.setInt(1, vehicleID) ;
		callstat.setInt(2, miles);
		callstat.setString(3, serviceDate);
		callstat.execute() ;
	}
	
	public ResultSet vehicleHistory(int vehicleID) throws SQLException {
		callstat = connect.prepareCall("call vehicleHistory(?)");
		callstat.setInt(1, vehicleID) ;
		return callstat.executeQuery() ;
	}
	
}

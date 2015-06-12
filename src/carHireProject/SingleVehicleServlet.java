package carHireProject;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleVehicleServlet extends HttpServlet {

	Statement statement = null ;
	Connection connection = null ;
	CallableStatement callstat = null ;
	
	public void init(ServletConfig config) throws ServletException{
		
		super.init(config);
		
		
		try { 
			try{ 
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e ) {
				System.out.println("Class not Found");
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire1","root","");
			System.out.println("Connecting to database...");
			System.out.println(" ");
			statement = connection.createStatement();
			System.out.println("Connection Succesful!!");
		}
		catch (SQLException e){
			System.out.println("SQL Exception");
			System.out.println("Not Connected ... Unlucky!");
		}
	
}
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			
			String SentItemID = request.getParameter("VehicleID") ;			
			int ItemID = Integer.parseInt(SentItemID);			
			callstat = connection.prepareCall("select * from vehicles where vehicleID = ?") ;			
			callstat.setInt(1, ItemID);			
			ResultSet rs = callstat.executeQuery();
			
			List<VehicleBean> Item = new ArrayList<VehicleBean>() ;
			System.out.println("1");
			
			int i = 0 ;
				int VehicleID = Integer.parseInt(rs.getString(1));
				String Category = String.valueOf(rs.getString(2));
				String Make = String.valueOf(rs.getString(3));
				String Model = String.valueOf(rs.getString(4));
				float EngineSize = rs.getFloat(5);
				float PricePerDay = rs.getFloat(6);
				String FuelType = String.valueOf(rs.getString(7));
				String NoOfDoors = String.valueOf(rs.getString(8));
				String MaxWeight = String.valueOf(rs.getString(9));
				
				VehicleBean newItem = new VehicleBean(VehicleID, Category, Make, Model, EngineSize, PricePerDay, FuelType, NoOfDoors, MaxWeight);
				Item.add(newItem);
				i++ ;
			request.setAttribute("Results", Item);
			request.getRequestDispatcher("SingleVehicleView.jsp").forward(request, response);
			

		}
		catch(SQLException e) {
			System.out.println("Exeception " + e);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp); 
	
	}	
		
	}

 /*
package dwpbay;


public class SingleItemServlet extends HttpServlet {
	
	
	
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			
			String SentItemID = request.getParameter("ItemID") ;			
			int ItemID = Integer.parseInt(SentItemID);			
			callstat = connection.prepareCall("select * from homepage where item_id = ?") ;			
			callstat.setInt(1, ItemID);			
			ResultSet rs = callstat.executeQuery();
			
			List<ItemsBean> Item = new ArrayList<ItemsBean>() ;
			System.out.println("1");
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter tt = DateTimeFormatter.ofPattern("HH:mm:ss");
			int i = 0 ;
			while (rs.next() && i <= 3){
				System.out.println("2");
				System.out.println(rs.getString(9)); 
				LocalDate startDate = LocalDate.parse(rs.getString(9), dt);
				LocalTime startTime = LocalTime.parse(rs.getString(10), tt);
				int itemID = Integer.parseInt(rs.getString(1));
				double MaxPrice = Double.parseDouble(rs.getString(6));
				double reservePrice = Double.parseDouble(rs.getString(8));
				boolean on_sale = Boolean.parseBoolean(rs.getString(7));
				ItemsBean newItem = new ItemsBean(itemID, rs.getString(2), 
												rs.getString(3),
												rs.getString(4),
												rs.getString(5),
												MaxPrice, on_sale, reservePrice, startDate, startTime);
				Item.add(newItem);
				i++ ;
			}
			request.setAttribute("Results", Item);
			request.getRequestDispatcher("ItemView.jsp").forward(request, response);
			

		}
		catch(SQLException e) {
			System.out.println("Exeception " + e);
		}
	}
		}


*/
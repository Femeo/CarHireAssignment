package carHireProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {
	HttpSession session; 
	Statement statement = null;
	Connection connection = null;
	
	public void init(ServletConfig config) throws ServletException{
		
		super.init(config);
		
			try{
				try{
					Class.forName("com.mysql.jdbc.Drive");
				}
				catch (ClassNotFoundException e){
					System.out.println("Class not found");
				}
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire","root","");
				statement = connection.createStatement();
			}
			catch(SQLException e){
				System.out.println("SQL exception");
			}
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String method = request.getParameter("go");
		System.out.println(method);
		switch (method) {
		case "LoginCustoemr": 
			LoginCustomer(request, response);
			request.getRequestDispatcher("CustomerLogin.jsp").forward(request, response);
			break;
		case "LoginStaff":
			LoginStaff(request, response);
			request.getRequestDispatcher("StaffLogin.jsp").forward(request, response);
			break;
		case "addVehicle":
			addVehicle(request,response);
			request.getRequestDispatcher("AddVehicle.jsp").forward(request, response);
			break;
		case "ListAllVehicles":
			ListAllVehicles(request, response);
			request.getRequestDispatcher("//JSP HERE \\").forward(request,  response);
			break;
		case "categoriseVehicles":
			categoriseVehicles(request, response);
			request.getRequestDispatcher("//JSP HERE\\").forward(request,  response);
			break;
		case "HireVehicle":
			HireVehicle(request,response);
			request.getRequestDispatcher("//JSP HERE\\").forward(request, response);
			break;
			
		
			
			
		
		}
	}
	
	public void destroy() {
		if(connection != null){
			try {
				connection.close() ;
			}
			catch(SQLException e) {} 
		}
	}
	
	public void LoginCustomer (HttpServletRequest request, HttpServletResponse response){
		
		try{
			String userName = request.getParameter("username");
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("Select * from customer_login where username = ' " + userName + "';");
			
			if (!results.isBeforeFirst()){
				request.setAttribute("authenticated", false);
			}else{
				results.next();
				LoginBean currentUserObj = null;
				if(results.getString(3).equals(request.getParameter("pass_word"))){
					currentUserObj = new LoginBean(results.getInt(1), results.getString(2), results.getString(3));
					session = request.getSession(true);
					session.setAttribute("currentUser", currentUserObj);
					return;
				}else{
					request.setAttribute("authenticated", false);
				}
				}
			}
		catch (SQLException e ) {
			System.out.println(e);
		}
	}
	
	public void LoginStaff (HttpServletRequest request, HttpServletResponse response){
		
		try{
			String userName = request.getParameter("username");
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("Select * from staff_login where username = '" + userName + "';");
			
			if(!results.isBeforeFirst()){
				request.setAttribute("authenticated",  false);
			}else{
				results.next();
				LoginBean currentUserObj = null;
				if(results.getString(3).equals(request.getParameter("pass_word"))){
					currentUserObj = new LoginBean(results.getInt(1), results.getString(2), results.getString(3));
					session = request.getSession(true);
					session.setAttribute("currentUser", currentUserObj);
					return;
				}
				else{
					request.setAttribute("authenticated",false);
				}
			}
		}
		catch(SQLException e){
			System.out.println(e);
		}
	}
	
	private void addVehicle(HttpServletRequest request, HttpServletResponse response){
		
		try{
			String category = request.getParameter("Category");
			String make = request.getParameter("Make");
			String model = request.getParameter("Model");
			Double engineSize = Double.parseDouble(request.getParameter("EngineSize"));
			Double pricePerDay = Double.parseDouble(request.getParameter("PricePerDay"));
			String fuelType = request.getParameter("FuelType");
			String numberOfDoors = request.getParameter("NoOfDoors");
			String maxWeight = request.getParameter("MaxWeight");
			String picture = request.getParameter("Picture");
			
			PreparedStatement statement = connection.prepareStatement("insert into vehicles values(?,?,?,?,?,?,?,?,?,?);") ;
			
			statement.setString(1, null);
			statement.setString(2,  category);
			statement.setString(3, make);
			statement.setString(4, model);
			statement.setDouble(5, engineSize);
			statement.setDouble(6, pricePerDay);
			statement.setString(7,  fuelType);
			statement.setString(8, numberOfDoors);
			statement.setString(9, maxWeight);
			statement.setString(10, picture);
			
			statement.execute();
			
		}
		catch(Exception e){
			System.out.println("Exception" + e);
		}
		
	}
	
	private void ListAllVehicles(HttpServletRequest request, HttpServletResponse response){
		try{
			ResultSet rs = statement.executeQuery("SELECT * from vehicles");
			List<VehicleBean> allVehicles = new ArrayList<VehicleBean>();
			while (rs.next()){
				int VehicleID = Integer.parseInt(rs.getString(1));
				String category = rs.getString(2);
				String Make = rs.getString(3);
				String model = rs.getString(4);
				float engineSize = Float.parseFloat(rs.getString(5));				
				float pricePerDay = Float.parseFloat(rs.getString(6));
				String FuelType = rs.getString(7);
				String Doors = rs.getString(8);
				String Weight = rs.getString(9);

				
				VehicleBean newVehicle = new VehicleBean(VehicleID, category, Make, model, engineSize, pricePerDay, FuelType, Doors, Weight);

				allVehicles.add(newVehicle);
			}
			request.setAttribute("Results", allVehicles);
				
		}
		catch(Exception e){
			System.out.println("Exception" + e);
		}
	}
	
	private void categoriseVehicles(HttpServletRequest request, HttpServletResponse response){
		try{
			String cat = request.getParameter("go");
			PreparedStatement statement = connection.prepareStatement("Select * from ");
			statement.setString(1, cat);
			ResultSet rs = statement.executeQuery();
			List<VehicleBean> allVehicles = new ArrayList<VehicleBean>();
			while (rs.next()){
				int VehicleID = Integer.parseInt(rs.getString(1));
				String category = rs.getString(2);
				String Make = rs.getString(3);
				String model = rs.getString(4);
				float engineSize = Float.parseFloat(rs.getString(5));				
				float pricePerDay = Float.parseFloat(rs.getString(6));
				String FuelType = rs.getString(7);
				String Doors = rs.getString(8);
				String Weight = rs.getString(9);
				VehicleBean newVehicle = new VehicleBean(VehicleID, category, Make, model, engineSize, pricePerDay, FuelType, Doors, Weight);
				allVehicles.add(newVehicle);
				
			}
			request.setAttribute("Results", allVehicles);
					
		}
		catch(Exception e){
			System.out.println("Exception" + e);
		}
	}
	
	public void HireVehicle(HttpServletRequest request, HttpServletResponse response){
		
		try{
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LoginBean person = new LoginBean();
			person = (LoginBean) session.getAttribute("CurrentUser");
			int user_id = person.getCustomerID();
			int vehicle_id = Integer.parseInt(request.getParameter("VehicleID"));
			
			PreparedStatement statement = connection.prepareStatement("insert into contracts values(?,?,?,?,?);");
			
			statement.setInt(2,  user_id);
			statement.setInt(3,  vehicle_id);
			
			LocalDate startDate = LocalDate.parse(request.getParameter("startDate"),dt);
			LocalDate endDate = LocalDate.parse(request.getParameter("endDate"), dt);
			
			statement.setString(4, startDate.toString());
			statement.setString(5, endDate.toString());
			
			statement.execute();
		}
		catch (Exception e){
			System.out.println("Exception" + e);
			
		}
	}
}



/*  

	
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String method =request.getParameter("go");
		System.out.println(method);
		switch (method) {
		case "LogIn":
			Login(request,response);
			request.getRequestDispatcher("LogIn.jsp").forward(request, response);
			break;
		case "Buyer":
			allItems(request,response);
			request.getRequestDispatcher("Buyers.jsp").forward(request, response);
		case "Clothes":
			refineItems(request,response);
			request.getRequestDispatcher("Buyers.jsp").forward(request, response);
		case "Shoes":
			refineItems(request,response);
			request.getRequestDispatcher("Buyers.jsp").forward(request, response);
		case "Electronics":
			refineItems(request,response);
			request.getRequestDispatcher("Buyers.jsp").forward(request, response);
		case "Furniture":
			refineItems(request,response);
			request.getRequestDispatcher("Buyers.jsp").forward(request, response);
		case "All":
			allItems(request,response);
			request.getRequestDispatcher("Buyers.jsp").forward(request, response);
		case "AddItem" :
			listItem(request,response);
			request.getRequestDispatcher("SellerMenu.jsp").forward(request, response);
		case "PlaceBid" :
			placeBid(request,response);
			request.getRequestDispatcher("Buyers.jsp").forward(request,response);
		case "Items On Sale":
			viewMyItemsOnSale(request,response);
			request.getRequestDispatcher("ItemsOnSale.jsp").forward(request,response);
		}
		
	}
	
	public void destroy() {
		if(connection != null){
			try {
				connection.close() ;
			}
			catch(SQLException e) {} 
		}
	}
	
	

	
	public void viewMyItemsOnSale(HttpServletRequest request, HttpServletResponse response) {
	
		try {
			
			LoginBean person= new LoginBean();		
			person=(LoginBean) session.getAttribute("currentUser");
			int user_id = person.getUserID();
			
		PreparedStatement statement = connection.prepareStatement("call myItemsOnSale(?);") ;;
		
		statement.setInt(1, user_id);
		
		ResultSet rs = statement.executeQuery();
		
		List<ItemsBean> allItems = new ArrayList<ItemsBean>() ;
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter tt = DateTimeFormatter.ofPattern("HH:mm:ss");
		int i = 0 ;
		while (rs.next()){
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
			System.out.println(i);
			i++;
			allItems.add(newItem);
		}
		
		request.setAttribute("Results", allItems);
		
	}
	catch(Exception e){
		System.out.println("Exception" + e );
	}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
	}
		

	

*/
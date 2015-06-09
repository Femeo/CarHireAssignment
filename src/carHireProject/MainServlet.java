package carHireProject;

import java.io.IOException;
import java.sql.Connection;
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
	

	
	private void allItems(HttpServletRequest request, HttpServletResponse response) {
		try{
		ResultSet rs = statement.executeQuery("SELECT * from homepage") ;
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
	
	private void refineItems(HttpServletRequest request, HttpServletResponse response) {
		try{
			String cat =request.getParameter("go");
			PreparedStatement statement = connection.prepareStatement("Select * from homepage where category = ?") ;			
			statement.setString(1, cat);			
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
				allItems.add(newItem);
			}
			request.setAttribute("Results", allItems);
			
		}
		catch(Exception e){
			System.out.println("Exception" + e );
		}
		
	}
	
	private void listItem(HttpServletRequest request, HttpServletResponse response) {
	
	try {	
			String title = request.getParameter("title") ;
			String category = request.getParameter("category");
			String description = request.getParameter("description") ;
			String picture = request.getParameter("picture") ;
			Double price = Double.parseDouble(request.getParameter("price"));
			Double reserve_price = Double.parseDouble(request.getParameter("reserve_price"));
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			String newDate = date.toString();
			String newTime = time.toString();
			
			PreparedStatement statement = connection.prepareStatement("insert into items values(?,?,?,?,?,?,?,?,?,?);") ;
			
			statement.setString(1, null);
			statement.setString(2, title);
			statement.setString(3, category);
			statement.setString(4, description);
			statement.setString(5, picture);
			statement.setDouble(6, price);
			statement.setInt(7,1);
			statement.setDouble(8, reserve_price);
			statement.setString(9, newDate);
			statement.setString(10, newTime);
			
			System.out.println("1");
			
			statement.execute();
			
			System.out.println("2");
			
			PreparedStatement statement2 = connection.prepareStatement("call getItemID(?,?);") ;
			
			statement2.setString(1,title);
			statement2.setString(2,description);
			
			System.out.println("3");
			
			ResultSet rs = statement2.executeQuery();
			
			System.out.println("4");
			
			while (rs.next()) {
			String ID = rs.getString(1);
			System.out.println(ID);
			
			
			
			PreparedStatement statement3 = connection.prepareStatement("insert into bids values(?,?,?);");
			
			statement3.setInt(1,1000000);
			statement3.setString(2, ID);
			statement3.setDouble(3, 00.00);
			
			
			statement3.execute();
			}
		
		}
		catch(SQLException e) {
			System.out.println("Exeception " + e);
		}
	
	}
	
	public void placeBid(HttpServletRequest request, HttpServletResponse response) {
		
		try {
		double price = Double.parseDouble(request.getParameter("bid"));				
		LoginBean person= new LoginBean();		
		person=(LoginBean) session.getAttribute("currentUser");
		int user_id = person.getUserID();
		int item_id = Integer.parseInt(request.getParameter("ItemID"));
		
			PreparedStatement statement = connection.prepareStatement("insert into bids values(?,?,?);");
			
			statement.setInt(1, user_id);
			statement.setInt(2, item_id);
			statement.setDouble(3, price);
			
			statement.execute();
			
			ResultSet rs = statement.executeQuery("SELECT * from homepage") ;
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
package Database;

import java.sql.*;
import java.util.ArrayList;

import Classes.Hotel;

public class SQLiteJDBC {

	private static DBConnection dbConn;
	static Connection c = null;
	static Statement stmt = null;

	/**
	 * Simple constructor. Initializes the DBConnection class.
	 */
	public SQLiteJDBC() {
		dbConn = new DBConnection();
		System.out.println("Connected");
	}

	public static void InsertHotel(String HotelName, double Price, int Stars, int Popularity, double Distance, int Breakfast, int Bar, int Gym, int Pets, int Pool){
		String correctname = HotelName.toUpperCase();
		try{
			c = dbConn.getConn();
			stmt = c.createStatement();

			String sql = "INSERT INTO Hotel (Name, Rating, Price, Distance, Pool, Popularity, Breakfast, Gym, Bar, Pets) "
					+ "VALUES('"+correctname+"' , '"+Stars+"', '"+Price+"', '"+Distance+"', '"+Pool+"'"
					+ ", '"+Popularity+"', '"+Breakfast+"', '"+Gym+"', '"+Bar+"', '"+Pets+"'); ";  

			stmt.executeUpdate(sql);
			c.commit();
			c.close();
		}
		catch (SQLException ex) {
			// handle erros here
			System.out.println("\n" + "Hotel added" + "\n");
		}
	}

	public static ArrayList<Hotel> RetrieveHotels(){


		ArrayList<Hotel> list = new ArrayList<Hotel>();

		try{
			c = dbConn.getConn();
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Hotel;" );

			while (rs.next()) {
				// the array list holding the data from
				// the current row parsed in the result set
				Hotel databaseHotel = new Hotel();

				// get data by column name
				int hid = rs.getInt("HID");
				int rating = rs.getInt("Rating");
				int popularity = rs.getInt("Popularity");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				double distance = rs.getDouble("Distance");
				boolean pool = rs.getBoolean("Pool");
				boolean gym = rs.getBoolean("Gym");
				boolean bar = rs.getBoolean("Bar");
				boolean pets = rs.getBoolean("Pets");
				boolean breakfast = rs.getBoolean("Breakfast");

				// add to data list
				databaseHotel.setHotelId(hid);
				databaseHotel.setHotelName(name);
				databaseHotel.setStars(rating);
				databaseHotel.setPopularity(popularity);
				databaseHotel.setHotelPrice(price);
				databaseHotel.setDistance(distance);
				databaseHotel.setPool(pool);
				databaseHotel.setBar(bar);
				databaseHotel.setPets(pets);
				databaseHotel.setBreakfast(breakfast);
				databaseHotel.setGym(gym);

				// add to list to return
				list.add(databaseHotel);
		
			}
		} // end while()

		catch (SQLException ex) {
			// handle erros here
			System.out.println("\n" + "Something went wrong " + "while executing query..." + "\n");
		}
		return list;

	}
	
	public ArrayList<Object> RetrieveOneHotel(String name1){
		
		String correctname = name1.toUpperCase();
		ArrayList<Object> list = new ArrayList<Object>();

		try{
			c = dbConn.getConn();
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Hotel WHERE Name == '"+correctname+"' ;" );

			while (rs.next()) {
				// the array list holding the data from
				// the current row parsed in the result set
				Hotel databaseHotel = new Hotel();

				// get data by column name
				int hid = rs.getInt("HID");
				int rating = rs.getInt("Rating");
				int popularity = rs.getInt("Popularity");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				double distance = rs.getDouble("Distance");
				boolean pool = rs.getBoolean("Pool");
				boolean gym = rs.getBoolean("Gym");
				boolean bar = rs.getBoolean("Bar");
				boolean pets = rs.getBoolean("Pets");
				boolean breakfast = rs.getBoolean("Breakfast");

				// add to data list
				databaseHotel.setHotelId(hid);
				databaseHotel.setHotelName(name);
				databaseHotel.setStars(rating);
				databaseHotel.setPopularity(popularity);
				databaseHotel.setHotelPrice(price);
				databaseHotel.setDistance(distance);
				databaseHotel.setPool(pool);
				databaseHotel.setBar(bar);
				databaseHotel.setPets(pets);
				databaseHotel.setBreakfast(breakfast);
				databaseHotel.setGym(gym);

				// add to list to return
				list.add(databaseHotel);
			}
		} // end while()

		catch (SQLException ex) {
			// handle erros here
			System.out.println("\n" + "Something went wrong " + "while executing query..." + "\n");
		}
	
		return list;

	}
	public ArrayList<Object> CompareHotels(int hID1, int hID2){

		ArrayList<Object> list = new ArrayList<Object>();

		try{
			c = dbConn.getConn();
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Hotel Where HID IN ('"+hID1+"','"+hID2+"');");

			while (rs.next()) {
				// the array list holding the data from
				// the current row parsed in the result set
				Hotel databaseHotel = new Hotel();

				// get data by column name
				int hid = rs.getInt("HID");
				int rating = rs.getInt("Rating");
				int popularity = rs.getInt("Popularity");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				double distance = rs.getDouble("Distance");
				boolean pool = rs.getBoolean("Pool");
				boolean gym = rs.getBoolean("Gym");
				boolean bar = rs.getBoolean("Bar");
				boolean pets = rs.getBoolean("Pets");
				boolean breakfast = rs.getBoolean("Breakfast");

				// add to data list
				databaseHotel.setHotelId(hid);
				databaseHotel.setHotelName(name);
				databaseHotel.setStars(rating);
				databaseHotel.setPopularity(popularity);
				databaseHotel.setHotelPrice(price);
				databaseHotel.setDistance(distance);
				databaseHotel.setPool(pool);
				databaseHotel.setBar(bar);
				databaseHotel.setPets(pets);
				databaseHotel.setBreakfast(breakfast);
				databaseHotel.setGym(gym);

				// add to list to return
				list.add(databaseHotel);

			} // end while()
		}

		catch (SQLException ex) {
			// handle erros here
			System.out.println("\n" + "Something went wrong " + "while executing query..." + "\n");
		}
		System.out.println(list);
		return list;

	}

	public ArrayList<Object> OrderByPrice(){

		ArrayList<Object> list = new ArrayList<Object>();


		try{
			c = dbConn.getConn();
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Hotel ORDER BY Price ASC;");

			while (rs.next()) {
				// the array list holding the data from
				// the current row parsed in the result set
				Hotel databaseHotel = new Hotel();

				// get data by column name
				int hid = rs.getInt("HID");
				int rating = rs.getInt("Rating");
				int popularity = rs.getInt("Popularity");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				double distance = rs.getDouble("Distance");
				boolean pool = rs.getBoolean("Pool");
				boolean gym = rs.getBoolean("Gym");
				boolean bar = rs.getBoolean("Bar");
				boolean pets = rs.getBoolean("Pets");
				boolean breakfast = rs.getBoolean("Breakfast");

				// add to data list
				databaseHotel.setHotelId(hid);
				databaseHotel.setHotelName(name);
				databaseHotel.setStars(rating);
				databaseHotel.setPopularity(popularity);
				databaseHotel.setHotelPrice(price);
				databaseHotel.setDistance(distance);
				databaseHotel.setPool(pool);
				databaseHotel.setBar(bar);
				databaseHotel.setPets(pets);
				databaseHotel.setBreakfast(breakfast);
				databaseHotel.setGym(gym);

				// add to list to return
				list.add(databaseHotel);

			} // end while()
		}
		catch (SQLException ex) {
			// handle erros here
			System.out.println("\n" + "Something went wrong " + "while executing query..." + "\n");
		}
		
		return list;

	}

	public ArrayList<Object> OrderByDistance() {

		ArrayList<Object> list = new ArrayList<Object>();

		try{
			c = dbConn.getConn();
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Hotel ORDER BY Distance ASC;");

			while (rs.next()) {
				// the array list holding the data from
				// the current row parsed in the result set
				Hotel databaseHotel = new Hotel();

				// get data by column name
				int hid = rs.getInt("HID");
				int rating = rs.getInt("Rating");
				int popularity = rs.getInt("Popularity");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				double distance = rs.getDouble("Distance");
				boolean pool = rs.getBoolean("Pool");
				boolean gym = rs.getBoolean("Gym");
				boolean bar = rs.getBoolean("Bar");
				boolean pets = rs.getBoolean("Pets");
				boolean breakfast = rs.getBoolean("Breakfast");

				// add to data list
				databaseHotel.setHotelId(hid);
				databaseHotel.setHotelName(name);
				databaseHotel.setStars(rating);
				databaseHotel.setPopularity(popularity);
				databaseHotel.setHotelPrice(price);
				databaseHotel.setDistance(distance);
				databaseHotel.setPool(pool);
				databaseHotel.setBar(bar);
				databaseHotel.setPets(pets);
				databaseHotel.setBreakfast(breakfast);
				databaseHotel.setGym(gym);

				// add to list to return
				list.add(databaseHotel);
			}
		} // end while()

		catch (SQLException ex) {
			// handle erros here
			System.out.println("\n" + "Something went wrong " + "while executing query..." + "\n");
		}

		return list;

	}


	public ArrayList<Object> FilterHotels(boolean filter) {

		ArrayList<Object> list = new ArrayList<Object>();
		
		try{
			c = dbConn.getConn();
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "SELECT * FROM Hotels WHERE " + filter + "== True;" );

			while (rs.next()) {
				// the array list holding the data from
				// the current row parsed in the result set
				Hotel databaseHotel = new Hotel();

				// get data by column name
				int hid = rs.getInt("HID");
				int rating = rs.getInt("Rating");
				int popularity = rs.getInt("Popularity");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				double distance = rs.getDouble("Distance");
				boolean pool = rs.getBoolean("Pool");
				boolean gym = rs.getBoolean("Gym");
				boolean bar = rs.getBoolean("Bar");
				boolean pets = rs.getBoolean("Pets");
				boolean breakfast = rs.getBoolean("Breakfast");

				// add to data list
				databaseHotel.setHotelId(hid);
				databaseHotel.setHotelName(name);
				databaseHotel.setStars(rating);
				databaseHotel.setPopularity(popularity);
				databaseHotel.setHotelPrice(price);
				databaseHotel.setDistance(distance);
				databaseHotel.setPool(pool);
				databaseHotel.setBar(bar);
				databaseHotel.setPets(pets);
				databaseHotel.setBreakfast(breakfast);
				databaseHotel.setGym(gym);

				// add to list to return
				list.add(databaseHotel);
			} // end while()
		}

		catch (SQLException ex) {
			// handle erros here
			System.out.println("\n" + "Something went wrong " + "while executing query..." + "\n");
		}
		
		return list;
	}
	
	public ArrayList<Object> SearchHotels(String Search) {

		ArrayList<Object> list = new ArrayList<Object>();
		
		String correctsearch = Search.toUpperCase();


		try{
			c = dbConn.getConn();
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Hotel Where Name LIKE ('"+correctsearch+"%');");
			

			while (rs.next()) {
				// the array list holding the data from
				// the current row parsed in the result set
				Hotel databaseHotel = new Hotel();

				// get data by column name
				int hid = rs.getInt("HID");
				int rating = rs.getInt("Rating");
				int popularity = rs.getInt("Popularity");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				double distance = rs.getDouble("Distance");
				boolean pool = rs.getBoolean("Pool");
				boolean gym = rs.getBoolean("Gym");
				boolean bar = rs.getBoolean("Bar");
				boolean pets = rs.getBoolean("Pets");
				boolean breakfast = rs.getBoolean("Breakfast");

				// add to data list
				databaseHotel.setHotelId(hid);
				databaseHotel.setHotelName(name);
				databaseHotel.setStars(rating);
				databaseHotel.setPopularity(popularity);
				databaseHotel.setHotelPrice(price);
				databaseHotel.setDistance(distance);
				databaseHotel.setPool(pool);
				databaseHotel.setBar(bar);
				databaseHotel.setPets(pets);
				databaseHotel.setBreakfast(breakfast);
				databaseHotel.setGym(gym);

				// add to list to return
				list.add(databaseHotel);
			}
		} // end while()

		catch (SQLException ex) {
			// handle erros here
			System.out.println("\n" + "Something went wrong " + "while executing query..." + "\n");
		}
		
		return list;

	}

}

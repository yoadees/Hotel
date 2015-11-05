package Database;

import java.sql.*;

public class DBConnection {


	/**
	 * Constructor. Loads the driver to be used.
	 */
	public DBConnection() {
		try {
			System.out.println("Loading driver...");
			
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver loaded...");
		} catch (ClassNotFoundException ex) {
			
			System.out.println("\n" + "Could not load driver..." + "\n");
			System.out.println(ex);
		}

	}

	/**
	 * Returns a connection to the database.
	 * 
	 * @return Connection
	 */
	public Connection getConn() {

		Connection conn = null;

		try {
			// get a connection
			conn = DriverManager.getConnection("jdbc:sqlite:test.sqlite");
		} catch (SQLException e) {
			// handle errors for JDBC here
			System.out.println("\n" + "Could not connect..." + "\n");
			System.out.println(e);
		}

		return conn;

	}


	public static void main( String args[] ) {

		SQLiteJDBC hello = new SQLiteJDBC();
//		System.out.println(hello.SearchHotels("Clarion"));
//		String sql = "INSERT INTO Hotel (Name, Rating, Price, Distance, Pool, Popularity, Gym, Bar, Pets)
//		hello.InsertHotel("wasup", 4, 50, 10, 1, 5, 0, 1 , 0, 1);
//	    hello.RetrieveOneHotel("Hello");
//		hello.RetrieveHotels();
//		System.out.println(hello.OrderByPrice());
//		System.out.println(hello.OrderByDistance());
//		System.out.println(hello.CompareHotels(4, 5));
		System.out.println(hello.SearchHotels("wasup"));
		
	}
}

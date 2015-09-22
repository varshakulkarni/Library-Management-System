import java.sql.*;

public class Connect {
	public int connection(String query){
		
	Connection conn = null;
	/**
	 * @param args
	 */
	
	//public static void main(String[] args) {
		
		/* Initialize variables for login creds */
		// String url = "jdbc:mysql://localhost:3306/company"; // direct connect to database in url
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "varsha";

		int linect = 0;

		try {
			/* Create a connection to the local MySQL server */
			conn = DriverManager.getConnection(url, user, password);
	
			/* Create a SQL statement object and execute the query */
			Statement stmt = conn.createStatement();
		
//			/* Set the current database, if not already set in the getConnection */
//			/* Execute a SQL statement */
		stmt.execute("use library;");

			int rs = stmt.executeUpdate(query);



//			// Always close the recordset and connection.
			return rs;

		} 
		catch(SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
			return 0;
		}
	}

	public static void main(String[] args){}
}
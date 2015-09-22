import java.sql.*;

public class ConnectQuery {
	public ResultSet connection(String query){
		
	Connection conn = null;
	
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "varsha";

	//	int linect = 0;

		try {
			/* Create a connection to the local MySQL server */
			conn = DriverManager.getConnection(url, user, password);
	
			/* Create a SQL statement object and execute the query */
			Statement stmt = conn.createStatement();
		
			/* Set the current database, if not already set in the getConnection */
			/* Execute a SQL statement */
		stmt.execute("use library;");
		

			ResultSet rs = stmt.executeQuery(query);
//			while(rs.next())
//			{
//				String s1=rs.getString(1);
//				System.out.println(s1);
//			}
		return rs;

		} 
		catch(SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
			return null;
		}
	}

	public static void main(String[] args){}
}
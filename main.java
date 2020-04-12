import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		getData();
	}

	private static void getData() {
		String userName = "";
		String passWord = "";

		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@YourHostIp:YourPortNumber/YourDbName",
					userName, passWord);

			// step3 create the statement object
			Statement stmt = con.createStatement();

			// step4 execute query
			ResultSet rs = stmt.executeQuery("Your SQL Query");

			while (rs != null && rs.next()) {
				System.out.println(rs.getString("SQL_COLUMN_NAME"));
			}

			// step5 close the connection object
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
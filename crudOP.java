import java.sql.*;
import java.io.*;

public class crudOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sampleDB", "root", "root");
			if (con != null)
				System.out.println("Connected to Database!");

			String sql = "INSERT INTO users (id, username, password) VALUES (?, ?, ?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, 1);
			statement.setString(2, "Bill Gates");
			statement.setString(3, "bill@gates");

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}

			String sql1 = "SELECT * FROM users";

			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql1);

			while (result.next()) {
				int id = result.getInt(1);
				String user = result.getString(2);
				String pass = result.getString(3);

				System.out.println(id + " " + user + " " + pass);
			}
			
			String sql2 = "UPDATE users SET password=? WHERE username=?";
			 
			PreparedStatement stmtt = con.prepareStatement(sql2);
			stmtt.setString(1, "123456789");
			stmtt.setString(2, "Bill Gates");
			
			int rowsUpdated = stmtt.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing user was updated successfully!");
			}
			
			String sql3 = "DELETE FROM Users WHERE username=?";
			 
			PreparedStatement statement1 = con.prepareStatement(sql3);
			statement1.setString(1, "Bill Gates");
			 
			int rowsDeleted = statement1.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("A user was deleted successfully!");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

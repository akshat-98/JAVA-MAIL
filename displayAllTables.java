import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.DatabaseMetaData;

public class displayAllTables {

	public static void main(String[] args) {
		Connection conn = null;
	      try {
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
	         } catch (Exception e) {
	            System.out.println(e);
	         }
	         conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test", "Manish", "123456");
	         System.out.println("Connection is created succcessfully:");
	      } catch (Exception e) {
	         System.out.println(e);
	      }
	      ResultSet rs = null;
	      DatabaseMetaData meta = (DatabaseMetaData) conn.getMetaData();
	      rs = meta.getTables(null, null, null, new String[] {
	         "TABLE"
	      });
	      int count = 0;
	      System.out.println("All table names are in test database:");
	      while (rs.next()) {
	         String tblName = rs.getString("TABLE_NAME");
	         System.out.println(tblName);
	         count++;
	      }
	      System.out.println(count + " Rows in set ");
	   }

}

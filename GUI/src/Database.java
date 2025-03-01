import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class Database
{
    private String url = "jdbc:mysql://localhost:3306/platformaStudiu";
    private	String uid = "root";
    private	String pw = "rootroot";
    Connection conn = null;
    private BufferedReader reader;

    private void init()
    {
        // Initialize your application
        // Register the MySQL driver and make a connection
        try {	// Load driver class
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " +e);
        }

        conn = null;
        try {
            conn = DriverManager.getConnection(url, uid, pw);
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex);
            System.exit(1);
        }

        // Set up console reader
        reader = new BufferedReader(new InputStreamReader(System.in));
    }


    private void closeConnection()
    {	try {
        conn.close();
    }
    catch (SQLException ex) {
        System.err.println("Exception during connection close: " + ex);
    }
    }
}

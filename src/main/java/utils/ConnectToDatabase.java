package utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by bill.witt on 11/2/2016.
 */
public class ConnectToDatabase {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3307/onboarding";

    //  Database credentials
    static final String USER = "onboarding";
    static final String PASS = "onboarding123";

    public List<String> verifyDbData(String email) throws Exception {
        // *You MUST have the VPN Tunneling client running for this to run properly!

        Connection conn = null;
        Statement stmt = null;
        List<String> dbData = new ArrayList<>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER).newInstance();

            //STEP 3: Open connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected.");

            //STEP 4: Execute query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM onboarding.users WHERE email = '" + email + "';";
            ResultSet rs = stmt.executeQuery(sql);


            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String userFirst = rs.getString("first_name");
                String userLast = rs.getString("last_name");
                String userEmail = rs.getString("email");

                //Add first, last, and email to list array for comparison
                dbData.add(userFirst);
                dbData.add(userLast);
                dbData.add(userEmail);

                //Display values
//                System.out.println("Generated User Data");
//                System.out.println("Email: " + userEmail);
//                System.out.println("First: " + userFirst);
//                System.out.println("Last: " + userLast);
            }

            //STEP 6: Clean-up
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException e){
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return dbData;
    }
}

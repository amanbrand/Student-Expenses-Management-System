package in.DatabaseManagement;

import java.sql.ResultSet;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class DatabaseConnection {

    private static String _jdbcUrl = "jdbc:mariadb://localhost:3306/ExpenseManagement";
    private static String _user = "root";
    private static String _password = "new_password";

    public void insertUserInfo(String User_Name, String MobileNumber, String User_Email, String User_Password, String ImageFilePath) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(_jdbcUrl, _user, _password);

            String SQLQuery = "insert into UserInfo (UserName, MobilNumber, Email, Password, UserImage) values (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(SQLQuery);

            statement.setString(1, User_Name);
            statement.setString(2, MobileNumber);
            statement.setString(3, User_Email);
            statement.setString(4, User_Password);
            statement.setString(5, ImageFilePath);

            statement.executeUpdate();
        } catch(SQLException exception) {
            System.out.println("DataBase connectivity or Connection Error" + exception.getMessage());
        } finally {
            try{
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch(Exception e) {
                System.out.println("Error While Closing the Resources: " + e.getMessage());
            }
        }
    } 

    
}

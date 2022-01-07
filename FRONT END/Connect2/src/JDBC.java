import java.sql.*;
import java.util.Calendar;

public class JDBC {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/sanka", "root" , "" );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from client");


            while(resultSet.next()){
                System.out.println(resultSet.getString("clientName"));
            }
            // create a sql date object so we can use it in our INSERT statement
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into client (idclient, clientName, nationality, phone, status, vac_date)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, 100210);
            preparedStmt.setString (2, "Rubble");
            preparedStmt.setString  (3, "cameroun");
            preparedStmt.setInt(4, 690768832);
            preparedStmt.setBoolean    (5, false);
            preparedStmt.setDate   (6, startDate);

            // execute the preparedstatement
            preparedStmt.execute();

            connection.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        }
}

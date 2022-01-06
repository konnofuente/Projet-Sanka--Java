import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDconnection {
    public static  void main(String[] arg){
        String jdbcURL = "jdbc:postgresql://localhost:5432/sanka";
        String password = "root";
        String Username = "postgres";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL , Username, password);
            System.out.println("Connection succeed ");

            String sql = "select * from client";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
//            String sql = "INSERT INTO client (idClient, nomClient, nationality, phone, status)"
//                    + "VALUES (200545210, 'nyobedjob', 'cameroun', 690154812, true)";
//            Statement statement = connection.createStatement();
//            int rows = statement.executeUpdate(sql);
//            if (rows > 0){
//
//                System.out.println("un element ajouter");
//            }


        } catch (SQLException e) {
            System.out.println("Error in connection to postgre");
            e.printStackTrace();
        }
    }
}

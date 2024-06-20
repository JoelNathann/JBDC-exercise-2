package JDBCExercise;


import java.sql.*;

public class CreateConnection {

    Connection con;

    Statement st;
    ResultSet rs;

    public CreateConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PriestlyDB", "root", "Priestly@78");
            System.out.println("Connection Success!!!");

            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM Product;";
            rs = stmt.executeQuery(query);


            // ResultSet
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Price_per_unit: " + rs.getString("price_per_unit"));
                System.out.println("Active_for_sell: "+rs.getString("active_for_sell"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}




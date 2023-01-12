package products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductsDemo {
static Connection conn = null;
    static String url = "jdbc:sqlite:C:\\Users\\gk\\Downloads\\data.db";
    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) throws SQLException {

createConnection();
      //  System.out.println(conn.getMetaData());

    }
    public static void createConnection() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

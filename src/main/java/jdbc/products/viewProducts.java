package jdbc.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewProducts {
    public static void displayItems(Connection conn) throws SQLException {
        String sql = "select * from products;";
        PreparedStatement ps = conn.prepareStatement(sql);
        try (ResultSet rs = ps.executeQuery()) {
    String format = "| %-10s | %-20s | %-12s | %-15s |%n";

    System.out.println("----------------------------------------------------------------------");

    System.out.printf(format, "Product Id", "Name", "Price", "Stock Quantity");
    
    System.out.println("----------------------------------------------------------------------");

    // 3. Print the Rows
    while (rs.next()) {
        System.out.printf(format,
                rs.getInt("product_id"),
                rs.getString("name"),
                rs.getDouble("price"),
                rs.getInt("stock_quantity"));
    }
    System.out.println("----------------------------------------------------------------------");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

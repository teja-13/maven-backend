package jdbc.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class updateProducts {
    public static void updateProducts(Connection conn) throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the product id : ");
        int id = in.nextInt();
        PreparedStatement ps = conn
                .prepareStatement("SELECT EXISTS (SELECT 1 FROM products WHERE product_id = ?) as id_exists");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (rs.getInt("id_exists") == 1) {
                System.out.print("Enter new price : ");
                double price = in.nextDouble();
                System.out.print("Enter new stock quantity : ");
                int stock_quantity = in.nextInt();
                PreparedStatement update = conn
                        .prepareStatement("UPDATE products SET price=?,stock_quantity=? WHERE product_id=?");
                update.setDouble(1, price);
                update.setInt(2, stock_quantity);
                update.setInt(3, id);
                update.execute();
            } else {
                System.out.println("Enter valid product id");
                updateProducts(conn);
            }
        }
    }
}

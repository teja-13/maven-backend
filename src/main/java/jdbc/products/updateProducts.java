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
                .prepareStatement("SELECT EXISTS (SELECT 1 FROM PRODUCTS WHERE products_id = ?) as id_exists");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (rs.getInt("id_exists") == 1) {
                
            } else {
                System.out.println("Enter valid product id");
            }
        }
    }
}

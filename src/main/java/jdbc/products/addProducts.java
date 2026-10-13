package jdbc.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class addProducts {
    public static void addProducts(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO products (name,price,stock_quantity) values(?,?,?)");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Product Name : ");
        String s = in.nextLine();
        System.out.print("Enter Price : ");
        double price = in.nextDouble();
        System.out.print("Enter Stock Quantity : ");
        int quantity = in.nextInt();
        ps.setString(1, s);
        ps.setDouble(2, price);
        ps.setInt(3, quantity);
        ps.execute();
    }
}


package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import jdbc.products.addProducts;
import jdbc.products.updateProducts;
import jdbc.products.viewProducts;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/cse_ab";
        String username = "root";
        String password = "1903";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(url, username, password);
        Scanner in = new Scanner(System.in);
        System.out.println("1. View Products\n2. Add Product\n3. Update Product\n4. Delete Product\n5. Search Product\n6. Add to Cart\n7. View Cart\n8. Place Order\n9. View Order History\n10. Exit");
        
        System.out.print("Enter your choice : ");
        int ch = in.nextInt();
        while (ch >= 1 && ch <= 10) {
            switch (ch) {
                case 1:
                    viewProducts.displayItems(conn);
                    break;
                case 2:
                    addProducts.addProducts(conn);
                    break;
                case 3:
                    updateProducts.updateProducts(conn);
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                default:

                    break;
            }
        System.out.println("1. View Products\n2. Add Product\n3. Update Product\n4. Delete Product\n5. Search Product\n6. Add to Cart\n7. View Cart\n8. Place Order\n9. View Order History\n10. Exit");
        
        System.out.print("Enter your choice : ");
        ch = in.nextInt();
        }
        conn.close();
    }
}
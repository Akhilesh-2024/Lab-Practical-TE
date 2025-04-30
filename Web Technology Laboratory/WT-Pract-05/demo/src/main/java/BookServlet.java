import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BookServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ebookshop";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Root@123";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            
            out.println("<html><head><title>eBook Shop</title>");
            out.println("<style>");
            out.println("table { border-collapse: collapse; width: 80%; margin: 20px auto; }");
            out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            out.println("th { background-color: #4CAF50; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("h1 { text-align: center; color: #333; }");
            out.println("</style></head>");
            out.println("<body><h1>eBook Shop Inventory</h1>");
            out.println("<table>");
            out.println("<tr><th>Book ID</th><th>Title</th><th>Author</th><th>Price</th><th>Quantity</th></tr>");
            
            while (rs.next()) {
                int id = rs.getInt("book_id");
                String title = rs.getString("book_title");
                String author = rs.getString("book_author");
                double price = rs.getDouble("book_price");
                int qty = rs.getInt("quantity");
                
                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + title + "</td>");
                out.println("<td>" + author + "</td>");
                out.println("<td>$" + price + "</td>");
                out.println("<td>" + qty + "</td>");
                out.println("</tr>");
            }
            
            out.println("</table></body></html>");
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException e) {
            out.println("<p>Error: JDBC driver not found</p>");
            e.printStackTrace(out);
        } catch (SQLException e) {
            out.println("<p>Error: Database connection problem</p>");
            e.printStackTrace(out);
        }
    }
}
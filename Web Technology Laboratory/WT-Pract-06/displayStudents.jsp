<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .error {
            color: red;
            text-align: center;
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student Information</h1>
        
        <%
            // Database connection details
            String jdbcUrl = "jdbc:mysql://localhost:3306/student_db";
            String dbUser = "your_username";
            String dbPassword = "your_password";
            
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            
            try {
                // Load JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Establish connection
                conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
                
                // Execute query
                stmt = conn.createStatement();
                String sql = "SELECT * FROM students_info";
                rs = stmt.executeQuery(sql);
        %>
        
        <table>
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Class</th>
                <th>Division</th>
                <th>City</th>
            </tr>
            
            <%
                // Process result set
                while (rs.next()) {
                    int studId = rs.getInt("stud_id");
                    String studName = rs.getString("stud_name");
                    String studClass = rs.getString("class");
                    String division = rs.getString("division");
                    String city = rs.getString("city");
            %>
            
            <tr>
                <td><%= studId %></td>
                <td><%= studName %></td>
                <td><%= studClass %></td>
                <td><%= division %></td>
                <td><%= city %></td>
            </tr>
            
            <%
                }
            %>
        </table>
        
        <%
            } catch (ClassNotFoundException e) {
        %>
            <p class="error">Error: MySQL JDBC Driver not found!</p>
        <%
                e.printStackTrace();
            } catch (SQLException e) {
        %>
            <p class="error">Error: Database connection problem!</p>
        <%
                e.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        %>
    </div>
</body>
</html>
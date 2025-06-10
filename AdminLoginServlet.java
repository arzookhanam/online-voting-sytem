package com.voting;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM admin WHERE username=? AND password=?"
            );
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                RequestDispatcher rd = request.getRequestDispatcher("ResultServlet");
                rd.forward(request, response);
            } else {
                response.getWriter().println("Invalid admin login");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
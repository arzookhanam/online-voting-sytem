package com.voting;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int partyId = Integer.parseInt(request.getParameter("party"));

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                "UPDATE parties SET votes = votes + 1 WHERE id = ?"
            );
            stmt.setInt(1, partyId);
            stmt.executeUpdate();

          
            response.sendRedirect("thankyou.html"); 
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<h3>Error recording vote. Please try again.</h3>");
        }
    }
}
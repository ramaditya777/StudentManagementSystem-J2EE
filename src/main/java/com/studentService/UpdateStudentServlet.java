package com.studentService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentDAO.ConnectionManager;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from request parameters
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        // SQL query to update student in the database
        String sql = "UPDATE students SET name = ?, mobile = ?, email = ? WHERE id = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set parameters for the prepared statement
            statement.setString(1, name);
            statement.setString(2, mobile);
            statement.setString(3, email);
            statement.setInt(4, studentId);

            // Execute the query
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                // Student updated successfully
                response.sendRedirect("listStudents");
            } else {
                // Failed to update student
                response.getWriter().println("Failed to update student.");
            }
        } catch (SQLException e) {
            // Handle database connection errors
            e.printStackTrace();
            response.getWriter().println("Database connection error.");
        }
    }
}

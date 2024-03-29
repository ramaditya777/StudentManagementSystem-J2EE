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

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve student ID from request parameter
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        // SQL query to delete student from the database
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set student ID as parameter for the prepared statement
            statement.setInt(1, studentId);

            // Execute the query
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                // Student deleted successfully
                response.sendRedirect("listStudents");
            } else {
                // Failed to delete student
                response.getWriter().println("Failed to delete student.");
            }
        } catch (SQLException e) {
            // Handle database connection errors
            e.printStackTrace();
            response.getWriter().println("Database connection error.");
        }
    }
}

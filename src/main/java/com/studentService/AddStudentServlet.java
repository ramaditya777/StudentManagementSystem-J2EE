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

import com.studentDAO.ConnectionManager; // Assuming your ConnectionManager class is in com.studentDAO package

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from request parameters
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        // SQL query to insert student into database
        String sql = "INSERT INTO students (name, mobile, email) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            // Set parameters for the prepared statement
            statement.setString(1, name);
            statement.setString(2, mobile);
            statement.setString(3, email);

            // Execute the query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
               
             // Redirect to ListStudentsServlet to show all students
                response.sendRedirect(request.getContextPath() + "/listStudents");

            } else {
                // Failed to add student
                response.getWriter().println("Failed to add student.");
            }
        } catch (SQLException e) {
            // Handle database connection errors
            e.printStackTrace();
            response.getWriter().println("Database connection error.");
        }
    }
}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.studentService.Student" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management System</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>

    <h1>Student Management System</h1>
    <button id="addStudentBtn" class="btn" onclick="window.location.href = 'addstudent.jsp';">Add New Student</button>
    <table id="studentTable">
        <thead>
            <tr>
                <th>S.No.</th>
                <th>Name</th>
                <th>Mobile Number</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody id="studentList">
            <% 
                List<Student> studentList = (List<Student>) request.getAttribute("studentList");
                int serialNumber = 1;
                for (Student student : studentList) { 
            %>
                <tr>
                    <td><%= serialNumber++ %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getMobile() %></td>
                    <td><%= student.getEmail() %></td>
                    <td>
					    <div class="button-container">
					        <form action="update.jsp" method="post">
					            <input type="hidden" name="studentId" value="<%= student.getId() %>">
					            <button type="submit">Update</button>
					        </form>
					        
					        <form action="deleteStudent" method="post" onsubmit="return confirm('Are you sure you want to delete this student?');">
					            <input type="hidden" name="studentId" value="<%= student.getId() %>">
					            <button type="submit">Delete</button>
					        </form>
					    </div>
					</td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <!-- Include your JavaScript file here -->
    <script src="js/script.js"></script>
</body>
</html>

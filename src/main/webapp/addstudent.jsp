<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
    <link rel="stylesheet" href="css/addStudent.css">
</head>
<body>
    <h1>Add Student</h1>
    <div class="container">
        <h2>Enter Student Information</h2>
        <form id="addStudentForm" method="post" action="addStudent">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="mobile">Mobile Number:</label> <!-- Changed from "Age" to "Mobile Number" -->
            <input type="tel" id="mobile" name="mobile" required> <!-- Changed type to tel -->
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <button type="submit">Add Student</button>
        </form>
    </div>
</body>
</html>

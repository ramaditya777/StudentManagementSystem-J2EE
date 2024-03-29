<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
    <link rel="stylesheet" href="css/update.css">
</head>
<body>
    <h1>Update Student</h1>
    <!-- Form to update student information -->
    <form action="updateStudent" method="post">
        <!-- Retrieve student ID from request parameter -->
        <% int studentId = Integer.parseInt(request.getParameter("studentId")); %>
        <input type="hidden" name="studentId" value="<%= studentId %>">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="mobile">Mobile Number:</label>
        <input type="text" id="mobile" name="mobile" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <button type="submit">Update Student</button>
    </form>
</body>
</html>

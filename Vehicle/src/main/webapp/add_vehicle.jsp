<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Vehicle</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Vehicle Sale System</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="admin_dashboard.jsp">Dashboard</a></li>
            <li class="nav-item"><a class="nav-link" href="LogoutController">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <h2>Add Vehicle</h2>
    <form action="VehicleController" method="post">
        <input type="hidden" name="action" value="add">
        <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" name="name" required>
        </div>
        <div class="form-group">
            <label>Brand</label>
            <input type="text" class="form-control" name="brand" required>
        </div>
        <div class="form-group">
            <label>Model</label>
            <input type="text" class="form-control" name="model" required>
        </div>
        <div class="form-group">
            <label>Price</label>
            <input type="number" step="0.01" class="form-control" name="price" required>
        </div>
        <div class="form-group">
            <label>Color</label>
            <input type="text" class="form-control" name="color" required>
        </div>
        <div class="form-group">
            <label>Registration Number</label>
            <input type="text" class="form-control" name="registration_number" required>
        </div>
        <div class="form-group">
            <label>Description</label>
            <textarea class="form-control" name="description" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Add Vehicle</button>
    </form>
</div>
</body>
</html>

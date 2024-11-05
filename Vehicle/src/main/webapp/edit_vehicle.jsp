<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Vehicle</title>
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
    <h2>Edit Vehicle</h2>
    <form action="VehicleController" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${vehicle.id}">
        <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" name="name" value="${vehicle.name}" required>
        </div>
        <div class="form-group">
            <label>Brand</label>
            <input type="text" class="form-control" name="brand" value="${vehicle.brand}" required>
        </div>
        <div class="form-group">
            <label>Model</label>
            <input type="text" class="form-control" name="model" value="${vehicle.model}" required>
        </div>
        <div class="form-group">
            <label>Price</label>
            <input type="number" step="0.01" class="form-control" name="price" value="${vehicle.price}" required>
        </div>
        <div class="form-group">
            <label>Color</label>
            <input type="text" class="form-control" name="color" value="${vehicle.color}" required>
        </div>
        <div class="form-group">
            <label>Registration Number</label>
            <input type="text" class="form-control" name="registration_number" value="${vehicle.registrationNumber}" required>
        </div>
        <div class="form-group">
            <label>Description</label>
            <textarea class="form-control" name="description" rows="3">${vehicle.description}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Update Vehicle</button>
    </form>
</div>
</body>
</html>

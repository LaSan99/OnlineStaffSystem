<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Vehicle Sale System</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="LogoutController">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <h2>Vehicle List</h2>
    <a href="add_vehicle.jsp" class="btn btn-primary mb-2">Add Vehicle</a>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Price</th>
                <th>Color</th>
                <th>Registration Number</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="vehicle" items="${vehicles}">
                <tr>
                    <td>${vehicle.id}</td>
                    <td>${vehicle.name}</td>
                    <td>${vehicle.brand}</td>
                    <td>${vehicle.model}</td>
                    <td>${vehicle.price}</td>
                    <td>${vehicle.color}</td>
                    <td>${vehicle.registrationNumber}</td>
                    <td>${vehicle.description}</td>
                    <td>
                        <a href="VehicleController?action=edit&id=${vehicle.id}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="VehicleController?action=delete&id=${vehicle.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this vehicle?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

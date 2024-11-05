<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="model.User" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .vehicle-card {
            transition: transform 0.2s; /* Animation on hover */
        }
        .vehicle-card:hover {
            transform: scale(1.05); /* Slightly increase size on hover */
        }
    </style>
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
    <h2>Welcome, <c:out value="${sessionScope.loggedInUser.name}"/>!</h2> <!-- Display logged-in user's name -->
    <h3>Available Vehicles</h3>
    <div class="row">
        <c:forEach var="vehicle" items="${vehicles}">
            <div class="col-md-4 mb-4">
                <div class="card vehicle-card">
                    <div class="card-body">
                        <h5 class="card-title">${vehicle.name}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${vehicle.brand} - ${vehicle.model}</h6>
                        <p class="card-text">
                            <strong>Price:</strong> $${vehicle.price}<br>
                            <strong>Color:</strong> ${vehicle.color}<br>
                            <strong>Registration Number:</strong> ${vehicle.registrationNumber}<br>
                            <strong>Description:</strong> ${vehicle.description}
                        </p>
                       
                    </div>
                </div>
            </div>
        </c:forEach>
        <c:if test="${empty vehicles}">
            <div class="col-12">
                <div class="alert alert-warning" role="alert">
                    No vehicles available.
                </div>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>

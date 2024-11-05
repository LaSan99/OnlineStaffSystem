package controller;

import model.Vehicle;
import model.VehicleDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

 // Add this annotation if it's missing
public class VehicleController extends HttpServlet {
    private final VehicleDAO vehicleDAO = new VehicleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("viewAll".equals(action)) {
            viewAllVehicles(request, response); // New action to view all vehicles
        } else if ("viewAlladmin".equals(action)) {
            viewAdminDashboard(request, response); // Default to admin dashboard
        } else if ("edit".equals(action)) {
            editVehicle(request, response);
        } else if ("delete".equals(action)) {
            deleteVehicle(request, response);
        }
    }

    private void viewAllVehicles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles(); // Fetching all vehicles
        request.setAttribute("vehicles", vehicles);
        request.getRequestDispatcher("user_dashboard.jsp").forward(request, response); // Forward to a new JSP page
    }


    private void viewAdminDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        request.setAttribute("vehicles", vehicles);
        request.getRequestDispatcher("admin_dashboard.jsp").forward(request, response);
    }


    private void editVehicle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            Vehicle vehicle = vehicleDAO.getVehicleById(id);
            request.setAttribute("vehicle", vehicle);
            request.getRequestDispatcher("edit_vehicle.jsp").forward(request, response);
        } else {
            response.sendRedirect("VehicleController"); // Redirect if no ID provided
        }
    }

    private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            vehicleDAO.deleteVehicle(id);
        }
        response.sendRedirect("VehicleController");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Vehicle vehicle = new Vehicle();

        vehicle.setName(request.getParameter("name"));
        vehicle.setBrand(request.getParameter("brand"));
        vehicle.setModel(request.getParameter("model"));
        vehicle.setPrice(Double.parseDouble(request.getParameter("price")));
        vehicle.setColor(request.getParameter("color"));
        vehicle.setRegistrationNumber(request.getParameter("registration_number"));
        vehicle.setDescription(request.getParameter("description"));

        if ("add".equals(action)) {
            vehicleDAO.addVehicle(vehicle);
        } else if ("update".equals(action)) {
            vehicle.setId(Integer.parseInt(request.getParameter("id")));
            vehicleDAO.updateVehicle(vehicle);
        }
        response.sendRedirect("VehicleController");
    }
}

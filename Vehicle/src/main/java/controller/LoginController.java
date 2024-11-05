package controller;

import dao.UserDao;
import model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserDao userDao = new UserDao();
        User user = userDao.validateUser(email, password);
        
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            if ("admin".equals(user.getRole())) {
                response.sendRedirect("VehicleController?action=viewAlladmin");
            } else {
                response.sendRedirect("VehicleController?action=viewAll");
            }
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}

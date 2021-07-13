package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String email = request.getParameter("email");

        boolean noEmpties = !username.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty() && !email.isEmpty();
        boolean passwordsMatch = password.equals(confirmPassword);
        boolean actuallyAnEmail = email.contains("@");
        boolean userNotExists;
        try {
            DaoFactory.getUsersDao().findByUsername(username);
            userNotExists = false;
        } catch (Exception e) {
            userNotExists = true;
        }


        if (noEmpties && passwordsMatch && actuallyAnEmail && userNotExists) {
            User newUser = new User(username, email, password);
            DaoFactory.getUsersDao().insert(newUser);
            newUser = DaoFactory.getUsersDao().findByUsername(newUser.getUsername());
            HttpSession session = request.getSession();
            session.setAttribute("user", newUser);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/register");
        }
    }
}
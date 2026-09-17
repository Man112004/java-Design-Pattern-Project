package com.example.Session3.Task2;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login-task2")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("username");

        HttpSession session = request.getSession();

        session.setAttribute("username", username);

        String remember = request.getParameter("remember");

        if (remember != null) {

            Cookie cookie = new Cookie("username", username);

            cookie.setMaxAge(60);

            response.addCookie(cookie);
        }

        response.sendRedirect("welcome.jsp");
    }
}
package com.song;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadSong")
@MultipartConfig
public class SongUploadServlet extends HttpServlet {

    String url = "jdbc:mysql://localhost:3306/songdb";
    String user = "root";
    String password = "Man@2004";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        Part filePart = request.getPart("song");

        String fileName = filePart.getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("")
                + File.separator + "uploads";

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String filePath = uploadPath + File.separator + fileName;

        filePart.write(filePath);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, user, password);

            String sql = "INSERT INTO uploaded_songs " +
                    "(username, original_filename, file_path) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, fileName);
            ps.setString(3, filePath);

            ps.executeUpdate();

            ps.close();
            con.close();

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            out.println("<h2>Song uploaded successfully!</h2>");
            out.println("<p>Username: " + username + "</p>");
            out.println("<p>File: " + fileName + "</p>");
            out.println("<p>File path saved in database.</p>");

        } catch (Exception e) {

            e.printStackTrace();

            response.getWriter().println(
                    "Database Error: " + e.getMessage());
        }
    }
}
package com.song;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h2>Song uploaded successfully!</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>File: " + fileName + "</p>");
    }
}
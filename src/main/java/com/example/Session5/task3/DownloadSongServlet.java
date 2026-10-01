package com.song;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/downloadSong")
public class DownloadSongServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("filename");

        String uploadPath = getServletContext().getRealPath("")
                + File.separator + "uploads";

        File file = new File(uploadPath, fileName);

        if (!file.exists()) {

            response.getWriter().println("File not found.");
            return;
        }

        response.setContentType("audio/mpeg");

        response.setHeader(
                "Content-Disposition",
                "attachment; filename=\"" + fileName + "\"");

        FileInputStream inputStream = new FileInputStream(file);

        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[4096];

        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {

            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();
    }
}
package com.example.Session2;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.Session2.ProductDAO;
import com.example.Session2.Product;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    private ProductDAO dao = new ProductDAO();

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> products = dao.getAllProducts();

        request.setAttribute("products", products);

        request.getRequestDispatcher("product-list.jsp")
                .forward(request, response);
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(
                request.getParameter("price"));

        Product product = new Product();

        product.setName(name);
        product.setPrice(price);

        dao.addProduct(product);

        response.sendRedirect("products");
    }
}
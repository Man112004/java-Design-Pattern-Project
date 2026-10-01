package com.example.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.admin.model.Order;

@Controller
public class OrderController {

        @GetMapping("/orders")
        public String orders(Model model) {

                List<Order> orders = new ArrayList<>();

                orders.add(
                                new Order(101, "Samsung Mobile", "Delivered"));

                orders.add(
                                new Order(102, "Boat Headphones", "Shipped"));

                orders.add(
                                new Order(103, "HP Laptop", "Processing"));

                orders.add(
                                new Order(104, "Nike Shoes", "Delivered"));

                model.addAttribute("orders", orders);

                return "orders";
        }
}
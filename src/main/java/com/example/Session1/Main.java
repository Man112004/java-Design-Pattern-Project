package com.example.Session1;

class Product {

    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

interface ProductDAO {

    void addProduct(Product p);

    Product getProductById(int id);

    void deleteProduct(int id);
}

class ProductDAOImpl implements ProductDAO {

    public void addProduct(Product p) {
        System.out.println("Product added " + p.name);
    }

    public Product getProductById(int id) {
        System.out.println("Getting product with ID " + id);

        return new Product(id, "Mobile", 60000);
    }

    public void deleteProduct(int id) {
        System.out.println("Product deleted with ID " + id);
    }
}

public class Main {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAOImpl();

        Product p = new Product(101, "TV", 20000);

        dao.addProduct(p);

        Product product = dao.getProductById(101);

        System.out.println("Product " + product.name);
        System.out.println("Price " + product.price);

        dao.deleteProduct(101);
    }
}
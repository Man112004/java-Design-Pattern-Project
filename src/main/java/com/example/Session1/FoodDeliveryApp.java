package com.example.Session1;

interface Food {
    void order();
}

class Pizza implements Food {

    public void order() {
        System.out.println("Pizza ordered successfully");
    }
}

class Burger implements Food {

    public void order() {
        System.out.println("Burger ordered successfully");
    }
}

class Biryani implements Food {

    public void order() {
        System.out.println("Biryani ordered successfully");
    }
}

class FoodFactory {

    public static Food createFood(String type) {

        if (type.equals("Pizza")) {
            return new Pizza();
        } else if (type.equals("Burger")) {
            return new Burger();
        } else if (type.equals("Biryani")) {
            return new Biryani();
        }

        return null;
    }
}

public class FoodDeliveryApp {

    public static void main(String[] args) {

        Food f1 = FoodFactory.createFood("Pizza");
        f1.order();

        Food f2 = FoodFactory.createFood("Burger");
        f2.order();

        Food f3 = FoodFactory.createFood("Biryani");
        f3.order();
    }
}
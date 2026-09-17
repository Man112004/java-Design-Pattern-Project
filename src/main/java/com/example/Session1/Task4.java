package com.example.Session1;

class Movie {
    private String name;
    private String language;
    private double price;

    public Movie(String name, String language, double price) {
        this.name = name;
        this.language = language;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public double getPrice() {
        return price;
    }
}

class MovieView {

    public void displayMovie(Movie movie) {
        System.out.println("Movie Name " + movie.getName());
        System.out.println("Language " + movie.getLanguage());
        System.out.println("Ticket Price " + movie.getPrice());
    }
}

class MovieController {

    private Movie movie;
    private MovieView view;

    public MovieController(Movie movie, MovieView view) {
        this.movie = movie;
        this.view = view;
    }

    public void displayMovie() {
        view.displayMovie(movie);
    }
}

public class Task4 {

    public static void main(String[] args) {

        Movie movie = new Movie("Extra Ordinary Man", "Hindi", 300);

        MovieView view = new MovieView();

        MovieController controller = new MovieController(movie, view);

        controller.displayMovie();
    }
}

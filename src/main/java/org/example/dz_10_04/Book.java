package org.example.dz_10_04;

import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private String genre;
    private String year;
    private double price;
    public Book(){}

    public Book(int id, String title, String genre, String author, String year, double price) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public Book(String title, String genre, String author, String year, double price) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }


    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

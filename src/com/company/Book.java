package com.company;

public class Book {
    private String author;
    private String name;
    private int cost;
    private int year;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public Book() {
        setAuthor("Не определено");
        setName("Не определено");
        setCost(0);
        setYear(0);
    }

    public Book(String author, String name, int cost, int year) {
        setAuthor(author);
        setName(name);
        setCost(cost);
        setYear(year);
    }

    public Book(String author, int year) {
        this();
        setAuthor(author);
        setYear(year);
    }

    public static String toString(Book book) {
        return book.getAuthor() + " " + book.getName() + " " + book.getCost() + " " + book.getYear();
    }
}

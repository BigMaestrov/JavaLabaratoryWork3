package com.company;

public class ChildrenBook extends Book {
    private int minimalAge;

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public ChildrenBook(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public ChildrenBook() {
        super();
        setMinimalAge(0);
    }

    public ChildrenBook(String author, String name, int cost, int year, int minimalAge) {
        super(author, name, cost, year);
        setMinimalAge(minimalAge);
    }

    public ChildrenBook(String author, int year) {
        this();
        setAuthor(author);
        setYear(year);
    }

    public static String toString(ChildrenBook book){
        return book.getAuthor() + " " + book.getName() + " " + book.getCost() + " " + book.getYear() + " "+ book.getMinimalAge();
    }
}

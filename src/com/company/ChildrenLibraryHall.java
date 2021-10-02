package com.company;

public class ChildrenLibraryHall {
    private int numBook;
    private ChildrenBook[] childrenBooks;
    private String name;

    public int getNumBook() {
        return numBook;
    }

    public void setNumBook(int numBook) {
        this.numBook = numBook;
    }

    public ChildrenBook[] getChildrenBooks() {
        return childrenBooks;
    }

    public void setChildrenBooks(ChildrenBook[] childrenBooks) {
        this.childrenBooks = childrenBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildrenLibraryHall(String name, int numBook) {
        setName(name);
        setNumBook(numBook);
    }

    public ChildrenLibraryHall(String name, ChildrenBook[] childrenBooks) {
        setName(name);
        setChildrenBooks(childrenBooks);
    }

    public static void printBooks(ChildrenLibraryHall childrenLibraryHall) {
        for (int i = 0; i < childrenLibraryHall.getNumBook(); i++) {
            System.out.println(childrenLibraryHall.childrenBooks[i].getName()+" ");
        }
    }

    public static int getCostOfAllBooks(ChildrenLibraryHall childrenLibraryHall) {
        int cost = 0;
        for (int i = 0; i < childrenLibraryHall.getNumBook(); i++) {
            cost += childrenLibraryHall.childrenBooks[i].getCost();
        }
        return cost;
    }

    public ChildrenBook getBookByID(int number) {
        return this.childrenBooks[number];
    }

    public void redactBook(ChildrenBook book, int number) {
        this.childrenBooks[number] = book;
    }

    public void addBook(ChildrenBook book, int number) {
        if (number > this.getNumBook()) {
            ChildrenBook[] childBooks = new ChildrenBook[number];
            for (int i = 0; i < getNumBook(); i++) {
                childBooks[i] = childrenBooks[i];
            }
            childBooks[number] = book;
            setChildrenBooks(childBooks);
            setNumBook(number);
        }
        if (number <= this.getNumBook()) {
            redactBook(book, number);
        }
    }

    public void deleteBook(int number) {
        if (number <= this.getNumBook()) {
            this.childrenBooks[number] = null;
        }
    }

    public static ChildrenBook getBestBook(ChildrenBook[] books) {
        int max = 0;
        int indexMax = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i].getCost()>max) {
                max = books[i].getCost();
                indexMax = i;
            }
        }
        return books[indexMax];
    }
}

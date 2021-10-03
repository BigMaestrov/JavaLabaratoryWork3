package com.company;

public class ChildrenLibraryHall {
    private ChildrenBook[] childrenBooks;
    private String name;

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
        childrenBooks = new ChildrenBook[numBook];
    }

    public ChildrenLibraryHall(String name, ChildrenBook[] childrenBooks) {
        setName(name);
        setChildrenBooks(childrenBooks);
    }

    public void printBooks() {
        for (int i = 0; i < childrenBooks.length; i++) {
            System.out.print(childrenBooks[i].getName() + ", ");
        }
    }

    public static int getCostOfAllBooks(ChildrenLibraryHall childrenLibraryHall) {
        int cost = 0;
        for (int i = 0; i < childrenLibraryHall.childrenBooks.length; i++) {
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
        ChildrenBook[] childBooks = new ChildrenBook[childrenBooks.length + 1];
        if (number > 0) {
            if (number > childrenBooks.length) {
                number = childrenBooks.length;
            }
            for (int i = 0; i < number; i++) {
                childBooks[i] = childrenBooks[i];
            }
            childBooks[number]=book;
            for(int i = number; i < childrenBooks.length; i++){
                childBooks[i+1]=childrenBooks[i];
            }
            setChildrenBooks(childBooks);
        }
    }


    public void deleteBook(int number) {
        if (number <= childrenBooks.length) {
            ChildrenBook[] childBooks = new ChildrenBook[childrenBooks.length - 1];
            for (int i = 0; i < number; i++) {
                childBooks[i] = childrenBooks[i];
            }
            for (int i = number; i < childrenBooks.length - 1; i++) {
                childBooks[i] = childrenBooks[i + 1];
            }
            setChildrenBooks(childBooks);
        }
    }

    public ChildrenBook getBestBook() {
        int max = 0;
        int indexMax = 0;
        for (int i = 0; i < childrenBooks.length; i++) {
            if (childrenBooks[i].getCost() >= max) {
                max = childrenBooks[i].getCost();
                indexMax = i;
            }
        }
        return childrenBooks[indexMax];
    }
}

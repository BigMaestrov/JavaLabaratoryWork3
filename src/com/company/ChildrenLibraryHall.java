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

    public static void printBooks(ChildrenLibraryHall childrenLibraryHall) {
        for (int i = 0; i < childrenLibraryHall.childrenBooks.length; i++) {
            System.out.println(childrenLibraryHall.childrenBooks[i].getName() + " ");
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
        if (number > childrenBooks.length) {
            ChildrenBook[] childBooks = new ChildrenBook[childrenBooks.length + 1];
            for (int i = 0; i < childrenBooks.length; i++) {
                childBooks[i] = childrenBooks[i];
            }
            childBooks[childrenBooks.length + 1] = book;
            setChildrenBooks(childBooks);
        }
        if (number <= childrenBooks.length) {
            redactBook(book, number);
        }
    }

    public void deleteBook(int number) {
        if (number <= childrenBooks.length) {
            ChildrenBook[] childBooks = new ChildrenBook[childrenBooks.length - 1];
            for (int i = 0, j = 0; i < childrenBooks.length; i++) {
                if (j != number) {
                    childBooks[j] = childrenBooks[i];
                    j++;
                }
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
